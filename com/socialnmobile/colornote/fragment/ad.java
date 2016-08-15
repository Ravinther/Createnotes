package com.socialnmobile.colornote.fragment;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class ad implements OnEditorActionListener {
    final /* synthetic */ ListEditor f1209a;

    ad(ListEditor listEditor) {
        this.f1209a = listEditor;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 5) {
            return false;
        }
        this.f1209a.m1251a(new an(true.f1217a.f1216b, true));
        return true;
    }
}
