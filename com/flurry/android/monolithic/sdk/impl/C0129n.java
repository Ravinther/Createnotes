package com.flurry.android.monolithic.sdk.impl;

import android.content.Context;
import android.widget.VideoView;

/* renamed from: com.flurry.android.monolithic.sdk.impl.n */
public class C0129n extends VideoView {
    public C0129n(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
    }

    public void seekTo(int i) {
        if (i < getCurrentPosition()) {
            super.seekTo(i);
        }
    }
}
