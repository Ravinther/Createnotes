package com.socialnmobile.colornote.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.socialnmobile.colornote.C0272f;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.sync.C0405u;
import com.socialnmobile.colornote.sync.ab;
import com.socialnmobile.colornote.sync.cf;
import com.socialnmobile.colornote.sync.cg;
import com.socialnmobile.colornote.sync.ci;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.colornote.sync.errors.ExternalAuthFailed;
import com.socialnmobile.colornote.sync.errors.PasswordNotMatch;
import com.socialnmobile.colornote.sync.errors.UnexpectedLocalAccountException;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import com.socialnmobile.colornote.sync.errors.UserNotFound;
import com.socialnmobile.colornote.sync.jobs.SyncJob.Listener;
import com.socialnmobile.colornote.sync.jobs.listeners.EmailLoginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.FacebookLoginListener;
import com.socialnmobile.colornote.sync.jobs.listeners.GoogleLoginListener;

public class SyncLogIn extends SyncActivity {
    EditText f734f;
    EditText f735g;
    TextView f736h;
    View f737i;
    OnClickListener f738j;
    EmailLoginListener f739k;

    /* renamed from: com.socialnmobile.colornote.activity.SyncLogIn.1 */
    class C01531 implements Listener {
        C01531() {
        }

        public void onInit() {
            SyncLogIn.this.f736h.setVisibility(8);
            SyncLogIn.this.m760a(SyncLogIn.this.getString(2131230998));
            C0313j.m1645a(SyncLogIn.this);
        }

        public void onFinalize() {
            C0313j.m1659b();
            SyncLogIn.this.m766d();
        }

        public void onException(Exception exception) {
            SyncLogIn.m769a(SyncLogIn.this, exception);
            SyncLogIn.this.finish();
        }

        public void onError(AuthRequired authRequired) {
        }

        public void onProgress(int i, int i2) {
            if (i2 == 0) {
                SyncLogIn.this.m757a(0);
            } else {
                SyncLogIn.this.m757a((i * 100) / i2);
            }
        }

        public void onFinished(Object obj) {
            SyncLogIn.this.m757a(100);
            SyncLogIn.this.finish();
        }

        public void onError(UnsupportedClientVersion unsupportedClientVersion) {
        }
    }

    /* renamed from: com.socialnmobile.colornote.activity.SyncLogIn.3 */
    class C01543 implements FacebookLoginListener {
        final /* synthetic */ cf val$fToken;

        C01543(cf cfVar) {
            this.val$fToken = cfVar;
        }

        public void onInit() {
            SyncLogIn.this.f736h.setVisibility(8);
            SyncLogIn.this.m764b(SyncLogIn.this.getString(2131230735));
        }

        public void onFinalize() {
            SyncLogIn.this.m767e();
        }

        public void onFinished(Object obj) {
            SyncLogIn.this.c.m1746a(new C01531());
        }

        public void onError(ExternalAuthFailed externalAuthFailed) {
            SyncLogIn.m769a(SyncLogIn.this, (Exception) externalAuthFailed);
        }

        public void onError(UserNotFound userNotFound) {
            Intent intent = new Intent(SyncLogIn.this, SyncSignUp.class);
            intent.putExtra("EXTRA_MODE", 2);
            intent.putExtra("EXTRA_FACEBOOK_TOKEN", cg.f1617a.m1789e(this.val$fToken));
            SyncLogIn.this.startActivityForResult(intent, 1);
        }

        public void onException(Exception exception) {
            SyncLogIn.m769a(SyncLogIn.this, exception);
        }
    }

    /* renamed from: com.socialnmobile.colornote.activity.SyncLogIn.4 */
    class C01554 implements GoogleLoginListener {
        final /* synthetic */ ci val$token;

        C01554(ci ciVar) {
            this.val$token = ciVar;
        }

        public void onInit() {
            SyncLogIn.this.f736h.setVisibility(8);
            SyncLogIn.this.m764b(SyncLogIn.this.getString(2131230735));
        }

        public void onFinalize() {
            SyncLogIn.this.m767e();
        }

        public void onFinished(Object obj) {
            SyncLogIn.this.c.m1746a(new C01531());
        }

