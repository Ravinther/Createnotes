package com.socialnmobile.colornote.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.socialnmobile.colornote.data.C0220j;

final class ax implements OnClickListener {
    final /* synthetic */ ListEditor f1238a;

    ax(ListEditor listEditor) {
        this.f1238a = listEditor;
    }

    public final void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue < this.f1238a.ap.size() - 1) {
            this.f1238a.ap.add(intValue + 1, (C0220j) this.f1238a.ap.remove(intValue));
            this.f1238a.ab();
        }
    }
}
