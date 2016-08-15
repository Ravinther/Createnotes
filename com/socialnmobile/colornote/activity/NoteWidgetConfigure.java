package com.socialnmobile.colornote.activity;

import android.app.Dialog;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProviderInfo;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.C0015f;
import android.support.v4.app.C0017z;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.socialnmobile.colornote.data.C0223m;
import com.socialnmobile.colornote.data.C0236z;
import com.socialnmobile.colornote.fragment.ArchiveFragment;
import com.socialnmobile.colornote.menu.C0152l;
import com.socialnmobile.colornote.menu.C0326m;
import com.socialnmobile.colornote.menu.C0330r;
import com.socialnmobile.colornote.receiver.C0332a;
import com.socialnmobile.colornote.view.bv;

public class NoteWidgetConfigure extends ThemeFragmentActivity implements C0152l {
    C0015f f665n;
    Dialog f666o;
    View f667p;
    OnCancelListener f668q;
    private int f669r;
    private int f670s;

    public NoteWidgetConfigure() {
        this.f668q = new aa(this);
    }

    protected void onCreate(Bundle bundle) {
        int i = 2;
        super.onCreate(bundle);
        m682a(2, null);
        setContentView(2130903046);
        Bundle extras = getIntent().getExtras();
        this.f667p = findViewById(2131623959);
        if (extras != null) {
            this.f669r = extras.getInt("appWidgetId", 0);
            AppWidgetProviderInfo appWidgetInfo = AppWidgetManager.getInstance(this).getAppWidgetInfo(this.f669r);
            if (appWidgetInfo != null) {
                String className = appWidgetInfo.provider.getClassName();
                if ("com.socialnmobile.colornote.receiver.NoteWidget".equals(className)) {
                    i = 1;
                } else if (!"com.socialnmobile.colornote.receiver.NoteWidget2x2".equals(className)) {
                    throw new RuntimeException("Invalid Widget Name");
                }
                this.f670s = i;
            }
        }
        if (this.f669r == 0 || this.f670s == 0) {
            finish();
            return;
        }
        this.f665n = this.f97b.m154a(2131623937);
        if (this.f665n == null) {
            this.f665n = ArchiveFragment.m1324a();
            C0017z a = this.f97b.m158a();
            a.m132b(2131623937, this.f665n);
            a.m126a(0);
            a.m131b();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            m725a(ContentUris.parseId(Uri.parse(intent.getAction())));
        } else {
            this.f667p.setVisibility(0);
            this.f667p.startAnimation(AnimationUtils.loadAnimation(this, 17432576));
        }
        super.onActivityResult(i, i2, intent);
    }

    public final void m725a(long j) {
        if (j < 0) {
            Dialog a = C0330r.m1710a(this, new ab(this), null).m1679a(this);
            a.setOnCancelListener(this.f668q);
            this.f666o = a;
            a.show();
            this.f667p.setVisibility(4);
            this.f667p.startAnimation(AnimationUtils.loadAnimation(this, 17432577));
            return;
        }
        C0223m a2 = C0223m.m1021a(this);
        int i = this.f669r;
        int i2 = this.f670s;
        SQLiteDatabase writableDatabase = a2.f985a.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(i));
        contentValues.put("note_id", Long.valueOf(j));
        contentValues.put("widget_type", Integer.valueOf(i2));
        if (writableDatabase.insert("widget", null, contentValues) == -1) {
            writableDatabase.update("widget", contentValues, "_id = ?", new String[]{String.valueOf(i)});
        }
        C0236z c0236z = new C0236z();
        c0236z.f1031a = this.f669r;
        c0236z.f1032b = this.f670s;
        C0332a.m1731a((Context) this, new C0236z[]{c0236z});
        Intent intent = new Intent();
        intent.putExtra("appWidgetId", this.f669r);
        setResult(-1, intent);
        finish();
    }

    public final boolean m727a(C0015f c0015f) {
        return true;
    }

    public final bv m728b() {
        return null;
    }

    public final void m726a(C0326m c0326m) {
    }
}
