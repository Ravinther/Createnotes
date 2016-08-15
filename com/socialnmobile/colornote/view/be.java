package com.socialnmobile.colornote.view;

import android.view.View;
import android.view.View.OnClickListener;

final class be implements OnClickListener {
    final /* synthetic */ NotesOptions f2097a;

    be(NotesOptions notesOptions) {
        this.f2097a = notesOptions;
    }

    public final void onClick(View view) {
        if (view.getId() == 2131624122) {
            this.f2097a.f1973c.setCurrentItem(0, true);
        } else if (view.getId() == 2131624123) {
            this.f2097a.f1973c.setCurrentItem(1, true);
        }
    }
}
