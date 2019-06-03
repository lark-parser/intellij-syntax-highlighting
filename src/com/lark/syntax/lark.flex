package com.lark.syntax;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.lark.syntax.psi.LarkTypes;
import com.intellij.psi.TokenType;

%%

%class LarkLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}

NEWLINE = (\r|\n|\r\n)
WHITE_SPACE = [ \t\f]+

COMMENT = \/\/[^\r\n]*

RULE = \!?\??_?[a-z][_a-z0-9]*
TOKEN = _?[A-Z][_A-Z0-9]*
STRING = \" ([^\"\\\n\r]|\\[^\n\r])* \" i?
REGEXP = \/ ([^\/\\\n\r]|\\[^\n\r])+ \/ [imslux]*

%%

<YYINITIAL> ":"                 { return LarkTypes.COLON; }
<YYINITIAL> "."                 { return LarkTypes.DOT; }
<YYINITIAL> ".."                { return LarkTypes.DOT_DOT; }
<YYINITIAL> "%ignore"           { return LarkTypes.IGNORE; }
<YYINITIAL> "%import"           { return LarkTypes.IMPORT; }
<YYINITIAL> "%declare"          { return LarkTypes.DECLARE; }
<YYINITIAL> "->"                { return LarkTypes.ARROW; }
<YYINITIAL> "~"                 { return LarkTypes.TILDE; }
<YYINITIAL> "("                 { return LarkTypes.OP; }
<YYINITIAL> ")"                 { return LarkTypes.CP; }
<YYINITIAL> "["                 { return LarkTypes.OB; }
<YYINITIAL> "]"                 { return LarkTypes.CB; }
<YYINITIAL> "+"                 { return LarkTypes.QUANT; }
<YYINITIAL> "*"                 { return LarkTypes.QUANT; }
<YYINITIAL> "?"                 { return LarkTypes.QUANT; }
<YYINITIAL> "|"                 { return LarkTypes.VBAR; }
<YYINITIAL> {RULE}              { return LarkTypes.RULE; }
<YYINITIAL> {TOKEN}             { return LarkTypes.TOKEN; }
<YYINITIAL> {STRING}            { return LarkTypes.STRING; }
<YYINITIAL> {REGEXP}            { return LarkTypes.REGEXP; }
<YYINITIAL> {COMMENT}           { return LarkTypes.COMMENT; }
<YYINITIAL> {WHITE_SPACE}       { return TokenType.WHITE_SPACE; }
<YYINITIAL> {NEWLINE}           { return LarkTypes.NEWLINE; }
//<<EOF>>                         { return LarkTypes.NEWLINE; }
