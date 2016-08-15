package com.socialnmobile.colornote.fragment;

import com.socialnmobile.colornote.data.C0220j;
import java.util.Comparator;

final class bh implements Comparator {
    final /* synthetic */ ListEditor f1255a;

    private bh(ListEditor listEditor) {
        this.f1255a = listEditor;
    }

    public final int compare(Object obj, Object obj2) {
        return Boolean.valueOf(((C0220j) obj).m1005a()).compareTo(Boolean.valueOf(((C0220j) obj2).m1005a()));
    }
}
