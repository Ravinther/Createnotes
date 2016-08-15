package com.socialnmobile.colornote.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.sync.C0405u;
import com.socialnmobile.colornote.sync.SyncService;
import com.socialnmobile.colornote.sync.ab;
import com.socialnmobile.colornote.sync.bs;
import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import com.socialnmobile.colornote.sync.jobs.AuthJob.Listener;

final class as implements OnClickListener {
    final /* synthetic */ SyncLogIn f799a;

    as(SyncLogIn syncLogIn) {
        this.f799a = syncLogIn;
    }

    public final void onClick(View view) {
        if (this.f799a.m762a(this, view)) {
            this.f799a.f736h.setVisibility(8);
            switch (view.getId()) {
                case 2131623991:
                    this.f799a.m763b();
                case 2131623992:
                    this.f799a.m765c();
                case 2131623993:
                    if (this.f799a.f737i.getVisibility() == 0) {
                        this.f799a.f737i.setVisibility(8);
                        this.f799a.findViewById(2131623991).setVisibility(0);
                        this.f799a.findViewById(2131623992).setVisibility(0);
                        return;
                    }
                    this.f799a.f737i.setVisibility(0);
                    this.f799a.findViewById(2131623991).setVisibility(8);
                    this.f799a.findViewById(2131623992).setVisibility(8);
                case 2131623997:
                    String obj = this.f799a.f734f.getText().toString();
                    String obj2 = this.f799a.f735g.getText().toString();
                    if (obj.length() == 0 || obj2.length() == 0) {
                        this.f799a.m772c(this.f799a.getString(2131230862));
                    } else if (C0313j.m1667c(obj)) {
                        try {
                            ColorNote.m647a(this.f799a.getApplicationContext(), "SYNC", "SIGNIN", "Method", "Email");
                            SyncService syncService = this.f799a.c;
                            Listener listener = this.f799a.f739k;
                            syncService.m1747a(C0405u.f1818a, ab.f1484b, new bs(obj, obj2), listener);
                        } catch (UnexpectedLocalAccountException e) {
                            this.f799a.c.m1745a();
                            this.f799a.setResult(-1);
                            this.f799a.finish();
                        }
                    } else {
                        this.f799a.m772c(this.f799a.getString(2131230863));
                    }
                case 2131623998:
                    this.f799a.startActivityForResult(new Intent(this.f799a, SyncSignUp.class), 1);
                default:
            }
        }
    }
}
