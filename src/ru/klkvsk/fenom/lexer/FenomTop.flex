package ru.klkvsk.fenom.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.Stack;
import static ru.klkvsk.fenom.psi.FenomTypes.*;

%%

%class FenomTopFlexLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%caseless
%eof{  return;
%eof}

%{
    private Stack<Integer> stack = new Stack<Integer>();

    public void yypushState(int newState) {
      stack.push(yystate());
      yybegin(newState);
    }

    public void yypopState() {
      yybegin(stack.pop());
    }
%}

STRING = \'(\\.|[^\'\\])*\'|\"(\\.|[^\"\\])*\"
STRING_NO_CURLY = \'(\\.|[^\'\\{}])*\'|\"(\\.|[^\"\\{}])*\"
CRLF = \n | \r | \r\n
WHITE_SPACE_CHAR = [\ \n\r\t\f]
COMMENT = "{*" ~"*}"
OPENING = "{"
CLOSING = "}"
MACRO_NAME = [^\'\"{} ]+


%state MACRO_STARTED
%state IN_MACRO

%%

<YYINITIAL> {
  	"<!--" .* "-->"              { return HTML_TEXT; }
    [{}<>] / {WHITE_SPACE_CHAR}  { return HTML_TEXT; }
    "</"                         { return HTML_TEXT; /* TAG_CLOSING; */ }
    "<" / [!a-zA-Z0-9:]          { return HTML_TEXT; /* TAG_START; */ }
    "{}"                         { return HTML_TEXT; }
    [^{<]+                       { return HTML_TEXT; }
}

<YYINITIAL> {
    {OPENING}/[^\s\'\"{}]        { yypushState(MACRO_STARTED);    return OPENING; }
}

<MACRO_STARTED> {
    [^} ][^}]*                  { yybegin(IN_MACRO); return PARAMS; }
    {CLOSING}                   { yypopState(); return CLOSING; }
}

<IN_MACRO> {
    {WHITE_SPACE_CHAR}+         { return WHITE_SPACE; }
    [^} ][^}]*                  { return PARAMS; }
}

<IN_MACRO> {
    {CLOSING}                   { yypopState(); return CLOSING; }
}

{COMMENT}                                { return COMMENT; }
{WHITE_SPACE_CHAR}+                      { return WHITE_SPACE; }
.                                        { return BAD_CHARACTER; }
