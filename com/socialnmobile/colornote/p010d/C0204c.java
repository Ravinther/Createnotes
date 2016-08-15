package com.socialnmobile.colornote.p010d;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* renamed from: com.socialnmobile.colornote.d.c */
final class C0204c extends WebChromeClient {
    final /* synthetic */ C0202a f898a;

    private C0204c(C0202a c0202a) {
        this.f898a = c0202a;
    }

    public final void onReceivedTitle(WebView webView, String str) {
        super.onReceivedTitle(webView, str);
        if (str != null) {
            if (str.contains("code=")) {
                String[] split = str.split("=");
                this.f898a.f890d.loadData("", "text/html", "utf-8");
                r0.f892f = r1;
                new C0206e((byte) 0).execute(new String[]{split[1]});
            } else if (str.contains("error=")) {
                this.f898a.f888b.m493a();
                this.f898a.dismiss();
            }
        }
    }
}
