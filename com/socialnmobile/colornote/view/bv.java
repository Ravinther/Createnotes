package com.socialnmobile.colornote.view;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.menu.C0326m;
import com.socialnmobile.colornote.menu.C0329p;
import com.socialnmobile.colornote.p007e.C0262d;

public final class bv {
    public View f2125a;
    View f2126b;
    public TextView f2127c;
    public TextView f2128d;
    ImageView f2129e;
    public MyImageButton[] f2130f;
    public int[] f2131g;
    public OnClickListener f2132h;

    public bv(View view) {
        this.f2130f = new MyImageButton[3];
        this.f2131g = new int[]{0, 0, 0};
        this.f2125a = view;
        this.f2128d = (TextView) view.findViewById(2131624084);
        this.f2129e = (ImageView) view.findViewById(2131624085);
        this.f2130f[0] = (MyImageButton) view.findViewById(2131624088);
        this.f2130f[1] = (MyImageButton) view.findViewById(2131624089);
        this.f2130f[2] = (MyImageButton) view.findViewById(2131624090);
        this.f2126b = view.findViewById(2131624082);
        this.f2127c = (TextView) view.findViewById(2131624087);
        this.f2126b.setOnClickListener(new bw(this));
    }

    public final void m2209a(C0262d c0262d) {
        this.f2125a.setBackgroundDrawable(new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{c0262d.m1145n(6), c0262d.m1145n(7)}));
        this.f2128d.setTextColor(c0262d.m1145n(8));
        this.f2125a.findViewById(2131624081).setBackgroundColor(c0262d.m1145n(9));
        this.f2129e.setImageResource(c0262d.m1132b());
    }

    public final void m2210a(C0326m c0326m) {
        Context context = this.f2125a.getContext();
        this.f2131g = new int[]{0, 0, 0};
        if (c0326m.f1434f.equals(context.getString(2131231058))) {
            this.f2128d.setVisibility(4);
            this.f2129e.setVisibility(0);
        } else {
            this.f2128d.setVisibility(0);
            this.f2129e.setVisibility(4);
            this.f2128d.setText(c0326m.f1434f);
        }
        ((C0329p) c0326m.f1432d.get(0)).m1708a(this.f2130f[0]);
        this.f2131g[0] = ((C0329p) c0326m.f1432d.get(0)).f1440a;
        switch (c0326m.f1435g) {
            case 1:
                this.f2130f[1].setVisibility(8);
                break;
            case 2:
            case 3:
                if (c0326m.f1432d.size() != 1) {
                    ((C0329p) c0326m.f1432d.get(1)).m1708a(this.f2130f[1]);
                    this.f2131g[1] = ((C0329p) c0326m.f1432d.get(1)).f1440a;
                    break;
                }
                this.f2130f[1].setVisibility(8);
                break;
        }
        if (c0326m.f1431c.size() > 0) {
            this.f2130f[2].setVisibility(0);
            if (c0326m.m1700a()) {
                c0326m.m1701b().m1708a(this.f2130f[2]);
            } else {
                C0313j.m1646a(context.getResources(), this.f2130f[2], 2130837606);
                this.f2130f[2].setTitle(0);
            }
        } else {
            this.f2130f[2].setVisibility(8);
        }
        for (View view : this.f2130f) {
            view.setOnClickListener(c0326m.f1436h);
            C0313j.m1661b(view, (int) (context.getResources().getDisplayMetrics().density * 56.0f));
        }
    }
}
