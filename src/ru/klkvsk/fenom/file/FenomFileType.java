package ru.klkvsk.fenom.file;

import com.intellij.openapi.editor.colors.EditorColorsScheme;
import com.intellij.openapi.editor.highlighter.EditorHighlighter;
import com.intellij.openapi.fileTypes.EditorHighlighterProvider;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.FileTypeEditorHighlighterProviders;
import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.klkvsk.fenom.FenomLanguage;
import ru.klkvsk.fenom.editor.FenomTemplateHighlighter;

import javax.swing.*;

public class FenomFileType extends LanguageFileType {
    public static final FenomFileType INSTANCE = new FenomFileType();

    private FenomFileType() {
        super(FenomLanguage.INSTANCE);

        // register highlighter - lazy singleton factory
        FileTypeEditorHighlighterProviders.INSTANCE.addExplicitExtension(this, new EditorHighlighterProvider() {
            public EditorHighlighter getEditorHighlighter(@Nullable Project project,
                                                          @NotNull FileType fileType,
                                                          @Nullable VirtualFile virtualFile,
                                                          @NotNull EditorColorsScheme editorColorsScheme) {
                return new FenomTemplateHighlighter(project, virtualFile, editorColorsScheme);
            }
        });
    }

    @NotNull
    @Override
    public String getName() {
        return "Fenom template";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Fenom template";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "fm";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return FenomIcons.FILE;
    }
}