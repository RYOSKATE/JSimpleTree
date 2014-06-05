package net.exkazuu.tree;

import net.exkazuu.tree.NamedNode;

@SuppressWarnings("all")
public class StringNode extends NamedNode<StringNode, String> {
  public StringNode(final String node) {
    super(node);
  }
  
  public final String getValue() {
    return this._value;
  }
  
  public final String setValue(final String value) {
    return this._value = value;
  }
  
  public final StringNode AddFirst(final String value) {
    StringNode _stringNode = new StringNode(value);
    return this.addFirst(_stringNode);
  }
  
  public final StringNode AddLast(final String value) {
    StringNode _stringNode = new StringNode(value);
    return this.addLast(_stringNode);
  }
  
  public final StringNode AddNext(final String value) {
    StringNode _stringNode = new StringNode(value);
    return this.addNext(_stringNode);
  }
  
  public final StringNode AddPrevious(final String value) {
    StringNode _stringNode = new StringNode(value);
    return this.addPrevious(_stringNode);
  }
}
