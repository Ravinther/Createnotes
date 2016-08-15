package com.socialnmobile.colornote.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.PopupWindow;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0230t;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.p007e.C0262d;
import com.socialnmobile.colornote.p013g.C0309g;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

public class MonthView extends View implements OnCreateContextMenuListener {
    private static float f1872a;
    private static int f1873b;
    private static int f1874c;
    private static int f1875d;
    private static float f1876e;
    private static float f1877f;
    private static int f1878g;
    private static int f1879h;
    private static int f1880i;
    private static int f1881j;
    private static int f1882k;
    private static int f1883l;
    private static int f1884m;
    private static int f1885n;
    private static int f1886o;
    private static int f1887p;
    private static int f1888q;
    private static int f1889r;
    private static int f1890s;
    private static int f1891t;
    private static int f1892u;
    private static int f1893v;
    private static int f1894w;
    private static int f1895x;
    private static int f1896y;
    private static int f1897z;
    private aa f1898A;
    private ScreenCalendar f1899B;
    private int f1900C;
    private int f1901D;
    private boolean f1902E;
    private Paint f1903F;
    private Paint f1904G;
    private Path f1905H;
    private GestureDetector f1906I;
    private Time f1907J;
    private Time f1908K;
    private Time f1909L;
    private String f1910M;
    private Time f1911N;
    private Time f1912O;
    private Time f1913P;
    private Time f1914Q;
    private C0423n f1915R;
    private Drawable f1916S;
    private Drawable f1917T;
    private Drawable f1918U;
    private int f1919V;
    private Resources f1920W;
    private Rect f1921Z;
    private int aA;
    private ArrayList[] aB;
    private String[] aC;
    private boolean aD;
    private PopupWindow aa;
    private C0432z ab;
    private Bitmap ac;
    private Canvas ad;
    private int ae;
    private Rect af;
    private RectF ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private SparseArray ak;
    private int al;
    private int am;
    private int an;
    private Drawable ao;
    private int ap;
    private int aq;
    private int ar;
    private int as;
    private int at;
    private int au;
    private int av;
    private int aw;
    private int ax;
    private int ay;
    private int az;

    static {
        f1872a = 0.0f;
        f1873b = 24;
        f1874c = 0;
        f1875d = 0;
        f1876e = 0.0f;
        f1877f = 4.0f;
        f1878g = 15;
        f1879h = 18;
        f1880i = 10;
        f1881j = 12;
        f1882k = 17;
        f1883l = 15;
        f1884m = 3;
        f1885n = 31;
        f1886o = 1;
        f1887p = 0;
        f1888q = 3;
        f1889r = 6;
        f1890s = 4;
        f1891t = 4;
        f1892u = 4;
        f1893v = 0;
        f1894w = 0;
        f1895x = 8;
        f1896y = 10;
        f1897z = 50;
    }

