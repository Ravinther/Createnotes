package com.socialnmobile.colornote.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.fragment.ListEditor.EditDialogFragment;

final class bd implements OnClickListener {
    final /* synthetic */ ListEditor f1248a;
    final /* synthetic */ EditDialogFragment f1249b;

    bd(EditDialogFragment editDialogFragment, ListEditor listEditor) {
        this.f1249b = editDialogFragment;
        this.f1248a = listEditor;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1249b.aa = true;
        ListEditor listEditor = this.f1248a;
        String t = this.f1249b.m1403t();
        if (listEditor.as >= 0 && listEditor.as < listEditor.ap.size()) {
            listEditor.m1251a(new ah(listEditor, t));
        }
        this.f1248a.at = true;
    }
}
