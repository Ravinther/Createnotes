package com.socialnmobile.colornote.activity;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* renamed from: com.socialnmobile.colornote.activity.v */
final class C0186v implements AnimationListener {
    final /* synthetic */ View f842a;
    final /* synthetic */ Main f843b;

    C0186v(Main main, View view) {
        this.f843b = main;
        this.f842a = view;
    }

    public final void onAnimationStart(Animation animation) {
    }

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationEnd(Animation animation) {
        this.f842a.setVisibility(8);
    }
}
