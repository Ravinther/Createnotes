package com.socialnmobile.colornote.sync.errors;

import com.socialnmobile.colornote.sync.p019c.C0369b;

public class BadFields extends ColorNoteRpcError {
    private static final long serialVersionUID = 5541394430453862186L;

    public interface Listener {
        void onError(BadFields badFields);
    }

    public BadFields(C0369b c0369b) {
        super(c0369b);
    }
}
