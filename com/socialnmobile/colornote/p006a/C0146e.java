package com.socialnmobile.colornote.p006a;

import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.socialnmobile.colornote.view.C0410a;

/* renamed from: com.socialnmobile.colornote.a.e */
final class C0146e implements Callback {
    final /* synthetic */ C0410a f603a;
    final /* synthetic */ C0145d f604b;

    C0146e(C0145d c0145d, C0410a c0410a) {
        this.f604b = c0145d;
        this.f603a = c0410a;
    }

    public final boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    public final void onDestroyActionMode(ActionMode actionMode) {
    }

    public final boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.f603a.m2155a(actionMode.getMenuInflater(), menu);
    }

    public final boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f603a.m2156a(menuItem);
    }
}
