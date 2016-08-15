package com.flurry.android.monolithic.sdk.impl;

import android.os.Looper;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.flurry.android.monolithic.sdk.impl.z */
public class C0141z {
    static final Integer f595a;
    private static final String f596c;
    LinkedHashMap f597b;

    static {
        f596c = C0141z.class.getSimpleName();
        f595a = Integer.valueOf(50);
    }

    public C0141z() {
        m634a();
    }

    private void m634a() {
        this.f597b = new LinkedHashMap();
        List<String> d = m640d("Main");
        if (d != null) {
            for (String str : d) {
                List d2 = m640d(str);
                if (d2 != null) {
                    this.f597b.put(str, d2);
                }
            }
        }
    }

    private synchronized void m637b() {
        List linkedList = new LinkedList(this.f597b.keySet());
        m635a(am.f442a.f443b.getFileStreamPath(".FlurrySenderIndex.info.Main"));
        if (!linkedList.isEmpty()) {
            m636a("Main", linkedList);
        }
    }

    public final synchronized void m642a(C0140x c0140x, String str) {
        Object obj = null;
        synchronized (this) {
            List linkedList;
            bh.m584a(4, "addBlockInfo");
            String str2 = c0140x.f591b;
            List list = (List) this.f597b.get(str);
            if (list == null) {
                bh.m584a(4, "New Data Key");
                linkedList = new LinkedList();
                obj = 1;
            } else {
                linkedList = list;
            }
            linkedList.add(str2);
            if (linkedList.size() > f595a.intValue()) {
                C0141z.m638b((String) linkedList.get(0));
                linkedList.remove(0);
            }
            this.f597b.put(str, linkedList);
            m636a(str, linkedList);
            if (obj != null) {
                m637b();
            }
        }
    }

    private static boolean m638b(String str) {
        C0140x c0140x = new C0140x(str);
        if (c0140x.f594e.exists()) {
            if (c0140x.f594e.delete()) {
                String str2 = C0140x.f590a;
                bh.m584a(4, "Deleted persistence file");
                c0140x.f592c = -1;
                c0140x.f593d = -1;
                return true;
            }
            String str3 = C0140x.f590a;
            bh.m584a(6, "Cannot delete persistence file");
        }
        return false;
    }

    public final boolean m643a(String str, String str2) {
        List list = (List) this.f597b.get(str2);
        boolean z = false;
        if (list != null) {
            C0141z.m638b(str);
            z = list.remove(str);
        }
        if (list == null || list.isEmpty()) {
            m639c(str2);
        } else {
            this.f597b.put(str2, list);
            m636a(str2, list);
        }
        return z;
    }

    public final List m641a(String str) {
        return (List) this.f597b.get(str);
    }

