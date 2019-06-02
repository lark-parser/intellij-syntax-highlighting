package com.lark.syntax;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.lark.syntax.psi.LarkTypes;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class LarkSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("LARK_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey ASSIGN = createTextAttributesKey("LARK_ASSIGN",
            DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey ALIAS = createTextAttributesKey("LARK_ALIAS",
            DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey QUANTIFIER = createTextAttributesKey("LARK_QUANTIFIER",
            DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey STRING = createTextAttributesKey("LARK_STRING",
            DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey REGEXP = createTextAttributesKey("LARK_REGEXP",
            DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey RULE = createTextAttributesKey("LARK_RULE",
            DefaultLanguageHighlighterColors.LOCAL_VARIABLE);
    public static final TextAttributesKey TOKEN = createTextAttributesKey("LARK_TOKEN",
            DefaultLanguageHighlighterColors.GLOBAL_VARIABLE);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("LARK_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARS = createTextAttributesKey("LARK_BAD_CHARS",
            HighlighterColors.BAD_CHARACTER);
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] ASSIGN_KEYS = new TextAttributesKey[]{ASSIGN};
    private static final TextAttributesKey[] ALIAS_KEYS = new TextAttributesKey[]{ALIAS};
    private static final TextAttributesKey[] QUANTIFIER_KEYS = new TextAttributesKey[]{QUANTIFIER};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] REGEXP_KEYS = new TextAttributesKey[]{REGEXP};
    private static final TextAttributesKey[] RULE_KEYS = new TextAttributesKey[]{RULE};
    private static final TextAttributesKey[] TOKEN_KEYS = new TextAttributesKey[]{TOKEN};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARS};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new LarkLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(LarkTypes.COLON)) {
            return ASSIGN_KEYS;
        } else if (tokenType.equals(LarkTypes.IGNORE) ||
                tokenType.equals(LarkTypes.DECLARE) ||
                tokenType.equals(LarkTypes.IMPORT)) {
            return KEYWORD_KEYS;
        } else if (tokenType.equals(LarkTypes.QUANT)) {
            return QUANTIFIER_KEYS;
        } else if (tokenType.equals(LarkTypes.STRING)) {
            return STRING_KEYS;
        } else if (tokenType.equals(LarkTypes.REGEXP)) {
            return REGEXP_KEYS;
        } else if (tokenType.equals(LarkTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(LarkTypes.RULE)) {
            return RULE_KEYS;
        } else if (tokenType.equals(LarkTypes.TOKEN)) {
            return TOKEN_KEYS;
        } else if (tokenType.equals(LarkTypes.ARROW)) {
            return ALIAS_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else if (tokenType.equals(TokenType.WHITE_SPACE) ||
                tokenType.equals(LarkTypes.NEWLINE) ||
                tokenType.equals(LarkTypes.OP) ||
                tokenType.equals(LarkTypes.CP) ||
                tokenType.equals(LarkTypes.OB) ||
                tokenType.equals(LarkTypes.CB)
        ) {
            return EMPTY_KEYS;
        } else {
            System.out.println(tokenType);
            return EMPTY_KEYS;
        }
    }
}
