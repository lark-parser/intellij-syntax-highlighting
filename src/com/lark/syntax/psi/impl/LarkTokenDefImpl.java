// This is a generated file. Not intended for manual editing.
package com.lark.syntax.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.lark.syntax.psi.LarkTypes.*;
import com.lark.syntax.psi.*;

public class LarkTokenDefImpl extends LarkNamedElementImpl implements LarkTokenDef {

  public LarkTokenDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LarkVisitor visitor) {
    visitor.visitTokenDef(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LarkVisitor) accept((LarkVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LarkExpansions getExpansions() {
    return findChildByClass(LarkExpansions.class);
  }

  @Override
  @Nullable
  public LarkPriority getPriority() {
    return findChildByClass(LarkPriority.class);
  }

  @Override
  public String getDefName() {
    return LarkPsiImplUtil.getDefName(this);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return LarkPsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return LarkPsiImplUtil.setName(this, newName);
  }

}
