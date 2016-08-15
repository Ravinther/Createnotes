package com.socialnmobile.colornote.menu;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.PopupWindow;

/* renamed from: com.socialnmobile.colornote.menu.c */
public final class C0318c {
    PopupWindow f1396a;
    ListAdapter f1397b;
    C0320e f1398c;
    int f1399d;
    int f1400e;
    DataSetObserver f1401f;
    View f1402g;
    OnItemClickListener f1403h;
    final C0325j f1404i;
    Handler f1405j;
    Rect f1406k;
    boolean f1407l;
    private Context f1408m;
    private int f1409n;
    private int f1410o;
    private int f1411p;
    private boolean f1412q;
    private View f1413r;
    private int f1414s;
    private Drawable f1415t;
    private OnItemSelectedListener f1416u;
    private final C0324i f1417v;
    private final C0323h f1418w;
    private final C0321f f1419x;
    private boolean f1420y;

    public C0318c(Context context, boolean z) {
        this.f1409n = -2;
        this.f1399d = -2;
        this.f1400e = Integer.MAX_VALUE;
        this.f1414s = 0;
        this.f1404i = new C0325j();
        this.f1417v = new C0324i();
        this.f1418w = new C0323h();
        this.f1419x = new C0321f();
        this.f1405j = new Handler();
        this.f1406k = new Rect();
        this.f1408m = context;
        this.f1396a = new PopupWindow(context, null, 2130771968);
        this.f1396a.setInputMethodMode(1);
        this.f1420y = z;
    }

