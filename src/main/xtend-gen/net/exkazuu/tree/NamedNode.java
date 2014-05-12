package net.exkazuu.tree;

import com.google.common.base.Objects;
import net.exkazuu.tree.Node;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class NamedNode<TNode extends NamedNode<TNode, TValue>, TValue extends Object> extends
    Node<TNode, TValue> {
  /**
   * Initializes a new instance of the Node class with a default value.
   */
  protected NamedNode() {}

  /**
   * Initializes a new instance of the Node class with the specified value.
   */
  protected NamedNode(final TValue value) {
    super(value);
  }

  private String _name;

  public String getName() {
    return this._name;
  }

  public void setName(final String name) {
    this._name = name;
  }

  public final TNode getChild(final String name) {
    Iterable<TNode> _children = this.getChildren();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>findFirst(_children, _function);
  }

  public final Iterable<TNode> getAncestors(final String name) {
    Iterable<TNode> _ancestors = this.getAncestors();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestors, _function);
  }

  public final Iterable<TNode> getAncestorsAndSelf(final String name) {
    Iterable<TNode> _ancestorsAndSelf = this.getAncestorsAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsAndSelf, _function);
  }

  public final Iterable<TNode> getChildren(final String name) {
    Iterable<TNode> _children = this.getChildren();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_children, _function);
  }

  public final Iterable<TNode> getNextsFromSelf(final String name) {
    Iterable<TNode> _nextsFromSelf = this.getNextsFromSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_nextsFromSelf, _function);
  }

  public final Iterable<TNode> getNextsFromSelfAndSelf(final String name) {
    Iterable<TNode> _nextsFromSelfAndSelf = this.getNextsFromSelfAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_nextsFromSelfAndSelf, _function);
  }

  public final Iterable<TNode> getNextsFromLast(final String name) {
    Iterable<TNode> _nextsFromLast = this.getNextsFromLast();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_nextsFromLast, _function);
  }

  public final Iterable<TNode> getNextsFromLastAndSelf(final String name) {
    Iterable<TNode> _nextsFromLastAndSelf = this.getNextsFromLastAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_nextsFromLastAndSelf, _function);
  }

  public final Iterable<TNode> getPrevsFromFirst(final String name) {
    Iterable<TNode> _prevsFromFirst = this.getPrevsFromFirst();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_prevsFromFirst, _function);
  }

  public final Iterable<TNode> getPrevsFromFirstAndSelf(final String name) {
    Iterable<TNode> _prevsFromFirstAndSelf = this.getPrevsFromFirstAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_prevsFromFirstAndSelf, _function);
  }

  public final Iterable<TNode> getPrevsFromSelf(final String name) {
    Iterable<TNode> _prevsFromSelf = this.getPrevsFromSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_prevsFromSelf, _function);
  }

  public final Iterable<TNode> getPrevsFromSelfAndSelf(final String name) {
    Iterable<TNode> _prevsFromSelfAndSelf = this.getPrevsFromSelfAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_prevsFromSelfAndSelf, _function);
  }

  public final Iterable<TNode> getDescendants(final String name) {
    Iterable<TNode> _descendants = this.getDescendants();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendants, _function);
  }

  public final Iterable<TNode> getDescendantsAndSelf(final String name) {
    Iterable<TNode> _descendantsAndSelf = this.getDescendantsAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendantsAndSelf, _function);
  }

  public final Iterable<TNode> getSiblings(final String name) {
    Iterable<TNode> _siblings = this.getSiblings();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_siblings, _function);
  }

  public final Iterable<TNode> getSiblingsAndSelf(final String name) {
    Iterable<TNode> _siblingsAndSelf = this.getSiblingsAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_siblingsAndSelf, _function);
  }

  public final Iterable<TNode> getAncestorsAndSiblingsAfterSelf(final String name) {
    Iterable<TNode> _ancestorsAndSiblingsAfterSelf = this.getAncestorsAndSiblingsAfterSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsAndSiblingsAfterSelf, _function);
  }

  public final Iterable<TNode> getAncestorsAndSiblingsAfterSelfAndSelf(final String name) {
    Iterable<TNode> _ancestorsAndSiblingsAfterSelfAndSelf =
        this.getAncestorsAndSiblingsAfterSelfAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsAndSiblingsAfterSelfAndSelf, _function);
  }

  public final Iterable<TNode> getAncestorsAndSiblingsBeforeSelf(final String name) {
    Iterable<TNode> _ancestorsAndSiblingsBeforeSelf = this.getAncestorsAndSiblingsBeforeSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsAndSiblingsBeforeSelf, _function);
  }

  public final Iterable<TNode> getAncestorsAndSiblingsBeforeSelfAndSelf(final String name) {
    Iterable<TNode> _ancestorsAndSiblingsBeforeSelfAndSelf =
        this.getAncestorsAndSiblingsBeforeSelfAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsAndSiblingsBeforeSelfAndSelf, _function);
  }

  public final Iterable<TNode> getAncestorsWithSingleChild(final String name) {
    Iterable<TNode> _ancestorsWithSingleChild = this.getAncestorsWithSingleChild();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsWithSingleChild, _function);
  }

  public final Iterable<TNode> getAncestorsWithSingleChildAndSelf(final String name) {
    Iterable<TNode> _ancestorsWithSingleChildAndSelf = this.getAncestorsWithSingleChildAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsWithSingleChildAndSelf, _function);
  }

  public final Iterable<TNode> getDescendantsOfSingle(final String name) {
    Iterable<TNode> _descendantsOfSingle = this.getDescendantsOfSingle();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendantsOfSingle, _function);
  }

  public final Iterable<TNode> getDescendantsOfSingleAndSelf(final String name) {
    Iterable<TNode> _descendantsOfSingleAndSelf = this.getDescendantsOfSingleAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendantsOfSingleAndSelf, _function);
  }

  public final Iterable<TNode> getDescendantsOfFirstChild(final String name) {
    Iterable<TNode> _descendantsOfFirstChild = this.getDescendantsOfFirstChild();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendantsOfFirstChild, _function);
  }

  public final Iterable<TNode> getDescendantsOfFirstChildAndSelf(final String name) {
    Iterable<TNode> _descendantsOfFirstChildAndSelf = this.getDescendantsOfFirstChildAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendantsOfFirstChildAndSelf, _function);
  }

  public final Iterable<TNode> getAncestors(final String name, final int inclusiveDepth) {
    Iterable<TNode> _ancestors = this.getAncestors(inclusiveDepth);
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestors, _function);
  }

  public final Iterable<TNode> getAncestorsAndSelf(final String name, final int inclusiveDepth) {
    Iterable<TNode> _ancestorsAndSelf = this.getAncestorsAndSelf(inclusiveDepth);
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsAndSelf, _function);
  }

  public final Iterable<TNode> getDescendants(final String name, final int inclusiveDepth) {
    Iterable<TNode> _descendants = this.getDescendants(inclusiveDepth);
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendants, _function);
  }

  public final Iterable<TNode> getDescendantsAndSelf(final String name, final int inclusiveDepth) {
    Iterable<TNode> _descendantsAndSelf = this.getDescendantsAndSelf(inclusiveDepth);
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendantsAndSelf, _function);
  }

  public final Iterable<TNode> getSiblings(final String name, final int inclusiveEachLength) {
    Iterable<TNode> _siblings = this.getSiblings(inclusiveEachLength);
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_siblings, _function);
  }

  public final Iterable<TNode> getSiblingsAndSelf(final String name, final int inclusiveEachLength) {
    Iterable<TNode> _siblingsAndSelf = this.getSiblingsAndSelf(inclusiveEachLength);
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_siblingsAndSelf, _function);
  }
}
