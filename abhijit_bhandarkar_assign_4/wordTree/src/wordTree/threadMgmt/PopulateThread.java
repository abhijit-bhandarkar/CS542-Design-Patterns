package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.BinarySearchTree;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

public class PopulateThread implements Runnable{
  private volatile Results rs;
  private volatile FileProcessor fp;
  private volatile BinarySearchTree bst;

  public PopulateThread(FileProcessor fp, BinarySearchTree bst, Results rs) {
    this.fp = fp;
    this.bst = bst;
    this.rs =rs;
    MyLogger.writeMessage("Init PopulateThread", MyLogger.DebugLevel.CONSTRUCTOR);
  }

  /**
   * When an object implementing interface <code>Runnable</code> is used
   * to create a thread, starting the thread causes the object's
   * <code>run</code> method to be called in that separately executing
   * thread.
   * <p>
   * The general contract of the method <code>run</code> is that it may
   * take any action whatsoever.
   *
   * @see Thread#run()
   */
  @Override
  public void run() {
    String line;
    MyLogger.writeMessage("Populate Thread Run Called", MyLogger.DebugLevel.FROM_RESULTS);
    while (!(line = fp.readLine()).equals("EOF")) {
      if (!line.replaceAll("[\\n\\r]+", " ").trim().isEmpty()) {
        MyLogger.writeMessage(line, MyLogger.DebugLevel.IN_RUN);
        String[] contents = line.split("[\\s\\t\\r\\n]+");
        for (String word : contents) {
          bst.insert(word);
        }
      }
    }
  }
}
