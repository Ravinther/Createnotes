package com.socialnmobile.colornote.dialog;

import android.view.inputmethod.InputMethodManager;

/* renamed from: com.socialnmobile.colornote.dialog.k */
final class C0247k implements Runnable {
    final /* synthetic */ C0245i f1080a;

    C0247k(C0245i c0245i) {
        this.f1080a = c0245i;
    }

    public final void run() {
        InputMethodManager inputMethodManager = (InputMethodManager) this.f1080a.getContext().getSystemService("input_method");
        inputMethodManager.showSoftInput(this.f1080a.f1076b, 0);
        inputMethodManager.showSoftInputFromInputMethod(this.f1080a.f1076b.getApplicationWindowToken(), 0);
    }
}
