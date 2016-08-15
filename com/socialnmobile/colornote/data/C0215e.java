package com.socialnmobile.colornote.data;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.socialnmobile.colornote.data.e */
final class C0215e implements FilenameFilter {
    final /* synthetic */ C0214d f952a;

    C0215e(C0214d c0214d) {
        this.f952a = c0214d;
    }

    public final boolean accept(File file, String str) {
        if (str.endsWith(".idx") && str.contains("AUTO")) {
            return true;
        }
        if (str.endsWith(".doc") && str.contains("AUTO")) {
            return true;
        }
        return false;
    }
}
