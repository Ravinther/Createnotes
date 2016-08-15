package com.socialnmobile.colornote.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import com.socialnmobile.colornote.C0313j;

/* renamed from: com.socialnmobile.colornote.activity.o */
final class C0179o implements OnClickListener {
    final /* synthetic */ View f832a;
    final /* synthetic */ Animation f833b;
    final /* synthetic */ Main f834c;

    C0179o(Main main, View view, Animation animation) {
        this.f834c = main;
        this.f832a = view;
        this.f833b = animation;
    }

    public final void onClick(View view) {
        C0313j.m1665c(this.f834c);
        this.f832a.startAnimation(this.f833b);
    }
}
