package ru.klkvsk.fenom.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.TokenType;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import ru.klkvsk.fenom.FenomLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class FenomTokenType extends IElementType {

    public FenomTokenType(@NotNull @NonNls String debugName) {
        super(debugName, FenomLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "FenomTokenType." + super.toString();
    }
}