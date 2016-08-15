package android.support.v4.app;

/* renamed from: android.support.v4.app.t */
final class C0035t implements Runnable {
    final /* synthetic */ int f209a;
    final /* synthetic */ int f210b;
    final /* synthetic */ C0033r f211c;

    C0035t(C0033r c0033r, int i) {
        this.f211c = c0033r;
        this.f209a = i;
        this.f210b = 1;
    }

    public final void run() {
        C0033r c0033r = this.f211c;
        FragmentActivity fragmentActivity = this.f211c.f197o;
        c0033r.m192a(this.f209a, this.f210b);
    }
}
