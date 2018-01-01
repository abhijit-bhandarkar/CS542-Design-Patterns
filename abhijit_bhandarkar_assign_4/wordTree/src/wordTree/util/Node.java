package wordTree.util;

/**
 * Stores the word along with it's children and
 * the current count for repetitions.
 */
public class Node {
  String key;
  // Child nodes
  Node left, right;

  // Self count for repeated words.
  private int wordCount;

  // Constructor
  public Node(String item) {
    key = item;
    left = right = null;
    setWordCount(1);
    MyLogger.writeMessage("Init Node", MyLogger.DebugLevel.CONSTRUCTOR);
  }

  /**
   * Getters
   * @return
   */
  public String getKey() {
    return key;
  }
  public int getWordCount() {
    return wordCount;
  }

  /**
   * Setters
   * @param key
   */
  public void setKey(String key) {
    this.key = key;
  }
  public void setWordCount(int wordCount) {
    this.wordCount = wordCount;
  }
}