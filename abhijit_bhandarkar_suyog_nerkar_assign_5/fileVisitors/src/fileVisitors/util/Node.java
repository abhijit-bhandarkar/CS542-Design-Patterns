package fileVisitors.util;

/**
 * Stores the word along with it's children.
 */
public class Node {
  // Child nodes
  Node left, right;
  String key;

  /**
   * Getters
   * @return
   */
  public Node getLeft() { return left; }
  public Node getRight() { return right; }
  public String getKey() {
    return key;
  }

  /**
   * Setters
   * @param key : A word
   * @param Node : Node to add.
   */
  public void setKey(String key) { this.key = key; }
  public void setLeft(Node left) { this.left = left; }
  public void setRight(Node right) { this.right = right; }
 
  // Constructor
  Node(String item) {
    key = item;
    left = right = null;
    MyLogger.writeMessage("Init Node", MyLogger.DebugLevel.CONSTRUCTOR);
  }
 }