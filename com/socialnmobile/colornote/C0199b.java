package com.socialnmobile.colornote;

import android.widget.Toast;

/* renamed from: com.socialnmobile.colornote.b */
final class C0199b implements Runnable {
    final /* synthetic */ String f886a;

    C0199b(String str) {
        this.f886a = str;
    }

    public final void run() {
        Toast.makeText(ColorNote.f599b, this.f886a, 1).show();
    }
}
