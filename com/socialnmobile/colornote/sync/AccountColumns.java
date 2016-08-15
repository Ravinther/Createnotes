package com.socialnmobile.colornote.sync;

import android.provider.BaseColumns;
import com.socialnmobile.util.p011b.C0449a;
import com.socialnmobile.util.p011b.p021a.C0454c;
import com.socialnmobile.util.p011b.p021a.C0456e;
import com.socialnmobile.util.p011b.p021a.C0458g;

public interface AccountColumns extends BaseColumns {
    public static final String AUTH_TOKEN = "auth_token";
    public static final String BASE_REVISION = "base_revision";
    public static final String CLIENT_UUID = "client_uuid";
    public static final String COLORNOTE_ID = "colornote_id";
    public static final C0449a[] COLUMNS;
    public static final String EMAIL = "email";
    public static final String FACEBOOK_ACCESS_TOKEN = "fb_access";
    public static final String FACEBOOK_USER_NAME = "fb_user_name";
    public static final String REPOSITORY_BUILT = "repository_built";

    static {
        COLUMNS = new C0449a[]{new C0456e("_id"), new C0458g(CLIENT_UUID), new C0456e(REPOSITORY_BUILT), new C0454c(BASE_REVISION), new C0458g(AUTH_TOKEN), new C0458g(EMAIL), new C0458g(COLORNOTE_ID), new C0458g(FACEBOOK_ACCESS_TOKEN), new C0458g(FACEBOOK_USER_NAME)};
    }
}
