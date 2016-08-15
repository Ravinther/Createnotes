package com.socialnmobile.colornote.sync.p018b;

import com.socialnmobile.colornote.sync.cl;
import com.socialnmobile.util.p011b.C0385e;
import com.socialnmobile.util.p011b.p016c.C0351e;
import com.socialnmobile.util.p011b.p016c.C0354c;
import com.socialnmobile.util.p011b.p017b.C0355d;
import com.socialnmobile.util.p011b.p017b.C0464g;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.socialnmobile.colornote.sync.b.e */
public class C0361e extends AbstractMap {
    final JSONObject f1507a;

    public /* synthetic */ Object put(Object obj, Object obj2) {
        return m1833a((String) obj, obj2);
    }

    public C0361e() {
        this(new JSONObject());
    }

    public C0361e(JSONObject jSONObject) {
        if (jSONObject == null) {
            throw new IllegalArgumentException();
        }
        this.f1507a = jSONObject;
    }

    public C0361e(C0361e c0361e) {
        this(c0361e.f1507a);
    }

    public static C0361e m1830a(String str) {
        return C0357a.m1828f(str, C0357a.m1817a(C0464g.f2259a.m1783d(str)));
    }

    public final String toString() {
        return this.f1507a.toString();
    }

    public Set entrySet() {
        Set hashSet = new HashSet();
        Iterator keys = this.f1507a.keys();
        while (keys.hasNext()) {
            hashSet.add(new C0362f(this, (String) keys.next()));
        }
        return hashSet;
    }

    public Object remove(Object obj) {
        return this.f1507a.remove((String) obj);
    }

    public void clear() {
        ArrayList arrayList = new ArrayList();
        Iterator keys = this.f1507a.keys();
        while (keys.hasNext()) {
            arrayList.add((String) keys.next());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.f1507a.remove((String) it.next());
        }
    }

    public final Object m1833a(String str, Object obj) {
        if (obj instanceof C0385e) {
            obj = ((C0385e) obj).m2010c();
        }
        Object obj2 = get(str);
        try {
            this.f1507a.put(str, C0357a.m1823b(obj));
            return obj2;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public final void m1834a(String str, Object obj, C0351e c0351e) {
        m1833a(str, c0351e.m1778c(obj));
    }

    public Object get(Object obj) {
        try {
            return m1835b((String) obj);
        } catch (C0358b e) {
            return null;
        }
    }

    public final Object m1832a(String str, C0354c c0354c) {
        try {
            return c0354c.m1783d(m1844j(str));
        } catch (cl e) {
            return null;
        }
    }

    public final Object m1835b(String str) {
        return C0357a.m1821a(this.f1507a, str);
    }

    public final Number m1837c(String str) {
        return (Number) C0357a.m1818a(str, C0357a.m1825c(str, m1835b(str)));
    }

    public final String m1838d(String str) {
        return (String) C0357a.m1818a(str, C0357a.m1826d(str, m1835b(str)));
    }

    public final C0361e m1839e(String str) {
        return (C0361e) C0357a.m1818a(str, C0357a.m1828f(str, m1835b(str)));
    }

    public final Object m1831a(String str, C0355d c0355d) {
        return C0357a.m1818a(str, C0357a.m1819a(str, C0357a.m1826d(str, m1835b(str)), c0355d));
    }

    public final Object m1836b(String str, C0354c c0354c) {
        return c0354c.m1783d(m1839e(str));
    }

    public final boolean m1840f(String str) {
        Object obj = get(str);
        if (obj != null) {
            try {
                return C0357a.m1822b(str, obj).booleanValue();
            } catch (C0359c e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final Number m1841g(String str) {
        try {
            return C0357a.m1825c(str, get(str));
        } catch (C0359c e) {
            e.printStackTrace();
            return null;
        }
    }

    public final String m1842h(String str) {
        try {
            return C0357a.m1826d(str, get(str));
        } catch (C0359c e) {
            e.printStackTrace();
            return null;
        }
    }

    public final C0360d m1843i(String str) {
        try {
            return C0357a.m1827e(str, get(str));
        } catch (C0359c e) {
            e.printStackTrace();
            return null;
        }
    }

    public final C0361e m1844j(String str) {
        try {
            return C0357a.m1828f(str, get(str));
        } catch (C0359c e) {
            e.printStackTrace();
            return null;
        }
    }
}
