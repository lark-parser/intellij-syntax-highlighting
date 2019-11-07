package com.lark.syntax;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import com.lark.syntax.psi.LarkFile;
import com.lark.syntax.psi.LarkTypes;
import com.lark.syntax.psi.impl.LarkAtomRefImpl;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class LarkCompletionContributor extends CompletionContributor {
    public LarkCompletionContributor() {
        extend(CompletionType.BASIC,
                PlatformPatterns.psiElement(LarkTypes.TOKEN).withLanguage(LarkLanguage.INSTANCE),
                new CompletionProvider<CompletionParameters>() {
                    @Override
                    public void addCompletions(@NotNull CompletionParameters cP, @NotNull ProcessingContext pC, @NotNull CompletionResultSet cRS) {
                        LarkCompletionContributor.this.findCompletions(cP, pC, cRS);
                    }
                });
    }

    private void findCompletions(@NotNull CompletionParameters completionParameters, @NotNull ProcessingContext processingContext, @NotNull CompletionResultSet completionResultSet) {
        LarkFile file = (LarkFile) completionParameters.getOriginalFile();
        PsiElement e = completionParameters.getPosition();
        PsiElement p1 = e.getParent();
        PsiElement p2 = p1.getParent();
        if (!(p1 instanceof LarkAtomRefImpl) && (p2 instanceof LarkFile)) {
            completionResultSet.addAllElements(Arrays.asList(
                    LookupElementBuilder.create("%import").withCaseSensitivity(true),
                    LookupElementBuilder.create("%ignore").withCaseSensitivity(true),
                    LookupElementBuilder.create("%declare").withCaseSensitivity(true))
            );
        }
    }
}
