package com.socialnmobile.colornote.fragment;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.text.format.Time;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.activity.Main;
import com.socialnmobile.colornote.data.C0210a;
import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.data.C0230t;
import com.socialnmobile.colornote.dialog.C0170m;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.dialog.DialogFactory.ColorListSelectionDialogFragment;
import com.socialnmobile.colornote.dialog.DialogFactory.NotesOptionsDialogFragment;
import com.socialnmobile.colornote.dialog.DialogFactory.TextInputDialogFragment;
import com.socialnmobile.colornote.menu.C0164q;
import com.socialnmobile.colornote.menu.C0330r;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.view.ScreenGridList;
import com.socialnmobile.colornote.view.bu;
import java.util.HashMap;

public abstract class NoteListFragment extends ScreenFragment {
    protected Handler f1157Y;
    public cd f1158Z;
    public bu aa;
    protected ce ab;
    C0230t ac;
    protected Uri ad;
    protected int ae;
    protected int af;
    protected Time ag;
    protected int ah;
    OnMenuItemClickListener ai;
    OnItemClickListener aj;
    C0170m ak;
    C0170m al;
    C0170m am;
    C0170m an;
    C0170m ao;
    OnClickListener ap;
    public HashMap f1159i;

    public abstract ScreenGridList m1294A();

    public abstract void m1295B();

    public abstract String m1296C();

    public abstract void m1308a(String str);

    public abstract void m1309b(int i);

    public abstract void m1311b(String str);

    public abstract void m1314c(int i);

    public abstract Uri m1321z();

    public NoteListFragment() {
        this.f1159i = new HashMap();
        this.f1157Y = new Handler();
        this.aa = new bu();
        this.ab = new ce();
        this.ai = new bn(this);
        this.aj = new bo(this);
        this.ak = new bp(this);
        this.al = new bq(this);
        this.am = new br(this);
        this.an = new bs(this);
        this.ao = new bu(this);
        this.ap = new bv(this);
    }

    public void m1305a(Activity activity) {
        super.m1285a(activity);
        String action = activity.getIntent().getAction();
        if ("android.intent.action.PICK".equals(action) || "android.intent.action.GET_CONTENT".equals(action)) {
            this.ah = 1;
        } else {
            this.ah = 0;
        }
    }

    public void m1306a(Bundle bundle) {
        super.m1287a(bundle);
    }

    public final void m1303a(int i, int i2, Intent intent) {
        super.m51a(i, i2, intent);
        if (i == 1001 && i2 == -1) {
            m1318e(1013);
        } else if (i == 2000 && i2 == 5000 && this.f48C != null && (this.f48C instanceof Main)) {
            ((Main) this.f48C).m724g();
        }
    }

    public final void m1313c() {
        super.m65c();
        if (this.ab.f1281a != null && !this.ab.f1281a.isClosed()) {
            this.ab.f1281a.requery();
        }
    }

    public final void m1317d() {
        super.m66d();
    }

