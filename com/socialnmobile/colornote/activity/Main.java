package com.socialnmobile.colornote.activity;

import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.v4.app.C0015f;
import android.support.v4.app.C0017z;
import android.support.v4.app.C0032q;
import android.support.v4.app.DialogFragment;
import android.support.v4.widget.DrawerLayout;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.socialnmobile.colornote.C0272f;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.data.C0210a;
import com.socialnmobile.colornote.data.C0212b;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.dialog.C0259x;
import com.socialnmobile.colornote.dialog.C0260y;
import com.socialnmobile.colornote.dialog.C0261z;
import com.socialnmobile.colornote.dialog.DialogFactory;
import com.socialnmobile.colornote.fragment.ArchiveFragment;
import com.socialnmobile.colornote.fragment.RecycleBinFragment;
import com.socialnmobile.colornote.fragment.SearchFragment;
import com.socialnmobile.colornote.fragment.SideMenuFragment;
import com.socialnmobile.colornote.fragment.cp;
import com.socialnmobile.colornote.fragment.cw;
import com.socialnmobile.colornote.menu.C0152l;
import com.socialnmobile.colornote.menu.C0273k;
import com.socialnmobile.colornote.menu.C0326m;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo;
import com.socialnmobile.colornote.menu.TopBarSubMenuInfo.SubMenuDialogFragment;
import com.socialnmobile.colornote.p007e.C0162f;
import com.socialnmobile.colornote.service.AutoSyncService;
import com.socialnmobile.colornote.sync.C0367b;
import com.socialnmobile.colornote.sync.SyncService;
import com.socialnmobile.colornote.sync.df;
import com.socialnmobile.colornote.sync.errors.AuthRequired;
import com.socialnmobile.colornote.sync.errors.UnsupportedClientVersion;
import com.socialnmobile.colornote.sync.jobs.SyncJob.Listener;
import com.socialnmobile.colornote.view.MyViewPager;
import com.socialnmobile.colornote.view.ac;
import com.socialnmobile.colornote.view.ad;
import com.socialnmobile.colornote.view.ao;
import com.socialnmobile.colornote.view.bv;
import com.socialnmobile.util.service.C0477d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main extends ThemeFragmentActivity implements C0032q, cw, C0152l, ad, ao {
    boolean f643A;
    boolean f644B;
    df f645C;
    OnClickListener f646D;
    Runnable f647E;
    C0162f f648F;
    protected Handler f649n;
    boolean f650o;
    View f651p;
    C0015f f652q;
    MyViewPager f653r;
    ImageView f654s;
    DrawerLayout f655t;
    View f656u;
    bv f657v;
    boolean f658w;
    boolean f659x;
    boolean f660y;
    SideMenuFragment f661z;

    class SyncListener implements ServiceConnection, Listener {
        WeakReference mActivityReference;
        Context mContext;
        boolean mShowMessage;

        SyncListener(Main main, boolean z) {
            this.mActivityReference = new WeakReference(main);
            this.mContext = main.getApplicationContext();
            this.mShowMessage = z;
        }

        void showErrorMessage(Main main) {
            main.findViewById(2131623946).setVisibility(8);
            main.findViewById(2131623947).setVisibility(0);
            ((TextView) main.findViewById(2131623948)).setText(C0272f.m1208a(main));
            main.m711a(5000);
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ((SyncService) ((C0477d) iBinder).f2282a).m1746a(this);
            new Handler().post(new C0190z(this));
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }

        public void onInit() {
            C0313j.m1645a(this.mContext);
            Main main = (Main) this.mActivityReference.get();
            if (main != null) {
                main.f650o = true;
                if (this.mShowMessage) {
                    main.m722e();
                    main.findViewById(2131623947).setVisibility(8);
                    main.findViewById(2131623946).setVisibility(0);
                    ((TextView) main.findViewById(2131623948)).setText(2131230877);
                }
            }
        }

        public void onFinalize() {
            C0313j.m1659b();
            Main main = (Main) this.mActivityReference.get();
            if (main != null) {
                main.f650o = false;
            }
        }

        public void onException(Exception exception) {
            Main main = (Main) this.mActivityReference.get();
            if (main != null && this.mShowMessage) {
                showErrorMessage(main);
            }
        }

        public void onError(AuthRequired authRequired) {
            Main main = (Main) this.mActivityReference.get();
            if (main != null) {
                Intent intent = new Intent(this.mContext, SyncRelogin.class);
                intent.putExtra("FROM", "Main");
                main.startActivityForResult(intent, 1);
                if (this.mShowMessage) {
                    main.f651p.setVisibility(8);
                }
            }
        }

        public void onError(UnsupportedClientVersion unsupportedClientVersion) {
            Main main = (Main) this.mActivityReference.get();
            if (main != null) {
                if (this.mShowMessage) {
                    showErrorMessage(main);
                }
                main.m705d(20);
            }
        }

        public void onProgress(int i, int i2) {
        }

        public void onFinished(Object obj) {
            Context context = (Main) this.mActivityReference.get();
            if (context != null && this.mShowMessage) {
                context.findViewById(2131623946).setVisibility(8);
                TextView textView = (TextView) context.findViewById(2131623948);
                DateUtils.formatDateTime(context, C0212b.m935a(context, "LAST_SYNC_TIME_MILLIS"), 524313);
                textView.setText(context.getString(2131230875));
                context.m711a(2500);
            }
        }
    }

    public Main() {
        this.f649n = new Handler();
        this.f650o = false;
        this.f658w = false;
        this.f659x = false;
        this.f643A = false;
        this.f644B = false;
        this.f646D = new C0181q(this);
        this.f647E = new C0182r(this);
        this.f648F = new C0183s(this);
    }

    static /* synthetic */ void m701a(Main main) {
        if (!C0367b.m1868a((Context) main)) {
            return;
        }
        if (C0212b.m955o(main)) {
            main.m714a(false, true, "LAUNCH");
            return;
        }
        C0367b.m1870b(main);
        if (C0212b.m954n(main)) {
            main.m714a(false, false, "LAUNCH_ERROR");
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903043);
        this.f651p = findViewById(2131623945);
        this.f653r = (MyViewPager) findViewById(2131623942);
        this.f654s = (ImageView) findViewById(2131624083);
        this.f655t = (DrawerLayout) findViewById(2131623940);
        this.f655t.setDrawerShadow(2130837558, 3);
        this.f656u = findViewById(2131623943);
        this.f657v = new bv(findViewById(2131623936));
        LayoutParams layoutParams = this.f656u.getLayoutParams();
        layoutParams.width = Math.min(getResources().getDisplayMetrics().widthPixels - C0313j.m1664c(this, 56), C0313j.m1664c(this, 304));
        this.f656u.setLayoutParams(layoutParams);
        if (C0210a.m894a((Context) this, "PREF_TITLE_NOTI_NUMBER") <= 0) {
            this.f657v.f2127c.setText("N");
        }
        CharSequence c = C0210a.m901c(this, "LOGO_EXTRA_TEXT");
        if (!TextUtils.isEmpty(c)) {
            ((TextView) findViewById(2131624086)).setText(c);
        }
        this.f657v.f2132h = this.f646D;
        m682a(1, this.f648F);
        setDefaultKeyMode(2);
        ColorNote.m652b();
        this.f97b.m160a((C0032q) this);
        this.f661z = (SideMenuFragment) this.f97b.m154a(2131623944);
        if (this.f661z == null) {
            this.f661z = new SideMenuFragment();
            C0017z a = this.f97b.m158a();
            a.m132b(2131623944, this.f661z);
            a.m126a(0);
            a.m131b();
        }
        this.f652q = this.f97b.m154a(2131623937);
        if (this.f652q != null) {
            m706h();
        }
        Intent intent = getIntent();
        if (intent.getData() == null) {
            intent.setData(C0228r.f997a);
        }
        this.f653r.setAdapter(new C0188x(this, this.f97b, this));
        this.f653r.setPageMargin(getResources().getDimensionPixelSize(2131361813));
        this.f653r.setOnPageChangeListener(this);
        if (C0212b.m947g(this) == 1) {
            this.f653r.setCurrentItem(1, false);
        } else {
            this.f653r.setCurrentItem(0, false);
        }
        m712a(intent);
        if (m702b(intent) != -1) {
            this.f644B = true;
        }
        this.f649n.postDelayed(new C0178n(this), 50);
    }

    protected void onStart() {
        boolean z = true;
        super.onStart();
        if (!this.f658w) {
            boolean z2;
            this.f658w = true;
            if (C0210a.m899b(this, "APP_INSTALL_TIME_MILLIS") == 0) {
                C0210a.m898a((Context) this, "APP_INSTALL_TIME_MILLIS", System.currentTimeMillis());
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                Map hashMap = new HashMap();
                hashMap.put("From", "MARKET");
                ColorNote.m649a(getApplicationContext(), "INSTALL", "FIRST_LAUNCH", hashMap);
            }
            long j = PreferenceManager.getDefaultSharedPreferences(this).getLong("RATING_TIME", 0);
            if (j > System.currentTimeMillis() || j == 1) {
                z = false;
            }
            if (z) {
                new C0189y().execute(new String[0]);
            }
        }
    }

    protected void onDestroy() {
        if (this.f645C != null) {
            unbindService(this.f645C);
        }
        if (C0367b.m1868a((Context) this)) {
            if (!C0212b.m955o(this)) {
                C0367b.m1870b(this);
            } else if (C0367b.m1873d(this)) {
                AutoSyncService.m1736b(getApplicationContext());
            }
        }
        super.onDestroy();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0015f c = m719c();
        if (c != null) {
            C0273k L = ((cp) c).m1277L();
            L.m1211a((Context) this);
            m713a(L.m1210M());
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (!"android.intent.action.MAIN".equals(intent.getAction())) {
            this.f649n.post(new C0180p(this, intent));
        }
    }

    protected void onResume() {
        super.onResume();
        this.f660y = true;
    }

    protected void onPause() {
        super.onPause();
        this.f660y = false;
        if (isFinishing()) {
            ColorNote.m646a(getApplicationContext(), "APP", "MAIN_FINISH");
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            m714a(false, true, "AUTH");
        }
    }

    public final void m710a(int i) {
        switch (i) {
            case 1:
                m721d();
                this.f653r.setCurrentItem(0, false);
                m723f();
            case 2:
                m721d();
                this.f653r.setCurrentItem(1, false);
                m723f();
            case 3:
                m721d();
                m704c(new RecycleBinFragment());
                m723f();
            case 4:
                m721d();
                m704c(new ArchiveFragment());
                m723f();
            case 5:
                onSearchRequested();
                m723f();
            case 11:
                m705d(1);
            case 12:
                startActivity(new Intent(this, Settings.class));
            case 13:
                startActivity(C0313j.m1671e((Context) this));
            default:
        }
    }

    private void m706h() {
        C0313j.m1646a(getResources(), this.f654s, 2130837615);
    }

    private C0015f m707i() {
        return ((ac) this.f653r.getAdapter()).f850c;
    }

    public final boolean m715a(C0015f c0015f) {
        if (this.f652q == null) {
            if (m707i() == c0015f) {
                return true;
            }
            return false;
        } else if (this.f652q != c0015f) {
            return false;
        } else {
            return true;
        }
    }

    public final bv m716b() {
        return this.f657v;
    }

    public final C0015f m719c() {
        if (this.f652q != null) {
            return this.f652q;
        }
        return m707i();
    }

    public boolean onSearchRequested() {
        ColorNote.m646a(this, "LIST", "SEARCH");
        return super.onSearchRequested();
    }

    private void m704c(C0015f c0015f) {
        C0015f i = m707i();
        if (i != null) {
            i.m63b(false);
        }
        C0017z a = this.f97b.m158a();
        a.m128a(2131623937, c0015f, "sub");
        a.m126a(4099);
        a.m125a();
        a.m133c();
        this.f652q = c0015f;
        m706h();
        this.f97b.m162b();
    }

    public final void m717b(int i) {
        if (i == 2) {
            closeOptionsMenu();
        }
    }

    public final void m720c(int i) {
        if (this.f644B && i != m702b(getIntent())) {
            this.f644B = false;
        }
        C0015f i2 = m707i();
        if (!(i2 == null || ((ac) this.f653r.getAdapter()).f849b.indexOf(i2) == i)) {
            i2.m63b(false);
        }
        this.f653r.getAdapter();
        ArrayList arrayList = ((ac) this.f653r.getAdapter()).f849b;
        if (i < arrayList.size()) {
            C0015f c0015f = (C0015f) arrayList.get(i);
            if (c0015f instanceof cp) {
                cp cpVar = (cp) c0015f;
                cpVar.m1279v();
                if (this.f652q == null) {
                    cpVar.m1280w();
                }
            }
        }
    }

    public final void m718b(C0015f c0015f) {
        if (c0015f instanceof cp) {
            this.f653r.getAdapter();
            cp cpVar = (cp) c0015f;
            cpVar.m1279v();
            this.f661z.m1524t();
            if (this.f652q == null) {
                cpVar.m1280w();
            }
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (m708j()) {
                this.f643A = true;
                return true;
            } else if (this.f652q == null) {
                if (((cp) m707i()).m1281x() || !(this.f653r.getCurrentItem() == C0212b.m947g(this) || this.f644B)) {
                    this.f643A = true;
                    return true;
                } else if (this.f659x) {
                    this.f643A = true;
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f643A) {
            this.f643A = false;
            if (m708j()) {
                this.f655t.m370a(false);
            } else if (this.f652q == null) {
                cp cpVar = (cp) m707i();
                if (cpVar.m1281x()) {
                    cpVar.m1282y();
                } else if (this.f653r.getCurrentItem() != C0212b.m947g(this)) {
                    if (C0212b.m947g(this) == 1) {
                        this.f653r.setCurrentItem(1, true);
                    } else {
                        this.f653r.setCurrentItem(0, true);
                    }
                } else if (this.f659x) {
                    boolean z;
                    this.f659x = false;
                    if (getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + getPackageName())), 65536).size() > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
                        if (defaultSharedPreferences.contains("RATING_INSTALL_TIME")) {
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - defaultSharedPreferences.getLong("RATING_INSTALL_TIME", currentTimeMillis) < 691200000) {
                                z = false;
                            } else {
                                long j = defaultSharedPreferences.getLong("RATING_TIME", 0);
                                if (j > currentTimeMillis || j == 1) {
                                    z = false;
                                } else {
                                    Builder builder = new Builder(this);
                                    builder.setTitle(2131230946);
                                    builder.setMessage(2131230944);
                                    builder.setPositiveButton(2131230947, new C0259x(this, defaultSharedPreferences));
                                    builder.setNegativeButton(2131230945, new C0260y(this, defaultSharedPreferences));
                                    builder.setOnCancelListener(new C0261z(this, defaultSharedPreferences));
                                    builder.create().show();
                                    z = true;
                                }
                            }
                        } else {
                            Editor edit = defaultSharedPreferences.edit();
                            edit.putLong("RATING_INSTALL_TIME", System.currentTimeMillis());
                            edit.commit();
                            z = false;
                        }
                    } else {
                        z = false;
                    }
                    if (!z) {
                        finish();
                    }
                }
            }
        }
        return super.onKeyUp(i, keyEvent);
    }

    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
        }
    }

    private static int m702b(Intent intent) {
        if (intent.getAction() != null) {
            if (intent.getAction().equals("note.socialnmobile.intent.action.VIEW_CALENDAR") || intent.getAction().equals("note.socialnmobile.intent.action.VIEW_TODAY_CALENDAR")) {
                return 1;
            }
            if (intent.getAction().equals("note.socialnmobile.intent.action.VIEW_NOTES")) {
                return 0;
            }
            if (intent.getAction().equals("note.socialnmobile.intent.action.LAUNCH_APP")) {
                return 0;
            }
        }
        return -1;
    }

    final void m712a(Intent intent) {
        if (intent.getAction() != null) {
            if (intent.getAction().equals("note.socialnmobile.intent.action.SEARCH")) {
                onSearchRequested();
            } else if (intent.getAction().equals("android.intent.action.SEARCH")) {
                m704c(SearchFragment.m1501a(intent.getStringExtra("query")));
            } else {
                int b = m702b(intent);
                if (b == -1) {
                    return;
                }
                if (b == 0) {
                    if (this.f653r.getCurrentItem() != 0) {
                        this.f653r.setCurrentItem(0, false);
                    }
                } else if (b == 1 && this.f653r.getCurrentItem() != 1) {
                    this.f653r.setCurrentItem(1, false);
                }
            }
        }
    }

    final void m722e() {
        this.f649n.removeCallbacks(this.f647E);
        this.f651p.setVisibility(0);
        this.f651p.startAnimation(AnimationUtils.loadAnimation(getApplication(), 17432576));
    }

    final void m711a(long j) {
        this.f649n.postDelayed(this.f647E, j);
    }

    public final void m714a(boolean z, boolean z2, String str) {
        if (!this.f650o) {
            if (z) {
                ColorNote.m648a(getApplicationContext(), "SYNC", "MANUAL_SYNC", "Source", "Main", "FROM", str);
            }
            if (!bindService(new Intent(this, SyncService.class), new SyncListener(this, z2), 1)) {
                ColorNote.m651a("NoteList bind SyncService FAILED");
            }
        }
    }

    public final void m713a(C0326m c0326m) {
        this.f657v.m2210a(c0326m);
    }

    private void m705d(int i) {
        DialogFragment dialogFragment = null;
        switch (i) {
            case 1:
                TopBarSubMenuInfo topBarSubMenuInfo = new TopBarSubMenuInfo(this, getString(2131231003), new C0185u(this));
                topBarSubMenuInfo.m1681a(2130837634, 2131231005, "COLORTABLE/DEFAULT");
                topBarSubMenuInfo.m1681a(2130837635, 2131231006, "COLORTABLE/SOFT");
                topBarSubMenuInfo.m1681a(2130837633, 2131231004, "COLORTABLE/DARK");
                dialogFragment = new SubMenuDialogFragment(topBarSubMenuInfo);
                break;
            case 20:
                dialogFragment = DialogFactory.m1116a(new C0184t(this));
                break;
        }
        dialogFragment.m85a(this.f97b, "dialog");
    }

    private boolean m708j() {
        return this.f656u.getVisibility() == 0;
    }

    public final void m723f() {
        this.f655t.m370a(false);
    }

    public final void m724g() {
        if (C0313j.m1670d((Context) this)) {
            ColorNote.m647a(getApplicationContext(), "INSTALL", "UPDATE_AVAILABLE", "METHOD", "BANNER");
            View findViewById = findViewById(2131623949);
            View findViewById2 = findViewById(2131623951);
            Animation loadAnimation = AnimationUtils.loadAnimation(this, 2130968580);
            loadAnimation.setDuration(1000);
            loadAnimation.setAnimationListener(new C0186v(this, findViewById));
            findViewById.setVisibility(0);
            findViewById2.setOnClickListener(new C0187w(this, findViewById, loadAnimation));
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this, 2130968581);
            loadAnimation2.setDuration(1000);
            findViewById.startAnimation(loadAnimation2);
            OnClickListener c0179o = new C0179o(this, findViewById, loadAnimation);
            findViewById.setOnClickListener(c0179o);
            findViewById(2131623950).setOnClickListener(c0179o);
            return;
        }
        ColorNote.m646a(getApplicationContext(), "INSTALL", "UPDATE_NOT_AVAILABLE");
    }

    public final void m709a() {
        if (this.f97b.m164d() == 0) {
            this.f652q = null;
            m706h();
            C0015f i = m707i();
            i.m63b(true);
            if (i instanceof cp) {
                ((cp) i).m1280w();
            }
        }
        this.f661z.m1524t();
    }

    final void m721d() {
        if (this.f97b.m164d() > 0) {
            try {
                this.f97b.m163c();
            } catch (IllegalStateException e) {
            }
        }
    }
}
