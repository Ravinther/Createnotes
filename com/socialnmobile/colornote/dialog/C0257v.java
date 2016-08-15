package com.socialnmobile.colornote.dialog;

import android.app.Dialog;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import com.socialnmobile.colornote.view.NotesOptions;

/* renamed from: com.socialnmobile.colornote.dialog.v */
public final class C0257v extends Dialog {
    NoteListFragment f1088a;
    NotesOptions f1089b;

    public C0257v(NoteListFragment noteListFragment, int i) {
        super(noteListFragment.f48C, i);
        setContentView(2130903058);
        this.f1088a = noteListFragment;
        setCanceledOnTouchOutside(true);
        this.f1089b = (NotesOptions) findViewById(2131624034);
        this.f1089b.m2125a(noteListFragment, this);
    }
}
