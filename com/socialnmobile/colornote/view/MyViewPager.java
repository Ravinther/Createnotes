package com.socialnmobile.colornote.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.p003d.C0075m;
import android.support.v4.p003d.C0080r;
import android.support.v4.p003d.C0085w;
import android.support.v4.p003d.aj;
import android.support.v4.widget.C0092f;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.socialnmobile.colornote.C0313j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MyViewPager extends ViewGroup {
    private static final int[] f1928a;
    private static final Comparator f1929b;
    private static final Interpolator f1930c;
    private float f1931A;
    private float f1932B;
    private int f1933C;
    private VelocityTracker f1934D;
    private int f1935E;
    private int f1936F;
    private int f1937G;
    private boolean f1938H;
    private C0092f f1939I;
    private C0092f f1940J;
    private boolean f1941K;
    private boolean f1942L;
    private int f1943M;
    private ao f1944N;
    private ao f1945O;
    private an f1946P;
    private int f1947Q;
    private final ArrayList f1948d;
    private af f1949e;
    private int f1950f;
    private int f1951g;
    private Parcelable f1952h;
    private ClassLoader f1953i;
    private Scroller f1954j;
    private ap f1955k;
    private int f1956l;
    private Drawable f1957m;
    private int f1958n;
    private int f1959o;
    private int f1960p;
    private int f1961q;
    private boolean f1962r;
    private boolean f1963s;
    private boolean f1964t;
    private boolean f1965u;
    private int f1966v;
    private boolean f1967w;
    private boolean f1968x;
    private int f1969y;
    private float f1970z;

    public class LayoutParams extends android.view.ViewGroup.LayoutParams {
        public boolean f1926a;
        public int f1927b;

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, MyViewPager.f1928a);
            this.f1927b = obtainStyledAttributes.getInteger(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    static {
        f1928a = new int[]{16842931};
        f1929b = new ai();
        f1930c = new aj();
    }

    public MyViewPager(Context context) {
        super(context);
        this.f1948d = new ArrayList();
        this.f1951g = -1;
        this.f1952h = null;
        this.f1953i = null;
        this.f1966v = 1;
        this.f1933C = -1;
        this.f1941K = true;
        this.f1947Q = 0;
        m2117c();
    }

    public MyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1948d = new ArrayList();
        this.f1951g = -1;
        this.f1952h = null;
        this.f1953i = null;
        this.f1966v = 1;
        this.f1933C = -1;
        this.f1941K = true;
        this.f1947Q = 0;
        m2117c();
    }

    private void m2117c() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f1954j = new Scroller(context, f1930c);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1969y = aj.m286a(viewConfiguration);
        this.f1935E = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1936F = viewConfiguration.getScaledMaximumFlingVelocity();
        if (VERSION.SDK_INT >= 14) {
            this.f1939I = new C0092f(context);
            this.f1940J = new C0092f(context);
        } else {
            this.f1939I = new am(context);
            this.f1940J = new am(context);
        }
        this.f1937G = (int) (context.getResources().getDisplayMetrics().density * 25.0f);
    }

    private void setScrollState(int i) {
        if (this.f1947Q != i) {
            this.f1947Q = i;
            if (this.f1944N != null) {
                this.f1944N.m699b(i);
            }
        }
    }

    public void setAdapter(af afVar) {
        if (this.f1949e != null) {
            int i;
            af afVar2 = this.f1949e;
            afVar2.f847e.unregisterObserver(this.f1955k);
            for (i = 0; i < this.f1948d.size(); i++) {
                al alVar = (al) this.f1948d.get(i);
                this.f1949e.m833a(this, alVar.f2026b, alVar.f2025a);
            }
            this.f1949e.m831a();
            this.f1948d.clear();
            i = 0;
            while (i < getChildCount()) {
                if (!((LayoutParams) getChildAt(i).getLayoutParams()).f1926a) {
                    removeViewAt(i);
                    i--;
                }
                i++;
            }
            this.f1950f = 0;
            scrollTo(0, 0);
        }
        this.f1949e = afVar;
        if (this.f1949e != null) {
            if (this.f1955k == null) {
                this.f1955k = new ap();
            }
            afVar2 = this.f1949e;
            afVar2.f847e.registerObserver(this.f1955k);
            this.f1964t = false;
            if (this.f1951g >= 0) {
                this.f1949e.m832a(this.f1952h, this.f1953i);
                m2111a(this.f1951g, false, true);
                this.f1951g = -1;
                this.f1952h = null;
                this.f1953i = null;
                return;
            }
            m2118d();
        }
    }

    public af getAdapter() {
        return this.f1949e;
    }

    void setOnAdapterChangeListener(an anVar) {
        this.f1946P = anVar;
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.f1964t = false;
        if (this.f1941K) {
            z = false;
        } else {
            z = true;
        }
        m2111a(i, z, false);
    }

    public void setCurrentItem(int i, boolean z) {
        this.f1964t = false;
        m2111a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f1950f;
    }

    private void m2111a(int i, boolean z, boolean z2) {
        m2112a(i, z, z2, 0);
    }

    private void m2112a(int i, boolean z, boolean z2, int i2) {
        if (this.f1949e == null) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f1950f != i || this.f1948d.size() == 0) {
            int i3;
            Object obj;
            if (i < 0) {
                i = 0;
            } else if (i >= 2) {
                i = 1;
            }
            int i4 = this.f1966v;
            if (i > this.f1950f + i4 || i < this.f1950f - i4) {
                for (i3 = 0; i3 < this.f1948d.size(); i3++) {
                    ((al) this.f1948d.get(i3)).f2027c = true;
                }
            }
            if (this.f1950f != i) {
                obj = 1;
            } else {
                obj = null;
            }
            this.f1950f = i;
            m2118d();
            i4 = (getWidth() + this.f1956l) * i;
            if (z) {
                if (getChildCount() == 0) {
                    setScrollingCacheEnabled(false);
                } else {
                    i3 = getScrollX();
                    int scrollY = getScrollY();
                    int i5 = i4 - i3;
                    int i6 = 0 - scrollY;
                    if (i5 == 0 && i6 == 0) {
                        m2120f();
                        setScrollState(0);
                    } else {
                        setScrollingCacheEnabled(true);
                        this.f1965u = true;
                        setScrollState(2);
                        i4 = getWidth();
                        int i7 = i4 / 2;
                        float f = (float) i7;
                        float sin = (((float) i7) * ((float) Math.sin((double) ((float) (((double) (Math.min(1.0f, (1.0f * ((float) Math.abs(i5))) / ((float) i4)) - 0.5f)) * 0.4712389167638204d))))) + f;
                        int abs = Math.abs(i2);
                        if (abs > 0) {
                            i4 = Math.round(1000.0f * Math.abs(sin / ((float) abs))) * 4;
                        } else {
                            i4 = (int) (((((float) Math.abs(i5)) / ((float) (i4 + this.f1956l))) + 1.0f) * 100.0f);
                        }
                        this.f1954j.startScroll(i3, scrollY, i5, i6, Math.min(i4, 600));
                        invalidate();
                    }
                }
                if (!(obj == null || this.f1944N == null)) {
                    this.f1944N.m700c(i);
                }
                if (obj != null && this.f1945O != null) {
                    this.f1945O.m700c(i);
                    return;
                }
                return;
            }
            if (!(obj == null || this.f1944N == null)) {
                this.f1944N.m700c(i);
            }
            if (!(obj == null || this.f1945O == null)) {
                this.f1945O.m700c(i);
            }
            m2120f();
            scrollTo(i4, 0);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    public void setOnPageChangeListener(ao aoVar) {
        this.f1944N = aoVar;
    }

    public int getOffscreenPageLimit() {
        return this.f1966v;
    }

    public void setOffscreenPageLimit(int i) {
        if (i <= 0) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to 1");
            i = 1;
        }
        if (i != this.f1966v) {
            this.f1966v = i;
            m2118d();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f1956l;
        this.f1956l = i;
        int width = getWidth();
        m2110a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f1956l;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f1957m = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f1957m;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f1957m;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    private void m2109a(int i, int i2) {
        al alVar = new al();
        alVar.f2026b = i;
        alVar.f2025a = this.f1949e.m830a((ViewGroup) this, i);
        if (i2 < 0) {
            this.f1948d.add(alVar);
        } else {
            this.f1948d.add(i2, alVar);
        }
    }

    final void m2123a() {
        int i;
        int i2 = 0;
        if (this.f1948d.size() >= 3 || this.f1948d.size() >= 2) {
            i = 0;
        } else {
            i = 1;
        }
        while (i2 < this.f1948d.size()) {
            this.f1948d.get(i2);
            i2++;
        }
        Collections.sort(this.f1948d, f1929b);
        if (i != 0) {
            m2118d();
            requestLayout();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2118d() {
        /*
        r10 = this;
        r4 = -1;
        r6 = 0;
        r2 = 0;
        r0 = r10.f1949e;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return;
    L_0x0008:
        r0 = r10.f1964t;
        if (r0 != 0) goto L_0x0007;
    L_0x000c:
        r0 = r10.getWindowToken();
        if (r0 == 0) goto L_0x0007;
    L_0x0012:
        r0 = r10.f1966v;
        r1 = r10.f1950f;
        r1 = r1 - r0;
        r5 = java.lang.Math.max(r2, r1);
        r1 = 1;
        r3 = r10.f1950f;
        r0 = r0 + r3;
        r7 = java.lang.Math.min(r1, r0);
        r1 = r2;
        r3 = r4;
    L_0x0025:
        r0 = r10.f1948d;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x0072;
    L_0x002d:
        r0 = r10.f1948d;
        r0 = r0.get(r1);
        r0 = (com.socialnmobile.colornote.view.al) r0;
        r8 = r0.f2026b;
        if (r8 < r5) goto L_0x003d;
    L_0x0039:
        r8 = r0.f2026b;
        if (r8 <= r7) goto L_0x0059;
    L_0x003d:
        r8 = r0.f2027c;
        if (r8 != 0) goto L_0x0059;
    L_0x0041:
        r3 = r10.f1948d;
        r3.remove(r1);
        r1 = r1 + -1;
        r3 = r10.f1949e;
        r8 = r0.f2026b;
        r9 = r0.f2025a;
        r3.m833a(r10, r8, r9);
        r3 = r1;
    L_0x0052:
        r1 = r0.f2026b;
        r0 = r3 + 1;
        r3 = r1;
        r1 = r0;
        goto L_0x0025;
    L_0x0059:
        if (r3 >= r7) goto L_0x011d;
    L_0x005b:
        r8 = r0.f2026b;
        if (r8 <= r5) goto L_0x011d;
    L_0x005f:
        r3 = r3 + 1;
        if (r3 >= r5) goto L_0x0064;
    L_0x0063:
        r3 = r5;
    L_0x0064:
        if (r3 > r7) goto L_0x011d;
    L_0x0066:
        r8 = r0.f2026b;
        if (r3 >= r8) goto L_0x011d;
    L_0x006a:
        r10.m2109a(r3, r1);
        r3 = r3 + 1;
        r1 = r1 + 1;
        goto L_0x0064;
    L_0x0072:
        r0 = r10.f1948d;
        r0 = r0.size();
        if (r0 <= 0) goto L_0x009a;
    L_0x007a:
        r0 = r10.f1948d;
        r1 = r10.f1948d;
        r1 = r1.size();
        r1 = r1 + -1;
        r0 = r0.get(r1);
        r0 = (com.socialnmobile.colornote.view.al) r0;
        r0 = r0.f2026b;
    L_0x008c:
        if (r0 >= r7) goto L_0x009e;
    L_0x008e:
        r0 = r0 + 1;
        if (r0 <= r5) goto L_0x009c;
    L_0x0092:
        if (r0 > r7) goto L_0x009e;
    L_0x0094:
        r10.m2109a(r0, r4);
        r0 = r0 + 1;
        goto L_0x0092;
    L_0x009a:
        r0 = r4;
        goto L_0x008c;
    L_0x009c:
        r0 = r5;
        goto L_0x0092;
    L_0x009e:
        r1 = r2;
    L_0x009f:
        r0 = r10.f1948d;
        r0 = r0.size();
        if (r1 >= r0) goto L_0x011b;
    L_0x00a7:
        r0 = r10.f1948d;
        r0 = r0.get(r1);
        r0 = (com.socialnmobile.colornote.view.al) r0;
        r0 = r0.f2026b;
        r3 = r10.f1950f;
        if (r0 != r3) goto L_0x010c;
    L_0x00b5:
        r0 = r10.f1948d;
        r0 = r0.get(r1);
        r0 = (com.socialnmobile.colornote.view.al) r0;
    L_0x00bd:
        r1 = r10.f1949e;
        if (r0 == 0) goto L_0x0110;
    L_0x00c1:
        r0 = r0.f2025a;
    L_0x00c3:
        r1.m834a(r0);
        r0 = r10.f1949e;
        r0.m831a();
        r0 = r10.hasFocus();
        if (r0 == 0) goto L_0x0007;
    L_0x00d1:
        r0 = r10.findFocus();
        if (r0 == 0) goto L_0x00e4;
    L_0x00d7:
        r1 = r0;
    L_0x00d8:
        r0 = r1.getParent();
        if (r0 == r10) goto L_0x0116;
    L_0x00de:
        if (r0 == 0) goto L_0x00e4;
    L_0x00e0:
        r1 = r0 instanceof android.view.View;
        if (r1 != 0) goto L_0x0112;
    L_0x00e4:
        if (r6 == 0) goto L_0x00ec;
    L_0x00e6:
        r0 = r6.f2026b;
        r1 = r10.f1950f;
        if (r0 == r1) goto L_0x0007;
    L_0x00ec:
        r0 = r10.getChildCount();
        if (r2 >= r0) goto L_0x0007;
    L_0x00f2:
        r0 = r10.getChildAt(r2);
        r1 = r10.m2108a(r0);
        if (r1 == 0) goto L_0x0109;
    L_0x00fc:
        r1 = r1.f2026b;
        r3 = r10.f1950f;
        if (r1 != r3) goto L_0x0109;
    L_0x0102:
        r1 = 2;
        r0 = r0.requestFocus(r1);
        if (r0 != 0) goto L_0x0007;
    L_0x0109:
        r2 = r2 + 1;
        goto L_0x00ec;
    L_0x010c:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x009f;
    L_0x0110:
        r0 = r6;
        goto L_0x00c3;
    L_0x0112:
        r0 = (android.view.View) r0;
        r1 = r0;
        goto L_0x00d8;
    L_0x0116:
        r6 = r10.m2108a(r1);
        goto L_0x00e4;
    L_0x011b:
        r0 = r6;
        goto L_0x00bd;
    L_0x011d:
        r3 = r1;
        goto L_0x0052;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.view.MyViewPager.d():void");
    }

    public Parcelable onSaveInstanceState() {
        Parcelable aqVar = new aq(super.onSaveInstanceState());
        aqVar.f2037a = this.f1950f;
        if (this.f1949e != null) {
            aqVar.f2038b = this.f1949e.m836b();
        }
        return aqVar;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof aq) {
            aq aqVar = (aq) parcelable;
            super.onRestoreInstanceState(aqVar.getSuperState());
            if (this.f1949e != null) {
                this.f1949e.m832a(aqVar.f2038b, aqVar.f2039c);
                m2111a(aqVar.f2037a, false, true);
                return;
            }
            this.f1951g = aqVar.f2037a;
            this.f1952h = aqVar.f2038b;
            this.f1953i = aqVar.f2039c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        android.view.ViewGroup.LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams3 = (LayoutParams) layoutParams2;
        layoutParams3.f1926a |= view instanceof ak;
        if (!this.f1962r) {
            super.addView(view, i, layoutParams2);
        } else if (layoutParams3 == null || !layoutParams3.f1926a) {
            addViewInLayout(view, i, layoutParams2);
            view.measure(this.f1960p, this.f1961q);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    private al m2108a(View view) {
        for (int i = 0; i < this.f1948d.size(); i++) {
            al alVar = (al) this.f1948d.get(i);
            if (this.f1949e.m835a(view, alVar.f2025a)) {
                return alVar;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1941K = true;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            LayoutParams layoutParams;
            int i4;
            int i5;
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams != null && layoutParams.f1926a) {
                    int i6 = layoutParams.f1927b & 7;
                    int i7 = layoutParams.f1927b & 112;
                    Log.d("ViewPager", "gravity: " + layoutParams.f1927b + " hgrav: " + i6 + " vgrav: " + i7);
                    i4 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i4 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    childAt.measure(MeasureSpec.makeMeasureSpec(measuredWidth, i4), MeasureSpec.makeMeasureSpec(measuredHeight, i5));
                    if (obj != null) {
                        i5 = measuredHeight - childAt.getMeasuredHeight();
                        i4 = measuredWidth;
                    } else if (obj2 != null) {
                        i4 = measuredWidth - childAt.getMeasuredWidth();
                        i5 = measuredHeight;
                    }
                    i3++;
                    measuredWidth = i4;
                    measuredHeight = i5;
                }
            }
            i5 = measuredHeight;
            i4 = measuredWidth;
            i3++;
            measuredWidth = i4;
            measuredHeight = i5;
        }
        this.f1960p = MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        this.f1961q = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f1962r = true;
        m2118d();
        this.f1962r = false;
        measuredHeight = getChildCount();
        for (i4 = 0; i4 < measuredHeight; i4++) {
            View childAt2 = getChildAt(i4);
            if (childAt2.getVisibility() != 8) {
                layoutParams = (LayoutParams) childAt2.getLayoutParams();
                if (layoutParams == null || !layoutParams.f1926a) {
                    childAt2.measure(this.f1960p, this.f1961q);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m2110a(i, i3, this.f1956l, this.f1956l);
        }
    }

    private void m2110a(int i, int i2, int i3, int i4) {
        int i5 = i + i3;
        if (i2 > 0) {
            int scrollX = getScrollX();
            int i6 = i2 + i4;
            i6 = (int) (((((float) (scrollX % i6)) / ((float) i6)) + ((float) (scrollX / i6))) * ((float) i5));
            scrollTo(i6, getScrollY());
            if (!this.f1954j.isFinished()) {
                this.f1954j.startScroll(i6, 0, i5 * this.f1950f, 0, this.f1954j.getDuration() - this.f1954j.timePassed());
                return;
            }
            return;
        }
        scrollX = this.f1950f * i5;
        if (scrollX != getScrollX()) {
            m2120f();
            scrollTo(scrollX, getScrollY());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1962r = true;
        m2118d();
        this.f1962r = false;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1926a) {
                    int max;
                    int i9 = layoutParams.f1927b & 112;
                    switch (layoutParams.f1927b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    i7++;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                } else {
                    al a = m2108a(childAt);
                    if (a != null) {
                        measuredWidth = (a.f2026b * (this.f1956l + i5)) + paddingLeft;
                        childAt.layout(measuredWidth, paddingTop, childAt.getMeasuredWidth() + measuredWidth, childAt.getMeasuredHeight() + paddingTop);
                    }
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        this.f1958n = paddingTop;
        this.f1959o = i6 - paddingBottom;
        this.f1943M = i7;
        this.f1941K = false;
    }

    public void computeScroll() {
        if (this.f1954j.isFinished() || !this.f1954j.computeScrollOffset()) {
            m2120f();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f1954j.getCurrX();
        int currY = this.f1954j.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            m2119e();
        }
        invalidate();
    }

    private void m2119e() {
        getWidth();
        this.f1942L = false;
        if (this.f1943M > 0) {
            int scrollX = getScrollX();
            int paddingLeft = getPaddingLeft();
            int paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            int i = 0;
            while (i < childCount) {
                int i2;
                View childAt = getChildAt(i);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1926a) {
                    int max;
                    switch (layoutParams.f1927b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i2 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i2;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i2 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i2;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i2 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i2;
                            break;
                        default:
                            max = paddingLeft;
                            i2 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i2;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i2 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i2;
                }
                i++;
                i2 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i2;
            }
        }
        this.f1942L = true;
        if (!this.f1942L) {
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    private void m2120f() {
        int scrollX;
        boolean z = this.f1965u;
        if (z) {
            setScrollingCacheEnabled(false);
            this.f1954j.abortAnimation();
            scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f1954j.getCurrX();
            int currY = this.f1954j.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
            setScrollState(0);
        }
        this.f1964t = false;
        this.f1965u = false;
        boolean z2 = z;
        for (scrollX = 0; scrollX < this.f1948d.size(); scrollX++) {
            al alVar = (al) this.f1948d.get(scrollX);
            if (alVar.f2027c) {
                z2 = true;
                alVar.f2027c = false;
            }
        }
        if (z2) {
            m2118d();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f1967w = false;
            this.f1968x = false;
            this.f1933C = -1;
            if (this.f1934D == null) {
                return false;
            }
            this.f1934D.recycle();
            this.f1934D = null;
            return false;
        }
        if (action != 0) {
            if (this.f1967w) {
                return true;
            }
            if (this.f1968x) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f1970z = x;
                this.f1931A = x;
                this.f1932B = motionEvent.getY();
                this.f1933C = C0075m.m322b(motionEvent, 0);
                m2120f();
                this.f1967w = false;
                this.f1968x = false;
                break;
            case 2:
                action = this.f1933C;
                if (action != -1) {
                    action = C0075m.m320a(motionEvent, action);
                    float c = C0075m.m323c(motionEvent, action);
                    float f = c - this.f1931A;
                    float abs = Math.abs(f);
                    float d = C0075m.m325d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f1932B);
                    if (!m2115a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs <= ((float) this.f1969y) || abs <= abs2) {
                            if (abs2 > ((float) this.f1969y)) {
                                this.f1968x = true;
                                break;
                            }
                        }
                        this.f1967w = true;
                        setScrollState(1);
                        this.f1931A = c;
                        setScrollingCacheEnabled(true);
                        break;
                    }
                    this.f1931A = c;
                    this.f1970z = c;
                    this.f1932B = d;
                    return false;
                }
                break;
            case 6:
                m2113a(motionEvent);
                break;
        }
        if (!this.f1967w) {
            if (this.f1934D == null) {
                this.f1934D = VelocityTracker.obtain();
            }
            this.f1934D.addMovement(motionEvent);
        }
        return this.f1967w;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f1938H) {
            return true;
        }
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || this.f1949e == null) {
            return false;
        }
        if (this.f1934D == null) {
            this.f1934D = VelocityTracker.obtain();
        }
        this.f1934D.addMovement(motionEvent);
        float x;
        int a;
        float f;
        switch (motionEvent.getAction() & 255) {
            case 0:
                m2120f();
                x = motionEvent.getX();
                this.f1970z = x;
                this.f1931A = x;
                this.f1933C = C0075m.m322b(motionEvent, 0);
                break;
            case 1:
                if (this.f1967w) {
                    VelocityTracker velocityTracker = this.f1934D;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1936F);
                    a = (int) C0080r.m346a(velocityTracker, this.f1933C);
                    this.f1964t = true;
                    int width = this.f1956l + getWidth();
                    int scrollX = getScrollX();
                    int i = scrollX / width;
                    f = ((float) (scrollX % width)) / ((float) width);
                    if (Math.abs((int) (C0075m.m323c(motionEvent, C0075m.m320a(motionEvent, this.f1933C)) - this.f1970z)) <= this.f1937G || Math.abs(a) <= this.f1935E) {
                        i = (int) ((((float) i) + f) + 0.5f);
                    } else if (a <= 0) {
                        i++;
                    }
                    m2112a(i, true, true, a);
                    this.f1933C = -1;
                    m2121g();
                    z = this.f1939I.m400b() | this.f1940J.m400b();
                    break;
                }
                break;
            case 2:
                float abs;
                if (!this.f1967w) {
                    a = C0075m.m320a(motionEvent, this.f1933C);
                    f = C0075m.m323c(motionEvent, a);
                    abs = Math.abs(f - this.f1931A);
                    x = Math.abs(C0075m.m325d(motionEvent, a) - this.f1932B);
                    if (abs > ((float) this.f1969y) && abs > x) {
                        this.f1967w = true;
                        this.f1931A = f;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                    }
                }
                if (this.f1967w) {
                    boolean z2;
                    float f2;
                    x = C0075m.m323c(motionEvent, C0075m.m320a(motionEvent, this.f1933C));
                    f = this.f1931A - x;
                    this.f1931A = x;
                    abs = ((float) getScrollX()) + f;
                    int width2 = getWidth();
                    int i2 = width2 + this.f1956l;
                    x = (float) Math.max(0, (this.f1950f - 1) * i2);
                    f = (float) (Math.min(this.f1950f + 1, 1) * i2);
                    if (abs < x) {
                        if (x == 0.0f) {
                            z = this.f1939I.m398a((-abs) / ((float) width2));
                        }
                        float f3 = x;
                        z2 = z;
                        f2 = f3;
                    } else if (abs > f) {
                        if (f == ((float) (i2 * 1))) {
                            z = this.f1940J.m398a((abs - f) / ((float) width2));
                        }
                        z2 = z;
                        f2 = f;
                    } else {
                        z2 = false;
                        f2 = abs;
                    }
                    this.f1931A += f2 - ((float) ((int) f2));
                    scrollTo((int) f2, getScrollY());
                    m2119e();
                    z = z2;
                    break;
                }
                break;
            case 3:
                if (this.f1967w) {
                    m2111a(this.f1950f, true, true);
                    this.f1933C = -1;
                    m2121g();
                    z = this.f1939I.m400b() | this.f1940J.m400b();
                    break;
                }
                break;
            case 5:
                a = C0075m.m321b(motionEvent);
                this.f1931A = C0075m.m323c(motionEvent, a);
                this.f1933C = C0075m.m322b(motionEvent, a);
                break;
            case 6:
                m2113a(motionEvent);
                this.f1931A = C0075m.m323c(motionEvent, C0075m.m320a(motionEvent, this.f1933C));
                break;
        }
        if (z) {
            invalidate();
        }
        return true;
    }

    public void draw(Canvas canvas) {
        int i = 0;
        int i2 = 1;
        int save;
        int width;
        if (VERSION.SDK_INT >= 14) {
            super.draw(canvas);
            if (!this.f1939I.m397a()) {
                save = canvas.save();
                i = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(270.0f);
                canvas.translate((float) ((-i) + getPaddingTop()), 0.0f);
                this.f1939I.m396a(i, getWidth());
                i = this.f1939I.m399a(canvas) | 0;
                canvas.restoreToCount(save);
            }
            if (!this.f1940J.m397a()) {
                save = canvas.save();
                width = getWidth();
                int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                if (this.f1949e != null) {
                    i2 = 2;
                }
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (float) (((-i2) * (this.f1956l + width)) + this.f1956l));
                this.f1940J.m396a(height, width);
                i |= this.f1940J.m399a(canvas);
                canvas.restoreToCount(save);
            }
        } else {
            if (this.f1939I.m397a()) {
                save = 0;
            } else {
                canvas.translate((float) getScrollX(), (float) getScrollY());
                if (getBackground() != null) {
                    getBackground().draw(canvas);
                }
                canvas.translate((float) (-getScrollX()), (float) (-getScrollY()));
                save = canvas.save();
                canvas.translate(((am) this.f1939I).f2028a * ((float) C0313j.m1664c(getContext(), 160)), 0.0f);
                super.draw(canvas);
                i = this.f1939I.m399a(canvas) | 0;
                canvas.restoreToCount(save);
                save = i;
                i = 1;
            }
            if (this.f1940J.m397a()) {
                i2 = i;
                i = save;
            } else {
                canvas.translate((float) getScrollX(), (float) getScrollY());
                if (getBackground() != null) {
                    getBackground().draw(canvas);
                }
                canvas.translate((float) (-getScrollX()), (float) (-getScrollY()));
                width = canvas.save();
                canvas.translate((-((am) this.f1940J).f2028a) * ((float) C0313j.m1664c(getContext(), 160)), 0.0f);
                super.draw(canvas);
                i = this.f1940J.m399a(canvas) | save;
                canvas.restoreToCount(width);
            }
            if (i2 == 0) {
                super.draw(canvas);
            }
        }
        if (i != 0) {
            invalidate();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1956l > 0 && this.f1957m != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            int i = scrollX % (this.f1956l + width);
            if (i != 0) {
                scrollX = (scrollX - i) + width;
                this.f1957m.setBounds(scrollX, this.f1958n, this.f1956l + scrollX, this.f1959o);
                this.f1957m.draw(canvas);
            }
        }
    }

    private void m2113a(MotionEvent motionEvent) {
        int b = C0075m.m321b(motionEvent);
        if (C0075m.m322b(motionEvent, b) == this.f1933C) {
            b = b == 0 ? 1 : 0;
            this.f1931A = C0075m.m323c(motionEvent, b);
            this.f1933C = C0075m.m322b(motionEvent, b);
            if (this.f1934D != null) {
                this.f1934D.clear();
            }
        }
    }

    private void m2121g() {
        this.f1967w = false;
        this.f1968x = false;
        if (this.f1934D != null) {
            this.f1934D.recycle();
            this.f1934D = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f1963s != z) {
            this.f1963s = z;
        }
    }

    private boolean m2115a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m2115a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && C0085w.m357a(view, -i)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchKeyEvent(android.view.KeyEvent r5) {
        /*
        r4 = this;
        r0 = 0;
        r1 = 1;
        r2 = super.dispatchKeyEvent(r5);
        if (r2 != 0) goto L_0x0018;
    L_0x0008:
        r2 = r5.getAction();
        if (r2 != 0) goto L_0x0015;
    L_0x000e:
        r2 = r5.getKeyCode();
        switch(r2) {
            case 21: goto L_0x001a;
            case 22: goto L_0x0021;
            case 61: goto L_0x0028;
            default: goto L_0x0015;
        };
    L_0x0015:
        r2 = r0;
    L_0x0016:
        if (r2 == 0) goto L_0x0019;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        return r0;
    L_0x001a:
        r2 = 17;
        r2 = r4.m2114a(r2);
        goto L_0x0016;
    L_0x0021:
        r2 = 66;
        r2 = r4.m2114a(r2);
        goto L_0x0016;
    L_0x0028:
        r2 = android.os.Build.VERSION.SDK_INT;
        r3 = 11;
        if (r2 < r3) goto L_0x0015;
    L_0x002e:
        r2 = android.support.v4.p003d.C0068f.m300a(r5);
        if (r2 == 0) goto L_0x003a;
    L_0x0034:
        r2 = 2;
        r2 = r4.m2114a(r2);
        goto L_0x0016;
    L_0x003a:
        r2 = android.support.v4.p003d.C0068f.m301a(r5, r1);
        if (r2 == 0) goto L_0x0015;
    L_0x0040:
        r2 = r4.m2114a(r1);
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.view.MyViewPager.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m2114a(int r7) {
        /*
        r6 = this;
        r5 = 66;
        r4 = 17;
        r2 = 0;
        r1 = 1;
        r0 = r6.findFocus();
        if (r0 != r6) goto L_0x000d;
    L_0x000c:
        r0 = 0;
    L_0x000d:
        r3 = android.view.FocusFinder.getInstance();
        r3 = r3.findNextFocus(r6, r0, r7);
        if (r3 == 0) goto L_0x004e;
    L_0x0017:
        if (r3 == r0) goto L_0x004e;
    L_0x0019:
        if (r7 != r4) goto L_0x003b;
    L_0x001b:
        if (r0 == 0) goto L_0x0036;
    L_0x001d:
        r1 = r3.getLeft();
        r0 = r0.getLeft();
        if (r1 < r0) goto L_0x0036;
    L_0x0027:
        r0 = r6.m2122h();
    L_0x002b:
        r2 = r0;
    L_0x002c:
        if (r2 == 0) goto L_0x0035;
    L_0x002e:
        r0 = android.view.SoundEffectConstants.getContantForFocusDirection(r7);
        r6.playSoundEffect(r0);
    L_0x0035:
        return r2;
    L_0x0036:
        r0 = r3.requestFocus();
        goto L_0x002b;
    L_0x003b:
        if (r7 != r5) goto L_0x002c;
    L_0x003d:
        if (r0 == 0) goto L_0x0049;
    L_0x003f:
        r4 = r3.getLeft();
        r0 = r0.getLeft();
        if (r4 <= r0) goto L_0x005c;
    L_0x0049:
        r0 = r3.requestFocus();
        goto L_0x002b;
    L_0x004e:
        if (r7 == r4) goto L_0x0052;
    L_0x0050:
        if (r7 != r1) goto L_0x0057;
    L_0x0052:
        r0 = r6.m2122h();
        goto L_0x002b;
    L_0x0057:
        if (r7 == r5) goto L_0x005c;
    L_0x0059:
        r0 = 2;
        if (r7 != r0) goto L_0x002c;
    L_0x005c:
        r0 = r6.f1949e;
        if (r0 == 0) goto L_0x006d;
    L_0x0060:
        r0 = r6.f1950f;
        if (r0 > 0) goto L_0x006d;
    L_0x0064:
        r0 = r6.f1950f;
        r0 = r0 + 1;
        r6.setCurrentItem(r0, r1);
        r0 = r1;
        goto L_0x002b;
    L_0x006d:
        r0 = r2;
        goto L_0x002b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.view.MyViewPager.a(int):boolean");
    }

    private boolean m2122h() {
        if (this.f1950f <= 0) {
            return false;
        }
        setCurrentItem(this.f1950f - 1, true);
        return true;
    }

    public void addFocusables(ArrayList arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    al a = m2108a(childAt);
                    if (a != null && a.f2026b == this.f1950f) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                al a = m2108a(childAt);
                if (a != null && a.f2026b == this.f1950f) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                al a = m2108a(childAt);
                if (a != null && a.f2026b == this.f1950f && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                al a = m2108a(childAt);
                if (a != null && a.f2026b == this.f1950f && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
