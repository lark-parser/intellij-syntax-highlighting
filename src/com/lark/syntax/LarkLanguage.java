package com.lark.syntax;

import com.intellij.lang.Language;

public class LarkLanguage extends Language {
    public static final LarkLanguage INSTANCE = new LarkLanguage();

    private LarkLanguage() {
        super("Lark");
    }
}
