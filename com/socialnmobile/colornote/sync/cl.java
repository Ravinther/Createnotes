package com.socialnmobile.colornote.sync;

public class cl extends Exception {
    private static final long serialVersionUID = -6123594830805857200L;

    public cl(String str) {
        super(str);
    }

    public cl(Throwable th) {
        super(th);
    }

    public cl(String str, Throwable th) {
        super(str, th);
    }

    public static void m1829a(Object obj) {
        if (obj == null) {
            throw new cl();
        }
    }
}
