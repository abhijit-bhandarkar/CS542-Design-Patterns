package fileVisitors.visitor;

import fileVisitors.util.BinarySearchTree;
import fileVisitors.util.FileProcessor;
import fileVisitors.util.MyLogger;

public class PopulateVisitor implements VisitorI {
  private String inputFile;

  public BinarySearchTree visit(BinarySearchTree bst) {
    String line;
    MyLogger.writeMessage("\n-----------------------------", MyLogger.DebugLevel.IN_RUN);
    MyLogger.writeMessage("\tPopulate Visitor : ", MyLogger.DebugLevel.IN_RUN);
    MyLogger.writeMessage("-----------------------------", MyLogger.DebugLevel.IN_RUN);

    FileProcessor fp = new FileProcessor(inputFile);
    while (!(line = fp.readLine()).equals("EOF")) {
      if (!line.replaceAll("[\\n\\r]+", " ").trim().isEmpty()) {
        MyLogger.writeMessage(line, MyLogger.DebugLevel.IN_RUN);
        String[] contents = line.split("[\\s\\t\\r\\n]+");
        for (String word : contents) {
          bst.insert(word);
        }
      }
    }
    return bst;
  }

  public PopulateVisitor(String in) {
    inputFile = in;
    MyLogger.writeMessage("Init PopulateVisitor", MyLogger.DebugLevel.CONSTRUCTOR);
  }
}
