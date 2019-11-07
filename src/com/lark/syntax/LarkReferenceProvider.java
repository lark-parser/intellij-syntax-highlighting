package com.lark.syntax;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.util.ProcessingContext;
import com.lark.syntax.psi.LarkNameReference;
import org.jetbrains.annotations.NotNull;

public class LarkReferenceProvider extends PsiReferenceProvider {
    @NotNull
    @Override
    public PsiReference[] getReferencesByElement(@NotNull PsiElement psiElement, @NotNull ProcessingContext processingContext) {
        if (psiElement instanceof LarkNameReference) {
            return new PsiReference[]{
                    new LarkReference((LarkNameReference) psiElement)
            };
        } else {
            return PsiReference.EMPTY_ARRAY;
        }
    }
}
