package com.socialnmobile.colornote.view;

import android.view.MenuItem;
import android.widget.TextView;
import com.socialnmobile.colornote.C0313j;

final class ah {
    ah() {
    }

    public static boolean m2161a(TextView textView, MenuItem menuItem) {
        if (menuItem.getItemId() != 2131624178) {
            return false;
        }
        try {
            textView.getContext().startActivity(C0313j.m1673f(textView.getText().subSequence(textView.getSelectionStart(), textView.getSelectionEnd()).toString()));
        } catch (IndexOutOfBoundsException e) {
        }
        return true;
    }
}
