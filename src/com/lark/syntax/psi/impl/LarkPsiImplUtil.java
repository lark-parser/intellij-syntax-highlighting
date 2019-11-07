package com.lark.syntax.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.tree.TokenSet;
import com.lark.syntax.LarkLiteralRegexEscaper;
import com.lark.syntax.psi.*;
import org.jetbrains.annotations.NotNull;

public class LarkPsiImplUtil {
    private final static TokenSet IDENTIFIER = TokenSet.create(LarkTypes.TOKEN, LarkTypes.RULE);

    private static String stripRuleName(String raw) {
        if (raw.startsWith("!")) {
            raw = raw.substring(1);
        }
        if (raw.startsWith("?")) {
            raw = raw.substring(1);
        }
        return raw;
    }

    public static String getDefName(LarkRuleDef def) {
        ASTNode node = def.getNode().findChildByType(LarkTypes.RULE);
        assert node != null;
        return stripRuleName(node.getText());
    }

    public static String getDefName(LarkTokenDef def) {
        ASTNode node = def.getNode().findChildByType(LarkTypes.TOKEN);
        assert node != null;
        return stripRuleName(node.getText());
    }

    public static String getDefName(LarkImportStatement stmt) {
        ASTNode node = stmt.getNode().findChildByType(IDENTIFIER);
        if (node != null) {
            return node.getText();
        } else if (stmt.getImportArgs() != null) {
            return stmt.getImportArgs().getDefName();
        } else {
            return null;
        }
    }

    public static String getDefName(LarkImportArgs importArgs) {
        ASTNode node = importArgs.getNode().getLastChildNode();
        if (node.getElementType().equals(LarkTypes.RULE) || node.getElementType().equals(LarkTypes.TOKEN)) {
            return node.getText();
        } else {
            return null;
        }
    }

    public static String[] getDefNames(LarkDeclareStatement declareStatement) {
        ASTNode[] children = declareStatement.getNode().getChildren(IDENTIFIER);
        String[] out = new String[children.length];
        int i = 0;
        for (ASTNode n : children) {
            if (n.getElementType().equals(LarkTypes.TOKEN)) {
                out[i++] = n.getText();
            }
        }
        return out;
    }

    public static PsiElement setName(LarkTokenDef def, String newName) {
        ASTNode nameNode = def.getNode().findChildByType(LarkTypes.TOKEN);
        assert nameNode != null;
        LarkTokenDef newDef = LarkElementFactory.createElement(def.getProject(), newName);
        ASTNode newNameNode = newDef.getFirstChild().getNode();
        def.getNode().replaceChild(nameNode, newNameNode);
        return def;
    }

    public static PsiElement setName(LarkRuleDef def, String newName) {
        ASTNode nameNode = def.getNode().findChildByType(LarkTypes.RULE);
        assert nameNode != null;
        LarkRuleDef newDef = LarkElementFactory.createElement(def.getProject(), newName);
        ASTNode newNameNode = newDef.getFirstChild().getNode();
        def.getNode().replaceChild(nameNode, newNameNode);
        return def;
    }

    public static PsiElement getNameIdentifier(LarkTokenDef def) {
        ASTNode node = def.getNode().findChildByType(LarkTypes.TOKEN);
        assert node != null;
        return node.getPsi();
    }

    public static PsiElement getNameIdentifier(LarkRuleDef def) {
        ASTNode node = def.getNode().findChildByType(LarkTypes.RULE);
        assert node != null;
        return node.getPsi();
    }

    public static TextRange getRegexRange(LarkAtomLitRegex regex) {
        return TextRange.create(1, regex.getText().lastIndexOf('/'));
    }

    @NotNull
    public static LarkLiteralRegexEscaper createLiteralTextEscaper(LarkAtomLitRegex regex) {
        return new LarkLiteralRegexEscaper(regex);
    }

    public static LarkAtomLitRegex updateText(LarkAtomLitRegex regex, @NotNull String var1) {
        System.out.println("updateText: " + var1);
        return regex;
    }

    public static boolean isValidHost(LarkAtomLitRegex regex) {
        return true;
    }
}