    public MonthView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1905H = new Path();
        this.f1911N = new Time();
        this.f1912O = new Time();
        this.f1913P = new Time();
        this.f1914Q = new Time();
        this.f1921Z = new Rect();
        this.ab = new C0432z(this);
        this.ae = 1;
        this.af = new Rect();
        this.ag = new RectF();
        this.ai = false;
        this.aj = false;
        this.ak = new SparseArray(4);
        this.al = 0;
        this.aC = new String[32];
        if (f1872a == 0.0f) {
            float f = getContext().getResources().getDisplayMetrics().density;
            f1872a = f;
            if (f != 1.0f) {
                f1874c = (int) (((float) f1874c) * f1872a);
                f1875d = (int) (((float) f1875d) * f1872a);
                f1876e *= f1872a;
                f1878g = (int) (((float) f1878g) * f1872a);
                f1879h = (int) (((float) f1879h) * f1872a);
                f1880i = (int) (((float) f1880i) * f1872a);
                f1881j = (int) (((float) f1881j) * f1872a);
                f1882k = (int) (((float) f1882k) * f1872a);
                f1883l = (int) (((float) f1883l) * f1872a);
                f1884m = (int) (((float) f1884m) * f1872a);
                f1886o = (int) (((float) f1886o) * f1872a);
                f1887p = (int) (((float) f1887p) * f1872a);
                f1888q = (int) (((float) f1888q) * f1872a);
                f1897z = (int) (((float) f1897z) * f1872a);
                f1877f *= f1872a;
                f1889r = (int) (((float) f1889r) * f1872a);
                f1890s = (int) (((float) f1890s) * f1872a);
                f1896y = (int) (((float) f1896y) * f1872a);
                f1873b = (int) (((float) f1873b) * f1872a);
                f1891t = (int) (((float) f1891t) * f1872a);
                f1892u = (int) (((float) f1892u) * f1872a);
            }
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131361793);
        f1893v = dimensionPixelSize;
        f1894w = dimensionPixelSize;
        setFocusable(true);
        setClickable(true);
        setOnCreateContextMenuListener(this);
        this.f1908K = new Time();
        this.f1907J = new Time();
        this.f1907J.set(System.currentTimeMillis());
        setViewCalendar(this.f1907J);
        m2104b();
        this.f1920W = context.getResources();
        this.f1916S = this.f1920W.getDrawable(2130837650);
        this.f1917T = this.f1920W.getDrawable(2130837652);
        this.f1918U = this.f1920W.getDrawable(2130837651);
        this.ao = this.f1920W.getDrawable(2130837653);
        m2105c();
        this.f1906I = new GestureDetector(getContext(), new C0430x(this));
    }

    public final void m2102a() {
        this.f1907J = new Time();
        this.f1907J.set(System.currentTimeMillis());
    }

    public void setMonthNotes(ArrayList[] arrayListArr) {
        this.aB = arrayListArr;
    }

    public void setParent(ScreenCalendar screenCalendar) {
        this.f1899B = screenCalendar;
    }

    public void setOnDayClickListener(aa aaVar) {
        this.f1898A = aaVar;
    }

    public final void m2104b() {
        this.an = getFirstDayOfWeek();
        this.f1915R = new C0423n(this.f1908K.year, this.f1908K.month, this.f1908K.monthDay, m2093d(0, this.an));
        String j = C0212b.m950j(getContext());
        if ("".equals(j) || j == null) {
            this.aD = false;
        } else {
            this.aD = true;
        }
        if (this.aD) {
            j = C0212b.m951k(getContext());
            if (!j.equals(this.f1910M) || this.f1908K == null || this.f1909L == null || C0147f.m661a(this.f1908K, true) != C0147f.m661a(this.f1909L, true)) {
                this.f1909L = new Time(this.f1908K);
                this.f1910M = j;
                for (int i = 0; i < this.aC.length; i++) {
                    this.aC[i] = null;
                }
                this.f1914Q.set(this.f1908K);
                this.f1914Q.monthDay = 1;
                C0309g c0309g = new C0309g(getContext(), C0147f.m660a(this.f1914Q), 2);
                if (c0309g.f1367c == 1) {
                    this.aC[1] = c0309g.f1366b + "/1";
                }
                if (c0309g.f1367c <= 15) {
                    this.aC[(15 - c0309g.f1367c) + 1] = c0309g.f1366b + "/15";
                }
                Object[] a = new C0309g(getContext()).m1604a(c0309g.f1365a, c0309g.f1366b, c0309g.f1368d, new C0309g(getContext()).m1603a(c0309g.f1365a, c0309g.f1366b, c0309g.f1368d, 2));
                int intValue = ((Integer) a[0]).intValue();
                int intValue2 = ((Integer) a[1]).intValue();
                boolean booleanValue = ((Boolean) a[2]).booleanValue();
                long longValue = ((Long) a[3]).longValue();
                this.f1914Q.set(longValue);
                if (this.f1914Q.month == this.f1908K.month && this.f1914Q.monthDay < this.aC.length) {
                    this.aC[this.f1914Q.monthDay] = intValue2 + "/1";
                }
                if (this.f1914Q.month == this.f1908K.month && this.f1914Q.monthDay + 14 < this.aC.length) {
                    this.aC[this.f1914Q.monthDay + 14] = intValue2 + "/15";
                }
                if (this.f1914Q.monthDay + 14 < 18) {
                    Object[] a2 = new C0309g(getContext()).m1604a(intValue, intValue2, booleanValue, longValue);
                    ((Integer) a2[0]).intValue();
                    intValue2 = ((Integer) a2[1]).intValue();
                    ((Boolean) a2[2]).booleanValue();
                    this.f1914Q.set(((Long) a2[3]).longValue());
                    if (this.f1914Q.year == this.f1908K.year && this.f1914Q.month == this.f1908K.month && this.f1914Q.monthDay < this.aC.length) {
                        this.aC[this.f1914Q.monthDay] = intValue2 + "/1";
                    }
                }
            }
        }
    }

    public final void m2105c() {
        C0262d a = C0209d.m875a(getContext());
        this.ap = a.m1145n(3);
        this.aq = a.m1144m(0);
        this.ar = a.m1144m(1);
        this.as = a.m1144m(2);
        this.at = a.m1144m(3);
        this.au = a.m1144m(4);
        this.av = a.m1144m(5);
        this.aw = a.m1144m(6);
        this.aA = a.m1144m(7);
        this.ax = a.m1144m(8);
        this.ay = a.m1144m(9);
        this.az = a.m1144m(10);
        this.ae = 1;
        invalidate();
    }

    final int m2101a(int i) {
        int i2 = ((i - f1874c) - f1873b) / (f1874c + this.f1900C);
        if (i2 > 5) {
            return 5;
        }
        return i2;
    }

    final int m2103b(int i) {
        int i2 = (i - this.f1901D) / (f1875d + this.f1919V);
        if (i2 > 6) {
            return 6;
        }
        return i2;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        m2083a(i, i2);
        m2098f();
        this.ae = 1;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2098f();
        if (this.ac != null) {
            this.ac.recycle();
        }
    }

    protected void onDraw(Canvas canvas) {
        if (this.ae != 0) {
            if (this.ad == null) {
                m2083a(getWidth(), getHeight());
            }
            if (this.ad != null) {
                int i;
                Canvas canvas2 = this.ad;
                if (this.ae == 1) {
                    canvas2.drawColor(this.ap);
                }
                boolean z = getResources().getConfiguration().orientation == 2;
                Paint paint = new Paint();
                Rect rect = this.f1921Z;
                int columnOf = this.am - this.f1915R.getColumnOf(1);
                if (this.ae == 1) {
                    for (int i2 = 0; i2 < 7; i2++) {
                        i = this.f1901D + ((f1875d + this.f1919V) * i2);
                        rect.left = i;
                        rect.top = 0;
                        rect.right = i + this.f1919V;
                        rect.bottom = this.f1900C + 0;
                        if (i2 == 0) {
                            rect.left = 1;
                        } else if (i2 == 6) {
                            rect.right += this.f1901D + 2;
                        }
                        paint.setStyle(Style.FILL);
                        paint.setColor(this.ap);
                        canvas2.drawRect(rect, paint);
                        paint.setStyle(Style.FILL);
                        paint.setAntiAlias(true);
                        paint.setTypeface(null);
                        paint.setTextSize((float) f1878g);
                        if (m2092c(i2, this.an)) {
                            paint.setColor(this.aw);
                        } else if (m2090b(i2, this.an)) {
                            paint.setColor(this.av);
                        } else {
                            paint.setColor(this.at);
                        }
                        paint.setTextAlign(Align.LEFT);
                        canvas2.drawText(DateUtils.getDayOfWeekString(m2093d(i2, this.an), 20).toUpperCase(), (float) (rect.left + f1888q), (float) ((int) ((((float) rect.top) + paint.getTextSize()) + ((float) f1886o))), paint);
                    }
                }
                Paint paint2 = new Paint();
                int i3 = 0;
                while (i3 < 6) {
                    i = 0;
                    while (i < 7) {
                        if (this.ae == 1) {
                            m2084a(columnOf, i3, i, canvas2, paint2, rect, z);
                        } else if (this.ae == 2 && this.f1915R.m2220b(i3, i)) {
                            m2084a(columnOf, i3, i, canvas2, paint2, rect, z);
                        }
                        columnOf++;
                        i++;
                    }
                    i3++;
                }
                m2086a(canvas2, paint2);
                this.ae = 0;
            }
        }
        if (this.ac != null) {
            canvas.drawBitmap(this.ac, this.af, this.af, null);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1906I.onTouchEvent(motionEvent)) {
            return true;
        }
        if (motionEvent.getAction() == 3) {
            this.f1902E = false;
            if (this.al != 0) {
                this.al = 0;
                this.ae = 1;
                invalidate();
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    private void m2098f() {
        SparseArray sparseArray = this.ak;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            ((Bitmap) sparseArray.valueAt(i)).recycle();
        }
        sparseArray.clear();
    }

    private void m2086a(Canvas canvas, Paint paint) {
        int i;
        paint.setColor(this.aq);
        paint.setAntiAlias(false);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        for (i = 0; i < 6; i++) {
            int i2 = ((f1874c + ((f1874c + this.f1900C) * i)) - 1) + f1873b;
            float f = (float) i2;
            canvas.drawLine(0.0f, (float) i2, (float) measuredWidth, f, paint);
        }
        Canvas canvas2 = canvas;
        canvas2.drawLine(0.0f, (float) (measuredHeight - 1), (float) measuredWidth, (float) (measuredHeight - 1), paint);
        canvas.drawLine(0.0f, (float) (f1874c + f1873b), 0.0f, (float) measuredHeight, paint);
        canvas.drawLine((float) (measuredWidth - 1), (float) (f1874c + f1873b), (float) (measuredWidth - 1), (float) measuredHeight, paint);
        for (i = 1; i < 7; i++) {
            i2 = (this.f1901D + ((f1875d + this.f1919V) * i)) - 1;
            canvas.drawLine((float) i2, (float) (f1874c + f1873b), (float) i2, (float) measuredHeight, paint);
        }
    }

    private void m2084a(int i, int i2, int i3, Canvas canvas, Paint paint, Rect rect, boolean z) {
        int i4 = (i - this.am) + 1;
        boolean z2 = false;
        if (this.al != 0) {
            z2 = this.f1915R.m2220b(i2, i3);
        }
        boolean isWithinCurrentMonth = this.f1915R.isWithinCurrentMonth(i2, i3);
        Object obj = null;
        if (this.f1915R.getDayAt(i2, i3) == this.f1907J.monthDay && this.f1915R.getYear() == this.f1907J.year && this.f1915R.getMonth() == this.f1907J.month) {
            obj = 1;
        }
        int i5 = (f1874c + ((f1874c + this.f1900C) * i2)) + f1873b;
        int i6 = this.f1901D + ((f1875d + this.f1919V) * i3);
        rect.left = i6;
        rect.top = i5;
        rect.right = i6 + this.f1919V;
        rect.bottom = i5 + this.f1900C;
        if (i3 == 0) {
            rect.left = 1;
        } else if (i3 == 6) {
            rect.right = getWidth() - 1;
        }
        if (i2 == 5) {
            rect.bottom = getMeasuredHeight();
        }
        if (!isWithinCurrentMonth) {
            rect.top--;
            if (i3 != 0) {
                rect.left--;
            }
            paint.setStyle(Style.FILL);
            paint.setColor(this.aA);
            canvas.drawRect(rect, paint);
        } else if (z2) {
            if (this.al == 2) {
                this.f1916S.setBounds(rect);
                this.f1916S.draw(canvas);
            } else if (this.al == 1) {
                this.f1917T.setBounds(rect);
                this.f1917T.draw(canvas);
            } else {
                this.f1918U.setBounds(rect);
                this.f1918U.draw(canvas);
            }
            m2085a(i4, canvas, rect, paint);
            if (!this.ah) {
            }
        } else {
            if (m2092c(i3, this.an)) {
                paint.setStyle(Style.FILL);
                paint.setColor(this.az);
                canvas.drawRect(rect, paint);
            } else if (m2090b(i3, this.an)) {
                paint.setStyle(Style.FILL);
                paint.setColor(this.ay);
                canvas.drawRect(rect, paint);
            } else {
                paint.setStyle(Style.FILL);
                paint.setColor(this.ax);
                canvas.drawRect(rect, paint);
            }
            if (obj != null) {
                Drawable drawable = this.ao;
                drawable.setBounds(rect.left, rect.top, rect.right - 1, rect.bottom - 1);
                drawable.draw(canvas);
            }
            m2085a(i4, canvas, rect, paint);
        }
        paint.setStyle(Style.FILL);
        paint.setAntiAlias(true);
        paint.setTypeface(null);
        paint.setTextSize((float) f1879h);
        if (!isWithinCurrentMonth) {
            paint.setColor(this.as);
        } else if (obj != null && !z2) {
            paint.setColor(this.au);
        } else if (m2092c(i3, this.an)) {
            paint.setColor(this.aw);
        } else if (m2090b(i3, this.an)) {
            paint.setColor(this.av);
        } else {
            paint.setColor(this.at);
        }
        int i7 = f1888q + rect.left;
        i5 = (int) ((((float) rect.top) + paint.getTextSize()) + ((float) f1887p));
        canvas.drawText(String.valueOf(this.f1915R.getDayAt(i2, i3)), (float) i7, (float) i5, paint);
        if (this.aD && isWithinCurrentMonth && this.aC[i4] != null) {
            int i8;
            if (z) {
                i8 = f1880i;
            } else {
                i8 = f1881j;
            }
            paint.setTextSize((float) i8);
            canvas.drawText(this.aC[i4], (float) i7, (float) (i8 + i5), paint);
        }
    }

    private void m2085a(int i, Canvas canvas, Rect rect, Paint paint) {
        Style style = paint.getStyle();
        int color = paint.getColor();
        ArrayList arrayList = this.aB[i];
        Iterator it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3;
            RectF rectF;
            C0230t c0230t = (C0230t) it.next();
            int size = arrayList.size();
            int i4 = i2 + 1;
            int e = C0209d.m875a(getContext()).m1136e(c0230t.f1011j);
            boolean a = c0230t.m1059a();
            int i5 = f1895x / 2;
            int i6 = (rect.bottom - f1892u) - f1893v;
            int i7 = (rect.right - f1891t) - ((f1894w + 1) * i5);
            int i8 = (rect.bottom - f1892u) - 1;
            int i9 = (((rect.right - f1891t) - i7) - ((i5 - 1) * 2)) / i5;
            if (size > i5) {
                if (i2 < i5) {
                    i8 = ((rect.bottom - (f1892u * 2)) - f1893v) - 1;
                    i3 = (rect.bottom - (f1892u * 2)) - (f1893v * 2);
                    i6 = i2;
                    i2 = i3;
                } else if (i2 >= i5) {
                    i3 = i6;
                    i6 = i2 - i5;
                    i2 = i3;
                }
                paint.setColor(e);
                paint.setStyle(Style.FILL);
                rectF = this.ag;
                rectF.left = (float) ((((i9 + 2) * i6) + i7) + 1);
                rectF.right = (float) (((i6 + 1) * (i9 + 2)) + i7);
                rectF.bottom = (float) i8;
                rectF.top = (float) i2;
                canvas.drawRect(rectF, paint);
                if (this.f1903F == null) {
                    this.f1903F = new Paint();
                    this.f1903F.setStyle(Style.STROKE);
                    this.f1903F.setStrokeWidth(0.0f);
                    this.f1903F.setPathEffect(null);
                    this.f1903F.setColorFilter(null);
                    this.f1903F.setDither(false);
                }
                this.f1903F.setColor(this.aq);
                if (this.f1904G == null) {
                    this.f1904G = new Paint();
                    this.f1904G.setStyle(Style.STROKE);
                    this.f1904G.setStrokeWidth(2.0f);
                    this.f1904G.setPathEffect(null);
                    this.f1904G.setColorFilter(null);
                    this.f1904G.setDither(false);
                }
                this.f1904G.setColor(this.ar);
                canvas.drawLine(rectF.left, rectF.top, rectF.right, rectF.top, this.f1903F);
                canvas.drawLine(rectF.left, rectF.bottom - 1.0f, rectF.right, rectF.bottom - 1.0f, this.f1903F);
                canvas.drawLine(rectF.left, rectF.top, rectF.left, rectF.bottom, this.f1903F);
                canvas.drawLine(rectF.right - 1.0f, rectF.top, rectF.right - 1.0f, rectF.bottom, this.f1903F);
                if (a) {
                    canvas.drawLine(rectF.left, 1.0f + rectF.top, rectF.right, rectF.bottom - 1.0f, this.f1904G);
                    canvas.drawLine(rectF.left, rectF.bottom - 1.0f, rectF.right, 1.0f + rectF.top, this.f1904G);
                }
                if (i4 >= f1895x) {
                    break;
                }
                i2 = i4;
            }
            i3 = i6;
            i6 = i2;
            i2 = i3;
            paint.setColor(e);
            paint.setStyle(Style.FILL);
            rectF = this.ag;
            rectF.left = (float) ((((i9 + 2) * i6) + i7) + 1);
            rectF.right = (float) (((i6 + 1) * (i9 + 2)) + i7);
            rectF.bottom = (float) i8;
            rectF.top = (float) i2;
            canvas.drawRect(rectF, paint);
            if (this.f1903F == null) {
                this.f1903F = new Paint();
                this.f1903F.setStyle(Style.STROKE);
                this.f1903F.setStrokeWidth(0.0f);
                this.f1903F.setPathEffect(null);
                this.f1903F.setColorFilter(null);
                this.f1903F.setDither(false);
            }
            this.f1903F.setColor(this.aq);
            if (this.f1904G == null) {
                this.f1904G = new Paint();
                this.f1904G.setStyle(Style.STROKE);
                this.f1904G.setStrokeWidth(2.0f);
                this.f1904G.setPathEffect(null);
                this.f1904G.setColorFilter(null);
                this.f1904G.setDither(false);
            }
            this.f1904G.setColor(this.ar);
            canvas.drawLine(rectF.left, rectF.top, rectF.right, rectF.top, this.f1903F);
            canvas.drawLine(rectF.left, rectF.bottom - 1.0f, rectF.right, rectF.bottom - 1.0f, this.f1903F);
            canvas.drawLine(rectF.left, rectF.top, rectF.left, rectF.bottom, this.f1903F);
            canvas.drawLine(rectF.right - 1.0f, rectF.top, rectF.right - 1.0f, rectF.bottom, this.f1903F);
            if (a) {
                canvas.drawLine(rectF.left, 1.0f + rectF.top, rectF.right, rectF.bottom - 1.0f, this.f1904G);
                canvas.drawLine(rectF.left, rectF.bottom - 1.0f, rectF.right, 1.0f + rectF.top, this.f1904G);
            }
            if (i4 >= f1895x) {
                break;
            }
            i2 = i4;
        }
        paint.setStyle(style);
        paint.setColor(color);
    }

    public void setTime(Time time) {
        this.f1911N.set(time);
        m2102a();
        setViewCalendar(time);
        m2104b();
        this.ae = 1;
        invalidate();
    }

    void setViewCalendar(Time time) {
        this.f1908K.set(time);
        this.f1908K.monthDay = 1;
        this.f1908K.hour = 0;
        this.f1908K.minute = 0;
        this.f1908K.second = 0;
        this.am = Time.getJulianDay(C0147f.m660a(this.f1908K), this.f1908K.gmtoff);
    }

    public Time getSelectedTime() {
        int i;
        Time time = this.f1913P;
        time.set(this.f1908K);
        int i2 = time.month;
        C0423n c0423n = this.f1915R;
        if (c0423n.isWithinCurrentMonth(c0423n.f2189a, c0423n.f2190b)) {
            i = 0;
        } else if (c0423n.f2189a == 0) {
            i = -1;
        } else {
            i = 1;
        }
        time.month = i + i2;
        time.monthDay = this.f1915R.m2217a();
        time.second = this.f1911N.second;
        time.minute = this.f1911N.minute;
        time.hour = this.f1911N.hour;
        C0147f.m660a(time);
        return time;
    }

    public long getSelectedTimeInMillis() {
        return C0147f.m661a(getSelectedTime(), true);
    }

    public Time getTime() {
        return this.f1908K;
    }

    public int getSelectionMode() {
        return this.al;
    }

    public void setSelectionMode(int i) {
        this.al = i;
    }

    private void m2083a(int i, int i2) {
        this.f1900C = ((i2 - f1873b) - (f1874c * 6)) / 6;
        this.f1919V = (i - (f1875d * 6)) / 7;
        this.f1901D = ((i - ((this.f1919V + f1875d) * 6)) - this.f1919V) / 2;
        if ((this.ac == null || this.ac.isRecycled() || this.ac.getHeight() != i2 || this.ac.getWidth() != i) && i > 0 && i2 > 0) {
            if (this.ac != null) {
                this.ac.recycle();
            }
            this.ac = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            this.ad = new Canvas(this.ac);
        }
        this.af.top = 0;
        this.af.bottom = i2;
        this.af.left = 0;
        this.af.right = i;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        switch (i) {
            case 23:
                if (this.al == 1) {
                    if (this.f1898A != null) {
                        this.f1898A.m2157a(getSelectedTime());
                    }
                    this.al = 0;
                    this.ae = 2;
                    invalidate();
                    break;
                }
                break;
        }
        return super.onKeyUp(i, keyEvent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.al == 0 && (i == 66 || i == 22 || i == 21 || i == 19 || i == 20 || i == 23)) {
            this.al = 2;
            this.ae = 1;
            invalidate();
            return true;
        }
        Time time;
        boolean z;
        this.al = 2;
        Time time2 = null;
        switch (i) {
            case 19:
                if (this.f1915R.m2219b()) {
                    time2 = this.f1912O;
                    time2.set(this.f1908K);
                    time2.month--;
                    time2.monthDay = this.f1915R.m2217a();
                    this.f1915R.m2221c();
                }
                time = time2;
                z = true;
                break;
            case 20:
                if (this.f1915R.m2221c()) {
                    time2 = this.f1912O;
                    time2.set(this.f1908K);
                    time2.month++;
                    time2.monthDay = this.f1915R.m2217a();
                    this.f1915R.m2219b();
                }
                time = time2;
                z = true;
                break;
            case 21:
                if (this.f1915R.m2222d()) {
                    time2 = this.f1912O;
                    time2.set(this.f1908K);
                    time2.month--;
                    time2.monthDay = this.f1915R.m2217a();
                    this.f1915R.m2223e();
                }
                time = time2;
                z = true;
                break;
            case 22:
                if (this.f1915R.m2223e()) {
                    time2 = this.f1912O;
                    time2.set(this.f1908K);
                    time2.month++;
                    time2.monthDay = this.f1915R.m2217a();
                    this.f1915R.m2222d();
                }
                time = time2;
                z = true;
                break;
            case 23:
                this.al = 1;
                this.ae = 1;
                invalidate();
                return true;
            case 66:
                if (this.f1898A != null) {
                    this.f1898A.m2157a(getSelectedTime());
                }
                return true;
            default:
                z = false;
                time = null;
                break;
        }
        if (time != null) {
            C0147f.m660a(time);
            this.f1899B.m2131a(time);
            return z;
        } else if (!z) {
            return z;
        } else {
            this.ae = 1;
            invalidate();
            return z;
        }
    }

    private static boolean m2090b(int i, int i2) {
        if (i2 == 0 && i == 6) {
            return true;
        }
        if (i2 == 1 && i == 5) {
            return true;
        }
        return i2 == 6 && i == 0;
    }

    private static boolean m2092c(int i, int i2) {
        if (i2 == 0 && i == 0) {
            return true;
        }
        if (i2 == 1 && i == 6) {
            return true;
        }
        return i2 == 6 && i == 1;
    }

    public int getFirstDayOfWeek() {
        String string = PreferenceManager.getDefaultSharedPreferences(getContext()).getString("pref_first_day_of_week", null);
        if (string != null) {
            return Integer.valueOf(string).intValue();
        }
        int firstDayOfWeek = Calendar.getInstance().getFirstDayOfWeek();
        if (firstDayOfWeek == 7) {
            return 6;
        }
        if (firstDayOfWeek == 2) {
            return 1;
        }
        return 0;
    }

    private static int m2093d(int i, int i2) {
        int i3 = 0;
        if (i2 == 0) {
            i3 = i + 1;
        } else if (i2 == 1) {
            i3 = i + 2;
        } else if (i2 == 6) {
            i3 = i + 7;
        }
        if (i3 > 7) {
            return i3 % 7;
        }
        return i3;
    }

    public final void m2106d() {
        this.ae = 1;
        invalidate();
    }
}
