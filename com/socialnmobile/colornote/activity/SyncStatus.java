package com.socialnmobile.colornote.activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.socialnmobile.colornote.C0272f;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.dialog.DialogFactory.ConfirmDialogFragment;
import com.socialnmobile.colornote.sync.C0366d;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.sync.C0405u;
import com.socialnmobile.colornote.sync.cf;
import com.socialnmobile.colornote.sync.ci;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import com.socialnmobile.colornote.sync.jobs.SyncJob.Listener;
import java.lang.ref.WeakReference;

public class SyncStatus extends SyncActivity {
    TextView f763f;
    TextView f764g;
    TextView f765h;
    TextView f766i;
    TextView f767j;
    int f768k;

    public class SyncListener implements Listener {
        WeakReference mActivityReference;
        Context mContext;
        boolean mSignOut;

        public SyncListener(SyncStatus syncStatus, boolean z) {
            this.mActivityReference = new WeakReference(syncStatus);
            this.mContext = syncStatus.getApplication();
            this.mSignOut = z;
        }

        public void onInit() {
            C0313j.m1645a(this.mContext);
            SyncStatus syncStatus = (SyncStatus) this.mActivityReference.get();
            if (syncStatus != null) {
                syncStatus.f766i.setVisibility(8);
                syncStatus.m760a(syncStatus.getString(2131230998));
                syncStatus.m757a(0);
            }
        }

        public void onFinalize() {
            C0313j.m1659b();
            SyncStatus syncStatus = (SyncStatus) this.mActivityReference.get();
            if (syncStatus != null) {
                syncStatus.m766d();
            }
        }

        public void onException(Exception exception) {
            SyncStatus syncStatus = (SyncStatus) this.mActivityReference.get();
            if (syncStatus != null) {
                SyncStatus.m794a(syncStatus, exception);
            }
        }

        public void onError(AuthRequired authRequired) {
            SyncStatus syncStatus = (SyncStatus) this.mActivityReference.get();
            if (syncStatus != null) {
                if (this.mSignOut) {
                    syncStatus.f768k = 1;
                } else {
                    syncStatus.f768k = 2;
                }
                Intent intent = new Intent(this.mContext, SyncRelogin.class);
                intent.putExtra("FROM", "SyncStatus");
                syncStatus.startActivityForResult(intent, 1);
            }
        }

        public void onProgress(int i, int i2) {
            SyncStatus syncStatus = (SyncStatus) this.mActivityReference.get();
            if (syncStatus != null) {
                if (i2 == 0) {
                    syncStatus.m757a(0);
                } else {
                    syncStatus.m757a((i * 100) / i2);
                }
            }
        }

        public void onFinished(Object obj) {
            SyncStatus syncStatus = (SyncStatus) this.mActivityReference.get();
            if (syncStatus != null) {
                syncStatus.m757a(100);
                if (this.mSignOut) {
                    C0229s.m1049b(this.mContext);
                    C0212b.m937a(this.mContext);
                    syncStatus.finish();
                    return;
                }
                syncStatus.m799f();
            }
        }

        public void onError(UnsupportedClientVersion unsupportedClientVersion) {
            SyncStatus syncStatus = (SyncStatus) this.mActivityReference.get();
            if (syncStatus != null) {
                syncStatus.showDialog(3);
            }
        }
    }

    public static String m792a(C0367b c0367b) {
        return c0367b.m1857e();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903051);
        this.f763f = (TextView) findViewById(2131624000);
        this.f764g = (TextView) findViewById(2131623999);
        this.f765h = (TextView) findViewById(2131624005);
        this.f767j = (TextView) findViewById(2131624006);
        this.f766i = (TextView) findViewById(2131623990);
        C0366d c = C0367b.m1871c(this);
        if (c != null) {
            C0405u c0405u = c.m1865m().f1569d.f1498a;
            this.f763f.setText(c.m1857e());
            if (c0405u == C0405u.f1819b) {
                this.f764g.setCompoundDrawablesWithIntrinsicBounds(2130837561, 0, 0, 0);
                this.f764g.setText(2131230803);
            } else if (c0405u == C0405u.f1820c) {
                this.f764g.setCompoundDrawablesWithIntrinsicBounds(2130837562, 0, 0, 0);
                this.f764g.setText(2131230805);
            } else if (c0405u == C0405u.f1818a) {
                this.f764g.setText(2131231031);
            } else if (c0405u == null) {
                this.f764g.setText("");
            } else {
                throw new RuntimeException("not reachable");
            }
        }
        startActivity(new Intent(this, SyncLogIn.class));
        finish();
        m799f();
        this.f763f.setOnClickListener(new aw(this));
        findViewById(2131624007).setOnClickListener(new ax(this));
        if (C0212b.m954n(this)) {
            m795a(C0272f.m1208a(this), false);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    private void m795a(CharSequence charSequence, boolean z) {
        this.f766i.setVisibility(0);
        this.f766i.setTextColor(-2293760);
        this.f766i.setText(charSequence);
        if (z) {
            Toast.makeText(this, charSequence, 1).show();
        }
    }

    private void m800g() {
        if (this.c != null) {
            ColorNote.m647a(getApplicationContext(), "SYNC", "MANUAL_SYNC", "Source", "SyncStatus");
            this.c.m1746a(new SyncListener(this, false));
        }
    }

    private void m801h() {
        if (this.c != null) {
            ColorNote.m646a(getApplicationContext(), "SYNC", "SIGNOUT");
            this.c.m1746a(new SyncListener(this, true));
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1 || i2 != -1) {
            return;
        }
        if (this.f768k == 1) {
            m801h();
        } else {
            m800g();
        }
    }

    protected final void m802a(cf cfVar) {
    }

    protected final void m803a(ci ciVar) {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(2131558413, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 2131624184:
                m800g();
                break;
            case 2131624191:
                showDialog(2);
                break;
            case 2131624192:
                showDialog(1);
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                return C0313j.m1634a(this, 2130837583, 2131230841, 2131230775, new az(this));
            case 2:
                return C0313j.m1634a(this, 2130837583, 2131230781, 2131231042, new ba(this));
            case 3:
                return ((ConfirmDialogFragment) DialogFactory.m1116a(new ay(this))).m1097a(this);
            default:
                return super.onCreateDialog(i);
        }
    }

    private void m799f() {
        long a = C0212b.m935a((Context) this, "LAST_SYNC_TIME_MILLIS");
        if (a != 0) {
            this.f765h.setText(C0313j.m1640a((Context) this, a));
        }
        this.f767j.setText(String.valueOf(C0212b.m934a((Context) this, "SYNC_NOTE_COUNT", 0)));
    }

    static /* synthetic */ void m794a(SyncStatus syncStatus, Exception exception) {
        syncStatus.m795a(C0272f.m1209a(syncStatus, exception) + ": " + exception.getClass().getSimpleName() + "\n" + exception.getMessage(), true);
        exception.printStackTrace();
    }
}
