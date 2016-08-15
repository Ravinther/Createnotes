package com.socialnmobile.colornote.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.C0015f;
import android.view.Menu;
import android.view.MenuItem;
import com.socialnmobile.colornote.C0312i;
import com.socialnmobile.colornote.menu.C0152l;
import com.socialnmobile.colornote.menu.C0273k;
import com.socialnmobile.colornote.menu.C0326m;

public abstract class ScreenFragment extends C0015f implements aa, cp, C0273k {
    C0326m aq;
    C0152l ar;

    public void m1285a(Activity activity) {
        super.m53a(activity);
        this.ar = (C0152l) activity;
    }

    public void m1287a(Bundle bundle) {
        super.m56a(bundle);
        m1286a(this.f48C);
    }

    public void m1290p() {
        super.m79p();
        this.aq.m1704c();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public final boolean m1289a(MenuItem menuItem) {
        if (m807a(menuItem.getItemId(), null)) {
            return true;
        }
        return super.m59a(menuItem);
    }

    public final C0273k m1283L() {
        return this;
    }

    public final C0326m m1284M() {
        return this.aq;
    }

    public final void m1286a(Context context) {
        if (m74h()) {
            int c = C0312i.m1629c(context);
            if (this.aq == null || this.aq.f1435g != c) {
                if (this.aq != null) {
                    this.aq.m1704c();
                }
                this.aq = new C0326m(this, c);
                m1212a(this.aq);
            }
        }
    }

    public boolean m1291x() {
        return false;
    }

    public boolean m1292y() {
        return false;
    }

    public final void m1288a(Menu menu) {
        m1213b(this.aq);
        this.aq.m1699a(menu);
    }
}
