package com.socialnmobile.colornote.p010d;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.p004a.p005a.C0106a;

/* renamed from: com.socialnmobile.colornote.d.d */
final class C0205d extends WebViewClient {
    final /* synthetic */ C0202a f899a;

    private C0205d(C0202a c0202a) {
        this.f899a = c0202a;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        this.f899a.f890d.loadUrl(str);
        return true;
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f899a.f888b.m495a(new C0106a(str, i, str2));
        this.f899a.dismiss();
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (!this.f899a.f893g.isFinishing()) {
            this.f899a.f889c.show();
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f899a.f890d.setVisibility(0);
        if (!this.f899a.f893g.isFinishing() && !this.f899a.f892f && this.f899a.f889c.isShowing()) {
            this.f899a.f889c.dismiss();
        }
    }
}
