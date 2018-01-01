package fileVisitors.util;

public class PalindromeCheck {

  /**
   * Check if palindrome
   *  - yes? : check if length > 3
   *    -- yes? : CAPITALIZE
   *    -- no?  : return key as it was
   *  - no? : return key as it was
   * @param key : To check for if palindrome?
   * @return : String capitalized as per conditions
   */
  public String checkAndHighlight(String key) {
    MyLogger.writeMessage(key + " :: " + new StringBuilder(key).reverse().toString(), MyLogger.DebugLevel.IN_RUN);
    if (key.equalsIgnoreCase(new StringBuilder(key).reverse().toString())) {
      if (key.length() > 3) { return key.toUpperCase(); } else { return key; }
    } else {
      return key;
    }
  }
}
