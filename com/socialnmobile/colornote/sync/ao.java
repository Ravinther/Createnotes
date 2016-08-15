package com.socialnmobile.colornote.sync;

import android.net.Uri;
import com.socialnmobile.util.p011b.p017b.C0462e;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpRequest;
import org.apache.http.RequestLine;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public final class ao extends am {
    final String f1494b;
    final String f1495c;
    final bg f1496d;

    public ao(String str, bg bgVar, byte[] bArr) {
        this.f1494b = str;
        this.f1496d = bgVar;
        this.f1495c = (String) C0462e.f2255b.m1782c(bArr);
    }

    public final void m1793a(HttpRequest httpRequest) {
        dg dgVar = new dg();
        try {
            RequestLine requestLine = httpRequest.getRequestLine();
            Uri parse = Uri.parse(requestLine.getUri());
            String path = parse.getPath();
            String query = parse.getQuery();
            if (query != null) {
                path = path + "?" + query;
            }
            path = ((requestLine.getMethod() + " ") + path) + " ";
            List linkedList = new LinkedList();
            linkedList.add(new BasicNameValuePair(AccountColumns.AUTH_TOKEN, this.f1494b));
            httpRequest.addHeader("X-COLORNOTE-TOKEN", this.f1494b + ':' + dg.m1993a(m1795a(), path + URLEncodedUtils.format(linkedList, "utf-8").replace("+", "%20")));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public final byte[] m1795a() {
        try {
            return (byte[]) C0462e.f2255b.m1783d(this.f1495c);
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public final boolean equals(Object obj) {
        try {
            ao aoVar = (ao) obj;
            if (this.f1494b.equals(aoVar.f1494b) && this.f1495c.equals(aoVar.f1495c) && this.f1496d.equals(aoVar.f1496d)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public final boolean m1794a(Date date) {
        return new Date(this.f1496d.f1558a).before(date);
    }
}
