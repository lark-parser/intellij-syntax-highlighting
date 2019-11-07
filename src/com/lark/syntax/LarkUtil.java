package com.lark.syntax;

import com.intellij.codeInsight.completion.CompletionResultSet;
import com.intellij.psi.PsiElement;
import com.intellij.util.Consumer;
import com.intellij.util.ProcessingContext;
import com.lark.syntax.psi.*;

import java.util.List;
import java.util.function.BiConsumer;

public class LarkUtil {
    public static void findRuleNames(LarkFile file, Consumer<String> consumer) {
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
                    if (n != null) {
                        consumer.consume(n);
                    }
                }
            }
        }
    }

    public static void findRuleDefinitions(LarkFile file, BiConsumer<String, PsiElement> consumer) {
        for (PsiElement e : file.getChildren()) {
            if (e instanceof LarkTokenDef) {
                String n = ((LarkTokenDef) e).getDefName();
                if (n != null) {
                    consumer.accept(n, e);
                }
            } else if (e instanceof LarkRuleDef) {
                String n = ((LarkRuleDef) e).getDefName();
                if (n != null) {
                    consumer.accept(n, e);
                }
            } else if (e instanceof LarkImportStatement) {
                String n = ((LarkImportStatement) e).getDefName();
                if (n != null) {
                    consumer.accept(n, e);
                }
            } else if (e instanceof LarkDeclareStatement) {
                String[] ns = ((LarkDeclareStatement) e).getDefNames();
                for (String n : ns) {
                    if (n != null)
                        consumer.accept(n, e);
                }
            }
        }
    }

    public static void findRuleDefinitions(LarkFile file, String target, Consumer<PsiElement> consumer) {
        findRuleDefinitions(file, (name, element) -> {
            if (name.equals(target)) {
                consumer.consume(element);
            }
        });
    }
}
