package com.socialnmobile.colornote.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Build.VERSION;
import android.os.Environment;
import com.socialnmobile.colornote.ColorNote;
import com.socialnmobile.colornote.activity.C0175k;
import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.p006a.C0147f;
import com.socialnmobile.colornote.p006a.C0148g;
import com.socialnmobile.colornote.sync.AccountColumns;
import com.socialnmobile.util.p011b.C0449a;
import com.socialnmobile.util.p011b.C0452c;
import com.socialnmobile.util.p011b.p021a.C0450a;
import com.socialnmobile.util.p011b.p021a.C0454c;
import com.socialnmobile.util.p011b.p021a.C0456e;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.socialnmobile.colornote.data.d */
public final class C0214d {
    public Context f949a;
    private C0222l f950b;
    private C0222l f951c;

    public static boolean m977a(Context context) {
        C0214d c0214d = new C0214d(context);
        c0214d.m989a(2);
        boolean a = c0214d.m991a(2, C0229s.m1034a(c0214d.f949a));
        for (String str : c0214d.m995a(false)) {
            String[] list = new File(str).list(new C0215e(c0214d));
            if (list != null) {
                List asList = Arrays.asList(list);
                Collections.sort(asList);
                if (asList.size() > 60) {
                    for (String str2 : asList.subList(0, asList.size() - 60)) {
                        String str22 = str22.substring(0, str22.indexOf("."));
                        new File(str + str22 + ".idx").delete();
                        new File(str + str22 + ".dat").delete();
                        new File(str + str22 + ".doc").delete();
                    }
                }
            }
        }
        return a;
    }

    public C0214d(Context context) {
        this.f949a = context;
    }

