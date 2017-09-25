package me.sigh.step.antlr.calc.labeled;

import java.io.FileInputStream;
import java.io.InputStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * @Author: sairui
 * @Date: 2017-九月-25
 * @Time: 17:23
 */
public class Main {
  public static void main(String[] args) throws Exception {
    // create a CharStream thatreads from standard input
//    String inputFile = "data.txt";
    String inputFile = "/Users/sairui/workspace/git-work/github/step-into-antlr/src/main/java/me/sigh/step/antlr/calc/data.txt";
    InputStream is = System.in;

    if ( inputFile!=null ) is = new FileInputStream(inputFile);
    ANTLRInputStream input = new ANTLRInputStream(is);

    LabeledExprLexer lexer = new LabeledExprLexer(input);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    LabeledExprParser parser = new LabeledExprParser(tokens);
    ParseTree tree = parser.prog(); // parse
    EvalVisitor eval = new EvalVisitor();
    eval.visit(tree);
  }
}
