package com.socialnmobile.colornote.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.socialnmobile.colornote.ColorNote;

/* renamed from: com.socialnmobile.colornote.dialog.y */
public final class C0260y implements OnClickListener {
    final /* synthetic */ Context f1092a;
    final /* synthetic */ SharedPreferences f1093b;

    public C0260y(Context context, SharedPreferences sharedPreferences) {
        this.f1092a = context;
        this.f1093b = sharedPreferences;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ColorNote.m647a(this.f1092a, "RATE", "SELECTION", "RESULT", "NO");
        Editor edit = this.f1093b.edit();
        edit.putLong("RATING_TIME", System.currentTimeMillis() + 5184000000L);
        edit.commit();
    }
}
