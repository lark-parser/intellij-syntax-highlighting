package com.lark.syntax.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.lang.Language;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.lark.syntax.LarkFileType;
import com.lark.syntax.LarkLanguage;
import org.jetbrains.annotations.NotNull;

public class LarkFile extends PsiFileBase {
    public LarkFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, LarkLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return LarkFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Lark Grammar File";
    }
}
