package com.socialnmobile.colornote.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.data.C0213c;

/* renamed from: com.socialnmobile.colornote.dialog.d */
public final class C0240d extends Dialog {
    public C0242f f1067a;
    int f1068b;
    public int f1069c;
    private OnClickListener f1070d;

    public C0240d(Context context, int i, int i2) {
        super(context, 2131427352);
        this.f1070d = new C0241e(this);
        this.f1068b = i;
        this.f1069c = i2;
        setContentView(2130903053);
        setCanceledOnTouchOutside(true);
        m1128a();
    }

    public final void m1128a() {
        m1127a(2131624009, 2131624010, this.f1070d, 1, C0213c.m959a(getContext(), this.f1068b, 1));
        m1127a(2131624011, 2131624012, this.f1070d, 2, C0213c.m959a(getContext(), this.f1068b, 2));
        m1127a(2131624013, 2131624014, this.f1070d, 3, C0213c.m959a(getContext(), this.f1068b, 3));
        m1127a(2131624015, 2131624016, this.f1070d, 4, C0213c.m959a(getContext(), this.f1068b, 4));
        m1127a(2131624017, 2131624018, this.f1070d, 5, C0213c.m959a(getContext(), this.f1068b, 5));
        m1127a(2131624019, 2131624020, this.f1070d, 6, C0213c.m959a(getContext(), this.f1068b, 6));
        m1127a(2131624021, 2131624022, this.f1070d, 7, C0213c.m959a(getContext(), this.f1068b, 7));
        m1127a(2131624023, 2131624024, this.f1070d, 8, C0213c.m959a(getContext(), this.f1068b, 8));
        m1127a(2131624025, 2131624026, this.f1070d, 9, C0213c.m959a(getContext(), this.f1068b, 9));
    }

    private void m1127a(int i, int i2, OnClickListener onClickListener, int i3, String str) {
        ImageButton imageButton = (ImageButton) findViewById(i);
        imageButton.setOnClickListener(onClickListener);
        GradientDrawable gradientDrawable = (GradientDrawable) getContext().getResources().getDrawable(2130837527);
        gradientDrawable.setColor(C0209d.m875a(getContext()).m1136e(i3));
        imageButton.setImageDrawable(gradientDrawable);
        TextView textView = (TextView) findViewById(i2);
        textView.setTextColor(C0209d.m875a(getContext()).m1143l(i3));
        textView.setText(str);
        if (i3 == this.f1069c) {
            imageButton.setSelected(true);
        } else {
            imageButton.setSelected(false);
        }
    }
}
