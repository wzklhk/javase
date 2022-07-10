package com.example.i18n.common.util;

import gnu.gettext.GettextResource;

import java.util.Locale;
import java.util.ResourceBundle;

public class Translation {
    private ResourceBundle bundle;

    public Translation() {
    }

    public static Translation init(Locale locale) {
        ResourceBundle bundle = ResourceBundle.getBundle("i18n/message", locale);
        Translation t = new Translation();
        t.setBundle(bundle);
        return t;
    }

    public String gettext(String msgid) {
        return GettextResource.gettext(bundle, msgid);
    }

    public String _x(String msgid, String msgctxt) {
        return GettextResource.pgettext(bundle, msgctxt, msgid);
    }

    public String _n(String msgid, String msgid_plural, long n) {
        return GettextResource.ngettext(bundle, msgid, msgid_plural, n);
    }

    public String _nx(String msgid, String plural, long n, String context) {
        return GettextResource.npgettext(bundle, context, msgid, plural, n);
    }

    public ResourceBundle getBundle() {
        return bundle;
    }

    public void setBundle(ResourceBundle bundle) {
        this.bundle = bundle;
    }
}
