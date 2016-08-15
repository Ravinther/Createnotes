package com.flurry.android.monolithic.sdk.impl;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.RelativeLayout;

@SuppressLint({"SetJavaScriptEnabled"})
public final class ar extends RelativeLayout implements OnClickListener {
    private WebView f463a;
    private C0119d f464b;
    private C0116a f465c;
    private C0117b f466d;

    public final void setBasicWebViewUrlLoadingHandler(C0119d c0119d) {
        this.f464b = c0119d;
    }

    public final C0119d getBasicWebViewUrlLoadingHandler() {
        return this.f464b;
    }

    public final void setBasicWebViewClosingHandler(C0116a c0116a) {
        this.f465c = c0116a;
    }

    public final C0116a getBasicWebViewClosingHandler() {
        return this.f465c;
    }

    public final void setBasicWebViewFullScreenTransitionHandler(C0117b c0117b) {
        this.f466d = c0117b;
    }

    public final C0117b getBasicWebViewFullScreenTransitionHandler() {
        return this.f466d;
    }

    public final String getUrl() {
        if (this.f463a != null) {
            return this.f463a.getUrl();
        }
        return null;
    }

    public final void onClick(View view) {
        int i;
        switch (view.getId()) {
            case 0:
                if (this.f465c != null) {
                    i = C0118c.f515c;
                }
            case 1:
                if (this.f463a != null && this.f463a.canGoBack()) {
                    this.f463a.goBack();
                } else if (this.f465c != null) {
                    i = C0118c.f514b;
                }
            case 2:
                if (this.f463a != null && this.f463a.canGoForward()) {
                    this.f463a.goForward();
                }
            default:
        }
    }
}
