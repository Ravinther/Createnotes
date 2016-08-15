package com.socialnmobile.colornote.view;

import android.content.ActivityNotFoundException;
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
import android.widget.TextView;
import android.widget.TextView.SavedState;
import android.widget.Toast;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.p006a.C0142a;

public class LinedTextView extends TextView {
    private Rect f1867a;
    private Paint f1868b;
    private int f1869c;
    private GestureDetector f1870d;
    private boolean f1871e;

    public LinedTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1871e = false;
        this.f1867a = new Rect();
        this.f1868b = new Paint();
        this.f1868b.setStyle(Style.STROKE);
        this.f1870d = new GestureDetector(context, new SimpleOnGestureListener());
        C0410a agVar = new ag();
        agVar.f2024b = this;
        C0142a.m656a(this, agVar);
    }

    public void setDoNotRestore(boolean z) {
        this.f1871e = z;
    }

    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.f1870d.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setColor(int i) {
        this.f1869c = i;
        this.f1868b.setColor(C0209d.m875a(getContext()).m1135d(i));
        setBackgroundColor(C0209d.m875a(getContext()).m1133b(i));
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        int lineCount = getLineCount();
        Rect rect = this.f1867a;
        Paint paint = this.f1868b;
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

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1870d.onTouchEvent(motionEvent);
        try {
            super.onTouchEvent(motionEvent);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getContext(), 2131230794, 0).show();
        } catch (NullPointerException e2) {
            Toast.makeText(getContext(), 2131230794, 0).show();
        }
        return true;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!this.f1871e) {
            super.onRestoreInstanceState(parcelable);
        } else if (parcelable instanceof SavedState) {
            super.onRestoreInstanceState(((SavedState) parcelable).getSuperState());
        } else {
            super.onRestoreInstanceState(parcelable);
        }
    }
}
