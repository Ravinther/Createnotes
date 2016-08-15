package com.socialnmobile.colornote.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.view.animation.AnimationUtils;

final class aa implements OnCancelListener {
    final /* synthetic */ NoteWidgetConfigure f779a;

    aa(NoteWidgetConfigure noteWidgetConfigure) {
        this.f779a = noteWidgetConfigure;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f779a.f667p.setVisibility(0);
        this.f779a.f667p.startAnimation(AnimationUtils.loadAnimation(this.f779a, 17432576));
    }
}
