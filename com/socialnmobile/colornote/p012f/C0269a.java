package com.socialnmobile.colornote.p012f;

import android.text.SpannableStringBuilder;
import com.socialnmobile.colornote.C0313j;
import com.socialnmobile.colornote.data.C0220j;
import com.socialnmobile.colornote.sync.bg;
import com.socialnmobile.colornote.sync.cm;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.socialnmobile.colornote.f.a */
public final class C0269a extends C0268b {
    public static CharSequence m1202a(String str) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        Iterator it = C0269a.m1204b(str).iterator();
        while (it.hasNext()) {
            C0220j c0220j = (C0220j) it.next();
            spannableStringBuilder.append("\u2022");
            if (c0220j.m1005a()) {
                spannableStringBuilder.append(C0313j.m1639a(c0220j.f964a));
            } else {
                spannableStringBuilder.append(c0220j.f964a);
            }
            spannableStringBuilder.append('\n');
        }
        return spannableStringBuilder;
    }

    public static String m1203a(ArrayList arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0220j c0220j = (C0220j) it.next();
            stringBuffer.append("[");
            if (c0220j.m1005a()) {
                stringBuffer.append("V");
            } else {
                stringBuffer.append(" ");
            }
            stringBuffer.append("] ");
            stringBuffer.append(c0220j.f964a + "\n");
        }
        return stringBuffer.toString();
    }

    public static ArrayList m1204b(String str) {
        ArrayList arrayList = new ArrayList();
        if (str.trim().equals("")) {
            return arrayList;
        }
        String[] split = str.split("\n\\[");
        split[0] = split[0].substring(1);
        for (String str2 : split) {
            if (str2.length() >= 3) {
                boolean z;
                String trim = str2.substring(3).trim();
                if (str2.charAt(0) == 'V') {
                    z = true;
                } else {
                    z = false;
                }
                arrayList.add(new C0220j(trim, z));
            }
        }
        return arrayList;
    }

    public final int m1205a(cm cmVar, cm cmVar2) {
        if (((bg) cmVar2.f1629c.f1647d.m2010c()).f1558a >= ((bg) cmVar.f1629c.f1647d.m2010c()).f1558a) {
            return 3;
        }
        return 2;
    }
}
