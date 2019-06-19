package com.lark.syntax;

import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.psi.PsiElement;
import com.intellij.util.Consumer;
import com.intellij.util.ProcessingContext;
import com.lark.syntax.psi.*;

import java.util.List;

public class LarkUtil {
    public static void findRules(LarkFile file, Consumer<String> consumer) {
        for (PsiElement e : file.getChildren()) {
            if (e instanceof LarkTokenDef) {
                String n = ((LarkTokenDef) e).getDefName();
                if (n != null) {
                    consumer.consume(n);
                }
            } else if (e instanceof LarkRuleDef) {
                String n = ((LarkRuleDef) e).getDefName();
                if (n != null) {
                    consumer.consume(n);
                }
            } else if (e instanceof LarkImportStatement) {
                String n = ((LarkImportStatement) e).getDefName();
                if (n != null) {
                    consumer.consume(n);
                }
            } else if (e instanceof LarkDeclareStatement) {
                String[] ns = ((LarkDeclareStatement) e).getDefNames();
                for (String n : ns) {
                    if (n != null)
                        consumer.consume(n);
                }
            }
        }
    }
}
