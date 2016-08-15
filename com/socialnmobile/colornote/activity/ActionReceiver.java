package com.socialnmobile.colornote.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.widget.Toast;
import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.p012f.C0268b;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ActionReceiver extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m681a(getIntent());
    }

    private boolean m681a(Intent intent) {
        Uri a;
        String str = null;
        String action = intent.getAction();
        Uri data = intent.getData();
        String type = intent.getType();
        String stringExtra;
        if ("android.intent.action.SEND".equals(action)) {
            action = intent.getStringExtra("android.intent.extra.SUBJECT");
            stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
            a = m680a(C0268b.m1200c(stringExtra), action, stringExtra);
            str = "android.intent.action.INSERT";
        } else if (!"android.intent.action.VIEW".equals(action) || data == null) {
            a = null;
        } else {
            int i;
            String str2;
            boolean z;
            if ("file".equals(data.getScheme())) {
                new StringBuilder("load file:").append(intent.getType()).append("/").append(data.getPath());
                if (new File(data.getPath()).length() > 149500) {
                    Toast.makeText(this, 2131230855, 1).show();
                    finish();
                    return false;
                }
                if (data.getPath().contains("bluetooth_content")) {
                    i = 1;
                } else {
                    z = false;
                }
                stringExtra = C0313j.m1669d(data.getPath());
            } else if ("content".equals(data.getScheme())) {
                try {
                    action = C0313j.m1641a(getContentResolver().openInputStream(data));
                    if (action.length() > 149500) {
                        Toast.makeText(this, 2131230855, 1).show();
                        finish();
                        return false;
                    }
                    stringExtra = action;
                    z = false;
                } catch (IOException e) {
                    Toast.makeText(this, getString(2131230795) + "\nIOException\nData:" + data.toString() + "\nType:" + type, 1).show();
                    finish();
                    return false;
                } catch (SecurityException e2) {
                    C0311h.f1370a.m1626b("ACTIONRECEIVER", "SecurityException", data.toString());
                    Toast.makeText(this, getString(2131230795) + "\nIOException\nData:" + data.toString() + "\nType:" + type, 1).show();
                    finish();
                    return false;
                } catch (IllegalStateException e3) {
                    C0311h.f1370a.m1626b("ACTIONRECEIVER", "IllegalStateException", data.toString());
                    Toast.makeText(this, 2131230795, 1).show();
                    finish();
                    return false;
                }
            } else {
                C0311h.f1370a.m1626b("UNSUPPORTED_SCHEME", data.getScheme(), "");
                Toast.makeText(this, 2131230795, 1).show();
                return false;
            }
            if ("text/html".equals(type)) {
                Matcher matcher = Pattern.compile("(?i)(?s)(<title.*?>)(.+?)(</title>)").matcher(stringExtra);
                str2 = null;
                while (matcher.find()) {
                    str2 = matcher.group(2);
                }
                String replaceAll = stringExtra.replaceAll("(?i)(?s)(<title.*?>)(.+?)(</title>)", "");
                if (i != 0) {
                    Matcher matcher2 = Pattern.compile("(?i)(?s)(<body><a.*?>)(.+?)(</a></p></body>)").matcher(replaceAll);
                    if (matcher2.find()) {
                        stringExtra = matcher2.group(2);
                    } else {
                        stringExtra = null;
                    }
                    if (stringExtra == null) {
                        stringExtra = replaceAll.replaceAll("\\<[^>]*>", "");
                    }
                } else {
                    try {
                        stringExtra = Html.fromHtml(replaceAll).toString();
                    } catch (RuntimeException e4) {
                        stringExtra = C0313j.m1658b(replaceAll.replaceAll("\\<[^>]*>", ""));
                    }
                }
            } else {
                "text/plain".equals(type);
                str2 = null;
            }
            i = C0268b.m1200c(stringExtra);
            if (i == 16 && "text/html".equals(type)) {
                stringExtra = stringExtra.replaceAll("\\[ \\]", "\n[ ]").replaceAll("\\[V\\]", "\n[V]").replaceAll("^\n", "");
            }
            a = m680a(i, str2, stringExtra);
            str = "android.intent.action.INSERT";
        }
        if (str == null || a == null) {
            CharSequence charSequence;
            if (data != null) {
                charSequence = getString(2131230795) + "\nData:" + data.toString() + "\nType:" + type;
            } else {
                charSequence = getString(2131230795);
            }
            Toast.makeText(this, charSequence, 1).show();
            finish();
            return false;
        }
        Intent intent2 = new Intent(str, a);
        intent2.setFlags(intent.getFlags());
        startActivity(intent2);
        finish();
        return true;
    }

    private Uri m680a(int i, String str, String str2) {
        return C0229s.m1039a((Context) this, 0, i, 0, C0212b.m934a((Context) this, "pref_default_color", 3), str, str2);
    }
}
