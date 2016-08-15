package com.socialnmobile.colornote.fragment;

import android.content.ContentUris;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.socialnmobile.colornote.C0310g;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.activity.PasswordSetting;
import com.socialnmobile.colornote.activity.ReminderSettings;
import com.socialnmobile.colornote.data.C0213c;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;

final class bn implements OnMenuItemClickListener {
    final /* synthetic */ NoteListFragment f1263a;

    bn(NoteListFragment noteListFragment) {
        this.f1263a = noteListFragment;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        try {
            menuItem.getMenuInfo();
            this.f1263a.ad = ContentUris.withAppendedId(this.f1263a.m1321z(), this.f1263a.ac.f1002a);
            switch (menuItem.getItemId()) {
                case 1:
                    this.f1263a.m1318e(1004);
                    return true;
                case 1002:
                    this.f1263a.m1318e(1005);
                    return true;
                case 1004:
                    C0229s.m1043a(this.f1263a.f48C, this.f1263a.ad, this.f1263a.ac.f1005d, 16, 16);
                    if (!C0310g.m1616a(this.f1263a.ac)) {
                        return true;
                    }
                    this.f1263a.m1318e(1018);
                    return true;
                case 1005:
                    C0229s.m1043a(this.f1263a.f48C, this.f1263a.ad, this.f1263a.ac.f1005d, 0, 16);
                    return true;
                case 1006:
                    this.f1263a.m1318e(1009);
                    return true;
                case 1007:
                    this.f1263a.m1318e(1010);
                    return true;
                case 1008:
                    this.f1263a.m1318e(1011);
                    return true;
                case 1009:
                    this.f1263a.m1318e(1012);
                    return true;
                case 1010:
                    if (C0213c.m961a(this.f1263a.f48C)) {
                        this.f1263a.m1318e(1013);
                        return true;
                    }
                    this.f1263a.m55a(new Intent(this.f1263a.f48C, PasswordSetting.class), 1001);
                    return true;
                case 1011:
                    if (C0213c.m961a(this.f1263a.f48C)) {
                        this.f1263a.m1318e(1014);
                        return true;
                    }
                    this.f1263a.m55a(new Intent(this.f1263a.f48C, PasswordSetting.class), 1001);
                    return true;
                case 1012:
                    Intent intent = new Intent(this.f1263a.f48C, ReminderSettings.class);
                    intent.putExtra("_id", this.f1263a.ac.f1002a);
                    intent.putExtra(NoteMinorColumns.FOLDER, this.f1263a.ac.f1003b);
                    intent.putExtra(NoteMinorColumns.REMINDER_TYPE, this.f1263a.ac.f1014m);
                    intent.putExtra(NoteMinorColumns.REMINDER_REPEAT, this.f1263a.ac.f1015n);
                    intent.putExtra(NoteMinorColumns.REMINDER_BASE, this.f1263a.ac.m1064f());
                    intent.putExtra(NoteMinorColumns.REMINDER_DATE, this.f1263a.ac.m1065g());
                    intent.putExtra(NoteMinorColumns.REMINDER_REPEAT_END, this.f1263a.ac.m1067i());
                    this.f1263a.m54a(intent);
                    return true;
                case 1013:
                    if (this.f1263a.ac.m1065g() != 0) {
                        this.f1263a.m1318e(1017);
                        return true;
                    }
                    this.f1263a.m1318e(1016);
                    return true;
                case 1014:
                    this.f1263a.m1301K();
                    return true;
                case 1015:
                    if (C0229s.m1054f(this.f1263a.f48C, this.f1263a.ad)) {
                        Toast.makeText(this.f1263a.f48C, 2131230787, 0).show();
                        return true;
                    }
                    Toast.makeText(this.f1263a.f48C, 2131230794, 0).show();
                    return true;
                default:
                    return false;
            }
        } catch (ClassCastException e) {
            ColorNote.m651a("bad menuInfo");
            return false;
        }
    }
}
