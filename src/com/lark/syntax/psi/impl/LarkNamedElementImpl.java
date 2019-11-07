package com.lark.syntax.psi.impl;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiReference;
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry;
import com.lark.syntax.psi.LarkNamedElement;
import org.jetbrains.annotations.NotNull;

public abstract class LarkNamedElementImpl extends ASTWrapperPsiElement implements LarkNamedElement {
    public LarkNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
