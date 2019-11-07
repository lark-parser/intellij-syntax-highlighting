// This is a generated file. Not intended for manual editing.
package com.lark.syntax.psi.impl;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;

import static com.lark.syntax.psi.LarkTypes.*;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.lark.syntax.psi.*;
import com.lark.syntax.LarkLiteralRegexEscaper;

public class LarkAtomLitRegexImpl extends ASTWrapperPsiElement implements LarkAtomLitRegex {

    public LarkAtomLitRegexImpl(@NotNull ASTNode node) {
        super(node);
    }

    public void accept(@NotNull LarkVisitor visitor) {
        visitor.visitAtomLitRegex(this);
    }

    public void accept(@NotNull PsiElementVisitor visitor) {
        if (visitor instanceof LarkVisitor) accept((LarkVisitor) visitor);
        else super.accept(visitor);
    }

    @Override
    @NotNull
    public LarkLiteralRegexEscaper createLiteralTextEscaper() {
        return LarkPsiImplUtil.createLiteralTextEscaper(this);
    }

    @Override
    public LarkAtomLitRegex updateText(@NotNull String var1) {
        return LarkPsiImplUtil.updateText(this, var1);
    }

    @Override
    public boolean isValidHost() {
        return LarkPsiImplUtil.isValidHost(this);
    }

}
