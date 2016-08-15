package android.support.v4.app;

import android.support.v4.p002c.C0052e;
import android.util.Log;
import java.io.PrintWriter;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.b */
final class C0018b extends C0017z implements Runnable {
    final C0033r f132a;
    C0019c f133b;
    C0019c f134c;
    int f135d;
    int f136e;
    int f137f;
    int f138g;
    int f139h;
    int f140i;
    int f141j;
    boolean f142k;
    boolean f143l;
    String f144m;
    boolean f145n;
    int f146o;
    int f147p;
    CharSequence f148q;
    int f149r;
    CharSequence f150s;

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f146o >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f146o);
        }
        if (this.f144m != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f144m);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void m143a(String str, PrintWriter printWriter) {
        m144a(str, printWriter, true);
    }

    public final void m144a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f144m);
            printWriter.print(" mIndex=");
            printWriter.print(this.f146o);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f145n);
            if (this.f140i != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f140i));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f141j));
            }
            if (!(this.f136e == 0 && this.f137f == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f136e));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f137f));
            }
            if (!(this.f138g == 0 && this.f139h == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f138g));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f139h));
            }
            if (!(this.f147p == 0 && this.f148q == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f147p));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f148q);
            }
            if (!(this.f149r == 0 && this.f150s == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f149r));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f150s);
            }
        }
        if (this.f133b != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0019c c0019c = this.f133b;
            while (c0019c != null) {
                String str3;
                switch (c0019c.f153c) {
                    case 0:
                        str3 = "NULL";
                        break;
                    case 1:
                        str3 = "ADD";
                        break;
                    case 2:
                        str3 = "REPLACE";
                        break;
                    case 3:
                        str3 = "REMOVE";
                        break;
                    case 4:
                        str3 = "HIDE";
                        break;
                    case 5:
                        str3 = "SHOW";
                        break;
                    case 6:
                        str3 = "DETACH";
                        break;
                    case 7:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0019c.f153c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0019c.f154d);
                if (z) {
                    if (!(c0019c.f155e == 0 && c0019c.f156f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0019c.f155e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0019c.f156f));
                    }
                    if (!(c0019c.f157g == 0 && c0019c.f158h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0019c.f157g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0019c.f158h));
                    }
                }
                if (c0019c.f159i != null && c0019c.f159i.size() > 0) {
                    for (int i2 = 0; i2 < c0019c.f159i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0019c.f159i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0019c.f159i.get(i2));
                    }
                }
                c0019c = c0019c.f151a;
                i++;
            }
        }
    }

    public C0018b(C0033r c0033r) {
        this.f143l = true;
        this.f146o = -1;
        this.f132a = c0033r;
    }

    final void m142a(C0019c c0019c) {
        if (this.f133b == null) {
            this.f134c = c0019c;
            this.f133b = c0019c;
        } else {
            c0019c.f152b = this.f134c;
            this.f134c.f151a = c0019c;
            this.f134c = c0019c;
        }
        c0019c.f155e = this.f136e;
        c0019c.f156f = this.f137f;
        c0019c.f157g = this.f138g;
        c0019c.f158h = this.f139h;
        this.f135d++;
    }

    public final C0017z m141a(C0015f c0015f, String str) {
        m134a(0, c0015f, str, 1);
        return this;
    }

    public final C0017z m138a(int i, C0015f c0015f) {
        m134a(i, c0015f, null, 1);
        return this;
    }

    private void m134a(int i, C0015f c0015f, String str, int i2) {
        c0015f.f47B = this.f132a;
        if (str != null) {
            if (c0015f.f53H == null || str.equals(c0015f.f53H)) {
                c0015f.f53H = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + c0015f + ": was " + c0015f.f53H + " now " + str);
            }
        }
        if (i != 0) {
            if (c0015f.f51F == 0 || c0015f.f51F == i) {
                c0015f.f51F = i;
                c0015f.f52G = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + c0015f + ": was " + c0015f.f51F + " now " + i);
            }
        }
        C0019c c0019c = new C0019c();
        c0019c.f153c = i2;
        c0019c.f154d = c0015f;
        m142a(c0019c);
    }

    public final C0017z m147b(int i, C0015f c0015f) {
        return m139a(i, c0015f, null);
    }

    public final C0017z m139a(int i, C0015f c0015f, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m134a(i, c0015f, str, 2);
        return this;
    }

    public final C0017z m140a(C0015f c0015f) {
        C0019c c0019c = new C0019c();
        c0019c.f153c = 3;
        c0019c.f154d = c0015f;
        m142a(c0019c);
        return this;
    }

    public final C0017z m137a(int i) {
        this.f140i = i;
        return this;
    }

    public final C0017z m136a() {
        if (this.f143l) {
            this.f142k = true;
            this.f144m = null;
            return this;
        }
        throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
    }

    final void m148b(int i) {
        if (this.f142k) {
            if (C0033r.f182a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0019c c0019c = this.f133b; c0019c != null; c0019c = c0019c.f151a) {
                C0015f c0015f;
                if (c0019c.f154d != null) {
                    c0015f = c0019c.f154d;
                    c0015f.f46A += i;
                    if (C0033r.f182a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0019c.f154d + " to " + c0019c.f154d.f46A);
                    }
                }
                if (c0019c.f159i != null) {
                    for (int size = c0019c.f159i.size() - 1; size >= 0; size--) {
                        c0015f = (C0015f) c0019c.f159i.get(size);
                        c0015f.f46A += i;
                        if (C0033r.f182a) {
                            Log.v("FragmentManager", "Bump nesting of " + c0015f + " to " + c0015f.f46A);
                        }
                    }
                }
            }
        }
    }

    public final int m146b() {
        return m135b(false);
    }

    public final int m149c() {
        return m135b(true);
    }

    private int m135b(boolean z) {
        if (this.f145n) {
            throw new IllegalStateException("commit already called");
        }
        if (C0033r.f182a) {
            Log.v("FragmentManager", "Commit: " + this);
            m143a("  ", new PrintWriter(new C0052e("FragmentManager")));
        }
        this.f145n = true;
        if (this.f142k) {
            this.f146o = this.f132a.m175a(this);
        } else {
            this.f146o = -1;
        }
        this.f132a.m190a((Runnable) this, z);
        return this.f146o;
    }

    public final void run() {
        if (C0033r.f182a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f142k || this.f146o >= 0) {
            m148b(1);
            for (C0019c c0019c = this.f133b; c0019c != null; c0019c = c0019c.f151a) {
                C0015f c0015f;
                switch (c0019c.f153c) {
                    case 1:
                        c0015f = c0019c.f154d;
                        c0015f.f61P = c0019c.f155e;
                        this.f132a.m188a(c0015f, false);
                        break;
                    case 2:
                        C0015f c0015f2;
                        c0015f = c0019c.f154d;
                        if (this.f132a.f189g != null) {
                            c0015f2 = c0015f;
                            for (int i = 0; i < this.f132a.f189g.size(); i++) {
                                c0015f = (C0015f) this.f132a.f189g.get(i);
                                if (C0033r.f182a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + c0015f2 + " old=" + c0015f);
                                }
                                if (c0015f2 == null || c0015f.f52G == c0015f2.f52G) {
                                    if (c0015f == c0015f2) {
                                        c0015f2 = null;
                                        c0019c.f154d = null;
                                    } else {
                                        if (c0019c.f159i == null) {
                                            c0019c.f159i = new ArrayList();
                                        }
                                        c0019c.f159i.add(c0015f);
                                        c0015f.f61P = c0019c.f156f;
                                        if (this.f142k) {
                                            c0015f.f46A++;
                                            if (C0033r.f182a) {
                                                Log.v("FragmentManager", "Bump nesting of " + c0015f + " to " + c0015f.f46A);
                                            }
                                        }
                                        this.f132a.m186a(c0015f, this.f140i, this.f141j);
                                    }
                                }
                            }
                        } else {
                            c0015f2 = c0015f;
                        }
                        if (c0015f2 == null) {
                            break;
                        }
                        c0015f2.f61P = c0019c.f155e;
                        this.f132a.m188a(c0015f2, false);
                        break;
                    case 3:
                        c0015f = c0019c.f154d;
                        c0015f.f61P = c0019c.f156f;
                        this.f132a.m186a(c0015f, this.f140i, this.f141j);
                        break;
                    case 4:
                        c0015f = c0019c.f154d;
                        c0015f.f61P = c0019c.f156f;
                        this.f132a.m198b(c0015f, this.f140i, this.f141j);
                        break;
                    case 5:
                        c0015f = c0019c.f154d;
                        c0015f.f61P = c0019c.f155e;
                        this.f132a.m203c(c0015f, this.f140i, this.f141j);
                        break;
                    case 6:
                        c0015f = c0019c.f154d;
                        c0015f.f61P = c0019c.f156f;
                        this.f132a.m206d(c0015f, this.f140i, this.f141j);
                        break;
                    case 7:
                        c0015f = c0019c.f154d;
                        c0015f.f61P = c0019c.f155e;
                        this.f132a.m208e(c0015f, this.f140i, this.f141j);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0019c.f153c);
                }
            }
            this.f132a.m181a(this.f132a.f196n, this.f140i, this.f141j, true);
            if (this.f142k) {
                C0033r c0033r = this.f132a;
                if (c0033r.f191i == null) {
                    c0033r.f191i = new ArrayList();
                }
                c0033r.f191i.add(this);
                c0033r.m210g();
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public final void m145a(boolean z) {
        if (C0033r.f182a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m143a("  ", new PrintWriter(new C0052e("FragmentManager")));
        }
        m148b(-1);
        for (C0019c c0019c = this.f134c; c0019c != null; c0019c = c0019c.f152b) {
            C0015f c0015f;
            switch (c0019c.f153c) {
                case 1:
                    c0015f = c0019c.f154d;
                    c0015f.f61P = c0019c.f158h;
                    this.f132a.m186a(c0015f, C0033r.m172d(this.f140i), this.f141j);
                    break;
                case 2:
                    c0015f = c0019c.f154d;
                    if (c0015f != null) {
                        c0015f.f61P = c0019c.f158h;
                        this.f132a.m186a(c0015f, C0033r.m172d(this.f140i), this.f141j);
                    }
                    if (c0019c.f159i == null) {
                        break;
                    }
                    for (int i = 0; i < c0019c.f159i.size(); i++) {
                        c0015f = (C0015f) c0019c.f159i.get(i);
                        c0015f.f61P = c0019c.f157g;
                        this.f132a.m188a(c0015f, false);
                    }
                    break;
                case 3:
                    c0015f = c0019c.f154d;
                    c0015f.f61P = c0019c.f157g;
                    this.f132a.m188a(c0015f, false);
                    break;
                case 4:
                    c0015f = c0019c.f154d;
                    c0015f.f61P = c0019c.f157g;
                    this.f132a.m203c(c0015f, C0033r.m172d(this.f140i), this.f141j);
                    break;
                case 5:
                    c0015f = c0019c.f154d;
                    c0015f.f61P = c0019c.f158h;
                    this.f132a.m198b(c0015f, C0033r.m172d(this.f140i), this.f141j);
                    break;
                case 6:
                    c0015f = c0019c.f154d;
                    c0015f.f61P = c0019c.f157g;
                    this.f132a.m208e(c0015f, C0033r.m172d(this.f140i), this.f141j);
                    break;
                case 7:
                    c0015f = c0019c.f154d;
                    c0015f.f61P = c0019c.f157g;
                    this.f132a.m206d(c0015f, C0033r.m172d(this.f140i), this.f141j);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0019c.f153c);
            }
        }
        if (z) {
            this.f132a.m181a(this.f132a.f196n, C0033r.m172d(this.f140i), this.f141j, true);
        }
        if (this.f146o >= 0) {
            C0033r c0033r = this.f132a;
            int i2 = this.f146o;
            synchronized (c0033r) {
                c0033r.f193k.set(i2, null);
                if (c0033r.f194l == null) {
                    c0033r.f194l = new ArrayList();
                }
                if (C0033r.f182a) {
                    Log.v("FragmentManager", "Freeing back stack index " + i2);
                }
                c0033r.f194l.add(Integer.valueOf(i2));
            }
            this.f146o = -1;
        }
    }
}
