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
    _cyclicPrev = thisNode();
    _cyclicNext = thisNode();
  }

  /**
   * Initializes a new instance of the Node class with the specified value.
   */
  protected NodeBase(TValue value) {
    _cyclicPrev = thisNode();
    _cyclicNext = thisNode();
    _value = value;
  }

  /**
   * The casted this instance for the simplicity.
   */
  @SuppressWarnings("unchecked")
  protected final TNode thisNode() {
    return (TNode) this;
  }

  /**
   * Gets the parent node.
   */
  public final TNode parent() {
    return _parent;
  }

  /**
   * Gets the previous node.
   */
  public final TNode cyclicPrev() {
    return _cyclicPrev;
  }

  /**
   * Gets the next node.
   */
  public final TNode cyclicNext() {
    return _cyclicNext;
  }

  /**
   * Gets the first child node.
   */
  public final TNode firstChild() {
    return _firstChild;
  }

  /**
   * Gets the last child node.
   */
  public final TNode lastChild() {
    return _firstChild != null ? _firstChild._cyclicPrev : null;
  }

  /**
   * Gets the previous node or null.
   */
  public final TNode prev() {
    return _cyclicPrev != lastSibling() ? _cyclicPrev : null;
  }

  /**
   * Gets the next node or null.
   */
  public final TNode next() {
    return _cyclicNext != firstSibling() ? _cyclicNext : null;
  }

  /**
   * Gets the first sibling node or the current node.
   */
  public final TNode firstSibling() {
    return _parent != null ? _parent._firstChild : thisNode();
  }

  /**
   * Gets the last sibling node or the current node.
   */
  public final TNode lastSibling() {
    return _parent != null ? _parent._firstChild._cyclicPrev : thisNode();
  }

  public final Iterable<TNode> ancestorsAndSelf() {
    final TNode thisNode = thisNode();
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

  public final Iterable<TNode> children() {
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

  public final Iterable<TNode> nextsFromSelf() {
    final TNode node = _cyclicNext;
    final TNode terminal = firstSibling();

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

  public final Iterable<TNode> nextsFromLast() {
    final TNode node = lastSibling();
    final TNode terminal = thisNode();

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

  public final Iterable<TNode> prevsFromFirst() {
    final TNode node = firstSibling();
    final TNode terminal = thisNode();

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

  public final Iterable<TNode> prevsFromSelf() {
    final TNode node = _cyclicPrev;
    final TNode terminal = lastSibling();

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

  public final Iterable<TNode> descendants() {
    final TNode start = thisNode();
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
            while (cursor.next() == null) {
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

  public final Iterable<TNode> siblings() {
    TNode head = firstSibling();
    if (head == null || head._cyclicNext == head) {
      return Collections.emptyList();
    }
    final TNode thisNode = thisNode();
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

  public final Iterable<TNode> siblingsAndSelf() {
    final TNode head = firstSibling();
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

  public final Iterable<TNode> ancestorsWithSingleChild() {
    final TNode node = thisNode();
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

  public final Iterable<TNode> descendantsOfSingle() {
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

  public final Iterable<TNode> descendantsOfFirstChild() {
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

  public final Iterable<TNode> descendants(final int inclusiveDepth) {
    final TNode start = thisNode();
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
            while (cursor.next() == null) {
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

  public final TNode addPrevious(TNode node) {
    Preconditions.checkNotNull(node);
    Preconditions.checkNotNull(_parent);
    Preconditions.checkArgument(node._parent == null);
    if (_parent._firstChild == this) {
      _parent._firstChild = node;
    }
    return addPreviousIgnoringFirstChild(node);
  }

  public final TNode addNext(TNode node) {
    Preconditions.checkNotNull(node);
    Preconditions.checkNotNull(_parent);
    Preconditions.checkArgument(node._parent == null);
    return _cyclicNext.addPreviousIgnoringFirstChild(node);
  }

  public final TNode addFirst(TNode node) {
    Preconditions.checkNotNull(node);
    Preconditions.checkArgument(node._parent == null);
    return addFirstPrivate(node);
  }

  private final TNode addFirstPrivate(TNode node) {
    addLastPrivate(node);
    _firstChild = node;
    return node;
  }

  protected final TNode addPreviousIgnoringFirstChild(TNode node) {
    node._parent = _parent;
    node._cyclicNext = thisNode();
    node._cyclicPrev = _cyclicPrev;
    _cyclicPrev._cyclicNext = node;
    _cyclicPrev = node;
    return node;
  }

  public final TNode addLast(TNode node) {
    Preconditions.checkNotNull(node);
    Preconditions.checkArgument(node._parent == null);
    return addLastPrivate(node);
  }

  private final TNode addLastPrivate(TNode node) {
    TNode second = _firstChild;
    if (second == null) {
      node._parent = thisNode();
      node._cyclicNext = node;
      node._cyclicPrev = node;
      _firstChild = node;
    } else {
      second.addPreviousIgnoringFirstChild(node);
    }
    return node;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    toStringPrivate(thisNode(), 0, builder);
    return builder.toString();
  }

  private final static <TNode extends NodeBase<TNode, T>, T> void toStringPrivate(TNode node,
      int depth, StringBuilder builder) {
    if (node == null) {
      return;
    }
    for (int i = 0; i < depth; i++) {
      builder.append("  ");
    }

    builder.append(node._value != null ? node._value.toString() : "");
    builder.append(System.lineSeparator());
    for (TNode child : node.children()) {
      toStringPrivate(child, depth + 1, builder);
    }
  }
}
