package com.socialnmobile.colornote.activity;

import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.support.v4.app.C0015f;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.fragment.aa;
import com.socialnmobile.colornote.menu.C0164q;
import com.socialnmobile.colornote.receiver.C0332a;
import com.socialnmobile.colornote.view.ac;
import java.util.Iterator;

/* renamed from: com.socialnmobile.colornote.activity.u */
final class C0185u implements C0164q {
    final /* synthetic */ Main f841a;

    C0185u(Main main) {
        this.f841a = main;
    }

    public final boolean m829a(int i, String str) {
        Editor edit = PreferenceManager.getDefaultSharedPreferences(this.f841a).edit();
        edit.putString("PREF_THEME", str);
        edit.commit();
        C0209d.m876b(this.f841a);
        C0332a.m1724a(this.f841a);
        C0332a.m1733b(this.f841a);
        this.f841a.f626G.m1194a();
        this.f841a.f661z.m1520a();
        if (this.f841a.f652q instanceof aa) {
            ((aa) this.f841a.f652q).m1276u();
        }
        Iterator it = ((ac) this.f841a.f653r.getAdapter()).f849b.iterator();
        while (it.hasNext()) {
            C0015f c0015f = (C0015f) it.next();
            if (c0015f != null && c0015f.m74h() && (c0015f instanceof aa)) {
                ((aa) c0015f).m1276u();
            }
        }
        this.f841a.m723f();
        return true;
    }
}
