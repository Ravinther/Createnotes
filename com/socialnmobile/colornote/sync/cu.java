package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.util.p011b.p021a.C0454c;
import com.socialnmobile.util.p011b.p021a.C0456e;
import com.socialnmobile.util.p011b.p021a.C0458g;

public interface cu extends NoteMajorColumns {
    public static final C0458g f1648a;
    public static final C0458g f1649b;
    public static final C0454c f1650c;
    public static final C0456e f1651d;

    static {
        f1648a = new C0458g(NoteMajorColumns.TITLE);
        f1649b = new C0458g(NoteMajorColumns.NOTE);
        f1650c = new C0454c(NoteMajorColumns.ENCRYPTION);
        f1651d = new C0456e(NoteMajorColumns.MODIFIED_DATE);
    }
}
