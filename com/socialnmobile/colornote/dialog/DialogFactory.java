package com.socialnmobile.colornote.dialog;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import android.text.format.DateUtils;
import android.text.format.Time;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.socialnmobile.colornote.C0209d;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.fragment.CalendarFragment;
import com.socialnmobile.colornote.fragment.NoteListFragment;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.p006a.C0150i;
import com.socialnmobile.colornote.view.ay;
import java.util.ArrayList;

public final class DialogFactory {

    public class ColorListSelectionDialogFragment extends NoRestoreDialogFragment {
        C0237a f1033Y;

        public ColorListSelectionDialogFragment(NoteListFragment noteListFragment) {
            this.f1033Y = new C0237a(noteListFragment);
            m75j();
        }

        public final Dialog m1094t() {
            return this.f1033Y;
        }

        public final void m1093p() {
            super.m79p();
            m86a(true);
        }
    }

    public class ColorSelectorDialogFragment extends NoRestoreDialogFragment {
        int f1034Y;
        int f1035Z;
        C0242f aa;

        public ColorSelectorDialogFragment(int i, int i2, C0242f c0242f) {
            this.f1034Y = i;
            this.f1035Z = i2;
            this.aa = c0242f;
            m75j();
        }

        public final Dialog m1096t() {
            Dialog c0240d = new C0240d(this.f48C, this.f1034Y, this.f1035Z);
            c0240d.f1067a = this.aa;
            return c0240d;
        }

        public final void m1095p() {
            super.m79p();
            m86a(true);
        }
    }

    public class ConfirmDialogFragment extends NoRestoreDialogFragment {
        int f1036Y;
        int f1037Z;
        int aa;
        int ab;
        int ac;
        boolean ad;
        boolean ae;
        OnClickListener af;

        public ConfirmDialogFragment(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, OnClickListener onClickListener) {
            this.f1036Y = i2;
            this.f1037Z = i;
            this.aa = i3;
            this.ab = i4;
            this.ac = i5;
            this.af = onClickListener;
            this.ad = z;
            this.ae = z2;
            m75j();
        }

        public ConfirmDialogFragment(int i, int i2, int i3, boolean z, OnClickListener onClickListener) {
            this(i, i2, i3, 17039370, 17039360, z, true, onClickListener);
        }

        public final Dialog m1097a(Context context) {
            Builder builder = new Builder(context);
            if (this.f1037Z != 0) {
                builder.setIcon(this.f1037Z);
            }
            builder.setTitle(this.f1036Y);
            builder.setMessage(this.aa);
            builder.setPositiveButton(this.ab, this.af);
            if (this.ad) {
                builder.setNegativeButton(this.ac, null);
            }
            Dialog create = builder.create();
            create.setCanceledOnTouchOutside(this.ae);
            return create;
        }

        public final void m1098p() {
            super.m79p();
            m86a(true);
        }

        public final Dialog m1099t() {
            return m1097a(this.f48C);
        }
    }

    public class DatePickerDialogFragment extends NoRestoreDialogFragment {
        int f1038Y;
        int f1039Z;
        OnDateSetListener aa;

        public DatePickerDialogFragment(OnDateSetListener onDateSetListener, int i, int i2) {
            this.aa = onDateSetListener;
            this.f1038Y = i;
            this.f1039Z = i2;
            m75j();
        }

        public final Dialog m1101t() {
            Dialog datePickerDialog = new DatePickerDialog(this.f48C, this.aa, this.f1038Y, this.f1039Z, 1);
            datePickerDialog.setCancelable(true);
            datePickerDialog.setCanceledOnTouchOutside(true);
            return datePickerDialog;
        }

        public final void m1100p() {
            super.m79p();
            m86a(true);
        }
    }

    public class DownloadColorDictDialogFragment extends NoRestoreDialogFragment {
        public final Dialog m1102t() {
            Builder builder = new Builder(this.f48C);
            builder.setTitle(2131230785);
            builder.setMessage(2131230784);
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://search?q=pname:com.socialnmobile.colordict"));
            intent.setFlags(524288);
            if (C0313j.m1650a(this.f48C, intent)) {
                builder.setPositiveButton(2131230783, new C0243g(this, intent));
            } else {
                builder.setPositiveButton(17039370, new C0244h(this));
            }
            return builder.create();
        }
    }

    public class EnterPasswordDialogFragment extends NoRestoreDialogFragment {
        C0170m f1040Y;
        OnCancelListener f1041Z;
        int aa;

        public EnterPasswordDialogFragment(C0170m c0170m, OnCancelListener onCancelListener) {
            this.f1040Y = c0170m;
            this.f1041Z = onCancelListener;
            this.aa = 0;
            m75j();
        }

        public final void m1105u() {
            super.m1092u();
            if (this.f1040Y == null) {
                m86a(true);
            }
        }

        public final Dialog m1104t() {
            return new C0245i(this.f48C, this.f1040Y, this.f1041Z, this.aa);
        }

        public final void m1103p() {
            super.m79p();
            m86a(true);
        }

