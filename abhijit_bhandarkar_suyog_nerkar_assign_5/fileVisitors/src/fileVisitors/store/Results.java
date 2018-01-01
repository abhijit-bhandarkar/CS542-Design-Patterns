package fileVisitors.store;

import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.IOException;
import fileVisitors.util.*;

public class Results implements FileDisplayInterface, StdoutDisplayInterface {
  /**
   * Private data member to store Strings.
   */
  private ArrayList<String> result;

  /**
   * @param p : String as path.
   */
  @Override
  public void writeToFile(String p) {
    PrintWriter wr;
    MyLogger.writeMessage("- Write Results to File", MyLogger.DebugLevel.IN_RESULTS);
    try {
      wr = new PrintWriter(p);
      for (int i = 0; i < result.size(); i++) {
        wr.write(result.get(i));
      }
      wr.close();
    }
    catch (IOException e) {
      System.err.println("- Cannot write results to output. Check the path provided.");
      e.printStackTrace();
      System.exit(1);
    }
  }

  /**
   * Push newly found results into an array.
   * @param res
   */
  public void pushResult(String res) {
    MyLogger.writeMessage("- Push to Results", MyLogger.DebugLevel.IN_RESULTS);
    result.add(res);
  }

  /**
   * Write a string to Std. Output.
   * @param s : String to write.
   */
  @Override
  public void writeToStdout(String s) {
    MyLogger.writeMessage("- Write Results to STDOUT", MyLogger.DebugLevel.IN_RESULTS);
    System.out.println(s);
  }

  /**
   * Default Constructor
   */
  public Results() {
    MyLogger.writeMessage("- Init Results Constructor", MyLogger.DebugLevel.CONSTRUCTOR);
    result = new ArrayList<>();
  }
}