package android.support.v4.widget;

import android.content.Context;
import android.support.v4.p003d.C0075m;
import android.support.v4.p003d.C0080r;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.Arrays;

/* renamed from: android.support.v4.widget.q */
public final class C0103q {
    private static final Interpolator f313v;
    int f314a;
    int f315b;
    int f316c;
    float[] f317d;
    float[] f318e;
    float[] f319f;
    float[] f320g;
    int f321h;
    VelocityTracker f322i;
    float f323j;
    int f324k;
    int f325l;
    View f326m;
    boolean f327n;
    private int[] f328o;
    private int[] f329p;
    private int[] f330q;
    private float f331r;
    private C0097k f332s;
    private final C0089t f333t;
    private final ViewGroup f334u;
    private final Runnable f335w;

    static {
        f313v = new C0104r();
    }

    private C0103q(Context context, ViewGroup viewGroup, C0089t c0089t) {
        this.f316c = -1;
        this.f335w = new C0105s(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (c0089t == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f334u = viewGroup;
            this.f333t = c0089t;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f324k = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f315b = viewConfiguration.getScaledTouchSlop();
            this.f331r = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f323j = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f332s = C0097k.m425a(context, f313v);
        }
    }

    public final void m479a(View view, int i) {
        if (view.getParent() != this.f334u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f334u + ")");
        }
        this.f326m = view;
        this.f316c = i;
        this.f333t.m380b(view);
        m478a(1);
    }

    public final void m477a() {
        this.f316c = -1;
        if (this.f317d != null) {
            Arrays.fill(this.f317d, 0.0f);
            Arrays.fill(this.f318e, 0.0f);
            Arrays.fill(this.f319f, 0.0f);
            Arrays.fill(this.f320g, 0.0f);
            Arrays.fill(this.f328o, 0);
            Arrays.fill(this.f329p, 0);
            Arrays.fill(this.f330q, 0);
            this.f321h = 0;
        }
        if (this.f322i != null) {
            this.f322i.recycle();
            this.f322i = null;
        }
    }

    public final boolean m482a(View view, int i, int i2) {
        this.f326m = view;
        this.f316c = -1;
        return m480a(i, i2, 0, 0);
    }

