package com.socialnmobile.colornote.data;

import android.net.Uri;
import com.socialnmobile.colornote.data.NoteColumns.NotesColumns;

/* renamed from: com.socialnmobile.colornote.data.r */
public final class C0228r implements NotesColumns {
    public static final Uri f997a;
    public static final Uri f998b;
    public static final Uri f999c;
    public static final Uri f1000d;
    public static final Uri f1001e;

    static {
        f997a = Uri.parse("content://note.socialnmobile.provider.colornote/notes");
        f998b = Uri.parse("content://note.socialnmobile.provider.colornote/notes/title");
        f999c = Uri.parse("content://note.socialnmobile.provider.colornote/counts");
        f1000d = Uri.parse("content://note.socialnmobile.provider.colornote/tempnotes");
        f1001e = Uri.parse("content://note.socialnmobile.provider.colornote/tempnotes/title");
    }
}
