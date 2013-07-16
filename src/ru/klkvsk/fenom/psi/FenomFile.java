package ru.klkvsk.fenom.psi;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.impl.PsiFileEx;
import org.jetbrains.annotations.NotNull;

public interface FenomFile extends PsiFileEx {
    @NotNull
    @Override
    FileType getFileType();
}