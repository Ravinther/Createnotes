package com.socialnmobile.colornote.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.socialnmobile.colornote.data.v */
public final class C0232v {
    public SQLiteDatabase f1027a;
    ReentrantLock f1028b;

    public C0232v(SQLiteDatabase sQLiteDatabase) {
        this.f1027a = sQLiteDatabase;
        this.f1028b = new ReentrantLock(true);
    }

    public final void m1081a(String str) {
        this.f1028b.lock();
        try {
            this.f1027a.execSQL(str);
        } finally {
            this.f1028b.unlock();
        }
    }

    public final int m1077a(String str, Object[] objArr) {
        this.f1028b.lock();
        try {
            this.f1027a.execSQL(str, objArr);
            int longForQuery = (int) DatabaseUtils.longForQuery(this.f1027a, "SELECT changes()", null);
            return longForQuery;
        } finally {
            this.f1028b.unlock();
        }
    }

    public final long m1082b(String str) {
        this.f1028b.lock();
        SQLiteStatement compileStatement = this.f1027a.compileStatement(str);
        try {
            long executeInsert = compileStatement.executeInsert();
            return executeInsert;
        } finally {
            compileStatement.close();
            this.f1028b.unlock();
        }
    }

    public final long m1078a(String str, String str2, ContentValues contentValues) {
        this.f1028b.lock();
        try {
            long insert = this.f1027a.insert(str, str2, contentValues);
            return insert;
        } finally {
            this.f1028b.unlock();
        }
    }

    public final long m1083b(String str, String str2, ContentValues contentValues) {
        this.f1028b.lock();
        try {
            long insertOrThrow = this.f1027a.insertOrThrow(str, str2, contentValues);
            return insertOrThrow;
        } finally {
            this.f1028b.unlock();
        }
    }

    public final int m1075a(String str, ContentValues contentValues, String str2, String[] strArr) {
        this.f1028b.lock();
        try {
            int update = this.f1027a.update(str, contentValues, str2, strArr);
            return update;
        } finally {
            this.f1028b.unlock();
        }
    }

    public final int m1076a(String str, String str2, String[] strArr) {
        this.f1028b.lock();
        try {
            int delete = this.f1027a.delete(str, str2, strArr);
            return delete;
        } finally {
            this.f1028b.unlock();
        }
    }

    public final Cursor m1079a(String str, String[] strArr) {
        return this.f1027a.rawQuery(str, strArr);
    }

    public final Cursor m1080a(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        return this.f1027a.query(str, strArr, str2, strArr2, null, null, str3);
    }
}
