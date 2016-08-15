package com.socialnmobile.colornote.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.data.C0229s;

/* renamed from: com.socialnmobile.colornote.fragment.k */
final class C0287k implements OnClickListener {
    final /* synthetic */ AbstractEditorViewer f1331a;

    C0287k(AbstractEditorViewer abstractEditorViewer) {
        this.f1331a = abstractEditorViewer;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        C0229s.m1043a(this.f1331a.f48C, this.f1331a.f1150c, this.f1331a.f1147Z.f1005d, 0, 4096);
        this.f1331a.f1146Y.requery();
    }
}
