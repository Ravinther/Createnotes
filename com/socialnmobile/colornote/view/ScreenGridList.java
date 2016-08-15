package com.socialnmobile.colornote.view;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.ab;
import android.support.v4.p000a.C0000d;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0267e;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0210a;
import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.data.C0230t;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import com.socialnmobile.colornote.fragment.ce;
import com.socialnmobile.colornote.p007e.C0262d;
import java.util.ArrayList;

public class ScreenGridList extends FrameLayout implements ab {
    private static LayoutAnimationController f1989v;
    private static LayoutAnimationController f1990w;
    private int f1991A;
    private int f1992B;
    private float f1993C;
    private boolean f1994D;
    private String f1995E;
    private C0000d f1996F;
    private int f1997G;
    NoteListFragment f1998a;
    bu f1999b;
    int f2000c;
    ListView f2001d;
    GridView f2002e;
    public View f2003f;
    TextView f2004g;
    View f2005h;
    AdapterView f2006i;
    Handler f2007j;
    public ce f2008k;
    C0230t f2009l;
    int f2010m;
    C0267e f2011n;
    boolean f2012o;
    public boolean f2013p;
    ListAdapter f2014q;
    OnItemClickListener f2015r;
    OnTouchListener f2016s;
    Runnable f2017t;
    OnScrollListener f2018u;
    private int f2019x;
    private boolean f2020y;
    private boolean f2021z;

    public final /* synthetic */ void m2147a(C0000d c0000d, Object obj) {
        ListAdapter listAdapter = null;
        int i = 3;
        Cursor cursor = (Cursor) obj;
        this.f1996F = c0000d;
        this.f2008k.f1281a = cursor;
        this.f1995E = null;
        if (this.f2008k.f1282b == 4) {
            au a;
            ArrayList arrayList = new ArrayList();
            m2136a(arrayList, this.f2008k.f1281a);
            if (this.f2008k.f1284d == 1 || this.f2008k.f1284d == 3) {
                if (this.f1998a.m1299I() != 1) {
                    i = 1;
                }
                a = this.f2008k.f1284d == 1 ? ay.m2180a(getContext(), arrayList, i) : ay.m2181b(getContext(), arrayList, i);
            } else {
                a = (this.f2008k.f1284d == 2 || this.f2008k.f1284d == 4) ? new au(getContext(), arrayList) : null;
            }
            if (this.f2008k.f1281a != null) {
                this.f2008k.f1281a.registerContentObserver(new br(this, this.f2007j));
            }
            if (arrayList.size() <= 0) {
                this.f1995E = "!";
            }
            listAdapter = a;
        } else {
            if (this.f2008k.f1284d == 1 || this.f2008k.f1284d == 3) {
                if (this.f1998a.m1299I() != 1) {
                    i = this.f2008k.f1282b == 5 ? 2 : this.f2008k.f1282b == 7 ? 6 : 1;
                }
                if (this.f2008k.f1284d == 1) {
                    listAdapter = az.m2182a(getContext(), this.f2008k.f1281a, i);
                } else {
                    listAdapter = az.m2183b(getContext(), this.f2008k.f1281a, i);
                }
            } else if (this.f2008k.f1284d == 2 || this.f2008k.f1284d == 4) {
                listAdapter = new av(getContext(), this.f2008k.f1281a);
            }
            if (this.f2008k.f1281a != null) {
                this.f2008k.f1281a.registerDataSetObserver(new bs(this));
            }
        }
        m2134a(listAdapter, this.f2008k.f1284d, this.f2012o);
        setMainTitle();
        m2152b(true);
    }

    public ScreenGridList(Context context) {
        this(context, null);
    }

