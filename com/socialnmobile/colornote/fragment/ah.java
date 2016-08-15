package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0220j;

final class ah implements Runnable {
    final /* synthetic */ String f1213a;
    final /* synthetic */ ListEditor f1214b;

    ah(ListEditor listEditor, String str) {
        this.f1214b = listEditor;
        this.f1213a = str;
    }

    public final void run() {
        if (this.f1213a.equals("")) {
            this.f1214b.ap.remove(this.f1214b.as);
        } else {
            ((C0220j) this.f1214b.ap.get(this.f1214b.as)).m1003a(this.f1213a);
        }
        this.f1214b.ab();
    }
}
