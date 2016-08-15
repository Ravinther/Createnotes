package android.support.v4.p003d;

import android.view.KeyEvent;

/* renamed from: android.support.v4.d.l */
final class C0074l {
    public static int m316a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m317a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m318b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
