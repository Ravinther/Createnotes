package com.socialnmobile.colornote.fragment;

import java.util.Collections;

final class ac implements Runnable {
    final /* synthetic */ ListEditor f1208a;

    ac(ListEditor listEditor) {
        this.f1208a = listEditor;
    }

    public final void run() {
        Collections.sort(this.f1208a.ap, new bc(this.f1208a));
        this.f1208a.ab();
    }
}
