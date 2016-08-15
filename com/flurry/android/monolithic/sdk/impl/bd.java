package com.flurry.android.monolithic.sdk.impl;

import java.io.File;

public final class bd {
    static String f499a;

    private bd() {
    }

    static {
        f499a = bd.class.getSimpleName();
    }

    public static boolean m579a(File file) {
        if (file == null) {
            return false;
        }
        File parentFile = file.getParentFile();
        if (parentFile.mkdirs() || parentFile.exists()) {
            return true;
        }
        bh.m584a(6, "Unable to create persistent dir: " + parentFile);
        return false;
    }
}
