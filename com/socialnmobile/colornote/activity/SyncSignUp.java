package com.socialnmobile.colornote.activity;

import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.socialnmobile.colornote.C0272f;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.sync.cf;
import com.socialnmobile.colornote.sync.cg;
import com.socialnmobile.colornote.sync.ci;
import com.socialnmobile.colornote.sync.cj;
import com.socialnmobile.colornote.sync.cl;
import com.socialnmobile.colornote.sync.errors.AlreadyInUse;
import com.socialnmobile.colornote.sync.errors.ExternalAuthFailed;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookSignupListener;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleSignupListener;

public class SyncSignUp extends SyncActivity {
    TextView f755f;
    Button f756g;
    Button f757h;
    cf f758i;
    ci f759j;
    OnClickListener f760k;
    private final FacebookSignupListener f761l;
    private final GoogleSignupListener f762m;

    /* renamed from: com.socialnmobile.colornote.activity.SyncSignUp.2 */
    class C01602 implements FacebookSignupListener {
        C01602() {
        }

        public void onInit() {
            SyncSignUp.this.m764b(SyncSignUp.this.getString(2131230979));
            SyncSignUp.this.f755f.setVisibility(8);
        }

        public void onFinalize() {
            SyncSignUp.this.m767e();
        }

        public void onError(AlreadyInUse alreadyInUse) {
            SyncSignUp.this.m787a(SyncSignUp.this.getString(2131230853), true, true);
        }

        public void onError(ExternalAuthFailed externalAuthFailed) {
            SyncSignUp.m785a(SyncSignUp.this, (Exception) externalAuthFailed);
        }

        public void onException(Exception exception) {
            SyncSignUp.m785a(SyncSignUp.this, exception);
        }

        public void onFinished(Object obj) {
            SyncSignUp.this.c.m1745a();
            SyncSignUp.this.setResult(-1);
            SyncSignUp.this.finish();
        }
    }

    /* renamed from: com.socialnmobile.colornote.activity.SyncSignUp.3 */
    class C01613 implements GoogleSignupListener {
        C01613() {
        }

        public void onInit() {
            SyncSignUp.this.m764b(SyncSignUp.this.getString(2131230979));
            SyncSignUp.this.f755f.setVisibility(8);
        }

        public void onFinalize() {
            SyncSignUp.this.m767e();
        }

        public void onError(AlreadyInUse alreadyInUse) {
            SyncSignUp.this.m787a(SyncSignUp.this.getString(2131230853), true, true);
        }

        public void onError(ExternalAuthFailed externalAuthFailed) {
            SyncSignUp.m785a(SyncSignUp.this, (Exception) externalAuthFailed);
        }

        public void onException(Exception exception) {
            SyncSignUp.m785a(SyncSignUp.this, exception);
        }

        public void onFinished(Object obj) {
            SyncSignUp.this.c.m1745a();
            SyncSignUp.this.setResult(-1);
            SyncSignUp.this.finish();
        }
    }

    public SyncSignUp() {
        this.f760k = new au(this);
        this.f761l = new C01602();
        this.f762m = new C01613();
    }

    static /* synthetic */ void m785a(SyncSignUp syncSignUp, Exception exception) {
        syncSignUp.m787a(C0272f.m1209a(syncSignUp, exception) + ": " + exception.getClass().getSimpleName() + "\n" + exception.getMessage(), true, true);
        exception.printStackTrace();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903050);
        this.f756g = (Button) findViewById(2131624003);
        this.f757h = (Button) findViewById(2131624004);
        this.f755f = (TextView) findViewById(2131623990);
        this.f756g.setOnClickListener(this.f760k);
        this.f757h.setOnClickListener(this.f760k);
        findViewById(2131624002).setOnClickListener(this.f760k);
        switch (getIntent() != null ? getIntent().getIntExtra("EXTRA_MODE", 0) : 0) {
            case 2:
                try {
                    if (getIntent().hasExtra("EXTRA_FACEBOOK_TOKEN")) {
                        this.f758i = (cf) cg.f1617a.m1788a(getIntent().getStringExtra("EXTRA_FACEBOOK_TOKEN"));
                    }
                } catch (cl e) {
                    ColorNote.m651a("facebook token exception");
                }
                m787a(getString(2131230759), false, false);
                this.f757h.setVisibility(8);
                this.f756g.setVisibility(0);
                break;
            case 3:
                try {
                    if (getIntent().hasExtra("EXTRA_GOOGLE_TOKEN")) {
                        this.f759j = (ci) cj.f1622a.m1788a(getIntent().getStringExtra("EXTRA_GOOGLE_TOKEN"));
                    }
                } catch (cl e2) {
                    ColorNote.m651a("google token exception");
                }
                m787a(getString(2131230760), false, false);
                this.f757h.setVisibility(0);
                this.f756g.setVisibility(8);
                break;
        }
        if (C0313j.m1666c()) {
            this.f756g.setEnabled(false);
        }
    }

    private void m787a(String str, boolean z, boolean z2) {
        this.f755f.setVisibility(0);
        if (z2) {
            this.f755f.setTextColor(-2293760);
        } else {
            this.f755f.setTextColor(-1);
        }
        this.f755f.setText(str);
        if (z) {
            Toast.makeText(this, str, 1).show();
        }
    }

    protected final void m790a(cf cfVar) {
        new av(this, cfVar).execute(new String[0]);
    }

    protected final void m791a(ci ciVar) {
        new av(this, ciVar).execute(new String[0]);
    }
}
