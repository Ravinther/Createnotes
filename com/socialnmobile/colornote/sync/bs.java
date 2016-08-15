package com.socialnmobile.colornote.sync;

public final class bs extends bd {
    public final String f1580a;
    public String f1581b;

    public bs(String str, String str2) {
        this.f1580a = str;
        this.f1581b = str2;
    }

    public bs(String str) {
        this(str, null);
    }

    public final String toString() {
        return "EmailCredential [email=" + this.f1580a + ", password=" + this.f1581b + "]";
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = ((this.f1580a == null ? 0 : this.f1580a.hashCode()) + 31) * 31;
        if (this.f1581b != null) {
            i = this.f1581b.hashCode();
        }
        return hashCode + i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        bs bsVar = (bs) obj;
        if (this.f1580a == null) {
            if (bsVar.f1580a != null) {
                return false;
            }
        } else if (!this.f1580a.equals(bsVar.f1580a)) {
            return false;
        }
        if (this.f1581b == null) {
            if (bsVar.f1581b != null) {
                return false;
            }
            return true;
        } else if (this.f1581b.equals(bsVar.f1581b)) {
            return true;
        } else {
            return false;
        }
    }
}
