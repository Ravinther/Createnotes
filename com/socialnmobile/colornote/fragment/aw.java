package com.socialnmobile.colornote.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.socialnmobile.colornote.data.C0220j;

final class aw implements OnClickListener {
    final /* synthetic */ ListEditor f1237a;

    aw(ListEditor listEditor) {
        this.f1237a = listEditor;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue > 0) {
            this.f1237a.ap.add(intValue - 1, (C0220j) this.f1237a.ap.remove(intValue));
            this.f1237a.ab();
        }
    }
}
