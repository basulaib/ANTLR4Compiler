///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/// • variable declarations																								///
/// • variable assignments																								///
/// • variable references (i.e., referring to declared variables in expressions)										///
/// • arithmetic, relational, and logical expressions																	///
/// • conditionals																										///
/// • specification (e.g., preconditions, postconditions, invariants, property assertions) in input programs			///
/// that guide the target verification																					///
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////
/// 		EECS 4302 - York University			///
///			Winter 2020 - Project				///
///			Team:								///
///				- Abdul Adeshina				///
/// 			- Abdullah Basulaib				///
///				- Chidi Okongwu					///
/// 			- Shiyi Du						///
///////////////////////////////////////////////////

// open util/boolean

grammar Project;

@header {
	package antlr;
}

// Start
prog: (classBlock)+ EOF														# Program
	;

classBlock: 'class' ID '{' body '}'
	 	  ;

body: declBody? (assume | func | assertion | loop)*								# ClassBody
	;

declBody: 'declare' '{' (decl LINE_END)* '}'
		;

decl: TYPE ID																# VarDecl
	| TYPE ID '=' VAR														# VarInit
    ;

assume: 'assume' '{' (expr LINE_END)* '}'									# Assumption
	  ;


expr: '(' expr ')' 															# ParenthesizedExpr
    | expr '*' expr                                                         # Multiplication
    | expr '/' expr                                                        # Division
    | expr '+' expr                                                        # Addition
    | expr '-' expr                                                        # Subtraction
    | expr '>' expr                                                        # Larger
    | expr '<' expr                                                        # Smaller
    | expr '>=' expr                                                        # LargerOrEqual
    | expr '<=' expr                                                         # SmallerOrEqual
    | expr '==' expr                                                         # Equal
    | expr '!=' expr                                                         # NotEqual
    | expr '&&' expr                                                        # Conjunction
    | expr '||' expr                                                        # Disjunction
    | expr '=>' expr                                                         # Implication
    | expr '<=>' expr                                                         # Equivalence
    | UNARY_OP expr															# UnaryExpr	
    | ID																	# VarExpr
    | VAR																	# BoolNumExpr
    ;
    
//BINARY_OP : '*' | '/' | '+' | '-' | '&&' | '||' | '>' | '<' | '>=' | '<=' | '==' | '!=' | '=>' | '<=>';
func: 'func' (TYPE | 'void') ID '(' ((param ',')* param)? ')' '{' funcBody '}'		# Function
	;

funcBody: precon? (funcStatement)* postcon?			# FunctionBody
		;

funcStatement: ID '=' (expr | VAR) LINE_END						      //# Statement
			 | conditional
             | loop
             | funcCall
             | switchBlock
			 ;

precon: 'require' '{' (expr LINE_END)* '}'									# PreCond
	  ;

postcon: 'ensure' '{' (expr LINE_END)* '}'									# PostCond
	   ;

assertion: 'assert' '{' (expr LINE_END)* '}'
	  ;

conditional: ifBlock (elseifBlock)* elseBlock?							  //# Conditional
		   ;

ifBlock: 'if' '(' expr ')' '{' (funcStatement)* '}'					# IfConditional
       ;

elseifBlock: 'else if' '(' expr ')' '{' (funcStatement)* '}'			# ElseIfConditional
		   ;

elseBlock: 'else' '{' (funcStatement)* '}'							# ElseConditional
		 ;

param: TYPE ID																# Parameter
	 ;

// initialization, invariant, terminating condition, loop body, and loop variant
loop: 'loop' '{' fromBlock untilBlock invariantBlock? doBlock? variantBlock '}'
         ;

fromBlock: 'from' '{' fromBody* '}'
         ;

fromBody: ID '=' expr LINE_END
        ;

untilBlock: 'until' '{' untilBody+ '}'
          ;

untilBody: expr LINE_END
         ;

invariantBlock: 'invariant' '{' invariantBody* '}'
              ;

invariantBody: expr LINE_END
             ;

doBlock: 'do' '{' doBody* '}'
       ;

doBody: funcStatement
      ;

variantBlock: 'variant' '{' variantBody '}'
            ;

variantBody: expr LINE_END
           ;
           
funcCall: ID '(' (((expr | VAR) ',')* (expr | VAR))? ')' LINE_END											#FunctionCall
		;
		
switchBlock: 'switch' '(' expr ')' '{' switchBody '}' 								#Switch
		   ;
	
switchBody: (caseBlock)* defaultBlock		
      	  ;
	
caseBlock: 'case:' expr '{' (funcStatement)* '}'										#Case
	     ;

defaultBlock: 'default:' '{' (funcStatement)* '}'  										#Default
	;

// Tokens
TYPE : 'int' | 'string' | 'bool';
VAR: NUM | BOOL | '"'STRING'"' | '"'ID'"';
fragment STRING : [a-zA-Z0-9_ ]*;
fragment NUM : '0' | '-'?[1-9]?[0-9]+;
ID : [a-zA-Z0-9_]+;
BOOL : 'true' | 'false';
COMMENT : '//' ~[\r\n]* -> skip;
WS : [ \r\t\n]+ -> skip;
//BINARY_OP : '*' | '/' | '+' | '-' | '&&' | '||' | '>' | '<' | '>=' | '<=' | '==' | '!=' | '=>' | '<=>';
UNARY_OP : '!';
LINE_END : ';';

// COMMENTS AND LINES
//boolExpr: '(' boolExpr ')' 												# ParenthesizedBoolExpr
//		| boolExpr BINARY_OP boolExpr										# BinaryBoolExpr
//		| '!' boolExpr														# NegationBoolExpr
//		| NUM																# NumBoolExpr
//		| ID																# VarBoolExpr
 //	   	| BOOL																# BoolBoolExpr
 	//   	;

//numExpr: '(' numExpr ')' 													# ParenthesizedNumExpr
//	   | numExpr MATH_OP numExpr											# MathNumExpr
       //| '-' numExpr														# NegativeNumExpr
       //| ID																# VarNumExpr
       //| NUM																# NumNumExpr
       //;

//MATH_OP : '*' | '/' | '+' | '-';
//BINARY_OP : '&&' | '||' | '>' | '<' | '>=' | '<=' | '==';
