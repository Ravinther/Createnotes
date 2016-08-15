package com.socialnmobile.colornote.dialog;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.socialnmobile.colornote.dialog.DialogFactory.DownloadColorDictDialogFragment;

/* renamed from: com.socialnmobile.colornote.dialog.g */
final class C0243g implements OnClickListener {
    final /* synthetic */ Intent f1072a;
    final /* synthetic */ DownloadColorDictDialogFragment f1073b;

    C0243g(DownloadColorDictDialogFragment downloadColorDictDialogFragment, Intent intent) {
        this.f1073b = downloadColorDictDialogFragment;
        this.f1072a = intent;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1073b.m54a(this.f1072a);
    }
}
