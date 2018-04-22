# CPP-to-LISP-translator

A compiler project to translate assignment of arithmetic operations from C++ to LISP programming language

Example
  C++ code
  
    x = 10;
    y = x+5;
    a = ((x*6)+5);

  Translated LISP code
  
    (x 10)
    (y (+ x 5))
    (a (+ (* x 6) 5))


