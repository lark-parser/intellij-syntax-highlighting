package com.lark.syntax;

import com.intellij.psi.InjectedLanguagePlaces;
import com.intellij.psi.LanguageInjector;
import com.intellij.psi.PsiLanguageInjectionHost;
import org.jetbrains.annotations.NotNull;

public class LarkInjector implements LanguageInjector {
    @Override
    public void getLanguagesToInject(@NotNull PsiLanguageInjectionHost psiLanguageInjectionHost, @NotNull InjectedLanguagePlaces injectedLanguagePlaces) {
        System.out.println(psiLanguageInjectionHost);
    }

}
