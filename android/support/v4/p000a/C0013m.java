package android.support.v4.p000a;

import android.os.Handler;
import android.os.Message;

/* renamed from: android.support.v4.a.m */
final class C0013m extends Handler {
    private C0013m() {
    }

    public final void handleMessage(Message message) {
        C0012l c0012l = (C0012l) message.obj;
        switch (message.what) {
            case 1:
                C0002g.m24c(c0012l.f39a, c0012l.f40b[0]);
            case 2:
                C0002g.m23c();
            default:
        }
    }
}
