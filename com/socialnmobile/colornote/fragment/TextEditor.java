package com.socialnmobile.colornote.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.LinkMovementMethod;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView.BufferType;
import android.widget.Toast;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0310g;
import com.socialnmobile.colornote.C0312i;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.menu.C0326m;
import com.socialnmobile.colornote.menu.C0329p;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.p006a.C0150i;
import com.socialnmobile.colornote.p007e.C0262d;
import com.socialnmobile.colornote.p013g.C0303a;
import com.socialnmobile.colornote.view.C0426s;
import com.socialnmobile.colornote.view.LinedEditText;
import com.socialnmobile.colornote.view.LinedTextView;
import java.util.Iterator;

public class TextEditor extends AbstractEditorViewer {
    private View aA;
    private View aB;
    private boolean aC;
    private int aD;
    private int aE;
    private boolean aF;
    private boolean aG;
    private Toast aH;
    Handler ap;
    SimpleOnGestureListener aq;
    SimpleOnGestureListener ar;
    private View as;
    private LinedEditText at;
    private LinedTextView au;
    private EditText av;
    private ListView aw;
    private View ax;
    private View ay;
    private View az;

    public TextEditor() {
        this.ap = new Handler();
        this.aq = new dc(this);
        this.ar = new dd(this);
    }

    public final void m1561a(Bundle bundle) {
        super.m1248a(bundle);
        m76k();
    }

    public final void m1560a(Activity activity) {
        super.m53a(activity);
    }

