package com.socialnmobile.colornote.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;

/* renamed from: com.socialnmobile.colornote.activity.w */
final class C0187w implements OnClickListener {
    final /* synthetic */ View f844a;
    final /* synthetic */ Animation f845b;
    final /* synthetic */ Main f846c;

    C0187w(Main main, View view, Animation animation) {
        this.f846c = main;
        this.f844a = view;
        this.f845b = animation;
    }

    public final void onClick(View view) {
        this.f844a.startAnimation(this.f845b);
    }
}
