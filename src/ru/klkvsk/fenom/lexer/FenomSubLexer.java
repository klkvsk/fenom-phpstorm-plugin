package ru.klkvsk.fenom.lexer;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.TokenSet;
import ru.klkvsk.fenom.lexer.FenomSubFlexLexer;
import ru.klkvsk.fenom.psi.FenomTypes;

import java.io.Reader;


public class FenomSubLexer extends MergingLexerAdapter {
    // To be merged
    private static final TokenSet TOKENS_TO_MERGE = TokenSet.create(
            FenomTypes.WHITE_SPACE
    );

    public FenomSubLexer() {
        super(new FlexAdapter(new FenomSubFlexLexer((Reader) null)), TOKENS_TO_MERGE);
    }
}
