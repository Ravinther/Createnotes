package com.socialnmobile.colornote.sync;

import java.net.URI;

/* renamed from: com.socialnmobile.colornote.sync.q */
public final class C0401q {
    public long f1803a;
    public cq f1804b;
    public bg f1805c;
    public bg f1806d;
    public bg f1807e;
    public int f1808f;
    public C0409z f1809g;
    public boolean f1810h;
    public URI f1811i;
    public boolean f1812j;

    private C0401q(long j, cq cqVar, bg bgVar, bg bgVar2, bg bgVar3, int i, C0409z c0409z, boolean z) {
        this.f1810h = false;
        this.f1811i = null;
        this.f1812j = false;
        this.f1803a = j;
        this.f1804b = cqVar;
        this.f1805c = bgVar;
        this.f1806d = bgVar2;
        this.f1807e = bgVar3;
        this.f1808f = i;
        this.f1809g = c0409z;
        this.f1810h = false;
        this.f1811i = null;
        this.f1812j = z;
    }

    public C0401q(long j, cq cqVar, bg bgVar, bg bgVar2, bg bgVar3, int i, C0409z c0409z, boolean z, byte b) {
        this(j, cqVar, bgVar, bgVar2, bgVar3, i, c0409z, z);
    }

    public C0401q(long j, cq cqVar, bg bgVar, bg bgVar2, bg bgVar3, int i, C0409z c0409z) {
        this(j, cqVar, bgVar, bgVar2, bgVar3, i, c0409z, false, (byte) 0);
    }
}
