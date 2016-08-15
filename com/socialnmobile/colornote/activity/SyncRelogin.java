package com.socialnmobile.colornote.activity;

import android.app.NotificationManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.socialnmobile.colornote.C0272f;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.sync.C0366d;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.sync.C0405u;
import com.socialnmobile.colornote.sync.ab;
import com.socialnmobile.colornote.sync.cf;
import com.socialnmobile.colornote.sync.ci;
import com.socialnmobile.colornote.sync.errors.AccountNotMatch;
import com.socialnmobile.colornote.sync.errors.ExternalAuthFailed;
import com.socialnmobile.colornote.sync.errors.PasswordNotMatch;
import com.socialnmobile.colornote.sync.errors.UserNotFound;
import com.socialnmobile.colornote.sync.jobs.listeners.EmailReloginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookReloginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleReloginListener;

public class SyncRelogin extends SyncActivity {
    Handler f740f;
    View f741g;
    View f742h;
    View f743i;
    TextView f744j;
    TextView f745k;
    EditText f746l;
    View f747m;
    TextView f748n;
    String f749o;
    int f750p;
    OnClickListener f751q;
    private final FacebookReloginListener f752r;
    private final GoogleReloginListener f753s;
    private final EmailReloginListener f754t;

    /* renamed from: com.socialnmobile.colornote.activity.SyncRelogin.2 */
    class C01572 implements FacebookReloginListener {
        C01572() {
        }

        public void onInit() {
            SyncRelogin.this.f748n.setVisibility(8);
            SyncRelogin.this.m764b(SyncRelogin.this.getString(2131230735));
        }

        public void onFinalize() {
            SyncRelogin.this.m767e();
        }

        public void onError(AccountNotMatch accountNotMatch) {
            SyncRelogin.m777a(SyncRelogin.this, (Exception) accountNotMatch);
        }

        public void onError(UserNotFound userNotFound) {
            SyncRelogin.m777a(SyncRelogin.this, (Exception) userNotFound);
        }

        public void onFinished(Object obj) {
            if (SyncRelogin.this.f750p == 1) {
                SyncRelogin.this.c.m1745a();
                SyncRelogin.this.finish();
                return;
            }
            SyncRelogin.this.setResult(-1);
            SyncRelogin.this.finish();
        }

        public void onError(ExternalAuthFailed externalAuthFailed) {
            SyncRelogin.m777a(SyncRelogin.this, (Exception) externalAuthFailed);
        }

        public void onException(Exception exception) {
            SyncRelogin.m777a(SyncRelogin.this, exception);
        }
    }

    /* renamed from: com.socialnmobile.colornote.activity.SyncRelogin.3 */
    class C01583 implements GoogleReloginListener {
        C01583() {
        }

        public void onInit() {
            SyncRelogin.this.f748n.setVisibility(8);
            SyncRelogin.this.m764b(SyncRelogin.this.getString(2131230735));
        }

        public void onFinalize() {
            SyncRelogin.this.m767e();
        }

        public void onError(AccountNotMatch accountNotMatch) {
            SyncRelogin.m777a(SyncRelogin.this, (Exception) accountNotMatch);
        }

        public void onError(UserNotFound userNotFound) {
            SyncRelogin.m777a(SyncRelogin.this, (Exception) userNotFound);
        }

        public void onFinished(Object obj) {
            if (SyncRelogin.this.f750p == 1) {
                SyncRelogin.this.c.m1745a();
                SyncRelogin.this.finish();
                return;
            }
            SyncRelogin.this.setResult(-1);
            SyncRelogin.this.finish();
        }

        public void onError(ExternalAuthFailed externalAuthFailed) {
            SyncRelogin.m777a(SyncRelogin.this, (Exception) externalAuthFailed);
        }

        public void onException(Exception exception) {
            SyncRelogin.m777a(SyncRelogin.this, exception);
        }
    }

    /* renamed from: com.socialnmobile.colornote.activity.SyncRelogin.4 */
    class C01594 implements EmailReloginListener {
        C01594() {
        }

        public void onInit() {
            SyncRelogin.this.f748n.setVisibility(8);
            SyncRelogin.this.m764b(SyncRelogin.this.getString(2131230735));
        }

        public void onFinalize() {
            SyncRelogin.this.m767e();
        }

