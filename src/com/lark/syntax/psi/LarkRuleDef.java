// This is a generated file. Not intended for manual editing.
package com.lark.syntax.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LarkRuleDef extends LarkNamedElement {

  @Nullable
  LarkExpansions getExpansions();

  @Nullable
  LarkPriority getPriority();

    String getDefName();

    PsiElement getNameIdentifier();

    PsiElement setName(String newName);

}
