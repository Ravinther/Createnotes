package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v4.p003d.C0060a;
import android.support.v4.p003d.C0068f;
import android.support.v4.p003d.C0085w;
import android.support.v4.p003d.ao;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;

public class DrawerLayout extends ViewGroup {
    private static final int[] f278e;
    final C0103q f279a;
    final C0103q f280b;
    int f281c;
    boolean f282d;
    private int f283f;
    private int f284g;
    private float f285h;
    private Paint f286i;
    private final C0090d f287j;
    private final C0090d f288k;
    private boolean f289l;
    private boolean f290m;
    private int f291n;
    private int f292o;
    private boolean f293p;
    private C0086a f294q;
    private float f295r;
    private float f296s;
    private Drawable f297t;
    private Drawable f298u;
    private CharSequence f299v;
    private CharSequence f300w;

    public class LayoutParams extends MarginLayoutParams {
        public int f274a;
        float f275b;
        boolean f276c;
        boolean f277d;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f274a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.f278e);
            this.f274a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams() {
            super(-1, -1);
            this.f274a = 0;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f274a = 0;
            this.f274a = layoutParams.f274a;
        }

        public LayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f274a = 0;
        }

        public LayoutParams(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f274a = 0;
        }
    }

    static {
        f278e = new int[]{16842931};
    }

    public DrawerLayout(Context context) {
        this(context, null);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DrawerLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f284g = -1728053248;
        this.f286i = new Paint();
        this.f290m = true;
        float f = getResources().getDisplayMetrics().density;
        this.f283f = (int) ((64.0f * f) + 0.5f);
        f *= 400.0f;
        this.f287j = new C0090d(this, 3);
        this.f288k = new C0090d(this, 5);
        this.f279a = C0103q.m465a((ViewGroup) this, this.f287j);
        this.f279a.f325l = 1;
        this.f279a.f323j = f;
        this.f287j.f305b = this.f279a;
        this.f280b = C0103q.m465a((ViewGroup) this, this.f288k);
        this.f280b.f325l = 2;
        this.f280b.f323j = f;
        this.f288k.f305b = this.f280b;
        setFocusableInTouchMode(true);
        C0085w.m359b(this, 1);
        ao.m291a(this, false);
    }

    public void setDrawerShadow(Drawable drawable, int i) {
        int a = C0060a.m268a(i, C0085w.m358b(this));
        if ((a & 3) == 3) {
            this.f297t = drawable;
            invalidate();
        }
        if ((a & 5) == 5) {
            this.f298u = drawable;
            invalidate();
        }
    }

    public void setDrawerShadow(int i, int i2) {
        setDrawerShadow(getResources().getDrawable(i), i2);
    }

    public void setScrimColor(int i) {
        this.f284g = i;
        invalidate();
    }

    public void setDrawerListener(C0086a c0086a) {
        this.f294q = c0086a;
    }

    public void setDrawerLockMode(int i) {
        setDrawerLockMode(i, 3);
        setDrawerLockMode(i, 5);
    }

    public void setDrawerLockMode(int i, int i2) {
        int a = C0060a.m268a(i2, C0085w.m358b(this));
        if (a == 3) {
            this.f291n = i;
        } else if (a == 5) {
            this.f292o = i;
        }
        if (i != 0) {
            (a == 3 ? this.f279a : this.f280b).m477a();
        }
        View a2;
        switch (i) {
            case 1:
                a2 = m369a(a);
                if (a2 != null) {
                    m373e(a2);
                }
            case 2:
                a2 = m369a(a);
                if (a2 != null) {
                    m372d(a2);
                }
            default:
        }
    }

    public void setDrawerLockMode(int i, View view) {
        if (m365c(view)) {
            setDrawerLockMode(i, ((LayoutParams) view.getLayoutParams()).f274a);
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer with appropriate layout_gravity");
    }

    public final int m368a(View view) {
        int f = m366f(view);
        if (f == 3) {
            return this.f291n;
        }
        if (f == 5) {
            return this.f292o;
        }
        return 0;
    }

    public void setDrawerTitle(int i, CharSequence charSequence) {
        int a = C0060a.m268a(i, C0085w.m358b(this));
        if (a == 3) {
            this.f299v = charSequence;
        } else if (a == 5) {
            this.f300w = charSequence;
        }
    }

    static void m360a(View view, float f) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (f != layoutParams.f275b) {
            layoutParams.f275b = f;
        }
    }

    static float m362b(View view) {
        return ((LayoutParams) view.getLayoutParams()).f275b;
    }

    private int m366f(View view) {
        return C0060a.m268a(((LayoutParams) view.getLayoutParams()).f274a, C0085w.m358b(this));
    }

    final boolean m371a(View view, int i) {
        return (m366f(view) & i) == i;
    }

    public final View m369a(int i) {
        int a = C0060a.m268a(i, C0085w.m358b(this)) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((m366f(childAt) & 7) == a) {
                return childAt;
            }
        }
        return null;
    }

    public static String m364b(int i) {
        if ((i & 3) == 3) {
            return "LEFT";
        }
        if ((i & 5) == 5) {
            return "RIGHT";
        }
        return Integer.toHexString(i);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f290m = true;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f290m = true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onMeasure(int r11, int r12) {
        /*
        r10 = this;
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r6 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r9 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = android.view.View.MeasureSpec.getMode(r11);
        r4 = android.view.View.MeasureSpec.getMode(r12);
        r2 = android.view.View.MeasureSpec.getSize(r11);
        r0 = android.view.View.MeasureSpec.getSize(r12);
        if (r3 != r9) goto L_0x001a;
    L_0x0018:
        if (r4 == r9) goto L_0x00e4;
    L_0x001a:
        r5 = r10.isInEditMode();
        if (r5 == 0) goto L_0x006a;
    L_0x0020:
        if (r3 == r6) goto L_0x0025;
    L_0x0022:
        if (r3 != 0) goto L_0x0025;
    L_0x0024:
        r2 = r1;
    L_0x0025:
        if (r4 == r6) goto L_0x00e4;
    L_0x0027:
        if (r4 != 0) goto L_0x00e4;
    L_0x0029:
        r10.setMeasuredDimension(r2, r1);
        r4 = r10.getChildCount();
        r0 = 0;
        r3 = r0;
    L_0x0032:
        if (r3 >= r4) goto L_0x00e3;
    L_0x0034:
        r5 = r10.getChildAt(r3);
        r0 = r5.getVisibility();
        r6 = 8;
        if (r0 == r6) goto L_0x0066;
    L_0x0040:
        r0 = r5.getLayoutParams();
        r0 = (android.support.v4.widget.DrawerLayout.LayoutParams) r0;
        r6 = m367g(r5);
        if (r6 == 0) goto L_0x0072;
    L_0x004c:
        r6 = r0.leftMargin;
        r6 = r2 - r6;
        r7 = r0.rightMargin;
        r6 = r6 - r7;
        r6 = android.view.View.MeasureSpec.makeMeasureSpec(r6, r9);
        r7 = r0.topMargin;
        r7 = r1 - r7;
        r0 = r0.bottomMargin;
        r0 = r7 - r0;
        r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r9);
        r5.measure(r6, r0);
    L_0x0066:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0032;
    L_0x006a:
        r0 = new java.lang.IllegalArgumentException;
        r1 = "DrawerLayout must be measured with MeasureSpec.EXACTLY.";
        r0.<init>(r1);
        throw r0;
    L_0x0072:
        r6 = m365c(r5);
        if (r6 == 0) goto L_0x00be;
    L_0x0078:
        r6 = r10.m366f(r5);
        r6 = r6 & 7;
        r7 = r6 & 0;
        if (r7 == 0) goto L_0x00a1;
    L_0x0082:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Child drawer has absolute gravity ";
        r1.<init>(r2);
        r2 = m364b(r6);
        r1 = r1.append(r2);
        r2 = " but this DrawerLayout already has a drawer view along that edge";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00a1:
        r6 = r10.f283f;
        r7 = r0.leftMargin;
        r6 = r6 + r7;
        r7 = r0.rightMargin;
        r6 = r6 + r7;
        r7 = r0.width;
        r6 = getChildMeasureSpec(r11, r6, r7);
        r7 = r0.topMargin;
        r8 = r0.bottomMargin;
        r7 = r7 + r8;
        r0 = r0.height;
        r0 = getChildMeasureSpec(r12, r7, r0);
        r5.measure(r6, r0);
        goto L_0x0066;
    L_0x00be:
        r0 = new java.lang.IllegalStateException;
        r1 = new java.lang.StringBuilder;
        r2 = "Child ";
        r1.<init>(r2);
        r1 = r1.append(r5);
        r2 = " at index ";
        r1 = r1.append(r2);
        r1 = r1.append(r3);
        r2 = " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x00e3:
        return;
    L_0x00e4:
        r1 = r0;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onMeasure(int, int):void");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f289l = true;
        int i5 = i3 - i;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (m367g(childAt)) {
                    childAt.layout(layoutParams.leftMargin, layoutParams.topMargin, layoutParams.leftMargin + childAt.getMeasuredWidth(), layoutParams.topMargin + childAt.getMeasuredHeight());
                } else {
                    int i7;
                    float f;
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (m371a(childAt, 3)) {
                        i7 = ((int) (((float) measuredWidth) * layoutParams.f275b)) + (-measuredWidth);
                        f = ((float) (measuredWidth + i7)) / ((float) measuredWidth);
                    } else {
                        i7 = i5 - ((int) (((float) measuredWidth) * layoutParams.f275b));
                        f = ((float) (i5 - i7)) / ((float) measuredWidth);
                    }
                    Object obj = f != layoutParams.f275b ? 1 : null;
                    int i8;
                    switch (layoutParams.f274a & 112) {
                        case 16:
                            int i9 = i4 - i2;
                            i8 = (i9 - measuredHeight) / 2;
                            if (i8 < layoutParams.topMargin) {
                                i8 = layoutParams.topMargin;
                            } else if (i8 + measuredHeight > i9 - layoutParams.bottomMargin) {
                                i8 = (i9 - layoutParams.bottomMargin) - measuredHeight;
                            }
                            childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
                            break;
                        case 80:
                            i8 = i4 - i2;
                            childAt.layout(i7, (i8 - layoutParams.bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i7, i8 - layoutParams.bottomMargin);
                            break;
                        default:
                            childAt.layout(i7, layoutParams.topMargin, measuredWidth + i7, measuredHeight + layoutParams.topMargin);
                            break;
                    }
                    if (obj != null) {
                        m360a(childAt, f);
                    }
                    int i10 = layoutParams.f275b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i10) {
                        childAt.setVisibility(i10);
                    }
                }
            }
        }
        this.f289l = false;
        this.f290m = false;
    }

    public void requestLayout() {
        if (!this.f289l) {
            super.requestLayout();
        }
    }

    public void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((LayoutParams) getChildAt(i).getLayoutParams()).f275b);
        }
        this.f285h = f;
        if ((this.f279a.m484b() | this.f280b.m484b()) != 0) {
            C0085w.m356a(this);
        }
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        int right;
        int height = getHeight();
        boolean g = m367g(view);
        int i = 0;
        int width = getWidth();
        int save = canvas.save();
        if (g) {
            int childCount = getChildCount();
            int i2 = 0;
            while (i2 < childCount) {
                View childAt = getChildAt(i2);
                if (childAt != view && childAt.getVisibility() == 0) {
                    Object obj;
                    Drawable background = childAt.getBackground();
                    if (background == null) {
                        obj = null;
                    } else if (background.getOpacity() == -1) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null && m365c(childAt) && childAt.getHeight() >= height) {
                        if (m371a(childAt, 3)) {
                            right = childAt.getRight();
                            if (right <= i) {
                                right = i;
                            }
                            i = right;
                            right = width;
                        } else {
                            right = childAt.getLeft();
                            if (right < width) {
                            }
                        }
                        i2++;
                        width = right;
                    }
                }
                right = width;
                i2++;
                width = right;
            }
            canvas.clipRect(i, 0, width, getHeight());
        }
        right = width;
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        if (this.f285h > 0.0f && g) {
            this.f286i.setColor((((int) (((float) ((this.f284g & -16777216) >>> 24)) * this.f285h)) << 24) | (this.f284g & 16777215));
            canvas.drawRect((float) i, 0.0f, (float) right, (float) getHeight(), this.f286i);
        } else if (this.f297t != null && m371a(view, 3)) {
            right = this.f297t.getIntrinsicWidth();
            i = view.getRight();
            r2 = Math.max(0.0f, Math.min(((float) i) / ((float) this.f279a.f324k), 1.0f));
            this.f297t.setBounds(i, view.getTop(), right + i, view.getBottom());
            this.f297t.setAlpha((int) (255.0f * r2));
            this.f297t.draw(canvas);
        } else if (this.f298u != null && m371a(view, 5)) {
            right = this.f298u.getIntrinsicWidth();
            i = view.getLeft();
            r2 = Math.max(0.0f, Math.min(((float) (getWidth() - i)) / ((float) this.f280b.f324k), 1.0f));
            this.f298u.setBounds(i - right, view.getTop(), i, view.getBottom());
            this.f298u.setAlpha((int) (255.0f * r2));
            this.f298u.draw(canvas);
        }
        return drawChild;
    }

    private static boolean m367g(View view) {
        return ((LayoutParams) view.getLayoutParams()).f274a == 0;
    }

    static boolean m365c(View view) {
        return (C0060a.m268a(((LayoutParams) view.getLayoutParams()).f274a, C0085w.m358b(view)) & 7) != 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r10) {
        /*
        r9 = this;
        r1 = 1;
        r2 = 0;
        r0 = android.support.v4.p003d.C0075m.m319a(r10);
        r3 = r9.f279a;
        r3 = r3.m481a(r10);
        r4 = r9.f280b;
        r4 = r4.m481a(r10);
        r4 = r4 | r3;
        switch(r0) {
            case 0: goto L_0x0039;
            case 1: goto L_0x00af;
            case 2: goto L_0x0060;
            case 3: goto L_0x00af;
            default: goto L_0x0016;
        };
    L_0x0016:
        r0 = r2;
    L_0x0017:
        if (r4 != 0) goto L_0x0037;
    L_0x0019:
        if (r0 != 0) goto L_0x0037;
    L_0x001b:
        r4 = r9.getChildCount();
        r3 = r2;
    L_0x0020:
        if (r3 >= r4) goto L_0x00bd;
    L_0x0022:
        r0 = r9.getChildAt(r3);
        r0 = r0.getLayoutParams();
        r0 = (android.support.v4.widget.DrawerLayout.LayoutParams) r0;
        r0 = r0.f276c;
        if (r0 == 0) goto L_0x00b8;
    L_0x0030:
        r0 = r1;
    L_0x0031:
        if (r0 != 0) goto L_0x0037;
    L_0x0033:
        r0 = r9.f282d;
        if (r0 == 0) goto L_0x0038;
    L_0x0037:
        r2 = r1;
    L_0x0038:
        return r2;
    L_0x0039:
        r0 = r10.getX();
        r3 = r10.getY();
        r9.f295r = r0;
        r9.f296s = r3;
        r5 = r9.f285h;
        r6 = 0;
        r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x00c0;
    L_0x004c:
        r5 = r9.f279a;
        r0 = (int) r0;
        r3 = (int) r3;
        r0 = r5.m476a(r0, r3);
        r0 = m367g(r0);
        if (r0 == 0) goto L_0x00c0;
    L_0x005a:
        r0 = r1;
    L_0x005b:
        r9.f293p = r2;
        r9.f282d = r2;
        goto L_0x0017;
    L_0x0060:
        r5 = r9.f279a;
        r0 = r5.f317d;
        r6 = r0.length;
        r0 = r2;
    L_0x0066:
        if (r0 >= r6) goto L_0x00ad;
    L_0x0068:
        r3 = r5.f321h;
        r7 = r1 << r0;
        r3 = r3 & r7;
        if (r3 == 0) goto L_0x00a4;
    L_0x006f:
        r3 = r1;
    L_0x0070:
        if (r3 == 0) goto L_0x00a8;
    L_0x0072:
        r3 = r5.f319f;
        r3 = r3[r0];
        r7 = r5.f317d;
        r7 = r7[r0];
        r3 = r3 - r7;
        r7 = r5.f320g;
        r7 = r7[r0];
        r8 = r5.f318e;
        r8 = r8[r0];
        r7 = r7 - r8;
        r3 = r3 * r3;
        r7 = r7 * r7;
        r3 = r3 + r7;
        r7 = r5.f315b;
        r8 = r5.f315b;
        r7 = r7 * r8;
        r7 = (float) r7;
        r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1));
        if (r3 <= 0) goto L_0x00a6;
    L_0x0091:
        r3 = r1;
    L_0x0092:
        if (r3 == 0) goto L_0x00aa;
    L_0x0094:
        r0 = r1;
    L_0x0095:
        if (r0 == 0) goto L_0x0016;
    L_0x0097:
        r0 = r9.f287j;
        r0.m384a();
        r0 = r9.f288k;
        r0.m384a();
        r0 = r2;
        goto L_0x0017;
    L_0x00a4:
        r3 = r2;
        goto L_0x0070;
    L_0x00a6:
        r3 = r2;
        goto L_0x0092;
    L_0x00a8:
        r3 = r2;
        goto L_0x0092;
    L_0x00aa:
        r0 = r0 + 1;
        goto L_0x0066;
    L_0x00ad:
        r0 = r2;
        goto L_0x0095;
    L_0x00af:
        r9.m370a(r1);
        r9.f293p = r2;
        r9.f282d = r2;
        goto L_0x0016;
    L_0x00b8:
        r0 = r3 + 1;
        r3 = r0;
        goto L_0x0020;
    L_0x00bd:
        r0 = r2;
        goto L_0x0031;
    L_0x00c0:
        r0 = r2;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.DrawerLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f279a.m483b(motionEvent);
        this.f280b.m483b(motionEvent);
        float x;
        float y;
        switch (motionEvent.getAction() & 255) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                this.f295r = x;
                this.f296s = y;
                this.f293p = false;
                this.f282d = false;
                break;
            case 1:
                boolean z;
                x = motionEvent.getX();
                y = motionEvent.getY();
                View a = this.f279a.m476a((int) x, (int) y);
                if (a != null && m367g(a)) {
                    x -= this.f295r;
                    y -= this.f296s;
                    int i = this.f279a.f315b;
                    if ((x * x) + (y * y) < ((float) (i * i))) {
                        View view;
                        int childCount = getChildCount();
                        for (i = 0; i < childCount; i++) {
                            View childAt = getChildAt(i);
                            if (((LayoutParams) childAt.getLayoutParams()).f277d) {
                                view = childAt;
                                if (view != null) {
                                    z = m368a(view) != 2;
                                    m370a(z);
                                    this.f293p = false;
                                    break;
                                }
                            }
                        }
                        view = null;
                        if (view != null) {
                            if (m368a(view) != 2) {
                            }
                            m370a(z);
                            this.f293p = false;
                        }
                    }
                }
                z = true;
                m370a(z);
                this.f293p = false;
            case 3:
                m370a(true);
                this.f293p = false;
                this.f282d = false;
                break;
        }
        return true;
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f293p = z;
        if (z) {
            m370a(true);
        }
    }

    public final void m370a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (m365c(childAt) && (!z || layoutParams.f276c)) {
                int width = childAt.getWidth();
                if (m371a(childAt, 3)) {
                    i |= this.f279a.m482a(childAt, -width, childAt.getTop());
                } else {
                    i |= this.f280b.m482a(childAt, getWidth(), childAt.getTop());
                }
                layoutParams.f276c = false;
            }
        }
        this.f287j.m384a();
        this.f288k.m384a();
        if (i != 0) {
            invalidate();
        }
    }

    public final void m372d(View view) {
        if (m365c(view)) {
            if (this.f290m) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.f275b = 1.0f;
                layoutParams.f277d = true;
            } else if (m371a(view, 3)) {
                this.f279a.m482a(view, 0, view.getTop());
            } else {
                this.f280b.m482a(view, getWidth() - view.getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public final void m373e(View view) {
        if (m365c(view)) {
            if (this.f290m) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                layoutParams.f275b = 0.0f;
                layoutParams.f277d = false;
            } else if (m371a(view, 3)) {
                this.f279a.m482a(view, -view.getWidth(), view.getTop());
            } else {
                this.f280b.m482a(view, getWidth(), view.getTop());
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    protected android.view.ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    protected android.view.ViewGroup.LayoutParams generateLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        return layoutParams instanceof MarginLayoutParams ? new LayoutParams((MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    protected boolean checkLayoutParams(android.view.ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public android.view.ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    private View m363b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m365c(childAt)) {
                if (m365c(childAt)) {
                    Object obj;
                    if (((LayoutParams) childAt.getLayoutParams()).f275b > 0.0f) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        return childAt;
                    }
                } else {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
            }
        }
        return null;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            boolean z;
            if (m363b() != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                C0068f.m302b(keyEvent);
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View b = m363b();
        if (b != null && m368a(b) == 0) {
            m370a(false);
        }
        if (b != null) {
            return true;
        }
        return false;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        C0087b c0087b = (C0087b) parcelable;
        super.onRestoreInstanceState(c0087b.getSuperState());
        if (c0087b.f301a != 0) {
            View a = m369a(c0087b.f301a);
            if (a != null) {
                m372d(a);
            }
        }
        setDrawerLockMode(c0087b.f302b, 3);
        setDrawerLockMode(c0087b.f303c, 5);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c0087b = new C0087b(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (m365c(childAt)) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f277d) {
                    c0087b.f301a = layoutParams.f274a;
                    break;
                }
            }
        }
        c0087b.f302b = this.f291n;
        c0087b.f303c = this.f292o;
        return c0087b;
    }

    public void addView(View view, int i, android.view.ViewGroup.LayoutParams layoutParams) {
        if (i > 0 || (i < 0 && getChildCount() > 0)) {
            C0085w.m359b(view, 4);
        } else {
            C0085w.m359b(view, 1);
        }
        super.addView(view, i, layoutParams);
    }
}