        public void onFinished(Object obj) {
            if (SyncRelogin.this.f750p == 1) {
                SyncRelogin.this.c.m1745a();
                SyncRelogin.this.finish();
                return;
            }
            SyncRelogin.this.setResult(-1);
            SyncRelogin.this.finish();
        }

        public void onError(UserNotFound userNotFound) {
            SyncRelogin.this.m781c(SyncRelogin.this.getString(2131230867));
        }

        public void onError(AccountNotMatch accountNotMatch) {
            SyncRelogin.m777a(SyncRelogin.this, (Exception) accountNotMatch);
        }

        public void onError(PasswordNotMatch passwordNotMatch) {
            C0405u authSuggest = passwordNotMatch.getAuthSuggest();
            if (authSuggest == C0405u.f1819b) {
                SyncRelogin.this.m779a(C0405u.f1819b, null);
            } else if (authSuggest == C0405u.f1820c) {
                SyncRelogin.this.m779a(C0405u.f1820c, null);
            } else {
                SyncRelogin.this.m781c(SyncRelogin.this.getString(2131230866));
            }
        }

        public void onException(Exception exception) {
            SyncRelogin.m777a(SyncRelogin.this, exception);
        }
    }

    public SyncRelogin() {
        this.f740f = new Handler();
        this.f751q = new at(this);
        this.f752r = new C01572();
        this.f753s = new C01583();
        this.f754t = new C01594();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f749o = getIntent().getStringExtra("FROM");
        this.f750p = getIntent().getIntExtra("EXTRA_PROCEED", 0);
        setContentView(2130903049);
        this.f741g = findViewById(2131623991);
        this.f742h = findViewById(2131623992);
        this.f743i = findViewById(2131623997);
        this.f745k = (TextView) findViewById(2131624000);
        this.f744j = (TextView) findViewById(2131623999);
        this.f746l = (EditText) findViewById(2131623996);
        this.f747m = findViewById(2131624001);
        this.f748n = (TextView) findViewById(2131623990);
        C0366d c = C0367b.m1871c(this);
        if (c != null) {
            m779a(c.m1865m().f1569d.f1498a, C0405u.m2058a(c));
        } else {
            if (this.f749o == null) {
                this.f749o = "none";
            }
            C0311h.f1370a.m1626b("RELOGIN ACCOUNT", "", this.f749o);
            finish();
        }
        this.f741g.setOnClickListener(this.f751q);
        this.f742h.setOnClickListener(this.f751q);
        this.f743i.setOnClickListener(this.f751q);
    }

    protected void onResume() {
        super.onResume();
        ((NotificationManager) getSystemService("notification")).cancel(21);
    }

    private void m779a(C0405u c0405u, String str) {
        if (str != null) {
            this.f745k.setText(str);
        }
        this.f741g.setVisibility(8);
        this.f742h.setVisibility(8);
        this.f747m.setVisibility(8);
        if (c0405u == C0405u.f1819b) {
            this.f741g.setVisibility(0);
            this.f744j.setCompoundDrawablesWithIntrinsicBounds(2130837561, 0, 0, 0);
            this.f744j.setText(2131230803);
        } else if (c0405u == C0405u.f1820c) {
            this.f742h.setVisibility(0);
            this.f744j.setCompoundDrawablesWithIntrinsicBounds(2130837562, 0, 0, 0);
            this.f744j.setText(2131230805);
        } else if (c0405u == C0405u.f1818a) {
            this.f747m.setVisibility(0);
            this.f744j.setText(2131231031);
        } else {
            throw new RuntimeException("not reachable");
        }
    }

    private void m781c(String str) {
        this.f748n.setVisibility(0);
        this.f748n.setTextColor(-2293760);
        this.f748n.setText(str);
        Toast.makeText(this, str, 1).show();
    }

    protected final void m782a(cf cfVar) {
        try {
            this.c.m1747a(C0405u.f1819b, ab.f1485c, cfVar, this.f752r);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    protected final void m783a(ci ciVar) {
        try {
            this.c.m1747a(C0405u.f1820c, ab.f1485c, ciVar, this.f753s);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    static /* synthetic */ void m777a(SyncRelogin syncRelogin, Exception exception) {
        syncRelogin.m781c(C0272f.m1209a(syncRelogin, exception) + ": " + exception.getClass().getSimpleName() + "\n" + exception.getMessage());
        exception.printStackTrace();
    }
}
