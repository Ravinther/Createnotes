package com.socialnmobile.colornote.view;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.C0015f;
import android.support.v4.app.C0017z;
import android.support.v4.app.C0025i;
import android.support.v4.app.C0031p;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class ac extends af {
    private final C0031p f848a;
    public ArrayList f849b;
    public C0015f f850c;
    ad f851d;
    private C0017z f852f;
    private ArrayList f853g;

    public abstract C0015f m837a(int i);

    public ac(C0031p c0031p, ad adVar) {
        this.f852f = null;
        this.f853g = new ArrayList();
        this.f849b = new ArrayList();
        this.f850c = null;
        this.f848a = c0031p;
        this.f851d = adVar;
    }

    public final Object m838a(ViewGroup viewGroup, int i) {
        if (this.f849b.size() > i) {
            C0015f c0015f = (C0015f) this.f849b.get(i);
            if (c0015f != null) {
                return c0015f;
            }
        }
        if (this.f852f == null) {
            this.f852f = this.f848a.m158a();
        }
        C0015f a = m837a(i);
        if (this.f853g.size() > i) {
            C0025i c0025i = (C0025i) this.f853g.get(i);
            if (c0025i != null) {
                if (a.f75o >= 0) {
                    throw new IllegalStateException("Fragment already active");
                }
                Bundle bundle;
                if (c0025i == null || c0025i.f170a == null) {
                    bundle = null;
                } else {
                    bundle = c0025i.f170a;
                }
                a.f73m = bundle;
            }
        }
        while (this.f849b.size() <= i) {
            this.f849b.add(null);
        }
        a.m63b(false);
        this.f849b.set(i, a);
        this.f852f.m127a(viewGroup.getId(), a);
        return a;
    }

    public final void m841a(ViewGroup viewGroup, int i, Object obj) {
        C0015f c0015f = (C0015f) obj;
        if (this.f852f == null) {
            this.f852f = this.f848a.m158a();
        }
        while (this.f853g.size() <= i) {
            this.f853g.add(null);
        }
        this.f853g.set(i, this.f848a.m157a(c0015f));
        this.f849b.set(i, null);
        this.f852f.m129a(c0015f);
    }

    public final void m842a(Object obj) {
        C0015f c0015f = (C0015f) obj;
        if (c0015f != this.f850c) {
            if (this.f850c != null) {
                this.f850c.m63b(false);
            }
            this.f850c = c0015f;
            if (c0015f != null) {
                c0015f.m63b(true);
                this.f851d.m698b(c0015f);
            }
        }
    }

    public final void m839a() {
        if (this.f852f != null) {
            this.f852f.m133c();
            this.f852f = null;
            this.f848a.m162b();
        }
    }

    public final boolean m843a(View view, Object obj) {
        return ((C0015f) obj).f63R == view;
    }

    public final Parcelable m844b() {
        Bundle bundle = null;
        if (this.f853g.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new C0025i[this.f853g.size()];
            this.f853g.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.f849b.size(); i++) {
            C0015f c0015f = (C0015f) this.f849b.get(i);
            if (c0015f != null) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.f848a.m159a(parcelable, "f" + i, c0015f);
            }
        }
        return parcelable;
    }

    public final void m840a(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.f853g.clear();
            this.f849b.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.f853g.add((C0025i) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    C0015f a = this.f848a.m155a(bundle, str);
                    if (a != null) {
                        while (this.f849b.size() <= parseInt) {
                            this.f849b.add(null);
                        }
                        a.m63b(false);
                        this.f849b.set(parseInt, a);
                    } else {
                        Log.w("FragmentStatePagerAdapter", "Bad fragment at key " + str);
                    }
                }
            }
        }
    }
}
