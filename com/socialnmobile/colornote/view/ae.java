package com.socialnmobile.colornote.view;

import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.Toast;
import com.socialnmobile.colornote.C0313j;

final class ae implements OnLongClickListener {
    final /* synthetic */ MyImageButton f2022a;

    ae(MyImageButton myImageButton) {
        this.f2022a = myImageButton;
    }

    public final boolean onLongClick(View view) {
        MyImageButton myImageButton = this.f2022a;
        Toast makeText = Toast.makeText(myImageButton.getContext(), myImageButton.f1923b, 0);
        makeText.setGravity(51, myImageButton.getLeft() - C0313j.m1664c(myImageButton.getContext(), 120), myImageButton.getBottom());
        makeText.show();
        return true;
    }
}
