package com.socialnmobile.colornote.menu;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.socialnmobile.colornote.menu.m */
public final class C0326m {
    C0273k f1429a;
    C0316a f1430b;
    public ArrayList f1431c;
    public ArrayList f1432d;
    ArrayList f1433e;
    public String f1434f;
    public int f1435g;
    public OnClickListener f1436h;
    public OnClickListener f1437i;

    public C0326m(C0273k c0273k, int i) {
        this.f1436h = new C0327n(this);
        this.f1437i = new C0328o(this);
        this.f1429a = c0273k;
        this.f1435g = i;
        this.f1431c = new ArrayList();
        this.f1432d = new ArrayList();
        this.f1433e = new ArrayList();
    }

    public final boolean m1700a() {
        switch (this.f1435g) {
            case 1:
                if (this.f1432d.size() != 2) {
                    return false;
                }
                return true;
            case 3:
                if (this.f1432d.size() != 3) {
                    return false;
                }
                return true;
            default:
                return false;
        }
    }

    public final C0329p m1701b() {
        switch (this.f1435g) {
            case 1:
                return (C0329p) this.f1432d.get(1);
            case 3:
                return (C0329p) this.f1432d.get(2);
            default:
                return null;
        }
    }

    public final C0329p m1697a(int i) {
        Iterator it = this.f1432d.iterator();
        while (it.hasNext()) {
            C0329p c0329p = (C0329p) it.next();
            if (c0329p.f1440a == i) {
                return c0329p;
            }
        }
        return null;
    }

    public final ArrayList m1702b(int i) {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f1431c.iterator();
        while (it.hasNext()) {
            C0329p c0329p = (C0329p) it.next();
            if (c0329p.f1440a == i) {
                arrayList.add(c0329p);
            }
        }
        it = this.f1433e.iterator();
        while (it.hasNext()) {
            c0329p = (C0329p) it.next();
            if (c0329p.f1440a == i) {
                arrayList.add(c0329p);
            }
        }
        it = this.f1432d.iterator();
        while (it.hasNext()) {
            c0329p = (C0329p) it.next();
            if (c0329p.f1440a == i) {
                arrayList.add(c0329p);
            }
        }
        return arrayList;
    }

    public final void m1698a(int i, int i2, int i3) {
        this.f1433e.add(new C0329p(i, i2, i3));
    }

    public final void m1703b(int i, int i2, int i3) {
        this.f1432d.add(new C0329p(i, i2, i3));
    }

    public final void m1705c(int i, int i2, int i3) {
        this.f1431c.add(new C0329p(i, i2, i3));
        this.f1433e.add(new C0329p(i, i2, i3));
    }

    public final void m1704c() {
        if (this.f1430b != null && this.f1430b.m1690c()) {
            this.f1430b.m1689b();
        }
    }

    public final void m1699a(Menu menu) {
        menu.clear();
        Iterator it = this.f1433e.iterator();
        while (it.hasNext()) {
            C0329p c0329p = (C0329p) it.next();
            MenuItem add = menu.add(0, c0329p.f1440a, 0, c0329p.f1442c);
            if (c0329p.f1446g) {
                add.setIcon(c0329p.f1445f);
            } else {
                add.setIcon(c0329p.f1441b);
            }
            add.setVisible(c0329p.f1447h);
            add.setEnabled(c0329p.f1448i);
        }
    }
}
