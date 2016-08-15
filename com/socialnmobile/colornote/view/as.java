package com.socialnmobile.colornote.view;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public final class as extends Drawable {
    Drawable f2040a;
    Paint f2041b;

    public as(Drawable drawable, float f) {
        this.f2040a = drawable;
        this.f2041b = new Paint();
        this.f2041b.setColor(1149798536);
        this.f2041b.setStrokeWidth(f);
    }

    public final void draw(Canvas canvas) {
        this.f2040a.draw(canvas);
        canvas.drawLine((float) getIntrinsicWidth(), 0.0f, 0.0f, (float) getIntrinsicHeight(), this.f2041b);
    }

    protected final void onBoundsChange(Rect rect) {
        this.f2040a.setBounds(rect);
    }

    public final int getIntrinsicWidth() {
        return this.f2040a.getIntrinsicWidth();
    }

    public final int getIntrinsicHeight() {
        return this.f2040a.getIntrinsicHeight();
    }

    public final int getOpacity() {
        return this.f2040a.getOpacity();
    }

    public final void setAlpha(int i) {
        this.f2040a.setAlpha(i);
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f2040a.setColorFilter(colorFilter);
    }
}
