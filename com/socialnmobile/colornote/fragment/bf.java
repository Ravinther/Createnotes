package com.socialnmobile.colornote.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.fragment.ListEditor.EditDialogFragment;

final class bf implements OnClickListener {
    final /* synthetic */ ListEditor f1252a;
    final /* synthetic */ EditDialogFragment f1253b;

    bf(EditDialogFragment editDialogFragment, ListEditor listEditor) {
        this.f1253b = editDialogFragment;
        this.f1252a = listEditor;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1253b.aa = true;
        this.f1252a.m1437a(this.f1252a.ap);
        this.f1252a.at = true;
    }
}
