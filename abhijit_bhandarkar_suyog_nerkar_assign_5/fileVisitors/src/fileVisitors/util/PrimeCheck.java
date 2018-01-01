package fileVisitors.util;

public class PrimeCheck {
  public String checkAndAppend(String key) {
    // Not prime if key length less than two
    if (key.length() < 2) { return key; }

    // Checks if Non-Prime :
    // Iterate from 2 to the square root of the
    // length i.e. the Greatest Factor of length
    // possible.
    for (int i = 2; i < (int) Math.sqrt(key.length()) + 1; i++) {
      if (key.length() % i == 0) {
        return key;
      }
    }

    // If not Non-Prime, append -PRIME suffix
    MyLogger.writeMessage(key + " :: " + key.concat("-PRIME"), MyLogger.DebugLevel.IN_RUN);
    return key.concat("-PRIME");
  }
}
