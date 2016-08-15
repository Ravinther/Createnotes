package com.socialnmobile.colornote.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.socialnmobile.colornote.data.C0212b;

final class dm implements OnClickListener {
    final /* synthetic */ TextEditor f1323a;

    dm(TextEditor textEditor) {
        this.f1323a = textEditor;
    }

    public final void onClick(View view) {
        C0212b.m939a(this.f1323a.f48C, false);
        this.f1323a.aB.setVisibility(8);
    }
}
