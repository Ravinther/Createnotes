package com.socialnmobile.colornote.fragment;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.C0015f;
import android.support.v4.app.C0017z;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.data.NoteProvider;
import com.socialnmobile.colornote.p012f.C0268b;

public class EditorContainer extends C0015f {
    Cursor f1175a;
    Uri f1176b;
    String f1177c;
    Activity f1178d;
    public AbstractEditorViewer f1179e;

    public static EditorContainer m1392b(Intent intent) {
        EditorContainer editorContainer = new EditorContainer();
        Bundle bundle = new Bundle();
        bundle.putParcelable("INTENT", intent);
        editorContainer.m71f(bundle);
        return editorContainer;
    }

    public final void m1395a(Activity activity) {
        super.m53a(activity);
        this.f1178d = activity;
    }

    public final void m1396a(Bundle bundle) {
        Uri uri;
        int c;
        super.m56a(bundle);
        Intent intent = (Intent) this.f77q.getParcelable("INTENT");
        Uri uri2 = null;
        String action = intent.getAction();
        if (bundle != null) {
            String string = bundle.getString("uri");
            if (string != null) {
                uri2 = Uri.parse(string);
                this.f1176b = uri2;
            }
            uri = uri2;
        } else {
            String action2 = intent.getAction();
            Uri data = intent.getData();
            if ("android.intent.action.EDIT".equals(action2)) {
                this.f1176b = data;
            } else if ("android.intent.action.VIEW".equals(action2) && data != null && "content".equals(data.getScheme())) {
                this.f1176b = data;
                this.f1177c = intent.getStringExtra("EXTRA_VIEW_FROM");
            } else if ("android.intent.action.INSERT".equals(action2)) {
                if (NoteProvider.m877a(data) == 2) {
                    this.f1176b = data;
                } else {
                    String stringExtra = intent.getStringExtra("android.intent.extra.SUBJECT");
                    String stringExtra2 = intent.getStringExtra("android.intent.extra.TEXT");
                    if (stringExtra2 != null) {
                        c = C0268b.m1200c(stringExtra2);
                    } else {
                        c = intent.getIntExtra("socialnmobile.intent.extra.TYPE", 0);
                    }
                    int a = C0212b.m934a(this.f1178d, "pref_default_color", 3);
                    this.f1176b = C0229s.m1039a(this.f1178d, 0, c, intent.getIntExtra("socialnmobile.intent.extra.FOLDER", 0), intent.getIntExtra("socialnmobile.intent.extra.COLOR", a), stringExtra, stringExtra2);
                }
                if (intent.hasExtra("socialnmobile.intent.extra.REMINDER_DATE")) {
                    C0229s.m1048a(this.f1178d, this.f1176b, intent.getLongExtra("socialnmobile.intent.extra.REMINDER_DATE", 0), intent.getIntExtra("socialnmobile.intent.extra.REMINDER_TYPE", 16), 0, 0, true);
                }
            }
            uri = this.f1176b;
        }
        if (uri == null || !uri.getAuthority().equals("note.socialnmobile.provider.colornote")) {
            m1391a();
            return;
        }
        this.f1175a = this.f1178d.managedQuery(this.f1176b, null, null, null, null);
        Cursor cursor = this.f1175a;
        if (cursor == null) {
            m1391a();
        } else if (cursor.moveToFirst()) {
            int columnIndex = cursor.getColumnIndex(NoteMinorColumns.TYPE);
            c = cursor.getColumnIndex(NoteMinorColumns.NOTE_VERSION);
            int columnIndex2 = cursor.getColumnIndex(NoteMajorColumns.ENCRYPTION);
            if (columnIndex == -1) {
                m1391a();
                return;
            }
            Object obj;
            columnIndex = cursor.getInt(columnIndex);
            c = cursor.getInt(c);
            a = cursor.getInt(columnIndex2);
            if (columnIndex != 0 && columnIndex != 16 && columnIndex != 256) {
                obj = null;
            } else if (c > 0) {
                obj = null;
            } else if (a == 0 || a == 1 || a == 2) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj == null) {
                Toast.makeText(this.f48C, 2131230882, 1).show();
                m1394a(5000, null);
                return;
            }
            this.f1179e = (AbstractEditorViewer) this.f48C.f97b.m154a(2131623953);
            if (this.f1179e == null) {
                this.f1179e = AbstractEditorViewer.m1216a(columnIndex, action, uri, this.f1177c);
                if (this.f1179e == null) {
                    m1391a();
                    return;
                }
                this.f1179e.m57a((C0015f) this);
                C0017z a2 = this.f48C.f97b.m158a();
                a2.m132b(2131623953, this.f1179e);
                a2.m126a(0);
                a2.m131b();
            }
        } else {
            m1391a();
        }
    }

    public final View m1393a(LayoutInflater layoutInflater, Bundle bundle) {
        return null;
    }

    public final void m1397e(Bundle bundle) {
        super.m69e(bundle);
        if (this.f1176b != null) {
            bundle.putString("uri", this.f1176b.toString());
        }
    }

    private void m1391a() {
        Toast.makeText(this.f48C, 2131230795, 1).show();
        m1394a(0, null);
    }

    public final void m1394a(int i, Intent intent) {
        this.f48C.setResult(i, intent);
        this.f48C.finish();
    }
}
