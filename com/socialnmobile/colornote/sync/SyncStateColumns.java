package com.socialnmobile.colornote.sync;

import android.provider.BaseColumns;

public interface SyncStateColumns extends BaseColumns {
    public static final String DIRTY_STATE = "dirty";
    public static final String STAGED_STATE = "staged";
}
