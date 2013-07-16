package ru.klkvsk.fenom.lexer;

import com.intellij.psi.tree.TokenSet;
import ru.klkvsk.fenom.psi.FenomTypes;

public class FenomLexer extends LayeredLexer {
    public static final TokenSet FENOM_TOKENS = TokenSet.create(FenomTypes.PARAMS);

    public FenomLexer() {
        super(new FenomTopLexer(), new FenomSubLexer(), FENOM_TOKENS);
    }
}
