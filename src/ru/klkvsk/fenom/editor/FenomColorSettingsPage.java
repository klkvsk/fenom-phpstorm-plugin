package ru.klkvsk.fenom.editor;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public class FenomColorSettingsPage implements ColorSettingsPage {
    public static final AttributesDescriptor[] ATTRS = {
            new AttributesDescriptor("Comments",       FenomSyntaxHighlighter.COMMENT),
            new AttributesDescriptor("Brackets",       FenomSyntaxHighlighter.BRACKETS),
            new AttributesDescriptor("Keywords",       FenomSyntaxHighlighter.KEYWORD),
            new AttributesDescriptor("Variables",      FenomSyntaxHighlighter.VARIABLE),
            new AttributesDescriptor("Strings",        FenomSyntaxHighlighter.STRING),
            new AttributesDescriptor("Punctuation",    FenomSyntaxHighlighter.PUNCTUATION),
            new AttributesDescriptor("Bad characters", FenomSyntaxHighlighter.BAD_CHARACTER),
    };

    @NotNull
    @Override
    public String getDisplayName() {
        return "Fenom";
    }

    @Override
    public Icon getIcon() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return ATTRS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return new ColorDescriptor[0];
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new FenomSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "{* Comment *}\n<h1>Welcome</h1>\n\n{if $user?}\n\t$user.name\n{/if}\n";
    }

    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }
}