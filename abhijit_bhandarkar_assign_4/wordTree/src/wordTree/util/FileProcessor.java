package wordTree.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
  private BufferedReader bufferedReader = null;
  /**
   * @return : If
   * - Line Exists: Return one line at a time from a file
   * - Line Does Not Exist: A blank string
   */
  public synchronized String readLine() {
    String line;
    try {
      if ((line = bufferedReader.readLine()) != null) return line;
    } catch (IOException e) {
      e.printStackTrace();
      MyLogger.writeMessage("ERROR: Couldn't read next line from input file.", MyLogger.DebugLevel.IN_RUN);
      System.exit(1);
    }
    return "EOF";
  }

  /**
   * Default Constructor : For initializations & instantiation.
   */
  public FileProcessor(String inf) {
    try {
      bufferedReader = new BufferedReader(new FileReader(inf));
    } catch (IOException e) {
      e.printStackTrace();
      MyLogger.writeMessage("FileProcessor Init", MyLogger.DebugLevel.CONSTRUCTOR);
      MyLogger.writeMessage("Cannot Find Input File named " + inf, MyLogger.DebugLevel.IN_RUN);
      System.exit(1);
    }
  }
}