package com.socialnmobile.colornote.fragment;

import android.view.inputmethod.InputMethodManager;

final class au implements Runnable {
    final /* synthetic */ ListEditor f1235a;

    au(ListEditor listEditor) {
        this.f1235a = listEditor;
    }

    public final void run() {
        if (this.f1235a.f48C != null) {
            ((InputMethodManager) this.f1235a.f48C.getSystemService("input_method")).restartInput(this.f1235a.ac.f2194c);
        }
    }
}
