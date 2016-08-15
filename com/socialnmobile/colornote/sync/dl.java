package com.socialnmobile.colornote.sync;

public final class dl extends RuntimeException {
    private static final long serialVersionUID = 6339927106210733168L;

    public dl(String str, Throwable th) {
        super(str, th);
    }

    public dl(String str) {
        super(str);
    }

    public dl(Throwable th) {
        super(th);
    }
}
