package com.socialnmobile.colornote.sync.p015a;

import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

/* renamed from: com.socialnmobile.colornote.sync.a.f */
final class C0340f extends HttpEntityWrapper {
    public C0340f(HttpEntity httpEntity) {
        super(httpEntity);
    }

    public final InputStream getContent() {
        return new GZIPInputStream(this.wrappedEntity.getContent());
    }
}