    public final void m1692a() {
        int measuredHeight;
        int i;
        int i2;
        int i3 = 0;
        int i4 = -1;
        View linearLayout;
        LayoutParams layoutParams;
        if (this.f1398c == null) {
            Context context = this.f1408m;
            this.f1398c = new C0320e(context, !this.f1407l);
            if (this.f1415t != null) {
                this.f1398c.setSelector(this.f1415t);
            }
            this.f1398c.setAdapter(this.f1397b);
            this.f1398c.setOnItemClickListener(this.f1403h);
            this.f1398c.setFocusable(true);
            this.f1398c.setFocusableInTouchMode(true);
            this.f1398c.setOnItemSelectedListener(new C0319d(this));
            this.f1398c.setOnScrollListener(this.f1418w);
            if (this.f1416u != null) {
                this.f1398c.setOnItemSelectedListener(this.f1416u);
            }
            View view = this.f1398c;
            View view2 = this.f1413r;
            if (view2 != null) {
                linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f1414s) {
                    case 0:
                        linearLayout.addView(view2);
                        linearLayout.addView(view, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view, layoutParams2);
                        linearLayout.addView(view2);
                        break;
                }
                view2.measure(MeasureSpec.makeMeasureSpec(this.f1399d, Integer.MIN_VALUE), 0);
                layoutParams = (LayoutParams) view2.getLayoutParams();
                measuredHeight = layoutParams.bottomMargin + (view2.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                linearLayout = view;
                measuredHeight = 0;
            }
            this.f1396a.setContentView(linearLayout);
        } else {
            this.f1396a.getContentView();
            linearLayout = this.f1413r;
            if (linearLayout != null) {
                layoutParams = (LayoutParams) linearLayout.getLayoutParams();
                measuredHeight = layoutParams.bottomMargin + (linearLayout.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.f1396a.getBackground();
        if (background != null) {
            background.getPadding(this.f1406k);
            i = this.f1406k.top + this.f1406k.bottom;
            if (!this.f1412q) {
                this.f1411p = -this.f1406k.top;
            }
        } else {
            i = 0;
        }
        boolean z = this.f1396a.getInputMethodMode() == 2;
        View view3 = this.f1402g;
        int i5 = this.f1411p;
        Rect rect = new Rect();
        view3.getWindowVisibleDisplayFrame(rect);
        int[] iArr = new int[2];
        view3.getLocationOnScreen(iArr);
        int i6 = rect.bottom;
        if (z) {
            i2 = view3.getContext().getResources().getDisplayMetrics().heightPixels;
        } else {
            i2 = i6;
        }
        i2 = Math.max((i2 - (iArr[1] + view3.getHeight())) - i5, (iArr[1] - rect.top) + i5);
        if (this.f1396a.getBackground() != null) {
            this.f1396a.getBackground().getPadding(this.f1406k);
            i2 -= this.f1406k.top + this.f1406k.bottom;
        }
        if (this.f1409n == -1) {
            measuredHeight = i2 + i;
        } else {
            i2 = m1691a(i2 - measuredHeight);
            if (i2 > 0) {
                measuredHeight += i;
            }
            measuredHeight += i2;
        }
        boolean d = m1695d();
        if (this.f1396a.isShowing()) {
            if (this.f1399d == -1) {
                i2 = -1;
            } else if (this.f1399d == -2) {
                i2 = this.f1402g.getWidth();
            } else {
                i2 = this.f1399d;
            }
            if (this.f1409n == -1) {
                if (d) {
                    i6 = measuredHeight;
                } else {
                    i6 = -1;
                }
                PopupWindow popupWindow;
                if (d) {
                    popupWindow = this.f1396a;
                    if (this.f1399d != -1) {
                        i4 = 0;
                    }
                    popupWindow.setWindowLayoutMode(i4, 0);
                } else {
                    popupWindow = this.f1396a;
                    if (this.f1399d == -1) {
                        i3 = -1;
                    }
                    popupWindow.setWindowLayoutMode(i3, -1);
                }
            } else if (this.f1409n == -2) {
                i6 = measuredHeight;
            } else {
                i6 = this.f1409n;
            }
            this.f1396a.setOutsideTouchable(true);
            this.f1396a.update(this.f1402g, this.f1410o, this.f1411p, i2, i6);
            return;
        }
        if (this.f1399d == -1) {
            i = -1;
        } else if (this.f1399d == -2) {
            this.f1396a.setWidth(this.f1402g.getWidth());
            i = 0;
        } else {
            this.f1396a.setWidth(this.f1399d);
            i = 0;
        }
        if (this.f1409n == -1) {
            i3 = -1;
        } else if (this.f1409n == -2) {
            this.f1396a.setHeight(measuredHeight);
        } else {
            this.f1396a.setHeight(this.f1409n);
        }
        this.f1396a.setWindowLayoutMode(i, i3);
        this.f1396a.setOutsideTouchable(true);
        this.f1396a.setTouchInterceptor(this.f1417v);
        this.f1396a.showAsDropDown(this.f1402g, this.f1410o, this.f1411p);
        this.f1398c.setSelection(-1);
        if (!this.f1407l || this.f1398c.isInTouchMode()) {
            m1694c();
        }
        if (!this.f1407l) {
            this.f1405j.post(this.f1419x);
        }
    }

    public final void m1693b() {
        this.f1396a.dismiss();
        if (this.f1413r != null) {
            ViewParent parent = this.f1413r.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f1413r);
            }
        }
        this.f1396a.setContentView(null);
        this.f1398c = null;
        this.f1405j.removeCallbacks(this.f1404i);
    }

    public final void m1694c() {
        C0320e c0320e = this.f1398c;
        if (c0320e != null) {
            c0320e.f1422a = true;
            c0320e.requestLayout();
        }
    }

    final boolean m1695d() {
        return this.f1396a.getInputMethodMode() == 2;
    }

    private int m1691a(int i) {
        ListAdapter listAdapter = this.f1397b;
        if (listAdapter == null) {
            return this.f1398c.getListPaddingTop() + this.f1398c.getListPaddingBottom();
        }
        int listPaddingTop = this.f1398c.getListPaddingTop() + this.f1398c.getListPaddingBottom();
        int dividerHeight = (this.f1398c.getDividerHeight() <= 0 || this.f1398c.getDivider() == null) ? 0 : this.f1398c.getDividerHeight();
        int count = listAdapter.getCount() - 1;
        for (int i2 = 0; i2 <= count; i2++) {
            View view = this.f1397b.getView(i2, null, this.f1398c);
            if (this.f1398c.getCacheColorHint() != 0) {
                view.setDrawingCacheBackgroundColor(this.f1398c.getCacheColorHint());
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
                view.setLayoutParams(layoutParams);
            }
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(0, this.f1398c.getPaddingLeft() + this.f1398c.getPaddingRight(), layoutParams.width);
            int i3 = layoutParams.height;
            if (i3 > 0) {
                i3 = MeasureSpec.makeMeasureSpec(i3, 1073741824);
            } else {
                i3 = MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(childMeasureSpec, i3);
            if (i2 > 0) {
                i3 = listPaddingTop + dividerHeight;
            } else {
                i3 = listPaddingTop;
            }
            listPaddingTop = view.getMeasuredHeight() + i3;
            if (listPaddingTop >= i) {
                return i;
            }
        }
        return listPaddingTop;
    }
}
