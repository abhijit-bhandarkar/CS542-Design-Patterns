package wordTree.threadMgmt;

import wordTree.store.Results;
import wordTree.util.BinarySearchTree;
import wordTree.util.FileProcessor;
import wordTree.util.MyLogger;

public class CreateWorkers {
  private volatile Results rs;
  private volatile FileProcessor fp;
  private volatile BinarySearchTree bst;

  public CreateWorkers(FileProcessor fp, BinarySearchTree bst, Results rs){
    this.fp = fp;
    this.bst = bst;
    this.rs =rs;
    MyLogger.writeMessage("Init CreateWorkers", MyLogger.DebugLevel.CONSTRUCTOR);
  }

  public void startPopulateWorkers(int num_threads) {
    int i;
    PopulateThread pt;
    Thread threadPool[] = new Thread[num_threads];

    // Create and start threads in a pool
    for (i = 0; i < num_threads; i++) {
      pt = new PopulateThread(fp, bst, rs);
      threadPool[i] = new Thread(pt);
      threadPool[i].start();
    }

    // Join the created threads so that each
    // one executes on its own time slot.
    for (i = 0; i < num_threads; i++) {
      try {
        threadPool[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    MyLogger.writeMessage("------------------------------------", MyLogger.DebugLevel.IN_RUN);
  }


  public void startDeleteWorkers(int num_threads, String[] delete_words) {
    int i;
    DeleteThread dt;
    Thread threadPool[] = new Thread[num_threads];
    // Create and start threads in a pool
    for (i = 0; i < num_threads; i++) {
      dt = new DeleteThread(fp, rs, bst, delete_words[i]);
      threadPool[i] = new Thread(dt);
      threadPool[i].start();
    }

    // Join the created threads so that each
    // one executes on its own time slot.
    for (i = 0; i < num_threads; i++) {
      try {
        threadPool[i].join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