    public ScreenGridList(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScreenGridList(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2007j = new Handler();
        this.f2020y = false;
        this.f2021z = false;
        this.f1997G = 0;
        this.f2016s = new bo(this);
        this.f2017t = new bp(this);
        this.f2018u = new bq(this);
        if (f1989v == null) {
            f1989v = AnimationUtils.loadLayoutAnimation(context, 2130968577);
            f1990w = AnimationUtils.loadLayoutAnimation(context, 2130968578);
        }
        this.f1991A = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f2011n = new C0267e(context);
        this.f2013p = false;
        setAlwaysDrawnWithCacheEnabled(false);
    }

    public final void m2148a(NoteListFragment noteListFragment, boolean z, ce ceVar) {
        this.f1998a = noteListFragment;
        this.f1999b = noteListFragment.aa;
        this.f1999b.m2202a(1);
        this.f2001d = (ListView) findViewById(2131624130);
        this.f2002e = (GridView) findViewById(2131624131);
        this.f2003f = findViewById(2131624132);
        this.f2004g = (TextView) findViewById(2131624134);
        this.f2005h = findViewById(2131624133);
        LayoutInflater from = LayoutInflater.from(getContext());
        if (noteListFragment.m1299I() == 1) {
            TextView textView = (TextView) from.inflate(2130903080, null);
            textView.setBackgroundResource(2130837512);
            this.f2001d.addHeaderView(textView);
        }
        this.f2008k = ceVar;
        this.f1994D = z;
        m2150b();
    }

    public final void m2143a() {
        int i = 4;
        Context context;
        float f;
        int i2;
        int i3;
        int dimensionPixelSize;
        int dimensionPixelSize2;
        int i4;
        if (this.f2000c == 4) {
            context = getContext();
            f = context.getResources().getDisplayMetrics().density;
            i2 = context.getResources().getDisplayMetrics().widthPixels;
            i3 = context.getResources().getDisplayMetrics().heightPixels;
            f = ((float) i2) / f;
            if (f >= 1280.0f) {
                i = 5;
            } else if (f < 1024.0f) {
                if (f >= 720.0f) {
                    i = 3;
                } else {
                    i = 2;
                }
            }
            dimensionPixelSize = context.getResources().getDimensionPixelSize(2131361798);
            dimensionPixelSize2 = context.getResources().getDimensionPixelSize(2131361829);
            i4 = i;
            i = (i2 - (((i - 1) + 2) * dimensionPixelSize)) / i;
            while (i > (i3 - dimensionPixelSize2) - context.getResources().getDimensionPixelSize(2131361828)) {
                i4++;
                i = (i2 - (((i4 - 1) + 2) * dimensionPixelSize)) / i4;
            }
            this.f1992B = i;
            this.f1993C = getContext().getResources().getDimension(2131361799);
        } else {
            context = getContext();
            f = context.getResources().getDisplayMetrics().density;
            i2 = context.getResources().getDisplayMetrics().widthPixels;
            i3 = context.getResources().getDisplayMetrics().heightPixels;
            f = ((float) i2) / f;
            if (f >= 1280.0f) {
                i = 6;
            } else if (f >= 1024.0f) {
                i = 5;
            } else if (f < 720.0f) {
                i = 3;
            }
            dimensionPixelSize = context.getResources().getDimensionPixelSize(2131361798);
            dimensionPixelSize2 = context.getResources().getDimensionPixelSize(2131361829);
            i4 = i;
            i = (i2 - (((i - 1) + 2) * dimensionPixelSize)) / i;
            while (i * 2 > (i3 - dimensionPixelSize2) - context.getResources().getDimensionPixelSize(2131361828)) {
                i4++;
                i = (i2 - (((i4 - 1) + 2) * dimensionPixelSize)) / i4;
            }
            this.f1992B = i;
            this.f1993C = getContext().getResources().getDimension(2131361796);
        }
        this.f2002e.setColumnWidth(this.f1992B);
        at atVar = (at) this.f2002e.getAdapter();
        if (atVar != null) {
            atVar.m2170a(this.f1992B);
            atVar.m2169a(this.f1993C);
        }
        this.f2002e.invalidateViews();
    }

    public final void m2150b() {
        int n = C0209d.m875a(getContext()).m1145n(3);
        this.f2001d.setBackgroundColor(n);
        this.f2002e.setBackgroundColor(n);
        this.f2001d.setCacheColorHint(n);
        this.f2002e.setCacheColorHint(n);
        this.f2001d.invalidateViews();
        this.f2002e.invalidateViews();
    }

    public void setListener(OnItemClickListener onItemClickListener) {
        this.f2015r = onItemClickListener;
        this.f2001d.setOnItemClickListener(onItemClickListener);
        this.f2002e.setOnItemClickListener(onItemClickListener);
        this.f2001d.setOnScrollListener(this.f2018u);
        this.f2002e.setOnScrollListener(this.f2018u);
        this.f2001d.setOnCreateContextMenuListener(this.f1998a);
        this.f2002e.setOnCreateContextMenuListener(this.f1998a);
        this.f2001d.setOnTouchListener(this.f2016s);
        this.f2002e.setOnTouchListener(this.f2016s);
    }

    private void m2134a(ListAdapter listAdapter, int i, boolean z) {
        this.f2000c = i;
        this.f2014q = listAdapter;
        if (i == 2 || i == 4) {
            setGridAdapter(listAdapter);
            this.f2002e.setVisibility(0);
            setListAdapter(null);
            this.f2001d.setVisibility(4);
            this.f2006i = this.f2002e;
            m2143a();
        } else if (i == 1 || i == 3) {
            setListAdapter(listAdapter);
            this.f2001d.setVisibility(0);
            setGridAdapter(null);
            this.f2002e.setVisibility(4);
            this.f2006i = this.f2001d;
        }
        m2153c();
        if (z) {
            this.f2001d.setLayoutAnimation(f1990w);
            this.f2002e.setLayoutAnimation(f1989v);
            this.f2006i.setLayoutAnimationListener(null);
            this.f2006i.startLayoutAnimation();
            return;
        }
        this.f2001d.setLayoutAnimation(null);
        this.f2002e.setLayoutAnimation(null);
    }

    final void m2153c() {
        int i = (this.f2014q == null || this.f2014q.isEmpty()) ? 1 : 0;
        if (i == 0 || !this.f2013p || this.f2008k.f1282b == 4) {
            this.f2003f.setVisibility(4);
            if (i == 0) {
                Context context = getContext();
                if (C0210a.m900b(context)) {
                    C0210a.m897a(context, "WIPE_OUT_MARK", 0);
                    return;
                }
                return;
            }
            return;
        }
        this.f2003f.setVisibility(0);
        if (C0210a.m900b(getContext())) {
            this.f2005h.setVisibility(8);
            this.f2004g.setText(2131231056);
            return;
        }
        this.f2005h.setVisibility(0);
        this.f2004g.setText(2131230818);
    }

    public void setGridAdapter(ListAdapter listAdapter) {
        this.f2002e.setAdapter(listAdapter);
    }

    public void setListAdapter(ListAdapter listAdapter) {
        this.f2001d.setAdapter(listAdapter);
    }

    public final void m2149a(boolean z) {
        this.f2012o = z;
        if (this.f1998a.m74h()) {
            this.f1998a.m77l().m102a(1, null, this);
        }
    }

    private static void m2136a(ArrayList arrayList, Cursor cursor) {
        arrayList.clear();
        if (cursor == null || !cursor.moveToFirst()) {
            C0313j.m1649a(arrayList);
        }
        do {
            arrayList.add(new C0230t(cursor));
        } while (cursor.moveToNext());
        C0313j.m1649a(arrayList);
    }

    public void setGridListViewOptions(int i, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2) {
        this.f2008k.f1282b = i;
        this.f2008k.f1283c = i2;
        this.f2008k.f1284d = i6;
        this.f2008k.f1285e = i3;
        this.f2008k.f1286f = i4;
        this.f2008k.f1287g = i5;
        if (z2) {
            m2149a(z);
        }
    }

    Adapter getCurrentAdapter() {
        switch (this.f2008k.f1284d) {
            case 1:
                return this.f2001d.getAdapter();
            case 2:
                return this.f2002e.getAdapter();
            case 3:
                return this.f2001d.getAdapter();
            case 4:
                return this.f2002e.getAdapter();
            default:
                return null;
        }
    }

    public final void m2152b(boolean z) {
        if (this.f2008k.f1281a != null && getCurrentAdapter() != null) {
            this.f1997G = 0;
        } else if ((!z && !this.f1998a.m77l().m103a()) || z) {
            if (this.f2008k.f1281a == null) {
                this.f1997G++;
            }
            if (this.f1997G > 15) {
                if (this.f1998a.f48C.getPackageManager().isSafeMode()) {
                    Toast.makeText(this.f1998a.f48C, 2131231045, 1).show();
                } else {
                    Toast.makeText(this.f1998a.f48C, 2131231044, 1).show();
                }
                this.f1998a.f48C.finish();
                return;
            }
            this.f2007j.postDelayed(new bn(this), 100);
        }
    }

    public final void m2145a(int i, boolean z) {
        if (z) {
            Editor edit = PreferenceManager.getDefaultSharedPreferences(getContext()).edit();
            edit.putInt("LAST_SAVED_SORT_ORDER", i);
            edit.commit();
        }
        if (i != this.f2008k.f1282b || this.f2008k.f1281a == null || ((this.f2008k.f1281a != null && this.f2008k.f1281a.getCount() <= 0) || getCurrentAdapter() == null)) {
            setGridListViewOptions(i, this.f2008k.f1283c, this.f2008k.f1285e, this.f2008k.f1286f, this.f2008k.f1287g, this.f2008k.f1284d, true, true);
        }
    }

    public final void m2144a(int i) {
        if (i != this.f2008k.f1287g) {
            setGridListViewOptions(this.f2008k.f1282b, this.f2008k.f1283c, this.f2008k.f1285e, this.f2008k.f1286f, i, this.f2008k.f1284d, true, true);
        }
    }

    public final void m2151b(int i) {
        if (i != this.f2008k.f1286f) {
            setGridListViewOptions(this.f2008k.f1282b, this.f2008k.f1283c, this.f2008k.f1285e, i, this.f2008k.f1287g, this.f2008k.f1284d, true, true);
        }
    }

    public final void m2154c(int i) {
        if (i != this.f2008k.f1283c) {
            setGridListViewOptions(this.f2008k.f1282b, i, this.f2008k.f1285e, this.f2008k.f1286f, this.f2008k.f1287g, this.f2008k.f1284d, true, true);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setMainTitle() {
        /*
        r11 = this;
        r1 = 0;
        r0 = r11.f1998a;
        r0 = r0.m74h();
        if (r0 != 0) goto L_0x000a;
    L_0x0009:
        return;
    L_0x000a:
        r0 = r11.f1999b;
        r0.m2207b(r1);
        r0 = r11.f1999b;
        r2 = r11.f2008k;
        r2 = r2.f1283c;
        r0.m2208c(r2);
        r0 = r11.f1995E;
        if (r0 != 0) goto L_0x005f;
    L_0x001c:
        r0 = r11.f1999b;
        r0.m2201a();
    L_0x0021:
        r2 = r11.getContext();
        r3 = 2131230991; // 0x7f08010f float:1.807805E38 double:1.052968016E-314;
        r0 = 1;
        r4 = new java.lang.Object[r0];
        r5 = r11.f1998a;
        r0 = r5.f1159i;
        r0 = r0.size();
        if (r0 != 0) goto L_0x0083;
    L_0x0035:
        r0 = r5.m70f();
        r6 = 2131099664; // 0x7f060010 float:1.7811688E38 double:1.052903132E-314;
        r6 = r0.getStringArray(r6);
        r0 = r5.m70f();
        r7 = 2131099665; // 0x7f060011 float:1.781169E38 double:1.0529031323E-314;
        r7 = r0.getStringArray(r7);
        r0 = r1;
    L_0x004c:
        r8 = r7.length;
        if (r0 >= r8) goto L_0x0072;
    L_0x004f:
        r8 = r5.f1159i;
        r9 = r7[r0];
        r9 = java.lang.Integer.valueOf(r9);
        r10 = r6[r0];
        r8.put(r9, r10);
        r0 = r0 + 1;
        goto L_0x004c;
    L_0x005f:
        r0 = r11.f1999b;
        r2 = r11.f1995E;
        r3 = r0.f2122h;
        if (r3 == 0) goto L_0x0021;
    L_0x0067:
        r3 = r0.f2122h;
        r3.setVisibility(r1);
        r0 = r0.f2122h;
        r0.setText(r2);
        goto L_0x0021;
    L_0x0072:
        r0 = r5.f1159i;
        r6 = 7;
        r6 = java.lang.Integer.valueOf(r6);
        r7 = 2131230985; // 0x7f080109 float:1.8078038E38 double:1.052968013E-314;
        r7 = r5.m50a(r7);
        r0.put(r6, r7);
    L_0x0083:
        r0 = r5.f1159i;
        r5 = r11.f2008k;
        r5 = r5.f1282b;
        r5 = java.lang.Integer.valueOf(r5);
        r0 = r0.get(r5);
        r4[r1] = r0;
        r0 = r2.getString(r3, r4);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r0 = r1.append(r0);
        r1 = " \u25bc";
        r0 = r0.append(r1);
        r1 = r0.toString();
        r0 = r11.f2008k;
        r0 = r0.f1283c;
        if (r0 == 0) goto L_0x00d1;
    L_0x00b0:
        r0 = r11.getContext();
        r2 = r11.f2008k;
        r2 = r2.f1286f;
        r3 = r11.f2008k;
        r3 = r3.f1283c;
        r0 = com.socialnmobile.colornote.data.C0213c.m959a(r0, r2, r3);
        if (r0 == 0) goto L_0x00d1;
    L_0x00c2:
        r2 = "";
        r2 = r0.equals(r2);
        if (r2 != 0) goto L_0x00d1;
    L_0x00ca:
        r1 = r11.f1999b;
        r1.m2205a(r0);
        goto L_0x0009;
    L_0x00d1:
        r0 = r1;
        goto L_0x00ca;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.view.ScreenGridList.setMainTitle():void");
    }

    private void setItemTitle(C0230t c0230t) {
        if (this.f2009l == null || this.f2009l.f1002a != c0230t.f1002a || this.f2010m != this.f2008k.f1282b) {
            this.f2009l = c0230t;
            this.f2010m = this.f2008k.f1282b;
            String str = "";
            switch (this.f2010m) {
                case 1:
                    str = this.f2011n.m1198a(c0230t.f1010i);
                    break;
                case 2:
                    if (c0230t.f1008g.length() > 0) {
                        str = c0230t.f1008g.substring(0, 1).toUpperCase();
                        break;
                    }
                    break;
                case 3:
                    C0262d a = C0209d.m875a(getContext());
                    bu buVar = this.f1999b;
                    buVar.f2120f.setTextColor(a.m1136e(c0230t.f1011j));
                    this.f1999b.m2207b(a.m1136e(c0230t.f1011j));
                    str = C0213c.m959a(getContext(), this.f2008k.f1286f, c0230t.f1011j);
                    if (str.length() == 0) {
                        str = getContext().getString(2131230747);
                        break;
                    }
                    break;
                case 4:
                    if (c0230t.f1014m != 16) {
                        str = this.f2011n.m1199b(c0230t.m1065g());
                        break;
                    } else {
                        str = this.f2011n.m1198a(c0230t.m1065g());
                        break;
                    }
                case 5:
                    str = this.f2011n.m1198a(c0230t.f1009h);
                    break;
                case 7:
                    if (c0230t.m1066h() != 0) {
                        str = this.f2011n.m1198a(c0230t.m1066h());
                        break;
                    } else {
                        str = "";
                        break;
                    }
            }
            this.f1999b.m2205a(str);
        }
    }

    public final C0000d a_(Bundle bundle) {
        this.f2003f.setVisibility(4);
        return new bt(getContext(), this);
    }

    public final void m2146a(C0000d c0000d) {
        if (this.f1996F == c0000d) {
            this.f2008k.f1281a = null;
            setListAdapter(null);
            setGridAdapter(null);
            this.f2014q = null;
            this.f2003f.setVisibility(4);
        }
    }

    static /* synthetic */ void m2135a(ScreenGridList screenGridList, AbsListView absListView) {
        View childAt;
        if (screenGridList.f2021z) {
            childAt = absListView.getChildAt(0);
        } else {
            childAt = C0313j.m1637a(absListView);
        }
        if (childAt != null) {
            Object tag = childAt.getTag();
            if (tag instanceof ax) {
                screenGridList.setItemTitle(((ax) tag).m2175a());
            }
            screenGridList.f2007j.removeCallbacks(screenGridList.f2017t);
            screenGridList.f2007j.postDelayed(screenGridList.f2017t, 2500);
        }
    }
}
