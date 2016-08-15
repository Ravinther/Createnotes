package com.flurry.android.monolithic.sdk.impl;

import java.io.File;
import java.io.FilenameFilter;

final class ay implements FilenameFilter {
    ay() {
    }

    public final boolean accept(File file, String str) {
        return str.startsWith(".flurryagent.");
    }
}
