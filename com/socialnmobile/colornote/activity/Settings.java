package com.socialnmobile.colornote.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import com.socialnmobile.colornote.C0310g;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.p006a.C0150i;
import com.socialnmobile.colornote.receiver.C0332a;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.view.MyIntentPreference;
import java.util.UnknownFormatConversionException;

public class Settings extends PreferenceActivity implements OnSharedPreferenceChangeListener {
    protected void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        addPreferencesFromResource(2131034113);
        MyIntentPreference myIntentPreference = (MyIntentPreference) getPreferenceScreen().findPreference("pref_faq");
        myIntentPreference.setIntent(C0313j.m1672e("http://www.colornote.com/help/faq.html"));
        CharSequence charSequence = "";
        try {
            charSequence = getString(2131231016, new Object[]{getPackageManager().getPackageInfo(getPackageName(), 0).versionName});
        } catch (NameNotFoundException e) {
        }
        myIntentPreference.setSummary(charSequence);
        myIntentPreference.f1925a = 2130837524;
        myIntentPreference = (MyIntentPreference) getPreferenceScreen().findPreference("pref_privacy");
        myIntentPreference.setIntent(C0313j.m1672e("http://www.colornote.com/help/privacy.html"));
        myIntentPreference.f1925a = 2130837524;
        myIntentPreference = (MyIntentPreference) getPreferenceScreen().findPreference("pref_trans");
        myIntentPreference.setIntent(C0313j.m1672e("http://www.colornote.com/help/translation.html"));
        myIntentPreference.f1925a = 2130837524;
        myIntentPreference = (MyIntentPreference) getPreferenceScreen().findPreference("pref_facebook");
        myIntentPreference.setIntent(C0313j.m1671e((Context) this));
        myIntentPreference.f1925a = 2130837561;
        if (C0150i.m674b()) {
            findPreference("pref_use_auto_select").setEnabled(false);
        }
        if (!C0150i.m675c()) {
            findPreference("pref_base_style").setEnabled(false);
        }
        if (VERSION.SDK_INT > 10) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            findPreference("pref_gpu_rendering").setEnabled(false);
        }
    }

    protected void onResume() {
        super.onResume();
        m755a("ALL");
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    protected void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        m755a(str);
        if (str.equals("pref_widget_transparency")) {
            C0332a.m1724a(this);
            C0332a.m1733b(this);
        }
    }

    private void m755a(String str) {
        if (str.equals("pref_default_screen") || str.equals("ALL")) {
            m756b("pref_default_screen");
        }
        if (str.equals("pref_default_font_size") || str.equals("ALL")) {
            m756b("pref_default_font_size");
        }
        if (str.equals("pref_default_sort_option") || str.equals("ALL")) {
            m756b("pref_default_sort_option");
        }
        if (str.equals("pref_list_item_height") || str.equals("ALL")) {
            C0212b.m943c(this);
            m756b("pref_list_item_height");
        }
        if (str.equals("pref_sort_order_in_color") || str.equals("ALL")) {
            m756b("pref_sort_order_in_color");
        }
        if (str.equals("pref_widget_transparency") || str.equals("ALL")) {
            m756b("pref_widget_transparency");
        }
        if (str.equals("pref_first_day_of_week") || str.equals("ALL")) {
            m756b("pref_first_day_of_week");
        }
        if (str.equals("pref_show_lunar_date_str") || str.equals("ALL")) {
            m756b("pref_show_lunar_date_str");
        }
        if (str.equals("pref_autolink_phone_type") || str.equals("ALL")) {
            m756b("pref_autolink_phone_type");
        }
        if (str.equals("pref_base_style") || str.equals("ALL")) {
            m756b("pref_base_style");
        }
        if (str.equals("ALL")) {
            CharSequence a;
            Preference findPreference = getPreferenceScreen().findPreference("pref_online_sync");
            Preference findPreference2 = getPreferenceScreen().findPreference("pref_sync_on_launch");
            C0367b c = C0367b.m1871c(this);
            if (c != null) {
                a = SyncStatus.m792a(c);
                findPreference2.setEnabled(true);
            } else {
                a = "";
                findPreference2.setEnabled(false);
            }
            findPreference.setSummary(a);
        }
        if (str.equals("pref_show_all_day_reminder")) {
            C0310g.m1618b(this, System.currentTimeMillis());
        }
    }

    private void m756b(String str) {
        ListPreference listPreference = (ListPreference) getPreferenceScreen().findPreference(str);
        try {
            listPreference.setSummary(listPreference.getEntry());
            listPreference.getSummary();
        } catch (UnknownFormatConversionException e) {
            listPreference.setSummary("%s");
        }
    }
}
