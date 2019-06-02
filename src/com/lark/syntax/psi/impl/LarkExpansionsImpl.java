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

public class LarkExpansionsImpl extends ASTWrapperPsiElement implements LarkExpansions {

  public LarkExpansionsImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LarkVisitor visitor) {
    visitor.visitExpansions(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LarkVisitor) accept((LarkVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LarkAlias> getAliasList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LarkAlias.class);
  }

}
