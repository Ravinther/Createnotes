package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p002c.C0046l;
import android.support.v4.p002c.C0051d;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;

/* renamed from: android.support.v4.app.f */
public class C0015f implements ComponentCallbacks, OnCreateContextMenuListener {
    private static final C0046l f45a;
    int f46A;
    public C0033r f47B;
    public FragmentActivity f48C;
    C0033r f49D;
    C0015f f50E;
    int f51F;
    int f52G;
    String f53H;
    boolean f54I;
    boolean f55J;
    boolean f56K;
    boolean f57L;
    boolean f58M;
    boolean f59N;
    boolean f60O;
    int f61P;
    ViewGroup f62Q;
    public View f63R;
    View f64S;
    boolean f65T;
    boolean f66U;
    ac f67V;
    boolean f68W;
    boolean f69X;
    int f70j;
    View f71k;
    int f72l;
    public Bundle f73m;
    SparseArray f74n;
    public int f75o;
    String f76p;
    public Bundle f77q;
    public C0015f f78r;
    int f79s;
    int f80t;
    boolean f81u;
    boolean f82v;
    public boolean f83w;
    boolean f84x;
    boolean f85y;
    boolean f86z;

    static {
        f45a = new C0046l();
    }

    public C0015f() {
        this.f70j = 0;
        this.f75o = -1;
        this.f79s = -1;
        this.f59N = true;
        this.f66U = true;
    }

    public static C0015f m42a(Context context, String str) {
        return C0015f.m43a(context, str, null);
    }

    public static C0015f m43a(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) f45a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f45a.put(str, cls);
            }
            C0015f c0015f = (C0015f) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(c0015f.getClass().getClassLoader());
                c0015f.f77q = bundle;
            }
            return c0015f;
        } catch (Exception e) {
            throw new C0024h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (Exception e2) {
            throw new C0024h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new C0024h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e22);
        }
    }

    static boolean m44b(Context context, String str) {
        try {
            Class cls = (Class) f45a.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                f45a.put(str, cls);
            }
            return C0015f.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    final void m52a(int i, C0015f c0015f) {
        this.f75o = i;
        if (c0015f != null) {
            this.f76p = c0015f.f76p + ":" + this.f75o;
        } else {
            this.f76p = "android:fragment:" + this.f75o;
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0051d.m256a(this, stringBuilder);
        if (this.f75o >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f75o);
        }
        if (this.f51F != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.f51F));
        }
        if (this.f53H != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f53H);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final void m71f(Bundle bundle) {
        if (this.f75o >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.f77q = bundle;
    }

    public final void m57a(C0015f c0015f) {
        this.f78r = c0015f;
        this.f80t = 0;
    }

    public final Resources m70f() {
        if (this.f48C != null) {
            return this.f48C.getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final CharSequence m72g() {
        return m70f().getText(2131230798);
    }

    public final String m50a(int i) {
        return m70f().getString(i);
    }

    public final boolean m74h() {
        return this.f48C != null && this.f81u;
    }

    public static void m45i() {
    }

    public final void m75j() {
        if (this.f50E != null) {
            throw new IllegalStateException("Can't retain fragements that are nested in other fragments");
        }
        this.f56K = true;
    }

    public final void m76k() {
        if (!this.f58M) {
            this.f58M = true;
            if (m74h() && !this.f54I) {
                this.f48C.a_();
            }
        }
    }

    public final void m63b(boolean z) {
        if (this.f59N != z) {
            this.f59N = z;
            if (this.f58M && m74h() && !this.f54I) {
                this.f48C.a_();
            }
        }
    }

    public final aa m77l() {
        if (this.f67V != null) {
            return this.f67V;
        }
        if (this.f48C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f69X = true;
        this.f67V = this.f48C.m97a(this.f76p, this.f68W, true);
        return this.f67V;
    }

    public final void m54a(Intent intent) {
        if (this.f48C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f48C.m98a(this, intent, -1);
    }

    public final void m55a(Intent intent, int i) {
        if (this.f48C == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.f48C.m98a(this, intent, i);
    }

    public void m51a(int i, int i2, Intent intent) {
    }

    public LayoutInflater m60b(Bundle bundle) {
        return this.f48C.getLayoutInflater();
    }

    public void m53a(Activity activity) {
        this.f60O = true;
    }

    public static Animation m46m() {
        return null;
    }

    public void m56a(Bundle bundle) {
        this.f60O = true;
    }

    public View m49a(LayoutInflater layoutInflater, Bundle bundle) {
        return null;
    }

    public static void m47n() {
    }

    public void m67d(Bundle bundle) {
        this.f60O = true;
    }

    public void m65c() {
        this.f60O = true;
        if (!this.f68W) {
            this.f68W = true;
            if (!this.f69X) {
                this.f69X = true;
                this.f67V = this.f48C.m97a(this.f76p, this.f68W, false);
            }
            if (this.f67V != null) {
                this.f67V.m112b();
            }
        }
    }

    public void m78o() {
        this.f60O = true;
    }

    public void m69e(Bundle bundle) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.f60O = true;
    }

    public void m79p() {
        this.f60O = true;
    }

    public void m66d() {
        this.f60O = true;
    }

    public void onLowMemory() {
        this.f60O = true;
    }

    public void m68e() {
        this.f60O = true;
    }

    public void m80q() {
        this.f60O = true;
        if (!this.f69X) {
            this.f69X = true;
            this.f67V = this.f48C.m97a(this.f76p, this.f68W, false);
        }
        if (this.f67V != null) {
            this.f67V.m117g();
        }
    }

    public void m62b() {
        this.f60O = true;
    }

    public void m58a(Menu menu) {
    }

    public static void m48r() {
    }

    public boolean m59a(MenuItem menuItem) {
        return false;
    }

    public boolean m64b(MenuItem menuItem) {
        return false;
    }

    final View m61b(LayoutInflater layoutInflater, Bundle bundle) {
        if (this.f49D != null) {
            this.f49D.f201s = false;
        }
        return m49a(layoutInflater, bundle);
    }

    final void m73g(Bundle bundle) {
        m69e(bundle);
        if (this.f49D != null) {
            Parcelable h = this.f49D.m211h();
            if (h != null) {
                bundle.putParcelable("android:support:fragments", h);
            }
        }
    }

    final void m81s() {
        if (this.f49D != null) {
            this.f49D.m202c(2);
        }
        if (this.f68W) {
            this.f68W = false;
            if (!this.f69X) {
                this.f69X = true;
                this.f67V = this.f48C.m97a(this.f76p, this.f68W, false);
            }
            if (this.f67V == null) {
                return;
            }
            if (this.f48C.f103h) {
                this.f67V.m114d();
            } else {
                this.f67V.m113c();
            }
        }
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        this.f48C.onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }
}
