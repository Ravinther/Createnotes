package com.socialnmobile.colornote.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.socialnmobile.colornote.C0313j;

public class SendAsAttachment extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        C0313j.m1660b(this, intent.getStringExtra("android.intent.extra.SUBJECT"), intent.getStringExtra("android.intent.extra.TEXT"));
        finish();
    }
}
