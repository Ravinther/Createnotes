package com.socialnmobile.colornote.fragment;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.C0015f;
import android.support.v4.app.DialogFragment;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0267e;
import com.socialnmobile.colornote.C0310g;
import com.socialnmobile.colornote.C0312i;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.activity.PasswordSetting;
import com.socialnmobile.colornote.activity.ReminderSettings;
import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.data.C0222l;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.data.C0230t;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.dialog.C0170m;
import com.socialnmobile.colornote.dialog.C0242f;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.dialog.DialogFactory.ColorSelectorDialogFragment;
import com.socialnmobile.colornote.dialog.DialogFactory.ConfirmDialogFragment;
import com.socialnmobile.colornote.dialog.DialogFactory.DownloadColorDictDialogFragment;
import com.socialnmobile.colornote.dialog.DialogFactory.EnterPasswordDialogFragment;
import com.socialnmobile.colornote.menu.C0273k;
import com.socialnmobile.colornote.menu.C0326m;
import com.socialnmobile.colornote.receiver.C0332a;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.view.C0422m;
import com.socialnmobile.colornote.view.C0426s;
import com.socialnmobile.colornote.view.C0427t;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractEditorViewer extends C0015f implements C0273k {
    protected Cursor f1146Y;
    protected C0230t f1147Z;
    protected Handler f1148a;
    protected boolean aa;
    C0326m ab;
    protected C0426s ac;
    protected C0422m ad;
    protected View ae;
    protected String af;
    protected boolean ag;
    protected boolean ah;
    protected boolean ai;
    protected boolean aj;
    C0170m ak;
    OnCancelListener al;
    OnClickListener am;
    OnClickListener an;
    protected C0242f ao;
    private boolean ap;
    private boolean aq;
    private boolean ar;
    private int as;
    private boolean at;
    protected int f1149b;
    protected Uri f1150c;
    protected String f1151d;
    protected String f1152e;
    protected int f1153f;
    protected String f1154g;
    protected String f1155h;
    protected int f1156i;

    protected abstract String m1235N();

    protected abstract String m1236O();

    protected abstract void m1237P();

    protected abstract void m1238Q();

    protected abstract void m1239R();

    protected abstract void m1240S();

    protected abstract boolean m1241T();

    protected abstract void m1242U();

    protected abstract void m1243V();

    protected abstract void m1244W();

    protected abstract boolean m1245X();

    protected abstract void m1252a(String str);

    protected abstract void m1254a(boolean z);

    protected abstract void m1266f(int i);

    public AbstractEditorViewer() {
        this.f1148a = new Handler();
        this.f1149b = 0;
        this.aa = false;
        this.af = null;
        this.ah = false;
        this.ai = true;
        this.aj = false;
        this.ap = true;
        this.aq = false;
        this.ar = false;
        this.as = -1;
        this.at = false;
        this.ak = new C0294r(this);
        this.al = new C0295s(this);
        this.am = new C0296t(this);
        this.an = new C0297u(this);
        this.ao = new C0277b(this);
    }

    public static AbstractEditorViewer m1216a(int i, String str, Uri uri, String str2) {
        AbstractEditorViewer abstractEditorViewer = null;
        switch (i) {
            case 0:
                abstractEditorViewer = new TextEditor();
                break;
            case 16:
                abstractEditorViewer = new ListEditor();
                break;
        }
        if (abstractEditorViewer != null) {
            Bundle bundle = new Bundle();
            bundle.putString("action", str);
            bundle.putParcelable("data", uri);
            bundle.putString("viewFrom", str2);
            abstractEditorViewer.m71f(bundle);
        }
        return abstractEditorViewer;
    }

    public void m1248a(Bundle bundle) {
        super.m56a(bundle);
        m1247a(this.f48C);
        if ("WIDGET".equals(this.f77q.getString("viewFrom")) && this.f48C != null) {
            C0367b.m1870b(this.f48C.getApplicationContext());
        }
        Cursor cursor = ((EditorContainer) this.f78r).f1175a;
        cursor.registerContentObserver(new C0291o(this, new Handler(), cursor));
        cursor.registerDataSetObserver(new C0292p(this));
        this.f1146Y = cursor;
    }

    public void m1267o() {
        super.m78o();
        if (this.as > 0) {
            m1263d(this.as);
            this.as = -1;
        }
    }

    public void m1268p() {
        super.m79p();
        if (this.ab != null) {
            this.ab.m1704c();
        }
        this.aq = false;
        if (this.f1146Y != null && VERSION.SDK_INT < 11) {
            this.aq = m1220c(true);
        }
    }

    public final void m1260c() {
        super.m65c();
        this.at = false;
    }

    public final void m1262d() {
        super.m66d();
        boolean c;
        if (this.f1146Y != null) {
            c = m1220c(false);
        } else {
            c = false;
        }
        if (this.aq || r0) {
            Toast.makeText(this.f48C, 2131230892, 0).show();
            this.at = true;
        }
        if (this.aj) {
            this.aj = false;
        } else {
            this.af = null;
        }
        this.as = -1;
        if (this.at && this.f48C != null) {
            C0367b.m1870b(this.f48C.getApplicationContext());
        }
    }

    protected final void m1250a(View view) {
        this.ac = new C0426s(view.findViewById(2131624044));
        this.ae = view.findViewById(2131624045);
        this.ad = new C0422m(view.findViewById(2131624046));
        C0426s c0426s = this.ac;
        c0426s.f2199h = new GestureDetector(c0426s.f2192a, new C0274a(this));
        c0426s.f2194c.setOnTouchListener(new C0427t(c0426s));
        c0426s = this.ac;
        c0426s.f2198g.setOnClickListener(new C0288l(this));
        view.findViewById(2131624062).setOnClickListener(new C0290n(this));
    }

    protected final void m1261c(Bundle bundle) {
        this.f1147Z = new C0230t();
        if (bundle != null) {
            m1264e(bundle.getInt("state"));
            this.f1150c = Uri.parse(bundle.getString("uri"));
            this.f1154g = bundle.getString("origNote");
            this.f1155h = bundle.getString("origTitle");
            this.f1156i = bundle.getInt("origColor");
            this.f1151d = bundle.getString("savedNote");
            this.f1152e = bundle.getString("savedTitle");
            this.f1153f = bundle.getInt("savedColor");
        } else if (this.f1149b == 0 || this.f1150c == null || this.f1154g == null || this.f1155h == null || this.f1156i == 0) {
            Bundle bundle2 = this.f77q;
            String string = bundle2.getString("action");
            this.f1150c = (Uri) bundle2.getParcelable("data");
            if ("android.intent.action.EDIT".equals(string)) {
                m1264e(1);
            } else if ("android.intent.action.VIEW".equals(string)) {
                m1264e(3);
            } else if ("android.intent.action.INSERT".equals(string)) {
                m1264e(2);
            }
        } else {
            m1264e(this.f1149b);
        }
        if (this.f1150c == null) {
            ColorNote.m651a("Failed to insert new note into ");
            m1258b(0);
            return;
        }
        if (this.f1150c.getPath().startsWith("/tempnotes")) {
            this.aa = true;
        }
        switch (this.f1149b) {
            case 1:
                m1255a(false, "INIT");
                break;
            case 2:
                if (this.f1150c != null) {
                    this.f48C.setResult(-1, new Intent().setAction(this.f1150c.toString()));
                }
                m1255a(true, "INIT");
                break;
            case 3:
                break;
            default:
                ColorNote.m651a("Unknown state, exiting");
                m1258b(0);
                return;
        }
        m1230I();
    }

    protected final boolean m1256a() {
        return this.f1149b == 1 || this.f1149b == 2;
    }

    public final void m1269t() {
        Object obj;
        C0422m c0422m = this.ad;
        boolean a = m1256a();
        if (this.af != null) {
            obj = 1;
        } else {
            obj = null;
        }
        C0230t c0230t = this.f1147Z;
        int i = c0230t.f1004c;
        long j = c0230t.f1010i;
        long g = c0230t.m1065g();
        c0230t.m1064f();
        long h = c0230t.m1066h();
        int i2 = c0230t.f1014m;
        int i3 = c0230t.f1015n;
        int i4 = c0230t.f1011j;
        i4 = C0209d.m875a(c0422m.f2182a).m1139h(i4);
        c0422m.f2187f.setVisibility(8);
        if (c0230t.f1014m != 0 && g == 0) {
            c0422m.f2187f.setVisibility(0);
            c0422m.f2187f.setImageResource(2130837661);
        }
        c0422m.f2183b.setText(C0313j.m1640a(c0422m.f2182a, j));
        Drawable drawable;
        if (i == 16) {
            c0422m.f2183b.setText(2131230948);
            drawable = c0422m.f2182a.getResources().getDrawable(2130837577);
            drawable.setColorFilter(i4, Mode.MULTIPLY);
            c0422m.f2184c.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
            c0422m.f2184c.setTypeface(Typeface.DEFAULT, 0);
            c0422m.f2184c.setText(C0267e.m1197b(c0422m.f2182a, j));
        } else if (i2 == 32 && h != 0) {
            c0422m.f2184c.setTypeface(Typeface.DEFAULT, 0);
            if (g > System.currentTimeMillis()) {
                c0422m.f2184c.setText(C0267e.m1197b(c0422m.f2182a, g));
            } else {
                c0422m.f2184c.setText(C0267e.m1197b(c0422m.f2182a, h));
            }
            drawable = c0422m.f2182a.getResources().getDrawable(2130837580);
            drawable.setColorFilter(i4, Mode.MULTIPLY);
            c0422m.f2184c.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        } else if (i2 == 16 && h != 0) {
            c0422m.f2184c.setTypeface(Typeface.DEFAULT, 0);
            if (i3 == 144 && g != 0) {
                c0422m.f2184c.setText(2131230887);
            } else if (g > System.currentTimeMillis()) {
                c0422m.f2184c.setText(C0267e.m1196a(c0422m.f2182a, g));
            } else {
                c0422m.f2184c.setText(C0267e.m1196a(c0422m.f2182a, h));
            }
            drawable = c0422m.f2182a.getResources().getDrawable(2130837575);
            drawable.setColorFilter(i4, Mode.MULTIPLY);
            c0422m.f2184c.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
        } else if (i2 == 128) {
            drawable = c0422m.f2182a.getResources().getDrawable(2130837579);
            drawable.setColorFilter(i4, Mode.MULTIPLY);
            c0422m.f2184c.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
            c0422m.f2184c.setTypeface(Typeface.DEFAULT, 0);
            c0422m.f2184c.setText(C0267e.m1196a(c0422m.f2182a, j));
        } else {
            c0422m.f2184c.setTypeface(Typeface.DEFAULT, 0);
            c0422m.f2184c.setText(C0267e.m1197b(c0422m.f2182a, j));
            c0422m.f2184c.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
        if (a) {
            c0422m.f2183b.setText(2131230790);
        }
        if (i3 == 0 || g == 0) {
            c0422m.f2185d.setVisibility(8);
        } else {
            c0422m.f2185d.setVisibility(0);
        }
        if (obj != null) {
            c0422m.f2186e.setVisibility(0);
        } else {
            c0422m.f2186e.setVisibility(8);
        }
    }

    protected final void m1270u() {
        if (this.f1146Y != null) {
            Intent intent = new Intent(this.f48C, ReminderSettings.class);
            intent.putExtra("_id", this.f1147Z.f1002a);
            intent.putExtra(NoteMinorColumns.FOLDER, this.f1147Z.f1003b);
            intent.putExtra(NoteMinorColumns.REMINDER_TYPE, this.f1147Z.f1014m);
            intent.putExtra(NoteMinorColumns.REMINDER_REPEAT, this.f1147Z.f1015n);
            intent.putExtra(NoteMinorColumns.REMINDER_BASE, this.f1147Z.m1064f());
            intent.putExtra(NoteMinorColumns.REMINDER_DATE, this.f1147Z.m1065g());
            intent.putExtra(NoteMinorColumns.REMINDER_REPEAT_END, this.f1147Z.m1067i());
            this.aj = true;
            m55a(intent, 2);
        }
    }

    protected final void m1271v() {
        if (this.f1146Y != null) {
            this.f1146Y.close();
            this.f1146Y = null;
            C0229s.m1046a(this.f48C, this.f1150c, "EDITOR");
        }
    }

    protected final void m1272w() {
        if (this.f1146Y != null && m1214Y() && !this.aa) {
            this.f1146Y.close();
            this.f1146Y = null;
            C0229s.m1052d(this.f48C, this.f1150c);
        }
    }

    protected final void m1273x() {
        if (this.f1146Y != null) {
            this.f1146Y.close();
            this.f1146Y = null;
            Context context = this.f48C;
            Uri uri = this.f1150c;
            context.getContentResolver().delete(uri, null, null);
            C0332a.m1725a(context, uri);
            C0310g.m1618b(context, System.currentTimeMillis());
        }
    }

    protected final void m1274y() {
        this.ah = true;
        this.af = null;
        m1269t();
    }

    protected final void m1275z() {
        if (C0213c.m961a(this.f48C)) {
            this.ag = true;
            m1263d(100);
            return;
        }
        m55a(new Intent(this.f48C, PasswordSetting.class), 1);
    }

    private boolean m1220c(boolean z) {
        if (!m1214Y() || this.aa) {
            return false;
        }
        boolean z2;
        Context context;
        int i;
        if (!(this.f1151d.length() == 0 && this.f1152e.length() == 0 && m1245X())) {
            if (!this.f1151d.equals(m1235N())) {
                z2 = true;
            } else if (!this.f1152e.equals(m1236O())) {
                z2 = true;
            } else if (this.ah) {
                z2 = true;
            }
            if (z2) {
                if (this.f1153f == this.f1147Z.f1011j) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    return false;
                }
                int i2 = this.f1147Z.f1011j;
                this.f1153f = i2;
                context = this.f48C;
                Uri uri = this.f1150c;
                i = this.f1147Z.f1014m;
                ContentValues contentValues = new ContentValues();
                contentValues.put(NoteMinorColumns.COLOR, Integer.valueOf(i2));
                context.getContentResolver().update(uri, contentValues, null, null);
                C0332a.m1725a(context, uri);
                if (i == 16) {
                    C0332a.m1733b(context);
                }
            } else {
                m1254a(z);
            }
            return true;
        }
        z2 = false;
        if (z2) {
            if (this.f1153f == this.f1147Z.f1011j) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                return false;
            }
            int i22 = this.f1147Z.f1011j;
            this.f1153f = i22;
            context = this.f48C;
            Uri uri2 = this.f1150c;
            i = this.f1147Z.f1014m;
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put(NoteMinorColumns.COLOR, Integer.valueOf(i22));
            context.getContentResolver().update(uri2, contentValues2, null, null);
            C0332a.m1725a(context, uri2);
            if (i == 16) {
                C0332a.m1733b(context);
            }
        } else {
            m1254a(z);
        }
        return true;
    }

    protected final void m1222A() {
        if (m1220c(false)) {
            Toast.makeText(this.f48C, 2131230892, 0).show();
            this.at = true;
        }
        this.f1154g = null;
        this.f1155h = null;
        this.f1156i = 0;
        this.f1151d = null;
        this.f1152e = null;
        this.f1153f = 0;
        if (this.f1146Y != null) {
            this.f1146Y.requery();
        } else {
            m1258b(0);
        }
    }

    protected final void m1258b(int i) {
        if (this.f1150c != null) {
            ((EditorContainer) this.f78r).m1394a(i, new Intent().setAction(this.f1150c.toString()));
        } else {
            ((EditorContainer) this.f78r).m1394a(i, null);
        }
    }

    protected final boolean m1225D() {
        if (!m1245X()) {
            m1222A();
            m1231J();
            return true;
        } else if (this.f1149b == 1) {
            m1272w();
            m1258b(0);
            return true;
        } else if (this.f1149b != 2) {
            return false;
        } else {
            m1273x();
            m1258b(0);
            return true;
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m1247a(this.f48C);
        m1219c(this.ab);
        this.ac.m2224a();
    }

    protected final void m1253a(String str, String str2, int i, int i2, int i3) {
        this.f1151d = str2;
        this.f1152e = str;
        this.f1153f = i2;
        if (this.af != null) {
            C0222l a = C0222l.m1007a(this.f48C);
            int i4 = a.f973b;
            C0229s.m1044a(this.f48C, this.f1150c, i, a.m1018c(str2), str, i2, i4, i3);
            return;
        }
        C0229s.m1044a(this.f48C, this.f1150c, i, str2, str, i2, 0, i3);
    }

    public void m1265e(Bundle bundle) {
        super.m69e(bundle);
        bundle.putInt("state", this.f1149b);
        bundle.putString("uri", this.f1150c.toString());
        bundle.putString("origNote", this.f1154g);
        bundle.putString("origTitle", this.f1155h);
        bundle.putInt("origColor", this.f1156i);
        bundle.putString("savedNote", this.f1151d);
        bundle.putString("savedTitle", this.f1152e);
        bundle.putInt("savedColor", this.f1153f);
    }

    public boolean m1226E() {
        return true;
    }

    public boolean m1227F() {
        return m1256a();
    }

    public boolean m1228G() {
        if (m1256a() && m1225D()) {
            return true;
        }
        return false;
    }

    DialogFragment m1259c(int i) {
        switch (i) {
            case 100:
                return new EnterPasswordDialogFragment(this.ak, this.al);
            case 101:
                return new ColorSelectorDialogFragment(this.f1147Z.f1003b, this.f1147Z.f1011j, this.ao);
            case 102:
                return DialogFactory.m1118b(2131231072, 2131230773, new C0282f(this));
            case 103:
                return DialogFactory.m1115a(2131230824, 2131230769, new C0283g(this));
            case 104:
                return DialogFactory.m1115a(2131230838, 2131230774, new C0279d(this));
            case 105:
                return DialogFactory.m1118b(2131230848, 2131230778, new C0278c(this));
            case 106:
                return DialogFactory.m1115a(2131230825, 2131230766, new C0281e(this));
            case 107:
                return DialogFactory.m1115a(2131230819, 2131230761, new C0284h(this));
            case 108:
                return DialogFactory.m1115a(2131230819, 2131230762, new C0285i(this));
            case 109:
                return DialogFactory.m1115a(2131230836, 2131230768, new C0286j(this));
            case 110:
                return new ConfirmDialogFragment(0, 2131230858, 2131230857, false, new C0287k(this));
            case 112:
                return new DownloadColorDictDialogFragment();
            default:
                return null;
        }
    }

    void m1263d(int i) {
        this.f1148a.post(new C0289m(this, i));
    }

    public final void m1246a(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            m1275z();
        }
    }

    private boolean m1214Y() {
        if (this.f1154g == null || this.f1155h == null || !this.ai) {
            return false;
        }
        return true;
    }

    private void m1221d(boolean z) {
        if (z || !this.f1147Z.m1060b()) {
            this.ae.setVisibility(8);
        } else {
            this.ae.setVisibility(0);
        }
    }

    public final void m1230I() {
        if (this.f1146Y == null) {
            m1240S();
        } else if (this.f1146Y.moveToFirst()) {
            this.f1147Z.m1058a(this.f1146Y);
            if (this.ap) {
                Bundle bundle = this.f77q;
                String string = bundle.getString("action");
                Object string2 = bundle.getString("viewFrom");
                if (string2 == null) {
                    string2 = "";
                }
                Map hashMap = new HashMap();
                hashMap.put("Folder", this.f1147Z.f1003b);
                hashMap.put("Type", this.f1147Z.f1007f);
                if ("android.intent.action.VIEW".equals(string)) {
                    boolean z;
                    if ((this.f1147Z.f1005d & 16384) == 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        hashMap.put("Type", "SAMPLE " + this.f1147Z.f1007f);
                    }
                    hashMap.put("Source", string2);
                    ColorNote.m649a(this.f48C, "NOTE", "VIEW", hashMap);
                } else if ("android.intent.action.INSERT".equals(string)) {
                    ColorNote.m649a(this.f48C, "NOTE", "INSERT", hashMap);
                } else {
                    "android.intent.action.EDIT".equals(string);
                }
                this.ap = false;
            }
            m1266f(this.f1147Z.f1011j);
            this.ac.m2228a(this.f1147Z.f1008g);
            m1269t();
            if (this.f1147Z.f1014m == 32) {
                C0310g.m1615a(this.f48C, this.f1150c);
            }
            if (VERSION.SDK_INT >= 11) {
                if (this.f1147Z.m1063e()) {
                    this.f48C.getWindow().setFlags(8192, 8192);
                } else {
                    this.f48C.getWindow().clearFlags(8192);
                }
            }
            if (!this.f1147Z.m1063e() || this.af != null) {
                this.ai = true;
                String a = this.f1147Z.m1057a(this.f48C);
                m1252a(a);
                if (this.f1154g == null) {
                    this.f1151d = a;
                    this.f1154g = a;
                    a = this.f1147Z.f1008g;
                    this.f1152e = a;
                    this.f1155h = a;
                    int i = this.f1147Z.f1011j;
                    this.f1153f = i;
                    this.f1156i = i;
                }
            } else if (C0213c.m961a(this.f48C)) {
                this.ai = false;
                this.ag = false;
                m1263d(100);
                m1237P();
            } else {
                m55a(new Intent(this.f48C, PasswordSetting.class), 1);
                m1258b(-1);
                return;
            }
            m1239R();
            m1221d(false);
            m1238Q();
        } else {
            m1240S();
        }
    }

    protected final void m1231J() {
        m1264e(3);
        C0426s c0426s = this.ac;
        c0426s.f2203l = 2;
        c0426s.f2202k = true;
        c0426s.f2194c.setSelected(false);
        c0426s.f2194c.setFocusable(false);
        c0426s.f2194c.setFocusableInTouchMode(false);
        c0426s.f2194c.setEnabled(true);
        c0426s.f2195d.setImageResource(2130837568);
        c0426s.f2195d.setEnabled(true);
        c0426s.f2195d.setVisibility(0);
        c0426s.f2196e.setVisibility(8);
        c0426s.f2193b.setDescendantFocusability(393216);
        c0426s.f2193b.requestFocus();
        c0426s.m2224a();
        m1269t();
        m1239R();
        m1221d(false);
        m1242U();
    }

    protected final void m1264e(int i) {
        this.f1149b = i;
        this.ab = null;
        m1247a(this.f48C);
        m1219c(this.ab);
    }

    protected final void m1255a(boolean z, String str) {
        if (!z) {
            m1264e(1);
        }
        C0426s c0426s = this.ac;
        boolean T = m1241T();
        int i = this.f1147Z.f1011j;
        c0426s.f2203l = 1;
        c0426s.f2202k = false;
        if (T) {
            c0426s.f2194c.setSelected(true);
            c0426s.f2194c.setFocusable(true);
            c0426s.f2194c.setFocusableInTouchMode(true);
            c0426s.f2194c.setEnabled(true);
        } else {
            c0426s.f2194c.setEnabled(false);
            c0426s.f2194c.setSelected(true);
        }
        GradientDrawable gradientDrawable = (GradientDrawable) c0426s.f2192a.getResources().getDrawable(2130837530);
        gradientDrawable.setColor(C0209d.m875a(c0426s.f2192a).m1136e(i));
        c0426s.f2196e.setImageDrawable(gradientDrawable);
        c0426s.f2196e.setVisibility(0);
        c0426s.f2195d.setImageResource(2130837571);
        c0426s.f2195d.setEnabled(true);
        c0426s.f2195d.setVisibility(8);
        c0426s.f2193b.setDescendantFocusability(262144);
        c0426s.m2224a();
        m1269t();
        m1239R();
        m1221d(true);
        if (!(this.ar || z)) {
            this.ar = true;
            Map hashMap = new HashMap();
            hashMap.put("Folder", this.f1147Z.f1003b);
            hashMap.put("Type", this.f1147Z.f1007f);
            hashMap.put("FROM", str + " " + this.f1147Z.f1007f);
            ColorNote.m649a(this.f48C, "NOTE", "EDIT", hashMap);
        }
        m1243V();
    }

    public final String m1232K() {
        return "(" + C0267e.m1196a(this.f48C, System.currentTimeMillis()) + ")";
    }

    final boolean m1233L() {
        if (this.aa || this.f1147Z.f1004c != 0 || this.f1146Y == null) {
            return false;
        }
        return true;
    }

    protected static void m1217a(C0326m c0326m, boolean z, int i, int i2, int i3) {
        if (z) {
            c0326m.m1698a(i, i2, i3);
        }
    }

    protected static void m1218b(C0326m c0326m, boolean z, int i, int i2, int i3) {
        if (z) {
            c0326m.m1698a(i, i2, i3);
        } else {
            c0326m.m1705c(i, i2, i3);
        }
    }

    public final C0326m m1234M() {
        return this.ab;
    }

    public final void m1247a(Context context) {
        if (m74h()) {
            int c = C0312i.m1629c(context);
            if (this.ab == null || this.ab.f1435g != c) {
                if (this.ab != null) {
                    this.ab.m1704c();
                }
                this.ab = new C0326m(this, c);
                m1212a(this.ab);
            }
        }
    }

    private void m1219c(C0326m c0326m) {
        C0426s c0426s = this.ac;
        if (c0326m.f1431c.size() == 0) {
            c0426s.f2197f.setVisibility(8);
            return;
        }
        c0426s.f2197f.setVisibility(0);
        c0426s.f2197f.setOnClickListener(c0326m.f1437i);
    }

    public final boolean m1257a(MenuItem menuItem) {
        if (m807a(menuItem.getItemId(), null)) {
            return true;
        }
        return super.m59a(menuItem);
    }

    protected final void m1223B() {
        C0229s.m1050b(this.f48C, this.f1150c);
        Toast.makeText(this.f48C, 2131230854, 0).show();
        m1258b(-1);
    }

    protected final void m1224C() {
        C0229s.m1051c(this.f48C, this.f1150c);
        Toast.makeText(this.f48C, 2131230878, 0).show();
        m1258b(-1);
    }

    public final void m1251a(Runnable runnable) {
        this.f48C.runOnUiThread(runnable);
    }

    protected final void m1229H() {
        C0313j.m1644a(this.f48C, m1236O(), m1235N());
    }

    public final void m1249a(Menu menu) {
        m1213b(this.ab);
        this.ab.m1699a(menu);
    }
}
