package com.socialnmobile.colornote.data;

import android.provider.BaseColumns;
import com.socialnmobile.colornote.sync.SyncIndexColumns;
import com.socialnmobile.colornote.sync.SyncStateColumns;
import com.socialnmobile.util.p011b.C0449a;
import com.socialnmobile.util.p011b.p021a.C0450a;
import com.socialnmobile.util.p011b.p021a.C0454c;
import com.socialnmobile.util.p011b.p021a.C0456e;
import com.socialnmobile.util.p011b.p021a.C0458g;

public final class NoteColumns {
    public static C0449a[] f909a;
    public static C0449a[] f910b;

    public interface NoteLocalColumns {
        public static final String ACCOUNT_ID = "account_id";
    }

    public interface NoteMajorColumns extends BaseColumns {
        public static final String ENCRYPTION = "encrypted";
        public static final String MODIFIED_DATE = "modified_date";
        public static final String NOTE = "note";
        public static final String TITLE = "title";
    }

    public interface NoteMinorColumns extends BaseColumns {
        public static final String COLOR = "color_index";
        public static final String CREATED_DATE = "created_date";
        public static final String FLAGS = "status";
        public static final String FOLDER = "folder_id";
        public static final String IMPORTANCE = "importance";
        public static final String LATITUDE = "latitude";
        public static final String LONGITUDE = "longitude";
        public static final String MINOR_MODIFIED_DATE = "minor_modified_date";
        public static final String NOTE_EXT = "note_ext";
        public static final String NOTE_VERSION = "note_type";
        public static final String REMINDER_BASE = "reminder_base";
        public static final String REMINDER_DATE = "reminder_date";
        public static final String REMINDER_DURATION = "reminder_duration";
        public static final String REMINDER_LAST = "reminder_last";
        public static final String REMINDER_OPTION = "reminder_option";
        public static final String REMINDER_REPEAT = "reminder_repeat";
        public static final String REMINDER_REPEAT_END = "reminder_repeat_ends";
        public static final String REMINDER_TYPE = "reminder_type";
        public static final String SPACE = "space";
        public static final String STATE = "active_state";
        public static final String TAGS = "tags";
        public static final String TYPE = "type";
    }

    public interface NotesColumns extends NoteMajorColumns, NoteMinorColumns {
    }

    static {
        f909a = new C0449a[]{new C0456e("_id"), new C0458g(NoteMajorColumns.TITLE), new C0458g(NoteMajorColumns.NOTE), new C0454c(NoteMajorColumns.ENCRYPTION), new C0456e(NoteMajorColumns.MODIFIED_DATE), new C0454c(NoteMinorColumns.STATE), new C0454c(NoteMinorColumns.FOLDER), new C0454c(NoteMinorColumns.FLAGS), new C0454c(NoteMinorColumns.SPACE), new C0454c(NoteMinorColumns.TYPE), new C0458g(NoteMinorColumns.NOTE_EXT), new C0454c(NoteMinorColumns.NOTE_VERSION), new C0454c(NoteMinorColumns.COLOR), new C0454c(NoteMinorColumns.IMPORTANCE), new C0456e(NoteMinorColumns.CREATED_DATE), new C0456e(NoteMinorColumns.MINOR_MODIFIED_DATE), new C0454c(NoteMinorColumns.REMINDER_TYPE), new C0454c(NoteMinorColumns.REMINDER_REPEAT), new C0456e(NoteMinorColumns.REMINDER_DATE), new C0456e(NoteMinorColumns.REMINDER_BASE), new C0456e(NoteMinorColumns.REMINDER_LAST), new C0456e(NoteMinorColumns.REMINDER_REPEAT_END), new C0454c(NoteMinorColumns.REMINDER_DURATION), new C0454c(NoteMinorColumns.REMINDER_OPTION), new C0450a(NoteMinorColumns.LATITUDE), new C0450a(NoteMinorColumns.LONGITUDE), new C0458g(NoteMinorColumns.TAGS), new C0456e(NoteLocalColumns.ACCOUNT_ID)};
        f910b = new C0449a[]{new C0454c(SyncStateColumns.DIRTY_STATE), new C0454c(SyncStateColumns.STAGED_STATE), new C0458g(SyncIndexColumns.UUID), new C0454c(SyncIndexColumns.REVISION)};
    }
}
