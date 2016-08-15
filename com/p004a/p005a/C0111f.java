package com.p004a.p005a;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/* renamed from: com.a.a.f */
public final class C0111f extends Dialog {
    private String f351a;
    private C0108d f352b;
    private ProgressDialog f353c;
    private WebView f354d;
    private LinearLayout f355e;
    private Activity f356f;
    private FrameLayout f357g;
    private int f358h;

    public C0111f(Activity activity, String str, C0108d c0108d) {
        super(activity, 16973840);
        this.f351a = str;
        this.f352b = c0108d;
        this.f356f = activity;
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f353c = new ProgressDialog(getContext());
        this.f353c.requestWindowFeature(1);
        int identifier = getContext().getResources().getIdentifier("loading", "string", getContext().getPackageName());
        if (identifier != 0) {
            this.f353c.setMessage(getContext().getText(identifier));
        } else {
            this.f353c.setMessage("Loading...");
        }
        requestWindowFeature(1);
        this.f357g = new FrameLayout(getContext());
        getWindow().setGravity(17);
        C0111f.m503a(getContext(), getWindow());
        this.f358h = (int) (getContext().getResources().getDisplayMetrics().density * 16.0f);
        this.f355e = new LinearLayout(getContext());
        this.f355e.setOrientation(1);
        this.f354d = new C0112g(this, getContext());
        this.f354d.setVerticalScrollBarEnabled(false);
        this.f354d.setHorizontalScrollBarEnabled(false);
        this.f354d.setWebViewClient(new C0113h());
        this.f354d.getSettings().setJavaScriptEnabled(true);
        this.f354d.loadUrl(this.f351a);
        this.f354d.getSettings().setSavePassword(false);
        this.f354d.getSettings().setSaveFormData(false);
        this.f354d.setLayoutParams(new LayoutParams(-1, -1));
        this.f354d.setVisibility(4);
        this.f355e.setPadding(this.f358h, this.f358h, this.f358h, this.f358h);
        this.f355e.addView(this.f354d);
        this.f355e.setBackgroundColor(-2013265920);
        this.f357g.addView(this.f355e);
        getWindow().setSoftInputMode(16);
        setContentView(this.f357g);
    }

    public static void m503a(Context context, Window window) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        window.setLayout(Math.min(C0111f.m501a(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.widthPixels : displayMetrics.heightPixels, displayMetrics.density, 480, 800), displayMetrics.widthPixels), Math.min(C0111f.m501a(displayMetrics.widthPixels < displayMetrics.heightPixels ? displayMetrics.heightPixels : displayMetrics.widthPixels, displayMetrics.density, 800, 1280), displayMetrics.heightPixels));
    }

    private static int m501a(int i, float f, int i2, int i3) {
        double d = 0.5d;
        int i4 = (int) (((float) i) / f);
        if (i4 <= i2) {
            d = 1.0d;
        } else if (i4 < i3) {
            d = 0.5d + ((((double) (i3 - i4)) / ((double) (i3 - i2))) * 0.5d);
        }
        return (int) (d * ((double) i));
    }
}
