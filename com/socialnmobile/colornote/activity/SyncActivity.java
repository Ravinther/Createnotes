package com.socialnmobile.colornote.activity;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.flurry.android.C0115a;
import com.p004a.p005a.C0107b;
import com.p004a.p005a.C0108d;
import com.p004a.p005a.C0114i;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.p010d.C0202a;
import com.socialnmobile.colornote.p010d.C0207f;
import com.socialnmobile.colornote.p010d.C0208g;
import com.socialnmobile.colornote.sync.AccountColumns;
import com.socialnmobile.colornote.sync.SyncService;
import com.socialnmobile.colornote.sync.cf;
import com.socialnmobile.colornote.sync.ci;
import com.socialnmobile.util.service.C0477d;

public abstract class SyncActivity extends Activity implements ServiceConnection {
    final C0107b f726a;
    final C0207f f727b;
    SyncService f728c;
    String f729d;
    ProgressDialog f730e;
    private boolean f731f;
    private C0108d f732g;
    private C0108d f733h;

    protected abstract void m758a(cf cfVar);

    protected abstract void m759a(ci ciVar);

    public SyncActivity() {
        this.f726a = new C0107b("119344318128492");
        this.f727b = new C0207f("908669027715.apps.googleusercontent.com", "SNZBS6UfQj4_DJSY1K6S3naw");
        this.f732g = new aq(this);
        this.f733h = new ar(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!bindService(new Intent("UI_FOREGROUND", null, this, SyncService.class), this, 1)) {
            ColorNote.m651a("bind SyncService FAILED");
        }
        CookieSyncManager.createInstance(this);
        this.f730e = new ProgressDialog(this);
        this.f730e.setProgressStyle(1);
        this.f730e.setCancelable(false);
        this.f730e.setProgress(0);
        this.f730e.setMax(100);
    }

    protected void onStart() {
        super.onStart();
        C0115a.m512a((Context) this, "7WTGHNWSX5PSDGSHN65D");
    }

    protected void onStop() {
        super.onStop();
        C0115a.m511a(this);
    }

    protected void onDestroy() {
        unbindService(this);
        this.f731f = true;
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f726a.m488a(i, i2, intent);
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f728c = (SyncService) ((C0477d) iBinder).f2282a;
    }

    public void onServiceDisconnected(ComponentName componentName) {
        if (this.f728c != null) {
            this.f728c = null;
        }
    }

    public final boolean m761a() {
        return isFinishing() || this.f731f;
    }

    protected final boolean m762a(OnClickListener onClickListener, View view) {
        if (this.f728c != null) {
            return true;
        }
        view.postDelayed(new ap(this, onClickListener, view), 100);
        return false;
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1001:
                Dialog progressDialog = new ProgressDialog(this);
                progressDialog.setCancelable(false);
                return progressDialog;
            case 1002:
                return this.f730e;
            default:
                return super.onCreateDialog(i);
        }
    }

    protected void onPrepareDialog(int i, Dialog dialog) {
        super.onPrepareDialog(i, dialog);
        switch (i) {
            case 1001:
                ((ProgressDialog) dialog).setMessage(this.f729d);
            default:
        }
    }

    protected final void m763b() {
        CookieManager.getInstance().removeAllCookie();
        C0107b c0107b = this.f726a;
        String[] strArr = new String[]{AccountColumns.EMAIL};
        c0107b.f345g = this.f733h;
        if (!c0107b.m492a((Activity) this, c0107b.f344f, strArr)) {
            c0107b.m489a((Activity) this, strArr);
        }
    }

    protected final void m765c() {
        CookieManager.getInstance().removeAllCookie();
        C0207f c0207f = this.f727b;
        String[] strArr = new String[]{"email profile"};
        c0207f.f901a = this.f732g;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(" ", strArr));
        bundle.putString("client_id", c0207f.f902b);
        bundle.putString("redirect_uri", "urn:ietf:wg:oauth:2.0:oob");
        bundle.putString("response_type", "code");
        String str = "https://accounts.google.com/o/oauth2/auth?" + C0114i.m508a(bundle);
        CookieSyncManager.createInstance(this);
        new C0202a(this, str, new C0208g(c0207f)).show();
    }

    protected final void m757a(int i) {
        this.f730e.setProgress(i);
    }

    protected final void m760a(String str) {
        this.f730e.setMessage(str);
        if (!m761a()) {
            showDialog(1002);
        }
    }

    protected final void m766d() {
        if (!m761a()) {
            dismissDialog(1002);
        }
    }

    protected final void m764b(String str) {
        this.f729d = str;
        if (!m761a()) {
            showDialog(1001);
        }
    }

    protected final void m767e() {
        if (!m761a()) {
            dismissDialog(1001);
        }
    }
}
