package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.dialog.C0170m;

/* renamed from: com.socialnmobile.colornote.fragment.r */
final class C0294r implements C0170m {
    final /* synthetic */ AbstractEditorViewer f1340a;

    C0294r(AbstractEditorViewer abstractEditorViewer) {
        this.f1340a = abstractEditorViewer;
    }

    public final boolean m1592a(String str) {
        if (this.f1340a.ag) {
            if (C0213c.m962a(this.f1340a.f48C, str)) {
                this.f1340a.af = str;
                this.f1340a.ah = true;
                this.f1340a.m1269t();
                return true;
            }
        } else if (C0213c.m962a(this.f1340a.f48C, str)) {
            this.f1340a.af = str;
            this.f1340a.f1146Y.requery();
            return true;
        }
        return false;
    }
}
