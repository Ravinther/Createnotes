package com.socialnmobile.colornote.fragment;

final class am implements Runnable {
    final /* synthetic */ ListEditor f1223a;

    am(ListEditor listEditor) {
        this.f1223a = listEditor;
    }

    public final void run() {
        if (this.f1223a.ar != null) {
            this.f1223a.ar.notifyDataSetChanged();
        }
        if (this.f1223a.aq != null) {
            this.f1223a.aq.notifyDataSetChanged();
        }
    }
}
