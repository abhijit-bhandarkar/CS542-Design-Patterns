package fileVisitors.visitor;

import fileVisitors.util.BinarySearchTree;
import fileVisitors.util.MyLogger;
import fileVisitors.util.Node;
import fileVisitors.util.PalindromeCheck;

public class PalindromeHighlight implements  VisitorI {
  private PalindromeCheck pc;

  public BinarySearchTree visit(BinarySearchTree bst) {
    MyLogger.writeMessage("\n-----------------------------", MyLogger.DebugLevel.IN_RUN);
    MyLogger.writeMessage("\tPalindrome Highlight : ", MyLogger.DebugLevel.IN_RUN);
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
      newKey = pc.checkAndHighlight(node.getKey());
      node.setKey(newKey);
      checkAndModify(node.getRight());
    }
  }


  /**
   * Default Constructor
   */
  public PalindromeHighlight () {
     pc = new PalindromeCheck();
    MyLogger.writeMessage("Init PalindromeHighlight", MyLogger.DebugLevel.CONSTRUCTOR);
  }
}
