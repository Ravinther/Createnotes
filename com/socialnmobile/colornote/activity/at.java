package com.socialnmobile.colornote.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.socialnmobile.colornote.sync.C0405u;
import com.socialnmobile.colornote.sync.SyncService;
import com.socialnmobile.colornote.sync.ab;
import com.socialnmobile.colornote.sync.bs;
import com.socialnmobile.colornote.sync.jobs.AuthJob.Listener;

final class at implements OnClickListener {
    final /* synthetic */ SyncRelogin f800a;

    at(SyncRelogin syncRelogin) {
        this.f800a = syncRelogin;
    }

    public final void onClick(View view) {
        if (this.f800a.m762a(this, view)) {
            switch (view.getId()) {
                case 2131623991:
                    this.f800a.m763b();
                case 2131623992:
                    this.f800a.m765c();
                case 2131623997:
                    String trim = this.f800a.f746l.getText().toString().trim();
                    if (trim.length() == 0) {
                        this.f800a.m781c(this.f800a.getString(2131230859));
                        return;
                    }
                    try {
                        SyncService syncService = this.f800a.c;
                        Listener a = this.f800a.f754t;
                        syncService.m1747a(C0405u.f1818a, ab.f1485c, new bs(null, trim), a);
                    } catch (Throwable e) {
                        throw new IllegalStateException(e);
                    }
                default:
            }
        }
    }
}
