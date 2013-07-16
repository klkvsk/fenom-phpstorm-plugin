package ru.klkvsk.fenom.psi;

import com.intellij.psi.tree.IElementType;
import ru.klkvsk.fenom.FenomLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class FenomElementType extends IElementType {
    public FenomElementType(@NotNull @NonNls String debugName) {
        super(debugName, FenomLanguage.INSTANCE);
    }
}