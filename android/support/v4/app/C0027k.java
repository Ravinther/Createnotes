package android.support.v4.app;

import android.os.Handler;
import android.os.Message;

/* renamed from: android.support.v4.app.k */
final class C0027k extends Handler {
    final /* synthetic */ FragmentActivity f171a;

    C0027k(FragmentActivity fragmentActivity) {
        this.f171a = fragmentActivity;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                if (this.f171a.f101f) {
                    this.f171a.m100a(false);
                }
            case 2:
                this.f171a.f97b.m215l();
                this.f171a.f97b.m209f();
            default:
                super.handleMessage(message);
        }
    }
}
