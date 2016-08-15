package com.socialnmobile.colornote.fragment;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0015f;
import android.support.v4.app.DialogFragment;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0310g;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0220j;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.menu.C0326m;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.p007e.C0262d;
import com.socialnmobile.colornote.p012f.C0269a;
import com.socialnmobile.colornote.view.C0275q;
import com.socialnmobile.colornote.view.C0276r;
import com.socialnmobile.colornote.view.C0413d;
import com.socialnmobile.colornote.view.C0414e;
import com.socialnmobile.colornote.view.C0415f;
import com.socialnmobile.colornote.view.C0426s;
import com.socialnmobile.colornote.view.DragDropListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

public class ListEditor extends AbstractEditorViewer {
    OnItemClickListener aA;
    OnItemClickListener aB;
    private View aC;
    private ListView aD;
    private DragDropListView aE;
    private TextView aF;
    private View aG;
    private View aH;
    private View aI;
    private GradientDrawable aJ;
    private int aK;
    private C0275q aL;
    private C0276r aM;
    ArrayList ap;
    C0415f aq;
    C0413d ar;
    int as;
    boolean at;
    EditDialogFragment au;
    C0220j av;
    int aw;
    OnClickListener ax;
    OnClickListener ay;
    OnClickListener az;

    public class EditDialogFragment extends DialogFragment {
        boolean f1180Y;
        EditText f1181Z;
        boolean aa;
        String ab;

        public static EditDialogFragment m1398a(boolean z, String str, ListEditor listEditor) {
            EditDialogFragment editDialogFragment = new EditDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("additem", z);
            editDialogFragment.m71f(bundle);
            editDialogFragment.m57a((C0015f) listEditor);
            editDialogFragment.ab = str;
            return editDialogFragment;
        }

        public final void m1399a(Bundle bundle) {
            super.m84a(bundle);
            m75j();
            if (this.f77q != null) {
                this.f1180Y = this.f77q.getBoolean("additem");
            }
            if (bundle != null) {
                m82a();
            }
        }

        public final Dialog m1400c(Bundle bundle) {
            Builder builder = new Builder(this.f48C);
            Context a = C0147f.m662a(builder);
            if (a == null) {
                a = this.f48C;
            }
            View inflate = LayoutInflater.from(a).inflate(2130903054, null);
            if (!C0212b.m958r(a)) {
                C0147f.m665a(inflate);
            }
            this.f1181Z = (EditText) inflate.findViewById(2131624030);
            if (VERSION.SDK_INT == 15 && Build.BRAND.equals("NOOK") && C0212b.m957q(this.f48C) == 1) {
                this.f1181Z.setTextColor(-16777216);
            }
            this.f1181Z.setText(this.ab);
            this.f1181Z.setSelection(this.f1181Z.length());
            if (this.f1180Y) {
                builder.setTitle(2131230725);
            } else {
                builder.setTitle(2131230789);
            }
            ListEditor listEditor = (ListEditor) this.f78r;
            builder.setView(inflate);
            builder.setPositiveButton(17039370, new bd(this, listEditor));
            if (this.f1180Y) {
                builder.setNeutralButton(2131230884, new be(this, listEditor));
            }
            builder.setNegativeButton(17039360, new bf(this, listEditor));
            return builder.create();
        }

        public void onCancel(DialogInterface dialogInterface) {
            super.onCancel(dialogInterface);
            ListEditor listEditor = (ListEditor) this.f78r;
            listEditor.m1438a(listEditor.ap, m1403t());
            listEditor.at = true;
        }

        public final String m1403t() {
            return this.f1181Z.getText().toString().trim();
        }

        public final void m1401c() {
            super.m90c();
            ListEditor listEditor = (ListEditor) this.f78r;
            listEditor.at = false;
            listEditor.au = this;
            this.f92f.getWindow().setSoftInputMode(36);
            this.f1181Z.postDelayed(new bg(this), 100);
        }

        public final void m1402d() {
            if (this.aa) {
                ((InputMethodManager) this.f48C.getSystemService("input_method")).hideSoftInputFromInputMethod(this.f1181Z.getApplicationWindowToken(), 1);
            }
            ListEditor listEditor = (ListEditor) this.f78r;
            if (!(listEditor.at || this.f92f == null)) {
                this.f92f.dismiss();
                listEditor.at = true;
            }
            super.m91d();
        }
    }

