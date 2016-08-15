package com.socialnmobile.colornote.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class EditorScrollView extends ScrollView {
    public EditorScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        return super.requestChildRectangleOnScreen(view, rect, true);
    }
}
