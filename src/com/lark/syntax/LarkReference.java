package com.lark.syntax;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.lark.syntax.psi.LarkFile;
import com.lark.syntax.psi.LarkNameReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LarkReference extends PsiReferenceBase<LarkNameReference> implements PsiPolyVariantReference {
    private String name;

    public LarkReference(@NotNull LarkNameReference element) {
        super(element, false);
        this.name = element.getText();
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        LarkFile file = (LarkFile) myElement.getContainingFile();
        List<ResolveResult> results = new ArrayList<>();
        LarkUtil.findRuleDefinitions(file, name, element -> results.add(new PsiElementResolveResult(element)));
        return results.toArray(new ResolveResult[0]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        LarkFile file = (LarkFile) myElement.getContainingFile();
        List<String> names = new ArrayList<>();
        LarkUtil.findRuleNames(file, names::add);
        return names.toArray();
    }

    @NotNull
    @Override
    public TextRange getRangeInElement() {
        return ElementManipulators.getValueTextRange(this.myElement);
    }
}
