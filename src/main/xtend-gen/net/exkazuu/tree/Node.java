package net.exkazuu.tree;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import net.exkazuu.tree.NodeBase;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class Node<TNode extends Node<TNode, TValue>, TValue extends Object> extends NodeBase<TNode, TValue> {
  /**
   * Initializes a new instance of the Node class with a default value.
   */
  protected Node() {
  }
  
  /**
   * Initializes a new instance of the Node class with the specified value.
   */
  protected Node(final TValue value) {
    super(value);
  }
  
  public final int childrenCount() {
    Iterable<TNode> _children = this.children();
    return ((Object[])Conversions.unwrapArray(_children, Object.class)).length;
  }
  
  public final TNode childAtOrNull(final int index) {
    Iterable<TNode> _children = this.children();
    Iterable<TNode> _drop = IterableExtensions.<TNode>drop(_children, index);
    return IterableExtensions.<TNode>head(_drop);
  }
  
  public final Iterable<TNode> ancestors() {
    Iterable<TNode> _ancestorsAndSelf = this.ancestorsAndSelf();
    return IterableExtensions.<TNode>tail(_ancestorsAndSelf);
  }
  
  public final Iterable<TNode> getNextsFromSelfAndSelf() {
    TNode _thisNode = this.thisNode();
    Iterable<TNode> _nextsFromSelf = this.nextsFromSelf();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _nextsFromSelf);
  }
  
  public final Iterable<TNode> getNextsFromLastAndSelf() {
    Iterable<TNode> _nextsFromLast = this.nextsFromLast();
    TNode _thisNode = this.thisNode();
    return Iterables.<TNode>concat(_nextsFromLast, Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)));
  }
  
  public final Iterable<TNode> prevsFromFirstAndSelf() {
    Iterable<TNode> _prevsFromFirst = this.prevsFromFirst();
    TNode _thisNode = this.thisNode();
    return Iterables.<TNode>concat(_prevsFromFirst, Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)));
  }
  
  public final Iterable<TNode> prevsFromSelfAndSelf() {
    TNode _thisNode = this.thisNode();
    Iterable<TNode> _prevsFromSelf = this.prevsFromSelf();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _prevsFromSelf);
  }
  
  public final Iterable<TNode> descendantsAndSelf() {
    TNode _thisNode = this.thisNode();
    Iterable<TNode> _descendants = this.descendants();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _descendants);
  }
  
  public final Iterable<TNode> ancestorsAndSiblingsAfterSelf() {
    Iterable<TNode> _ancestorsAndSelf = this.ancestorsAndSelf();
    final Function1<TNode, Iterable<TNode>> _function = new Function1<TNode, Iterable<TNode>>() {
      public Iterable<TNode> apply(final TNode it) {
        return it.nextsFromSelf();
      }
    };
    Iterable<Iterable<TNode>> _map = IterableExtensions.<TNode, Iterable<TNode>>map(_ancestorsAndSelf, _function);
    return Iterables.<TNode>concat(_map);
  }
  
  public final Iterable<TNode> ancestorsAndSiblingsAfterSelfAndSelf() {
    TNode _thisNode = this.thisNode();
    Iterable<TNode> _ancestorsAndSiblingsAfterSelf = this.ancestorsAndSiblingsAfterSelf();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _ancestorsAndSiblingsAfterSelf);
  }
  
  public final Iterable<TNode> ancestorsAndSiblingsBeforeSelf() {
    Iterable<TNode> _ancestorsAndSiblingsBeforeSelfAndSelf = this.ancestorsAndSiblingsBeforeSelfAndSelf();
    return IterableExtensions.<TNode>tail(_ancestorsAndSiblingsBeforeSelfAndSelf);
  }
  
  public final Iterable<TNode> ancestorsAndSiblingsBeforeSelfAndSelf() {
    Iterable<TNode> _ancestorsAndSelf = this.ancestorsAndSelf();
    final Function1<TNode, Iterable<TNode>> _function = new Function1<TNode, Iterable<TNode>>() {
      public Iterable<TNode> apply(final TNode it) {
        return it.prevsFromSelfAndSelf();
      }
    };
    Iterable<Iterable<TNode>> _map = IterableExtensions.<TNode, Iterable<TNode>>map(_ancestorsAndSelf, _function);
    return Iterables.<TNode>concat(_map);
  }
  
  public final Iterable<TNode> ancestorsWithSingleChildAndSelf() {
    TNode _thisNode = this.thisNode();
    Iterable<TNode> _ancestorsWithSingleChild = this.ancestorsWithSingleChild();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _ancestorsWithSingleChild);
  }
  
  public final Iterable<TNode> descendantsOfSingleAndSelf() {
    TNode _thisNode = this.thisNode();
    Iterable<TNode> _descendantsOfSingle = this.descendantsOfSingle();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _descendantsOfSingle);
  }
  
  public final Iterable<TNode> descendantsOfFirstChildAndSelf() {
    TNode _thisNode = this.thisNode();
    Iterable<TNode> _descendantsOfFirstChild = this.descendantsOfFirstChild();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _descendantsOfFirstChild);
  }
  
  public final Iterable<TNode> ancestors(final int inclusiveDepth) {
    Iterable<TNode> _ancestors = this.ancestors();
    return IterableExtensions.<TNode>take(_ancestors, inclusiveDepth);
  }
  
  public final Iterable<TNode> ancestorsAndSelf(final int inclusiveDepth) {
    Iterable<TNode> _ancestorsAndSelf = this.ancestorsAndSelf();
    return IterableExtensions.<TNode>take(_ancestorsAndSelf, (inclusiveDepth + 1));
  }
  
  public final Iterable<TNode> descendantsAndSelf(final int inclusiveDepth) {
    TNode _thisNode = this.thisNode();
    Iterable<TNode> _descendants = this.descendants(inclusiveDepth);
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _descendants);
  }
  
  public final Iterable<TNode> siblings(final int inclusiveEachLength) {
    Iterable<TNode> _prevsFromSelf = this.prevsFromSelf();
    Iterable<TNode> _take = IterableExtensions.<TNode>take(_prevsFromSelf, inclusiveEachLength);
    List<TNode> _list = IterableExtensions.<TNode>toList(_take);
    List<TNode> _reverse = ListExtensions.<TNode>reverse(_list);
    Iterable<TNode> _nextsFromSelf = this.nextsFromSelf();
    Iterable<TNode> _take_1 = IterableExtensions.<TNode>take(_nextsFromSelf, inclusiveEachLength);
    return Iterables.<TNode>concat(_reverse, _take_1);
  }
  
  public final Iterable<TNode> siblingsAndSelf(final int inclusiveEachLength) {
    Iterable<TNode> _prevsFromSelf = this.prevsFromSelf();
    Iterable<TNode> _take = IterableExtensions.<TNode>take(_prevsFromSelf, inclusiveEachLength);
    List<TNode> _list = IterableExtensions.<TNode>toList(_take);
    List<TNode> _reverse = ListExtensions.<TNode>reverse(_list);
    TNode _thisNode = this.thisNode();
    Iterable<TNode> _plus = Iterables.<TNode>concat(_reverse, Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)));
    Iterable<TNode> _nextsFromSelf = this.nextsFromSelf();
    Iterable<TNode> _take_1 = IterableExtensions.<TNode>take(_nextsFromSelf, inclusiveEachLength);
    return Iterables.<TNode>concat(_plus, _take_1);
  }
  
  public final Function0<TNode> remove() {
    boolean _equals = Objects.equal(this._parent, null);
    if (_equals) {
      return null;
    }
    final TNode next = this._cyclicNext;
    Function0<TNode> _xifexpression = null;
    boolean _notEquals = (!Objects.equal(next, this));
    if (_notEquals) {
      Function0<TNode> _xblockexpression = null;
      {
        this._cyclicPrev._cyclicNext = next;
        next._cyclicPrev = this._cyclicPrev;
        Function0<TNode> _xifexpression_1 = null;
        boolean _equals_1 = Objects.equal(this._parent._firstChild, this);
        if (_equals_1) {
          Function0<TNode> _xblockexpression_1 = null;
          {
            this._parent._firstChild = next;
            final Function0<TNode> _function = new Function0<TNode>() {
              public TNode apply() {
                TNode _xblockexpression = null;
                {
                  TNode _thisNode = Node.this.thisNode();
                  next._parent._firstChild = _thisNode;
                  TNode _thisNode_1 = Node.this.thisNode();
                  _xblockexpression = next.addPreviousIgnoringFirstChild(_thisNode_1);
                }
                return _xblockexpression;
              }
            };
            _xblockexpression_1 = _function;
          }
          _xifexpression_1 = _xblockexpression_1;
        } else {
          final Function0<TNode> _function = new Function0<TNode>() {
            public TNode apply() {
              TNode _thisNode = Node.this.thisNode();
              return next.addPreviousIgnoringFirstChild(_thisNode);
            }
          };
          _xifexpression_1 = _function;
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      Function0<TNode> _xblockexpression_1 = null;
      {
        final TNode parent = this._parent;
        parent._firstChild = null;
        final Function0<TNode> _function = new Function0<TNode>() {
          public TNode apply() {
            TNode _thisNode = Node.this.thisNode();
            return parent.addFirst(_thisNode);
          }
        };
        _xblockexpression_1 = _function;
      }
      _xifexpression = _xblockexpression_1;
    }
    final Function0<TNode> action = _xifexpression;
    this._cyclicNext = null;
    this._cyclicPrev = null;
    this._parent = null;
    return action;
  }
}
