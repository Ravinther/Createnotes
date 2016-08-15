package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.p000a.C0000d;
import android.support.v4.p002c.C0051d;
import android.support.v4.p002c.C0058m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;

final class ac extends aa {
    static boolean f109a;
    final C0058m f110b;
    final C0058m f111c;
    final String f112d;
    FragmentActivity f113e;
    boolean f114f;
    boolean f115g;
    boolean f116h;

    static {
        f109a = false;
    }

    ac(String str, FragmentActivity fragmentActivity, boolean z) {
        this.f110b = new C0058m();
        this.f111c = new C0058m();
        this.f112d = str;
        this.f113e = fragmentActivity;
        this.f114f = z;
    }

    private ad m106b(int i, Bundle bundle, ab abVar) {
        ad adVar = new ad(this, i, bundle, abVar);
        adVar.f120d = abVar.a_(bundle);
        return adVar;
    }

    private ad m107c(int i, Bundle bundle, ab abVar) {
        try {
            this.f116h = true;
            ad b = m106b(i, bundle, abVar);
            m109a(b);
            return b;
        } finally {
            this.f116h = false;
        }
    }

    final void m109a(ad adVar) {
        this.f110b.m262a(adVar.f117a, adVar);
        if (this.f114f) {
            adVar.m118a();
        }
    }

    public final C0000d m108a(int i, Bundle bundle, ab abVar) {
        if (this.f116h) {
            throw new IllegalStateException("Called while creating a loader");
        }
        ad adVar = (ad) this.f110b.m261a(i);
        if (f109a) {
            Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
        }
        if (adVar != null) {
            ad adVar2 = (ad) this.f111c.m261a(i);
            if (adVar2 != null) {
                if (adVar.f121e) {
                    if (f109a) {
                        Log.v("LoaderManager", "  Removing last inactive loader: " + adVar);
                    }
                    adVar2.f122f = false;
                    adVar2.m123c();
                } else if (adVar.f124h) {
                    if (adVar.f130n != null) {
                        if (f109a) {
                            Log.v("LoaderManager", "  Removing pending loader: " + adVar.f130n);
                        }
                        adVar.f130n.m123c();
                        adVar.f130n = null;
                    }
                    if (f109a) {
                        Log.v("LoaderManager", "  Enqueuing as new pending loader");
                    }
                    adVar.f130n = m106b(i, bundle, abVar);
                    return adVar.f130n.f120d;
                } else {
                    if (f109a) {
                        Log.v("LoaderManager", "  Current loader is stopped; replacing");
                    }
                    this.f110b.m262a(i, null);
                    adVar.m123c();
                }
            } else if (f109a) {
                Log.v("LoaderManager", "  Making last loader inactive: " + adVar);
            }
            adVar.f120d.f4q = true;
            this.f111c.m262a(i, adVar);
        }
        return m107c(i, bundle, abVar).f120d;
    }

    final void m112b() {
        if (f109a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f114f) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f114f = true;
        for (int a = this.f110b.m260a() - 1; a >= 0; a--) {
            ((ad) this.f110b.m265c(a)).m118a();
        }
    }

    final void m113c() {
        if (f109a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f114f) {
            for (int a = this.f110b.m260a() - 1; a >= 0; a--) {
                ((ad) this.f110b.m265c(a)).m121b();
            }
            this.f114f = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    final void m114d() {
        if (f109a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f114f) {
            this.f115g = true;
            this.f114f = false;
            for (int a = this.f110b.m260a() - 1; a >= 0; a--) {
                ad adVar = (ad) this.f110b.m265c(a);
                if (f109a) {
                    Log.v("LoaderManager", "  Retaining: " + adVar);
                }
                adVar.f125i = true;
                adVar.f126j = adVar.f124h;
                adVar.f124h = false;
                adVar.f119c = null;
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    final void m115e() {
        for (int a = this.f110b.m260a() - 1; a >= 0; a--) {
            ((ad) this.f110b.m265c(a)).f127k = true;
        }
    }

    final void m116f() {
        for (int a = this.f110b.m260a() - 1; a >= 0; a--) {
            ad adVar = (ad) this.f110b.m265c(a);
            if (adVar.f124h && adVar.f127k) {
                adVar.f127k = false;
                if (adVar.f121e) {
                    adVar.m122b(adVar.f120d, adVar.f123g);
                }
            }
        }
    }

    final void m117g() {
        int a;
        if (!this.f115g) {
            if (f109a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (a = this.f110b.m260a() - 1; a >= 0; a--) {
                ((ad) this.f110b.m265c(a)).m123c();
            }
            this.f110b.m264b();
        }
        if (f109a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (a = this.f111c.m260a() - 1; a >= 0; a--) {
            ((ad) this.f111c.m265c(a)).m123c();
        }
        this.f111c.m264b();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0051d.m256a(this.f113e, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void m110a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f110b.m260a() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f110b.m260a(); i2++) {
                ad adVar = (ad) this.f110b.m265c(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f110b.m263b(i2));
                printWriter.print(": ");
                printWriter.println(adVar.toString());
                adVar.m120a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f111c.m260a() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f111c.m260a()) {
                adVar = (ad) this.f111c.m265c(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f111c.m263b(i));
                printWriter.print(": ");
                printWriter.println(adVar.toString());
                adVar.m120a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public final boolean m111a() {
        int a = this.f110b.m260a();
        boolean z = false;
        for (int i = 0; i < a; i++) {
            int i2;
            ad adVar = (ad) this.f110b.m265c(i);
            if (!adVar.f124h || adVar.f122f) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
