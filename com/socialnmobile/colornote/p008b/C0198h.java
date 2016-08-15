package com.socialnmobile.colornote.p008b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/* renamed from: com.socialnmobile.colornote.b.h */
public final class C0198h {
    final TreeSet f885a;

    public C0198h() {
        this.f885a = new TreeSet();
    }

    public final boolean m861a(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        Iterator it = this.f885a.iterator();
        while (it.hasNext()) {
            if (className.startsWith(((String) it.next()) + ".")) {
                return true;
            }
        }
        return false;
    }

    final StackTraceElement[] m862a(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < stackTraceElementArr.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            if (i == 0 || m861a(stackTraceElement)) {
                arrayList.add(stackTraceElement);
            } else {
                arrayList.add(null);
            }
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]);
    }

    static StackTraceElement[] m860b(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : stackTraceElementArr) {
            if (obj != null || r0 == 0) {
                arrayList.add(obj);
            }
            if (obj == null) {
                i = 1;
            } else {
                i = 0;
            }
        }
        return (StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]);
    }
}
