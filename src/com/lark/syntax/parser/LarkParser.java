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
  // expansion [ARROW [RULE]]
  public static boolean alias(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALIAS, "<alias>");
    r = expansion(b, l + 1);
    r = r && alias_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [ARROW [RULE]]
  private static boolean alias_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_1")) return false;
    alias_1_0(b, l + 1);
    return true;
  }

  // ARROW [RULE]
  private static boolean alias_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ARROW);
    r = r && alias_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // [RULE]
  private static boolean alias_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alias_1_0_1")) return false;
    consumeToken(b, RULE);
    return true;
  }

  /* ********************************************************** */
  // atom_par|atom_opt|atom_ran|atom_ref|atom_lit
  static boolean atom_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_")) return false;
    boolean r;
    r = atom_par(b, l + 1);
    if (!r) r = atom_opt(b, l + 1);
    if (!r) r = atom_ran(b, l + 1);
    if (!r) r = atom_ref(b, l + 1);
    if (!r) r = atom_lit(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // REGEXP | STRING
  public static boolean atom_lit(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_lit")) return false;
    if (!nextTokenIs(b, "<atom lit>", REGEXP, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM_LIT, "<atom lit>");
    r = consumeToken(b, REGEXP);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OB expansions CB
  public static boolean atom_opt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_opt")) return false;
    if (!nextTokenIs(b, OB)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ATOM_OPT, null);
    r = consumeToken(b, OB);
    p = r; // pin = 1
    r = r && report_error_(b, expansions(b, l + 1));
    r = p && consumeToken(b, CB) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // OP expansions CP
  public static boolean atom_par(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_par")) return false;
    if (!nextTokenIs(b, OP)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ATOM_PAR, null);
    r = consumeToken(b, OP);
    p = r; // pin = 1
    r = r && report_error_(b, expansions(b, l + 1));
    r = p && consumeToken(b, CP) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // STRING DOT_DOT STRING
  public static boolean atom_ran(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_ran")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ATOM_RAN, null);
    r = consumeTokens(b, 2, STRING, DOT_DOT, STRING);
    p = r; // pin = 2
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // RULE | TOKEN
  public static boolean atom_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_ref")) return false;
    if (!nextTokenIs(b, "<atom ref>", RULE, TOKEN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM_REF, "<atom ref>");
    r = consumeToken(b, RULE);
    if (!r) r = consumeToken(b, TOKEN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DECLARE rule_name+ line_end_
  public static boolean declare_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_statement")) return false;
    if (!nextTokenIs(b, DECLARE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DECLARE_STATEMENT, null);
    r = consumeToken(b, DECLARE);
    p = r; // pin = 1
    r = r && report_error_(b, declare_statement_1(b, l + 1));
    r = p && line_end_(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // rule_name+
  private static boolean declare_statement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declare_statement_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RULE_NAME);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, RULE_NAME)) break;
      if (!empty_element_parsed_guard_(b, "declare_statement_1", c)) break;
    }
    exit_section_(b, m, null, r);
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
  // alias ((COMMENT? NEWLINE)? VBAR alias)*
  public static boolean expansions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expansions")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPANSIONS, "<expansions>");
    r = alias(b, l + 1);
    r = r && expansions_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((COMMENT? NEWLINE)? VBAR alias)*
  private static boolean expansions_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expansions_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!expansions_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "expansions_1", c)) break;
    }
    return true;
  }

  // (COMMENT? NEWLINE)? VBAR alias
  private static boolean expansions_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expansions_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expansions_1_0_0(b, l + 1);
    r = r && consumeToken(b, VBAR);
    r = r && alias(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMENT? NEWLINE)?
  private static boolean expansions_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expansions_1_0_0")) return false;
    expansions_1_0_0_0(b, l + 1);
    return true;
  }

  // COMMENT? NEWLINE
  private static boolean expansions_1_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expansions_1_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expansions_1_0_0_0_0(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMENT?
  private static boolean expansions_1_0_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expansions_1_0_0_0_0")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // atom_ [QUANT | TILDE NUMBER [DOT_DOT NUMBER]]
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = atom_(b, l + 1);
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
  // IGNORE expansions line_end_
  public static boolean ignore_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ignore_statement")) return false;
    if (!nextTokenIs(b, IGNORE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IGNORE_STATEMENT, null);
    r = consumeToken(b, IGNORE);
    p = r; // pin = 1
    r = r && report_error_(b, expansions(b, l + 1));
    r = p && line_end_(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // DOT? rule_name (DOT rule_name)*
  public static boolean import_args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_args")) return false;
    if (!nextTokenIs(b, "<import args>", DOT, RULE_NAME)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_ARGS, "<import args>");
    r = import_args_0(b, l + 1);
    r = r && consumeToken(b, RULE_NAME);
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
    r = consumeTokens(b, 0, DOT, RULE_NAME);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IMPORT import_args [ARROW rule_name] line_end_
  public static boolean import_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_STATEMENT, null);
    r = consumeToken(b, IMPORT);
    p = r; // pin = 1
    r = r && report_error_(b, import_args(b, l + 1));
    r = p && report_error_(b, import_statement_2(b, l + 1)) && r;
    r = p && line_end_(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [ARROW rule_name]
  private static boolean import_statement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "import_statement_2")) return false;
    parseTokens(b, 0, ARROW, RULE_NAME);
    return true;
  }

  /* ********************************************************** */
  // rule_def
  //                 | token_def
  //                 | ignore_statement
  //                 | import_statement
  //                 | declare_statement
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = rule_def(b, l + 1);
    if (!r) r = token_def(b, l + 1);
    if (!r) r = ignore_statement(b, l + 1);
    if (!r) r = import_statement(b, l + 1);
    if (!r) r = declare_statement(b, l + 1);
    exit_section_(b, l, m, r, false, item_recovery__parser_);
    return r;
  }

  /* ********************************************************** */
  // line_end_ !(RULE|TOKEN|IGNORE|IMPORT|DECLARE)
  static boolean item_recovery_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_recovery_")) return false;
    if (!nextTokenIs(b, "", COMMENT, NEWLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = line_end_(b, l + 1);
    r = r && item_recovery__1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !(RULE|TOKEN|IGNORE|IMPORT|DECLARE)
  private static boolean item_recovery__1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_recovery__1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !item_recovery__1_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // RULE|TOKEN|IGNORE|IMPORT|DECLARE
  private static boolean item_recovery__1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_recovery__1_0")) return false;
    boolean r;
    r = consumeToken(b, RULE);
    if (!r) r = consumeToken(b, TOKEN);
    if (!r) r = consumeToken(b, IGNORE);
    if (!r) r = consumeToken(b, IMPORT);
    if (!r) r = consumeToken(b, DECLARE);
    return r;
  }

  /* ********************************************************** */
  // (item_ | line_end_)*
  static boolean larkFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "larkFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!larkFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "larkFile", c)) break;
    }
    return true;
  }

  // item_ | line_end_
  private static boolean larkFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "larkFile_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = item_(b, l + 1);
    if (!r) r = line_end_(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // COMMENT? NEWLINE
  static boolean line_end_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_end_")) return false;
    if (!nextTokenIs(b, "", COMMENT, NEWLINE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = line_end__0(b, l + 1);
    r = r && consumeToken(b, NEWLINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMENT?
  private static boolean line_end__0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "line_end__0")) return false;
    consumeToken(b, COMMENT);
    return true;
  }

  /* ********************************************************** */
  // DOT [NUMBER]
  public static boolean priority(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "priority")) return false;
    if (!nextTokenIs(b, DOT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && priority_1(b, l + 1);
    exit_section_(b, m, PRIORITY, r);
    return r;
  }

  // [NUMBER]
  private static boolean priority_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "priority_1")) return false;
    consumeToken(b, NUMBER);
    return true;
  }

  /* ********************************************************** */
  // RULE priority? COLON expansions line_end_
  public static boolean rule_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_def")) return false;
    if (!nextTokenIs(b, RULE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RULE_DEF, null);
    r = consumeToken(b, RULE);
    p = r; // pin = 1
    r = r && report_error_(b, rule_def_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && report_error_(b, expansions(b, l + 1)) && r;
    r = p && line_end_(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // priority?
  private static boolean rule_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rule_def_1")) return false;
    priority(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TOKEN priority? COLON expansions line_end_
  public static boolean token_def(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "token_def")) return false;
    if (!nextTokenIs(b, TOKEN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TOKEN_DEF, null);
    r = consumeToken(b, TOKEN);
    p = r; // pin = 1
    r = r && report_error_(b, token_def_1(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && report_error_(b, expansions(b, l + 1)) && r;
    r = p && line_end_(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // priority?
  private static boolean token_def_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "token_def_1")) return false;
    priority(b, l + 1);
    return true;
  }

  static final Parser item_recovery__parser_ = new Parser() {
    public boolean parse(PsiBuilder b, int l) {
      return item_recovery_(b, l + 1);
    }
  };
}
