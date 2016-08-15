package com.socialnmobile.colornote.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.dialog.C0240d;

public class ColorPreference extends DialogPreference {
    C0240d f1829a;
    GradientDrawable f1830b;

    public ColorPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1829a = new C0240d(getContext(), -1, 3);
        setDefaultValue(Integer.valueOf(3));
        this.f1830b = (GradientDrawable) getContext().getResources().getDrawable(2130837530);
        this.f1829a.f1067a = new C0421l(this);
    }

    protected void onBindView(View view) {
        super.onBindView(view);
        ImageView imageView = (ImageView) view.findViewById(2131624091);
        if (imageView != null) {
            imageView.setImageDrawable(this.f1830b);
        }
    }

    protected void onSetInitialValue(boolean z, Object obj) {
        if (z) {
            m2063a(getPersistedInt(3));
        } else {
            m2063a(((Integer) obj).intValue());
        }
    }

    private void m2063a(int i) {
        this.f1830b.setColor(C0209d.m875a(getContext()).m1136e(i));
        this.f1829a.f1069c = i;
        this.f1829a.m1128a();
    }

    public Dialog getDialog() {
        return this.f1829a;
    }

    protected void showDialog(Bundle bundle) {
        this.f1829a.show();
    }
}
