package com.lark.syntax;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class LarkColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Rule Name", LarkSyntaxHighlighter.RULE),
            new AttributesDescriptor("Token Name", LarkSyntaxHighlighter.TOKEN),
            new AttributesDescriptor("Assign Colon", LarkSyntaxHighlighter.ASSIGN),
            new AttributesDescriptor("Alias Arrow", LarkSyntaxHighlighter.ALIAS),
            new AttributesDescriptor("Operators", LarkSyntaxHighlighter.OPERATOR),
            new AttributesDescriptor("Keyword", LarkSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("String", LarkSyntaxHighlighter.STRING),
            new AttributesDescriptor("Regexp", LarkSyntaxHighlighter.REGEXP),
            new AttributesDescriptor("Comment", LarkSyntaxHighlighter.COMMENT),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new LarkSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "// A demo-lark-grammar\n" +
                "start: \"test\" data+\n" +
                "data: _SEPARATOR (entry|field)+\n" +
                "_SEPARATOR: /[:=\\s]+/\n" +
                "entry: NAME -> name\n" +
                "     | SIGNED_NUMBER -> number\n" +
                "field: entry \"|\" entry\n" +
                "%import SIGNED_NUMBER\n" +
                "%import CNAME -> NAME\n" +
                "%import NEWLINE -> NL\n" +
                "%ignore NL\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "Lark";
    }
}
