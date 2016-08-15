package com.socialnmobile.colornote.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.TextView.SavedState;
import com.socialnmobile.colornote.C0209d;

public class LinedEditText extends MyEditText {
    public int f1856a;
    public int f1857b;
    Runnable f1858c;
    private Rect f1859d;
    private Paint f1860e;
    private int f1861f;
    private String f1862g;
    private boolean f1863h;
    private C0280w f1864i;
    private GestureDetector f1865j;
    private boolean f1866k;

    public LinedEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1856a = 0;
        this.f1857b = 0;
        this.f1863h = false;
        this.f1866k = false;
        this.f1858c = new C0428u(this);
        this.f1859d = new Rect();
        this.f1860e = new Paint();
        this.f1860e.setStyle(Style.STROKE);
        this.f1862g = "";
        setMovementMethod(new C0429v(this));
        this.f1865j = new GestureDetector(context, new SimpleOnGestureListener());
    }

    public void setDoNotRestore(boolean z) {
        this.f1866k = z;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.f1865j.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setColor(int i) {
        this.f1861f = i;
        this.f1860e.setColor(C0209d.m875a(getContext()).m1135d(i));
        setBackgroundColor(C0209d.m875a(getContext()).m1133b(i));
    }

    public void setOnWordChangedListener(C0280w c0280w) {
        this.f1864i = c0280w;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1865j.onTouchEvent(motionEvent)) {
            return false;
        }
        super.onTouchEvent(motionEvent);
        return true;
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        int lineCount = getLineCount();
        Rect rect = this.f1859d;
        Paint paint = this.f1860e;
        int i2 = 0;
        while (i2 < lineCount) {
            int lineBounds = getLineBounds(i2, rect);
            canvas.drawLine((float) rect.left, (float) (lineBounds + 1), (float) rect.right, (float) (lineBounds + 1), paint);
            i2++;
            i = lineBounds;
        }
        while (i < getHeight()) {
            i2 = i + getLineHeight();
            canvas.drawLine((float) rect.left, (float) (i2 + 1), (float) rect.right, (float) (i2 + 1), paint);
            i = i2;
        }
        super.onDraw(canvas);
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (i2 > 0) {
            requestLayout();
        }
    }

    public final String m2080a(CharSequence charSequence, int i, boolean z) {
        int length = charSequence.length();
        if (this.f1864i == null) {
            return "";
        }
        if (i < 0) {
            return "";
        }
        String str;
        int i2;
        String str2;
        if (charSequence.length() == 0 || i >= length || !Character.isLetterOrDigit(charSequence.charAt(i))) {
            str = "";
            i2 = i;
            length = i;
        } else {
            int i3 = i;
            while (i3 >= 0) {
                if (!Character.isLetterOrDigit(Character.valueOf(charSequence.charAt(i3)).charValue())) {
                    i2 = i3 + 1;
                    break;
                }
                i3--;
            }
            i2 = i;
            if (i3 < 0) {
                i2 = 0;
            }
            int i4 = i;
            while (i4 < length) {
                if (!Character.isLetterOrDigit(Character.valueOf(charSequence.charAt(i4)).charValue())) {
                    i3 = i4;
                    break;
                }
                i4++;
            }
            i3 = i;
            if (i4 < length) {
                length = i3;
            }
            str = charSequence.subSequence(i2, length).toString();
            int i5;
            if (str == null) {
                str = "";
                i5 = length;
                length = i2;
                i2 = i5;
            } else {
                i5 = length;
                length = i2;
                i2 = i5;
            }
        }
        if (length > i2) {
            str2 = "";
            i2 = i;
        } else {
            i = i2;
            i2 = length;
            str2 = str;
        }
        if (!(this.f1862g.equals(str2) && this.f1856a == i2)) {
            this.f1862g = str2;
            this.f1856a = i2;
            this.f1857b = i;
            this.f1863h = z;
            if (getHandler() != null) {
                getHandler().removeCallbacks(this.f1858c);
                getHandler().postDelayed(this.f1858c, 100);
            }
        }
        return this.f1862g;
    }

    protected void onSelectionChanged(int i, int i2) {
        super.onSelectionChanged(i, i2);
        if (i == i2) {
            m2080a(getText(), i, false);
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m2080a(charSequence, i, true);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!this.f1866k) {
            super.onRestoreInstanceState(parcelable);
        } else if (parcelable instanceof SavedState) {
            super.onRestoreInstanceState(((SavedState) parcelable).getSuperState());
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }
}
