package com.socialnmobile.colornote.sync.errors;

import com.socialnmobile.colornote.sync.C0367b;

public class UnexpectedLocalAccountException extends Exception {
    private static final long serialVersionUID = 3563710859278507387L;
    private final C0367b unexpectedAccount;

    public UnexpectedLocalAccountException(C0367b c0367b) {
        super("Sign Up/Sign In: Unexpected local account is detected");
        this.unexpectedAccount = c0367b;
    }

    public UnexpectedLocalAccountException() {
        super("Login: Local account should exists");
        this.unexpectedAccount = null;
    }

    public C0367b getUnexpectedAccount() {
        return this.unexpectedAccount;
    }
}
