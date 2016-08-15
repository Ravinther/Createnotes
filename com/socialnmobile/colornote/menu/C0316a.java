package com.socialnmobile.colornote.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.p007e.C0262d;
import com.socialnmobile.colornote.view.MyImageButton;
import com.socialnmobile.colornote.view.ab;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.socialnmobile.colornote.menu.a */
public final class C0316a implements OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener, ab {
    private Context f1381a;
    private LayoutInflater f1382b;
    private C0318c f1383c;
    private int f1384d;
    private View f1385e;
    private boolean f1386f;
    private ViewTreeObserver f1387g;
    private C0317b f1388h;
    private ViewGroup f1389i;
    private C0164q f1390j;
    private ArrayList f1391k;
    private ArrayList f1392l;

    public C0316a(Context context, View view, C0273k c0273k) {
        this(context, view, c0273k.m1210M().f1431c, c0273k, (byte) 0);
        c0273k.m1213b(c0273k.m1210M());
    }

    public C0316a(Context context, View view, ArrayList arrayList, C0164q c0164q) {
        this(context, view, arrayList, c0164q, (byte) 0);
    }

    private C0316a(Context context, View view, ArrayList arrayList, C0164q c0164q, byte b) {
        this.f1381a = context;
        this.f1382b = LayoutInflater.from(context);
        this.f1386f = false;
        this.f1391k = arrayList;
        this.f1390j = c0164q;
        context.getResources();
        this.f1384d = C0313j.m1664c(context, 260);
        this.f1385e = view;
    }

    public final void m1687a() {
        boolean z = true;
        C0262d a = C0209d.m875a(this.f1381a);
        this.f1383c = new C0318c(this.f1381a, a.m1131a());
        this.f1383c.f1396a.setOnDismissListener(this);
        this.f1383c.f1403h = this;
        this.f1392l = new ArrayList();
        Iterator it = this.f1391k.iterator();
        while (it.hasNext()) {
            C0329p c0329p = (C0329p) it.next();
            if (c0329p.f1447h && c0329p.f1448i) {
                this.f1392l.add(c0329p);
            }
        }
        this.f1388h = new C0317b(this, this.f1381a, this.f1392l, a.m1131a());
        C0318c c0318c = this.f1383c;
        ListAdapter listAdapter = this.f1388h;
        if (c0318c.f1401f == null) {
            c0318c.f1401f = new C0322g((byte) 0);
        } else if (c0318c.f1397b != null) {
            c0318c.f1397b.unregisterDataSetObserver(c0318c.f1401f);
        }
        c0318c.f1397b = listAdapter;
        if (c0318c.f1397b != null) {
            listAdapter.registerDataSetObserver(c0318c.f1401f);
        }
        if (c0318c.f1398c != null) {
            c0318c.f1398c.setAdapter(c0318c.f1397b);
        }
        c0318c = this.f1383c;
        c0318c.f1407l = true;
        c0318c.f1396a.setFocusable(true);
        View view = this.f1385e;
        if (view != null) {
            boolean z2 = this.f1387g == null;
            this.f1387g = view.getViewTreeObserver();
            if (z2) {
                this.f1387g.addOnGlobalLayoutListener(this);
            }
            ((MyImageButton) view).f1922a.add(this);
            this.f1383c.f1402g = view;
            c0318c = this.f1383c;
            int min = Math.min(m1685a(this.f1388h), this.f1384d);
            Drawable background = c0318c.f1396a.getBackground();
            if (background != null) {
                background.getPadding(c0318c.f1406k);
                c0318c.f1399d = min + (c0318c.f1406k.left + c0318c.f1406k.right);
            } else {
                c0318c.f1399d = min;
            }
            this.f1383c.f1396a.setInputMethodMode(2);
            this.f1383c.m1692a();
            this.f1383c.f1398c.setOnKeyListener(this);
        } else {
            z = false;
        }
        if (!z) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public final void m1689b() {
        if (m1690c()) {
            this.f1383c.m1693b();
        }
    }

    public final void onDismiss() {
        this.f1383c = null;
        if (this.f1387g != null) {
            if (!this.f1387g.isAlive()) {
                this.f1387g = this.f1385e.getViewTreeObserver();
            }
            this.f1387g.removeGlobalOnLayoutListener(this);
            this.f1387g = null;
        }
        ((MyImageButton) this.f1385e).m2107a(this);
    }

    public final boolean m1690c() {
        return this.f1383c != null && this.f1383c.f1396a.isShowing();
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        C0329p c0329p = (C0329p) this.f1392l.get(i);
        this.f1390j.m807a(c0329p.f1440a, c0329p.f1443d);
        m1689b();
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m1689b();
        return true;
    }

    private int m1685a(ListAdapter listAdapter) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view2 = null;
            } else {
                itemViewType = i2;
                view2 = view;
            }
            if (this.f1389i == null) {
                this.f1389i = new FrameLayout(this.f1381a);
            }
            view = listAdapter.getView(i, view2, this.f1389i);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public final void onGlobalLayout() {
        if (m1690c()) {
            View view = this.f1385e;
            if (view == null || !view.isShown()) {
                m1689b();
            } else if (m1690c()) {
                this.f1383c.m1692a();
            }
        }
    }

    public final void m1688a(View view) {
        if (this.f1387g != null) {
            if (!this.f1387g.isAlive()) {
                this.f1387g = view.getViewTreeObserver();
            }
            this.f1387g.removeGlobalOnLayoutListener(this);
        }
        ((MyImageButton) view).m2107a(this);
    }
}
