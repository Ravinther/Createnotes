package com.socialnmobile.colornote.dialog;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;

/* renamed from: com.socialnmobile.colornote.dialog.j */
final class C0246j implements OnClickListener {
    final /* synthetic */ C0245i f1079a;

    C0246j(C0245i c0245i) {
        this.f1079a = c0245i;
    }

    public final void onClick(View view) {
        if (this.f1079a.f1078d.m819a(this.f1079a.f1076b.getText().toString().trim())) {
            this.f1079a.dismiss();
            return;
        }
        this.f1079a.f1076b.startAnimation(AnimationUtils.loadAnimation(this.f1079a.getContext(), 2130968583));
        this.f1079a.f1076b.setText("");
    }
}
