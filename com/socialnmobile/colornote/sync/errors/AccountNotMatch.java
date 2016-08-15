package com.socialnmobile.colornote.sync.errors;

import com.socialnmobile.colornote.sync.p019c.C0369b;

public class AccountNotMatch extends ColorNoteRpcError {
    private static final long serialVersionUID = 5520397284687391627L;

    public interface Listener {
        void onError(AccountNotMatch accountNotMatch);
    }

    public AccountNotMatch(C0369b c0369b) {
        super(c0369b);
    }
}
