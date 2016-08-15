package com.socialnmobile.colornote.dialog;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.socialnmobile.colornote.dialog.e */
final class C0241e implements OnClickListener {
    final /* synthetic */ C0240d f1071a;

    C0241e(C0240d c0240d) {
        this.f1071a = c0240d;
    }

    public final void onClick(View view) {
        int i = 8;
        switch (view.getId()) {
            case 2131624009:
                i = 1;
                break;
            case 2131624011:
                i = 2;
                break;
            case 2131624013:
                i = 3;
                break;
            case 2131624015:
                i = 4;
                break;
            case 2131624017:
                i = 5;
                break;
            case 2131624019:
                i = 6;
                break;
            case 2131624021:
                i = 7;
                break;
            case 2131624025:
                i = 9;
                break;
        }
        if (this.f1071a.f1067a != null) {
            this.f1071a.f1067a.m1129a(i);
        }
        this.f1071a.dismiss();
    }
}
