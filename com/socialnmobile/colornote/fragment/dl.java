package com.socialnmobile.colornote.fragment;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;

final class dl implements OnClickListener {
    final /* synthetic */ TextEditor f1322a;

    dl(TextEditor textEditor) {
        this.f1322a = textEditor;
    }

    public final void onClick(View view) {
        int selectionStart = this.f1322a.at.getSelectionStart();
        int selectionEnd = this.f1322a.at.getSelectionEnd();
        Editable editableText = this.f1322a.at.getEditableText();
        if (selectionStart <= selectionEnd) {
            int i = selectionEnd;
            selectionEnd = selectionStart;
            selectionStart = i;
        }
        editableText.replace(selectionEnd, selectionStart, this.f1322a.av.getText().toString());
        this.f1322a.at.setSelection(this.f1322a.at.getSelectionEnd());
        this.f1322a.at.requestFocus();
    }
}
