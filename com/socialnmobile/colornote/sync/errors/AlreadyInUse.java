package com.socialnmobile.colornote.sync.errors;

import com.socialnmobile.colornote.sync.p019c.C0369b;

public class AlreadyInUse extends ColorNoteRpcError {
    private static final long serialVersionUID = 6051525333101886884L;

    public interface Listener {
        void onError(AlreadyInUse alreadyInUse);
    }

    public AlreadyInUse(C0369b c0369b) {
        super(c0369b);
    }
}
