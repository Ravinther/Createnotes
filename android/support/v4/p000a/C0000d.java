package android.support.v4.p000a;

import android.content.Context;
import android.support.v4.p002c.C0051d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.a.d */
public class C0000d {
    public int f0m;
    public C0006f f1n;
    public Context f2o;
    boolean f3p;
    public boolean f4q;
    boolean f5r;
    boolean f6s;
    boolean f7t;

    public C0000d(Context context) {
        this.f3p = false;
        this.f4q = false;
        this.f5r = true;
        this.f6s = false;
        this.f7t = false;
        this.f2o = context.getApplicationContext();
    }

    public void m3b(Object obj) {
        if (this.f1n != null) {
            this.f1n.m40a(this, obj);
        }
    }

    public final void m1a(C0006f c0006f) {
        if (this.f1n == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f1n != c0006f) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f1n = null;
        }
    }

    public final void m7i() {
        this.f3p = true;
        this.f5r = false;
        this.f4q = false;
        m4f();
    }

    protected void m4f() {
    }

    public final void m8j() {
        m0a();
    }

    protected void m0a() {
    }

    public final void m9k() {
        this.f3p = false;
        m5g();
    }

    protected void m5g() {
    }

    public final void m10l() {
        m6h();
        this.f5r = true;
        this.f3p = false;
        this.f4q = false;
        this.f6s = false;
        this.f7t = false;
    }

    protected void m6h() {
    }

    public final void m11m() {
        if (this.f3p) {
            m0a();
        } else {
            this.f6s = true;
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0051d.m256a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f0m);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public void m2a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f0m);
        printWriter.print(" mListener=");
        printWriter.println(this.f1n);
        if (this.f3p || this.f6s || this.f7t) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f3p);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f6s);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f7t);
        }
        if (this.f4q || this.f5r) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f4q);
            printWriter.print(" mReset=");
            printWriter.println(this.f5r);
        }
    }
}
