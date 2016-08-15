package com.socialnmobile.colornote.fragment;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.Toast;
import com.socialnmobile.colornote.data.C0229s;

/* renamed from: com.socialnmobile.colornote.fragment.f */
final class C0282f implements OnClickListener {
    final /* synthetic */ AbstractEditorViewer f1326a;

    C0282f(AbstractEditorViewer abstractEditorViewer) {
        this.f1326a = abstractEditorViewer;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (!this.f1326a.aa) {
            C0229s.m1041a(this.f1326a.f48C, this.f1326a.f1150c);
            this.f1326a.f1146Y.requery();
        } else if (C0229s.m1054f(this.f1326a.f48C, this.f1326a.f1150c)) {
            Toast.makeText(this.f1326a.f48C, 2131230787, 0).show();
        } else {
            Toast.makeText(this.f1326a.f48C, 2131230794, 0).show();
        }
    }
}
