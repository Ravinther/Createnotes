package com.socialnmobile.colornote.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class NoChildFocusRelativeLayout extends RelativeLayout {
    public NoChildFocusRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setDescendantFocusability(393216);
    }

    protected void dispatchSetPressed(boolean z) {
    }

    public void dispatchSetSelected(boolean z) {
    }
}
