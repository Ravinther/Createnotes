package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0220j;
import java.util.ArrayList;

final class al implements Runnable {
    final /* synthetic */ String f1220a;
    final /* synthetic */ ArrayList f1221b;
    final /* synthetic */ ListEditor f1222c;

    al(ListEditor listEditor, String str, ArrayList arrayList) {
        this.f1222c = listEditor;
        this.f1220a = str;
        this.f1221b = arrayList;
    }

    public final void run() {
        if (this.f1220a.equals("")) {
            this.f1221b.remove(this.f1222c.as);
        } else {
            ((C0220j) this.f1221b.get(this.f1222c.as)).m1003a(this.f1220a);
        }
        if (this.f1221b == this.f1222c.ap) {
            this.f1222c.ab();
        }
    }
}
