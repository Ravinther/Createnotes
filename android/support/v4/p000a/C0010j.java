package android.support.v4.p000a;

import android.util.Log;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: android.support.v4.a.j */
final class C0010j extends FutureTask {
    final /* synthetic */ C0002g f37a;

    C0010j(C0002g c0002g, Callable callable) {
        this.f37a = c0002g;
        super(callable);
    }

    protected final void done() {
        try {
            C0002g.m22b(this.f37a, get());
        } catch (Throwable e) {
            Log.w("AsyncTask", e);
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occured while executing doInBackground()", e2.getCause());
        } catch (CancellationException e3) {
            C0002g.m22b(this.f37a, null);
        } catch (Throwable e4) {
            RuntimeException runtimeException = new RuntimeException("An error occured while executing doInBackground()", e4);
        }
    }
}
