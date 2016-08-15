package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0220j;
import java.util.Iterator;

final class ab implements Runnable {
    final /* synthetic */ ListEditor f1207a;

    ab(ListEditor listEditor) {
        this.f1207a = listEditor;
    }

    public final void run() {
        Iterator it = this.f1207a.ap.iterator();
        while (it.hasNext()) {
            if (((C0220j) it.next()).m1005a()) {
                it.remove();
            }
        }
        this.f1207a.ab();
    }
}
