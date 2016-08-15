package com.socialnmobile.colornote.activity;

import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.widget.ListView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.menu.C0330r;
import com.socialnmobile.colornote.sync.df;
import com.socialnmobile.colornote.view.az;

public class Today extends ThemeActivity {
    Cursor f769a;
    boolean f770b;
    boolean f771d;
    Dialog f772e;
    Dialog f773f;
    df f774g;
    OnClickListener f775h;
    OnCancelListener f776i;
    OnCancelListener f777j;

    public Today() {
        this.f770b = false;
        this.f771d = false;
        this.f775h = new bb(this);
        this.f776i = new bc(this);
        this.f777j = new bd(this);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m753a();
    }

    protected void onDestroy() {
        if (this.f774g != null) {
            unbindService(this.f774g);
        }
        super.onDestroy();
    }

    protected void onResume() {
        super.onResume();
        this.f769a = C0229s.m1036a((Context) this, System.currentTimeMillis());
        m804a(1);
    }

    protected void onPause() {
        if (!(this.f769a == null || this.f769a.isClosed())) {
            this.f769a.close();
            this.f769a = null;
        }
        super.onPause();
    }

    protected void onStop() {
        if (this.f771d) {
            if (this.f773f != null) {
                this.f773f.dismiss();
                this.f773f = null;
            }
            this.f771d = false;
        }
        if (this.f770b) {
            if (this.f772e != null) {
                this.f772e.dismiss();
                this.f772e = null;
            }
            this.f770b = false;
        }
        super.onStop();
    }

    final void m804a(int i) {
        Dialog dialog = null;
        switch (i) {
            case 1:
                Builder builder = new Builder(this);
                builder.setTitle(2131231010);
                builder.setAdapter(az.m2182a(this, this.f769a, 4), this.f775h);
                builder.setOnCancelListener(this.f776i);
                builder.setNeutralButton(2131230723, new be(this));
                dialog = builder.create();
                ListView listView = dialog.getListView();
                listView.setBackgroundColor(C0209d.m875a(this).m1145n(3));
                listView.setDivider(getResources().getDrawable(2130837553));
                int dimensionPixelSize = getResources().getDimensionPixelSize(2131361798);
                listView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
                listView.setSelector(2130837654);
                listView.setDrawSelectorOnTop(true);
                dialog.setCanceledOnTouchOutside(true);
                this.f770b = true;
                dialog.setTitle(DateUtils.formatDateTime(this, System.currentTimeMillis(), 32786));
                this.f772e = dialog;
                break;
            case 2:
                dialog = C0330r.m1710a(this, new bf(this), null).m1679a(this);
                dialog.setOnCancelListener(this.f777j);
                this.f771d = true;
                this.f773f = dialog;
                break;
        }
        dialog.show();
    }
}