    public final View m1559a(LayoutInflater layoutInflater, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903068, null);
        if (!C0212b.m958r(this.f48C)) {
            C0147f.m665a(inflate);
        }
        m1250a(inflate);
        this.as = inflate.findViewById(2131623959);
        this.at = (LinedEditText) inflate.findViewById(2131624059);
        this.au = (LinedTextView) inflate.findViewById(2131624060);
        this.av = (EditText) inflate.findViewById(2131624055);
        this.aw = (ListView) inflate.findViewById(2131624061);
        this.ay = inflate.findViewById(2131624056);
        this.ax = inflate.findViewById(2131624057);
        this.az = inflate.findViewById(2131624058);
        this.aA = inflate.findViewById(2131624049);
        this.aB = inflate.findViewById(2131624054);
        this.av.setOnClickListener(new dh(this));
        this.av.setOnFocusChangeListener(new di(this));
        this.at.setOnWordChangedListener(new dj(this));
        this.aw.setOnItemClickListener(new dk(this));
        this.ax.setOnClickListener(new dl(this));
        this.az.setOnClickListener(new dm(this));
        this.av.addTextChangedListener(new dn(this));
        this.at.addTextChangedListener(new cy(this));
        C0426s c0426s = this.ac;
        c0426s.f2194c.addTextChangedListener(new cz(this));
        this.ay.setOnClickListener(new da(this));
        this.av.setOnKeyListener(new db(this));
        this.ac.m2227a(this.am);
        this.ac.m2231b(this.an);
        this.au.setOnDoubleTapListener(this.aq);
        this.at.setOnDoubleTapListener(this.ar);
        this.aC = false;
        this.aF = false;
        this.at.requestFocus();
        m1261c(bundle);
        ListAdapter cxVar = new cx(this, this.f48C, new String[]{"suggest_text_1"}, new int[]{16908308});
        cxVar.setFilterQueryProvider(new dg(this));
        this.aw.setAdapter(cxVar);
        this.aE = 0;
        this.aD = 0;
        return inflate;
    }

    public final void m1568o() {
        boolean z;
        super.m1267o();
        Context context = this.f48C;
        if (C0150i.m674b()) {
            z = false;
        } else {
            z = C0212b.m940a(context, "pref_use_auto_select", context.getResources().getBoolean(2131296267));
        }
        this.aG = z;
        int h = C0212b.m948h(this.f48C);
        this.at.setTextSize((float) h);
        this.au.setTextSize((float) h);
        if (C0212b.m946f(this.f48C)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setClassName("com.socialnmobile.colordict", "com.socialnmobile.colordict.activity.Main");
            if (C0313j.m1650a(this.f48C, intent)) {
                this.ax.setVisibility(0);
                this.az.setVisibility(8);
            } else {
                this.ax.setVisibility(8);
                this.az.setVisibility(0);
            }
            m1525Y();
        }
    }

    public final void m1569p() {
        super.m1268p();
        if (this.aH != null) {
            this.aH.cancel();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1525Y();
    }

    protected final void m1555U() {
        this.aB.setVisibility(8);
        this.au.setVisibility(0);
        this.at.setVisibility(8);
        this.aA.setVisibility(8);
        InputMethodManager inputMethodManager = (InputMethodManager) this.f48C.getSystemService("input_method");
        inputMethodManager.hideSoftInputFromWindow(this.at.getWindowToken(), 0);
        inputMethodManager.hideSoftInputFromInputMethod(this.at.getWindowToken(), 0);
    }

    protected final void m1556V() {
        if (C0212b.m946f(this.f48C)) {
            this.aB.setVisibility(0);
        }
        this.au.setVisibility(8);
        this.at.setVisibility(0);
        this.at.requestFocus();
        this.aA.setVisibility(8);
        if (m1526Z().equals(this.ac.m2229b())) {
            this.aF = true;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) this.f48C.getSystemService("input_method");
        inputMethodManager.showSoftInput(this.at, 0);
        inputMethodManager.showSoftInputFromInputMethod(this.at.getWindowToken(), 0);
    }

    public final boolean m1546F() {
        if (this.aC) {
            return true;
        }
        return super.m1227F();
    }

    public final boolean m1547G() {
        if (!this.aC) {
            return super.m1228G();
        }
        this.at.requestFocus();
        return true;
    }

    protected final boolean m1558X() {
        return this.at.getText().toString().length() == 0 && this.ac.m2229b().length() == 0;
    }

    public final void m1562a(C0326m c0326m) {
        boolean z;
        int i = c0326m.f1435g;
        if (i == 1 || i == 3) {
            z = false;
        } else if (i == 2) {
            z = true;
        } else {
            z = true;
        }
        if (this.aa) {
            AbstractEditorViewer.m1217a(c0326m, z, 2131624186, 2130837611, 2131231072);
        } else if (this.b == 1) {
            AbstractEditorViewer.m1217a(c0326m, z, 2131624091, 2130837525, 2131230823);
            if (z) {
                AbstractEditorViewer.m1218b(c0326m, true, 2131624162, 2130837603, 2131230832);
                AbstractEditorViewer.m1218b(c0326m, true, 2131624163, 2130837621, 2131230848);
                AbstractEditorViewer.m1218b(c0326m, true, 2131624164, 2130837611, 2131230838);
                AbstractEditorViewer.m1218b(c0326m, true, 2131624165, 2130837610, 2131230836);
                AbstractEditorViewer.m1218b(c0326m, true, 2131624166, 2130837614, 2131230839);
            } else {
                AbstractEditorViewer.m1218b(c0326m, false, 2131624164, 2130837611, 2131230838);
                AbstractEditorViewer.m1218b(c0326m, false, 2131624162, 2130837603, 2131230832);
                AbstractEditorViewer.m1218b(c0326m, false, 2131624163, 2130837621, 2131230848);
                AbstractEditorViewer.m1218b(c0326m, false, 2131624166, 2130837614, 2131230839);
                AbstractEditorViewer.m1218b(c0326m, false, 2131624165, 2130837610, 2131230836);
            }
            AbstractEditorViewer.m1218b(c0326m, z, 2131624167, 2130837589, 2131230819);
            AbstractEditorViewer.m1218b(c0326m, z, 2131624168, 2130837619, 2131230845);
            AbstractEditorViewer.m1218b(c0326m, z, 2131624169, 2130837595, 2131230824);
        } else if (this.b == 3) {
            if (this.Z.f1004c == 0) {
                AbstractEditorViewer.m1217a(c0326m, z, 2131624030, 2130837598, 2131230827);
                if (z) {
                    AbstractEditorViewer.m1218b(c0326m, true, 2131624166, 2130837614, 2131230839);
                    AbstractEditorViewer.m1218b(c0326m, true, 2131624193, 2130837590, 2131230820);
                } else {
                    AbstractEditorViewer.m1218b(c0326m, false, 2131624193, 2130837590, 2131230820);
                    AbstractEditorViewer.m1218b(c0326m, false, 2131624166, 2130837614, 2131230839);
                }
                AbstractEditorViewer.m1218b(c0326m, z, 2131624165, 2130837610, 2131230836);
                AbstractEditorViewer.m1218b(c0326m, z, 2131624167, 2130837589, 2131230819);
                AbstractEditorViewer.m1218b(c0326m, z, 2131624168, 2130837619, 2131230845);
                AbstractEditorViewer.m1218b(c0326m, z, 2131624169, 2130837595, 2131230824);
            } else if (this.Z.f1004c == 16) {
                AbstractEditorViewer.m1217a(c0326m, z, 2131624186, 2130837611, 2131231072);
                AbstractEditorViewer.m1218b(c0326m, z, 2131624187, 2130837596, 2131230825);
            } else if (this.Z.f1004c != 32) {
            }
        } else if (this.b == 2) {
            AbstractEditorViewer.m1217a(c0326m, z, 2131624091, 2130837525, 2131230823);
            if (z) {
                AbstractEditorViewer.m1218b(c0326m, true, 2131624162, 2130837603, 2131230832);
                AbstractEditorViewer.m1218b(c0326m, true, 2131624165, 2130837610, 2131230836);
                AbstractEditorViewer.m1218b(c0326m, true, 2131624166, 2130837614, 2131230839);
                AbstractEditorViewer.m1218b(c0326m, true, 2131624170, 2130837595, 2131230826);
                return;
            }
            AbstractEditorViewer.m1218b(c0326m, false, 2131624170, 2130837595, 2131230826);
            AbstractEditorViewer.m1218b(c0326m, false, 2131624166, 2130837614, 2131230839);
            AbstractEditorViewer.m1218b(c0326m, false, 2131624162, 2130837603, 2131230832);
            AbstractEditorViewer.m1218b(c0326m, false, 2131624165, 2130837610, 2131230836);
        } else if (this.b != 4) {
        }
    }

    public final void m1566b(C0326m c0326m) {
        if (!this.aa) {
            Iterator it;
            boolean z;
            Iterator it2;
            C0329p c0329p;
            boolean z2;
            Iterator it3;
            if (this.b == 1) {
                it = c0326m.m1702b(2131624091).iterator();
                while (it.hasNext()) {
                    ((C0329p) it.next()).m1707a(C0313j.m1636a(this.f48C, this.Z.f1011j));
                }
                z = this.af == null;
                it3 = c0326m.m1702b(2131624162).iterator();
                while (it3.hasNext()) {
                    ((C0329p) it3.next()).f1447h = z;
                }
                it2 = c0326m.m1702b(2131624163).iterator();
                while (it2.hasNext()) {
                    c0329p = (C0329p) it2.next();
                    if (z) {
                        z2 = false;
                    } else {
                        z2 = true;
                    }
                    c0329p.f1447h = z2;
                }
            } else if (this.b == 3) {
                if (this.Z.f1004c == 0) {
                    it = c0326m.m1702b(2131624193).iterator();
                    while (it.hasNext()) {
                        c0329p = (C0329p) it.next();
                        if (this.Z.m1059a()) {
                            c0329p.m1706a(2130837620);
                            c0329p.f1442c = 2131230846;
                        } else {
                            c0329p.m1706a(2130837590);
                            c0329p.f1442c = 2131230820;
                        }
                    }
                }
            } else if (this.b == 2) {
                it = c0326m.m1702b(2131624091).iterator();
                while (it.hasNext()) {
                    ((C0329p) it.next()).m1707a(C0313j.m1636a(this.f48C, this.Z.f1011j));
                }
                z = this.af == null;
                it3 = c0326m.m1702b(2131624162).iterator();
                while (it3.hasNext()) {
                    ((C0329p) it3.next()).f1448i = z;
                }
            } else if (this.b == 4) {
                return;
            }
            it = c0326m.m1702b(2131624165).iterator();
            while (it.hasNext()) {
                c0329p = (C0329p) it.next();
                if (this.Z.f1006e == 16) {
                    c0329p.f1448i = false;
                } else {
                    c0329p.f1448i = true;
                }
                if (this.Z.f1003b == 16) {
                    c0329p.m1706a(2130837605);
                    c0329p.f1442c = 2131230741;
                }
            }
            z = this.Z.f1006e == 16;
            it2 = c0326m.m1702b(2131624167).iterator();
            while (it2.hasNext()) {
                c0329p = (C0329p) it2.next();
                if (z) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                c0329p.f1447h = z2;
            }
            Iterator it4 = c0326m.m1702b(2131624168).iterator();
            while (it4.hasNext()) {
                ((C0329p) it4.next()).f1447h = z;
            }
        }
    }

    public final boolean m1565a(int i, String str) {
        switch (i) {
            case 2131624030:
                m1255a(false, "MENU");
                break;
            case 2131624091:
                m1263d(101);
                break;
            case 2131624162:
                m1275z();
                break;
            case 2131624163:
                m1263d(105);
                break;
            case 2131624164:
                m1263d(104);
                break;
            case 2131624165:
                m1270u();
                break;
            case 2131624166:
                m1229H();
                break;
            case 2131624167:
                if (this.Z.m1065g() == 0) {
                    m1263d(107);
                    break;
                }
                m1263d(108);
                break;
            case 2131624168:
                m1224C();
                break;
            case 2131624169:
                m1263d(103);
                break;
            case 2131624170:
                m1273x();
                m1258b(0);
                break;
            case 2131624186:
                m1263d(102);
                break;
            case 2131624187:
                m1263d(106);
                break;
            case 2131624193:
                if (this.Z.m1059a()) {
                    C0229s.m1043a(this.f48C, this.c, this.Z.f1005d, 0, 16);
                } else {
                    C0229s.m1043a(this.f48C, this.c, this.Z.f1005d, 16, 16);
                    if (C0310g.m1616a(this.Z)) {
                        m1263d(109);
                    }
                }
                this.Y.requery();
                break;
        }
        return false;
    }

    public final boolean m1545E() {
        if ((this.b != 1 && this.b != 2) || !C0212b.m946f(this.f48C)) {
            return true;
        }
        this.av.requestFocus();
        return false;
    }

    private String m1526Z() {
        return C0313j.m1675h(this.at.getText().toString());
    }

    protected final void m1564a(boolean z) {
        this.ah = false;
        String N = m1548N();
        this.Z.f1008g = m1549O();
        int a = C0229s.m1033a(this.Z.f1005d, 0, 16);
        m1253a(this.Z.f1008g, N, a, this.Z.f1011j, this.Z.f1014m);
    }

    protected final void m1557W() {
        m1253a(this.h, this.g, this.Z.f1005d, this.i, this.Z.f1014m);
        this.Y.requery();
        m1231J();
    }

    protected final String m1548N() {
        return this.at.getText().toString();
    }

    protected final String m1549O() {
        String b = this.ac.m2229b();
        if (b.equals("")) {
            return m1232K();
        }
        return b;
    }

    protected final void m1550P() {
        this.at.setText("");
        this.au.setText("");
        this.au.setDoNotRestore(true);
        this.at.setDoNotRestore(true);
    }

    protected final void m1563a(String str) {
        if (this.at.getText().length() == 0) {
            this.at.setTextKeepState(str);
            this.at.setSelection(this.at.getText().length());
        } else {
            this.at.setTextKeepState(str);
        }
        CharSequence a = C0303a.m1594a(this.f48C, this.aa, str);
        if (a != null) {
            if (VERSION.SDK_INT < 11) {
                this.au.setMovementMethod(LinkMovementMethod.getInstance());
            }
            this.au.setAutoLinkMask(0);
            this.au.setTextKeepState(a, BufferType.SPANNABLE);
            this.au.setAutoLinkMask(15);
            return;
        }
        this.au.setTextKeepState(str);
    }

    protected final void m1551Q() {
        int i = this.Z.f1004c;
        if (this.aa) {
            m1231J();
            this.ac.m2225a(1);
        } else if (i == 16) {
            m1231J();
            this.ac.m2225a(2);
        } else if (i == 32) {
            m1231J();
            this.ac.m2225a(3);
            this.aA.setVisibility(0);
        } else if (i == 0 && this.b == 3) {
            m1231J();
            this.ac.m2225a(4);
        }
        this.ap.post(new df(this));
    }

    private void m1525Y() {
        if (C0212b.m946f(this.f48C)) {
            C0313j.m1661b(this.ay, C0312i.m1630d(this.f48C));
            C0313j.m1661b(this.ax, C0312i.m1630d(this.f48C));
            C0313j.m1661b(this.az, C0312i.m1630d(this.f48C));
        }
    }

    protected final void m1567f(int i) {
        this.as.setBackgroundColor(C0209d.m875a(this.f48C).m1133b(i));
        this.Z.f1011j = i;
        this.ac.m2230b(i);
        this.at.setColor(i);
        this.au.setColor(i);
        this.ad.m2216a(i);
        m1552R();
    }

    protected final boolean m1554T() {
        Context context = this.f48C;
        return C0212b.m940a(context, "pref_edit_title", context.getResources().getBoolean(2131296259));
    }

    protected final void m1552R() {
        C0262d a = C0209d.m875a(this.f48C);
        if (m1256a()) {
            this.ac.m2226a(1, a, this.Z.f1011j);
            this.au.setTextColor(a.m1138g(this.Z.f1011j));
            this.at.setTextColor(a.m1138g(this.Z.f1011j));
        } else if (this.Z.m1059a()) {
            this.ac.m2226a(2, a, this.Z.f1011j);
            this.au.setTextColor(C0313j.m1632a(102, a.m1138g(this.Z.f1011j)));
            this.at.setTextColor(a.m1138g(this.Z.f1011j));
        } else {
            this.ac.m2226a(3, a, this.Z.f1011j);
            this.au.setTextColor(a.m1138g(this.Z.f1011j));
            this.at.setTextColor(a.m1138g(this.Z.f1011j));
        }
    }

    protected final void m1553S() {
        C0310g.m1615a(this.f48C, this.c);
        m1264e(4);
        m1567f(8);
        this.at.setText(m72g());
        this.au.setText(m72g());
        this.ad.m2215a();
        this.ac.m2232c();
        this.Y = null;
    }

    static /* synthetic */ void m1530a(TextEditor textEditor, CharSequence charSequence) {
        if (textEditor.av.isFocused()) {
            CursorAdapter cursorAdapter = (CursorAdapter) textEditor.aw.getAdapter();
            textEditor.aw.setSelection(0);
            cursorAdapter.getFilter().filter(charSequence, new de(textEditor));
        }
    }

    static /* synthetic */ void m1541j(TextEditor textEditor) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setClassName("com.socialnmobile.colordict", "com.socialnmobile.colordict.activity.Main");
        if (C0313j.m1650a(textEditor.f48C, intent)) {
            String obj = textEditor.av.getText().toString();
            if (obj != null && obj.length() != 0) {
                ((InputMethodManager) textEditor.f48C.getSystemService("input_method")).hideSoftInputFromWindow(textEditor.av.getWindowToken(), 2);
                intent.setData(Uri.parse(obj));
                textEditor.m54a(intent);
                return;
            }
            return;
        }
        textEditor.m1263d(112);
    }
}
