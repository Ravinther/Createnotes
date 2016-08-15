package android.support.v4.p002c;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.c.f */
abstract class C0048f {
    C0054h f238b;
    C0055i f239c;
    C0057k f240d;

    protected abstract int m233a();

    protected abstract int m234a(Object obj);

    protected abstract Object m235a(int i, int i2);

    protected abstract Object m236a(int i, Object obj);

    protected abstract void m237a(int i);

    protected abstract void m238a(Object obj, Object obj2);

    protected abstract int m240b(Object obj);

    protected abstract Map m241b();

    protected abstract void m243c();

    C0048f() {
    }

    public final Object[] m242b(int i) {
        int a = m233a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = m235a(i2, i);
        }
        return objArr;
    }

    public final Object[] m239a(Object[] objArr, int i) {
        Object[] objArr2;
        int a = m233a();
        if (objArr.length < a) {
            objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), a);
        } else {
            objArr2 = objArr;
        }
        for (int i2 = 0; i2 < a; i2++) {
            objArr2[i2] = m235a(i2, i);
        }
        if (objArr2.length > a) {
            objArr2[a] = null;
        }
        return objArr2;
    }

    public static boolean m232a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        try {
            if (set.size() == set2.size() && set.containsAll(set2)) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        } catch (ClassCastException e2) {
            return false;
        }
    }
}
