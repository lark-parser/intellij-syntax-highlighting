// This is a generated file. Not intended for manual editing.
package com.lark.syntax.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.lark.syntax.psi.LarkTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LarkParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    if (t instanceof IFileElementType) {
      r = parse_root_(t, b, 0);
    }
    else {
      r = false;
    }
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return larkFile(b, l + 1);
  }

  /* ********************************************************** */
  // expansion [ARROW RULE]
  public static boolean alias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALIAS, "<alias>");
    r = expansion(b, l + 1);
    r = r && alias_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [ARROW RULE]
  private static boolean alias_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_1")) return false;
    parseTokens(b, 0, ARROW, RULE);
    return true;
  }

  /* ********************************************************** */
  // OP expansions CP
  //        | OB expansions CB
  //        | STRING DOT_DOT STRING
  //        | rule_name
  //        | (REGEXP | STRING)
  public static boolean atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = atom_0(b, l + 1);
    if (!r) r = atom_1(b, l + 1);
    if (!r) r = parseTokens(b, 0, STRING, DOT_DOT, STRING);
    if (!r) r = rule_name(b, l + 1);
    if (!r) r = atom_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // OP expansions CP
  private static boolean atom_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OP);
    r = r && expansions(b, l + 1);
    r = r && consumeToken(b, CP);
    exit_section_(b, m, null, r);
    return r;
  }

  // OB expansions CB
  private static boolean atom_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OB);
    r = r && expansions(b, l + 1);
    r = r && consumeToken(b, CB);
    exit_section_(b, m, null, r);
    return r;
  }

  // REGEXP | STRING
  private static boolean atom_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_4")) return false;
    boolean r;
    r = consumeToken(b, REGEXP);
    if (!r) r = consumeToken(b, STRING);
    return r;
  }

  /* ********************************************************** */
  // expr*
  public static boolean expansion(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expansion")) return false;
    Marker m = enter_section_(b, l, _NONE_, EXPANSION, "<expansion>");
    while (true) {
      int c = current_position_(b);
      if (!expr(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expansion", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // alias (VBAR alias)*
  public static boolean expansions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expansions")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPANSIONS, "<expansions>");
    r = alias(b, l + 1);
    r = r && expansions_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (VBAR alias)*
  private static boolean expansions_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expansions_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expansions_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expansions_1", c)) break;
    }
    return true;
  }

  // VBAR alias
  private static boolean expansions_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expansions_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VBAR);
    r = r && alias(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // atom [QUANT | TILDE NUMBER [DOT_DOT NUMBER]]
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = atom(b, l + 1);
    r = r && expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [QUANT | TILDE NUMBER [DOT_DOT NUMBER]]
  private static boolean expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1")) return false;
    expr_1_0(b, l + 1);
    return true;
  }

  // QUANT | TILDE NUMBER [DOT_DOT NUMBER]
  private static boolean expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUANT);
    if (!r) r = expr_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TILDE NUMBER [DOT_DOT NUMBER]
  private static boolean expr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TILDE, NUMBER);
    r = r && expr_1_0_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [DOT_DOT NUMBER]
  private static boolean expr_1_0_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr_1_0_1_2")) return false;
    parseTokens(b, 0, DOT_DOT, NUMBER);
    return true;
  }

  /* ********************************************************** */
  // DOT? rule_name (DOT rule_name)*
  public static boolean import_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_ARGS, "<import args>");
    r = import_args_0(b, l + 1);
    r = r && rule_name(b, l + 1);
    r = r && import_args_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // DOT?
  private static boolean import_args_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_args_0")) return false;
    consumeToken(b, DOT);
    return true;
  }

  // (DOT rule_name)*
  private static boolean import_args_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_args_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!import_args_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "import_args_2", c)) break;
    }
    return true;
  }

  // DOT rule_name
  private static boolean import_args_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_args_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && rule_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // rule_def
  //                 | token_def
  //                 | statement
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    r = rule_def(b, l + 1);
    if (!r) r = token_def(b, l + 1);
    if (!r) r = statement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (item_ | NEWLINE | COMMENT)*
  static boolean larkFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "larkFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!larkFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "larkFile", c)) break;
    }
    return true;
  }

  // item_ | NEWLINE | COMMENT
  private static boolean larkFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "larkFile_0")) return false;
    boolean r;
    r = item_(b, l + 1);
    if (!r) r = consumeToken(b, NEWLINE);
    if (!r) r = consumeToken(b, COMMENT);
    return r;
  }

  /* ********************************************************** */
  // DOT NUMBER
  public static boolean priority(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "priority")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, NUMBER);
    exit_section_(b, m, PRIORITY, r);
    return r;
  }

  /* ********************************************************** */
  // RULE priority? COLON expansions NEWLINE
  public static boolean rule_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_def")) return false;
    if (!nextTokenIs(b, RULE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE);
    r = r && rule_def_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expansions(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, RULE_DEF, r);
    return r;
  }

  // priority?
  private static boolean rule_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_def_1")) return false;
    priority(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // RULE
  //             | TOKEN
  public static boolean rule_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_name")) return false;
    if (!nextTokenIs(b, "<rule name>", RULE, TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RULE_NAME, "<rule name>");
    r = consumeToken(b, RULE);
    if (!r) r = consumeToken(b, TOKEN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IGNORE expansions NEWLINE
  //             | IMPORT import_args [ARROW rule_name] NEWLINE
  //             | DECLARE rule_name+ NEWLINE
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    if (!r) r = statement_1(b, l + 1);
    if (!r) r = statement_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IGNORE expansions NEWLINE
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IGNORE);
    r = r && expansions(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // IMPORT import_args [ARROW rule_name] NEWLINE
  private static boolean statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPORT);
    r = r && import_args(b, l + 1);
    r = r && statement_1_2(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // [ARROW rule_name]
  private static boolean statement_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1_2")) return false;
    statement_1_2_0(b, l + 1);
    return true;
  }

  // ARROW rule_name
  private static boolean statement_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARROW);
    r = r && rule_name(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // DECLARE rule_name+ NEWLINE
  private static boolean statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DECLARE);
    r = r && statement_2_1(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // rule_name+
  private static boolean statement_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rule_name(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!rule_name(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_2_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TOKEN priority? COLON expansions NEWLINE
  public static boolean token_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "token_def")) return false;
    if (!nextTokenIs(b, TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TOKEN);
    r = r && token_def_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && expansions(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, TOKEN_DEF, r);
    return r;
  }

  // priority?
  private static boolean token_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "token_def_1")) return false;
    priority(b, l + 1);
    return true;
  }

}
