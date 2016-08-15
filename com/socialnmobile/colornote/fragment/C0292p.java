package com.socialnmobile.colornote.fragment;

import android.database.DataSetObserver;

/* renamed from: com.socialnmobile.colornote.fragment.p */
final class C0292p extends DataSetObserver {
    final /* synthetic */ AbstractEditorViewer f1338a;

    C0292p(AbstractEditorViewer abstractEditorViewer) {
        this.f1338a = abstractEditorViewer;
    }

    public final void onChanged() {
        super.onChanged();
        this.f1338a.f48C.runOnUiThread(new C0293q(this));
    }
}