        public void onException(Exception exception) {
            SyncLogIn.m769a(SyncLogIn.this, exception);
        }

        public void onError(ExternalAuthFailed externalAuthFailed) {
            SyncLogIn.m769a(SyncLogIn.this, (Exception) externalAuthFailed);
        }

        public void onError(UserNotFound userNotFound) {
            Intent intent = new Intent(SyncLogIn.this, SyncSignUp.class);
            intent.putExtra("EXTRA_MODE", 3);
            intent.putExtra("EXTRA_GOOGLE_TOKEN", this.val$token.toString());
            SyncLogIn.this.startActivityForResult(intent, 1);
        }
    }

    /* renamed from: com.socialnmobile.colornote.activity.SyncLogIn.5 */
    class C01565 implements EmailLoginListener {
        C01565() {
        }

        public void onInit() {
            SyncLogIn.this.f736h.setVisibility(8);
            SyncLogIn.this.m764b(SyncLogIn.this.getString(2131230735));
        }

        public void onFinalize() {
            SyncLogIn.this.m767e();
        }

        public void onError(UserNotFound userNotFound) {
            SyncLogIn.this.m772c(SyncLogIn.this.getString(2131230867));
        }

        public void onError(PasswordNotMatch passwordNotMatch) {
            C0405u authSuggest = passwordNotMatch.getAuthSuggest();
            if (authSuggest == C0405u.f1819b) {
                SyncLogIn.this.m772c(SyncLogIn.this.getString(2131230873));
            } else if (authSuggest == C0405u.f1820c) {
                SyncLogIn.this.m772c(SyncLogIn.this.getString(2131230874));
            } else {
                SyncLogIn.this.m772c(SyncLogIn.this.getString(2131230866));
            }
        }

        public void onException(Exception exception) {
            SyncLogIn.m769a(SyncLogIn.this, exception);
        }

        public void onFinished(Object obj) {
            SyncLogIn.this.c.m1746a(new C01531());
        }
    }

    public SyncLogIn() {
        this.f738j = new as(this);
        this.f739k = new C01565();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903048);
        this.f734f = (EditText) findViewById(2131623995);
        this.f735g = (EditText) findViewById(2131623996);
        this.f736h = (TextView) findViewById(2131623990);
        this.f737i = findViewById(2131623994);
        findViewById(2131623991).setOnClickListener(this.f738j);
        findViewById(2131623992).setOnClickListener(this.f738j);
        findViewById(2131623997).setOnClickListener(this.f738j);
        findViewById(2131623993).setOnClickListener(this.f738j);
        findViewById(2131623998).setOnClickListener(this.f738j);
        if (C0313j.m1666c()) {
            findViewById(2131623991).setEnabled(false);
        }
    }

    protected void onResume() {
        super.onResume();
        this.f736h.setVisibility(8);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
        } else if (i2 == -1) {
            finish();
        }
    }

    private void m772c(String str) {
        this.f736h.setVisibility(0);
        this.f736h.setText(str);
        Toast.makeText(this, str, 1).show();
    }

    protected final void m773a(cf cfVar) {
        try {
            ColorNote.m647a(getApplicationContext(), "SYNC", "SIGNIN", "Method", "Facebook");
            this.c.m1747a(C0405u.f1819b, ab.f1484b, cfVar, new C01543(cfVar));
        } catch (UnexpectedLocalAccountException e) {
            this.c.m1745a();
            setResult(-1);
            finish();
        }
    }

    protected final void m774a(ci ciVar) {
        try {
            ColorNote.m647a(getApplicationContext(), "SYNC", "SIGNIN", "Method", "Google");
            this.c.m1747a(C0405u.f1820c, ab.f1484b, ciVar, new C01554(ciVar));
        } catch (UnexpectedLocalAccountException e) {
            this.c.m1745a();
            setResult(-1);
            finish();
        }
    }

    static /* synthetic */ void m769a(SyncLogIn syncLogIn, Exception exception) {
        syncLogIn.m772c(C0272f.m1209a(syncLogIn, exception) + ": " + exception.getClass().getSimpleName() + "\n" + exception.getMessage());
        exception.printStackTrace();
    }
}
