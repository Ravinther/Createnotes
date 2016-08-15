package com.socialnmobile.colornote.menu;

import android.content.Context;
import com.socialnmobile.colornote.fragment.ScreenFragment;

/* renamed from: com.socialnmobile.colornote.menu.r */
public final class C0330r {
    public static TopBarSubMenuInfo m1711a(ScreenFragment screenFragment, C0164q c0164q) {
        Context context = screenFragment.f48C;
        int t = screenFragment.m1278t();
        TopBarSubMenuInfo topBarSubMenuInfo = new TopBarSubMenuInfo(context, context.getString(2131231074), c0164q);
        if (t != 3) {
            topBarSubMenuInfo.m1680a(1, 2130837597, 2131230989);
        } else {
            topBarSubMenuInfo.m1680a(6, 2130837597, 2131230988);
        }
        topBarSubMenuInfo.m1680a(5, 2130837594, 2131230987);
        topBarSubMenuInfo.m1680a(2, 2130837616, 2131230984);
        topBarSubMenuInfo.m1680a(3, 2130837617, 2131230986);
        if (t == 1) {
            topBarSubMenuInfo.m1680a(4, 2130837610, 2131230990);
        } else if (t == 4) {
            topBarSubMenuInfo.m1680a(7, 2130837605, 2131230985);
        }
        return topBarSubMenuInfo;
    }

    public static TopBarSubMenuInfo m1709a(Context context, C0164q c0164q) {
        TopBarSubMenuInfo topBarSubMenuInfo = new TopBarSubMenuInfo(context, context.getString(2131230849), c0164q);
        topBarSubMenuInfo.m1680a(1, 2130837625, 2131231020);
        topBarSubMenuInfo.m1680a(3, 2130837622, 2131231017);
        topBarSubMenuInfo.m1680a(2, 2130837623, 2131231018);
        topBarSubMenuInfo.m1680a(4, 2130837624, 2131231019);
        return topBarSubMenuInfo;
    }

    public static TopBarSubMenuInfo m1710a(Context context, C0164q c0164q, String str) {
        TopBarSubMenuInfo topBarSubMenuInfo;
        if (str == null) {
            topBarSubMenuInfo = new TopBarSubMenuInfo(context, context.getString(2131230818), c0164q);
        } else {
            topBarSubMenuInfo = new TopBarSubMenuInfo(context, str, c0164q);
        }
        topBarSubMenuInfo.m1680a(0, 2130837593, 2131231001);
        topBarSubMenuInfo.m1680a(16, 2130837604, 2131230744);
        return topBarSubMenuInfo;
    }
}
