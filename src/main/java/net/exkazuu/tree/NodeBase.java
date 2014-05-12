package net.exkazuu.tree;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.google.common.base.Preconditions;

/**
 * Represents a node instead of XElement.
 */
public class NodeBase<TNode extends NodeBase<TNode, TValue>, TValue> {

  /**
   * Gets the parent node.
   */
  protected TNode _parent;

  /**
   * Gets the previous node.
   */
  protected TNode _cyclicPrev;

  /**
   * Gets the next node.
   */
  protected TNode _cyclicNext;

  /**
   * Gets and sets the value.
   */
  protected TValue _value;

  /**
   * Gets the first child node.
   */
  protected TNode _firstChild;

  /**
   * Initializes a new instance of the Node class with a default value.
   */
  protected NodeBase() {
    _cyclicPrev = getThisNode();
    _cyclicNext = getThisNode();
  }

  /**
   * Initializes a new instance of the Node class with the specified value.
   */
  protected NodeBase(TValue value) {
    _cyclicPrev = getThisNode();
    _cyclicNext = getThisNode();
    _value = value;
  }

  /**
   * The casted this instance for the simplicity.
   */
  @SuppressWarnings("unchecked")
  protected final TNode getThisNode() {
    return (TNode) this;
  }

  /**
   * Gets the parent node.
   */
  public final TNode getParent() {
    return _parent;
  }

  /**
   * Gets the previous node.
   */
  public final TNode getCyclicPrev() {
    return _cyclicPrev;
  }

  /**
   * Gets the next node.
   */
  public final TNode getCyclicNext() {
    return _cyclicNext;
  }

  /**
   * Gets the first child node.
   */
  public final TNode getFirstChild() {
    return _firstChild;
  }

  /**
   * Gets the last child node.
   */
  public final TNode getLastChild() {
    return _firstChild != null ? _firstChild._cyclicPrev : null;
  }

  /**
   * Gets the previous node or null.
   */
  public final TNode getPrev() {
    return _cyclicPrev != getLastSibling() ? _cyclicPrev : null;
  }

  /**
   * Gets the next node or null.
   */
  public final TNode getNext() {
    return _cyclicNext != getFirstSibling() ? _cyclicNext : null;
  }

  /**
   * Gets the first sibling node or the current node.
   */
  public final TNode getFirstSibling() {
    return _parent != null ? _parent._firstChild : getThisNode();
  }

  /**
   * Gets the last sibling node or the current node.
   */
  public final TNode getLastSibling() {
    return _parent != null ? _parent._firstChild._cyclicPrev : getThisNode();
  }

