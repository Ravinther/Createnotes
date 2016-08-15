package com.socialnmobile.colornote.menu;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.support.v4.app.C0015f;
import android.support.v4.app.C0031p;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import com.socialnmobile.colornote.C0312i;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.dialog.NoRestoreDialogFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class TopBarSubMenuInfo {
    C0316a f1376a;
    public ArrayList f1377b;
    String f1378c;
    int f1379d;
    public C0164q f1380e;

    public class SubMenuDialogFragment extends NoRestoreDialogFragment {
        TopBarSubMenuInfo f1375Y;

        public SubMenuDialogFragment(TopBarSubMenuInfo topBarSubMenuInfo) {
            this.f1375Y = topBarSubMenuInfo;
        }

        public final Dialog m1677a(Context context) {
            Builder builder = new Builder(context);
            builder.setTitle(this.f1375Y.f1378c);
            builder.setAdapter(this.f1375Y.m1683b(context), new C0331s(this.f1375Y));
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            return create;
        }

        public final Dialog m1678t() {
            return m1677a(this.f48C);
        }
    }

    public TopBarSubMenuInfo(Context context, String str, C0164q c0164q) {
        int i = 1;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i2 = (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
        if ((C0312i.m1627a(context) > 480 || !C0313j.m1663b(context)) && i2 > 480) {
            i = 2;
        }
        this.f1379d = i;
        this.f1377b = new ArrayList();
        this.f1378c = str;
        this.f1380e = c0164q;
    }

    public final void m1680a(int i, int i2, int i3) {
        this.f1377b.add(new C0329p(i, i2, i3));
    }

    public final void m1681a(int i, int i2, String str) {
        this.f1377b.add(new C0329p(0, i, i2, str));
    }

    public final void m1682a(C0015f c0015f, C0031p c0031p, View view, boolean z) {
        if (!c0015f.f83w) {
            return;
        }
        if (this.f1379d == 1 || z) {
            FragmentActivity fragmentActivity = c0015f.f48C;
            new SubMenuDialogFragment(this).m85a(c0031p, "dialog");
            return;
        }
        this.f1376a = new C0316a(view.getContext(), view, this.f1377b, this.f1380e);
        this.f1376a.m1687a();
    }

    public final Dialog m1679a(Context context) {
        return new SubMenuDialogFragment(this).m1677a(context);
    }

    public final ListAdapter m1683b(Context context) {
        List arrayList = new ArrayList();
        Iterator it = this.f1377b.iterator();
        while (it.hasNext()) {
            C0329p c0329p = (C0329p) it.next();
            HashMap hashMap = new HashMap();
            hashMap.put("ICON", Integer.valueOf(c0329p.f1441b));
            hashMap.put("TEXT", context.getString(c0329p.f1442c));
            arrayList.add(hashMap);
        }
        return new SimpleAdapter(context, arrayList, 2130903087, new String[]{"ICON", "TEXT"}, new int[]{2131624092, 2131624031});
    }
}
