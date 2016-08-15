package com.socialnmobile.colornote.fragment;

import android.text.Editable;
import android.text.TextWatcher;

final class dn implements TextWatcher {
    final /* synthetic */ TextEditor f1324a;

    dn(TextEditor textEditor) {
        this.f1324a = textEditor;
    }

    public final void afterTextChanged(Editable editable) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextEditor.m1530a(this.f1324a, charSequence);
    }
}
