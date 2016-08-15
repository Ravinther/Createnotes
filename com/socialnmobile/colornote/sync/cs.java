package com.socialnmobile.colornote.sync;

import com.socialnmobile.colornote.C0311h;
import com.socialnmobile.colornote.data.NoteColumns.NoteMajorColumns;
import com.socialnmobile.colornote.data.NoteColumns.NoteMinorColumns;
import com.socialnmobile.colornote.sync.p018b.C0361e;

public final class cs {
    public static final cs f1643a;

    static {
        f1643a = new cs();
    }

    public static void m1973a(cm cmVar, C0361e c0361e) {
        dk dkVar = dk.f1737a;
        dk.m1995b(cmVar.f1627a, c0361e);
        cy cyVar = cy.f1688d;
        cw cwVar = cmVar.f1628b;
        try {
            Integer num;
            int intValue;
            Number g;
            cv cvVar;
            ct ctVar;
            String d;
            bg bgVar;
            cwVar.f1661g.m2008a(Integer.valueOf(c0361e.m1837c("color").intValue()));
            cwVar.f1662h.m2008a((bg) c0361e.m1831a("created", bg.f1556d));
            cwVar.f1656b.m2008a(Integer.valueOf(c0361e.m1837c("flags").intValue()));
            cwVar.f1657c.m2008a(Integer.valueOf(c0361e.m1837c("folder").intValue()));
            cwVar.f1663i.m2008a((bg) c0361e.m1831a("modified_minor", bg.f1556d));
            String str = "state";
            String h = c0361e.m1842h(str);
            if (h != null) {
                num = (Integer) cyVar.f1690b.get(h);
                if (num != null) {
                    intValue = num.intValue();
                    cwVar.f1659e.m2008a(Integer.valueOf(intValue));
                    str = "state";
                    h = c0361e.m1842h(str);
                    if (h != null) {
                        num = (Integer) cyVar.f1691c.get(h);
                        if (num != null) {
                            intValue = num.intValue();
                            cwVar.f1655a.m2008a(Integer.valueOf(intValue));
                            str = NoteMinorColumns.TYPE;
                            h = c0361e.m1842h(str);
                            if (h != null) {
                                num = (Integer) cyVar.f1689a.get(h);
                                if (num != null) {
                                    intValue = num.intValue();
                                    cwVar.f1660f.m2008a(Integer.valueOf(intValue));
                                    g = c0361e.m1841g("version");
                                    if (g != null) {
                                        cwVar.f1664j.m2008a(Integer.valueOf(g.intValue()));
                                    }
                                    cy.m1980a(cwVar.f1665k, c0361e, "reminder");
                                    cvVar = cv.f1654c;
                                    ctVar = cmVar.f1629c;
                                    d = c0361e.m1838d("content");
                                    ctVar.f1645b.m2008a(d);
                                    str = c0361e.m1838d(NoteMajorColumns.TITLE);
                                    ctVar.f1644a.m2008a(str);
                                    bgVar = (bg) c0361e.m1831a("modified", bg.f1556d);
                                    ctVar.f1647d.m2008a(bgVar);
                                    ctVar.f1646c.m2008a(Integer.valueOf(cv.m1974a(c0361e, "locked")));
                                    if (d == null) {
                                        C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "content is null", c0361e);
                                    }
                                    if (str == null) {
                                        C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "title is null", c0361e);
                                    }
                                    if (bgVar != null) {
                                        C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "modified is null", c0361e);
                                    }
                                }
                            }
                            intValue = c0361e.m1837c(str).intValue();
                            cwVar.f1660f.m2008a(Integer.valueOf(intValue));
                            g = c0361e.m1841g("version");
                            if (g != null) {
                                cwVar.f1664j.m2008a(Integer.valueOf(g.intValue()));
                            }
                            cy.m1980a(cwVar.f1665k, c0361e, "reminder");
                            cvVar = cv.f1654c;
                            ctVar = cmVar.f1629c;
                            d = c0361e.m1838d("content");
                            ctVar.f1645b.m2008a(d);
                            str = c0361e.m1838d(NoteMajorColumns.TITLE);
                            ctVar.f1644a.m2008a(str);
                            bgVar = (bg) c0361e.m1831a("modified", bg.f1556d);
                            ctVar.f1647d.m2008a(bgVar);
                            ctVar.f1646c.m2008a(Integer.valueOf(cv.m1974a(c0361e, "locked")));
                            if (d == null) {
                                C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "content is null", c0361e);
                            }
                            if (str == null) {
                                C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "title is null", c0361e);
                            }
                            if (bgVar != null) {
                                C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "modified is null", c0361e);
                            }
                        }
                    }
                    intValue = c0361e.m1837c(str).intValue();
                    cwVar.f1655a.m2008a(Integer.valueOf(intValue));
                    str = NoteMinorColumns.TYPE;
                    h = c0361e.m1842h(str);
                    if (h != null) {
                        num = (Integer) cyVar.f1689a.get(h);
                        if (num != null) {
                            intValue = num.intValue();
                            cwVar.f1660f.m2008a(Integer.valueOf(intValue));
                            g = c0361e.m1841g("version");
                            if (g != null) {
                                cwVar.f1664j.m2008a(Integer.valueOf(g.intValue()));
                            }
                            cy.m1980a(cwVar.f1665k, c0361e, "reminder");
                            cvVar = cv.f1654c;
                            ctVar = cmVar.f1629c;
                            d = c0361e.m1838d("content");
                            ctVar.f1645b.m2008a(d);
                            str = c0361e.m1838d(NoteMajorColumns.TITLE);
                            ctVar.f1644a.m2008a(str);
                            bgVar = (bg) c0361e.m1831a("modified", bg.f1556d);
                            ctVar.f1647d.m2008a(bgVar);
                            ctVar.f1646c.m2008a(Integer.valueOf(cv.m1974a(c0361e, "locked")));
                            if (d == null) {
                                C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "content is null", c0361e);
                            }
                            if (str == null) {
                                C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "title is null", c0361e);
                            }
                            if (bgVar != null) {
                                C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "modified is null", c0361e);
                            }
                        }
                    }
                    intValue = c0361e.m1837c(str).intValue();
                    cwVar.f1660f.m2008a(Integer.valueOf(intValue));
                    g = c0361e.m1841g("version");
                    if (g != null) {
                        cwVar.f1664j.m2008a(Integer.valueOf(g.intValue()));
                    }
                    cy.m1980a(cwVar.f1665k, c0361e, "reminder");
                    cvVar = cv.f1654c;
                    ctVar = cmVar.f1629c;
                    d = c0361e.m1838d("content");
                    ctVar.f1645b.m2008a(d);
                    str = c0361e.m1838d(NoteMajorColumns.TITLE);
                    ctVar.f1644a.m2008a(str);
                    bgVar = (bg) c0361e.m1831a("modified", bg.f1556d);
                    ctVar.f1647d.m2008a(bgVar);
                    ctVar.f1646c.m2008a(Integer.valueOf(cv.m1974a(c0361e, "locked")));
                    if (d == null) {
                        C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "content is null", c0361e);
                    }
                    if (str == null) {
                        C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "title is null", c0361e);
                    }
                    if (bgVar != null) {
                        C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "modified is null", c0361e);
                    }
                }
            }
            intValue = c0361e.m1837c(str).intValue();
            cwVar.f1659e.m2008a(Integer.valueOf(intValue));
            str = "state";
            h = c0361e.m1842h(str);
            if (h != null) {
                num = (Integer) cyVar.f1691c.get(h);
                if (num != null) {
                    intValue = num.intValue();
                    cwVar.f1655a.m2008a(Integer.valueOf(intValue));
                    str = NoteMinorColumns.TYPE;
                    h = c0361e.m1842h(str);
                    if (h != null) {
                        num = (Integer) cyVar.f1689a.get(h);
                        if (num != null) {
                            intValue = num.intValue();
                            cwVar.f1660f.m2008a(Integer.valueOf(intValue));
                            g = c0361e.m1841g("version");
                            if (g != null) {
                                cwVar.f1664j.m2008a(Integer.valueOf(g.intValue()));
                            }
                            cy.m1980a(cwVar.f1665k, c0361e, "reminder");
                            cvVar = cv.f1654c;
                            ctVar = cmVar.f1629c;
                            d = c0361e.m1838d("content");
                            ctVar.f1645b.m2008a(d);
                            str = c0361e.m1838d(NoteMajorColumns.TITLE);
                            ctVar.f1644a.m2008a(str);
                            bgVar = (bg) c0361e.m1831a("modified", bg.f1556d);
                            ctVar.f1647d.m2008a(bgVar);
                            ctVar.f1646c.m2008a(Integer.valueOf(cv.m1974a(c0361e, "locked")));
                            if (d == null) {
                                C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "content is null", c0361e);
                            }
                            if (str == null) {
                                C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "title is null", c0361e);
                            }
                            if (bgVar != null) {
                                C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "modified is null", c0361e);
                            }
                        }
                    }
                    intValue = c0361e.m1837c(str).intValue();
                    cwVar.f1660f.m2008a(Integer.valueOf(intValue));
                    g = c0361e.m1841g("version");
                    if (g != null) {
                        cwVar.f1664j.m2008a(Integer.valueOf(g.intValue()));
                    }
                    cy.m1980a(cwVar.f1665k, c0361e, "reminder");
                    cvVar = cv.f1654c;
                    ctVar = cmVar.f1629c;
                    d = c0361e.m1838d("content");
                    ctVar.f1645b.m2008a(d);
                    str = c0361e.m1838d(NoteMajorColumns.TITLE);
                    ctVar.f1644a.m2008a(str);
                    bgVar = (bg) c0361e.m1831a("modified", bg.f1556d);
                    ctVar.f1647d.m2008a(bgVar);
                    ctVar.f1646c.m2008a(Integer.valueOf(cv.m1974a(c0361e, "locked")));
                    if (d == null) {
                        C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "content is null", c0361e);
                    }
                    if (str == null) {
                        C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "title is null", c0361e);
                    }
                    if (bgVar != null) {
                        C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "modified is null", c0361e);
                    }
                }
            }
            intValue = c0361e.m1837c(str).intValue();
            cwVar.f1655a.m2008a(Integer.valueOf(intValue));
            str = NoteMinorColumns.TYPE;
            h = c0361e.m1842h(str);
            if (h != null) {
                num = (Integer) cyVar.f1689a.get(h);
                if (num != null) {
                    intValue = num.intValue();
                    cwVar.f1660f.m2008a(Integer.valueOf(intValue));
                    g = c0361e.m1841g("version");
                    if (g != null) {
                        cwVar.f1664j.m2008a(Integer.valueOf(g.intValue()));
                    }
                    cy.m1980a(cwVar.f1665k, c0361e, "reminder");
                    cvVar = cv.f1654c;
                    ctVar = cmVar.f1629c;
                    d = c0361e.m1838d("content");
                    ctVar.f1645b.m2008a(d);
                    str = c0361e.m1838d(NoteMajorColumns.TITLE);
                    ctVar.f1644a.m2008a(str);
                    bgVar = (bg) c0361e.m1831a("modified", bg.f1556d);
                    ctVar.f1647d.m2008a(bgVar);
                    ctVar.f1646c.m2008a(Integer.valueOf(cv.m1974a(c0361e, "locked")));
                    if (d == null) {
                        C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "content is null", c0361e);
                    }
                    if (str == null) {
                        C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "title is null", c0361e);
                    }
                    if (bgVar != null) {
                        C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "modified is null", c0361e);
                    }
                }
            }
            intValue = c0361e.m1837c(str).intValue();
            cwVar.f1660f.m2008a(Integer.valueOf(intValue));
            g = c0361e.m1841g("version");
            if (g != null) {
                cwVar.f1664j.m2008a(Integer.valueOf(g.intValue()));
            }
            cy.m1980a(cwVar.f1665k, c0361e, "reminder");
            cvVar = cv.f1654c;
            ctVar = cmVar.f1629c;
            try {
                d = c0361e.m1838d("content");
                ctVar.f1645b.m2008a(d);
                str = c0361e.m1838d(NoteMajorColumns.TITLE);
                ctVar.f1644a.m2008a(str);
                bgVar = (bg) c0361e.m1831a("modified", bg.f1556d);
                ctVar.f1647d.m2008a(bgVar);
                ctVar.f1646c.m2008a(Integer.valueOf(cv.m1974a(c0361e, "locked")));
                if (d == null) {
                    C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "content is null", c0361e);
                }
                if (str == null) {
                    C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "title is null", c0361e);
                }
                if (bgVar != null) {
                    C0311h.f1370a.m1622a("NoteMajorFormatV1.parse problem", "modified is null", c0361e);
                }
            } catch (Throwable e) {
                throw new cl(e);
            } catch (Throwable e2) {
                throw new cl(e2);
            }
        } catch (Throwable e22) {
            throw new cl(e22);
        } catch (Throwable e222) {
            throw new cl(e222);
        } catch (Throwable e2222) {
            throw new cl(e2222);
        }
    }
}
