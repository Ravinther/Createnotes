package android.support.v4.app;

import android.view.View;

/* renamed from: android.support.v4.app.g */
final class C0023g implements C0022o {
    final /* synthetic */ C0015f f169a;

    C0023g(C0015f c0015f) {
        this.f169a = c0015f;
    }

    public final View m152a(int i) {
        if (this.f169a.f63R != null) {
            return this.f169a.f63R.findViewById(i);
        }
        throw new IllegalStateException("Fragment does not have a view");
    }
}
