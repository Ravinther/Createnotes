package android.support.v4.p003d;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* renamed from: android.support.v4.d.m */
public final class C0075m {
    static final C0076p f271a;

    static {
        if (VERSION.SDK_INT >= 5) {
            f271a = new C0078o();
        } else {
            f271a = new C0077n();
        }
    }

    public static int m319a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m321b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m320a(MotionEvent motionEvent, int i) {
        return f271a.m327a(motionEvent, i);
    }

    public static int m322b(MotionEvent motionEvent, int i) {
        return f271a.m328b(motionEvent, i);
    }

    public static float m323c(MotionEvent motionEvent, int i) {
        return f271a.m329c(motionEvent, i);
    }

    public static float m325d(MotionEvent motionEvent, int i) {
        return f271a.m330d(motionEvent, i);
    }

    public static int m324c(MotionEvent motionEvent) {
        return f271a.m326a(motionEvent);
    }
}
