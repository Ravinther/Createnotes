package com.socialnmobile.colornote.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.text.TextUtils;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.data.NoteColumns.NotesColumns;
import com.socialnmobile.colornote.sync.SyncIndexColumns;
import com.socialnmobile.colornote.sync.SyncStateColumns;
import com.socialnmobile.util.p011b.C0211d;
import com.socialnmobile.util.p011b.C0473n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public final class aa implements NotesColumns, SyncIndexColumns, SyncStateColumns {
    public static final Object[] f920b;
    static final C0473n f921c;
    static final C0473n f922d;
    static final C0473n f923e;
    static final C0473n f924f;
    static final C0473n f925g;
    public static final C0473n f926h;
    public final C0231u f927a;

    public aa(C0231u c0231u) {
        this.f927a = c0231u;
    }

    public final long m909a(ContentValues contentValues) {
        return this.f927a.m1074f().m1083b("notes", NoteMajorColumns.TITLE, contentValues);
    }

    public final int m906a(ContentValues contentValues, C0473n c0473n) {
        if (c0473n == null) {
            c0473n = new C0473n();
        }
        return this.f927a.m1074f().m1075a("notes", contentValues, c0473n.f2273a, c0473n.f2274b);
    }

    public final int m907a(ContentValues contentValues, UUID uuid) {
        return m906a(contentValues, new C0473n("uuid=?", uuid));
    }

    public final Cursor m911a(String[] strArr, C0473n c0473n) {
        if (c0473n == null) {
            c0473n = new C0473n();
        }
        return this.f927a.m1073e().m1080a("notes", strArr, c0473n.f2273a, c0473n.f2274b, null);
    }

    public final ContentValues m916b(String[] strArr, C0473n c0473n) {
        Cursor a = m911a(strArr, c0473n);
        try {
            if (a.moveToFirst()) {
                ContentValues contentValues = new ContentValues();
                DatabaseUtils.cursorRowToContentValues(a, contentValues);
                return contentValues;
            }
            a.close();
            return null;
        } finally {
            a.close();
        }
    }

    public final ContentValues m910a(UUID uuid) {
        return m916b(new String[]{"_id", SyncStateColumns.DIRTY_STATE, SyncStateColumns.STAGED_STATE}, new C0473n("uuid=?", uuid.toString()));
    }

    static {
        f920b = new Object[0];
        f921c = new C0473n("dirty != 0", new String[0]);
        f922d = new C0473n("staged != 0", new String[0]);
        f923e = new C0473n("revision!=0 or active_state != 32", new String[0]);
        f924f = new C0473n("status NOT BETWEEN (16384) AND (32767)", new String[0]);
        C0473n c0473n = f921c;
        C0473n c0473n2 = f922d;
        f925g = C0473n.m2323a("OR", c0473n, c0473n2).m2324a(f923e).m2324a(f924f);
        f926h = new C0473n("staged!=0", new String[0]);
    }

    public final void m912a() {
        int i = 0;
        Cursor a = m911a(new String[]{"_id", SyncIndexColumns.UUID}, null);
        int columnIndexOrThrow = a.getColumnIndexOrThrow("_id");
        int columnIndexOrThrow2 = a.getColumnIndexOrThrow(SyncIndexColumns.UUID);
        C0211d abVar = new ab(this, a);
        ContentValues contentValues = new ContentValues();
        Iterator it = abVar.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) it.next();
            long j = cursor.getLong(columnIndexOrThrow);
            String string = cursor.getString(columnIndexOrThrow2);
            UUID uuid = null;
            if (string != null) {
                try {
                    uuid = UUID.fromString(string);
                } catch (Exception e) {
                    ColorNote.m651a("Note #" + j + " ahs invalid uuid: " + string + " / regenerating...");
                } catch (Throwable th) {
                    a.close();
                }
            }
            if (uuid != null) {
                ColorNote.m651a("Note #" + j + " has already uuid: " + uuid.toString());
            } else {
                int i2;
                uuid = UUID.randomUUID();
                contentValues.put(SyncIndexColumns.UUID, uuid.toString());
                if (m906a(contentValues, new C0473n("_id=?", Long.valueOf(j))) == 1) {
                    ColorNote.m651a("Note #" + j + " uuid: " + uuid.toString());
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                i = i2;
            }
        }
        a.close();
        ColorNote.m651a("# of uuid regenerated Note: " + i);
    }

    public final int m913b() {
        String str = "SELECT COUNT(_ID) FROM notes WHERE " + new C0473n("dirty!=0", new String[0]).f2273a;
        Cursor a = this.f927a.m1073e().m1079a(str, new String[0]);
        try {
            if (a.moveToFirst()) {
                int i = a.getInt(0);
                return i;
            }
            throw new RuntimeException("NoteWithSyncInfoTable.getDirtyNoteCount() failed: " + str);
        } finally {
            a.close();
        }
    }

    private Object m903a(Callable callable) {
        C0232v f = this.f927a.m1074f();
        f.f1027a.beginTransaction();
        try {
            Object call = callable.call();
            f.f1027a.setTransactionSuccessful();
            f.f1027a.endTransaction();
            return call;
        } catch (Throwable e) {
            throw new ExecutionException(e);
        } catch (Throwable th) {
            f.f1027a.endTransaction();
        }
    }

    public final int m905a(int i, Set set) {
        try {
            return ((Integer) m903a(new ac(this, i, set))).intValue();
        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    final int m914b(int i, Set set) {
        String str = "SELECT _id FROM notes WHERE " + f925g.f2273a + " ORDER BY modified_date, minor_modified_date LIMIT " + i;
        Iterable arrayList = new ArrayList();
        C0232v f = this.f927a.m1074f();
        Cursor a = f.m1079a(str, new String[0]);
        if (a != null) {
            try {
                int count = a.getCount();
                if (count <= i) {
                    i = count;
                }
                for (count = 0; count < i; count++) {
                    if (a.moveToPosition(count)) {
                        Long valueOf = Long.valueOf(a.getLong(0));
                        if (valueOf != null && (set == null || !set.contains(valueOf))) {
                            arrayList.add(valueOf.toString());
                        }
                    }
                }
                if (arrayList.size() == 0) {
                    return 0;
                }
                a.close();
            } finally {
                a.close();
            }
        }
        return f.m1077a("UPDATE notes SET " + TextUtils.join(", ", new String[]{"dirty=0", "staged=(staged|dirty)"}) + " WHERE " + new C0473n("_id IN (" + TextUtils.join(",", arrayList) + ")", new String[0]).f2273a, f920b);
    }

    public static C0473n m902a(long j) {
        return new C0473n("_id=?", Long.valueOf(j));
    }

    public static C0473n m904b(UUID uuid) {
        return new C0473n("uuid=\"" + uuid + "\"", new String[0]);
    }

    public final int m915b(ContentValues contentValues, C0473n c0473n) {
        contentValues.remove(SyncIndexColumns.UUID);
        contentValues.remove("_id");
        contentValues.put(SyncStateColumns.STAGED_STATE, Integer.valueOf(0));
        return m906a(contentValues, c0473n);
    }

    public final int m917c() {
        String[] strArr = new String[]{"revision=0", "dirty=1"};
        return this.f927a.m1074f().m1077a("UPDATE notes SET " + TextUtils.join(", ", strArr) + " WHERE " + new C0473n("revision > 0", new String[0]).f2273a, f920b);
    }

    public final int m908a(C0473n c0473n) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(SyncStateColumns.DIRTY_STATE, Integer.valueOf(1));
        return m906a(contentValues, c0473n);
    }
}
