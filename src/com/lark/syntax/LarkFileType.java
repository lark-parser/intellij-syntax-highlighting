package com.lark.syntax;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LarkFileType extends LanguageFileType {
    public static final LarkFileType INSTANCE = new LarkFileType();

    private LarkFileType() {
        super(LarkLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Lark grammar";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Lark grammar file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "lark";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }
}
