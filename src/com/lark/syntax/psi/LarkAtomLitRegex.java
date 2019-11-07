// This is a generated file. Not intended for manual editing.
package com.lark.syntax.psi;

import java.util.List;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.lark.syntax.LarkLiteralRegexEscaper;

public interface LarkAtomLitRegex extends PsiLanguageInjectionHost {

    @NotNull
    LarkLiteralRegexEscaper createLiteralTextEscaper();

    LarkAtomLitRegex updateText(@NotNull String var1);

    boolean isValidHost();

}
