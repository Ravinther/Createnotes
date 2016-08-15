package com.socialnmobile.colornote.fragment;

import android.text.Editable;
import android.text.TextWatcher;

final class cy implements TextWatcher {
    final /* synthetic */ TextEditor f1308a;

    cy(TextEditor textEditor) {
        this.f1308a = textEditor;
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f1308a.aF) {
            this.f1308a.ac.m2228a(this.f1308a.m1526Z());
        }
    }
}
