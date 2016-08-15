package com.socialnmobile.colornote.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;

public final class aa extends AlertDialog {
    EditText f1056a;
    af f1057b;
    public String f1058c;
    OnClickListener f1059d;
    OnClickListener f1060e;

    public aa(Context context, af afVar) {
        super(context);
        this.f1058c = "";
        this.f1059d = new ad(this);
        this.f1060e = new ae(this);
        setTitle(2131230960);
        setView(LayoutInflater.from(context).inflate(2130903056, null));
        this.f1057b = afVar;
        setButton(-1, context.getText(17039370), this.f1059d);
        setButton(-2, context.getText(17039360), this.f1060e);
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1056a = (EditText) findViewById(2131624030);
    }

    protected final void onStart() {
        super.onStart();
        getWindow().setSoftInputMode(4);
        this.f1056a.setText(this.f1058c);
        this.f1056a.post(new ab(this));
    }

    protected final void onStop() {
        super.onStop();
        this.f1056a.post(new ac(this));
    }

    public final boolean onSearchRequested() {
        return false;
    }
}
