package com.lark.syntax.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.lark.syntax.psi.*;

public class LarkPsiImplUtil {
    private final static TokenSet IDENTIFIER = TokenSet.create(LarkTypes.TOKEN, LarkTypes.RULE);

    public static String getDefName(LarkRuleDef def) {
        ASTNode node = def.getNode().findChildByType(LarkTypes.RULE);
        if (node != null) {
            return node.getText();
        } else {
            return null;
        }
    }

    public static String getDefName(LarkTokenDef def) {
        ASTNode node = def.getNode().findChildByType(LarkTypes.TOKEN);
        if (node != null) {
            return node.getText();
        } else {
            return null;
        }
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

}
