package com.socialnmobile.colornote.sync.errors;

import com.socialnmobile.colornote.sync.p019c.C0369b;

public class UserNotFound extends ColorNoteRpcError {
    private static final long serialVersionUID = -4185472424967940761L;

    public interface Listener {
        void onError(UserNotFound userNotFound);
    }

    public UserNotFound(C0369b c0369b) {
        super(c0369b);
    }
}
