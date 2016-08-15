package com.socialnmobile.colornote.fragment;

import android.text.Editable;
import android.text.TextWatcher;

final class cz implements TextWatcher {
    final /* synthetic */ TextEditor f1309a;

    cz(TextEditor textEditor) {
        this.f1309a = textEditor;
    }

    public final void afterTextChanged(Editable editable) {
        if (this.f1309a.aF && !this.f1309a.m1526Z().equals(this.f1309a.ac.m2229b())) {
            this.f1309a.aF = false;
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
