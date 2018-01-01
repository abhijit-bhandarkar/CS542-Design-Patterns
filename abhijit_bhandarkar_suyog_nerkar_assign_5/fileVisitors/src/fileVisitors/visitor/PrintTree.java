package fileVisitors.visitor;

import fileVisitors.store.Results;
import fileVisitors.util.BinarySearchTree;
import fileVisitors.util.MyLogger;

public class PrintTree implements VisitorI {
  private Results results;
  private String output;

  public BinarySearchTree visit(BinarySearchTree bst) {
    MyLogger.writeMessage("\n-----------------------------", MyLogger.DebugLevel.IN_RUN);
    MyLogger.writeMessage("\tPrint tree Visitor :", MyLogger.DebugLevel.IN_RUN);
    MyLogger.writeMessage("-----------------------------", MyLogger.DebugLevel.IN_RUN);
    bst.printTree(results);
    processWrites(results, output);
    return bst;
  }

  /**
   * Write results to the Results and print file
   * @param res
   * @param out
   */
  private static void processWrites(Results res, String out) {
    // Write to Output file
    res.writeToFile(out);
  }

  /**
   * Constructor
   * @param res
   * @param out
   */
  public PrintTree (Results res, String out) {
    results = res;
    output = out;
    MyLogger.writeMessage("Init PrintTree", MyLogger.DebugLevel.CONSTRUCTOR);
  }
}