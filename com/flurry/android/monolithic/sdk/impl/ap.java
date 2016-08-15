package com.flurry.android.monolithic.sdk.impl;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class ap {
    private Map f461a;
    private Map f462b;

    ap() {
        this.f461a = new HashMap();
        this.f462b = new HashMap();
    }

    public final synchronized void m555a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            Object obj2 = this.f461a.get(str);
            if (obj == obj2 || (obj != null && obj.equals(obj2))) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 == null) {
                if (obj == null) {
                    this.f461a.remove(str);
                } else {
                    this.f461a.put(str, obj);
                }
                if (this.f462b.get(str) != null) {
                    for (aq a : (List) this.f462b.get(str)) {
                        a.m520a(str, obj);
                    }
                }
            }
        }
    }

    public final synchronized Object m553a(String str) {
        return this.f461a.get(str);
    }

    public final synchronized void m554a(String str, aq aqVar) {
        if (aqVar != null) {
            List list = (List) this.f462b.get(str);
            if (list == null) {
                list = new LinkedList();
            }
            list.add(aqVar);
            this.f462b.put(str, list);
        }
    }

    public final synchronized boolean m556b(String str, aq aqVar) {
        boolean z;
        if (aqVar == null) {
            z = false;
        } else {
            List list = (List) this.f462b.get(str);
            if (list == null) {
                z = false;
            } else {
                z = list.remove(aqVar);
            }
        }
        return z;
    }
}
