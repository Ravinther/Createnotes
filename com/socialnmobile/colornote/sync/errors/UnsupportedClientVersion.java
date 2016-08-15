package com.socialnmobile.colornote.sync.errors;

import com.socialnmobile.colornote.sync.p019c.C0369b;

public class UnsupportedClientVersion extends ColorNoteRpcError {
    private static final long serialVersionUID = -8303050972783043872L;

    public interface Listener {
        void onError(UnsupportedClientVersion unsupportedClientVersion);
    }

    public UnsupportedClientVersion(C0369b c0369b) {
        super(c0369b);
    }
}
