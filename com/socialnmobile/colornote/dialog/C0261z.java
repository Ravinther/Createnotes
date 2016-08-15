package com.socialnmobile.colornote.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.socialnmobile.colornote.ColorNote;

/* renamed from: com.socialnmobile.colornote.dialog.z */
public final class C0261z implements OnCancelListener {
    final /* synthetic */ Context f1094a;
    final /* synthetic */ SharedPreferences f1095b;

    public C0261z(Context context, SharedPreferences sharedPreferences) {
        this.f1094a = context;
        this.f1095b = sharedPreferences;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ColorNote.m647a(this.f1094a, "RATE", "SELECTION", "RESULT", "CANCEL");
        Editor edit = this.f1095b.edit();
        edit.putLong("RATING_TIME", System.currentTimeMillis() + 3456000000L);
        edit.commit();
    }
}
