package fileVisitors.util;

import fileVisitors.store.Results;
import fileVisitors.visitor.VisitorI;

/**
 * BST to store the words as nodes
 */
public class BinarySearchTree implements TreeBuilder {
  /**
   * Create a instance for BST with properties.
   */
  private Node root;

  /**
   * getters for tree node.
   * @return
   */
  public Node getRoot() {
    return root;
  }
  /**
   * setters for tree nodes
   */
  public void setRoot(Node root) {
    this.root = root;
  }

  /**
   * Constructor init's root node.
   */
  public BinarySearchTree() {
    root = null;
    MyLogger.writeMessage("Init BinarySearchTree", MyLogger.DebugLevel.CONSTRUCTOR);
  }

  /**
   * Accept the visitor which would be operating on
   * the tree that is sent as 'this' parameter to the
   * visit function.
   * @param v
   */
  public void accept(VisitorI v) {
    v.visit(this);
    MyLogger.writeMessage("- Visit " + v.getClass().toString().split(" ")[1] +
        " Completed", MyLogger.DebugLevel.IN_RESULTS);
  }

  /**
   * Insertion base function, would need this to
   * handle auxiliary recursive function.
   */
  public void insert(String key) {
    setRoot(insertRec(getRoot(), key));
  }

  /**
   * Recursively create nodes of the tree
   * key is the string passed in.
   */
  private Node insertRec(Node node, String key) {
    // Empty? => returns a new node
    if (node == null) {
      return new Node(key);
    }
    // Traverse subtree nodes and add nodes
    if (key.compareTo(node.key) < 0)
      node.left = insertRec(node.left, key);
    else if(key.compareTo(node.key) > 0)
      node.right = insertRec(node.right, key);
    return node;
  }

  // Prints the tree.
  public void printTree(Results res)  {
    printTreeHelper(getRoot(), res);
  }

  /**
   * Print helper for printing
   * the tree nodes via results
   * and fileWriter api
   */
  private void printTreeHelper(Node node, Results res) {
    if (node != null) {
      printTreeHelper(node.left, res);
      MyLogger.writeMessage(node.getKey(), MyLogger.DebugLevel.IN_RUN);
      res.pushResult(node.getKey()+"\n");
      printTreeHelper(node.right, res);
    }
  }
}