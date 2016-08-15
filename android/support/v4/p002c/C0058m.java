package android.support.v4.p002c;

/* renamed from: android.support.v4.c.m */
public final class C0058m implements Cloneable {
    public static final Object f259a;
    public boolean f260b;
    public int[] f261c;
    public Object[] f262d;
    public int f263e;

    public final /* synthetic */ Object clone() {
        return m258c();
    }

    static {
        f259a = new Object();
    }

    public C0058m() {
        this((byte) 0);
    }

    private C0058m(byte b) {
        this.f260b = false;
        int a = C0050c.m253a(10);
        this.f261c = new int[a];
        this.f262d = new Object[a];
        this.f263e = 0;
    }

    private C0058m m258c() {
        try {
            C0058m c0058m = (C0058m) super.clone();
            try {
                c0058m.f261c = (int[]) this.f261c.clone();
                c0058m.f262d = (Object[]) this.f262d.clone();
                return c0058m;
            } catch (CloneNotSupportedException e) {
                return c0058m;
            }
        } catch (CloneNotSupportedException e2) {
            return null;
        }
    }

    private void m259d() {
        int i = this.f263e;
        int[] iArr = this.f261c;
        Object[] objArr = this.f262d;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (obj != f259a) {
                if (i3 != i2) {
                    iArr[i2] = iArr[i3];
                    objArr[i2] = obj;
                    objArr[i3] = null;
                }
                i2++;
            }
        }
        this.f260b = false;
        this.f263e = i2;
    }

    public final void m262a(int i, Object obj) {
        int a = C0050c.m254a(this.f261c, this.f263e, i);
        if (a >= 0) {
            this.f262d[a] = obj;
            return;
        }
        a ^= -1;
        if (a >= this.f263e || this.f262d[a] != f259a) {
            if (this.f260b && this.f263e >= this.f261c.length) {
                m259d();
                a = C0050c.m254a(this.f261c, this.f263e, i) ^ -1;
            }
            if (this.f263e >= this.f261c.length) {
                int a2 = C0050c.m253a(this.f263e + 1);
                Object obj2 = new int[a2];
                Object obj3 = new Object[a2];
                System.arraycopy(this.f261c, 0, obj2, 0, this.f261c.length);
                System.arraycopy(this.f262d, 0, obj3, 0, this.f262d.length);
                this.f261c = obj2;
                this.f262d = obj3;
            }
            if (this.f263e - a != 0) {
                System.arraycopy(this.f261c, a, this.f261c, a + 1, this.f263e - a);
                System.arraycopy(this.f262d, a, this.f262d, a + 1, this.f263e - a);
            }
            this.f261c[a] = i;
            this.f262d[a] = obj;
            this.f263e++;
            return;
        }
        this.f261c[a] = i;
        this.f262d[a] = obj;
    }

    public final int m260a() {
        if (this.f260b) {
            m259d();
        }
        return this.f263e;
    }

    public final int m263b(int i) {
        if (this.f260b) {
            m259d();
        }
        return this.f261c[i];
    }

    public final Object m265c(int i) {
        if (this.f260b) {
            m259d();
        }
        return this.f262d[i];
    }

    public final void m264b() {
        int i = this.f263e;
        Object[] objArr = this.f262d;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.f263e = 0;
        this.f260b = false;
    }

    public final String toString() {
        if (m260a() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.f263e * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.f263e; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(m263b(i));
            stringBuilder.append('=');
            C0058m c = m265c(i);
            if (c != this) {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final Object m261a(int i) {
        int a = C0050c.m254a(this.f261c, this.f263e, i);
        if (a < 0 || this.f262d[a] == f259a) {
            return null;
        }
        return this.f262d[a];
    }
}
