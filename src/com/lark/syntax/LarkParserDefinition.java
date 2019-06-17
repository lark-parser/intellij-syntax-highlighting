package com.lark.syntax;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import com.lark.syntax.parser.LarkParser;
import com.lark.syntax.psi.LarkFile;
import com.lark.syntax.psi.LarkTypes;
import org.jetbrains.annotations.NotNull;

public class LarkParserDefinition implements ParserDefinition {
    public static final TokenSet COMMENTS = TokenSet.create(LarkTypes.COMMENT);
    public static final TokenSet STRINGS = TokenSet.create(LarkTypes.STRING, LarkTypes.REGEXP);

    public static final IFileElementType FILE = new IFileElementType(LarkLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new LarkLexerAdapter();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new LarkParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return STRINGS;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode astNode) {
        System.out.println("---------------------------------");
        System.out.println(astNode);
        System.out.println('\'' + astNode.getText() + '\'');
        return LarkTypes.Factory.createElement(astNode);
    }

    @Override
    public PsiFile createFile(FileViewProvider fileViewProvider) {
        return new LarkFile(fileViewProvider);
    }
}
