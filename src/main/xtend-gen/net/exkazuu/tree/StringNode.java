package net.exkazuu.tree;

import net.exkazuu.tree.NamedNode;

@SuppressWarnings("all")
public class StringNode extends NamedNode<StringNode,String> {
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
    return this.AddFirst(_stringNode);
  }
  
  public final StringNode AddLast(final String value) {
    StringNode _stringNode = new StringNode(value);
    return this.AddLast(_stringNode);
  }
  
  public final StringNode AddNext(final String value) {
    StringNode _stringNode = new StringNode(value);
    return this.AddNext(_stringNode);
  }
  
  public final StringNode AddPrevious(final String value) {
    StringNode _stringNode = new StringNode(value);
    return this.AddPrevious(_stringNode);
  }
}
