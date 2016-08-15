package com.socialnmobile.colornote.sync;

import android.os.Handler;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class cd {
    final HashMap f1605a;
    final Handler f1606b;

    public cd(Handler handler) {
        this.f1605a = new HashMap();
        this.f1606b = handler;
        for (Object put : cb.values()) {
            this.f1605a.put(put, new HashSet());
        }
    }

    public final void m1944a(cb cbVar, Object obj) {
        HashSet hashSet = (HashSet) this.f1605a.get(cbVar);
        synchronized (hashSet) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                this.f1606b.post(new ce(this, (cc) it.next(), cbVar, obj));
            }
        }
    }
}
