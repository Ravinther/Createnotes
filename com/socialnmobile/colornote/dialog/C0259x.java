package com.socialnmobile.colornote.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import com.socialnmobile.colornote.ColorNote;

/* renamed from: com.socialnmobile.colornote.dialog.x */
public final class C0259x implements OnClickListener {
    final /* synthetic */ Context f1090a;
    final /* synthetic */ SharedPreferences f1091b;

    public C0259x(Context context, SharedPreferences sharedPreferences) {
        this.f1090a = context;
        this.f1091b = sharedPreferences;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ColorNote.m647a(this.f1090a, "RATE", "SELECTION", "RESULT", "YES");
        Editor edit = this.f1091b.edit();
        edit.putLong("RATING_TIME", 1);
        edit.commit();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.f1090a.getPackageName()));
        intent.setFlags(524288);
        this.f1090a.startActivity(intent);
    }
}
