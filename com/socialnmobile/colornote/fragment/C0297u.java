package com.socialnmobile.colornote.fragment;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.socialnmobile.colornote.fragment.u */
final class C0297u implements OnClickListener {
    final /* synthetic */ AbstractEditorViewer f1343a;

    C0297u(AbstractEditorViewer abstractEditorViewer) {
        this.f1343a = abstractEditorViewer;
    }

    public final void onClick(View view) {
        if (this.f1343a.aa) {
            this.f1343a.m1263d(102);
            return;
        }
        switch (this.f1343a.f1149b) {
            case 1:
            case 2:
                this.f1343a.m1225D();
            case 3:
                if (this.f1343a.f1147Z.f1004c == 0) {
                    this.f1343a.m1255a(false, "BUTTON");
                } else if (this.f1343a.f1147Z.f1004c == 16) {
                    this.f1343a.m1263d(102);
                }
            default:
        }
    }
}
