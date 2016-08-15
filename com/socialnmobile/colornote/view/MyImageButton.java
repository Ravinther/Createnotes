package com.socialnmobile.colornote.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class MyImageButton extends ImageButton {
    public CopyOnWriteArrayList f1922a;
    int f1923b;
    boolean f1924c;

    public MyImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1922a = new CopyOnWriteArrayList();
    }

    public MyImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1922a = new CopyOnWriteArrayList();
    }

    public MyImageButton(Context context) {
        super(context);
        this.f1922a = new CopyOnWriteArrayList();
    }

    public void setBlockLayout(boolean z) {
        this.f1924c = z;
    }

    public void requestLayout() {
        if (!this.f1924c) {
            super.requestLayout();
        }
    }

    public void setTitle(int i) {
        this.f1923b = i;
        if (i == 0) {
            setOnLongClickListener(null);
        } else {
            setOnLongClickListener(new ae(this));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Iterator it = this.f1922a.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Iterator it = this.f1922a.iterator();
        while (it.hasNext()) {
            ((ab) it.next()).m1684a(this);
        }
    }

    public final void m2107a(ab abVar) {
        this.f1922a.remove(abVar);
    }
}
