package com.socialnmobile.colornote.fragment;

import android.content.Context;
import android.text.Layout;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.Toast;
import com.socialnmobile.colornote.data.C0210a;
import com.socialnmobile.colornote.view.LinedTextView;

final class dc extends SimpleOnGestureListener {
    final /* synthetic */ TextEditor f1313a;

    dc(TextEditor textEditor) {
        this.f1313a = textEditor;
    }

    public final boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.f1313a.m1233L()) {
            if (C0210a.m894a(this.f1313a.f48C, "DTAP_EDIT_COUNT") < 5) {
                Context context = this.f1313a.f48C;
                C0210a.m897a(context, "DTAP_EDIT_COUNT", C0210a.m894a(context, "DTAP_EDIT_COUNT") + 1);
            }
            LinedTextView k = this.f1313a.au;
            int x = ((int) motionEvent.getX()) - k.getTotalPaddingLeft();
            int y = ((int) motionEvent.getY()) - k.getTotalPaddingTop();
            if (x < 0) {
                x = 0;
            } else if (x >= k.getWidth() - k.getTotalPaddingRight()) {
                x = (k.getWidth() - k.getTotalPaddingRight()) - 1;
            }
            if (y < 0) {
                y = 0;
            } else if (y >= k.getHeight() - k.getTotalPaddingBottom()) {
                y = (k.getHeight() - k.getTotalPaddingBottom()) - 1;
            }
            x += k.getScrollX();
            y += k.getScrollY();
            Layout layout = k.getLayout();
            y = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
            if (y > this.f1313a.at.length()) {
                y = this.f1313a.at.length();
            }
            this.f1313a.at.setSelection(y);
            this.f1313a.m1255a(false, "TAP");
        }
        return true;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (!this.f1313a.m1233L() || !this.f1313a.f83w || C0210a.m894a(this.f1313a.f48C, "DTAP_EDIT_COUNT") >= 5) {
            return false;
        }
        if (this.f1313a.aH == null) {
            this.f1313a.aH = Toast.makeText(this.f1313a.f48C, 2131230788, 0);
        }
        this.f1313a.aH.show();
        return true;
    }
}
