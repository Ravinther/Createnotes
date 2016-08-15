package com.socialnmobile.colornote.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class bc implements OnCancelListener {
    final /* synthetic */ Today f813a;

    bc(Today today) {
        this.f813a = today;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f813a.finish();
    }
}
