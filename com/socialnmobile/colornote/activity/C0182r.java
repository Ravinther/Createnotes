package com.socialnmobile.colornote.activity;

import android.view.animation.AnimationUtils;

/* renamed from: com.socialnmobile.colornote.activity.r */
final class C0182r implements Runnable {
    final /* synthetic */ Main f838a;

    C0182r(Main main) {
        this.f838a = main;
    }

    public final void run() {
        this.f838a.f651p.setVisibility(8);
        this.f838a.f651p.startAnimation(AnimationUtils.loadAnimation(this.f838a.getApplication(), 17432577));
    }
}