  public final Iterable<TNode> getAncestorsAndSelf() {
    final TNode thisNode = getThisNode();
    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _node = thisNode;

          @Override
          public boolean hasNext() {
            return _node != null;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            TNode previousNode = _node;
            _node = previousNode._parent;
            return previousNode;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final Iterable<TNode> getChildren() {
    final TNode head = _firstChild;
    if (head == null) {
      return Collections.emptyList();
    }
    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _node = head;
          private boolean _hasNext = true;

          @Override
          public boolean hasNext() {
            return _hasNext;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            TNode previousNode = _node;
            _node = previousNode._cyclicNext;
            _hasNext = _node != head;
            return previousNode;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final Iterable<TNode> getNextsFromSelf() {
    final TNode node = _cyclicNext;
    final TNode terminal = getFirstSibling();

    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _node = node;

          @Override
          public boolean hasNext() {
            return _node != terminal;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            TNode previousNode = _node;
            _node = previousNode._cyclicNext;
            return previousNode;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final Iterable<TNode> getNextsFromLast() {
    final TNode node = getLastSibling();
    final TNode terminal = getThisNode();

    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _node = node;

          @Override
          public boolean hasNext() {
            return _node != terminal;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            TNode previousNode = _node;
            _node = previousNode._cyclicPrev;
            return previousNode;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final Iterable<TNode> getPrevsFromFirst() {
    final TNode node = getFirstSibling();
    final TNode terminal = getThisNode();

    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _node = node;

          @Override
          public boolean hasNext() {
            return _node != terminal;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            TNode previousNode = _node;
            _node = previousNode._cyclicNext;
            return previousNode;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final Iterable<TNode> getPrevsFromSelf() {
    final TNode node = _cyclicPrev;
    final TNode terminal = getLastSibling();

    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _node = node;

          @Override
          public boolean hasNext() {
            return _node != terminal;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            TNode previousNode = _node;
            _node = previousNode._cyclicPrev;
            return previousNode;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final Iterable<TNode> getDescendants() {
    final TNode start = getThisNode();
    if (start._firstChild == null) {
      return Collections.emptyList();
    }

    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _next = start._firstChild;

          @Override
          public boolean hasNext() {
            return _next != null;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            TNode node = _next;
            _next = privateNext(node);
            return node;
          }

          private TNode privateNext(TNode cursor) {
            if (cursor._firstChild != null) {
              cursor = cursor._firstChild;
              return cursor;
            }
            while (cursor.getNext() == null) {
              cursor = cursor._parent;
              if (cursor == start) {
                return null;
              }
            }
            cursor = cursor._cyclicNext;
            return cursor;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final Iterable<TNode> getSiblings() {
    TNode head = getFirstSibling();
    if (head == null || head._cyclicNext == head) {
      return Collections.emptyList();
    }
    final TNode thisNode = getThisNode();
    final TNode terminal = head != thisNode ? head : head._cyclicNext;
    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _node = terminal;
          private boolean _hasNext = true;

          @Override
          public boolean hasNext() {
            return _hasNext;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            TNode previousNode = _node;
            _node = previousNode._cyclicNext;
            if (_node == thisNode) {
              _node = _node._cyclicNext;
            }
            _hasNext = _node != terminal;
            return previousNode;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final Iterable<TNode> getSiblingsAndSelf() {
    final TNode head = getFirstSibling();
    if (head == null) {
      return Collections.emptyList();
    }
    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _node = head;
          private boolean _hasNext = true;

          @Override
          public boolean hasNext() {
            return _hasNext;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            TNode previousNode = _node;
            _node = previousNode._cyclicNext;
            _hasNext = _node != head;
            return previousNode;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final Iterable<TNode> getAncestorsWithSingleChild() {
    final TNode node = getThisNode();
    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _node = node;

          @Override
          public boolean hasNext() {
            return _node != null && _node == _node._cyclicNext;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            _node = _node._parent;
            return _node;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final Iterable<TNode> getDescendantsOfSingle() {
    final TNode node = _firstChild;
    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _node = node;

          @Override
          public boolean hasNext() {
            return _node != null && _node == _node._cyclicNext;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            TNode previousNode = _node;
            _node = _node._firstChild;
            return previousNode;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final Iterable<TNode> getDescendantsOfFirstChild() {
    final TNode node = _firstChild;
    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _node = node;

          @Override
          public boolean hasNext() {
            return _node != null;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            TNode previousNode = _node;
            _node = _node._firstChild;
            return previousNode;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final Iterable<TNode> getDescendants(final int inclusiveDepth) {
    final TNode start = getThisNode();
    if (start._firstChild == null || inclusiveDepth <= 0) {
      return Collections.emptyList();
    }

    return new Iterable<TNode>() {
      @Override
      public Iterator<TNode> iterator() {
        return new Iterator<TNode>() {
          private TNode _next = start._firstChild;
          private int _inclusiveDepth = inclusiveDepth - 1;

          @Override
          public boolean hasNext() {
            return _next != null;
          }

          @Override
          public TNode next() {
            if (!hasNext()) {
              throw new NoSuchElementException();
            }
            TNode node = _next;
            _next = privateNext(node);
            return node;
          }

          private TNode privateNext(TNode cursor) {
            if (cursor._firstChild != null && _inclusiveDepth > 0) {
              cursor = cursor._firstChild;
              _inclusiveDepth--;
              return cursor;
            }
            while (cursor.getNext() == null) {
              cursor = cursor._parent;
              _inclusiveDepth++;
              if (cursor == start) {
                return null;
              }
            }
            cursor = cursor._cyclicNext;
            return cursor;
          }

          @Override
          public void remove() {
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public final TNode AddPrevious(TNode node) {
    Preconditions.checkNotNull(node);
    Preconditions.checkNotNull(_parent);
    Preconditions.checkArgument(node._parent == null);
    if (_parent._firstChild == this) {
      _parent._firstChild = node;
    }
    return AddPreviousIgnoringFirstChild(node);
  }

  public final TNode AddNext(TNode node) {
    Preconditions.checkNotNull(node);
    Preconditions.checkNotNull(_parent);
    Preconditions.checkArgument(node._parent == null);
    return _cyclicNext.AddPreviousIgnoringFirstChild(node);
  }

  public final TNode AddFirst(TNode node) {
    Preconditions.checkNotNull(node);
    Preconditions.checkArgument(node._parent == null);
    return AddFirstPrivate(node);
  }

  private final TNode AddFirstPrivate(TNode node) {
    AddLastPrivate(node);
    _firstChild = node;
    return node;
  }

  protected final TNode AddPreviousIgnoringFirstChild(TNode node) {
    node._parent = _parent;
    node._cyclicNext = getThisNode();
    node._cyclicPrev = _cyclicPrev;
    _cyclicPrev._cyclicNext = node;
    _cyclicPrev = node;
    return node;
  }

  public final TNode AddLast(TNode node) {
    Preconditions.checkNotNull(node);
    Preconditions.checkArgument(node._parent == null);
    return AddLastPrivate(node);
  }

  private final TNode AddLastPrivate(TNode node) {
    TNode second = _firstChild;
    if (second == null) {
      node._parent = getThisNode();
      node._cyclicNext = node;
      node._cyclicPrev = node;
      _firstChild = node;
    } else {
      second.AddPreviousIgnoringFirstChild(node);
    }
    return node;
  }

  public final boolean Remove() {
    if (_parent == null) {
      return false;
    }
    if (_cyclicNext != this) {
      if (_parent._firstChild == this) {
        _parent._firstChild = _cyclicNext;
      }
      _cyclicPrev._cyclicNext = _cyclicNext;
      _cyclicNext._cyclicPrev = _cyclicPrev;
    } else {
      _parent._firstChild = null;
    }
    _cyclicNext = null;
    _cyclicPrev = null;
    _parent = null;
    return true;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    ToStringPrivate(getThisNode(), 0, builder);
    return builder.toString();
  }

  private final static <TNode extends NodeBase<TNode, T>, T> void ToStringPrivate(TNode node,
      int depth, StringBuilder builder) {
    if (node == null) {
      return;
    }
    for (int i = 0; i < depth; i++) {
      builder.append("  ");
    }

    builder.append(node._value != null ? node._value.toString() : "");
    builder.append(System.lineSeparator());
    for (TNode child : node.getChildren()) {
      ToStringPrivate(child, depth + 1, builder);
    }
  }
}