        public void onCancel(DialogInterface dialogInterface) {
            if (this.f1041Z != null) {
                this.f1041Z.onCancel(dialogInterface);
            }
            super.onCancel(dialogInterface);
        }
    }

    public class MonthDayDialogFragment extends NoRestoreDialogFragment {
        AlertDialog f1042Y;

        public MonthDayDialogFragment(CalendarFragment calendarFragment, ArrayList arrayList, Time time) {
            Context context = calendarFragment.f48C;
            ListAdapter a = ay.m2180a(context, new ArrayList(), 5);
            Builder builder = new Builder(context);
            builder.setIcon(2130837584);
            builder.setTitle(2131230741);
            if (C0150i.m673a()) {
                builder.setPositiveButton(context.getText(2131230941), new C0251p(calendarFragment));
                builder.setNegativeButton(context.getText(2131230884), new C0252q(calendarFragment));
            } else {
                builder.setPositiveButton(context.getText(2131230884), new C0253r(calendarFragment));
                builder.setNegativeButton(context.getText(2131230941), new C0254s(calendarFragment));
            }
            builder.setNeutralButton(context.getText(2131230723), new C0255t(calendarFragment));
            builder.setAdapter(a, new C0256u(calendarFragment));
            AlertDialog create = builder.create();
            create.setCanceledOnTouchOutside(true);
            ListView listView = create.getListView();
            listView.setAdapter(a);
            listView.setDivider(calendarFragment.f48C.getResources().getDrawable(2130837553));
            int dimensionPixelSize = calendarFragment.f48C.getResources().getDimensionPixelSize(2131361798);
            listView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
            listView.setSelector(2130837654);
            listView.setDrawSelectorOnTop(true);
            listView.setBackgroundColor(C0209d.m875a(context).m1145n(3));
            create.getWindow().clearFlags(2);
            this.f1042Y = create;
            this.f1042Y.getListView().setOnCreateContextMenuListener(calendarFragment);
            m75j();
            if (arrayList != null && time != null) {
                m1106a(arrayList, time);
            }
        }

        public final void m1106a(ArrayList arrayList, Time time) {
            AlertDialog alertDialog = this.f1042Y;
            alertDialog.setTitle(DateUtils.formatDateTime(alertDialog.getContext(), C0147f.m661a(time, true), 32786));
            ay ayVar = (ay) alertDialog.getListView().getAdapter();
            ayVar.f2064d.clear();
            ayVar.f2064d.addAll(arrayList);
            ayVar.f2061a = 5;
            ayVar.f2063c = time;
            ayVar.notifyDataSetChanged();
        }

        public final Dialog m1108t() {
            return this.f1042Y;
        }

        public final void m1107p() {
            super.m79p();
            m86a(true);
        }
    }

    public class NotesOptionsDialogFragment extends NoRestoreDialogFragment {
        NoteListFragment f1043Y;

        public NotesOptionsDialogFragment(NoteListFragment noteListFragment) {
            this.f1043Y = noteListFragment;
        }

        public final void m1109p() {
            super.m79p();
            m86a(true);
        }

        public final Dialog m1110t() {
            if (C0209d.m875a(this.f48C).m1131a()) {
                return new C0257v(this.f1043Y, 2131427332);
            }
            return new C0257v(this.f1043Y, 2131427331);
        }
    }

    public class PasswordDialogFragment extends NoRestoreDialogFragment {
        C0170m f1044Y;
        OnCancelListener f1045Z;
        int aa;

        public PasswordDialogFragment(C0170m c0170m) {
            this.f1044Y = c0170m;
            this.f1045Z = null;
            this.aa = 0;
            m75j();
        }

        public void onCancel(DialogInterface dialogInterface) {
            super.onCancel(dialogInterface);
            if (this.f1045Z != null) {
                this.f1045Z.onCancel(dialogInterface);
            }
        }

        public final Dialog m1112t() {
            return new C0245i(this.f48C, this.f1044Y, null, this.aa);
        }

        public final void m1111p() {
            super.m79p();
            m86a(true);
        }
    }

    public class TextInputDialogFragment extends NoRestoreDialogFragment {
        public aa f1046Y;

        public TextInputDialogFragment(Context context, af afVar) {
            this.f1046Y = new aa(context, afVar);
            m75j();
        }

        public final Dialog m1114t() {
            return this.f1046Y;
        }

        public final void m1113p() {
            super.m79p();
            m86a(true);
        }
    }

    public static DialogFragment m1115a(int i, int i2, OnClickListener onClickListener) {
        return new ConfirmDialogFragment(2130837583, i, i2, true, onClickListener);
    }

    public static DialogFragment m1118b(int i, int i2, OnClickListener onClickListener) {
        return new ConfirmDialogFragment(0, i, i2, true, onClickListener);
    }

    public static DialogFragment m1116a(OnClickListener onClickListener) {
        return new ConfirmDialogFragment(2130837583, 2131231014, 2131230882, 2131231014, 0, false, false, onClickListener);
    }

    public static DialogFragment m1117a(C0170m c0170m) {
        return new PasswordDialogFragment(c0170m);
    }
}
