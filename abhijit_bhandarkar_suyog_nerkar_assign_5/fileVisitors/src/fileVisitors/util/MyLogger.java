package fileVisitors.util;

public class MyLogger {

    /*DEBUG_VALUE=4 [Print to stdout every time a constructor is called]
      DEBUG_VALUE=3 [Open for future modifications]
      DEBUG_VALUE=2 [IN_RESULTS, prints any errors happening in printing results]
      DEBUG_VALUE=1 [IN_RUN, Used for full debug]
      DEBUG_VALUE=0 [No output should be printed from the application to stdout.
       It is ok to write to the output file though" ]
    */

  public enum DebugLevel {
    RELEASE,
    FROM_RESULTS,
    IN_RESULTS,
    IN_RUN,
    CONSTRUCTOR
  }

  private static DebugLevel debugLevel;

  public static void setDebugValue(int levelIn) {
    switch (levelIn) {
      case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
      case 3: debugLevel = DebugLevel.FROM_RESULTS; break;
      case 2: debugLevel = DebugLevel.IN_RESULTS; break;
      case 1: debugLevel = DebugLevel.IN_RUN; break;
      case 0: debugLevel = DebugLevel.RELEASE; break;
      default: debugLevel = DebugLevel.RELEASE;
    }
  }

  public static void setDebugValue(DebugLevel levelIn) {
    debugLevel = levelIn;
  }

  public static DebugLevel getDebugValue() {
    return debugLevel;
  }
  // @return None
  public static void writeMessage(String  message, DebugLevel levelIn) {
    if (levelIn == debugLevel)
      System.out.println(message);
  }

  /**
   * @return String
   */
  public String toString() {
    return "Debug Level is " + debugLevel;
  }
}