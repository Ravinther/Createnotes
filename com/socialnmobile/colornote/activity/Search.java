package com.socialnmobile.colornote.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.socialnmobile.colornote.C0311h;

public class Search extends Activity {
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if ("android.intent.action.VIEW".equals(action)) {
            Intent intent = new Intent("android.intent.action.VIEW", getIntent().getData());
            intent.putExtra("EXTRA_VIEW_FROM", "SEARCH");
            try {
                startActivity(intent);
            } catch (Exception e) {
                if (getIntent().getData() != null) {
                    action = getIntent().getData().toString();
                } else {
                    action = "null";
                }
                C0311h.f1370a.m1626b("SEARCH_ACTION_VIEW", e.getClass().getSimpleName(), action);
            }
        } else if ("android.intent.action.SEARCH".equals(action)) {
            Intent intent2 = new Intent(this, Main.class);
            intent2.setAction("android.intent.action.SEARCH");
            intent2.setFlags(603979776);
            intent2.putExtra("query", getIntent().getStringExtra("query"));
            startActivity(intent2);
        }
        finish();
    }
}
