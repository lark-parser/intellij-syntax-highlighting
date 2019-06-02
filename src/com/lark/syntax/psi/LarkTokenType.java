package com.lark.syntax.psi;

import com.intellij.lang.Language;
import com.intellij.psi.tree.IElementType;
import com.lark.syntax.LarkLanguage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LarkTokenType extends IElementType {
    public LarkTokenType(@NotNull String debugName) {
        super(debugName, LarkLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "LarkTokenType." + super.toString();
    }
}