    final boolean m480a(int i, int i2, int i3, int i4) {
        int left = this.f326m.getLeft();
        int top = this.f326m.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f332s.m426a();
            m478a(0);
            return false;
        }
        View view = this.f326m;
        int b = C0103q.m470b(i3, (int) this.f323j, (int) this.f331r);
        int b2 = C0103q.m470b(i4, (int) this.f323j, (int) this.f331r);
        int abs = Math.abs(i5);
        int abs2 = Math.abs(i6);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        int a = (int) (((b2 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) m464a(i6, b2, 0))) + ((b != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) m464a(i5, b, this.f333t.m381c(view)))));
        C0097k c0097k = this.f332s;
        c0097k.f312b.m428a(c0097k.f311a, left, top, i5, i6, a);
        m478a(2);
        return true;
    }

    private int m464a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f334u.getWidth();
        int i4 = width / 2;
        float sin = (((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, ((float) Math.abs(i)) / ((float) width)) - 0.5f)) * 0.4712389167638204d)))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(sin / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    private static int m470b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private static float m463a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    public final boolean m484b() {
        if (this.f314a == 2) {
            C0097k c0097k = this.f332s;
            boolean d = c0097k.f312b.m432d(c0097k.f311a);
            C0097k c0097k2 = this.f332s;
            int b = c0097k2.f312b.m430b(c0097k2.f311a);
            C0097k c0097k3 = this.f332s;
            int c = c0097k3.f312b.m431c(c0097k3.f311a);
            int left = b - this.f326m.getLeft();
            int top = c - this.f326m.getTop();
            if (left != 0) {
                this.f326m.offsetLeftAndRight(left);
            }
            if (top != 0) {
                this.f326m.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                this.f333t.m377a(this.f326m, b);
            }
            if (d) {
                C0097k c0097k4 = this.f332s;
                if (b == c0097k4.f312b.m434f(c0097k4.f311a)) {
                    c0097k2 = this.f332s;
                    if (c == c0097k2.f312b.m435g(c0097k2.f311a)) {
                        this.f332s.m426a();
                        c0097k = this.f332s;
                        d = c0097k.f312b.m429a(c0097k.f311a);
                    }
                }
            }
            if (!d) {
                this.f334u.post(this.f335w);
            }
        }
        return this.f314a == 2;
    }

    private void m466a(float f) {
        this.f327n = true;
        this.f333t.m376a(this.f326m, f);
        this.f327n = false;
        if (this.f314a == 1) {
            m478a(0);
        }
    }

    private void m472b(int i) {
        if (this.f317d != null) {
            this.f317d[i] = 0.0f;
            this.f318e[i] = 0.0f;
            this.f319f[i] = 0.0f;
            this.f320g[i] = 0.0f;
            this.f328o[i] = 0;
            this.f329p[i] = 0;
            this.f330q[i] = 0;
            this.f321h &= (1 << i) ^ -1;
        }
    }

    private void m467a(float f, float f2, int i) {
        int i2 = 0;
        if (this.f317d == null || this.f317d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f317d != null) {
                System.arraycopy(this.f317d, 0, obj, 0, this.f317d.length);
                System.arraycopy(this.f318e, 0, obj2, 0, this.f318e.length);
                System.arraycopy(this.f319f, 0, obj3, 0, this.f319f.length);
                System.arraycopy(this.f320g, 0, obj4, 0, this.f320g.length);
                System.arraycopy(this.f328o, 0, obj5, 0, this.f328o.length);
                System.arraycopy(this.f329p, 0, obj6, 0, this.f329p.length);
                System.arraycopy(this.f330q, 0, obj7, 0, this.f330q.length);
            }
            this.f317d = obj;
            this.f318e = obj2;
            this.f319f = obj3;
            this.f320g = obj4;
            this.f328o = obj5;
            this.f329p = obj6;
            this.f330q = obj7;
        }
        float[] fArr = this.f317d;
        this.f319f[i] = f;
        fArr[i] = f;
        fArr = this.f318e;
        this.f320g[i] = f2;
        fArr[i] = f2;
        int[] iArr = this.f328o;
        int i3 = (int) f;
        int i4 = (int) f2;
        if (i3 < this.f334u.getLeft() + this.f324k) {
            i2 = 1;
        }
        if (i4 < this.f334u.getTop() + this.f324k) {
            i2 |= 4;
        }
        if (i3 > this.f334u.getRight() - this.f324k) {
            i2 |= 2;
        }
        if (i4 > this.f334u.getBottom() - this.f324k) {
            i2 |= 8;
        }
        iArr[i] = i2;
        this.f321h |= 1 << i;
    }

    private void m475c(MotionEvent motionEvent) {
        int c = C0075m.m324c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = C0075m.m322b(motionEvent, i);
            float c2 = C0075m.m323c(motionEvent, i);
            float d = C0075m.m325d(motionEvent, i);
            this.f319f[b] = c2;
            this.f320g[b] = d;
        }
    }

    final void m478a(int i) {
        if (this.f314a != i) {
            this.f314a = i;
            this.f333t.m374a(i);
            if (i == 0) {
                this.f326m = null;
            }
        }
    }

    private boolean m473b(View view, int i) {
        if (view == this.f326m && this.f316c == i) {
            return true;
        }
        if (view == null || !this.f333t.m378a(view)) {
            return false;
        }
        this.f316c = i;
        m479a(view, i);
        return true;
    }

    public final boolean m481a(MotionEvent motionEvent) {
        int a = C0075m.m319a(motionEvent);
        int b = C0075m.m321b(motionEvent);
        if (a == 0) {
            m477a();
        }
        if (this.f322i == null) {
            this.f322i = VelocityTracker.obtain();
        }
        this.f322i.addMovement(motionEvent);
        float y;
        int b2;
        switch (a) {
            case 0:
                float x = motionEvent.getX();
                y = motionEvent.getY();
                b2 = C0075m.m322b(motionEvent, 0);
                m467a(x, y, b2);
                View a2 = m476a((int) x, (int) y);
                if (a2 == this.f326m && this.f314a == 2) {
                    m473b(a2, b2);
                }
                if ((this.f328o[b2] & this.f325l) != 0) {
                    this.f333t.m382c();
                    break;
                }
                break;
            case 1:
            case 3:
                m477a();
                break;
            case 2:
                b = C0075m.m324c(motionEvent);
                a = 0;
                while (a < b) {
                    b2 = C0075m.m322b(motionEvent, a);
                    float c = C0075m.m323c(motionEvent, a);
                    float d = C0075m.m325d(motionEvent, a);
                    float f = c - this.f317d[b2];
                    m471b(f, d - this.f318e[b2], b2);
                    if (this.f314a != 1) {
                        View a3 = m476a((int) c, (int) d);
                        if (a3 == null || !m469a(a3, f) || !m473b(a3, b2)) {
                            a++;
                        }
                    }
                    m475c(motionEvent);
                    break;
                }
                m475c(motionEvent);
                break;
            case 5:
                a = C0075m.m322b(motionEvent, b);
                float c2 = C0075m.m323c(motionEvent, b);
                y = C0075m.m325d(motionEvent, b);
                m467a(c2, y, a);
                if (this.f314a != 0) {
                    if (this.f314a == 2) {
                        View a4 = m476a((int) c2, (int) y);
                        if (a4 == this.f326m) {
                            m473b(a4, a);
                            break;
                        }
                    }
                } else if ((this.f328o[a] & this.f325l) != 0) {
                    this.f333t.m382c();
                    break;
                }
                break;
            case 6:
                m472b(C0075m.m322b(motionEvent, b));
                break;
        }
        if (this.f314a == 1) {
            return true;
        }
        return false;
    }

    public final void m483b(MotionEvent motionEvent) {
        int i = 0;
        int a = C0075m.m319a(motionEvent);
        int b = C0075m.m321b(motionEvent);
        if (a == 0) {
            m477a();
        }
        if (this.f322i == null) {
            this.f322i = VelocityTracker.obtain();
        }
        this.f322i.addMovement(motionEvent);
        float x;
        int i2;
        int d;
        float c;
        switch (a) {
            case 0:
                x = motionEvent.getX();
                float y = motionEvent.getY();
                i = C0075m.m322b(motionEvent, 0);
                View a2 = m476a((int) x, (int) y);
                m467a(x, y, i);
                m473b(a2, i);
                if ((this.f328o[i] & this.f325l) != 0) {
                    this.f333t.m382c();
                }
            case 1:
                if (this.f314a == 1) {
                    m474c();
                }
                m477a();
            case 2:
                if (this.f314a == 1) {
                    i = C0075m.m320a(motionEvent, this.f316c);
                    x = C0075m.m323c(motionEvent, i);
                    i2 = (int) (x - this.f319f[this.f316c]);
                    d = (int) (C0075m.m325d(motionEvent, i) - this.f320g[this.f316c]);
                    i = this.f326m.getLeft() + i2;
                    this.f326m.getTop();
                    a = this.f326m.getLeft();
                    b = this.f326m.getTop();
                    if (i2 != 0) {
                        i = this.f333t.m379b(this.f326m, i);
                        this.f326m.offsetLeftAndRight(i - a);
                    }
                    if (d != 0) {
                        this.f326m.offsetTopAndBottom(this.f333t.m383d(this.f326m) - b);
                    }
                    if (!(i2 == 0 && d == 0)) {
                        this.f333t.m377a(this.f326m, i);
                    }
                    m475c(motionEvent);
                    return;
                }
                i2 = C0075m.m324c(motionEvent);
                while (i < i2) {
                    a = C0075m.m322b(motionEvent, i);
                    c = C0075m.m323c(motionEvent, i);
                    float d2 = C0075m.m325d(motionEvent, i);
                    float f = c - this.f317d[a];
                    m471b(f, d2 - this.f318e[a], a);
                    if (this.f314a != 1) {
                        View a3 = m476a((int) c, (int) d2);
                        if (!m469a(a3, f) || !m473b(a3, a)) {
                            i++;
                        }
                    }
                    m475c(motionEvent);
                }
                m475c(motionEvent);
            case 3:
                if (this.f314a == 1) {
                    m466a(0.0f);
                }
                m477a();
            case 5:
                i2 = C0075m.m322b(motionEvent, b);
                float c2 = C0075m.m323c(motionEvent, b);
                c = C0075m.m325d(motionEvent, b);
                m467a(c2, c, i2);
                if (this.f314a == 0) {
                    m473b(m476a((int) c2, (int) c), i2);
                    if ((this.f328o[i2] & this.f325l) != 0) {
                        this.f333t.m382c();
                        return;
                    }
                    return;
                }
                a = (int) c2;
                b = (int) c;
                View view = this.f326m;
                if (view != null && a >= view.getLeft() && a < view.getRight() && b >= view.getTop() && b < view.getBottom()) {
                    i = 1;
                }
                if (i != 0) {
                    m473b(this.f326m, i2);
                }
            case 6:
                a = C0075m.m322b(motionEvent, b);
                if (this.f314a == 1 && a == this.f316c) {
                    d = C0075m.m324c(motionEvent);
                    while (i < d) {
                        b = C0075m.m322b(motionEvent, i);
                        if (b != this.f316c) {
                            if (m476a((int) C0075m.m323c(motionEvent, i), (int) C0075m.m325d(motionEvent, i)) == this.f326m && m473b(this.f326m, b)) {
                                i = this.f316c;
                                if (i == -1) {
                                    m474c();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m474c();
                    }
                }
                m472b(a);
            default:
        }
    }

    private void m471b(float f, float f2, int i) {
        int i2 = 1;
        if (!m468a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m468a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m468a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m468a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f329p;
            iArr[i] = iArr[i] | i2;
            this.f333t.m375a(i2, i);
        }
    }

    private boolean m468a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f328o[i] & i2) != i2 || (this.f325l & i2) == 0 || (this.f330q[i] & i2) == i2 || (this.f329p[i] & i2) == i2) {
            return false;
        }
        if ((abs > ((float) this.f315b) || abs2 > ((float) this.f315b)) && (this.f329p[i] & i2) == 0 && abs > ((float) this.f315b)) {
            return true;
        }
        return false;
    }

    private boolean m469a(View view, float f) {
        if (view == null) {
            return false;
        }
        if (!(this.f333t.m381c(view) > 0) || Math.abs(f) <= ((float) this.f315b)) {
            return false;
        }
        return true;
    }

    private void m474c() {
        this.f322i.computeCurrentVelocity(1000, this.f331r);
        float a = C0103q.m463a(C0080r.m346a(this.f322i, this.f316c), this.f323j, this.f331r);
        C0103q.m463a(C0080r.m347b(this.f322i, this.f316c), this.f323j, this.f331r);
        m466a(a);
    }

    public final View m476a(int i, int i2) {
        for (int childCount = this.f334u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f334u.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    public static C0103q m465a(ViewGroup viewGroup, C0089t c0089t) {
        C0103q c0103q = new C0103q(viewGroup.getContext(), viewGroup, c0089t);
        c0103q.f315b = (int) (((float) c0103q.f315b) * 1.0f);
        return c0103q;
    }
}
