package com.socialnmobile.colornote.view;

import com.socialnmobile.colornote.dialog.C0242f;

/* renamed from: com.socialnmobile.colornote.view.l */
final class C0421l implements C0242f {
    final /* synthetic */ ColorPreference f2181a;

    C0421l(ColorPreference colorPreference) {
        this.f2181a = colorPreference;
    }

    public final void m2214a(int i) {
        this.f2181a.m2063a(i);
        this.f2181a.persistInt(i);
        this.f2181a.notifyChanged();
    }
}
