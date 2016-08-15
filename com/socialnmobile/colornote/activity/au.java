package com.socialnmobile.colornote.activity;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

final class au implements OnClickListener {
    final /* synthetic */ SyncSignUp f801a;

    au(SyncSignUp syncSignUp) {
        this.f801a = syncSignUp;
    }

    public final void onClick(View view) {
        if (this.f801a.m762a(this, view)) {
            switch (view.getId()) {
                case 2131624002:
                    this.f801a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://www.colornote.com/help/tos.html")));
                case 2131624003:
                    if (this.f801a.f758i != null) {
                        new av(this.f801a, this.f801a.f758i).execute(new String[0]);
                    } else {
                        this.f801a.m763b();
                    }
                case 2131624004:
                    if (this.f801a.f759j != null) {
                        new av(this.f801a, this.f801a.f759j).execute(new String[0]);
                    } else {
                        this.f801a.m765c();
                    }
                default:
            }
        }
    }
}
