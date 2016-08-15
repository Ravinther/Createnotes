package com.socialnmobile.colornote.sync;

import java.util.Date;
import org.apache.http.HttpRequest;

public final class aq extends am {
    public final String f1497b;

    public aq(String str) {
        this.f1497b = str;
    }

    public final void m1801a(HttpRequest httpRequest) {
        httpRequest.addHeader("X-COLORNOTE-TOKEN-V1", this.f1497b);
    }

    public final boolean m1802a(Date date) {
        return false;
    }

    public final boolean equals(Object obj) {
        return m1800a(obj);
    }

    private boolean m1800a(Object obj) {
        try {
            return this.f1497b.equals(((aq) obj).f1497b);
        } catch (Exception e) {
            return false;
        }
    }
}
