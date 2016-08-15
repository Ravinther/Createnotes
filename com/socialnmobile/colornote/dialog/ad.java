package com.socialnmobile.colornote.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ad implements OnClickListener {
    final /* synthetic */ aa f1063a;

    ad(aa aaVar) {
        this.f1063a = aaVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1063a.f1057b.m1126a(this.f1063a.f1056a.getText().toString().trim());
    }
}
