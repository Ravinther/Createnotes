package com.socialnmobile.colornote.p010d;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.p004a.p005a.C0108d;
import com.p004a.p005a.C0111f;

/* renamed from: com.socialnmobile.colornote.d.a */
public final class C0202a extends Dialog {
    private String f887a;
    private C0108d f888b;
    private ProgressDialog f889c;
    private WebView f890d;
    private LinearLayout f891e;
    private boolean f892f;
    private Activity f893g;
    private FrameLayout f894h;
    private int f895i;
    private int f896j;

    public C0202a(Activity activity, String str, C0108d c0108d) {
        super(activity, 16973840);
        this.f887a = str;
        this.f888b = c0108d;
        this.f892f = false;
        this.f893g = activity;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f889c = new ProgressDialog(getContext());
        this.f889c.requestWindowFeature(1);
        this.f889c.setMessage(getContext().getString(2131230812));
        requestWindowFeature(1);
        this.f894h = new FrameLayout(getContext());
        getWindow().setGravity(17);
        C0111f.m503a(getContext(), getWindow());
        float f = getContext().getResources().getDisplayMetrics().density;
        this.f895i = (int) (16.0f * f);
        this.f896j = (int) (f * 8.0f);
        this.f891e = new LinearLayout(getContext());
        this.f891e.setOrientation(1);
        this.f890d = new C0203b(this, getContext());
        this.f890d.setVerticalScrollBarEnabled(false);
        this.f890d.setHorizontalScrollBarEnabled(false);
        this.f890d.setWebViewClient(new C0205d());
        this.f890d.setWebChromeClient(new C0204c());
        this.f890d.getSettings().setJavaScriptEnabled(true);
        try {
            this.f890d.loadUrl(this.f887a);
        } catch (SecurityException e) {
        }
        this.f890d.getSettings().setSavePassword(false);
        this.f890d.getSettings().setSaveFormData(false);
        this.f890d.setLayoutParams(new LayoutParams(-1, -1));
        this.f890d.setVisibility(4);
        this.f891e.setPadding(this.f896j, this.f895i, this.f896j, this.f895i);
        this.f891e.addView(this.f890d);
        this.f891e.setBackgroundColor(-2013265920);
        this.f894h.addView(this.f891e);
        getWindow().setSoftInputMode(16);
        setContentView(this.f894h);
    }
}
