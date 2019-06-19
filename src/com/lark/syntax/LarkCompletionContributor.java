package com.lark.syntax;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import com.lark.syntax.psi.LarkFile;
import com.lark.syntax.psi.LarkTokenType;
import com.lark.syntax.psi.LarkTypes;
import com.lark.syntax.psi.impl.LarkAtomRefImpl;
import org.jetbrains.annotations.NotNull;

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
        if (p1 instanceof LarkAtomRefImpl) {
            LarkUtil.findRules(file,
                    (name) -> completionResultSet.addElement(LookupElementBuilder.create(name).withCaseSensitivity(true)));
        }
    }
}
