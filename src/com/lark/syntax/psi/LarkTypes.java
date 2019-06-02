// This is a generated file. Not intended for manual editing.
package com.lark.syntax.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.lark.syntax.psi.impl.*;

public interface LarkTypes {

  IElementType ALIAS = new LarkElementType("ALIAS");
  IElementType ATOM = new LarkElementType("ATOM");
  IElementType EXPANSION = new LarkElementType("EXPANSION");
  IElementType EXPANSIONS = new LarkElementType("EXPANSIONS");
  IElementType EXPR = new LarkElementType("EXPR");
  IElementType IMPORT_ARGS = new LarkElementType("IMPORT_ARGS");
  IElementType PRIORITY = new LarkElementType("PRIORITY");
  IElementType RULE_DEF = new LarkElementType("RULE_DEF");
  IElementType RULE_NAME = new LarkElementType("RULE_NAME");
  IElementType STATEMENT = new LarkElementType("STATEMENT");
  IElementType TOKEN_DEF = new LarkElementType("TOKEN_DEF");

  IElementType ARROW = new LarkTokenType("ARROW");
  IElementType CB = new LarkTokenType("CB");
  IElementType COLON = new LarkTokenType("COLON");
  IElementType COMMENT = new LarkTokenType("COMMENT");
  IElementType CP = new LarkTokenType("CP");
  IElementType DECLARE = new LarkTokenType("DECLARE");
  IElementType DOT = new LarkTokenType("DOT");
  IElementType DOT_DOT = new LarkTokenType("DOT_DOT");
  IElementType IGNORE = new LarkTokenType("IGNORE");
  IElementType IMPORT = new LarkTokenType("IMPORT");
  IElementType NEWLINE = new LarkTokenType("NEWLINE");
  IElementType NUMBER = new LarkTokenType("NUMBER");
  IElementType OB = new LarkTokenType("OB");
  IElementType OP = new LarkTokenType("OP");
  IElementType QUANT = new LarkTokenType("QUANT");
  IElementType REGEXP = new LarkTokenType("REGEXP");
  IElementType RULE = new LarkTokenType("RULE");
  IElementType STRING = new LarkTokenType("STRING");
  IElementType TILDE = new LarkTokenType("TILDE");
  IElementType TOKEN = new LarkTokenType("TOKEN");
  IElementType VBAR = new LarkTokenType("VBAR");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ALIAS) {
        return new LarkAliasImpl(node);
      }
      else if (type == ATOM) {
        return new LarkAtomImpl(node);
      }
      else if (type == EXPANSION) {
        return new LarkExpansionImpl(node);
      }
      else if (type == EXPANSIONS) {
        return new LarkExpansionsImpl(node);
      }
      else if (type == EXPR) {
        return new LarkExprImpl(node);
      }
      else if (type == IMPORT_ARGS) {
        return new LarkImportArgsImpl(node);
      }
      else if (type == PRIORITY) {
        return new LarkPriorityImpl(node);
      }
      else if (type == RULE_DEF) {
        return new LarkRuleDefImpl(node);
      }
      else if (type == RULE_NAME) {
        return new LarkRuleNameImpl(node);
      }
      else if (type == STATEMENT) {
        return new LarkStatementImpl(node);
      }
      else if (type == TOKEN_DEF) {
        return new LarkTokenDefImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
