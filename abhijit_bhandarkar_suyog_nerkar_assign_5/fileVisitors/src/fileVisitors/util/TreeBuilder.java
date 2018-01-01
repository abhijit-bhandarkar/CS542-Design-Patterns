package fileVisitors.util;

import fileVisitors.visitor.VisitorI;

public interface TreeBuilder {
  void accept(VisitorI v);
}
