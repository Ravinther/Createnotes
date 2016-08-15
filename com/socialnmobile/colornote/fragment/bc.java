package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0220j;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

final class bc implements Comparator {
    Collator f1246a;
    final /* synthetic */ ListEditor f1247b;

    public bc(ListEditor listEditor) {
        this.f1247b = listEditor;
        this.f1246a = Collator.getInstance(Locale.getDefault());
        this.f1246a.setDecomposition(1);
        this.f1246a.setStrength(3);
    }

    public final int compare(Object obj, Object obj2) {
        return this.f1246a.compare(((C0220j) obj).f964a, ((C0220j) obj2).f964a);
    }
}
