package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.p000a.C0000d;
import android.support.v4.p000a.C0006f;
import android.support.v4.p002c.C0050c;
import android.support.v4.p002c.C0051d;
import android.support.v4.p002c.C0058m;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class ad implements C0006f {
    final int f117a;
    final Bundle f118b;
    ab f119c;
    C0000d f120d;
    boolean f121e;
    boolean f122f;
    Object f123g;
    boolean f124h;
    boolean f125i;
    boolean f126j;
    boolean f127k;
    boolean f128l;
    boolean f129m;
    ad f130n;
    final /* synthetic */ ac f131o;

    public ad(ac acVar, int i, Bundle bundle, ab abVar) {
        this.f131o = acVar;
        this.f117a = i;
        this.f118b = bundle;
        this.f119c = abVar;
    }

    final void m118a() {
        if (this.f125i && this.f126j) {
            this.f124h = true;
        } else if (!this.f124h) {
            this.f124h = true;
            if (ac.f109a) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            if (this.f120d == null && this.f119c != null) {
                this.f120d = this.f119c.a_(this.f118b);
            }
            if (this.f120d == null) {
                return;
            }
            if (!this.f120d.getClass().isMemberClass() || Modifier.isStatic(this.f120d.getClass().getModifiers())) {
                if (!this.f129m) {
                    C0000d c0000d = this.f120d;
                    int i = this.f117a;
                    if (c0000d.f1n != null) {
                        throw new IllegalStateException("There is already a listener registered");
                    }
                    c0000d.f1n = this;
                    c0000d.f0m = i;
                    this.f129m = true;
                }
                this.f120d.m7i();
                return;
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f120d);
        }
    }

    final void m121b() {
        if (ac.f109a) {
            Log.v("LoaderManager", "  Stopping: " + this);
        }
        this.f124h = false;
        if (!this.f125i && this.f120d != null && this.f129m) {
            this.f129m = false;
            this.f120d.m1a(this);
            this.f120d.m9k();
        }
    }

    final void m123c() {
        String str;
        ab abVar = null;
        Object obj = null;
        while (true) {
            if (ac.f109a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f128l = true;
            boolean z = this.f122f;
            this.f122f = obj;
            if (this.f119c != null && this.f120d != null && this.f121e && z) {
                if (ac.f109a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.f131o.f113e != null) {
                    String str2 = this.f131o.f113e.f97b.f203u;
                    this.f131o.f113e.f97b.f203u = "onLoaderReset";
                    str = str2;
                } else {
                    Object obj2 = abVar;
                }
                try {
                    this.f119c.m104a(this.f120d);
                } finally {
                    abVar = this.f131o.f113e;
                    if (abVar != null) {
                        abVar = this.f131o.f113e.f97b;
                        abVar.f203u = str;
                    }
                    break;
                }
            }
            this.f119c = abVar;
            this.f123g = abVar;
            this.f121e = obj;
            if (this.f120d != null) {
                if (this.f129m) {
                    this.f129m = obj;
                    this.f120d.m1a(this);
                }
                this.f120d.m10l();
            }
            if (this.f130n != null) {
                this = this.f130n;
            } else {
                return;
            }
        }
    }

    public final void m119a(C0000d c0000d, Object obj) {
        if (ac.f109a) {
            Log.v("LoaderManager", "onLoadComplete: " + this);
        }
        if (this.f128l) {
            if (ac.f109a) {
                Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
            }
        } else if (this.f131o.f110b.m261a(this.f117a) == this) {
            ad adVar = this.f130n;
            if (adVar != null) {
                if (ac.f109a) {
                    Log.v("LoaderManager", "  Switching to pending loader: " + adVar);
                }
                this.f130n = null;
                this.f131o.f110b.m262a(this.f117a, null);
                m123c();
                this.f131o.m109a(adVar);
                return;
            }
            if (!(this.f123g == obj && this.f121e)) {
                this.f123g = obj;
                this.f121e = true;
                if (this.f124h) {
                    m122b(c0000d, obj);
                }
            }
            adVar = (ad) this.f131o.f111c.m261a(this.f117a);
            if (!(adVar == null || adVar == this)) {
                adVar.f122f = false;
                adVar.m123c();
                C0058m c0058m = this.f131o.f111c;
                int a = C0050c.m254a(c0058m.f261c, c0058m.f263e, this.f117a);
                if (a >= 0 && c0058m.f262d[a] != C0058m.f259a) {
                    c0058m.f262d[a] = C0058m.f259a;
                    c0058m.f260b = true;
                }
            }
            if (this.f131o.f113e != null && !this.f131o.m111a()) {
                this.f131o.f113e.f97b.m207e();
            }
        } else if (ac.f109a) {
            Log.v("LoaderManager", "  Ignoring load complete -- not active");
        }
    }

    final void m122b(C0000d c0000d, Object obj) {
        String str;
        if (this.f119c != null) {
            if (this.f131o.f113e != null) {
                String str2 = this.f131o.f113e.f97b.f203u;
                this.f131o.f113e.f97b.f203u = "onLoadFinished";
                str = str2;
            } else {
                str = null;
            }
            try {
                if (ac.f109a) {
                    StringBuilder append = new StringBuilder("  onLoadFinished in ").append(c0000d).append(": ");
                    StringBuilder stringBuilder = new StringBuilder(64);
                    C0051d.m256a(obj, stringBuilder);
                    stringBuilder.append("}");
                    Log.v("LoaderManager", append.append(stringBuilder.toString()).toString());
                }
                this.f119c.m105a(c0000d, obj);
                this.f122f = true;
            } finally {
                if (this.f131o.f113e != null) {
                    this.f131o.f113e.f97b.f203u = str;
                }
            }
        }
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append("LoaderInfo{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" #");
        stringBuilder.append(this.f117a);
        stringBuilder.append(" : ");
        C0051d.m256a(this.f120d, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void m120a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        while (true) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f117a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f118b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f119c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f120d);
            if (this.f120d != null) {
                this.f120d.m2a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f121e || this.f122f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f121e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f122f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f123g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f124h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f127k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f128l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f125i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f126j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f129m);
            if (this.f130n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f130n);
                printWriter.println(":");
                this = this.f130n;
                str = str + "  ";
            } else {
                return;
            }
        }
    }
}
