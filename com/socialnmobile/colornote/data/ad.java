package com.socialnmobile.colornote.data;

import android.content.ContentUris;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.sync.SyncIndexColumns;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class ad implements SharedPreferences {
    private static final HashMap f933b;
    private static Handler f934c;
    C0226o f935a;
    private Context f936d;
    private String f937e;
    private Uri f938f;
    private String f939g;
    private long f940h;

    static {
        f933b = new HashMap();
    }

    public static void m925a(Handler handler) {
        f934c = handler;
    }

    public static void m924a() {
        f933b.clear();
    }

    public static SharedPreferences m920a(Context context, String str) {
        SharedPreferences sharedPreferences;
        synchronized (f933b) {
            sharedPreferences = (ad) f933b.get(str);
            if (sharedPreferences != null) {
            } else {
                if (sharedPreferences == null) {
                    sharedPreferences = new ad(context, str);
                    f933b.put(str, sharedPreferences);
                }
            }
        }
        return sharedPreferences;
    }

    private ad(Context context, String str) {
        Cursor a;
        this.f935a = new C0226o();
        this.f936d = context;
        this.f937e = str;
        Cursor a2 = C0229s.m1037a(context, str);
        if (a2.getCount() > 1) {
            a2.moveToNext();
            Uri withAppendedId = ContentUris.withAppendedId(C0228r.f997a, a2.getLong(a2.getColumnIndex("_id")));
            long j = a2.getLong(a2.getColumnIndex(SyncIndexColumns.REVISION));
            Uri uri = withAppendedId;
            while (a2.moveToNext()) {
                Uri withAppendedId2 = ContentUris.withAppendedId(C0228r.f997a, a2.getLong(a2.getColumnIndex("_id")));
                long j2 = a2.getLong(a2.getColumnIndex(SyncIndexColumns.REVISION));
                if (j < j2) {
                    C0229s.m1052d(context, withAppendedId2);
                } else {
                    C0229s.m1052d(context, uri);
                    j = j2;
                    uri = withAppendedId2;
                }
            }
            a2.close();
            a = C0229s.m1037a(context, str);
        } else {
            a = a2;
        }
        if (a.moveToFirst()) {
            this.f938f = ContentUris.withAppendedId(C0228r.f997a, a.getLong(a.getColumnIndex("_id")));
            this.f939g = a.getString(a.getColumnIndex(NoteMajorColumns.NOTE));
            this.f940h = a.getLong(a.getColumnIndex(SyncIndexColumns.REVISION));
            C0226o c0226o = this.f935a;
            try {
                c0226o.f988b = new JSONObject(this.f939g);
                c0226o.f987a = c0226o.f988b.getJSONObject("D");
            } catch (JSONException e) {
                c0226o.m1024a();
                ColorNote.m651a("Load MergeableNote JSON Parse Error" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            this.f938f = null;
            this.f939g = null;
            this.f940h = 0;
        }
        a.close();
    }

    public final boolean contains(String str) {
        boolean a;
        synchronized (this) {
            a = this.f935a.m1028a(str);
        }
        return a;
    }

    public final Editor edit() {
        return new ae(this);
    }

    public final Map getAll() {
        throw new RuntimeException("not support");
    }

    public final String getString(String str, String str2) {
        String str3;
        synchronized (this) {
            str3 = (String) this.f935a.m1029b(str);
            if (str3 == null) {
                str3 = str2;
            }
        }
        return str3;
    }

    public final Set getStringSet(String str, Set set) {
        Set set2;
        synchronized (this) {
            set2 = (Set) this.f935a.m1029b(str);
            if (set2 == null) {
                set2 = set;
            }
        }
        return set2;
    }

    public final int getInt(String str, int i) {
        synchronized (this) {
            Integer num = (Integer) this.f935a.m1029b(str);
            if (num != null) {
                i = num.intValue();
            }
        }
        return i;
    }

    public final long getLong(String str, long j) {
        synchronized (this) {
            Long l = (Long) this.f935a.m1029b(str);
            if (l != null) {
                j = l.longValue();
            }
        }
        return j;
    }

    public final float getFloat(String str, float f) {
        synchronized (this) {
            Float f2 = (Float) this.f935a.m1029b(str);
            if (f2 != null) {
                f = f2.floatValue();
            }
        }
        return f;
    }

    public final boolean getBoolean(String str, boolean z) {
        synchronized (this) {
            Boolean bool = (Boolean) this.f935a.m1029b(str);
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public final void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new RuntimeException("not supports");
    }

    public final void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        throw new RuntimeException("not supports");
    }
}
