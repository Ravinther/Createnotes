package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.p012f.C0269a;
import java.util.Collection;

final class az implements Runnable {
    final /* synthetic */ String f1240a;
    final /* synthetic */ ListEditor f1241b;

    az(ListEditor listEditor, String str) {
        this.f1241b = listEditor;
        this.f1240a = str;
    }

    public final void run() {
        Collection b = C0269a.m1204b(this.f1240a);
        this.f1241b.ap.clear();
        this.f1241b.ap.addAll(b);
        this.f1241b.ab();
    }
}
