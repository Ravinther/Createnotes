package android.support.v4.p003d;

import android.view.MotionEvent;

/* renamed from: android.support.v4.d.n */
final class C0077n implements C0076p {
    C0077n() {
    }

    public final int m332a(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        return -1;
    }

    public final int m333b(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return 0;
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public final float m334c(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getX();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public final float m335d(MotionEvent motionEvent, int i) {
        if (i == 0) {
            return motionEvent.getY();
        }
        throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
    }

    public final int m331a(MotionEvent motionEvent) {
        return 1;
    }
}
