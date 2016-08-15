package com.socialnmobile.colornote.sync.errors;

import com.socialnmobile.colornote.sync.p019c.C0369b;

public class ExternalAuthFailed extends ColorNoteRpcError {
    private static final long serialVersionUID = 6006958182060277420L;

    public interface Listener {
        void onError(ExternalAuthFailed externalAuthFailed);
    }

    public ExternalAuthFailed(C0369b c0369b) {
        super(c0369b);
    }
}
