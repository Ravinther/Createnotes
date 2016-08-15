package com.flurry.android.monolithic.sdk.impl;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.view.KeyEvent;
import android.view.ViewParent;
import com.flurry.android.impl.ads.avro.protocol.v6.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v6.AdUnit;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
/* renamed from: com.flurry.android.monolithic.sdk.impl.o */
public class C0130o extends ac implements OnKeyListener, OnCompletionListener, OnErrorListener, OnPreparedListener {
    private ProgressDialog f562e;
    private C0129n f563f;
    private boolean f564g;
    private boolean f565h;
    private boolean f566i;
    private AlertDialog f567j;
    private List f568k;

    private synchronized void setFlurryJsEnvInitialized(boolean z) {
        this.f565h = z;
    }

    private synchronized void setMraidJsEnvInitialized(boolean z) {
        this.f566i = z;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m626a("videoCompleted", Collections.emptyMap(), this.c, this.b, this.d);
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        if (getCurrentBinding() == 3) {
            if (this.f562e.isShowing()) {
                this.f562e.dismiss();
            }
            if ((this.f567j == null || !this.f567j.isShowing()) && this.f563f != null && this.f564g) {
                this.f563f.start();
            }
            m626a("rendered", Collections.emptyMap(), this.c, this.b, this.d);
            m626a("videoStart", Collections.emptyMap(), this.c, this.b, this.d);
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.f562e != null && this.f562e.isShowing()) {
            this.f562e.dismiss();
        }
        m626a("renderFailed", Collections.emptyMap(), this.c, this.b, this.d);
        removeView(this.f563f);
        return false;
    }

    private void m626a(String str, Map map, AdUnit adUnit, bl blVar, int i) {
        bh.m584a(3, "fireEvent(event=" + str + ",params=" + map + ")");
        this.a.a(new C0120e(str, map, getContext(), adUnit, blVar, i), this, 0);
    }

    int getCurrentBinding() {
        return getCurrentAdFrame().b().intValue();
    }

    String getCurrentContent() {
        return getCurrentAdFrame().d().toString();
    }

    String getCurrentDisplay() {
        return getCurrentAdFrame().c().toString();
    }

    String getCurrentFormat() {
        return getCurrentAdFrame().e().e().toString();
    }

    AdFrame getCurrentAdFrame() {
        return (AdFrame) this.f568k.get(this.d);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        bh.m584a(3, "onkey,keycode=" + i + ",event=" + keyEvent.getAction());
        if (dialogInterface != this.f562e || i != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        m626a("adWillClose", Collections.emptyMap(), this.c, this.b, this.d);
        dialogInterface.dismiss();
        return true;
    }

    an getHolder() {
        try {
            ViewParent parent = getParent();
            return parent != null ? (an) parent : null;
        } catch (ClassCastException e) {
            bh.m584a(5, "AdUnityView parent not a BannerHolder:" + e.getMessage());
            return null;
        }
    }
}
