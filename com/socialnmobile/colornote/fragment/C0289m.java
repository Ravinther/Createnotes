package com.socialnmobile.colornote.fragment;

/* renamed from: com.socialnmobile.colornote.fragment.m */
final class C0289m implements Runnable {
    final /* synthetic */ int f1333a;
    final /* synthetic */ AbstractEditorViewer f1334b;

    C0289m(AbstractEditorViewer abstractEditorViewer, int i) {
        this.f1334b = abstractEditorViewer;
        this.f1333a = i;
    }

    public final void run() {
        if (this.f1334b.f83w) {
            this.f1334b.m1259c(this.f1333a).m85a(this.f1334b.f47B, "dialog");
        } else {
            this.f1334b.as = this.f1333a;
        }
    }
}
