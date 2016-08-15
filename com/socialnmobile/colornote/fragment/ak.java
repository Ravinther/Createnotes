package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0220j;
import java.util.ArrayList;

final class ak implements Runnable {
    final /* synthetic */ ArrayList f1218a;
    final /* synthetic */ ListEditor f1219b;

    ak(ListEditor listEditor, ArrayList arrayList) {
        this.f1219b = listEditor;
        this.f1218a = arrayList;
    }

    public final void run() {
        if (((C0220j) this.f1218a.get(this.f1219b.as)).f964a.trim().equals("")) {
            this.f1218a.remove(this.f1219b.as);
            if (this.f1218a == this.f1219b.ap) {
                this.f1219b.ab();
            }
        }
    }
}
