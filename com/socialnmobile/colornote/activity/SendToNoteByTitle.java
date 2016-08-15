package com.socialnmobile.colornote.activity;

import android.app.Dialog;
import android.content.ContentUris;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.menu.C0330r;

public class SendToNoteByTitle extends ThemeActivity {
    String f724a;
    OnCancelListener f725b;

    public SendToNoteByTitle() {
        this.f725b = new ao(this);
    }

    protected void onCreate(Bundle bundle) {
        long j;
        super.onCreate(bundle);
        m753a();
        Uri data = getIntent().getData();
        boolean startsWith = data.getPath().startsWith("/tempnotes");
        Cursor query = getContentResolver().query(data, null, null, null, null);
        if (query == null || !query.moveToFirst()) {
            j = 0;
        } else {
            j = query.getLong(query.getColumnIndex("_id"));
        }
        if (query != null) {
            query.close();
        }
        if (j != 0) {
            Uri withAppendedId;
            if (startsWith) {
                withAppendedId = ContentUris.withAppendedId(C0228r.f1000d, j);
            } else {
                withAppendedId = ContentUris.withAppendedId(C0228r.f997a, j);
            }
            Intent intent = new Intent("android.intent.action.VIEW", withAppendedId);
            intent.putExtra("EXTRA_VIEW_FROM", "NOTE");
            startActivity(intent);
            finish();
        } else if (startsWith || data.getPathSegments().size() < 3) {
            Toast.makeText(this, 2131230798, 1).show();
            finish();
        } else {
            this.f724a = (String) data.getPathSegments().get(2);
            Dialog a = C0330r.m1710a(this, new an(this), null).m1679a(this);
            a.setOnCancelListener(this.f725b);
            a.show();
        }
    }

    static /* synthetic */ void m754a(SendToNoteByTitle sendToNoteByTitle, int i, String str) {
        Intent intent = new Intent("android.intent.action.INSERT", C0228r.f997a);
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("socialnmobile.intent.extra.TYPE", i);
        intent.putExtra("socialnmobile.intent.extra.FOLDER", 0);
        intent.putExtra("EXTRA_VIEW_FROM", "NOTE");
        sendToNoteByTitle.startActivity(intent);
    }
}
