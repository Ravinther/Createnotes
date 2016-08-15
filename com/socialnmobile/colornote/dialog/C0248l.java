package com.socialnmobile.colornote.dialog;

import android.view.inputmethod.InputMethodManager;

/* renamed from: com.socialnmobile.colornote.dialog.l */
final class C0248l implements Runnable {
    final /* synthetic */ C0245i f1081a;

    C0248l(C0245i c0245i) {
        this.f1081a = c0245i;
    }

    public final void run() {
        ((InputMethodManager) this.f1081a.getContext().getSystemService("input_method")).hideSoftInputFromInputMethod(this.f1081a.f1076b.getApplicationWindowToken(), 1);
    }
}
