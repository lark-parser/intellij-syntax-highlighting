// This is a generated file. Not intended for manual editing.
package com.lark.syntax.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;

public class LarkVisitor extends PsiElementVisitor {

  public void visitAlias(@NotNull LarkAlias o) {
    visitPsiElement(o);
  }

    public void visitAtomLitRegex(@NotNull LarkAtomLitRegex o) {
        visitPsiLanguageInjectionHost(o);
    }

    public void visitAtomLitString(@NotNull LarkAtomLitString o) {
    visitPsiElement(o);
  }

  public void visitAtomOpt(@NotNull LarkAtomOpt o) {
    visitPsiElement(o);
  }

  public void visitAtomPar(@NotNull LarkAtomPar o) {
    visitPsiElement(o);
  }

  public void visitAtomRan(@NotNull LarkAtomRan o) {
    visitPsiElement(o);
  }

  public void visitAtomRef(@NotNull LarkAtomRef o) {
      visitNameReference(o);
  }

  public void visitDeclareStatement(@NotNull LarkDeclareStatement o) {
    visitPsiElement(o);
  }

  public void visitExpansion(@NotNull LarkExpansion o) {
    visitPsiElement(o);
  }

  public void visitExpansions(@NotNull LarkExpansions o) {
    visitPsiElement(o);
  }

  public void visitExpr(@NotNull LarkExpr o) {
    visitPsiElement(o);
  }

  public void visitIgnoreStatement(@NotNull LarkIgnoreStatement o) {
    visitPsiElement(o);
  }

    public void visitImportAlias(@NotNull LarkImportAlias o) {
        visitPsiElement(o);
    }

    public void visitImportName(@NotNull LarkImportName o) {
        visitPsiElement(o);
    }

    public void visitImportNames(@NotNull LarkImportNames o) {
        visitPsiElement(o);
    }

    public void visitImportPath(@NotNull LarkImportPath o) {
    visitPsiElement(o);
  }

  public void visitImportStatement(@NotNull LarkImportStatement o) {
    visitPsiElement(o);
  }

  public void visitPriority(@NotNull LarkPriority o) {
    visitPsiElement(o);
  }

    public void visitRuleDef(@NotNull LarkRuleDef o) {
        visitNamedElement(o);
    }

    public void visitTokenDef(@NotNull LarkTokenDef o) {
        visitNamedElement(o);
    }

    public void visitNameReference(@NotNull LarkNameReference o) {
        visitPsiElement(o);
    }

    public void visitNamedElement(@NotNull LarkNamedElement o) {
    visitPsiElement(o);
  }

    public void visitPsiLanguageInjectionHost(@NotNull PsiLanguageInjectionHost o) {
        visitElement(o);
    }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
