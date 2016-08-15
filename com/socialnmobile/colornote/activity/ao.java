package com.socialnmobile.colornote.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class ao implements OnCancelListener {
    final /* synthetic */ SendToNoteByTitle f793a;

    ao(SendToNoteByTitle sendToNoteByTitle) {
        this.f793a = sendToNoteByTitle;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.f793a.finish();
    }
}