    public static String m968a() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        String str = absolutePath + "/data/colornote/backup/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            file = new File(absolutePath + "/data/colornote/.nomedia");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
        }
        return str;
    }

    public final List m996b() {
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        List arrayList = new ArrayList();
        if (VERSION.SDK_INT >= 19) {
            try {
                File[] externalFilesDirs = this.f949a.getExternalFilesDirs(null);
                if (externalFilesDirs != null && externalFilesDirs.length > 0) {
                    for (int i = 0; i < externalFilesDirs.length; i++) {
                        if (externalFilesDirs[i] != null) {
                            String absolutePath2 = externalFilesDirs[i].getAbsolutePath();
                            if (!absolutePath2.startsWith(absolutePath)) {
                                arrayList.add(absolutePath2 + "/backup/");
                            }
                        }
                    }
                }
            } catch (NullPointerException e) {
            }
        } else {
            String a = C0148g.m668a();
            if (a != null) {
                arrayList.add(a + ("/Android/data/" + this.f949a.getPackageName() + "/files") + "/backup/");
            }
        }
        return arrayList;
    }

    public static String m985c() {
        String a = C0148g.m668a();
        if (a == null) {
            return null;
        }
        String str = a + "/data/colornote/backup/";
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            file = new File(a + "/data/colornote/.nomedia");
            if (file.exists()) {
                return str;
            }
            file.createNewFile();
            return str;
        } catch (IOException e) {
            return str;
        }
    }

    private String m988f() {
        File file = null;
        try {
            file = this.f949a.getExternalCacheDir();
        } catch (NullPointerException e) {
        }
        if (file != null) {
            return file.getAbsolutePath();
        }
        file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/data/colornote/temp/");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public final String[] m995a(boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(C0214d.m968a());
        for (String str : m996b()) {
            String str2;
            if (!(str2 == null || arrayList.contains(str2))) {
                arrayList.add(str2);
            }
        }
        if (VERSION.SDK_INT < 19 || z) {
            str2 = C0214d.m985c();
            if (!(str2 == null || arrayList.contains(str2))) {
                arrayList.add(str2);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final void m989a(int i) {
        String b;
        if (i == 2) {
            if (C0213c.m961a(this.f949a)) {
                Context context = this.f949a;
                if (C0212b.m940a(context, "pref_secured_auto_backup", context.getResources().getBoolean(2131296263))) {
                    b = C0213c.m963b(this.f949a);
                }
            }
            C0222l b2 = C0222l.m1009b(30);
            b2.m1016a("0000");
            b2.m1019c(1);
            b = b2.m1012a();
        } else {
            b = C0213c.m963b(this.f949a);
        }
        this.f950b = C0222l.m1009b(20);
        this.f950b.m1017b(b);
        this.f950b.m1019c(1);
        this.f951c = C0222l.m1009b(20);
        this.f951c.m1017b(b);
        this.f951c.m1019c(2);
    }

    private static void m982b(String str) {
        new File(str).delete();
    }

    private static void m983b(String str, String str2) {
        FileChannel channel = new FileInputStream(str).getChannel();
        FileChannel channel2 = new FileOutputStream(str2).getChannel();
        try {
            channel.transferTo(0, channel.size(), channel2);
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
        } catch (Throwable th) {
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m991a(int r14, int r15) {
        /*
        r13 = this;
        r2 = 0;
        r9 = 1;
        r0 = 0;
        r4 = java.lang.System.currentTimeMillis();
        r8 = java.lang.String.valueOf(r4);
        switch(r14) {
            case 1: goto L_0x002e;
            case 2: goto L_0x0042;
            default: goto L_0x000e;
        };
    L_0x000e:
        r3 = r13.m995a(r0);
        r10 = new java.util.ArrayList;
        r10.<init>();
        r6 = r3.length;
        r1 = r0;
    L_0x0019:
        if (r1 >= r6) goto L_0x0056;
    L_0x001b:
        r7 = r3[r1];
        r11 = new java.io.File;
        r11.<init>(r7);
        r11 = r11.canWrite();
        if (r11 == 0) goto L_0x002b;
    L_0x0028:
        r10.add(r7);
    L_0x002b:
        r1 = r1 + 1;
        goto L_0x0019;
    L_0x002e:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r8);
        r3 = "-MANUAL";
        r1 = r1.append(r3);
        r8 = r1.toString();
        goto L_0x000e;
    L_0x0042:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r8);
        r3 = "-AUTO";
        r1 = r1.append(r3);
        r8 = r1.toString();
        goto L_0x000e;
    L_0x0056:
        r1 = r10.size();
        if (r1 != 0) goto L_0x0066;
    L_0x005c:
        r1 = r13.f949a;
        r2 = "BACKUP";
        r3 = "NO_WRITABLE_STORAGE";
        com.socialnmobile.colornote.ColorNote.m646a(r1, r2, r3);
    L_0x0065:
        return r0;
    L_0x0066:
        r7 = r10.get(r0);
        r7 = (java.lang.String) r7;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r1 = r1.append(r7);
        r1 = r1.append(r8);
        r3 = ".doc";
        r1 = r1.append(r3);
        r11 = r1.toString();
        com.socialnmobile.colornote.data.C0231u.m1071c();	 Catch:{ IOException -> 0x0108, JSONException -> 0x0122 }
        r1 = new java.io.File;	 Catch:{ all -> 0x0118 }
        r1.<init>(r7);	 Catch:{ all -> 0x0118 }
        r3 = r1.exists();	 Catch:{ all -> 0x0118 }
        if (r3 != 0) goto L_0x0094;
    L_0x0091:
        r1.mkdirs();	 Catch:{ all -> 0x0118 }
    L_0x0094:
        r1 = new java.io.File;	 Catch:{ all -> 0x0118 }
        r1.<init>(r11);	 Catch:{ all -> 0x0118 }
        r6 = new java.io.BufferedOutputStream;	 Catch:{ all -> 0x0118 }
        r3 = new java.io.FileOutputStream;	 Catch:{ all -> 0x0118 }
        r3.<init>(r1);	 Catch:{ all -> 0x0118 }
        r6.<init>(r3);	 Catch:{ all -> 0x0118 }
        r3 = new java.io.DataOutputStream;	 Catch:{ all -> 0x0118 }
        r3.<init>(r6);	 Catch:{ all -> 0x0118 }
        r6 = 78;
        r3.writeChar(r6);	 Catch:{ all -> 0x0143 }
        r6 = 79;
        r3.writeChar(r6);	 Catch:{ all -> 0x0143 }
        r6 = 84;
        r3.writeChar(r6);	 Catch:{ all -> 0x0143 }
        r6 = 69;
        r3.writeChar(r6);	 Catch:{ all -> 0x0143 }
        r6 = 7;
        r3.writeInt(r6);	 Catch:{ all -> 0x0143 }
        r3.writeInt(r14);	 Catch:{ all -> 0x0143 }
        r3.writeLong(r4);	 Catch:{ all -> 0x0143 }
        r3.writeInt(r15);	 Catch:{ all -> 0x0143 }
        r3.close();	 Catch:{ all -> 0x0143 }
        r3 = r13.f950b;	 Catch:{ all -> 0x0118 }
        r6 = new java.io.FileOutputStream;	 Catch:{ all -> 0x0118 }
        r12 = 1;
        r6.<init>(r1, r12);	 Catch:{ all -> 0x0118 }
        r1 = new javax.crypto.CipherOutputStream;	 Catch:{ all -> 0x0118 }
        r3 = r3.f972a;	 Catch:{ all -> 0x0118 }
        r1.<init>(r6, r3);	 Catch:{ all -> 0x0118 }
        r3 = new java.io.DataOutputStream;	 Catch:{ all -> 0x0118 }
        r3.<init>(r1);	 Catch:{ all -> 0x0118 }
        r13.m971a(r3);	 Catch:{ all -> 0x0146 }
        r3.close();	 Catch:{ all -> 0x0146 }
        com.socialnmobile.colornote.data.C0231u.m1072d();	 Catch:{ IOException -> 0x0108, JSONException -> 0x0122 }
        r1 = new com.socialnmobile.colornote.data.h;	 Catch:{ IOException -> 0x0108, JSONException -> 0x0122 }
        r2 = 7;
        r3 = r14;
        r6 = r15;
        r1.<init>(r2, r3, r4, r6, r7, r8);	 Catch:{ IOException -> 0x0108, JSONException -> 0x0122 }
        r2 = 0;
        r1 = r13.m993a(r1, r2);	 Catch:{ IOException -> 0x0108, JSONException -> 0x0122 }
        if (r1 != 0) goto L_0x0132;
    L_0x00f8:
        r1 = com.socialnmobile.colornote.C0311h.f1370a;	 Catch:{ IOException -> 0x0108, JSONException -> 0x0122 }
        r2 = "BACKUP0";
        r3 = "";
        r4 = "";
        r1.m1623a(r2, r3, r4);	 Catch:{ IOException -> 0x0108, JSONException -> 0x0122 }
        com.socialnmobile.colornote.data.C0214d.m982b(r11);	 Catch:{ IOException -> 0x0108, JSONException -> 0x0122 }
        goto L_0x0065;
    L_0x0108:
        r1 = move-exception;
        r1.printStackTrace();
        com.socialnmobile.colornote.data.C0214d.m982b(r11);
        r2 = com.socialnmobile.colornote.C0311h.f1370a;
        r3 = "BACKUP1:";
        r2.m1624a(r3, r1);
        goto L_0x0065;
    L_0x0118:
        r1 = move-exception;
    L_0x0119:
        com.socialnmobile.colornote.data.C0231u.m1072d();	 Catch:{ IOException -> 0x0108, JSONException -> 0x0122 }
        if (r2 == 0) goto L_0x0121;
    L_0x011e:
        r2.close();	 Catch:{ IOException -> 0x0141, JSONException -> 0x0122 }
    L_0x0121:
        throw r1;	 Catch:{ IOException -> 0x0108, JSONException -> 0x0122 }
    L_0x0122:
        r1 = move-exception;
        r1.printStackTrace();
        com.socialnmobile.colornote.data.C0214d.m982b(r11);
        r2 = com.socialnmobile.colornote.C0311h.f1370a;
        r3 = "BACKUP2:";
        r2.m1624a(r3, r1);
        goto L_0x0065;
    L_0x0132:
        r1 = r10.size();
        if (r1 <= r9) goto L_0x013e;
    L_0x0138:
        r1 = com.socialnmobile.colornote.data.C0214d.m979a(r10, r8);
        if (r1 == 0) goto L_0x0065;
    L_0x013e:
        r0 = r9;
        goto L_0x0065;
    L_0x0141:
        r2 = move-exception;
        goto L_0x0121;
    L_0x0143:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0119;
    L_0x0146:
        r1 = move-exception;
        r2 = r3;
        goto L_0x0119;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.socialnmobile.colornote.data.d.a(int, int):boolean");
    }

    private static boolean m979a(List list, String str) {
        if (list.size() <= 1) {
            return true;
        }
        boolean z = true;
        for (int i = 1; i < list.size(); i++) {
            try {
                File file = new File((String) list.get(i));
                if (!file.exists()) {
                    file.mkdirs();
                }
                C0214d.m983b(((String) list.get(0)) + str + ".doc", ((String) list.get(i)) + str + ".doc");
            } catch (IOException e) {
                ColorNote.m651a("Backup file copy failed : " + ((String) list.get(i)));
                z = false;
            }
        }
        return z;
    }

    private static int m967a(int i, DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        if (dataInputStream.readInt() == 4 && i == readInt) {
            return dataInputStream.readInt();
        }
        throw new IOException();
    }

    private static long m980b(int i, DataInputStream dataInputStream) {
        int readInt = dataInputStream.readInt();
        if (dataInputStream.readInt() == 8 && i == readInt) {
            return dataInputStream.readLong();
        }
        throw new IOException();
    }

    private String m986c(int i, DataInputStream dataInputStream) {
        if (i != dataInputStream.readInt()) {
            throw new IOException();
        }
        byte[] bArr = new byte[dataInputStream.readInt()];
        dataInputStream.read(bArr);
        return this.f951c.m1013a(bArr);
    }

    public final boolean m992a(C0218h c0218h) {
        boolean z = false;
        try {
            z = m994a(c0218h, null, true);
        } catch (IOException e) {
        } catch (JSONException e2) {
        } catch (GeneralSecurityException e3) {
        }
        return z;
    }

    private static InputStream m981b(C0218h c0218h) {
        String str;
        if (c0218h.m999a()) {
            str = c0218h.f959e + c0218h.f960f + ".doc";
        } else {
            str = c0218h.f959e + c0218h.f960f + ".idx";
        }
        return new BufferedInputStream(new FileInputStream(str));
    }

    public final boolean m993a(C0218h c0218h, C0175k c0175k) {
        Throwable th;
        DataInputStream dataInputStream = null;
        try {
            DataInputStream dataInputStream2 = new DataInputStream(C0214d.m981b(c0218h));
            try {
                if (new String(new char[]{dataInputStream2.readChar(), dataInputStream2.readChar(), dataInputStream2.readChar(), dataInputStream2.readChar()}).equals("NOTE")) {
                    int readInt = dataInputStream2.readInt();
                    if (c0218h.f955a != readInt) {
                        try {
                            dataInputStream2.close();
                            return false;
                        } catch (IOException e) {
                            return false;
                        }
                    }
                    af a = af.m930a(this.f949a);
                    if (readInt > 7) {
                        try {
                            dataInputStream2.close();
                            return false;
                        } catch (IOException e2) {
                            return false;
                        }
                    } else if (readInt == 4 || readInt == 5 || readInt == 6 || readInt == 7) {
                        a.m932a(true);
                        m978a(c0218h, a.m933b(), c0175k, false);
                        try {
                            dataInputStream2.close();
                        } catch (IOException e3) {
                        }
                        return true;
                    } else if (readInt == 3) {
                        m974a(c0218h.f959e, c0218h.f960f, this.f949a.getDatabasePath("colornote_temp.db").getPath(), c0175k, false, false);
                        a.m932a(false);
                        try {
                            dataInputStream2.close();
                        } catch (IOException e4) {
                        }
                        return true;
                    } else {
                        try {
                            dataInputStream2.close();
                            return false;
                        } catch (IOException e5) {
                            return false;
                        }
                    }
                }
                try {
                    dataInputStream2.close();
                    return false;
                } catch (IOException e6) {
                    return false;
                }
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e7) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            throw th;
        }
    }

    public final boolean m994a(C0218h c0218h, C0175k c0175k, boolean z) {
        Throwable th;
        DataInputStream dataInputStream = null;
        DataInputStream dataInputStream2;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(C0214d.m981b(c0218h));
            try {
                if (new String(new char[]{dataInputStream3.readChar(), dataInputStream3.readChar(), dataInputStream3.readChar(), dataInputStream3.readChar()}).equals("NOTE")) {
                    int readInt = dataInputStream3.readInt();
                    if (c0218h.f955a != readInt) {
                        try {
                            dataInputStream3.close();
                            return false;
                        } catch (IOException e) {
                            return false;
                        }
                    }
                    dataInputStream3.readInt();
                    dataInputStream3.readLong();
                    int readInt2 = dataInputStream3.readInt();
                    if (readInt > 7) {
                        try {
                            dataInputStream3.close();
                            return false;
                        } catch (IOException e2) {
                            return false;
                        }
                    } else if (readInt == 4 || readInt == 5 || readInt == 6 || readInt == 7) {
                        NoteProvider a = NoteProvider.m880a(this.f949a);
                        C0231u b = NoteProvider.m885b(this.f949a);
                        C0231u.m1071c();
                        m978a(c0218h, b.m1074f(), c0175k, z);
                        C0231u.m1072d();
                        a.m890a();
                        ColorNote.m654c();
                        try {
                            dataInputStream3.close();
                        } catch (IOException e3) {
                        }
                        return true;
                    } else if (readInt == 3) {
                        m974a(c0218h.f959e, c0218h.f960f, this.f949a.getDatabasePath("colornote.db").getPath(), c0175k, true, z);
                        ColorNote.m654c();
                        try {
                            dataInputStream3.close();
                        } catch (IOException e4) {
                        }
                        return true;
                    } else {
                        dataInputStream2 = new DataInputStream(new BufferedInputStream(new FileInputStream(C0214d.m987c(c0218h))));
                        try {
                            m976a(readInt, readInt2, z, dataInputStream3, dataInputStream2, c0175k);
                            try {
                                dataInputStream3.close();
                                dataInputStream2.close();
                            } catch (IOException e5) {
                            }
                            return true;
                        } catch (Throwable th2) {
                            th = th2;
                            dataInputStream = dataInputStream3;
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (IOException e6) {
                                    throw th;
                                }
                            }
                            if (dataInputStream2 != null) {
                                dataInputStream2.close();
                            }
                            throw th;
                        }
                    }
                }
                try {
                    dataInputStream3.close();
                    return false;
                } catch (IOException e7) {
                    return false;
                }
            } catch (Throwable th3) {
                th = th3;
                dataInputStream2 = null;
                dataInputStream = dataInputStream3;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            dataInputStream2 = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            throw th;
        }
    }

    public final void m997d() {
        int i = 0;
        String[] a = m995a(false);
        int length = a.length;
        while (i < length) {
            File file = new File(a[i]);
            if (file.isDirectory()) {
                C0214d.m972a(file);
            }
            i++;
        }
    }

    public static void m973a(String str, String str2) {
        new File(str + str2 + ".idx").delete();
        new File(str + str2 + ".dat").delete();
        new File(str + str2 + ".doc").delete();
    }

    private static void m972a(File file) {
        String[] list = file.list();
        int i = 0;
        while (i < list.length && new File(file, list[i]).delete()) {
            i++;
        }
    }

    public final ArrayList m998e() {
        HashMap hashMap = new HashMap();
        for (String a : m995a(true)) {
            m975a(hashMap, a);
        }
        m975a(hashMap, C0147f.m663a(Environment.DIRECTORY_DOWNLOADS).toString() + "/");
        Object arrayList = new ArrayList(hashMap.values());
        Collections.sort(arrayList, new C0216f(this));
        return arrayList;
    }

    private void m975a(HashMap hashMap, String str) {
        String[] list = new File(str).list(new C0217g(this));
        if (list != null) {
            for (String c : Arrays.asList(list)) {
                C0218h c2 = C0214d.m984c(str, c);
                if (c2 != null && c2.f955a >= 0) {
                    if (hashMap.containsKey(c2.f960f)) {
                        C0218h c0218h = (C0218h) hashMap.get(c2.f960f);
                        c0218h.f961g.add(c2.f959e);
                    } else {
                        hashMap.put(c2.f960f, c2);
                    }
                }
            }
        }
    }

    private static String m987c(C0218h c0218h) {
        if (c0218h.m999a()) {
            return c0218h.f959e + c0218h.f960f + ".doc";
        }
        return c0218h.f959e + c0218h.f960f + ".dat";
    }

    private static C0218h m984c(String str, String str2) {
        DataInputStream dataInputStream;
        Throwable th;
        DataInputStream dataInputStream2;
        try {
            dataInputStream2 = new DataInputStream(new BufferedInputStream(new FileInputStream(str + str2)));
            try {
                if (new String(new char[]{dataInputStream2.readChar(), dataInputStream2.readChar(), dataInputStream2.readChar(), dataInputStream2.readChar()}).equals("NOTE")) {
                    C0218h c0218h = new C0218h(dataInputStream2.readInt(), dataInputStream2.readInt(), dataInputStream2.readLong(), dataInputStream2.readInt(), str, str2.substring(0, str2.indexOf(".")));
                    try {
                        dataInputStream2.close();
                        return c0218h;
                    } catch (IOException e) {
                        return c0218h;
                    }
                }
                try {
                    dataInputStream2.close();
                } catch (IOException e2) {
                }
                return null;
            } catch (IOException e3) {
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (dataInputStream2 != null) {
                    try {
                        dataInputStream2.close();
                    } catch (IOException e5) {
                    }
                }
                throw th;
            }
        } catch (IOException e6) {
            dataInputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            return null;
        } catch (Throwable th3) {
            dataInputStream2 = null;
            th = th3;
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            throw th;
        }
    }

    private boolean m978a(C0218h c0218h, C0232v c0232v, C0175k c0175k, boolean z) {
        String c = C0214d.m987c(c0218h);
        String str = m988f() + c0218h.f960f + ".tmp";
        try {
            if (c0218h.m999a()) {
                this.f951c.m1014a(c, 28, str);
            } else {
                this.f951c.m1015a(c, str);
            }
            if (!z) {
                C0214d.m969a(c0218h, str, c0175k, c0232v);
                C0214d.m982b(str);
            }
            return true;
        } finally {
            C0214d.m982b(str);
        }
    }

    private static void m969a(C0218h c0218h, String str, C0175k c0175k, C0232v c0232v) {
        Throwable th;
        DataInputStream dataInputStream;
        try {
            c0232v.f1027a.beginTransaction();
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(str)));
            try {
                int readInt = dataInputStream.readInt();
                if (readInt != 1) {
                    throw new IOException("Invalid Data Type : AccountTable : " + c0218h.f955a + ":" + c0218h.m999a() + ":" + readInt);
                }
                int i;
                String readUTF;
                byte[] bArr;
                JSONObject jSONObject;
                ContentValues contentValues;
                int readInt2 = dataInputStream.readInt();
                for (i = 0; i < readInt2; i++) {
                    if (c0218h.f955a == 4) {
                        readUTF = dataInputStream.readUTF();
                    } else {
                        bArr = new byte[dataInputStream.readInt()];
                        dataInputStream.readFully(bArr);
                        readUTF = new String(bArr, "UTF-8");
                    }
                    jSONObject = new JSONObject(readUTF);
                    contentValues = new ContentValues();
                    for (C0449a a : AccountColumns.COLUMNS) {
                        C0214d.m970a(a, contentValues, jSONObject);
                    }
                    c0232v.m1078a("SyncAccount", null, contentValues);
                }
                if (dataInputStream.readInt() != 2) {
                    throw new IOException("Invalid Data Type : NoteTable");
                }
                readInt2 = dataInputStream.readInt();
                if (c0175k != null) {
                    c0175k.m823a(readInt2);
                }
                for (i = 0; i < readInt2; i++) {
                    if (c0218h.f955a == 4) {
                        readUTF = dataInputStream.readUTF();
                    } else {
                        bArr = new byte[dataInputStream.readInt()];
                        dataInputStream.readFully(bArr);
                        readUTF = new String(bArr, "UTF-8");
                    }
                    jSONObject = new JSONObject(readUTF);
                    contentValues = new ContentValues();
                    for (C0449a a2 : NoteColumns.f909a) {
                        C0214d.m970a(a2, contentValues, jSONObject);
                    }
                    for (C0449a a22 : NoteColumns.f910b) {
                        C0214d.m970a(a22, contentValues, jSONObject);
                    }
                    contentValues.remove("_id");
                    c0232v.m1078a("notes", null, contentValues);
                    if (i % 32 == 0 && c0175k != null) {
                        c0175k.m824b(i);
                    }
                }
                if (c0175k != null && readInt2 > 0) {
                    c0175k.m824b(readInt2 - 1);
                }
                c0232v.f1027a.setTransactionSuccessful();
                c0232v.f1027a.endTransaction();
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                }
            } catch (Throwable th2) {
                th = th2;
                c0232v.f1027a.endTransaction();
                if (dataInputStream != null) {
                    try {
                        dataInputStream.close();
                    } catch (IOException e2) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
            c0232v.f1027a.endTransaction();
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            throw th;
        }
    }

    private void m971a(DataOutputStream dataOutputStream) {
        Cursor a = NoteProvider.m885b(this.f949a).m1074f().m1080a("SyncAccount", null, null, null, null);
        dataOutputStream.writeInt(1);
        dataOutputStream.writeInt(a.getCount());
        ArrayList arrayList = new ArrayList();
        for (C0449a a2 : AccountColumns.COLUMNS) {
            arrayList.add(a2.m2246a(a));
        }
        while (a.moveToNext()) {
            JSONObject jSONObject = new JSONObject();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0452c c0452c = (C0452c) it.next();
                jSONObject.put(c0452c.f2235a.f2234a, c0452c.m2261c());
            }
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            dataOutputStream.writeInt(bytes.length);
            dataOutputStream.write(bytes);
        }
        a.close();
        a = NoteProvider.m885b(this.f949a).m1074f().m1080a("notes", null, null, null, null);
        dataOutputStream.writeInt(2);
        dataOutputStream.writeInt(a.getCount());
        ArrayList arrayList2 = new ArrayList();
        for (C0449a a3 : NoteColumns.f909a) {
            arrayList2.add(a3.m2246a(a));
        }
        for (C0449a a32 : NoteColumns.f910b) {
            arrayList2.add(a32.m2246a(a));
        }
        while (a.moveToNext()) {
            JSONObject jSONObject2 = new JSONObject();
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                c0452c = (C0452c) it2.next();
                jSONObject2.put(c0452c.f2235a.f2234a, c0452c.m2261c());
            }
            bytes = jSONObject2.toString().getBytes("UTF-8");
            dataOutputStream.writeInt(bytes.length);
            dataOutputStream.write(bytes);
        }
        a.close();
    }

    private void m974a(String str, String str2, String str3, C0175k c0175k, boolean z, boolean z2) {
        NoteProvider a = NoteProvider.m880a(this.f949a);
        String str4 = m988f() + str2 + ".dat.tmp";
        String str5 = str + str2 + ".dat";
        if (c0175k != null) {
            c0175k.m823a(4);
        }
        this.f951c.m1015a(str5, str4);
        if (c0175k != null) {
            c0175k.m824b(1);
        }
        if (z2) {
            C0214d.m982b(str4);
            return;
        }
        if (z) {
            C0231u.m1071c();
        }
        if (z) {
            try {
                NoteProvider.m887c();
            } catch (Throwable th) {
                if (z) {
                    C0231u.m1072d();
                }
            }
        }
        C0214d.m983b(str4, str3);
        if (c0175k != null) {
            c0175k.m824b(2);
        }
        C0214d.m982b(str4);
        if (c0175k != null) {
            c0175k.m824b(3);
        }
        if (z) {
            a.m892b();
        }
        if (c0175k != null) {
            c0175k.m824b(4);
        }
        if (z) {
            C0231u.m1072d();
        }
    }

    private boolean m976a(int i, int i2, boolean z, DataInputStream dataInputStream, DataInputStream dataInputStream2, C0175k c0175k) {
        if (i >= 2) {
            String[] strArr = new String[10];
            strArr[1] = dataInputStream.readUTF();
            strArr[2] = dataInputStream.readUTF();
            strArr[3] = dataInputStream.readUTF();
            strArr[4] = dataInputStream.readUTF();
            strArr[5] = dataInputStream.readUTF();
            strArr[6] = dataInputStream.readUTF();
            strArr[7] = dataInputStream.readUTF();
            strArr[8] = dataInputStream.readUTF();
            strArr[9] = dataInputStream.readUTF();
            if (!z) {
                ad.m924a();
                C0213c.m960a(this.f949a, 0, 1, strArr[1]);
                C0213c.m960a(this.f949a, 0, 2, strArr[2]);
                C0213c.m960a(this.f949a, 0, 3, strArr[3]);
                C0213c.m960a(this.f949a, 0, 4, strArr[4]);
                C0213c.m960a(this.f949a, 0, 5, strArr[5]);
                C0213c.m960a(this.f949a, 0, 6, strArr[6]);
                C0213c.m960a(this.f949a, 0, 7, strArr[7]);
                C0213c.m960a(this.f949a, 0, 8, strArr[8]);
                C0213c.m960a(this.f949a, 0, 9, strArr[9]);
            }
        }
        if (z && i2 > 100) {
            i2 = 100;
        }
        if (c0175k != null) {
            c0175k.m823a(i2);
        }
        for (int i3 = 0; i3 < i2; i3++) {
            dataInputStream.readInt();
            dataInputStream.readInt();
            int i4 = 0;
            int i5 = 0;
            String str = "";
            int i6 = 0;
            int i7 = 0;
            long j = 0;
            long j2 = 0;
            long j3 = 0;
            int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            int a = C0214d.m967a(1, dataInputStream2);
            int a2 = C0214d.m967a(2, dataInputStream2);
            int a3 = C0214d.m967a(3, dataInputStream2);
            long b = C0214d.m980b(4, dataInputStream2);
            long b2 = C0214d.m980b(5, dataInputStream2);
            String c = m986c(6, dataInputStream2);
            int a4 = C0214d.m967a(7, dataInputStream2);
            int a5 = C0214d.m967a(8, dataInputStream2);
            String c2 = m986c(9, dataInputStream2);
            if (i == 1) {
                if (a3 <= 5) {
                    a3++;
                }
                if (a == 1) {
                    a = 16;
                }
                if (a2 == 1) {
                    a2 = 16;
                }
            }
            if (i >= 2) {
                i5 = C0214d.m967a(10, dataInputStream2);
                i4 = C0214d.m967a(11, dataInputStream2);
                str = m986c(12, dataInputStream2);
                i6 = C0214d.m967a(13, dataInputStream2);
                i7 = C0214d.m967a(14, dataInputStream2);
                j = C0214d.m980b(15, dataInputStream2);
                j2 = C0214d.m980b(16, dataInputStream2);
                j3 = C0214d.m980b(17, dataInputStream2);
                i8 = C0214d.m967a(18, dataInputStream2);
                i9 = C0214d.m967a(19, dataInputStream2);
                i10 = C0214d.m967a(20, dataInputStream2);
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put(NoteMinorColumns.FOLDER, Integer.valueOf(i5));
            contentValues.put(NoteMinorColumns.FLAGS, Integer.valueOf(a));
            contentValues.put(NoteMinorColumns.TYPE, Integer.valueOf(a2));
            contentValues.put(NoteMinorColumns.COLOR, Integer.valueOf(a3));
            contentValues.put(NoteMinorColumns.CREATED_DATE, Long.valueOf(b));
            contentValues.put(NoteMajorColumns.MODIFIED_DATE, Long.valueOf(b2));
            contentValues.put(NoteMajorColumns.TITLE, c);
            contentValues.put(NoteMinorColumns.NOTE_VERSION, Integer.valueOf(a4));
            contentValues.put(NoteMajorColumns.ENCRYPTION, Integer.valueOf(a5));
            contentValues.put(NoteMajorColumns.NOTE, c2);
            contentValues.put(NoteMinorColumns.STATE, Integer.valueOf(i4));
            contentValues.put(NoteMinorColumns.NOTE_EXT, str);
            contentValues.put(NoteMinorColumns.IMPORTANCE, Integer.valueOf(i6));
            contentValues.put(NoteMinorColumns.REMINDER_TYPE, Integer.valueOf(i7));
            contentValues.put(NoteMinorColumns.REMINDER_DATE, Long.valueOf(j));
            contentValues.put(NoteMinorColumns.REMINDER_BASE, Long.valueOf(j2));
            contentValues.put(NoteMinorColumns.REMINDER_LAST, Long.valueOf(j3));
            contentValues.put(NoteMinorColumns.REMINDER_DURATION, Integer.valueOf(i8));
            contentValues.put(NoteMinorColumns.REMINDER_OPTION, Integer.valueOf(i9));
            contentValues.put(NoteMinorColumns.REMINDER_REPEAT, Integer.valueOf(i10));
            if (!z) {
                C0229s.m1040a(this.f949a, contentValues);
            }
            if ((i3 & 3) == 0 && c0175k != null) {
                c0175k.m824b(i3);
            }
        }
        if (!z) {
            ColorNote.m654c();
        }
        return true;
    }

    public final void m990a(String str) {
        this.f951c = C0222l.m1009b(20);
        this.f951c.m1016a(str);
        this.f951c.m1019c(2);
    }

    private static void m970a(C0449a c0449a, ContentValues contentValues, JSONObject jSONObject) {
        if (!jSONObject.has(c0449a.f2234a)) {
            return;
        }
        if (c0449a instanceof C0454c) {
            c0449a.m2248a(contentValues, Integer.valueOf(jSONObject.getInt(c0449a.f2234a)));
        } else if (c0449a instanceof C0450a) {
            c0449a.m2248a(contentValues, Double.valueOf(jSONObject.getDouble(c0449a.f2234a)));
        } else if (c0449a instanceof C0456e) {
            c0449a.m2248a(contentValues, Long.valueOf(jSONObject.getLong(c0449a.f2234a)));
        } else {
            c0449a.m2248a(contentValues, jSONObject.get(c0449a.f2234a));
        }
    }
}
