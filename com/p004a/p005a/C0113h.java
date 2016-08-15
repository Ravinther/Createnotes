package com.p004a.p005a;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* renamed from: com.a.a.h */
final class C0113h extends WebViewClient {
    final /* synthetic */ C0111f f360a;

    private C0113h(C0111f c0111f) {
        this.f360a = c0111f;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Log.d("Facebook-WebView", "Redirect URL: " + str);
        if (str.startsWith("fbconnect://success")) {
            Bundle a = C0114i.m507a(str);
            String string = a.getString("error");
            if (string == null) {
                string = a.getString("error_type");
            }
            if (string == null) {
                this.f360a.f352b.m494a(a);
            } else if (string.equals("access_denied") || string.equals("OAuthAccessDeniedException")) {
                this.f360a.f352b.m493a();
            } else {
                this.f360a.f352b.m496a(new C0110e(string));
            }
            this.f360a.dismiss();
            return true;
        } else if (str.startsWith("fbconnect://cancel")) {
            this.f360a.f352b.m493a();
            this.f360a.dismiss();
            return true;
        } else if (str.contains("touch")) {
            return false;
        } else {
            this.f360a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return true;
        }
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        this.f360a.f352b.m495a(new C0106a(str, i, str2));
        this.f360a.dismiss();
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Log.d("Facebook-WebView", "Webview loading URL: " + str);
        super.onPageStarted(webView, str, bitmap);
        if (!this.f360a.f356f.isFinishing()) {
            this.f360a.f353c.show();
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f360a.f354d.setVisibility(0);
        if (!this.f360a.f356f.isFinishing()) {
            this.f360a.f353c.dismiss();
        }
    }
}
