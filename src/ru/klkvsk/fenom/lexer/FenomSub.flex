package ru.klkvsk.fenom.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.containers.Stack;
import static ru.klkvsk.fenom.psi.FenomTypes.*;

%%

%class FenomSubFlexLexer
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

IDENTIFIER = [a-zA-Z_][a-zA-Z0-9_]*
STRING = \'(\\.|[^\'\\])*\'|\"(\\.|[^\"\\])*\"
STRING_NO_CURLY = \'(\\.|[^\'\\{}])*\'|\"(\\.|[^\"\\{}])*\"
CRLF = \n | \r | \r\n
WHITE_SPACE_CHAR = [\ \n\r\t\f]
COMMENT = "{*" ~"*}"
OPENING = "{"
CLOSING = "}"
MACRO_NAME = [^\'\"{} ]+
VARIABLE = "$"[a-zA-Z_][a-zA-Z0-9\.]*
KEYWORD = [a-z]+

%%

<YYINITIAL> {
    "true"                      { return KEYWORD; }
    "false"                     { return KEYWORD; }
    "null"                      { return KEYWORD; }
    "isset"                      { return KEYWORD; }
    "empty"                      { return KEYWORD; }

    [\[\]]                      { return ARRAY; }
    [\(\)]                      { return BRACKETS; }
	"|"                         { return MODIFIER; }
    {STRING}                    { return STRING; }
    ":"                         { return COLON; }
    ";"                         { return SEMICOLON; }
    "=>" | "->"                 { return ASSIGN; }
    {VARIABLE}                  { return VARIABLE; }
    ^{KEYWORD}                  { return KEYWORD; }
    " " {KEYWORD} " "           { return KEYWORD; }
    " " {KEYWORD} "="           { return KEYWORD; }
    "/" {KEYWORD}               { return KEYWORD; }
    "!"                         { return OPERATOR; }
    "?"                         { return OPERATOR; }
    ","                         { return COMMA; }
    "."                         { return DOT; }
    [0-9]+("."[0-9]+)?          { return NUMBER; }
    [\|\&]                      { return LOGIC; }
    [<>=][<>=]?[<>=]?           { return OPERATOR; }
        {IDENTIFIER}                { return IDENTIFIER; }

}

{WHITE_SPACE_CHAR}+                      { return WHITE_SPACE; }
.                                        { return BAD_CHARACTER; }
