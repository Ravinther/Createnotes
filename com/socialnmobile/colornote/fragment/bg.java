package com.socialnmobile.colornote.fragment;

import android.view.inputmethod.InputMethodManager;
import com.socialnmobile.colornote.fragment.ListEditor.EditDialogFragment;

final class bg implements Runnable {
    final /* synthetic */ EditDialogFragment f1254a;

    bg(EditDialogFragment editDialogFragment) {
        this.f1254a = editDialogFragment;
    }

    public final void run() {
        if (this.f1254a.f48C != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1254a.f48C.getSystemService("input_method");
            inputMethodManager.showSoftInput(this.f1254a.f1181Z, 0);
            inputMethodManager.showSoftInputFromInputMethod(this.f1254a.f1181Z.getApplicationWindowToken(), 0);
        }
    }
}
