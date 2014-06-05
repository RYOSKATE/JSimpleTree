package net.exkazuu.tree;

import com.google.common.base.Objects;
import net.exkazuu.tree.Node;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class NamedNode<TNode extends NamedNode<TNode, TValue>, TValue extends Object> extends Node<TNode, TValue> {
  /**
   * Initializes a new instance of the Node class with a default value.
   */
  protected NamedNode() {
  }
  
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
  
  public final TNode child(final String name) {
    Iterable<TNode> _children = this.children();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>findFirst(_children, _function);
  }
  
  public final Iterable<TNode> ancestors(final String name) {
    Iterable<TNode> _ancestors = this.ancestors();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestors, _function);
  }
  
  public final Iterable<TNode> ancestorsAndSelf(final String name) {
    Iterable<TNode> _ancestorsAndSelf = this.ancestorsAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsAndSelf, _function);
  }
  
  public final Iterable<TNode> children(final String name) {
    Iterable<TNode> _children = this.children();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_children, _function);
  }
  
  public final Iterable<TNode> nextsFromSelf(final String name) {
    Iterable<TNode> _nextsFromSelf = this.nextsFromSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_nextsFromSelf, _function);
  }
  
  public final Iterable<TNode> nextsFromSelfAndSelf(final String name) {
    Iterable<TNode> _nextsFromSelfAndSelf = this.getNextsFromSelfAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_nextsFromSelfAndSelf, _function);
  }
  
  public final Iterable<TNode> nextsFromLast(final String name) {
    Iterable<TNode> _nextsFromLast = this.nextsFromLast();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_nextsFromLast, _function);
  }
  
  public final Iterable<TNode> nextsFromLastAndSelf(final String name) {
    Iterable<TNode> _nextsFromLastAndSelf = this.getNextsFromLastAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_nextsFromLastAndSelf, _function);
  }
  
  public final Iterable<TNode> prevsFromFirst(final String name) {
    Iterable<TNode> _prevsFromFirst = this.prevsFromFirst();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_prevsFromFirst, _function);
  }
  
  public final Iterable<TNode> prevsFromFirstAndSelf(final String name) {
    Iterable<TNode> _prevsFromFirstAndSelf = this.prevsFromFirstAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_prevsFromFirstAndSelf, _function);
  }
  
  public final Iterable<TNode> prevsFromSelf(final String name) {
    Iterable<TNode> _prevsFromSelf = this.prevsFromSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_prevsFromSelf, _function);
  }
  
  public final Iterable<TNode> prevsFromSelfAndSelf(final String name) {
    Iterable<TNode> _prevsFromSelfAndSelf = this.prevsFromSelfAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_prevsFromSelfAndSelf, _function);
  }
  
  public final Iterable<TNode> descendants(final String name) {
    Iterable<TNode> _descendants = this.descendants();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendants, _function);
  }
  
  public final Iterable<TNode> descendantsAndSelf(final String name) {
    Iterable<TNode> _descendantsAndSelf = this.descendantsAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendantsAndSelf, _function);
  }
  
  public final Iterable<TNode> siblings(final String name) {
    Iterable<TNode> _siblings = this.siblings();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_siblings, _function);
  }
  
  public final Iterable<TNode> siblingsAndSelf(final String name) {
    Iterable<TNode> _siblingsAndSelf = this.siblingsAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_siblingsAndSelf, _function);
  }
  
  public final Iterable<TNode> ancestorsAndSiblingsAfterSelf(final String name) {
    Iterable<TNode> _ancestorsAndSiblingsAfterSelf = this.ancestorsAndSiblingsAfterSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsAndSiblingsAfterSelf, _function);
  }
  
  public final Iterable<TNode> ancestorsAndSiblingsAfterSelfAndSelf(final String name) {
    Iterable<TNode> _ancestorsAndSiblingsAfterSelfAndSelf = this.ancestorsAndSiblingsAfterSelfAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsAndSiblingsAfterSelfAndSelf, _function);
  }
  
  public final Iterable<TNode> ancestorsAndSiblingsBeforeSelf(final String name) {
    Iterable<TNode> _ancestorsAndSiblingsBeforeSelf = this.ancestorsAndSiblingsBeforeSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsAndSiblingsBeforeSelf, _function);
  }
  
  public final Iterable<TNode> ancestorsAndSiblingsBeforeSelfAndSelf(final String name) {
    Iterable<TNode> _ancestorsAndSiblingsBeforeSelfAndSelf = this.ancestorsAndSiblingsBeforeSelfAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsAndSiblingsBeforeSelfAndSelf, _function);
  }
  
  public final Iterable<TNode> ancestorsWithSingleChild(final String name) {
    Iterable<TNode> _ancestorsWithSingleChild = this.ancestorsWithSingleChild();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsWithSingleChild, _function);
  }
  
  public final Iterable<TNode> ancestorsWithSingleChildAndSelf(final String name) {
    Iterable<TNode> _ancestorsWithSingleChildAndSelf = this.ancestorsWithSingleChildAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsWithSingleChildAndSelf, _function);
  }
  
  public final Iterable<TNode> descendantsOfSingle(final String name) {
    Iterable<TNode> _descendantsOfSingle = this.descendantsOfSingle();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendantsOfSingle, _function);
  }
  
  public final Iterable<TNode> descendantsOfSingleAndSelf(final String name) {
    Iterable<TNode> _descendantsOfSingleAndSelf = this.descendantsOfSingleAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendantsOfSingleAndSelf, _function);
  }
  
  public final Iterable<TNode> descendantsOfFirstChild(final String name) {
    Iterable<TNode> _descendantsOfFirstChild = this.descendantsOfFirstChild();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendantsOfFirstChild, _function);
  }
  
  public final Iterable<TNode> descendantsOfFirstChildAndSelf(final String name) {
    Iterable<TNode> _descendantsOfFirstChildAndSelf = this.descendantsOfFirstChildAndSelf();
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendantsOfFirstChildAndSelf, _function);
  }
  
  public final Iterable<TNode> ancestors(final String name, final int inclusiveDepth) {
    Iterable<TNode> _ancestors = this.ancestors(inclusiveDepth);
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestors, _function);
  }
  
  public final Iterable<TNode> ancestorsAndSelf(final String name, final int inclusiveDepth) {
    Iterable<TNode> _ancestorsAndSelf = this.ancestorsAndSelf(inclusiveDepth);
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_ancestorsAndSelf, _function);
  }
  
  public final Iterable<TNode> descendants(final String name, final int inclusiveDepth) {
    Iterable<TNode> _descendants = this.descendants(inclusiveDepth);
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendants, _function);
  }
  
  public final Iterable<TNode> descendantsAndSelf(final String name, final int inclusiveDepth) {
    Iterable<TNode> _descendantsAndSelf = this.descendantsAndSelf(inclusiveDepth);
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_descendantsAndSelf, _function);
  }
  
  public final Iterable<TNode> siblings(final String name, final int inclusiveEachLength) {
    Iterable<TNode> _siblings = this.siblings(inclusiveEachLength);
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_siblings, _function);
  }
  
  public final Iterable<TNode> siblingsAndSelf(final String name, final int inclusiveEachLength) {
    Iterable<TNode> _siblingsAndSelf = this.siblingsAndSelf(inclusiveEachLength);
    final Function1<TNode, Boolean> _function = new Function1<TNode, Boolean>() {
      public Boolean apply(final TNode it) {
        String _name = it.getName();
        return Boolean.valueOf(Objects.equal(_name, name));
      }
    };
    return IterableExtensions.<TNode>filter(_siblingsAndSelf, _function);
  }
}
