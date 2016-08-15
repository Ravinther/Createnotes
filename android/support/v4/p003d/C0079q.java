package android.support.v4.p003d;

import android.view.MotionEvent;

/* renamed from: android.support.v4.d.q */
final class C0079q {
    public static int m342a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m343b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m344c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m345d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }

    public static int m341a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }
}
