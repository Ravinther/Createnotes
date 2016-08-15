package com.socialnmobile.colornote.fragment;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.C0015f;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.ab;
import android.support.v4.p000a.C0000d;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.data.C0230t;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.menu.C0326m;
import com.socialnmobile.colornote.menu.C0329p;
import com.socialnmobile.colornote.menu.C0330r;
import com.socialnmobile.colornote.p007e.C0262d;
import com.socialnmobile.colornote.view.az;
import com.socialnmobile.colornote.view.bu;
import java.util.Iterator;

public class RecycleBinFragment extends ScreenFragment implements ab {
    OnClickListener f1185a;
    OnItemClickListener f1186b;
    private Handler f1187c;
    private ListView f1188d;
    private bu f1189e;
    private String f1190f;
    private int f1191g;
    private Uri f1192h;
    private C0230t f1193i;

    public RecycleBinFragment() {
        this.f1187c = new Handler();
        this.f1189e = new bu();
        this.f1185a = new ci(this);
        this.f1186b = new cj(this);
    }

    public final /* synthetic */ void m1489a(C0000d c0000d, Object obj) {
        this.f1188d.setAdapter(az.m2182a(this.f48C, (Cursor) obj, 1));
    }

    public final int m1497t() {
        return 3;
    }

    public final void m1487a(Bundle bundle) {
        super.m1287a(bundle);
        m76k();
    }

    public final void m1486a(Activity activity) {
        super.m1285a(activity);
    }

    public final View m1484a(LayoutInflater layoutInflater, Bundle bundle) {
        View inflate = layoutInflater.inflate(2130903065, null);
        this.f1188d = (ListView) inflate.findViewById(2131623939);
        this.f1189e.m2204a(inflate, this);
        this.f1189e.m2202a(1);
        this.f1189e.m2203a(this.f1185a);
        this.f1190f = null;
        m1493b(6);
        this.f1188d.setOnItemClickListener(this.f1186b);
        this.f1188d.setOnCreateContextMenuListener(this);
        return inflate;
    }

    public final void m1496o() {
        super.m78o();
        m1481b(this.f48C);
        if (this.ar.m684a((C0015f) this)) {
            m1485a();
        }
    }

    private void m1481b(Context context) {
        String i = C0212b.m949i(context);
        if (this.f1190f == null || !this.f1190f.equals(i)) {
            this.f1190f = i;
            C0262d a = C0209d.m875a(context);
            this.f1188d.setBackgroundColor(a.m1145n(3));
            this.f1188d.setCacheColorHint(a.m1145n(3));
            this.f1189e.m2206b();
            this.f1188d.invalidateViews();
        }
    }

    final void m1485a() {
        m1483z();
        this.ar.m683a(this.aq);
    }

    private void m1483z() {
        int i = 0;
        switch (this.f1191g) {
            case 2:
                i = 2130837616;
                break;
            case 3:
                i = 2130837617;
                break;
            case 5:
                i = 2130837594;
                break;
            case 6:
                i = 2130837597;
                break;
        }
        C0329p a = this.aq.m1697a(2131624157);
        if (a != null) {
            a.m1706a(i);
        }
    }

    public final void m1499v() {
    }

    public final void m1500w() {
        if (m74h()) {
            m1211a(this.f48C);
            m1485a();
        }
    }

    final void m1493b(int i) {
        if (m74h()) {
            int i2;
            Bundle bundle = new Bundle();
            bundle.putInt("SORT", i);
            m77l().m102a(0, bundle, this);
            switch (i) {
                case 2:
                    i2 = 2131230984;
                    break;
                case 3:
                    i2 = 2131230986;
                    break;
                case 5:
                    i2 = 2131230987;
                    break;
                case 6:
                    i2 = 2131230988;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            this.f1191g = i;
            this.f1189e.m2205a(m70f().getString(2131230991, new Object[]{m50a(i2)}));
        }
    }

    final void m1491a(boolean z) {
        C0330r.m1711a((ScreenFragment) this, new cn(this)).m1682a(this, this.f47B, this.ar.m685b().f2130f[0], z);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        try {
            Cursor cursor = (Cursor) ((AdapterView) view).getAdapter().getItem(((AdapterContextMenuInfo) contextMenuInfo).position);
            if (cursor != null) {
                C0230t c0230t = new C0230t(cursor);
                this.f1193i = c0230t;
                contextMenu.setHeaderTitle(c0230t.f1008g);
                this.f48C.getMenuInflater().inflate(2131558410, contextMenu);
            }
        } catch (ClassCastException e) {
            ColorNote.m651a("bad menuInfo");
        }
    }

    public final boolean m1495b(MenuItem menuItem) {
        try {
            this.f1192h = ContentUris.withAppendedId(C0228r.f997a, ((AdapterContextMenuInfo) menuItem.getMenuInfo()).id);
            switch (menuItem.getItemId()) {
                case 2131624169:
                    m1482c(3);
                    return true;
                case 2131624186:
                    C0229s.m1041a(this.f48C, this.f1192h);
                    return true;
                default:
                    return super.m64b(menuItem);
            }
        } catch (ClassCastException e) {
            ColorNote.m651a("bad menuInfo");
            return false;
        }
    }

    public final void m1490a(C0326m c0326m) {
        int i = c0326m.f1435g;
        c0326m.f1434f = m50a(2131230948);
        if (i == 2) {
            c0326m.m1703b(2131624132, 2130837596, 2131230828);
            c0326m.m1698a(2131624157, 2130837597, 2131231074);
            c0326m.m1698a(2131624132, 2130837596, 2131230828);
        } else if (i == 1) {
            c0326m.m1703b(2131624132, 2130837596, 2131230828);
            c0326m.m1705c(2131624157, 2130837597, 2131231074);
        } else if (i == 3) {
            c0326m.m1703b(2131624132, 2130837596, 2131230828);
            c0326m.m1705c(2131624157, 2130837597, 2131231074);
        }
        m1483z();
    }

    public final void m1494b(C0326m c0326m) {
        Iterator it = c0326m.m1702b(2131624157).iterator();
        while (it.hasNext()) {
            ((C0329p) it.next()).m1706a(C0313j.m1631a(this.f1191g));
        }
    }

    public final boolean m1492a(int i, String str) {
        switch (i) {
            case 2131624132:
                m1482c(2);
                return true;
            case 2131624157:
                m1491a(false);
                return true;
            default:
                return false;
        }
    }

    public final C0000d a_(Bundle bundle) {
        return new co(this.f48C, bundle.getInt("SORT"));
    }

    public final void m1488a(C0000d c0000d) {
    }

    public final void m1498u() {
        m1481b(this.f48C);
    }

    private void m1482c(int i) {
        DialogFragment dialogFragment = null;
        switch (i) {
            case 2:
                dialogFragment = DialogFactory.m1115a(2131230824, 2131230767, new ck(this));
                break;
            case 3:
                dialogFragment = DialogFactory.m1115a(2131230825, 2131230766, new cl(this));
                break;
        }
        this.f1187c.post(new cm(this, dialogFragment));
    }
}
