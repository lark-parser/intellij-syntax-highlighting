// This is a generated file. Not intended for manual editing.
package com.lark.syntax.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LarkImportStatement extends PsiElement {

  @Nullable
  LarkImportAlias getImportAlias();

  @Nullable
  LarkImportNames getImportNames();

  @Nullable
  LarkImportPath getImportPath();

  String[] getDefNames();

}
