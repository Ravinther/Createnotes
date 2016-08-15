package com.socialnmobile.colornote.sync.errors;

import com.socialnmobile.colornote.sync.p019c.C0369b;

public class AuthRequired extends ColorNoteRpcError {
    private static final long serialVersionUID = -3401879374647309191L;

    public interface Listener {
        void onError(AuthRequired authRequired);
    }

    public AuthRequired(C0369b c0369b) {
        super(c0369b);
    }

    public AuthRequired(String str) {
        super(str);
    }
}
