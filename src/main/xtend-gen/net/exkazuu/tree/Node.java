package net.exkazuu.tree;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import net.exkazuu.tree.NodeBase;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

@SuppressWarnings("all")
public class Node<TNode extends Node<TNode,TValue>, TValue extends Object> extends NodeBase<TNode,TValue> {
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
  
  public final int getChildrenCount() {
    Iterable<TNode> _children = this.getChildren();
    return ((Object[])Conversions.unwrapArray(_children, Object.class)).length;
  }
  
  public final TNode getChildAtOrNull(final int index) {
    Iterable<TNode> _children = this.getChildren();
    Iterable<TNode> _drop = IterableExtensions.<TNode>drop(_children, index);
    return IterableExtensions.<TNode>head(_drop);
  }
  
  public final Iterable<TNode> getAncestors() {
    Iterable<TNode> _ancestorsAndSelf = this.getAncestorsAndSelf();
    return IterableExtensions.<TNode>tail(_ancestorsAndSelf);
  }
  
  public final Iterable<TNode> getNextsFromSelfAndSelf() {
    TNode _thisNode = this.getThisNode();
    Iterable<TNode> _nextsFromSelf = this.getNextsFromSelf();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _nextsFromSelf);
  }
  
  public final Iterable<TNode> getNextsFromLastAndSelf() {
    Iterable<TNode> _nextsFromLast = this.getNextsFromLast();
    TNode _thisNode = this.getThisNode();
    return Iterables.<TNode>concat(_nextsFromLast, Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)));
  }
  
  public final Iterable<TNode> getPrevsFromFirstAndSelf() {
    Iterable<TNode> _prevsFromFirst = this.getPrevsFromFirst();
    TNode _thisNode = this.getThisNode();
    return Iterables.<TNode>concat(_prevsFromFirst, Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)));
  }
  
  public final Iterable<TNode> getPrevsFromSelfAndSelf() {
    TNode _thisNode = this.getThisNode();
    Iterable<TNode> _prevsFromSelf = this.getPrevsFromSelf();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _prevsFromSelf);
  }
  
  public final Iterable<TNode> getDescendantsAndSelf() {
    TNode _thisNode = this.getThisNode();
    Iterable<TNode> _descendants = this.getDescendants();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _descendants);
  }
  
  public final Iterable<TNode> getAncestorsAndSiblingsAfterSelf() {
    Iterable<TNode> _ancestorsAndSelf = this.getAncestorsAndSelf();
    final Function1<TNode,Iterable<TNode>> _function = new Function1<TNode,Iterable<TNode>>() {
      public Iterable<TNode> apply(final TNode it) {
        return it.getNextsFromSelf();
      }
    };
    Iterable<Iterable<TNode>> _map = IterableExtensions.<TNode, Iterable<TNode>>map(_ancestorsAndSelf, _function);
    return Iterables.<TNode>concat(_map);
  }
  
  public final Iterable<TNode> getAncestorsAndSiblingsAfterSelfAndSelf() {
    TNode _thisNode = this.getThisNode();
    Iterable<TNode> _ancestorsAndSiblingsAfterSelf = this.getAncestorsAndSiblingsAfterSelf();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _ancestorsAndSiblingsAfterSelf);
  }
  
  public final Iterable<TNode> getAncestorsAndSiblingsBeforeSelf() {
    Iterable<TNode> _ancestorsAndSiblingsBeforeSelfAndSelf = this.getAncestorsAndSiblingsBeforeSelfAndSelf();
    return IterableExtensions.<TNode>tail(_ancestorsAndSiblingsBeforeSelfAndSelf);
  }
  
  public final Iterable<TNode> getAncestorsAndSiblingsBeforeSelfAndSelf() {
    Iterable<TNode> _ancestorsAndSelf = this.getAncestorsAndSelf();
    final Function1<TNode,Iterable<TNode>> _function = new Function1<TNode,Iterable<TNode>>() {
      public Iterable<TNode> apply(final TNode it) {
        return it.getPrevsFromSelfAndSelf();
      }
    };
    Iterable<Iterable<TNode>> _map = IterableExtensions.<TNode, Iterable<TNode>>map(_ancestorsAndSelf, _function);
    return Iterables.<TNode>concat(_map);
  }
  
  public final Iterable<TNode> getAncestorsWithSingleChildAndSelf() {
    TNode _thisNode = this.getThisNode();
    Iterable<TNode> _ancestorsWithSingleChild = this.getAncestorsWithSingleChild();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _ancestorsWithSingleChild);
  }
  
  public final Iterable<TNode> getDescendantsOfSingleAndSelf() {
    TNode _thisNode = this.getThisNode();
    Iterable<TNode> _descendantsOfSingle = this.getDescendantsOfSingle();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _descendantsOfSingle);
  }
  
  public final Iterable<TNode> getDescendantsOfFirstChildAndSelf() {
    TNode _thisNode = this.getThisNode();
    Iterable<TNode> _descendantsOfFirstChild = this.getDescendantsOfFirstChild();
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _descendantsOfFirstChild);
  }
  
  public final Iterable<TNode> getAncestors(final int inclusiveDepth) {
    Iterable<TNode> _ancestors = this.getAncestors();
    return IterableExtensions.<TNode>take(_ancestors, inclusiveDepth);
  }
  
  public final Iterable<TNode> getAncestorsAndSelf(final int inclusiveDepth) {
    Iterable<TNode> _ancestorsAndSelf = this.getAncestorsAndSelf();
    return IterableExtensions.<TNode>take(_ancestorsAndSelf, (inclusiveDepth + 1));
  }
  
  public final Iterable<TNode> getDescendantsAndSelf(final int inclusiveDepth) {
    TNode _thisNode = this.getThisNode();
    Iterable<TNode> _descendants = this.getDescendants(inclusiveDepth);
    return Iterables.<TNode>concat(Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)), _descendants);
  }
  
  public final Iterable<TNode> getSiblings(final int inclusiveEachLength) {
    Iterable<TNode> _prevsFromSelf = this.getPrevsFromSelf();
    Iterable<TNode> _take = IterableExtensions.<TNode>take(_prevsFromSelf, inclusiveEachLength);
    List<TNode> _list = IterableExtensions.<TNode>toList(_take);
    List<TNode> _reverse = ListExtensions.<TNode>reverse(_list);
    Iterable<TNode> _nextsFromSelf = this.getNextsFromSelf();
    Iterable<TNode> _take_1 = IterableExtensions.<TNode>take(_nextsFromSelf, inclusiveEachLength);
    return Iterables.<TNode>concat(_reverse, _take_1);
  }
  
  public final Iterable<TNode> getSiblingsAndSelf(final int inclusiveEachLength) {
    Iterable<TNode> _prevsFromSelf = this.getPrevsFromSelf();
    Iterable<TNode> _take = IterableExtensions.<TNode>take(_prevsFromSelf, inclusiveEachLength);
    List<TNode> _list = IterableExtensions.<TNode>toList(_take);
    List<TNode> _reverse = ListExtensions.<TNode>reverse(_list);
    TNode _thisNode = this.getThisNode();
    Iterable<TNode> _plus = Iterables.<TNode>concat(_reverse, Collections.<TNode>unmodifiableList(Lists.<TNode>newArrayList(_thisNode)));
    Iterable<TNode> _nextsFromSelf = this.getNextsFromSelf();
    Iterable<TNode> _take_1 = IterableExtensions.<TNode>take(_nextsFromSelf, inclusiveEachLength);
    return Iterables.<TNode>concat(_plus, _take_1);
  }
}
