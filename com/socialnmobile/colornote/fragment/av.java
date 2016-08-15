package com.socialnmobile.colornote.fragment;

import android.view.View;
import android.view.View.OnClickListener;

final class av implements OnClickListener {
    final /* synthetic */ ListEditor f1236a;

    av(ListEditor listEditor) {
        this.f1236a = listEditor;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue < this.f1236a.ap.size()) {
            this.f1236a.ap.remove(intValue);
            this.f1236a.ab();
        }
    }
}
