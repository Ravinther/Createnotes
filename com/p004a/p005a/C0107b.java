package com.p004a.p005a;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieSyncManager;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.a.a.b */
public final class C0107b {
    protected static String f339a;
    protected static String f340b;
    protected static String f341c;
    String f342d;
    long f343e;
    public String f344f;
    public C0108d f345g;
    private Activity f346h;
    private String[] f347i;
    private int f348j;

    static {
        f339a = "https://facebook.com/v2.0/dialog/";
        f340b = "https://graph.facebook.com/";
        f341c = "https://api.facebook.com/restserver.php";
    }

    public C0107b(String str) {
        this.f342d = null;
        this.f343e = 0;
        this.f344f = str;
    }

    public final boolean m492a(Activity activity, String str, String[] strArr) {
        boolean z = true;
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", str);
        intent.putExtra("scope", TextUtils.join(",", strArr));
        Object b = C0107b.m487b();
        if (!TextUtils.isEmpty(b)) {
            intent.putExtra("e2e", b);
        }
        intent.putExtra("response_type", "token");
        intent.putExtra("return_scopes", "true");
        intent.putExtra("default_audience", "everyone");
        intent.putExtra("legacy_override", "v2.2");
        if (activity.getPackageManager().resolveActivity(intent, 0) == null || !C0107b.m486a(activity, intent)) {
            return false;
        }
        this.f346h = activity;
        this.f347i = strArr;
        this.f348j = 32665;
        try {
            activity.startActivityForResult(intent, 32665);
        } catch (ActivityNotFoundException e) {
            z = false;
        }
        return z;
    }

    private static boolean m486a(Activity activity, Intent intent) {
        ResolveInfo resolveActivity = activity.getPackageManager().resolveActivity(intent, 0);
        if (resolveActivity == null) {
            return false;
        }
        try {
            for (Signature toCharsString : activity.getPackageManager().getPackageInfo(resolveActivity.activityInfo.packageName, 64).signatures) {
                if (toCharsString.toCharsString().equals("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2")) {
                    return true;
                }
            }
            return false;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    public final void m489a(Activity activity, String[] strArr) {
        Bundle bundle = new Bundle();
        if (strArr.length > 0) {
            bundle.putString("scope", TextUtils.join(",", strArr));
        }
        CookieSyncManager.createInstance(activity);
        String str = "oauth";
        C0108d c0109c = new C0109c(this);
        String str2 = f339a + str;
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", "fbconnect://success");
        if (str.equals("oauth")) {
            bundle.putString(NoteMinorColumns.TYPE, "user_agent");
            bundle.putString("client_id", this.f344f);
        } else {
            bundle.putString("app_id", this.f344f);
        }
        if (m491a()) {
            bundle.putString("access_token", this.f342d);
        }
        String str3 = str2 + "?" + C0114i.m508a(bundle);
        if (activity.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            Builder builder = new Builder(activity);
            builder.setTitle("Error");
            builder.setMessage("Application requires permission to access the Internet");
            builder.create().show();
            return;
        }
        new C0111f(activity, str3, c0109c).show();
    }

    public final void m488a(int i, int i2, Intent intent) {
        if (i != this.f348j) {
            return;
        }
        if (i2 == -1) {
            String stringExtra = intent.getStringExtra("error");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("error_type");
            }
            if (stringExtra == null) {
                this.f342d = intent.getStringExtra("access_token");
                m490a(intent.getStringExtra("expires_in"));
                if (m491a()) {
                    Log.d("Facebook-authorize", "Login Success! access_token=" + this.f342d + " expires=" + this.f343e);
                    this.f345g.m494a(intent.getExtras());
                    return;
                }
                this.f345g.m496a(new C0110e("Failed to receive access token."));
            } else if (stringExtra.equals("service_disabled") || stringExtra.equals("AndroidAuthKillSwitchException")) {
                Log.d("Facebook-authorize", "Hosted auth currently disabled. Retrying dialog auth...");
                m489a(this.f346h, this.f347i);
            } else if (stringExtra.equals("access_denied") || stringExtra.equals("OAuthAccessDeniedException")) {
                Log.d("Facebook-authorize", "Login canceled by user.");
                this.f345g.m493a();
            } else {
                Log.d("Facebook-authorize", "Login failed: " + stringExtra);
                this.f345g.m496a(new C0110e(stringExtra));
            }
        } else if (i2 != 0) {
        } else {
            if (intent != null) {
                Log.d("Facebook-authorize", "Login failed: " + intent.getStringExtra("error"));
                this.f345g.m495a(new C0106a(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                return;
            }
            Log.d("Facebook-authorize", "Login canceled by user.");
            this.f345g.m493a();
        }
    }

    public final void m490a(String str) {
        if (str != null && !str.equals("0")) {
            this.f343e = System.currentTimeMillis() + ((long) (Integer.parseInt(str) * 1000));
        }
    }

    private static String m487b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("init", System.currentTimeMillis());
        } catch (JSONException e) {
        }
        return jSONObject.toString();
    }

    public final boolean m491a() {
        return this.f342d != null && (this.f343e == 0 || System.currentTimeMillis() < this.f343e);
    }
}
