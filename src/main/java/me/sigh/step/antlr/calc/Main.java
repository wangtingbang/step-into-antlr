package me.sigh.step.antlr.calc;

import java.io.FileInputStream;
import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

/**
 * @Author: sairui
 * @Date: 2017-九月-25
 * @Time: 16:04
 */

//Main.java

public class Main {

  public static void main(String[] args) throws Exception {
    String inputFile = "/Users/sairui/workspace/git-work/github/step-into-antlr/src/main/java/me/sigh/step/antlr/calc/data.txt";
    InputStream is = System.in;
//
    if (inputFile != null) {
      is = new FileInputStream(inputFile);
    }
    ANTLRInputStream input = new ANTLRInputStream(is);
//
    ExprLexer lexer = new ExprLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    ExprParser parser = new ExprParser(tokens);
    ParseTree tree = parser.prog(); // parse
    System.out.println(tree.toStringTree(parser));
    ExprVisitor visitor = new ExprBaseVisitor();
    System.out.println(
        visitor.visit(tree)
    );
  }
}
