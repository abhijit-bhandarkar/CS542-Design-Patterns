package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.BinarySearchTree;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

public class DeleteThread implements Runnable {
  private volatile Results rs;
  private volatile FileProcessor fp;
  private String delete_word;
  private volatile BinarySearchTree bst;

  /**
   * Delete processor class that every word
   * thread would execute and process delete
   * @param bst
   * @param delete_word
   */
  public DeleteThread(FileProcessor fp, Results rs, BinarySearchTree bst, String delete_word) {
    this.rs = rs;
    this.fp = fp;
    this.bst = bst;
    this.delete_word = delete_word;
    MyLogger.writeMessage("Init DeleteThread", MyLogger.DebugLevel.CONSTRUCTOR);
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
  public synchronized void run() {
    MyLogger.writeMessage("Delete Thread Run Called", MyLogger.DebugLevel.FROM_RESULTS);
    bst.deleteWord(bst.getRoot(), delete_word);
  }
}
