// This is a generated file. Not intended for manual editing.
package ru.klkvsk.fenom.psi;

import com.intellij.psi.TokenType;
import com.intellij.psi.templateLanguages.TemplateDataElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import ru.klkvsk.fenom.FenomLanguage;
import ru.klkvsk.fenom.psi.impl.*;

public interface FenomTypes {
    // large grain parsing
    public static final IElementType TEMPLATE_HTML_TEXT = new FenomElementType("FENOM_TEMPLATE_HTML_TEXT"); // produced by lexer for all HTML code
    public static final IElementType OUTER_ELEMENT_TYPE = new FenomElementType("FENOM_FRAGMENT");
    public static final TemplateDataElementType TEMPLATE_DATA =
            new TemplateDataElementType("FENOM_TEMPLATE_DATA", FenomLanguage.INSTANCE, TEMPLATE_HTML_TEXT, OUTER_ELEMENT_TYPE);


    // Common tokens
    IElementType BAD_CHARACTER = TokenType.BAD_CHARACTER;
    IElementType WHITE_SPACE = TokenType.WHITE_SPACE;
    IElementType COMMENT = new FenomElementType("COMMENT");
    @Deprecated
    IElementType HTML_TEXT = TEMPLATE_HTML_TEXT;


    // TopLexer tokens
    IElementType OPENING = new FenomElementType("OPEN-MACRO");      // {
    IElementType MACRO_NAME = new FenomElementType("MACRO_NAME");   //  if
    IElementType PARAMS = new FenomElementType("PARAMS");           //     $cond
    IElementType CLOSING = new FenomElementType("CLOSE-MACRO");     //          }


    // SubLexer tokens
    IElementType KEYWORD = new FenomElementType("KEYWORD");
    IElementType IDENTIFIER = new FenomElementType("IDENTIFIER");
    IElementType COLON = new FenomElementType(":");
    IElementType ARRAY = new FenomElementType("ARRAY");
    IElementType LOGIC = new FenomElementType("LOGIC");
    IElementType BRACKETS = new FenomElementType("BRACKETS");
    IElementType SEMICOLON = new FenomElementType(";");
    IElementType ASSIGN = new FenomElementType("ASSIGN");
    IElementType STRING = new FenomElementType("STRING");
    IElementType VARIABLE = new FenomElementType("VARIABLE");
    IElementType EXCLAMATION = new FenomElementType("EXCLAMATION");
    IElementType NUMBER = new FenomElementType("NUMBER");
    IElementType COMMA = new FenomElementType(",");
    IElementType DOT = new FenomElementType(".");
    IElementType MODIFIER = new FenomElementType("|");
    IElementType OPERATOR = new FenomElementType("OPERATOR");


    // Parser
    IElementType MACRO_NODE = new FenomElementType("MACRO-NODE");
    IElementType MACRO_ATTR = new FenomElementType("MACRO-ATTR");


    IFileElementType FILE = new IFileElementType("FILE", FenomLanguage.INSTANCE);

    TokenSet WHITESPACES = TokenSet.create(WHITE_SPACE);
    TokenSet COMMENTS = TokenSet.create(COMMENT);
    TokenSet STRING_LITERALS = TokenSet.create();
}
