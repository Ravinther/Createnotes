package com.socialnmobile.colornote.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

/* renamed from: com.socialnmobile.colornote.fragment.s */
final class C0295s implements OnCancelListener {
    final /* synthetic */ AbstractEditorViewer f1341a;

    C0295s(AbstractEditorViewer abstractEditorViewer) {
        this.f1341a = abstractEditorViewer;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (!this.f1341a.ag) {
            this.f1341a.m1258b(0);
        }
    }
}
