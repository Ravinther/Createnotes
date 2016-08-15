package com.socialnmobile.colornote.data;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: com.socialnmobile.colornote.data.g */
final class C0217g implements FilenameFilter {
    final /* synthetic */ C0214d f954a;

    C0217g(C0214d c0214d) {
        this.f954a = c0214d;
    }

    public final boolean accept(File file, String str) {
        if (str.endsWith(".idx") || str.endsWith(".doc")) {
            return true;
        }
        return false;
    }
}
