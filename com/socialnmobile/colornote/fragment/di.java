package com.socialnmobile.colornote.fragment;

import android.view.View;
import android.view.View.OnFocusChangeListener;

final class di implements OnFocusChangeListener {
    final /* synthetic */ TextEditor f1319a;

    di(TextEditor textEditor) {
        this.f1319a = textEditor;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.f1319a.aw.setVisibility(0);
            this.f1319a.aC = true;
            if (this.f1319a.aE <= this.f1319a.at.getText().length()) {
                this.f1319a.at.setSelection(this.f1319a.aD, this.f1319a.aE);
            }
            TextEditor.m1530a(this.f1319a, this.f1319a.av.getText().toString());
            return;
        }
        this.f1319a.aw.setVisibility(8);
        this.f1319a.aC = false;
    }
}
