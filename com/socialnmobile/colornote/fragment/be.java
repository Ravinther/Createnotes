package com.socialnmobile.colornote.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.fragment.ListEditor.EditDialogFragment;

final class be implements OnClickListener {
    final /* synthetic */ ListEditor f1250a;
    final /* synthetic */ EditDialogFragment f1251b;

    be(EditDialogFragment editDialogFragment, ListEditor listEditor) {
        this.f1251b = editDialogFragment;
        this.f1250a = listEditor;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        String t = this.f1251b.m1403t();
        ListEditor listEditor = this.f1250a;
        if (listEditor.as >= 0 && listEditor.as < listEditor.ap.size()) {
            listEditor.m1251a(new ai(listEditor, t));
        }
        if ("".equals(t)) {
            this.f1251b.aa = true;
        } else {
            this.f1251b.aa = false;
        }
        this.f1250a.at = true;
    }
}
