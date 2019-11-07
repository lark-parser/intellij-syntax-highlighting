package com.lark.syntax.psi.impl;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.lark.syntax.LarkFileType;
import com.lark.syntax.psi.LarkFile;
import com.lark.syntax.psi.LarkTokenDef;

public class LarkElementFactory {
    public static <T extends PsiElement> T createElement(Project project, String name) {
        final LarkFile file = createFile(project, name);
        return (T) file.getFirstChild();
    }

    public static LarkFile createFile(Project project, String text) {
        String name = "dummy.lark";
        return (LarkFile) PsiFileFactory.getInstance(project).createFileFromText(name, LarkFileType.INSTANCE, text);
    }
}
