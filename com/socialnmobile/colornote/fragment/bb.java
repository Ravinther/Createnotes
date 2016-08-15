package com.socialnmobile.colornote.fragment;

import java.util.Collections;

final class bb implements Runnable {
    final /* synthetic */ ListEditor f1245a;

    bb(ListEditor listEditor) {
        this.f1245a = listEditor;
    }

    public final void run() {
        Collections.sort(this.f1245a.ap, new bh(this.f1245a, (byte) 0));
        this.f1245a.ab();
    }
}
