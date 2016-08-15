package com.socialnmobile.colornote.dialog;

import android.view.inputmethod.InputMethodManager;

final class ab implements Runnable {
    final /* synthetic */ aa f1061a;

    ab(aa aaVar) {
        this.f1061a = aaVar;
    }

    public final void run() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f1061a.getContext().getSystemService("input_method");
        inputMethodManager.showSoftInput(this.f1061a.f1056a, 0);
        inputMethodManager.showSoftInputFromInputMethod(this.f1061a.f1056a.getApplicationWindowToken(), 0);
    }
}