    DialogFragment m1315d(int i) {
        DialogFragment dialogFragment = null;
        switch (i) {
            case 1004:
                dialogFragment = DialogFactory.m1115a(2131230824, 2131230769, new bw(this));
                break;
            case 1005:
                dialogFragment = DialogFactory.m1115a(2131230824, 2131230769, new bx(this));
                break;
            case 1006:
                dialogFragment = DialogFactory.m1117a(this.am);
                break;
            case 1009:
                dialogFragment = DialogFactory.m1118b(2131230821, 2131230763, new by(this));
                break;
            case 1010:
                dialogFragment = DialogFactory.m1118b(2131230847, 2131230777, new bz(this));
                break;
            case 1011:
                dialogFragment = DialogFactory.m1117a(this.an);
                break;
            case 1012:
                dialogFragment = DialogFactory.m1117a(this.ao);
                break;
            case 1013:
                dialogFragment = DialogFactory.m1117a(this.ak);
                break;
            case 1014:
                dialogFragment = DialogFactory.m1117a(this.al);
                break;
            case 1015:
                dialogFragment = new TextInputDialogFragment(this.f48C, new ca(this));
                break;
            case 1016:
                dialogFragment = DialogFactory.m1115a(2131230819, 2131230761, new bi(this));
                break;
            case 1017:
                dialogFragment = DialogFactory.m1115a(2131230819, 2131230762, new bt(this));
                break;
            case 1018:
                dialogFragment = DialogFactory.m1115a(2131230836, 2131230768, new cb(this));
                break;
            case 1020:
                dialogFragment = new ColorListSelectionDialogFragment(this);
                break;
            case 1021:
                dialogFragment = new NotesOptionsDialogFragment(this);
                break;
        }
        switch (i) {
            case 1015:
                ((TextInputDialogFragment) dialogFragment).f1046Y.f1058c = C0213c.m959a(this.f48C, this.af, this.ae);
                break;
        }
        return dialogFragment;
    }

    public final ce m1297G() {
        return this.ab;
    }

    void m1318e(int i) {
        this.f1157Y.post(new cc(this, m1315d(i)));
    }

    void m1304a(int i, boolean z) {
        TopBarSubMenuInfo a;
        switch (i) {
            case 2001:
                a = C0330r.m1711a((ScreenFragment) this, m1312c("MENU"));
                break;
            case 2004:
                Context context = this.f48C;
                a = new TopBarSubMenuInfo(context, context.getString(2131230834), new bk(this));
                a.m1680a(-1, 2130837588, 2131230731);
                a.m1680a(0, 2130837593, 2131231001);
                a.m1680a(16, 2130837604, 2131230744);
                break;
            case 2005:
                a = C0330r.m1710a(this.f48C, new bj(this), null);
                break;
            default:
                a = null;
                break;
        }
        if (z || this.ar.m685b() == null) {
            a.m1682a(this, this.f47B, null, true);
        } else {
            a.m1682a(this, this.f47B, this.ar.m685b().f2130f[0], false);
        }
    }

    public final C0164q m1312c(String str) {
        return new bl(this, str);
    }

    public final C0164q m1316d(String str) {
        return new bm(this, str);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        if (this.ah != 1) {
            try {
                AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
                if (((AdapterView) view).getAdapter() != null) {
                    Object item = ((AdapterView) view).getAdapter().getItem(adapterContextMenuInfo.position);
                    if (item != null) {
                        C0230t c0230t;
                        if (item instanceof Cursor) {
                            c0230t = new C0230t((Cursor) item);
                        } else {
                            c0230t = (C0230t) item;
                        }
                        this.ac = c0230t;
                        contextMenu.setHeaderTitle(c0230t.f1008g);
                        if (c0230t.f1006e == 16) {
                            contextMenu.add(0, 1014, 0, 2131230845).setOnMenuItemClickListener(this.ai);
                        } else {
                            contextMenu.add(0, 1013, 0, 2131230819).setOnMenuItemClickListener(this.ai);
                        }
                        if (c0230t.m1063e()) {
                            contextMenu.add(0, 1002, 0, 2131230824).setOnMenuItemClickListener(this.ai);
                        } else {
                            contextMenu.add(0, 1, 0, 2131230824).setOnMenuItemClickListener(this.ai);
                        }
                        if (c0230t.f1007f == 16) {
                            if (c0230t.m1059a()) {
                                if (c0230t.m1063e()) {
                                    contextMenu.add(0, 1009, 0, 2131230847).setOnMenuItemClickListener(this.ai);
                                } else {
                                    contextMenu.add(0, 1007, 0, 2131230847).setOnMenuItemClickListener(this.ai);
                                }
                            } else if (c0230t.m1063e()) {
                                contextMenu.add(0, 1008, 0, 2131230821).setOnMenuItemClickListener(this.ai);
                            } else {
                                contextMenu.add(0, 1006, 0, 2131230821).setOnMenuItemClickListener(this.ai);
                            }
                        } else if (c0230t.m1059a()) {
                            contextMenu.add(0, 1005, 0, 2131230846).setOnMenuItemClickListener(this.ai);
                        } else {
                            contextMenu.add(0, 1004, 0, 2131230820).setOnMenuItemClickListener(this.ai);
                        }
                        if (c0230t.f1006e != 16) {
                            contextMenu.add(0, 1012, 0, 2131230836).setOnMenuItemClickListener(this.ai);
                        }
                        if (c0230t.m1063e()) {
                            contextMenu.add(0, 1011, 0, 2131230848).setOnMenuItemClickListener(this.ai);
                        } else {
                            contextMenu.add(0, 1010, 0, 2131230832).setOnMenuItemClickListener(this.ai);
                        }
                    }
                }
            } catch (ClassCastException e) {
                ColorNote.m651a("bad menuInfo");
            }
        }
    }

