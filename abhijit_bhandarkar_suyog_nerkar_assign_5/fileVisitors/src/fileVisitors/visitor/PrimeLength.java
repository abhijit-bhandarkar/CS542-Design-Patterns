package fileVisitors.visitor;

import fileVisitors.util.*;

public class PrimeLength implements VisitorI {
  private PrimeCheck pc;

  public BinarySearchTree visit(BinarySearchTree bst) {
    MyLogger.writeMessage("\n-----------------------------", MyLogger.DebugLevel.IN_RUN);
    MyLogger.writeMessage("\tPrime Length : ", MyLogger.DebugLevel.IN_RUN);
    MyLogger.writeMessage("-----------------------------", MyLogger.DebugLevel.IN_RUN);
    checkAndModify(bst.getRoot());
    return bst;
  }

  /**
   * Check and modify the tree.
   */
  private void checkAndModify(Node node) {
    String newKey;
    if (node != null) {
      checkAndModify(node.getLeft());
      newKey = pc.checkAndAppend(node.getKey());
      node.setKey(newKey);
      checkAndModify(node.getRight());
    }
  }

  public PrimeLength() {
    pc = new PrimeCheck();
    MyLogger.writeMessage("Init PrimeLength", MyLogger.DebugLevel.CONSTRUCTOR);
  }
}
