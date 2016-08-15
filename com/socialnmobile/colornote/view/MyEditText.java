package com.socialnmobile.colornote.view;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.EditText;
import com.socialnmobile.colornote.p006a.C0142a;

public class MyEditText extends EditText {
    private int f1855a;

    public MyEditText(Context context, AttributeSet attributeSet) {
        int i = 0;
        super(context, attributeSet);
        this.f1855a = 0;
        if (VERSION.SDK_INT >= 14 && Build.BRAND.toLowerCase().equals("samsung")) {
            i = 1;
        }
        if (i != 0) {
            C0410a agVar = new ag();
            agVar.f2024b = this;
            C0142a.m656a(this, agVar);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(true, i, i2, i3, i4);
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (getLayout() != null) {
            int lineCount = getLayout().getLineCount();
            if (this.f1855a != lineCount) {
                requestLayout();
                this.f1855a = lineCount;
            }
        }
    }
}
