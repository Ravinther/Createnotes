package com.socialnmobile.colornote.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.C0015f;
import android.support.v4.app.C0017z;
import android.support.v4.app.C0031p;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public abstract class NoRestoreDialogFragment extends DialogFragment {
    public final void m1088a(C0031p c0031p, String str) {
        C0017z a = c0031p.m158a();
        a.m130a((C0015f) this, str);
        a.m133c();
    }

    public Dialog m1091t() {
        return null;
    }

    public void m1092u() {
    }

    public final void m1087a(Bundle bundle) {
        super.m84a(bundle);
        if (bundle != null) {
            this.f90d = false;
            m86a(true);
            Log.e("-_-", "------oncrate----");
            return;
        }
        m1092u();
    }

    public final Dialog m1089c(Bundle bundle) {
        if (bundle != null) {
            return null;
        }
        return m1091t();
    }

    public final View m1085a(LayoutInflater layoutInflater, Bundle bundle) {
        return bundle != null ? null : null;
    }

    public final void m1090d(Bundle bundle) {
        super.m92d(bundle);
        if (bundle == null) {
        }
    }

    public final void m1086a() {
        m86a(true);
    }
}
