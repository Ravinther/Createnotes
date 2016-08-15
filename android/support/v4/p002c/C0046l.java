package android.support.v4.p002c;

import java.util.Map;

/* renamed from: android.support.v4.c.l */
public class C0046l {
    static Object[] f230b;
    static int f231c;
    static Object[] f232d;
    static int f233e;
    int[] f234f;
    Object[] f235g;
    int f236h;

    final int m227a(Object obj, int i) {
        int i2 = this.f236h;
        if (i2 == 0) {
            return -1;
        }
        int a = C0050c.m254a(this.f234f, i2, i);
        if (a < 0 || obj.equals(this.f235g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f234f[i3] == i) {
            if (obj.equals(this.f235g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f234f[a] == i) {
            if (obj.equals(this.f235g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    final int m225a() {
        int i = this.f236h;
        if (i == 0) {
            return -1;
        }
        int a = C0050c.m254a(this.f234f, i, 0);
        if (a < 0 || this.f235g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f234f[i2] == 0) {
            if (this.f235g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f234f[a] == 0) {
            if (this.f235g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    final void m228a(int i) {
        Object[] objArr;
        if (i == 8) {
            synchronized (C0047a.class) {
                if (f232d != null) {
                    objArr = f232d;
                    this.f235g = objArr;
                    f232d = (Object[]) objArr[0];
                    this.f234f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f233e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (C0047a.class) {
                if (f230b != null) {
                    objArr = f230b;
                    this.f235g = objArr;
                    f230b = (Object[]) objArr[0];
                    this.f234f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f231c--;
                    return;
                }
            }
        }
        this.f234f = new int[i];
        this.f235g = new Object[(i << 1)];
    }

    static void m223a(int[] iArr, Object[] objArr, int i) {
        int i2;
        if (iArr.length == 8) {
            synchronized (C0047a.class) {
                if (f233e < 10) {
                    objArr[0] = f232d;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f232d = objArr;
                    f233e++;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (C0047a.class) {
                if (f231c < 10) {
                    objArr[0] = f230b;
                    objArr[1] = iArr;
                    for (i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    f230b = objArr;
                    f231c++;
                }
            }
        }
    }

    public C0046l() {
        this.f234f = C0050c.f242a;
        this.f235g = C0050c.f244c;
        this.f236h = 0;
    }

    public void clear() {
        if (this.f236h != 0) {
            C0046l.m223a(this.f234f, this.f235g, this.f236h);
            this.f234f = C0050c.f242a;
            this.f235g = C0050c.f244c;
            this.f236h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return obj == null ? m225a() >= 0 : m227a(obj, obj.hashCode()) >= 0;
    }

    final int m226a(Object obj) {
        int i = 1;
        int i2 = this.f236h * 2;
        Object[] objArr = this.f235g;
        if (obj == null) {
            while (i < i2) {
                if (objArr[i] == null) {
                    return i >> 1;
                }
                i += 2;
            }
        } else {
            while (i < i2) {
                if (obj.equals(objArr[i])) {
                    return i >> 1;
                }
                i += 2;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return m226a(obj) >= 0;
    }

    public Object get(Object obj) {
        int a = obj == null ? m225a() : m227a(obj, obj.hashCode());
        return a >= 0 ? this.f235g[(a << 1) + 1] : null;
    }

    private Object m224d(int i) {
        return this.f235g[i << 1];
    }

    public final Object m229b(int i) {
        return this.f235g[(i << 1) + 1];
    }

    public boolean isEmpty() {
        return this.f236h <= 0;
    }

    public Object put(Object obj, Object obj2) {
        int a;
        int i;
        int i2 = 8;
        if (obj == null) {
            a = m225a();
            i = 0;
        } else {
            i = obj.hashCode();
            a = m227a(obj, i);
        }
        if (a >= 0) {
            int i3 = (a << 1) + 1;
            Object obj3 = this.f235g[i3];
            this.f235g[i3] = obj2;
            return obj3;
        }
        a ^= -1;
        if (this.f236h >= this.f234f.length) {
            if (this.f236h >= 8) {
                i2 = this.f236h + (this.f236h >> 1);
            } else if (this.f236h < 4) {
                i2 = 4;
            }
            Object obj4 = this.f234f;
            Object obj5 = this.f235g;
            m228a(i2);
            if (this.f234f.length > 0) {
                System.arraycopy(obj4, 0, this.f234f, 0, obj4.length);
                System.arraycopy(obj5, 0, this.f235g, 0, obj5.length);
            }
            C0046l.m223a(obj4, obj5, this.f236h);
        }
        if (a < this.f236h) {
            System.arraycopy(this.f234f, a, this.f234f, a + 1, this.f236h - a);
            System.arraycopy(this.f235g, a << 1, this.f235g, (a + 1) << 1, (this.f236h - a) << 1);
        }
        this.f234f[a] = i;
        this.f235g[a << 1] = obj;
        this.f235g[(a << 1) + 1] = obj2;
        this.f236h++;
        return null;
    }

    public Object remove(Object obj) {
        int a = obj == null ? m225a() : m227a(obj, obj.hashCode());
        if (a >= 0) {
            return m230c(a);
        }
        return null;
    }

    public final Object m230c(int i) {
        int i2 = 8;
        Object obj = this.f235g[(i << 1) + 1];
        if (this.f236h <= 1) {
            C0046l.m223a(this.f234f, this.f235g, this.f236h);
            this.f234f = C0050c.f242a;
            this.f235g = C0050c.f244c;
            this.f236h = 0;
        } else if (this.f234f.length <= 8 || this.f236h >= this.f234f.length / 3) {
            this.f236h--;
            if (i < this.f236h) {
                System.arraycopy(this.f234f, i + 1, this.f234f, i, this.f236h - i);
                System.arraycopy(this.f235g, (i + 1) << 1, this.f235g, i << 1, (this.f236h - i) << 1);
            }
            this.f235g[this.f236h << 1] = null;
            this.f235g[(this.f236h << 1) + 1] = null;
        } else {
            if (this.f236h > 8) {
                i2 = this.f236h + (this.f236h >> 1);
            }
            Object obj2 = this.f234f;
            Object obj3 = this.f235g;
            m228a(i2);
            this.f236h--;
            if (i > 0) {
                System.arraycopy(obj2, 0, this.f234f, 0, i);
                System.arraycopy(obj3, 0, this.f235g, 0, i << 1);
            }
            if (i < this.f236h) {
                System.arraycopy(obj2, i + 1, this.f234f, i, this.f236h - i);
                System.arraycopy(obj3, (i + 1) << 1, this.f235g, i << 1, (this.f236h - i) << 1);
            }
        }
        return obj;
    }

    public int size() {
        return this.f236h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        int i = 0;
        while (i < this.f236h) {
            try {
                Object d = m224d(i);
                Object b = m229b(i);
                Object obj2 = map.get(d);
                if (b == null) {
                    if (obj2 != null || !map.containsKey(d)) {
                        return false;
                    }
                } else if (!b.equals(obj2)) {
                    return false;
                }
                i++;
            } catch (NullPointerException e) {
                return false;
            } catch (ClassCastException e2) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.f234f;
        Object[] objArr = this.f235g;
        int i = this.f236h;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f236h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f236h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            C0046l d = m224d(i);
            if (d != this) {
                stringBuilder.append(d);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            d = m229b(i);
            if (d != this) {
                stringBuilder.append(d);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
