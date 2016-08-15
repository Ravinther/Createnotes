package com.socialnmobile.colornote.sync;

import com.socialnmobile.util.p011b.p017b.C0356a;
import com.socialnmobile.util.p011b.p017b.C0463f;
import java.util.Date;

public final class bi extends C0356a {
    final Date f1559a;

    public bi() {
        this.f1559a = new Date(0);
    }

    public final /* synthetic */ Object m1895a(Object obj) {
        return new bg(((Date) C0463f.f2257b.m1783d((String) obj)).getTime());
    }

    public final /* synthetic */ Object m1896b(Object obj) {
        return m1894a((bg) obj);
    }

    private String m1894a(bg bgVar) {
        synchronized (this) {
            this.f1559a.setTime(bgVar.f1558a);
        }
        return (String) C0463f.f2257b.m1782c(this.f1559a);
    }
}
