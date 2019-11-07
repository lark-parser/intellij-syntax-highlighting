package com.lark.syntax;

import com.intellij.lang.injection.MultiHostInjector;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.psi.PsiElement;
import com.jetbrains.python.codeInsight.regexp.PythonRegexpLanguage;
import com.lark.syntax.psi.LarkAtomLitRegex;
import com.lark.syntax.psi.impl.LarkPsiImplUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

public class LarkRegexInjector implements MultiHostInjector {
    @Override
    public void getLanguagesToInject(@NotNull MultiHostRegistrar registrar, @NotNull PsiElement psiElement) {
        registrar.startInjecting(PythonRegexpLanguage.INSTANCE).addPlace(null, null, (LarkAtomLitRegex) psiElement,
                LarkPsiImplUtil.getRegexRange((LarkAtomLitRegex) psiElement)).doneInjecting();
    }

    @NotNull
    @Override
    public List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
        return Collections.singletonList(LarkAtomLitRegex.class);
    }
}
