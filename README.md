
# Compiler
Design of this language is close to completion (Oh, not yet). I named it as YF language, abbreviated as YFlang. It has static typed OO features  for example, class, interface, inheritance, implemention, generic, reflection, etc, and also, dynamic typed functional programming is supported, including lambda expression and high order function. Of cause it can do type inference and checking. And i'm considering if i should add map/reduce/fmap even functor/monad as buildin functions or types in it. i guess it will be finished by next month. 

older version: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  Recently, parser generator is updated to GLR. For parsing complex or even ambiguous grammars, LR(1) is not as powerful as GLR. Then the LR(1) parser generator is updated to GLR. The script language and its compiler is still in process. There will be many new features, such as OOP, sub-class, interface, generic, lambda expression... Maybe look like java language. IR is still in AST form. After that, the next step may be optimizing interpreter, or designing virtual machine.
  
older version: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  
  A compiler, including lex analyser, regex parser, LR(1) parser and the LR(1) parser generator. These tools are used for compiling a script program language specified by myself. Currently the IR is abstruct syntax tree and is interpreted by an interpreter. Lex and syntax specifications are defined in some txt files, as well as the parsing rules. The script languege is like a subset of C languese, including if...else... expression, while(...){...} expression, variable defining and assignment, function defining and calling, recursive function, for example: int fact(int a){if(a<1) return 1; return a*fact(a-1);}.
