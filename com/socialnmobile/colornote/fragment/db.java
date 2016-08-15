package com.socialnmobile.colornote.fragment;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;

final class db implements OnKeyListener {
    final /* synthetic */ TextEditor f1312a;

    db(TextEditor textEditor) {
        this.f1312a = textEditor;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 66) {
            return false;
        }
        TextEditor.m1541j(this.f1312a);
        return true;
    }
}
