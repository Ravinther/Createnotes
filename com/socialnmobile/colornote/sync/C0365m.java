package com.socialnmobile.colornote.sync;

import com.socialnmobile.util.p011b.p021a.C0456e;
import com.socialnmobile.util.p011b.p021a.C0458g;

/* renamed from: com.socialnmobile.colornote.sync.m */
public interface C0365m extends AccountColumns {
    public static final C0456e f1510A;
    public static final C0456e f1511B;
    public static final C0458g f1512C;
    public static final C0458g f1513D;
    public static final C0458g f1514E;
    public static final C0458g f1515F;
    public static final C0458g f1516G;
    public static final C0456e f1517y;
    public static final C0458g f1518z;

    static {
        f1517y = new C0456e("_id");
        f1518z = new C0458g(AccountColumns.CLIENT_UUID);
        f1510A = new C0456e(AccountColumns.REPOSITORY_BUILT);
        f1511B = new C0456e(AccountColumns.BASE_REVISION);
        f1512C = new C0458g(AccountColumns.AUTH_TOKEN);
        f1513D = new C0458g(AccountColumns.EMAIL);
        f1514E = new C0458g(AccountColumns.COLORNOTE_ID);
        f1515F = new C0458g(AccountColumns.FACEBOOK_ACCESS_TOKEN);
        f1516G = new C0458g(AccountColumns.FACEBOOK_USER_NAME);
    }
}
