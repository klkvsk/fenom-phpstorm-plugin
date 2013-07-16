package ru.klkvsk.fenom.editor;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import com.jetbrains.php.lang.highlighter.PhpHighlightingData;
import org.apache.tools.ant.Project;
import org.jetbrains.annotations.NotNull;
import ru.klkvsk.fenom.lexer.FenomLexer;
import ru.klkvsk.fenom.psi.FenomTypes;

import java.awt.*;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class FenomSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final String            BAD_CHARACTER_ID = "Bad character";
    public static final TextAttributesKey BAD_CHARACTER    = TextAttributesKey.createTextAttributesKey(BAD_CHARACTER_ID, HighlighterColors.BAD_CHARACTER);

    public static final String            COMMENT_ID       = "Fenom comment";
    public static final TextAttributesKey COMMENT          = TextAttributesKey.createTextAttributesKey(COMMENT_ID, PhpHighlightingData.COMMENT);

    public static final String            BRACKETS_ID      = "Brackets";
    public static final TextAttributesKey BRACKETS         = TextAttributesKey.createTextAttributesKey(BRACKETS_ID, PhpHighlightingData.BRACKETS);

    public static final String            IDENTIFIER_ID    = "Identifier";
    public static final TextAttributesKey IDENTIFIER       = TextAttributesKey.createTextAttributesKey(IDENTIFIER_ID, HighlighterColors.TEXT);

    public static final String            KEYWORD_ID       = "Keyword";
    public static final TextAttributesKey KEYWORD          = TextAttributesKey.createTextAttributesKey(KEYWORD_ID, PhpHighlightingData.KEYWORD);

    public static final String            VARIABLE_ID      = "Variable";
    public static final TextAttributesKey VARIABLE         = TextAttributesKey.createTextAttributesKey(VARIABLE_ID, PhpHighlightingData.VAR);

    public static final String            STRING_ID        = "String";
    public static final TextAttributesKey STRING           = TextAttributesKey.createTextAttributesKey(STRING_ID, PhpHighlightingData.STRING);

    public static final String            PUNCTUATION_ID   = "Punctuation";
    public static final TextAttributesKey PUNCTUATION      = TextAttributesKey.createTextAttributesKey(PUNCTUATION_ID, PhpHighlightingData.COMMA);

    public static final String            NUMBER_ID        = "Number";
    public static final TextAttributesKey NUMBER           = TextAttributesKey.createTextAttributesKey(NUMBER_ID, PhpHighlightingData.NUMBER);


    // Groups of IElementType's
    public static final TokenSet sBAD          = TokenSet.create(FenomTypes.BAD_CHARACTER);
    public static final TokenSet sCOMMENTS     = TokenSet.create(FenomTypes.COMMENT);
    public static final TokenSet sBRACES       = TokenSet.create(FenomTypes.OPENING, FenomTypes.CLOSING);
    public static final TokenSet sIDENTIFIERS  = TokenSet.create(FenomTypes.IDENTIFIER);
    public static final TokenSet sKEYWORDS     = TokenSet.create(FenomTypes.KEYWORD, FenomTypes.MACRO_NAME);
    public static final TokenSet sSTRINGS      = TokenSet.create(FenomTypes.STRING);
    public static final TokenSet sVARIABLES    = TokenSet.create(FenomTypes.VARIABLE);
    public static final TokenSet sPUNCTUATION  = TokenSet.create(
            FenomTypes.COLON, FenomTypes.SEMICOLON, FenomTypes.EXCLAMATION, FenomTypes.COMMA, FenomTypes.ASSIGN,
            FenomTypes.MODIFIER, FenomTypes.ARRAY, FenomTypes.BRACKETS, FenomTypes.DOT, FenomTypes.LOGIC, FenomTypes.EXCLAMATION);
    public static final TokenSet sNUMBERS      = TokenSet.create(FenomTypes.NUMBER);

    // Static container
    private static final Map<IElementType, TextAttributesKey> ATTRIBUTES = new HashMap<IElementType, TextAttributesKey>();


    // Fill in the map
    static {
        fillMap(ATTRIBUTES, sBAD,         BAD_CHARACTER);
        fillMap(ATTRIBUTES, sCOMMENTS,    COMMENT);
        fillMap(ATTRIBUTES, sBRACES,      BRACKETS);
        fillMap(ATTRIBUTES, sIDENTIFIERS, IDENTIFIER);
        fillMap(ATTRIBUTES, sKEYWORDS,    KEYWORD);
        fillMap(ATTRIBUTES, sSTRINGS,     STRING);
        fillMap(ATTRIBUTES, sVARIABLES,   VARIABLE);
        fillMap(ATTRIBUTES, sPUNCTUATION, PUNCTUATION);
        fillMap(ATTRIBUTES, sNUMBERS,     NUMBER);
    }


    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FenomLexer();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType type) {
        TextAttributesKey[] x = pack(ATTRIBUTES.get(type));
        return x;
    }
}