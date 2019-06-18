package com.lark.syntax;

import com.intellij.lexer.FlexAdapter;

public class LarkLexerAdapter extends FlexAdapter {
    public LarkLexerAdapter() {
        super(new LarkLexer(null));
    }
}
