package com.socialnmobile.colornote.sync;

import com.socialnmobile.util.p011b.p021a.C0454c;

public interface dy extends SyncStateColumns {
    public static final C0454c f1771a;
    public static final C0454c f1772b;

    static {
        f1771a = new C0454c(SyncStateColumns.DIRTY_STATE);
        f1772b = new C0454c(SyncStateColumns.STAGED_STATE);
    }
}
