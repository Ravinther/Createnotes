package com.socialnmobile.colornote.activity;

import android.os.AsyncTask;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0214d;
import com.socialnmobile.colornote.sync.C0405u;
import com.socialnmobile.colornote.sync.ab;
import com.socialnmobile.colornote.sync.cf;
import com.socialnmobile.colornote.sync.ci;
import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;

final class av extends AsyncTask {
    cf f802a;
    ci f803b;
    int f804c;
    final /* synthetic */ SyncSignUp f805d;

    av(SyncSignUp syncSignUp, cf cfVar) {
        this.f805d = syncSignUp;
        this.f804c = 2;
        this.f802a = cfVar;
    }

    av(SyncSignUp syncSignUp, ci ciVar) {
        this.f805d = syncSignUp;
        this.f804c = 3;
        this.f803b = ciVar;
    }

    protected final void onPreExecute() {
        this.f805d.m764b(this.f805d.getString(2131230736));
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        if (!this.f805d.m761a()) {
            this.f805d.m767e();
            try {
                if (this.f804c == 2) {
                    ColorNote.m647a(this.f805d.getApplicationContext(), "SYNC", "SIGNUP", "Method", "Facebook");
                    this.f805d.c.m1747a(C0405u.f1819b, ab.f1483a, this.f802a, this.f805d.f761l);
                } else if (this.f804c == 3) {
                    ColorNote.m647a(this.f805d.getApplicationContext(), "SYNC", "SIGNUP", "Method", "Google");
                    this.f805d.c.m1747a(C0405u.f1820c, ab.f1483a, this.f803b, this.f805d.f762m);
                }
            } catch (UnexpectedLocalAccountException e) {
                this.f805d.c.m1745a();
                this.f805d.setResult(-1);
                this.f805d.finish();
            }
        }
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        C0214d.m977a(this.f805d);
        return Long.valueOf(0);
    }
}
