package com.lark.syntax;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

public class LarkLexerAdapter extends FlexAdapter {
    public LarkLexerAdapter() {
        super(new LarkLexer((Reader) null));
    }
}
