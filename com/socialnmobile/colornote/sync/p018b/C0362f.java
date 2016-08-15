package com.socialnmobile.colornote.sync.p018b;

import java.util.Map.Entry;

/* renamed from: com.socialnmobile.colornote.sync.b.f */
final class C0362f implements Entry {
    final C0361e f1508a;
    final String f1509b;

    C0362f(C0361e c0361e, String str) {
        this.f1508a = c0361e;
        this.f1509b = str;
    }

    public final Object getValue() {
        return this.f1508a.get(this.f1509b);
    }

    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        return this.f1509b.hashCode() + 527;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0362f)) {
            return false;
        }
        return this.f1509b.equals(((C0362f) obj).f1509b);
    }

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.f1509b;
    }
}