    protected final void m1298H() {
        this.ah = 1;
    }

    public final int m1299I() {
        return this.ah;
    }

    protected final void m1307a(View view) {
        this.aa.m2204a(view, this);
        this.aa.m2203a(this.ap);
    }

    public final void m1302a(int i, int i2) {
        this.af = i;
        this.ae = i2;
        m1318e(1015);
    }

    public final void m1320g(int i) {
        C0210a.m897a(this.f48C, "ADD_NEW_CLICKED", 1);
        Intent intent = new Intent("android.intent.action.INSERT", m1321z());
        intent.putExtra("socialnmobile.intent.extra.TYPE", i);
        intent.putExtra("socialnmobile.intent.extra.FOLDER", 16);
        intent.putExtra("socialnmobile.intent.extra.REMINDER_TYPE", 16);
        intent.putExtra("socialnmobile.intent.extra.REMINDER_DATE", C0147f.m661a(this.ag, true));
        if (this.ab.f1283c != 0) {
            intent.putExtra("socialnmobile.intent.extra.COLOR", this.ab.f1283c);
        }
        m54a(intent);
    }

    public final void m1310b(long j) {
        Intent intent = new Intent("android.intent.action.VIEW", ContentUris.withAppendedId(m1321z(), j));
        intent.putExtra("EXTRA_VIEW_FROM", m1296C());
        try {
            m55a(intent, 2000);
        } catch (RuntimeException e) {
            try {
                if (this.f48C != null) {
                    this.f48C.startActivityForResult(intent, 2000);
                } else {
                    m1293a(e, "UI:View:Level 1");
                }
            } catch (RuntimeException e2) {
                m1293a(e2, "UI:View:Level 2");
            }
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (m1294A() != null) {
            m1294A().m2143a();
        }
    }

    final void m1300J() {
        C0229s.m1050b(this.f48C, this.ad);
        Toast.makeText(this.f48C, 2131230854, 0).show();
    }

    final void m1301K() {
        C0229s.m1051c(this.f48C, this.ad);
        Toast.makeText(this.f48C, 2131230878, 0).show();
    }

    final void m1319f(int i) {
        C0210a.m897a(this.f48C, "ADD_NEW_CLICKED", 1);
        Intent intent = new Intent("android.intent.action.INSERT", m1321z());
        intent.putExtra("socialnmobile.intent.extra.TYPE", i);
        intent.putExtra("socialnmobile.intent.extra.FOLDER", 0);
        if (this.ab.f1283c != 0) {
            intent.putExtra("socialnmobile.intent.extra.COLOR", this.ab.f1283c);
        }
        m54a(intent);
    }

    private void m1293a(RuntimeException runtimeException, String str) {
        Toast.makeText(this.f48C, 2131231050, 1).show();
        C0311h.f1370a.m1624a(str, runtimeException);
    }
}
