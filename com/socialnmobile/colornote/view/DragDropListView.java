package com.socialnmobile.colornote.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0212b;

public class DragDropListView extends ListView {
    private ImageView f1831a;
    private WindowManager f1832b;
    private LayoutParams f1833c;
    private int f1834d;
    private int f1835e;
    private int f1836f;
    private int f1837g;
    private C0425p f1838h;
    private C0275q f1839i;
    private C0276r f1840j;
    private int f1841k;
    private int f1842l;
    private int f1843m;
    private GestureDetector f1844n;
    private int f1845o;
    private Rect f1846p;
    private Rect f1847q;
    private Bitmap f1848r;
    private final int f1849s;
    private int f1850t;
    private int f1851u;
    private GradientDrawable f1852v;
    private int f1853w;
    private int f1854x;

    public DragDropListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1845o = -1;
        this.f1846p = new Rect();
        this.f1847q = new Rect();
        this.f1845o = -1;
        this.f1849s = ViewConfiguration.get(context).getScaledTouchSlop();
        getResources();
        this.f1850t = C0212b.m944d(context) / 2;
        this.f1851u = C0212b.m944d(context);
        this.f1852v = (GradientDrawable) getResources().getDrawable(2130837551).mutate();
    }

    public void setColor(int i) {
        this.f1852v.setColor(C0209d.m875a(getContext()).m1135d(i));
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f1840j != null && this.f1844n == null && this.f1845o == 0) {
            this.f1844n = new GestureDetector(getContext(), new C0424o(this));
        }
        if (!(this.f1838h == null && this.f1839i == null)) {
            switch (motionEvent.getAction()) {
                case 0:
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    int pointToPosition = pointToPosition(x, y);
                    if (pointToPosition != -1) {
                        View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                        if (childAt instanceof ViewGroup) {
                            ViewGroup viewGroup = (ViewGroup) childAt;
                            View findViewById = viewGroup.findViewById(2131624107);
                            if (findViewById != null) {
                                this.f1836f = y - viewGroup.getTop();
                                if (this.f1836f > this.f1851u) {
                                    this.f1836f = this.f1851u;
                                }
                                this.f1837g = ((int) motionEvent.getRawY()) - y;
                                Rect rect = this.f1846p;
                                findViewById.getDrawingRect(rect);
                                if (x >= rect.right + 5) {
                                    m2069a();
                                    break;
                                }
                                Bitmap drawingCache;
                                viewGroup.setDrawingCacheEnabled(true);
                                viewGroup.invalidate();
                                Bitmap drawingCache2 = viewGroup.getDrawingCache();
                                if (drawingCache2 == null) {
                                    viewGroup.setDrawingCacheEnabled(true);
                                    viewGroup.invalidate();
                                    drawingCache = viewGroup.getDrawingCache();
                                    if (drawingCache == null) {
                                        drawingCache = Bitmap.createBitmap(getWidth(), this.f1851u, Config.ARGB_4444);
                                        drawingCache.eraseColor(-1);
                                    } else {
                                        drawingCache = Bitmap.createBitmap(drawingCache, 0, 0, drawingCache.getWidth(), this.f1851u);
                                    }
                                } else {
                                    drawingCache = Bitmap.createBitmap(drawingCache2, 0, 0, drawingCache2.getWidth(), this.f1851u);
                                }
                                m2069a();
                                this.f1833c = new LayoutParams();
                                this.f1833c.gravity = 48;
                                this.f1833c.x = 0;
                                this.f1833c.y = (y - this.f1836f) + this.f1837g;
                                this.f1833c.height = -2;
                                this.f1833c.width = -2;
                                this.f1833c.flags = 920;
                                this.f1833c.format = -3;
                                this.f1833c.windowAnimations = 0;
                                Context context = getContext();
                                findViewById = new ImageView(context);
                                findViewById.setBackgroundColor(context.getResources().getColor(2131492865));
                                findViewById.setImageBitmap(drawingCache);
                                this.f1848r = drawingCache;
                                this.f1832b = (WindowManager) context.getSystemService("window");
                                this.f1832b.addView(findViewById, this.f1833c);
                                this.f1831a = findViewById;
                                this.f1834d = pointToPosition;
                                this.f1835e = this.f1834d;
                                this.f1843m = getHeight();
                                int i = this.f1849s;
                                this.f1841k = Math.min(y - i, this.f1843m / 3);
                                this.f1842l = Math.max(i + y, (this.f1843m * 2) / 3);
                                return false;
                            }
                        }
                    }
                    break;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private int m2067a(int i, int i2) {
        int a;
        if (i2 < 0) {
            a = m2067a(i, 0);
            if (a > 0) {
                return a;
            }
            return 0;
        }
        Rect rect = this.f1846p;
        Rect rect2 = this.f1847q;
        for (a = getChildCount() - 1; a >= 0; a--) {
            View childAt = getChildAt(a);
            View findViewById = childAt.findViewById(2131624104);
            childAt.getHitRect(rect);
            findViewById.getHitRect(rect2);
            rect.top = rect2.top + rect.top;
            childAt.getHitRect(rect2);
            if (rect.contains(i, i2)) {
                return a + getFirstVisiblePosition();
            }
            if (rect2.contains(i, i2)) {
                return (a + getFirstVisiblePosition()) - 1;
            }
        }
        return -1;
    }

    private void m2070a(boolean z) {
        int i = 0;
        while (true) {
            View childAt = getChildAt(i);
            if (childAt == null) {
                if (z) {
                    int firstVisiblePosition = getFirstVisiblePosition();
                    int top = getChildAt(0).getTop();
                    setAdapter(getAdapter());
                    setSelectionFromTop(firstVisiblePosition, top);
                }
                layoutChildren();
                childAt = getChildAt(i);
                if (childAt == null) {
                    return;
                }
            }
            ((C0414e) childAt.getTag()).m2211a(false, null);
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f1844n != null) {
            this.f1844n.onTouchEvent(motionEvent);
        }
        if ((this.f1838h == null && this.f1839i == null) || this.f1831a == null) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        switch (action) {
            case 0:
            case 2:
                int width;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (this.f1845o == 1) {
                    float f = 1.0f;
                    width = this.f1831a.getWidth();
                    if (x > width / 2) {
                        f = ((float) (width - x)) / ((float) (width / 2));
                    }
                    this.f1833c.alpha = f;
                }
                if (this.f1845o == 0) {
                    this.f1833c.x = x;
                }
                this.f1833c.y = (y - this.f1836f) + this.f1837g;
                this.f1832b.updateViewLayout(this.f1831a, this.f1833c);
                x = (y - this.f1836f) - this.f1850t;
                int a = m2067a(0, x);
                if (a >= 0) {
                    if (a <= this.f1835e) {
                        a++;
                    }
                } else if (x < 0) {
                    a = 0;
                }
                x = getFirstVisiblePosition();
                width = getChildCount();
                if (a < 0) {
                    return true;
                }
                if (!(action != 0 && a == this.f1834d && this.f1853w == x && x + width == this.f1853w + this.f1854x)) {
                    this.f1853w = x;
                    this.f1854x = width;
                    this.f1834d = a;
                    if (this.f1834d > (getCount() - 1) - 1) {
                        this.f1834d = (getCount() - 1) - 1;
                    }
                    a = this.f1834d - getFirstVisiblePosition();
                    if (this.f1834d > this.f1835e) {
                        action = a + 1;
                    } else {
                        action = a;
                    }
                    View childAt = getChildAt(this.f1835e - getFirstVisiblePosition());
                    x = 0;
                    while (true) {
                        View childAt2 = getChildAt(x);
                        if (childAt2 != null) {
                            C0414e c0414e = (C0414e) childAt2.getTag();
                            if (childAt2.equals(childAt)) {
                                c0414e.f2151e.setVisibility(8);
                                c0414e.f2149c.setVisibility(0);
                                c0414e.f2150d.setVisibility(8);
                                if (this.f1834d == this.f1835e) {
                                    a = -2;
                                } else {
                                    a = 1;
                                }
                                C0313j.m1648a(childAt2, a);
                            } else if (x != action) {
                                c0414e.m2211a(false, null);
                            } else if (this.f1834d < (getCount() - 1) + 1) {
                                c0414e.m2211a(true, this.f1852v);
                            }
                            x++;
                        }
                    }
                }
                if (y >= this.f1843m / 3) {
                    this.f1841k = this.f1843m / 3;
                }
                if (y <= (this.f1843m * 2) / 3) {
                    this.f1842l = (this.f1843m * 2) / 3;
                }
                if (y > this.f1842l) {
                    action = y > (this.f1843m + this.f1842l) / 2 ? 16 : 4;
                } else if (y < this.f1841k) {
                    action = y < this.f1841k / 2 ? -16 : -4;
                } else {
                    action = 0;
                }
                if (action == 0) {
                    return true;
                }
                a = pointToPosition(0, this.f1843m / 2);
                if (a == -1) {
                    a = pointToPosition(0, (this.f1843m / 2) + getDividerHeight());
                }
                if (a == -1) {
                    a = pointToPosition(0, (this.f1843m / 2) + this.f1851u);
                }
                View childAt3 = getChildAt(a - getFirstVisiblePosition());
                if (childAt3 == null) {
                    return true;
                }
                setSelectionFromTop(a, childAt3.getTop() - action);
                return true;
            case 1:
            case 3:
                Rect rect = this.f1846p;
                this.f1831a.getDrawingRect(rect);
                m2069a();
                if (this.f1845o != 1 || motionEvent.getX() <= ((float) ((rect.right * 3) / 4))) {
                    if (this.f1839i != null && this.f1834d >= 0 && this.f1834d < getCount()) {
                        this.f1839i.m1570a(this.f1835e, this.f1834d);
                    }
                    m2070a(false);
                    return true;
                }
                if (this.f1840j != null) {
                    this.f1840j.m1572a(this.f1835e);
                }
                m2070a(true);
                return true;
            default:
                return true;
        }
    }

    private void m2069a() {
        if (this.f1831a != null) {
            this.f1831a.setVisibility(8);
            ((WindowManager) getContext().getSystemService("window")).removeView(this.f1831a);
            this.f1831a.setImageDrawable(null);
            this.f1831a = null;
        }
        if (this.f1848r != null) {
            this.f1848r.recycle();
            this.f1848r = null;
        }
    }

    public void setDragListener(C0425p c0425p) {
        this.f1838h = c0425p;
    }

    public void setDropListener(C0275q c0275q) {
        this.f1839i = c0275q;
    }

    public void setRemoveListener(C0276r c0276r) {
        this.f1840j = c0276r;
    }
}
