package ru.klkvsk.fenom;

import com.intellij.lang.Language;

public class FenomLanguage extends Language {
    public static final FenomLanguage INSTANCE = new FenomLanguage();

    private FenomLanguage() {
        super("Fenom");
    }
}