    private synchronized boolean m639c(String str) {
        boolean a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            bh.m584a(6, "discardOutdatedBlocksForDataKey(ID) running on the MAIN thread!");
        }
        File fileStreamPath = am.f442a.f443b.getFileStreamPath(".FlurrySenderIndex.info." + str);
        List a2 = m641a(str);
        if (a2 != null) {
            bh.m584a(4, "discardOutdatedBlocksForDataKey: notSentBlocks = " + a2.size());
            for (int i = 0; i < a2.size(); i++) {
                String str2 = (String) a2.get(i);
                C0141z.m638b(str2);
                bh.m584a(4, "discardOutdatedBlocksForDataKey: removed block = " + str2);
            }
        }
        this.f597b.remove(str);
        a = m635a(fileStreamPath);
        m637b();
        return a;
    }

    private synchronized boolean m635a(File file) {
        boolean z;
        z = false;
        if (file != null) {
            if (file.exists()) {
                bh.m584a(4, "Trying to delete persistence file : " + file.getAbsolutePath());
                z = file.delete();
                if (z) {
                    bh.m584a(4, "Deleted persistence file");
                } else {
                    bh.m584a(6, "Cannot delete persistence file");
                }
            }
        }
        return z;
    }

    private synchronized List m640d(String str) {
        Throwable th;
        Throwable th2;
        Throwable th3;
        List list = null;
        synchronized (this) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                bh.m584a(6, "readFromFile(byte[], ID) running on the MAIN thread!");
            }
            File fileStreamPath = am.f442a.f443b.getFileStreamPath(".FlurrySenderIndex.info." + str);
            List arrayList;
            if (fileStreamPath.exists()) {
                Closeable dataInputStream;
                try {
                    dataInputStream = new DataInputStream(new FileInputStream(fileStreamPath));
                    try {
                        int readUnsignedShort = dataInputStream.readUnsignedShort();
                        if (readUnsignedShort == 0) {
                            bj.m596a(dataInputStream);
                        } else {
                            arrayList = new ArrayList(readUnsignedShort);
                            int i = 0;
                            while (i < readUnsignedShort) {
                                try {
                                    int readUnsignedShort2 = dataInputStream.readUnsignedShort();
                                    bh.m584a(4, "read iter " + i + " dataLength = " + readUnsignedShort2);
                                    byte[] bArr = new byte[readUnsignedShort2];
                                    dataInputStream.readFully(bArr);
                                    arrayList.add(new String(bArr));
                                    i++;
                                } catch (Throwable th4) {
                                    th = th4;
                                }
                            }
                            dataInputStream.readUnsignedShort();
                            bj.m596a(dataInputStream);
                            list = arrayList;
                        }
                    } catch (Throwable th32) {
                        th2 = th32;
                        arrayList = null;
                        th = th2;
                        try {
                            bh.m590b("Error when loading persistent file", th);
                            bj.m596a(dataInputStream);
                            list = arrayList;
                            return list;
                        } catch (Throwable th5) {
                            th32 = th5;
                            bj.m596a(dataInputStream);
                            throw th32;
                        }
                    }
                } catch (Throwable th6) {
                    th32 = th6;
                    dataInputStream = null;
                    bj.m596a(dataInputStream);
                    throw th32;
                }
            } else {
                bh.m584a(5, "Agent cache file doesn't exist.");
                arrayList = null;
                list = arrayList;
            }
        }
        return list;
    }

    private synchronized boolean m636a(String str, List list) {
        Closeable dataOutputStream;
        boolean z;
        Throwable th;
        boolean z2 = false;
        synchronized (this) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                bh.m584a(6, "saveToFile(byte[], ID) running on the MAIN thread!");
            }
            File fileStreamPath = am.f442a.f443b.getFileStreamPath(".FlurrySenderIndex.info." + str);
            try {
                if (bd.m579a(fileStreamPath)) {
                    dataOutputStream = new DataOutputStream(new FileOutputStream(fileStreamPath));
                    try {
                        dataOutputStream.writeShort(list.size());
                        for (int i = 0; i < list.size(); i++) {
                            byte[] bytes = ((String) list.get(i)).getBytes();
                            int length = bytes.length;
                            bh.m584a(4, "write iter " + i + " dataLength = " + length);
                            dataOutputStream.writeShort(length);
                            dataOutputStream.write(bytes);
                        }
                        dataOutputStream.writeShort(0);
                        z = true;
                        bj.m596a(dataOutputStream);
                    } catch (Throwable th2) {
                        th = th2;
                        try {
                            bh.m590b("", th);
                            bj.m596a(dataOutputStream);
                            z = false;
                            z2 = z;
                            return z2;
                        } catch (Throwable th3) {
                            th = th3;
                            bj.m596a(dataOutputStream);
                            throw th;
                        }
                    }
                    z2 = z;
                } else {
                    bj.m596a(null);
                }
            } catch (Throwable th4) {
                th = th4;
                dataOutputStream = null;
                bj.m596a(dataOutputStream);
                throw th;
            }
        }
        return z2;
    }
}
