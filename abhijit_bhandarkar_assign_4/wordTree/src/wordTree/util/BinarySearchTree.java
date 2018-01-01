package wordTree.util;

/**
 * BST to store the words as nodes
 */
public class BinarySearchTree {

  /**
   * Create a instance for BST with properties like
   * total words, distinct words, and char count.
   */
  Node root;
  private int totalWords;
  private int distinctWords;
  private int charCount;

  /**
   * getters for tree node.
   * @return
   */
  public Node getRoot() {
    return root;
  }
  public int getCharCount() {
    return charCount;
  }
  public int getTotalWords() {
    return totalWords;
  }
  public int getDistinctWords() {
    return distinctWords;
  }

  /**
   * setters for tree nodes
   */
  public void setRoot(Node root) {
    this.root = root;
  }
  public void setCharCount(int charCount) {
    this.charCount = charCount;
  }
  public void setTotalWords(int totalWords) {
    this.totalWords = totalWords;
  }
  public void setDistinctWords(int distinctWords) {
    this.distinctWords = distinctWords;
  }

  /**
   * Constructor init counts
   * and root node.
   */
  public BinarySearchTree() {
    root = null;
    setCharCount(0);
    setDistinctWords(0);
    setTotalWords(0);
    MyLogger.writeMessage("Init BinarySearchTree", MyLogger.DebugLevel.CONSTRUCTOR);
  }

  /**
   * Insertion main logic, would need this
   * ToDo : synchronized locking for threads
   * @return
   */
  public synchronized void insert(String key) {
    setRoot(insertRec(getRoot(), key));
  }

  /**
   * Recursively create nodes of the tree
   * key is the string passed in.
   */
  public Node insertRec(Node node, String key) {
    // Empty? => returns a new node
    if (node == null) {
      return new Node(key);
    }
    // Traverse subtree nodes and add nodes
    if (key.compareTo(node.key) < 0)
      node.left = insertRec(node.left, key);
    else if (key.compareTo(node.key) > 0)
      node.right = insertRec(node.right, key);
    else
      // Set word count for current node if repeated
      node.setWordCount(node.getWordCount() + 1);
    return node;
  }

  // Computes the counters.
  public void computeCount()  {
    computeCountHelper(getRoot());
  }

  /**
   * Compute helper for counting
   * stores the counts in tree's
   * data members
   */
  private void computeCountHelper(Node node) {
    if (node != null) {
      computeCountHelper(node.left);
      MyLogger.writeMessage(node.key + " -- " + node.getWordCount(), MyLogger.DebugLevel.IN_RUN);
      if (node.getWordCount() > 0)
        this.setDistinctWords(this.getDistinctWords() + 1);
      this.setTotalWords(this.getTotalWords() + node.getWordCount());
      this.setCharCount(this.getCharCount() + (node.getWordCount() * node.key.length()));
      computeCountHelper(node.right);
    }
  }

  /**
   * Delete the given key from the tree and reduce count
   * Initially, root is null or key is present at root
   * Raise Exception if not found
   * @param node
   * @param key
   * @return
   */
  public synchronized Node deleteWord(Node node, String key)
  {
    try {
      if (node == null || node.key.equals(key)) {
        if (node != null && node.getWordCount() > 0) {
          node.setWordCount(node.getWordCount() - 1);
          return node;
        }
      }
      // if the word compared is > current
      if (node.key.compareTo(key) > 0)
        return deleteWord(node.left, key);

      // if < than current word
      return deleteWord(node.right, key);
    }
    catch (Exception ex) {
      MyLogger.writeMessage("Word NOT Exists :- " + key, MyLogger.DebugLevel.IN_RUN);
    }
    return null;
  }
}