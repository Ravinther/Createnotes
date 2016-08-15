package com.socialnmobile.colornote.dialog;

import android.view.inputmethod.InputMethodManager;

final class ac implements Runnable {
    final /* synthetic */ aa f1062a;

    ac(aa aaVar) {
        this.f1062a = aaVar;
    }

    public final void run() {
        ((InputMethodManager) this.f1062a.getContext().getSystemService("input_method")).hideSoftInputFromInputMethod(this.f1062a.f1056a.getApplicationWindowToken(), 1);
    }
}
