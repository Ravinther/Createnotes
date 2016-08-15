package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0220j;
import java.util.Iterator;

final class ba implements Runnable {
    final /* synthetic */ boolean f1243a;
    final /* synthetic */ ListEditor f1244b;

    ba(ListEditor listEditor, boolean z) {
        this.f1244b = listEditor;
        this.f1243a = z;
    }

    public final void run() {
        Iterator it = this.f1244b.ap.iterator();
        while (it.hasNext()) {
            ((C0220j) it.next()).m1004a(this.f1243a);
        }
        this.f1244b.ab();
        this.f1244b.m1424R();
    }
}
