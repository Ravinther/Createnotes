package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0220j;

final class ai implements Runnable {
    final /* synthetic */ String f1215a;
    final /* synthetic */ ListEditor f1216b;

    ai(ListEditor listEditor, String str) {
        this.f1216b = listEditor;
        this.f1215a = str;
    }

    public final void run() {
        if (this.f1215a.equals("")) {
            this.f1216b.ap.remove(this.f1216b.as);
        } else {
            ((C0220j) this.f1216b.ap.get(this.f1216b.as)).m1003a(this.f1215a);
            this.f1216b.a.post(new aj(this));
        }
        this.f1216b.ab();
    }
}
