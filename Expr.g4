grammar Expr;

prog: stat+ ;

stat: ID '=' expr ';' NEWLINE                    #assign
    | NEWLINE                                #blank
    ;

expr: expr op=(MUL|DIV|MOD) expr             #MulDiv
    |  expr op=(ADD|SUB) expr                #AddSub
    | INT                                    #int
    | ID                                     #id
    | '(' expr ')'                           #parenc
    ;

ID  : [a-zA-Z]+ ;
INT :  [0-9]+ ;
NEWLINE : [\r\n]+ ;
WS  : [ \t\r\n]+ -> skip ;

MUL : '*' ;
DIV : '/' ;
MOD : '%' ;
ADD : '+' ;
SUB : '-' ;

