package com.socialnmobile.colornote.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/* renamed from: com.socialnmobile.colornote.dialog.i */
public final class C0245i extends Dialog {
    Button f1075a;
    EditText f1076b;
    TextView f1077c;
    C0170m f1078d;

    public C0245i(Context context, C0170m c0170m, OnCancelListener onCancelListener, int i) {
        super(context);
        setTitle(2131230793);
        setContentView(2130903055);
        this.f1075a = (Button) findViewById(2131624033);
        this.f1076b = (EditText) findViewById(2131624032);
        this.f1077c = (TextView) findViewById(2131624031);
        if (i != 0) {
            this.f1077c.setText(i);
        } else {
            this.f1077c.setVisibility(8);
        }
        this.f1078d = c0170m;
        if (onCancelListener != null) {
            setOnCancelListener(onCancelListener);
        }
        this.f1075a.setOnClickListener(new C0246j(this));
    }

    protected final void onStart() {
        super.onStart();
        getWindow().setSoftInputMode(4);
        this.f1076b.setText("");
        this.f1076b.post(new C0247k(this));
    }

    protected final void onStop() {
        super.onStop();
        this.f1076b.post(new C0248l(this));
    }

    public final boolean onSearchRequested() {
        return false;
    }
}
