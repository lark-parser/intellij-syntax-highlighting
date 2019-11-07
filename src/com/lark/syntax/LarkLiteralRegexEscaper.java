package com.lark.syntax;

import com.intellij.openapi.util.ProperTextRange;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import com.lark.syntax.psi.LarkAtomLitRegex;
import com.lark.syntax.psi.impl.LarkPsiImplUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class LarkLiteralRegexEscaper extends LiteralTextEscaper<LarkAtomLitRegex> {
    private int[] translations;

    public LarkLiteralRegexEscaper(@NotNull LarkAtomLitRegex host) {
        super(host);
    }

    private static boolean parseRegexCharacters(@NotNull String chars, @NotNull StringBuilder outChars, @Nullable int[] sourceOffsets) {
        assert sourceOffsets == null || sourceOffsets.length == chars.length() + 1;
        if (chars.indexOf('\\') < 0) {
            outChars.append(chars);
            if (sourceOffsets != null) {
                for (int i = 0; i < sourceOffsets.length; i++) {
                    sourceOffsets[i] = i;
                }
            }
            return true;
        }

        int index = 0;
        final int outOffset = outChars.length();
        while (index < chars.length()) {
            char c = chars.charAt(index++);
            if (sourceOffsets != null) {
                sourceOffsets[outChars.length() - outOffset] = index - 1;
                sourceOffsets[outChars.length() + 1 - outOffset] = index;
            }
            if (c != '\\') {
                outChars.append(c);
                continue;
            }
            if (index == chars.length()) return false;
            c = chars.charAt(index++);
            if (c == '\\') {
                outChars.append('\\');
            } else if (c == '/') {
                outChars.append('/');
            } else {
                outChars.append('\\');
                outChars.append(c);
            }
            if (sourceOffsets != null) {
                sourceOffsets[outChars.length() - outOffset] = index;
            }
        }
        return true;
    }

    @Override
    public boolean decode(@NotNull TextRange rangeInsideHost, @NotNull StringBuilder outChars) {
        ProperTextRange.assertProperRange(rangeInsideHost);
        String subText = rangeInsideHost.substring(myHost.getText());
        translations = new int[subText.length() + 1];
        return parseRegexCharacters(subText, outChars, translations);
    }

    @Override
    public int getOffsetInHost(int i, @NotNull TextRange textRange) {
        int result = i < translations.length ? translations[i] : -1;
        if (result == -1) return -1;
        return (result <= textRange.getLength() ? result : textRange.getLength()) + textRange.getStartOffset();

    }

    @Override
    public boolean isOneLine() {
        return true;
    }
}
