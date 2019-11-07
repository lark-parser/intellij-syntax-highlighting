package com.lark.syntax.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiReference;
import com.lark.syntax.LarkReference;
import com.lark.syntax.psi.LarkNameReference;
import org.jetbrains.annotations.NotNull;

public class LarkNameReferenceImpl extends ASTWrapperPsiElement implements LarkNameReference {
    public LarkNameReferenceImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public PsiReference getReference() {
        return new LarkReference(this);
    }

    @Override
    public TextRange getTextRange() {
        return super.getTextRange();
    }
}
