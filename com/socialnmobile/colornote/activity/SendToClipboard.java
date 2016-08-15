package com.socialnmobile.colornote.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.widget.Toast;

public class SendToClipboard extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        intent.getStringExtra("android.intent.extra.SUBJECT");
        ((ClipboardManager) getSystemService("clipboard")).setText(intent.getStringExtra("android.intent.extra.TEXT"));
        Toast.makeText(this, 2131231002, 1).show();
        finish();
    }
}
