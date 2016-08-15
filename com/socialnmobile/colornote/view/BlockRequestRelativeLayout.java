package com.socialnmobile.colornote.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class BlockRequestRelativeLayout extends RelativeLayout {
    public BlockRequestRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public BlockRequestRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BlockRequestRelativeLayout(Context context) {
        super(context);
    }

    public boolean isLayoutRequested() {
        return true;
    }
}
