package com.socialnmobile.colornote.sync.errors;

import com.socialnmobile.colornote.sync.p019c.C0369b;

public class ColorNoteRpcError extends Exception {
    private static final long serialVersionUID = 4460001770567208483L;
    protected C0369b error;

    public ColorNoteRpcError(String str) {
        super(str);
    }

    public ColorNoteRpcError(C0369b c0369b) {
        super(c0369b.f1592b);
        this.error = c0369b;
    }
}
