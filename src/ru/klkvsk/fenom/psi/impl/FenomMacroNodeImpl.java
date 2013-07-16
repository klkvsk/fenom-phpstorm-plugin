package ru.klkvsk.fenom.psi.impl;

import com.intellij.extapi.psi.ASTDelegatePsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import ru.klkvsk.fenom.psi.FenomTypes;

/**
 * Curly brackets macro
 */
public class FenomMacroNodeImpl extends FenomPsiElement {

    public FenomMacroNodeImpl(ASTNode node) {
        super(node);
    }

    public String getMacroName() {
        for(PsiElement el: getChildren()) {
            if(el.getNode().getElementType() == FenomTypes.MACRO_NAME) return el.getText();
        }
        return null;
    }

    public PsiElement getParams() {
        for(PsiElement el: getChildren()) {
            if(el.getNode().getElementType() == FenomTypes.PARAMS) return el;
        }
        return null;
    }

}