    public ListEditor() {
        this.as = -1;
        this.ax = new av(this);
        this.ay = new aw(this);
        this.az = new ax(this);
        this.aA = new ao(this);
        this.aB = new ap(this);
        this.aL = new aq(this);
        this.aM = new as(this);
    }

    public final void m1433a(Bundle bundle) {
        super.m1248a(bundle);
        m76k();
    }

    public final void m1445e(Bundle bundle) {
        super.m1265e(bundle);
    }

    public final void m1432a(Activity activity) {
        super.m53a(activity);
    }

    public final View m1431a(LayoutInflater layoutInflater, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903063, null);
        if (!C0212b.m958r(this.f48C)) {
            C0147f.m665a(inflate);
        }
        this.ar = null;
        this.aq = null;
        this.ap = new ArrayList();
        this.aK = C0212b.m948h(this.f48C);
        m1250a(inflate);
        this.aC = inflate.findViewById(2131623959);
        this.aD = (ListView) inflate.findViewById(2131624047);
        this.aE = (DragDropListView) inflate.findViewById(2131624048);
        this.aG = inflate.findViewById(2131624049);
        this.aF = (TextView) inflate.findViewById(2131624031);
        this.aH = layoutInflater.inflate(2130903084, null);
        this.aI = layoutInflater.inflate(2130903084, null);
        this.aE.addHeaderView(this.aH);
        this.aE.addFooterView(this.aI);
        this.aH.setTag(new C0414e(null, this.aH, false));
        this.aI.setTag(new C0414e(null, this.aI, false));
        this.aJ = (GradientDrawable) m70f().getDrawable(2130837551).mutate();
        this.aD.setDivider(this.aJ);
        this.aE.setDivider(this.aJ);
        this.ac.m2227a(this.am);
        this.ac.m2231b(this.an);
        this.aD.setOnItemClickListener(this.aA);
        this.aE.setOnItemClickListener(this.aB);
        this.aE.setDropListener(this.aL);
        this.aE.setRemoveListener(this.aM);
        C0426s c0426s = this.ac;
        c0426s.f2194c.setOnEditorActionListener(new ad(this));
        m1261c(bundle);
        return inflate;
    }

    public final void m1448o() {
        super.m1267o();
        this.aK = C0212b.m948h(this.f48C);
        ((TextView) this.aH.findViewById(2131624031)).setTextColor(C0209d.m875a(this.f48C).m1138g(this.Z.f1011j));
        ((TextView) this.aI.findViewById(2131624031)).setTextColor(C0209d.m875a(this.f48C).m1138g(this.Z.f1011j));
    }

    private void m1404Y() {
        if (this.aq == null) {
            this.aq = new C0415f(this.f48C, this.ap, this.Z.f1011j, this.aa);
            this.aD.setAdapter(this.aq);
        }
        this.aq.f2157a = this.aK;
        ab();
    }

    private void m1405Z() {
        if (this.ar == null) {
            this.ar = new C0413d(this.f48C, this.ap, this.Z.f1011j, this.ay, this.az, this.ax);
            this.aE.setAdapter(this.ar);
        }
        this.ar.f2141a = this.aK;
        ab();
    }

    protected final void m1427U() {
        this.aD.setVisibility(0);
        this.aE.setVisibility(8);
        this.aG.setVisibility(8);
        m1404Y();
        this.aD.setSelection(0);
    }

    protected final void m1428V() {
        this.aD.setVisibility(8);
        this.aE.setVisibility(0);
        this.aG.setVisibility(8);
        m1405Z();
        View a = C0313j.m1637a(this.aD);
        if (a == null) {
            this.aE.setSelection(0);
            return;
        }
        int positionForView = this.aD.getPositionForView(a);
        if (positionForView > 0) {
            positionForView++;
        }
        this.aE.setSelection(positionForView);
    }

    protected final boolean m1426T() {
        return true;
    }

    protected final boolean m1430X() {
        int length = this.ac.m2229b().length();
        if (this.ap.size() == 0 && length == 0) {
            return true;
        }
        return false;
    }

    private void m1414c(boolean z) {
        m1251a(new ba(this, z));
    }

    private void aa() {
        m1251a(new bb(this));
    }

    private static boolean m1411b(ArrayList arrayList) {
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((C0220j) it.next()).m1005a()) {
                return false;
            }
        }
        return true;
    }

    final DialogFragment m1443c(int i) {
        String str;
        switch (i) {
            case 2:
                str = ((C0220j) this.ap.get(this.as)).f964a;
                this.aE.requestFocus();
                return EditDialogFragment.m1398a(false, str, this);
            case 3:
                str = ((C0220j) this.ap.get(this.as)).f964a;
                this.aE.requestFocus();
                return EditDialogFragment.m1398a(true, str, this);
            case 6:
                return DialogFactory.m1118b(2131230847, 2131230777, new ag(this));
            case 8:
                return DialogFactory.m1118b(2131230821, 2131230763, new af(this));
            case 9:
                return DialogFactory.m1118b(2131230837, 2131230770, new ae(this));
            default:
                return super.m1259c(i);
        }
    }

    final void m1444d(int i) {
        if (i != 2 && i != 3) {
            super.m1263d(i);
        } else if (this.f83w) {
            m1443c(i).m85a(this.f47B, "list editor");
            this.f47B.m162b();
        }
    }

    final void m1447g(int i) {
        this.as = i;
        m1444d(2);
    }

    final void m1437a(ArrayList arrayList) {
        if (this.as >= 0 && this.as < arrayList.size()) {
            m1251a(new ak(this, arrayList));
        }
    }

    final void m1438a(ArrayList arrayList, String str) {
        if (this.as >= 0 && this.as < arrayList.size()) {
            m1251a(new al(this, str, arrayList));
        }
    }

    private void ab() {
        m1251a(new am(this));
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        try {
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            Adapter adapter = ((AdapterView) view).getAdapter();
            if (adapter != null) {
                if (view == this.aD || view == this.aE) {
                    C0220j c0220j = (C0220j) adapter.getItem(adapterContextMenuInfo.position);
                    if (c0220j != null) {
                        MenuItem findItem;
                        this.av = c0220j;
                        this.aw = (int) adapter.getItemId(adapterContextMenuInfo.position);
                        contextMenu.setHeaderTitle(c0220j.f964a);
                        this.f48C.getMenuInflater().inflate(2131558406, contextMenu);
                        if (!(Locale.getDefault() == null || Locale.getDefault().getCountry() == null || Locale.getDefault().getCountry().equals(Locale.US.getCountry()))) {
                            findItem = contextMenu.findItem(2131624177);
                            if (findItem != null) {
                                findItem.setVisible(false);
                            }
                        }
                        if (m1256a() || this.aw == -1) {
                            findItem = contextMenu.findItem(2131624030);
                            if (findItem != null) {
                                findItem.setVisible(false);
                            }
                        }
                    }
                }
            }
        } catch (ClassCastException e) {
        }
    }

    public final boolean m1442b(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131624030:
                m1255a(false, "ITEM MENU");
                m1447g(this.aw);
                return true;
            case 2131624177:
                ColorNote.m646a(this.f48C, "CHECKLIST", "AMAZON SEARCH");
                m54a(C0313j.m1674g(this.av.f964a));
                return true;
            case 2131624178:
                ColorNote.m646a(this.f48C, "CHECKLIST", "WEB SEARCH");
                m54a(C0313j.m1673f(this.av.f964a));
                return true;
            case 2131624179:
                ColorNote.m646a(this.f48C, "CHECKLIST", "ITEM CLIPBOARD");
                ((ClipboardManager) this.f48C.getSystemService("clipboard")).setText(this.av.f964a);
                Toast.makeText(this.f48C, 2131231002, 1).show();
                return true;
            default:
                return false;
        }
    }

    public final void m1434a(C0220j c0220j) {
        if (this.Z.f1004c == 0) {
            c0220j.m1004a(!c0220j.m1005a());
            m1424R();
            if (m1411b(this.ap) && C0310g.m1616a(this.Z)) {
                m1444d(109);
            }
        }
    }

    public final void m1435a(C0326m c0326m) {
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
                    AbstractEditorViewer.m1218b(c0326m, true, 2131624171, 2130837602, 2131230831);
                } else {
                    AbstractEditorViewer.m1218b(c0326m, false, 2131624171, 2130837602, 2131230831);
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

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m1441b(com.socialnmobile.colornote.menu.C0326m r9) {
        /*
        r8 = this;
        r7 = 2131624162; // 0x7f0e00e2 float:1.8875496E38 double:1.0531622683E-314;
        r4 = 2131624091; // 0x7f0e009b float:1.8875352E38 double:1.053162233E-314;
        r6 = 16;
        r3 = 0;
        r2 = 1;
        r0 = r8.aa;
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r8.b;
        if (r0 != r2) goto L_0x0072;
    L_0x0013:
        r0 = r9.m1702b(r4);
        r1 = r0.iterator();
    L_0x001b:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0035;
    L_0x0021:
        r0 = r1.next();
        r0 = (com.socialnmobile.colornote.menu.C0329p) r0;
        r4 = r8.f48C;
        r5 = r8.Z;
        r5 = r5.f1011j;
        r4 = com.socialnmobile.colornote.C0313j.m1636a(r4, r5);
        r0.m1707a(r4);
        goto L_0x001b;
    L_0x0035:
        r0 = r8.af;
        if (r0 != 0) goto L_0x0051;
    L_0x0039:
        r1 = r2;
    L_0x003a:
        r0 = r9.m1702b(r7);
        r4 = r0.iterator();
    L_0x0042:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x0053;
    L_0x0048:
        r0 = r4.next();
        r0 = (com.socialnmobile.colornote.menu.C0329p) r0;
        r0.f1447h = r1;
        goto L_0x0042;
    L_0x0051:
        r1 = r3;
        goto L_0x003a;
    L_0x0053:
        r0 = 2131624163; // 0x7f0e00e3 float:1.8875498E38 double:1.053162269E-314;
        r0 = r9.m1702b(r0);
        r5 = r0.iterator();
    L_0x005e:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x007d;
    L_0x0064:
        r0 = r5.next();
        r0 = (com.socialnmobile.colornote.menu.C0329p) r0;
        if (r1 != 0) goto L_0x0070;
    L_0x006c:
        r4 = r2;
    L_0x006d:
        r0.f1447h = r4;
        goto L_0x005e;
    L_0x0070:
        r4 = r3;
        goto L_0x006d;
    L_0x0072:
        r0 = r8.b;
        r1 = 3;
        if (r0 != r1) goto L_0x00ae;
    L_0x0077:
        r0 = r8.Z;
        r0 = r0.f1004c;
        if (r0 != 0) goto L_0x007d;
    L_0x007d:
        r0 = 2131624165; // 0x7f0e00e5 float:1.8875502E38 double:1.05316227E-314;
        r0 = r9.m1702b(r0);
        r1 = r0.iterator();
    L_0x0088:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x00fd;
    L_0x008e:
        r0 = r1.next();
        r0 = (com.socialnmobile.colornote.menu.C0329p) r0;
        r4 = r8.Z;
        r4 = r4.f1006e;
        if (r4 != r6) goto L_0x00fa;
    L_0x009a:
        r0.f1448i = r3;
    L_0x009c:
        r4 = r8.Z;
        r4 = r4.f1003b;
        if (r4 != r6) goto L_0x0088;
    L_0x00a2:
        r4 = 2130837605; // 0x7f020065 float:1.7280169E38 double:1.0527736575E-314;
        r0.m1706a(r4);
        r4 = 2131230741; // 0x7f080015 float:1.8077543E38 double:1.0529678925E-314;
        r0.f1442c = r4;
        goto L_0x0088;
    L_0x00ae:
        r0 = r8.b;
        r1 = 2;
        if (r0 != r1) goto L_0x00f3;
    L_0x00b3:
        r0 = r9.m1702b(r4);
        r1 = r0.iterator();
    L_0x00bb:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x00d5;
    L_0x00c1:
        r0 = r1.next();
        r0 = (com.socialnmobile.colornote.menu.C0329p) r0;
        r4 = r8.f48C;
        r5 = r8.Z;
        r5 = r5.f1011j;
        r4 = com.socialnmobile.colornote.C0313j.m1636a(r4, r5);
        r0.m1707a(r4);
        goto L_0x00bb;
    L_0x00d5:
        r0 = r8.af;
        if (r0 != 0) goto L_0x00f1;
    L_0x00d9:
        r1 = r2;
    L_0x00da:
        r0 = r9.m1702b(r7);
        r4 = r0.iterator();
    L_0x00e2:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x007d;
    L_0x00e8:
        r0 = r4.next();
        r0 = (com.socialnmobile.colornote.menu.C0329p) r0;
        r0.f1448i = r1;
        goto L_0x00e2;
    L_0x00f1:
        r1 = r3;
        goto L_0x00da;
    L_0x00f3:
        r0 = r8.b;
        r1 = 4;
        if (r0 != r1) goto L_0x007d;
    L_0x00f8:
        goto L_0x000e;
    L_0x00fa:
        r0.f1448i = r2;
        goto L_0x009c;
    L_0x00fd:
        r0 = r8.Z;
        r0 = r0.f1006e;
        if (r0 != r6) goto L_0x0121;
    L_0x0103:
        r1 = r2;
    L_0x0104:
        r0 = 2131624167; // 0x7f0e00e7 float:1.8875506E38 double:1.053162271E-314;
        r0 = r9.m1702b(r0);
        r5 = r0.iterator();
    L_0x010f:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0125;
    L_0x0115:
        r0 = r5.next();
        r0 = (com.socialnmobile.colornote.menu.C0329p) r0;
        if (r1 != 0) goto L_0x0123;
    L_0x011d:
        r4 = r2;
    L_0x011e:
        r0.f1447h = r4;
        goto L_0x010f;
    L_0x0121:
        r1 = r3;
        goto L_0x0104;
    L_0x0123:
        r4 = r3;
        goto L_0x011e;
    L_0x0125:
        r0 = 2131624168; // 0x7f0e00e8 float:1.8875508E38 double:1.0531622713E-314;
        r0 = r9.m1702b(r0);
        r2 = r0.iterator();
    L_0x0130:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x000e;
    L_0x0136:
        r0 = r2.next();
        r0 = (com.socialnmobile.colornote.menu.C0329p) r0;
        r0.f1447h = r1;
        goto L_0x0130;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.fragment.ListEditor.b(com.socialnmobile.colornote.menu.m):void");
    }

    public final boolean m1440a(int i, String str) {
        switch (i) {
            case 2131624030:
                m1255a(false, "MENU");
                break;
            case 2131624091:
                m1444d(101);
                break;
            case 2131624162:
                m1275z();
                break;
            case 2131624163:
                m1444d(105);
                break;
            case 2131624164:
                m1444d(104);
                break;
            case 2131624165:
                m1270u();
                break;
            case 2131624166:
                m1229H();
                break;
            case 2131624167:
                if (this.Z.m1065g() == 0) {
                    m1444d(107);
                    break;
                }
                m1444d(108);
                break;
            case 2131624168:
                m1224C();
                break;
            case 2131624169:
                m1444d(103);
                break;
            case 2131624170:
                m1273x();
                m1258b(0);
                break;
            case 2131624171:
                Context context = this.f48C;
                TopBarSubMenuInfo topBarSubMenuInfo = new TopBarSubMenuInfo(context, context.getString(2131230831), this);
                topBarSubMenuInfo.m1680a(2131624172, 2130837618, 2131230843);
                topBarSubMenuInfo.m1680a(2131624173, 2130837616, 2131230842);
                topBarSubMenuInfo.m1680a(2131624174, 2130837590, 2131230821);
                topBarSubMenuInfo.m1680a(2131624175, 2130837620, 2131230847);
                topBarSubMenuInfo.m1680a(2131624176, 2130837591, 2131230837);
                topBarSubMenuInfo.m1682a(this, this.f47B, this.ac.f2197f, false);
                break;
            case 2131624172:
                aa();
                break;
            case 2131624173:
                m1251a(new ac(this));
                break;
            case 2131624174:
                m1444d(8);
                break;
            case 2131624175:
                m1444d(6);
                break;
            case 2131624176:
                m1444d(9);
                break;
            case 2131624186:
                m1444d(102);
                break;
            case 2131624187:
                m1444d(106);
                break;
        }
        return false;
    }

    protected final void m1439a(boolean z) {
        ArrayList arrayList;
        if (z) {
            arrayList = (ArrayList) this.ap.clone();
        } else {
            arrayList = this.ap;
        }
        m1413c(arrayList);
        this.ah = false;
        this.Z.f1008g = m1421O();
        m1409a(arrayList, this.Z.f1008g, this.Z.f1011j, this.Z.f1014m);
    }

    protected final void m1429W() {
        m1409a(C0269a.m1204b(this.g), this.h, this.i, this.Z.f1014m);
        this.Y.requery();
        m1231J();
    }

    private void m1409a(ArrayList arrayList, String str, int i, int i2) {
        int a;
        String a2 = C0269a.m1203a(arrayList);
        if (m1411b(arrayList)) {
            a = C0229s.m1033a(this.Z.f1005d, 16, 16);
        } else {
            a = C0229s.m1033a(this.Z.f1005d, 0, 16);
        }
        m1253a(str, a2, a, i, i2);
    }

    private void m1413c(ArrayList arrayList) {
        if (!this.at) {
            if (this.au != null) {
                m1438a(arrayList, this.au.m1403t());
            } else {
                m1437a(arrayList);
            }
        }
        if (C0212b.m956p(this.f48C)) {
            Collections.sort(arrayList, new bh());
        }
        if (arrayList == this.ap) {
            ab();
        }
    }

    protected final String m1420N() {
        ArrayList arrayList = (ArrayList) this.ap.clone();
        m1413c(arrayList);
        return C0269a.m1203a(arrayList);
    }

    protected final String m1421O() {
        String b = this.ac.m2229b();
        if (b.equals("")) {
            return m1232K();
        }
        return b;
    }

    protected final void m1423Q() {
        int i = this.Z.f1004c;
        if (this.aa) {
            m1231J();
            this.ac.m2225a(1);
            this.aD.setOnItemClickListener(null);
            this.aD.setOnCreateContextMenuListener(this);
            this.aE.setOnCreateContextMenuListener(null);
        } else if (i == 16) {
            m1231J();
            this.ac.m2225a(2);
            this.aD.setOnItemClickListener(null);
            this.aD.setOnCreateContextMenuListener(this);
            this.aE.setOnCreateContextMenuListener(null);
        } else if (i == 32) {
            m1231J();
            this.ac.m2225a(3);
            this.aG.setVisibility(0);
            this.aD.setOnItemClickListener(null);
            this.aD.setOnCreateContextMenuListener(null);
            this.aE.setOnCreateContextMenuListener(null);
        } else if (i == 0) {
            if (this.b == 3) {
                m1231J();
                this.ac.m2225a(4);
            }
            this.aD.setOnItemClickListener(this.aA);
            this.aD.setOnCreateContextMenuListener(this);
            this.aE.setOnCreateContextMenuListener(this);
        }
        if (m1256a()) {
            m1405Z();
        } else {
            m1404Y();
        }
        this.a.post(new au(this));
    }

    protected final void m1425S() {
        C0310g.m1615a(this.f48C, this.c);
        this.b = 4;
        m1446f(8);
        this.aD.setVisibility(8);
        this.aE.setVisibility(8);
        this.aF.setVisibility(0);
        this.aF.setText(m72g());
        this.ad.m2215a();
        this.ac.m2232c();
    }

    protected final void m1446f(int i) {
        C0262d a = C0209d.m875a(this.f48C);
        this.Z.f1011j = i;
        this.ac.m2230b(i);
        this.aF.setBackgroundColor(a.m1133b(i));
        this.aD.setBackgroundColor(a.m1133b(i));
        this.aE.setBackgroundColor(a.m1133b(i));
        this.aC.setBackgroundColor(a.m1133b(i));
        this.ad.m2216a(i);
        this.aJ.setColor(a.m1135d(i));
        this.aD.setBackgroundColor(a.m1133b(i));
        this.aD.setCacheColorHint(a.m1133b(i));
        this.aE.setBackgroundColor(a.m1133b(i));
        this.aE.setCacheColorHint(0);
        this.aE.setColor(i);
        if (this.aq != null) {
            this.aq.f2158b = i;
        }
        if (this.ar != null) {
            this.ar.f2143c = i;
        }
        m1424R();
    }

    protected final void m1424R() {
        C0262d a = C0209d.m875a(this.f48C);
        if (m1256a()) {
            this.ac.m2226a(1, a, this.Z.f1011j);
        } else if (m1411b(this.ap) || (!this.ai && this.Z.m1059a())) {
            this.ac.m2226a(2, a, this.Z.f1011j);
        } else {
            this.ac.m2226a(3, a, this.Z.f1011j);
        }
    }

    protected final void m1422P() {
        m1251a(new ay(this));
    }

    protected final void m1436a(String str) {
        m1251a(new az(this, str));
    }
}
