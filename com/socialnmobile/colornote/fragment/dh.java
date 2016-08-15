package com.socialnmobile.colornote.fragment;

import android.view.View;
import android.view.View.OnClickListener;

final class dh implements OnClickListener {
    final /* synthetic */ TextEditor f1318a;

    dh(TextEditor textEditor) {
        this.f1318a = textEditor;
    }

    public final void onClick(View view) {
        this.f1318a.at.requestFocus();
    }
}
