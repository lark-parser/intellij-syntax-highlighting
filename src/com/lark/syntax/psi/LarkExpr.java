// This is a generated file. Not intended for manual editing.
package com.lark.syntax.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LarkExpr extends PsiElement {

  @Nullable
  LarkAtomLitRegex getAtomLitRegex();

    @Nullable
    LarkAtomLitString getAtomLitString();

  @Nullable
  LarkAtomOpt getAtomOpt();

  @Nullable
  LarkAtomPar getAtomPar();

  @Nullable
  LarkAtomRan getAtomRan();

  @Nullable
  LarkAtomRef getAtomRef();

}
