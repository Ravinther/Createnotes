package com.socialnmobile.colornote.sync.errors;

import com.socialnmobile.colornote.sync.C0405u;
import com.socialnmobile.colornote.sync.p018b.C0357a;
import com.socialnmobile.colornote.sync.p018b.C0359c;
import com.socialnmobile.colornote.sync.p018b.C0361e;
import com.socialnmobile.colornote.sync.p019c.C0369b;

public class PasswordNotMatch extends ColorNoteRpcError {
    static final String AUTH_SUGGEST = "auth_suggest";
    private static final long serialVersionUID = -5283704965596397740L;

    public interface Listener {
        void onError(PasswordNotMatch passwordNotMatch);
    }

    public PasswordNotMatch(C0369b c0369b) {
        super(c0369b);
    }

    public C0405u getAuthSuggest() {
        try {
            C0361e c = C0357a.m1824c(this.error.f1593c);
            if (c != null) {
                String h = c.m1842h(AUTH_SUGGEST);
                if (h != null) {
                    return C0405u.m2057a(h.toLowerCase());
                }
            }
        } catch (C0359c e) {
        }
        return null;
    }
}
