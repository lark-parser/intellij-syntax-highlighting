package com.lark.syntax.psi;

import com.intellij.psi.tree.IElementType;
import com.lark.syntax.LarkLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class LarkElementType extends IElementType {
    public LarkElementType(@NotNull @NonNls String debugName) {
        super(debugName, LarkLanguage.INSTANCE);
    }
}
