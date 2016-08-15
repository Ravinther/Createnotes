package com.socialnmobile.colornote.p006a;

import android.os.Environment;
import android.text.TextUtils;
import com.socialnmobile.colornote.ColorNote;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

/* renamed from: com.socialnmobile.colornote.a.g */
public final class C0148g {
    static String[] f610a;
    static String[] f611b;
    private static String f612c;

    static {
        f612c = null;
        f610a = new String[]{"/storage/extSdCard", "/mnt/ext_card", "/mnt/sdcard2", "/mnt/external1", "/mnt/sdcard-ext", "/storage/external_SD", "/storage/ext_sd", "/storage/removable/sdcard1", "/mnt/extSdCard", "/mnt/sdextcard"};
        f611b = new String[]{"/mnt/sdcard/external_sd", "/mnt/sdcard/ext_sd", "/mnt/sdcard/_ExternalSD"};
    }

    public static String m668a() {
        int i = 0;
        for (String str : f610a) {
            File file = new File(str);
            if (file.exists() && file.canWrite() && file.isDirectory()) {
                return str;
            }
        }
        String str2 = C0148g.m670c();
        if (str2 != null) {
            File file2 = new File(str2);
            if (file2.exists() && file2.canWrite() && file2.isDirectory()) {
                return str2;
            }
        }
        String[] strArr = f611b;
        int length = strArr.length;
        while (i < length) {
            str2 = strArr[i];
            File file3 = new File(str2);
            if (file3.exists() && file3.canWrite() && file3.isDirectory()) {
                return str2;
            }
            i++;
        }
        return null;
    }

    private static String m670c() {
        int i = 0;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            String nextLine;
            Object obj = System.getenv("SECONDARY_STORAGE");
            if (!TextUtils.isEmpty(obj)) {
                for (String nextLine2 : obj.split(File.pathSeparator)) {
                    File file = new File(nextLine2);
                    if (file.exists() && file.canWrite() && file.isDirectory()) {
                        return nextLine2;
                    }
                }
            }
            Scanner scanner = new Scanner(new File("/proc/mounts"));
            while (scanner.hasNext()) {
                String nextLine3 = scanner.nextLine();
                String toLowerCase = nextLine3.toLowerCase(Locale.US);
                if (toLowerCase.contains("/vold/") && !toLowerCase.contains("asec")) {
                    String[] split = nextLine3.split(" ");
                    if (split.length >= 2) {
                        nextLine3 = split[1];
                        if (!nextLine3.equals(Environment.getExternalStorageDirectory().getAbsolutePath())) {
                            File file2 = new File(nextLine3);
                            if (file2.exists() && file2.canWrite() && file2.isDirectory()) {
                                arrayList.add(nextLine3);
                            }
                        }
                    }
                }
            }
            scanner.close();
            File file3 = new File("/system/etc/vold.fstab");
            if (file3.exists()) {
                Scanner scanner2 = new Scanner(file3);
                while (scanner2.hasNext()) {
                    nextLine2 = scanner2.nextLine();
                    if (nextLine2.startsWith("dev_mount")) {
                        String[] split2 = nextLine2.split(" ");
                        if (split2.length > 2) {
                            split2[2] = split2[2].replaceAll(":.*$", "");
                            arrayList2.add(split2[2]);
                        }
                    }
                }
                scanner2.close();
            }
            while (i < arrayList.size()) {
                int i2;
                if (arrayList2.contains((String) arrayList.get(i))) {
                    i2 = i;
                } else {
                    i2 = i - 1;
                    arrayList.remove(i);
                }
                i = i2 + 1;
            }
            if (arrayList.size() > 0) {
                return (String) arrayList.get(0);
            }
        } catch (IOException e) {
            ColorNote.m651a("Exception in detect sd card");
            e.printStackTrace();
        } catch (RuntimeException e2) {
            ColorNote.m651a("Exception in detect sd card");
            e2.printStackTrace();
        }
        return null;
    }

    public static String m669b() {
        if (f612c != null) {
            return f612c;
        }
        String d = C0148g.m671d();
        f612c = d;
        return d;
    }

    private static synchronized String m671d() {
        String str;
        synchronized (C0148g.class) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/data/colornote/info/");
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(file, "DEVICE");
            try {
                if (!file2.exists()) {
                    FileOutputStream fileOutputStream = new FileOutputStream(file2);
                    fileOutputStream.write(UUID.randomUUID().toString().getBytes());
                    fileOutputStream.close();
                }
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "r");
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.readFully(bArr);
                randomAccessFile.close();
                str = new String(bArr);
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        return str;
    }
}
