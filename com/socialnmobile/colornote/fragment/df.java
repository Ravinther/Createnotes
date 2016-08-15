package com.socialnmobile.colornote.fragment;

import android.view.inputmethod.InputMethodManager;

final class df implements Runnable {
    final /* synthetic */ TextEditor f1316a;

    df(TextEditor textEditor) {
        this.f1316a = textEditor;
    }

    public final void run() {
        if (this.f1316a.f48C != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1316a.f48C.getSystemService("input_method");
            inputMethodManager.restartInput(this.f1316a.ac.f2194c);
            inputMethodManager.restartInput(this.f1316a.at);
        }
    }
}
