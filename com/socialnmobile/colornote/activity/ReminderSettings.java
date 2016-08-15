package com.socialnmobile.colornote.activity;

import android.app.Activity;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import com.flurry.android.C0115a;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0228r;
import com.socialnmobile.colornote.data.C0229s;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.p006a.C0150i;
import com.socialnmobile.colornote.p013g.C0309g;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ReminderSettings extends Activity {
    View f678A;
    int f679B;
    int f680C;
    long f681D;
    long f682E;
    long f683F;
    long f684G;
    long f685H;
    int f686I;
    Uri f687J;
    boolean f688K;
    boolean f689L;
    OnClickListener f690M;
    OnTimeSetListener f691N;
    OnDateSetListener f692O;
    OnDateSetListener f693P;
    DialogInterface.OnClickListener f694Q;
    DialogInterface.OnClickListener f695R;
    private ArrayList f696S;
    int f697a;
    int f698b;
    Time f699c;
    long f700d;
    Time f701e;
    long f702f;
    boolean f703g;
    boolean f704h;
    boolean f705i;
    boolean f706j;
    ArrayList f707k;
    ArrayList f708l;
    String[] f709m;
    int[] f710n;
    View f711o;
    View f712p;
    View f713q;
    View f714r;
    View f715s;
    Button f716t;
    Button f717u;
    Button f718v;
    Button f719w;
    Spinner f720x;
    Spinner f721y;
    View f722z;

    public ReminderSettings() {
        this.f706j = false;
        this.f688K = true;
        this.f689L = true;
        this.f690M = new ag(this);
        this.f691N = new ah(this);
        this.f692O = new ai(this);
        this.f693P = new aj(this);
        this.f694Q = new ak(this);
        this.f695R = new al(this);
    }

    static /* synthetic */ void m739b(ReminderSettings reminderSettings) {
        reminderSettings.f720x.setSelection(reminderSettings.m751b(0));
        if (reminderSettings.m741b(false)) {
            reminderSettings.f688K = false;
            reminderSettings.setResult(-1);
            reminderSettings.finish();
        }
    }

    static /* synthetic */ void m746e(ReminderSettings reminderSettings) {
        reminderSettings.f688K = false;
        reminderSettings.setResult(0);
        reminderSettings.finish();
    }

    protected void onCreate(Bundle bundle) {
        SpinnerAdapter createFromResource;
        super.onCreate(bundle);
        setContentView(2130903047);
        this.f709m = getResources().getStringArray(2131099653);
        this.f710n = getResources().getIntArray(2131099671);
        this.f711o = findViewById(2131623965);
        this.f712p = findViewById(2131623968);
        this.f713q = findViewById(2131623973);
        this.f714r = findViewById(2131623979);
        this.f715s = findViewById(2131623976);
        this.f716t = (Button) findViewById(2131623971);
        this.f717u = (Button) findViewById(2131623972);
        this.f718v = (Button) findViewById(2131623970);
        this.f719w = (Button) findViewById(2131623978);
        this.f720x = (Spinner) findViewById(2131623967);
        this.f721y = (Spinner) findViewById(2131623975);
        this.f722z = findViewById(2131623962);
        this.f678A = findViewById(2131623964);
        Button button = (Button) findViewById(2131623986);
        Button button2 = (Button) findViewById(2131623988);
        ((Button) findViewById(2131623987)).setText(2131230746);
        if (C0150i.m673a()) {
            button.setText(2131230787);
            button2.setText(2131230742);
        } else {
            button2.setText(2131230787);
            button.setText(2131230742);
        }
        this.f685H = getIntent().getLongExtra("_id", 0);
        this.f686I = getIntent().getIntExtra(NoteMinorColumns.FOLDER, -1);
        this.f679B = getIntent().getIntExtra(NoteMinorColumns.REMINDER_TYPE, 0);
        this.f680C = getIntent().getIntExtra(NoteMinorColumns.REMINDER_REPEAT, 0);
        this.f681D = getIntent().getLongExtra(NoteMinorColumns.REMINDER_BASE, 0);
        this.f682E = getIntent().getLongExtra(NoteMinorColumns.REMINDER_DATE, 0);
        this.f684G = getIntent().getLongExtra(NoteMinorColumns.REMINDER_REPEAT_END, 0);
        if (this.f686I != 16 || this.f679B == 128) {
            this.f689L = false;
            setTitle(2131230950);
        } else {
            this.f689L = true;
            findViewById(2131623987).setVisibility(8);
            setTitle(2131230741);
        }
        if (this.f689L) {
            createFromResource = ArrayAdapter.createFromResource(this, 2131099649, 2130903074);
        } else {
            createFromResource = ArrayAdapter.createFromResource(this, 2131099648, 2130903074);
        }
        createFromResource.setDropDownViewResource(2130903075);
        this.f720x.setAdapter(createFromResource);
        this.f716t.setOnClickListener(this.f690M);
        this.f717u.setOnClickListener(this.f690M);
        this.f718v.setOnClickListener(this.f690M);
        this.f719w.setOnClickListener(this.f690M);
        this.f720x.setOnItemSelectedListener(new ae(this));
        this.f721y.setOnItemSelectedListener(new af(this));
        findViewById(2131623986).setOnClickListener(this.f690M);
        findViewById(2131623987).setOnClickListener(this.f690M);
        findViewById(2131623988).setOnClickListener(this.f690M);
        findViewById(2131623963).setOnClickListener(this.f690M);
        findViewById(2131623981).setOnClickListener(this.f690M);
        findViewById(2131623982).setOnClickListener(this.f690M);
        findViewById(2131623983).setOnClickListener(this.f690M);
        findViewById(2131623984).setOnClickListener(this.f690M);
        findViewById(2131623985).setOnClickListener(this.f690M);
        this.f678A.setOnClickListener(this.f690M);
        this.f709m = getResources().getStringArray(2131099653);
        this.f710n = getResources().getIntArray(2131099671);
        this.f699c = new Time();
        this.f701e = new Time();
        this.f704h = false;
        this.f703g = false;
        this.f705i = false;
        this.f702f = this.f684G;
        m750a(this.f702f);
        if (this.f682E != 0) {
            this.f722z.setVisibility(8);
            this.f683F = this.f682E;
            this.f678A.setVisibility(0);
        } else if (this.f679B != 0) {
            m749a();
        } else {
            this.f722z.setVisibility(8);
        }
        this.f687J = ContentUris.withAppendedId(C0228r.f997a, this.f685H);
        this.f720x.setSelection(m751b(this.f679B));
    }

    protected void onStart() {
        super.onStart();
        C0115a.m512a((Context) this, "7WTGHNWSX5PSDGSHN65D");
    }

    protected void onStop() {
        super.onStop();
        C0115a.m511a(this);
    }

    protected void onPause() {
        if (this.f688K) {
            m741b(false);
        }
        super.onPause();
    }

    final void m749a() {
        this.f722z.setVisibility(0);
        this.f683F = this.f681D;
        this.f720x.setEnabled(false);
        this.f716t.setEnabled(false);
        this.f717u.setEnabled(false);
        this.f718v.setEnabled(false);
        this.f721y.setEnabled(false);
    }

    final int m748a(int i) {
        if (!this.f689L) {
            switch (i) {
                case 0:
                    return 0;
                case 1:
                    return 16;
                case 2:
                    return 32;
                case 3:
                    return 128;
                default:
                    break;
            }
        }
        switch (i) {
            case 0:
                return 16;
            case 1:
                return 32;
        }
        throw new RuntimeException("Not reachable1:" + i + "/" + this.f689L);
    }

    final int m751b(int i) {
        if (!this.f689L) {
            switch (i) {
                case 0:
                    return 0;
                case 16:
                    return 1;
                case 32:
                    return 2;
                case 128:
                    return 3;
                default:
                    break;
            }
        }
        switch (i) {
            case 16:
                return 0;
            case 32:
                return 1;
        }
        throw new RuntimeException("Not reachable2:" + i + "/" + this.f689L);
    }

    private void m736a(boolean z) {
        if (m741b(z)) {
            this.f688K = false;
            setResult(-1);
            finish();
        }
    }

    private boolean m741b(boolean z) {
        Object obj;
        int selectedItemPosition = this.f720x.getSelectedItemPosition();
        int selectedItemPosition2 = this.f721y.getSelectedItemPosition();
        int i = 0;
        long j = this.f700d;
        long j2 = this.f702f;
        if (this.f696S != null) {
            i = ((Integer) this.f696S.get(selectedItemPosition2)).intValue();
        }
        selectedItemPosition = m748a(selectedItemPosition);
        Object obj2;
        switch (selectedItemPosition) {
            case 0:
                j = 0;
                selectedItemPosition2 = 0;
                j2 = 0;
                if (this.f679B == selectedItemPosition) {
                    obj = null;
                    break;
                }
                obj = 1;
                break;
            case 16:
                if (this.f700d != -1) {
                    obj2 = (this.f679B == selectedItemPosition && this.f680C == i && this.f683F == j && this.f684G == j2) ? null : 1;
                    selectedItemPosition2 = i;
                    obj = obj2;
                    break;
                }
                selectedItemPosition2 = 144;
                j = 0;
                j2 = 0;
                if (this.f679B != selectedItemPosition || this.f680C != 144) {
                    obj = 1;
                    break;
                }
                obj = null;
                break;
                break;
            case 32:
                obj2 = (this.f679B == selectedItemPosition && this.f680C == i && this.f683F == j && this.f684G == j2) ? null : 1;
                selectedItemPosition2 = i;
                obj = obj2;
                break;
            case 128:
                j = -1;
                selectedItemPosition2 = 0;
                j2 = 0;
                if (this.f679B == selectedItemPosition) {
                    obj = null;
                    break;
                }
                obj = 1;
                break;
            default:
                selectedItemPosition2 = i;
                obj = null;
                break;
        }
        if (selectedItemPosition2 == 0) {
            j2 = 0;
        }
        if (obj == null && !this.f705i) {
            return true;
        }
        boolean a = C0229s.m1048a((Context) this, this.f687J, j, selectedItemPosition, selectedItemPosition2, j2, z);
        if (a) {
            if (selectedItemPosition == 0) {
                Toast.makeText(this, 2131230951, 1).show();
            } else {
                Toast.makeText(this, 2131230953, 1).show();
            }
            setResult(-1);
            return a;
        } else if (selectedItemPosition != 16 || z) {
            Toast.makeText(this, 2131230800, 1).show();
            return a;
        } else {
            showDialog(1);
            return a;
        }
    }

    final void m752c(int i) {
        this.f698b = this.f697a;
        this.f697a = i;
        switch (i) {
            case 0:
                this.f714r.setVisibility(0);
                this.f712p.setVisibility(8);
                this.f717u.setVisibility(8);
                this.f716t.setVisibility(8);
                this.f713q.setVisibility(8);
                this.f715s.setVisibility(8);
            case 16:
                this.f714r.setVisibility(8);
                this.f713q.setVisibility(0);
                this.f715s.setVisibility(0);
                this.f712p.setVisibility(0);
                this.f717u.setVisibility(8);
                this.f716t.setVisibility(0);
                this.f716t.setCompoundDrawablesWithIntrinsicBounds(2130837687, 0, 0, 0);
                m737b();
                if (this.f706j) {
                    this.f706j = false;
                } else if (this.f679B == 16) {
                    if (this.f680C == 144) {
                        m738b(-1);
                    } else {
                        m738b(this.f683F);
                    }
                } else if (this.f698b != 32 || this.f700d == -1) {
                    m738b(System.currentTimeMillis());
                } else {
                    m738b(this.f700d);
                }
                m742c();
            case 32:
                this.f714r.setVisibility(8);
                this.f713q.setVisibility(0);
                this.f715s.setVisibility(0);
                this.f712p.setVisibility(0);
                this.f717u.setVisibility(0);
                this.f716t.setVisibility(0);
                this.f716t.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                if (this.f706j) {
                    this.f706j = false;
                } else if (this.f679B == 32) {
                    m738b(this.f683F);
                } else if (this.f698b != 16 || this.f700d == -1 || DateUtils.isToday(this.f700d)) {
                    m738b(System.currentTimeMillis() + 910000);
                } else {
                    this.f699c.hour = 6;
                    this.f699c.minute = 0;
                    this.f699c.second = 0;
                    m738b(C0147f.m661a(this.f699c, true));
                }
                m742c();
            case 128:
                this.f714r.setVisibility(8);
                this.f713q.setVisibility(8);
                this.f715s.setVisibility(8);
                this.f712p.setVisibility(8);
                this.f717u.setVisibility(8);
                this.f716t.setVisibility(8);
            default:
        }
    }

    private void m737b() {
        if (this.f697a == 16 && this.f700d == -1) {
            this.f716t.setVisibility(0);
            this.f717u.setVisibility(8);
            this.f713q.setVisibility(8);
            this.f715s.setVisibility(8);
        } else if (this.f697a == 16) {
            this.f713q.setVisibility(0);
            this.f715s.setVisibility(0);
            this.f717u.setVisibility(8);
            this.f716t.setVisibility(0);
        } else if (this.f697a == 32) {
            this.f713q.setVisibility(0);
            this.f715s.setVisibility(0);
            this.f717u.setVisibility(0);
            this.f716t.setVisibility(0);
        }
    }

    private void m738b(long j) {
        this.f700d = j;
        this.f699c.set(this.f700d);
        m737b();
        m744d();
    }

    private void m742c() {
        long j;
        if (this.f697a == 16) {
            long j2 = this.f700d;
            if (j2 == -1) {
                this.f716t.setText(2131230887);
            } else {
                this.f716t.setText(DateUtils.formatDateTime(this, j2, 22));
            }
            j = this.f700d;
            if (j == -1) {
                this.f718v.setText(2131230887);
                return;
            }
            CharSequence b = C0313j.m1657b((Context) this, j);
            if (b == null) {
                b = DateUtils.formatDateTime(this, j, 22);
            }
            this.f718v.setText(b);
        } else if (this.f697a == 32) {
            this.f716t.setText(DateUtils.formatDateTime(this, this.f700d, 98326));
            j = this.f700d;
            int i = 1;
            if (DateFormat.is24HourFormat(this)) {
                i = 129;
            }
            this.f717u.setText(DateUtils.formatDateTime(this, j, i));
            this.f718v.setText(DateUtils.getRelativeTimeSpanString(this.f700d, System.currentTimeMillis(), 0, 0).toString());
        }
    }

    private void m735a(Calendar calendar) {
        calendar.add(5, 1);
        this.f708l.add(DateUtils.getDayOfWeekString(calendar.get(7), 10));
        this.f707k.add(Long.valueOf(calendar.getTimeInMillis()));
    }

    final void m750a(long j) {
        if (j == 0) {
            this.f719w.setText(2131230792);
        } else {
            this.f719w.setText(DateUtils.formatDateTime(this, j, 22));
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        this.f704h = true;
        return true;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f704h) {
            return super.onKeyUp(i, keyEvent);
        }
        this.f704h = false;
        m736a(false);
        return true;
    }

    private void m744d() {
        Time time = this.f699c;
        Resources resources = getResources();
        String[] strArr = new String[]{DateUtils.getDayOfWeekString(1, 10), DateUtils.getDayOfWeekString(2, 10), DateUtils.getDayOfWeekString(3, 10), DateUtils.getDayOfWeekString(4, 10), DateUtils.getDayOfWeekString(5, 10), DateUtils.getDayOfWeekString(6, 10), DateUtils.getDayOfWeekString(7, 10)};
        String[] stringArray = resources.getStringArray(2131099652);
        boolean z = (time.weekDay == 0 || time.weekDay == 6) ? false : true;
        List arrayList = new ArrayList(0);
        ArrayList arrayList2 = new ArrayList(0);
        ArrayList arrayList3 = this.f696S;
        arrayList.add(resources.getString(2131230786));
        arrayList2.add(Integer.valueOf(0));
        arrayList.add(resources.getString(2131230752));
        arrayList2.add(Integer.valueOf(16));
        if (z) {
            arrayList.add(resources.getString(2131230802));
            arrayList2.add(Integer.valueOf(32));
        }
        arrayList.add(String.format(resources.getString(2131231022), new Object[]{time.format("%A")}));
        arrayList2.add(Integer.valueOf(48));
        arrayList.add(String.format(resources.getString(2131230740), new Object[]{time.format("%A")}));
        arrayList2.add(Integer.valueOf(64));
        int i = (time.monthDay - 1) / 7;
        arrayList.add(String.format(resources.getString(2131230851), new Object[]{stringArray[i], strArr[time.weekDay]}));
        arrayList2.add(Integer.valueOf(80));
        arrayList.add(String.format(resources.getString(2131230850), new Object[]{Integer.valueOf(time.monthDay)}));
        arrayList2.add(Integer.valueOf(96));
        long a = C0147f.m661a(time, false);
        String string = resources.getString(2131231025);
        if (DateFormat.is24HourFormat(this)) {
            i = 128;
        } else {
            i = 0;
        }
        arrayList.add(String.format(string, new Object[]{DateUtils.formatDateTime(this, a, i)}));
        arrayList2.add(Integer.valueOf(112));
        String string2 = resources.getString(2131231026);
        C0309g c0309g = new C0309g(this, C0147f.m661a(time, true), 2);
        arrayList.add(String.format(string2, new Object[]{DateUtils.getMonthString(c0309g.f1366b - 1, 10), Integer.valueOf(c0309g.f1367c)}));
        arrayList2.add(Integer.valueOf(128));
        i = arrayList2.indexOf(Integer.valueOf(0));
        if (arrayList3 != null) {
            int selectedItemPosition = this.f721y.getSelectedItemPosition();
            if (selectedItemPosition >= 0) {
                i = arrayList2.indexOf(Integer.valueOf(((Integer) arrayList3.get(selectedItemPosition)).intValue()));
            }
        } else if (this.f680C != 0) {
            i = arrayList2.indexOf(Integer.valueOf(this.f680C));
        }
        if (i < 0) {
            i = arrayList2.indexOf(Integer.valueOf(0));
        }
        this.f696S = arrayList2;
        SpinnerAdapter arrayAdapter = new ArrayAdapter(this, 2130903074, arrayList);
        arrayAdapter.setDropDownViewResource(2130903075);
        this.f721y.setAdapter(arrayAdapter);
        this.f721y.setSelection(i);
    }

    protected Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                int i2;
                if (this.f689L) {
                    i2 = 2131230741;
                } else {
                    i2 = 2131230950;
                }
                return C0313j.m1634a(this, 2130837583, i2, 2131230776, new am(this));
            default:
                return super.onCreateDialog(i);
        }
    }

    static /* synthetic */ void m743c(ReminderSettings reminderSettings) {
        Calendar instance = Calendar.getInstance();
        instance.set(instance.get(1), instance.get(2), instance.get(5), 6, 0, 0);
        reminderSettings.f707k = new ArrayList();
        reminderSettings.f708l = new ArrayList();
        instance.add(5, -1);
        reminderSettings.m735a(instance);
        reminderSettings.m735a(instance);
        reminderSettings.m735a(instance);
        reminderSettings.m735a(instance);
        reminderSettings.m735a(instance);
        reminderSettings.m735a(instance);
        reminderSettings.m735a(instance);
        reminderSettings.f708l.set(0, reminderSettings.getResources().getText(2131231010).toString());
        reminderSettings.f708l.set(1, reminderSettings.getResources().getText(2131231012).toString());
        reminderSettings.f708l.add(0, reminderSettings.getString(2131230887));
        reminderSettings.f707k.add(0, Long.valueOf(-1));
        reminderSettings.f708l.add(reminderSettings.getString(2131230995));
        reminderSettings.f707k.add(Long.valueOf(-2));
    }

    static /* synthetic */ void m733a(ReminderSettings reminderSettings, Time time) {
        reminderSettings.f700d = C0147f.m660a(time);
        reminderSettings.f699c.set(reminderSettings.f700d);
        reminderSettings.m737b();
        reminderSettings.m744d();
    }
}
