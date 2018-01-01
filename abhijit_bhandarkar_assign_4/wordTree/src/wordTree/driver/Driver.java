package wordTree.driver;

import wordTree.threadMgmt.CreateWorkers;
import wordTree.util.*;
import wordTree.store.Results;

public class Driver {

  public static void main(String[] args) {
    int debug = -1, num_threads = -1;
    String [] delete_words = null;

    if (args.length == 5) {
      if (args[0].equals("${arg0}")) {
        System.err.println("ERROR: Need a INPUT file as an argument, got " + args[0]);
        System.exit(1);
      } else if (args[1].equals("${arg1}")) {
        System.err.println("ERROR: Need a OUTPUT file as an argument, got " + args[1]);
        System.exit(1);
      } else if (args[2].equals("${arg2}")) {
        System.err.println("ERROR: Need NUM_THREADS as an argument, got " + args[2]);
        System.exit(1);
      } else if (args[3].equals("${arg3}")) {
        System.err.println("ERROR: Need DELETE WORDS as an argument, got " + args[3]);
        System.exit(1);
      } else if (args[4].equals("${arg4}")) {
        System.err.println("ERROR: Need a Debug Level as an argument, got " + args[4]);
        System.exit(1);
      }
      else {
        String in = args[0], out = args[1];

        // Num of threads validations
        try {
          num_threads = Integer.parseInt(args[2]);
        } catch (NumberFormatException e) {
          System.err.println("ERROR: Need a Number of Threads as a integer argument, got " + args[2]);
          e.printStackTrace();
          System.exit(1);
        }

        if ((num_threads < 1) || (num_threads > 3)) {
          System.err.println("ERROR: Number of threads must be in [1 - 3] , got " + num_threads);
          System.exit(1);
        }

        // Delete words validations
        try {
          delete_words = args[3].split(" ");
        } catch (Exception e) {
          System.err.println("ERROR: Not proper delete word list, got " + args[3]);
          e.printStackTrace();
          System.exit(1);
        }

        // Words equals threads
        if (delete_words.length != num_threads) {
          System.err.println("ERROR: Number of threads and Delete Words should be equal.");
          System.exit(1);
        }

        // Debug level validations
        try {
          debug = Integer.parseInt(args[4]);
        } catch (NumberFormatException e) {
          System.err.println("ERROR: Need a Debug Level as a number argument, got " + args[4]);
          e.printStackTrace();
          System.exit(1);
        }

        if ((debug < 0) || (debug > 4)) {
          System.err.println("ERROR: Need a Debug Level in [0 - 4] , got " + debug);
          System.exit(1);
        }

        MyLogger.setDebugValue(debug);
        MyLogger.writeMessage("SUCCESS: I have got all I need, let's proceed. \n" +
                "- Reading input from          : " + in + "\n" +
                "- Output will be written to   : " + out + "\n" +
                "- Debug level set to          : " + MyLogger.getDebugValue() + "\n\n",
            MyLogger.DebugLevel.IN_RUN
        );

        // Create instances
        FileProcessor inp = new FileProcessor(in);
        Results res = new Results();
        BinarySearchTree tree = new BinarySearchTree();

        MyLogger.writeMessage("\n------------------------------------", MyLogger.DebugLevel.IN_RUN);
        MyLogger.writeMessage("Processing input File : ", MyLogger.DebugLevel.IN_RUN);
        MyLogger.writeMessage("------------------------------------", MyLogger.DebugLevel.IN_RUN);

        CreateWorkers cr = new CreateWorkers( inp, tree, res);
        // Create workers for populating threads
        cr.startPopulateWorkers(num_threads);
        // Create workers for deleting threads.
        MyLogger.writeMessage("Log for Deleting the words :- \n", MyLogger.DebugLevel.IN_RUN);
        cr.startDeleteWorkers(num_threads, delete_words);
        MyLogger.writeMessage("\n------------------------------------", MyLogger.DebugLevel.IN_RUN);
        MyLogger.writeMessage("The count for individual words are :-\n", MyLogger.DebugLevel.IN_RUN);
        tree.computeCount();
        // Write results
        pushResultsToRes(res, tree, out);

        MyLogger.writeMessage("=================================", MyLogger.DebugLevel.IN_RUN);
        MyLogger.writeMessage("TotalWordCount : " + tree.getTotalWords(), MyLogger.DebugLevel.IN_RUN);
        MyLogger.writeMessage("DistinctWordCount : " + tree.getDistinctWords(), MyLogger.DebugLevel.IN_RUN);
        MyLogger.writeMessage("CharCount : " + tree.getCharCount(), MyLogger.DebugLevel.IN_RUN);
      }
    } else {
      // MyLogger not initialized yet, so need sys error.
      System.err.println("ERROR: Unexpected commandline arguments, got " + args.length + " args." +
          "\n- ADVICE: Please provide proper arguments to command listed below." +
          "\n- EXPECTED: ant -buildfile src/build.xml run -Darg0=<INPUT FILE NAME> -Darg1=<OUTPUT FILE NAME>" +
          " -Darg2=<NUM_THREADS> -Darg3=<DELETE WORDS> -Darg4=<LOGGER LEVEL>");
      System.exit(1);
    }
  }

  /**
   * Write results to the Results and print file
   * @param res
   * @param tree
   * @param out
   */
  private static void pushResultsToRes(Results res, BinarySearchTree tree, String out) {
    //  Write results into results data structure.
    res.pushResult(
        "The total number of words: " + tree.getTotalWords() + "\n" +
            "The total number of characters: " + tree.getDistinctWords() + "\n" +
            "The total number of distinct words: " + tree.getCharCount()
    );
    // Write to Output file
    res.writeToFile(out);
  }

  /**
   * Default class constructor, need results to store output to print
   */
  private Driver() {
    MyLogger.writeMessage("Init Driver", MyLogger.DebugLevel.CONSTRUCTOR);
  }
}