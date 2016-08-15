package com.socialnmobile.colornote.data;

import java.util.Iterator;

/* renamed from: com.socialnmobile.colornote.data.w */
final class C0233w implements Runnable {
    final /* synthetic */ NoteProvider f1029a;

    C0233w(NoteProvider noteProvider) {
        this.f1029a = noteProvider;
    }

    public final void run() {
        synchronized (this.f1029a.f918g) {
            Iterator it = this.f1029a.f918g.iterator();
            while (it.hasNext()) {
                ((C0235y) it.next()).m1084a();
            }
        }
    }
}
