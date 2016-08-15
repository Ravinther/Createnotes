package com.socialnmobile.colornote.activity;

import android.os.Bundle;
import android.support.v4.app.C0015f;
import android.support.v4.app.C0017z;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.fragment.ArchiveFragment;
import com.socialnmobile.colornote.menu.C0152l;
import com.socialnmobile.colornote.menu.C0326m;
import com.socialnmobile.colornote.p007e.C0162f;
import com.socialnmobile.colornote.view.bv;

public class Archive extends ThemeFragmentActivity implements C0152l {
    C0015f f627n;
    bv f628o;
    C0162f f629p;

    public Archive() {
        this.f629p = new C0163a(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903040);
        this.f628o = new bv(findViewById(2131623936));
        bv bvVar = this.f628o;
        bvVar.f2125a.findViewById(2131624083).setVisibility(8);
        bvVar.f2128d.setPadding(C0313j.m1664c(bvVar.f2125a.getContext(), 8), 0, 0, 0);
        m682a(1, this.f629p);
        this.f627n = this.f97b.m154a(2131623937);
        if (this.f627n == null) {
            if ("note.socialnmobile.intent.action.VIEW_BACKUP_ARCHIVE".equals(getIntent().getAction())) {
                this.f627n = ArchiveFragment.m1325a(getIntent().getLongExtra("EXTRA_BACKUP_TIME", 0));
            } else {
                this.f627n = new ArchiveFragment();
            }
            C0017z a = this.f97b.m158a();
            a.m132b(2131623937, this.f627n);
            a.m126a(0);
            a.m131b();
        }
    }

    public final boolean m687a(C0015f c0015f) {
        return true;
    }

    public final bv m688b() {
        return this.f628o;
    }

    public final void m686a(C0326m c0326m) {
        this.f628o.m2210a(c0326m);
    }
}
