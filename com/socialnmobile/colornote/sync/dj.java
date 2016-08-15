package com.socialnmobile.colornote.sync;

import com.socialnmobile.util.p011b.p021a.C0456e;
import com.socialnmobile.util.p011b.p021a.C0458g;

public interface dj extends SyncIndexColumns {
    public static final C0458g f1735a;
    public static final C0456e f1736b;

    static {
        f1735a = new C0458g(SyncIndexColumns.UUID);
        f1736b = new C0456e(SyncIndexColumns.REVISION);
    }
}
