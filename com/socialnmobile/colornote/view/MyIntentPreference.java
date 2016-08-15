package com.socialnmobile.colornote.view;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class MyIntentPreference extends Preference {
    public int f1925a;

    public MyIntentPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public MyIntentPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MyIntentPreference(Context context) {
        super(context);
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131624092);
        if (this.f1925a != 0) {
            imageView.setImageResource(this.f1925a);
        }
    }
}
