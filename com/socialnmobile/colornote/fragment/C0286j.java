package com.socialnmobile.colornote.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.socialnmobile.colornote.data.C0229s;

/* renamed from: com.socialnmobile.colornote.fragment.j */
final class C0286j implements OnClickListener {
    final /* synthetic */ AbstractEditorViewer f1330a;

    C0286j(AbstractEditorViewer abstractEditorViewer) {
        this.f1330a = abstractEditorViewer;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f1330a.m1222A();
        C0229s.m1042a(this.f1330a.f48C, this.f1330a.f1150c, this.f1330a.f1147Z.f1014m);
        this.f1330a.f1146Y.requery();
    }
}
