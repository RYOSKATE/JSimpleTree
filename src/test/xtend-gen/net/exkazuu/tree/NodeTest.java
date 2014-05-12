package net.exkazuu.tree;

import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import net.exkazuu.tree.StringNode;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class NodeTest {
  public String NormalizeNewLine(final String text) {
    String _lineSeparator = System.lineSeparator();
    return text.replace("\n", _lineSeparator);
  }
  
  @Test
  public void OperateRoot() {
    final StringNode root = new StringNode("a");
    Iterable<StringNode> _prevsFromFirst = root.getPrevsFromFirst();
    List<StringNode> _list = IterableExtensions.<StringNode>toList(_prevsFromFirst);
    List<StringNode> _list_1 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList()));
    Matcher<List<StringNode>> _is = Matchers.<List<StringNode>>is(_list_1);
    Assert.<List<StringNode>>assertThat(_list, _is);
    Iterable<StringNode> _nextsFromSelf = root.getNextsFromSelf();
    List<StringNode> _list_2 = IterableExtensions.<StringNode>toList(_nextsFromSelf);
    List<StringNode> _list_3 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList()));
    Matcher<List<StringNode>> _is_1 = Matchers.<List<StringNode>>is(_list_3);
    Assert.<List<StringNode>>assertThat(_list_2, _is_1);
    Iterable<StringNode> _prevsFromFirstAndSelf = root.getPrevsFromFirstAndSelf();
    List<StringNode> _list_4 = IterableExtensions.<StringNode>toList(_prevsFromFirstAndSelf);
    List<StringNode> _list_5 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(root)));
    Matcher<List<StringNode>> _is_2 = Matchers.<List<StringNode>>is(_list_5);
    Assert.<List<StringNode>>assertThat(_list_4, _is_2);
    Iterable<StringNode> _nextsFromSelfAndSelf = root.getNextsFromSelfAndSelf();
    List<StringNode> _list_6 = IterableExtensions.<StringNode>toList(_nextsFromSelfAndSelf);
    List<StringNode> _list_7 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(root)));
    Matcher<List<StringNode>> _is_3 = Matchers.<List<StringNode>>is(_list_7);
    Assert.<List<StringNode>>assertThat(_list_6, _is_3);
    Iterable<StringNode> _prevsFromSelf = root.getPrevsFromSelf();
    List<StringNode> _list_8 = IterableExtensions.<StringNode>toList(_prevsFromSelf);
    List<StringNode> _list_9 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList()));
    Matcher<List<StringNode>> _is_4 = Matchers.<List<StringNode>>is(_list_9);
    Assert.<List<StringNode>>assertThat(_list_8, _is_4);
    Iterable<StringNode> _nextsFromLast = root.getNextsFromLast();
    List<StringNode> _list_10 = IterableExtensions.<StringNode>toList(_nextsFromLast);
    List<StringNode> _list_11 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList()));
    Matcher<List<StringNode>> _is_5 = Matchers.<List<StringNode>>is(_list_11);
    Assert.<List<StringNode>>assertThat(_list_10, _is_5);
    Iterable<StringNode> _prevsFromSelfAndSelf = root.getPrevsFromSelfAndSelf();
    List<StringNode> _list_12 = IterableExtensions.<StringNode>toList(_prevsFromSelfAndSelf);
    List<StringNode> _list_13 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(root)));
    Matcher<List<StringNode>> _is_6 = Matchers.<List<StringNode>>is(_list_13);
    Assert.<List<StringNode>>assertThat(_list_12, _is_6);
    Iterable<StringNode> _nextsFromLastAndSelf = root.getNextsFromLastAndSelf();
    List<StringNode> _list_14 = IterableExtensions.<StringNode>toList(_nextsFromLastAndSelf);
    List<StringNode> _list_15 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(root)));
    Matcher<List<StringNode>> _is_7 = Matchers.<List<StringNode>>is(_list_15);
    Assert.<List<StringNode>>assertThat(_list_14, _is_7);
  }
  
  @Test
  public void Create1Node() {
    final StringNode node = new StringNode("a");
    String _string = node.toString();
    String _NormalizeNewLine = this.NormalizeNewLine("a\n");
    Matcher<String> _is = Matchers.<String>is(_NormalizeNewLine);
    Assert.<String>assertThat(_string, _is);
    Iterable<StringNode> _descendants = node.getDescendants();
    final Function1<StringNode,String> _function = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map = IterableExtensions.<StringNode, String>map(_descendants, _function);
    String _join = IterableExtensions.join(_map);
    Matcher<String> _is_1 = Matchers.<String>is("");
    Assert.<String>assertThat(_join, _is_1);
  }
  
  @Test
  public void Create2Nodes() {
    StringNode node = new StringNode("a");
    StringNode _stringNode = new StringNode("b");
    node.AddFirst(_stringNode);
    String _string = node.toString();
    String _NormalizeNewLine = this.NormalizeNewLine("a\n  b\n");
    Matcher<String> _is = Matchers.<String>is(_NormalizeNewLine);
    Assert.<String>assertThat(_string, _is);
    Iterable<StringNode> _descendants = node.getDescendants();
    final Function1<StringNode,String> _function = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map = IterableExtensions.<StringNode, String>map(_descendants, _function);
    String _join = IterableExtensions.join(_map);
    Matcher<String> _is_1 = Matchers.<String>is("b");
    Assert.<String>assertThat(_join, _is_1);
  }
  
  @Test
  public void Create3Nodes() {
    StringNode node = new StringNode("a");
    StringNode _stringNode = new StringNode("b");
    node.AddLast(_stringNode);
    StringNode _stringNode_1 = new StringNode("c");
    node.AddFirst(_stringNode_1);
    String _string = node.toString();
    String _NormalizeNewLine = this.NormalizeNewLine("a\n  c\n  b\n");
    Matcher<String> _is = Matchers.<String>is(_NormalizeNewLine);
    Assert.<String>assertThat(_string, _is);
    Iterable<StringNode> _descendants = node.getDescendants();
    final Function1<StringNode,String> _function = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map = IterableExtensions.<StringNode, String>map(_descendants, _function);
    String _join = IterableExtensions.join(_map);
    Matcher<String> _is_1 = Matchers.<String>is("cb");
    Assert.<String>assertThat(_join, _is_1);
  }
  
  @Test
  public void Create4Nodes() {
    StringNode node = new StringNode("a");
    StringNode _stringNode = new StringNode("b");
    node.AddLast(_stringNode);
    StringNode _stringNode_1 = new StringNode("c");
    node.AddFirst(_stringNode_1);
    StringNode _stringNode_2 = new StringNode("d");
    node.AddLast(_stringNode_2);
    String _string = node.toString();
    String _NormalizeNewLine = this.NormalizeNewLine("a\n  c\n  b\n  d\n");
    Matcher<String> _is = Matchers.<String>is(_NormalizeNewLine);
    Assert.<String>assertThat(_string, _is);
    Iterable<StringNode> _descendants = node.getDescendants();
    final Function1<StringNode,String> _function = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map = IterableExtensions.<StringNode, String>map(_descendants, _function);
    String _join = IterableExtensions.join(_map);
    Matcher<String> _is_1 = Matchers.<String>is("cbd");
    Assert.<String>assertThat(_join, _is_1);
  }
  
  @Test
  public void CreateTreeAndTraverse() {
    StringNode a = new StringNode("a");
    StringNode _stringNode = new StringNode("b");
    StringNode b = a.AddFirst(_stringNode);
    StringNode _stringNode_1 = new StringNode("c");
    StringNode c = a.AddLast(_stringNode_1);
    StringNode _stringNode_2 = new StringNode("d");
    StringNode d = a.AddFirst(_stringNode_2);
    StringNode _stringNode_3 = new StringNode("e");
    StringNode e = a.AddFirst(_stringNode_3);
    StringNode _stringNode_4 = new StringNode("f");
    StringNode f = b.AddFirst(_stringNode_4);
    StringNode _stringNode_5 = new StringNode("g");
    StringNode g = b.AddFirst(_stringNode_5);
    StringNode h = g.AddLast("h");
    StringNode i = f.AddLast("i");
    StringNode j = h.AddNext("j");
    StringNode k = h.AddPrevious("k");
    StringNode l = i.AddPrevious("l");
    StringNode m = i.AddNext("m");
    String _string = a.toString();
    String _NormalizeNewLine = this.NormalizeNewLine("a\n  e\n  d\n  b\n    g\n      k\n      h\n      j\n    f\n      l\n      i\n      m\n  c\n");
    Matcher<String> _is = Matchers.<String>is(_NormalizeNewLine);
    Assert.<String>assertThat(_string, _is);
    Iterable<StringNode> _descendants = a.getDescendants();
    final Function1<StringNode,String> _function = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map = IterableExtensions.<StringNode, String>map(_descendants, _function);
    String _join = IterableExtensions.join(_map);
    Matcher<String> _is_1 = Matchers.<String>is("edbgkhjflimc");
    Assert.<String>assertThat(_join, _is_1);
    Iterable<StringNode> _descendants_1 = e.getDescendants();
    final Function1<StringNode,String> _function_1 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_1 = IterableExtensions.<StringNode, String>map(_descendants_1, _function_1);
    String _join_1 = IterableExtensions.join(_map_1);
    Matcher<String> _is_2 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_1, _is_2);
    Iterable<StringNode> _descendants_2 = d.getDescendants();
    final Function1<StringNode,String> _function_2 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_2 = IterableExtensions.<StringNode, String>map(_descendants_2, _function_2);
    String _join_2 = IterableExtensions.join(_map_2);
    Matcher<String> _is_3 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_2, _is_3);
    Iterable<StringNode> _descendants_3 = b.getDescendants();
    final Function1<StringNode,String> _function_3 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_3 = IterableExtensions.<StringNode, String>map(_descendants_3, _function_3);
    String _join_3 = IterableExtensions.join(_map_3);
    Matcher<String> _is_4 = Matchers.<String>is("gkhjflim");
    Assert.<String>assertThat(_join_3, _is_4);
    Iterable<StringNode> _descendants_4 = c.getDescendants();
    final Function1<StringNode,String> _function_4 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_4 = IterableExtensions.<StringNode, String>map(_descendants_4, _function_4);
    String _join_4 = IterableExtensions.join(_map_4);
    Matcher<String> _is_5 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_4, _is_5);
    Iterable<StringNode> _descendantsAndSelf = a.getDescendantsAndSelf();
    final Function1<StringNode,String> _function_5 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_5 = IterableExtensions.<StringNode, String>map(_descendantsAndSelf, _function_5);
    String _join_5 = IterableExtensions.join(_map_5);
    Matcher<String> _is_6 = Matchers.<String>is("aedbgkhjflimc");
    Assert.<String>assertThat(_join_5, _is_6);
    Iterable<StringNode> _descendantsAndSelf_1 = e.getDescendantsAndSelf();
    final Function1<StringNode,String> _function_6 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_6 = IterableExtensions.<StringNode, String>map(_descendantsAndSelf_1, _function_6);
    String _join_6 = IterableExtensions.join(_map_6);
    Matcher<String> _is_7 = Matchers.<String>is("e");
    Assert.<String>assertThat(_join_6, _is_7);
    Iterable<StringNode> _descendantsAndSelf_2 = d.getDescendantsAndSelf();
    final Function1<StringNode,String> _function_7 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_7 = IterableExtensions.<StringNode, String>map(_descendantsAndSelf_2, _function_7);
    String _join_7 = IterableExtensions.join(_map_7);
    Matcher<String> _is_8 = Matchers.<String>is("d");
    Assert.<String>assertThat(_join_7, _is_8);
    Iterable<StringNode> _descendantsAndSelf_3 = b.getDescendantsAndSelf();
    final Function1<StringNode,String> _function_8 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_8 = IterableExtensions.<StringNode, String>map(_descendantsAndSelf_3, _function_8);
    String _join_8 = IterableExtensions.join(_map_8);
    Matcher<String> _is_9 = Matchers.<String>is("bgkhjflim");
    Assert.<String>assertThat(_join_8, _is_9);
    Iterable<StringNode> _descendantsAndSelf_4 = c.getDescendantsAndSelf();
    final Function1<StringNode,String> _function_9 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_9 = IterableExtensions.<StringNode, String>map(_descendantsAndSelf_4, _function_9);
    String _join_9 = IterableExtensions.join(_map_9);
    Matcher<String> _is_10 = Matchers.<String>is("c");
    Assert.<String>assertThat(_join_9, _is_10);
    Iterable<StringNode> _descendants_5 = a.getDescendants(2);
    final Function1<StringNode,String> _function_10 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_10 = IterableExtensions.<StringNode, String>map(_descendants_5, _function_10);
    String _join_10 = IterableExtensions.join(_map_10);
    Matcher<String> _is_11 = Matchers.<String>is("edbgfc");
    Assert.<String>assertThat(_join_10, _is_11);
    Iterable<StringNode> _descendants_6 = e.getDescendants(2);
    final Function1<StringNode,String> _function_11 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_11 = IterableExtensions.<StringNode, String>map(_descendants_6, _function_11);
    String _join_11 = IterableExtensions.join(_map_11);
    Matcher<String> _is_12 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_11, _is_12);
    Iterable<StringNode> _descendants_7 = d.getDescendants(2);
    final Function1<StringNode,String> _function_12 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_12 = IterableExtensions.<StringNode, String>map(_descendants_7, _function_12);
    String _join_12 = IterableExtensions.join(_map_12);
    Matcher<String> _is_13 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_12, _is_13);
    Iterable<StringNode> _descendants_8 = b.getDescendants(2);
    final Function1<StringNode,String> _function_13 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_13 = IterableExtensions.<StringNode, String>map(_descendants_8, _function_13);
    String _join_13 = IterableExtensions.join(_map_13);
    Matcher<String> _is_14 = Matchers.<String>is("gkhjflim");
    Assert.<String>assertThat(_join_13, _is_14);
    Iterable<StringNode> _descendants_9 = c.getDescendants(2);
    final Function1<StringNode,String> _function_14 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_14 = IterableExtensions.<StringNode, String>map(_descendants_9, _function_14);
    String _join_14 = IterableExtensions.join(_map_14);
    Matcher<String> _is_15 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_14, _is_15);
    Iterable<StringNode> _descendants_10 = b.getDescendants(0);
    final Function1<StringNode,String> _function_15 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_15 = IterableExtensions.<StringNode, String>map(_descendants_10, _function_15);
    String _join_15 = IterableExtensions.join(_map_15);
    Matcher<String> _is_16 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_15, _is_16);
    Iterable<StringNode> _descendantsAndSelf_5 = a.getDescendantsAndSelf(2);
    final Function1<StringNode,String> _function_16 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_16 = IterableExtensions.<StringNode, String>map(_descendantsAndSelf_5, _function_16);
    String _join_16 = IterableExtensions.join(_map_16);
    Matcher<String> _is_17 = Matchers.<String>is("aedbgfc");
    Assert.<String>assertThat(_join_16, _is_17);
    Iterable<StringNode> _descendantsAndSelf_6 = e.getDescendantsAndSelf(2);
    final Function1<StringNode,String> _function_17 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_17 = IterableExtensions.<StringNode, String>map(_descendantsAndSelf_6, _function_17);
    String _join_17 = IterableExtensions.join(_map_17);
    Matcher<String> _is_18 = Matchers.<String>is("e");
    Assert.<String>assertThat(_join_17, _is_18);
    Iterable<StringNode> _descendantsAndSelf_7 = d.getDescendantsAndSelf(2);
    final Function1<StringNode,String> _function_18 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_18 = IterableExtensions.<StringNode, String>map(_descendantsAndSelf_7, _function_18);
    String _join_18 = IterableExtensions.join(_map_18);
    Matcher<String> _is_19 = Matchers.<String>is("d");
    Assert.<String>assertThat(_join_18, _is_19);
    Iterable<StringNode> _descendantsAndSelf_8 = b.getDescendantsAndSelf(2);
    final Function1<StringNode,String> _function_19 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_19 = IterableExtensions.<StringNode, String>map(_descendantsAndSelf_8, _function_19);
    String _join_19 = IterableExtensions.join(_map_19);
    Matcher<String> _is_20 = Matchers.<String>is("bgkhjflim");
    Assert.<String>assertThat(_join_19, _is_20);
    Iterable<StringNode> _descendantsAndSelf_9 = c.getDescendantsAndSelf(2);
    final Function1<StringNode,String> _function_20 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_20 = IterableExtensions.<StringNode, String>map(_descendantsAndSelf_9, _function_20);
    String _join_20 = IterableExtensions.join(_map_20);
    Matcher<String> _is_21 = Matchers.<String>is("c");
    Assert.<String>assertThat(_join_20, _is_21);
    Iterable<StringNode> _descendantsAndSelf_10 = b.getDescendantsAndSelf(0);
    final Function1<StringNode,String> _function_21 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_21 = IterableExtensions.<StringNode, String>map(_descendantsAndSelf_10, _function_21);
    String _join_21 = IterableExtensions.join(_map_21);
    Matcher<String> _is_22 = Matchers.<String>is("b");
    Assert.<String>assertThat(_join_21, _is_22);
    Iterable<StringNode> _siblings = a.getSiblings();
    final Function1<StringNode,String> _function_22 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_22 = IterableExtensions.<StringNode, String>map(_siblings, _function_22);
    String _join_22 = IterableExtensions.join(_map_22);
    Matcher<String> _is_23 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_22, _is_23);
    Iterable<StringNode> _siblings_1 = k.getSiblings();
    final Function1<StringNode,String> _function_23 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_23 = IterableExtensions.<StringNode, String>map(_siblings_1, _function_23);
    String _join_23 = IterableExtensions.join(_map_23);
    Matcher<String> _is_24 = Matchers.<String>is("hj");
    Assert.<String>assertThat(_join_23, _is_24);
    Iterable<StringNode> _siblings_2 = h.getSiblings();
    final Function1<StringNode,String> _function_24 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_24 = IterableExtensions.<StringNode, String>map(_siblings_2, _function_24);
    String _join_24 = IterableExtensions.join(_map_24);
    Matcher<String> _is_25 = Matchers.<String>is("kj");
    Assert.<String>assertThat(_join_24, _is_25);
    Iterable<StringNode> _siblings_3 = j.getSiblings();
    final Function1<StringNode,String> _function_25 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_25 = IterableExtensions.<StringNode, String>map(_siblings_3, _function_25);
    String _join_25 = IterableExtensions.join(_map_25);
    Matcher<String> _is_26 = Matchers.<String>is("kh");
    Assert.<String>assertThat(_join_25, _is_26);
    Iterable<StringNode> _siblings_4 = i.getSiblings();
    final Function1<StringNode,String> _function_26 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_26 = IterableExtensions.<StringNode, String>map(_siblings_4, _function_26);
    String _join_26 = IterableExtensions.join(_map_26);
    Matcher<String> _is_27 = Matchers.<String>is("lm");
    Assert.<String>assertThat(_join_26, _is_27);
    Iterable<StringNode> _siblingsAndSelf = a.getSiblingsAndSelf();
    final Function1<StringNode,String> _function_27 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_27 = IterableExtensions.<StringNode, String>map(_siblingsAndSelf, _function_27);
    String _join_27 = IterableExtensions.join(_map_27);
    Matcher<String> _is_28 = Matchers.<String>is("a");
    Assert.<String>assertThat(_join_27, _is_28);
    Iterable<StringNode> _siblingsAndSelf_1 = k.getSiblingsAndSelf();
    final Function1<StringNode,String> _function_28 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_28 = IterableExtensions.<StringNode, String>map(_siblingsAndSelf_1, _function_28);
    String _join_28 = IterableExtensions.join(_map_28);
    Matcher<String> _is_29 = Matchers.<String>is("khj");
    Assert.<String>assertThat(_join_28, _is_29);
    Iterable<StringNode> _siblingsAndSelf_2 = h.getSiblingsAndSelf();
    final Function1<StringNode,String> _function_29 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_29 = IterableExtensions.<StringNode, String>map(_siblingsAndSelf_2, _function_29);
    String _join_29 = IterableExtensions.join(_map_29);
    Matcher<String> _is_30 = Matchers.<String>is("khj");
    Assert.<String>assertThat(_join_29, _is_30);
    Iterable<StringNode> _siblingsAndSelf_3 = j.getSiblingsAndSelf();
    final Function1<StringNode,String> _function_30 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_30 = IterableExtensions.<StringNode, String>map(_siblingsAndSelf_3, _function_30);
    String _join_30 = IterableExtensions.join(_map_30);
    Matcher<String> _is_31 = Matchers.<String>is("khj");
    Assert.<String>assertThat(_join_30, _is_31);
    Iterable<StringNode> _siblingsAndSelf_4 = i.getSiblingsAndSelf();
    final Function1<StringNode,String> _function_31 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_31 = IterableExtensions.<StringNode, String>map(_siblingsAndSelf_4, _function_31);
    String _join_31 = IterableExtensions.join(_map_31);
    Matcher<String> _is_32 = Matchers.<String>is("lim");
    Assert.<String>assertThat(_join_31, _is_32);
    Iterable<StringNode> _siblings_5 = a.getSiblings(1);
    final Function1<StringNode,String> _function_32 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_32 = IterableExtensions.<StringNode, String>map(_siblings_5, _function_32);
    String _join_32 = IterableExtensions.join(_map_32);
    Matcher<String> _is_33 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_32, _is_33);
    Iterable<StringNode> _siblings_6 = k.getSiblings(1);
    final Function1<StringNode,String> _function_33 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_33 = IterableExtensions.<StringNode, String>map(_siblings_6, _function_33);
    String _join_33 = IterableExtensions.join(_map_33);
    Matcher<String> _is_34 = Matchers.<String>is("h");
    Assert.<String>assertThat(_join_33, _is_34);
    Iterable<StringNode> _siblings_7 = h.getSiblings(1);
    final Function1<StringNode,String> _function_34 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_34 = IterableExtensions.<StringNode, String>map(_siblings_7, _function_34);
    String _join_34 = IterableExtensions.join(_map_34);
    Matcher<String> _is_35 = Matchers.<String>is("kj");
    Assert.<String>assertThat(_join_34, _is_35);
    Iterable<StringNode> _siblings_8 = j.getSiblings(1);
    final Function1<StringNode,String> _function_35 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_35 = IterableExtensions.<StringNode, String>map(_siblings_8, _function_35);
    String _join_35 = IterableExtensions.join(_map_35);
    Matcher<String> _is_36 = Matchers.<String>is("h");
    Assert.<String>assertThat(_join_35, _is_36);
    Iterable<StringNode> _siblings_9 = i.getSiblings(1);
    final Function1<StringNode,String> _function_36 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_36 = IterableExtensions.<StringNode, String>map(_siblings_9, _function_36);
    String _join_36 = IterableExtensions.join(_map_36);
    Matcher<String> _is_37 = Matchers.<String>is("lm");
    Assert.<String>assertThat(_join_36, _is_37);
    Iterable<StringNode> _siblings_10 = i.getSiblings(0);
    final Function1<StringNode,String> _function_37 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_37 = IterableExtensions.<StringNode, String>map(_siblings_10, _function_37);
    String _join_37 = IterableExtensions.join(_map_37);
    Matcher<String> _is_38 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_37, _is_38);
    Iterable<StringNode> _siblingsAndSelf_5 = a.getSiblingsAndSelf(1);
    final Function1<StringNode,String> _function_38 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_38 = IterableExtensions.<StringNode, String>map(_siblingsAndSelf_5, _function_38);
    String _join_38 = IterableExtensions.join(_map_38);
    Matcher<String> _is_39 = Matchers.<String>is("a");
    Assert.<String>assertThat(_join_38, _is_39);
    Iterable<StringNode> _siblingsAndSelf_6 = k.getSiblingsAndSelf(1);
    final Function1<StringNode,String> _function_39 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_39 = IterableExtensions.<StringNode, String>map(_siblingsAndSelf_6, _function_39);
    String _join_39 = IterableExtensions.join(_map_39);
    Matcher<String> _is_40 = Matchers.<String>is("kh");
    Assert.<String>assertThat(_join_39, _is_40);
    Iterable<StringNode> _siblingsAndSelf_7 = h.getSiblingsAndSelf(1);
    final Function1<StringNode,String> _function_40 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_40 = IterableExtensions.<StringNode, String>map(_siblingsAndSelf_7, _function_40);
    String _join_40 = IterableExtensions.join(_map_40);
    Matcher<String> _is_41 = Matchers.<String>is("khj");
    Assert.<String>assertThat(_join_40, _is_41);
    Iterable<StringNode> _siblingsAndSelf_8 = j.getSiblingsAndSelf(1);
    final Function1<StringNode,String> _function_41 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_41 = IterableExtensions.<StringNode, String>map(_siblingsAndSelf_8, _function_41);
    String _join_41 = IterableExtensions.join(_map_41);
    Matcher<String> _is_42 = Matchers.<String>is("hj");
    Assert.<String>assertThat(_join_41, _is_42);
    Iterable<StringNode> _siblingsAndSelf_9 = i.getSiblingsAndSelf(1);
    final Function1<StringNode,String> _function_42 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_42 = IterableExtensions.<StringNode, String>map(_siblingsAndSelf_9, _function_42);
    String _join_42 = IterableExtensions.join(_map_42);
    Matcher<String> _is_43 = Matchers.<String>is("lim");
    Assert.<String>assertThat(_join_42, _is_43);
    Iterable<StringNode> _siblingsAndSelf_10 = i.getSiblingsAndSelf(0);
    final Function1<StringNode,String> _function_43 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_43 = IterableExtensions.<StringNode, String>map(_siblingsAndSelf_10, _function_43);
    String _join_43 = IterableExtensions.join(_map_43);
    Matcher<String> _is_44 = Matchers.<String>is("i");
    Assert.<String>assertThat(_join_43, _is_44);
    Iterable<StringNode> _ancestors = i.getAncestors();
    final Function1<StringNode,String> _function_44 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_44 = IterableExtensions.<StringNode, String>map(_ancestors, _function_44);
    String _join_44 = IterableExtensions.join(_map_44);
    Matcher<String> _is_45 = Matchers.<String>is("fba");
    Assert.<String>assertThat(_join_44, _is_45);
    Iterable<StringNode> _ancestors_1 = i.getAncestors(3);
    final Function1<StringNode,String> _function_45 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_45 = IterableExtensions.<StringNode, String>map(_ancestors_1, _function_45);
    String _join_45 = IterableExtensions.join(_map_45);
    Matcher<String> _is_46 = Matchers.<String>is("fba");
    Assert.<String>assertThat(_join_45, _is_46);
    Iterable<StringNode> _ancestors_2 = i.getAncestors(2);
    final Function1<StringNode,String> _function_46 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_46 = IterableExtensions.<StringNode, String>map(_ancestors_2, _function_46);
    String _join_46 = IterableExtensions.join(_map_46);
    Matcher<String> _is_47 = Matchers.<String>is("fb");
    Assert.<String>assertThat(_join_46, _is_47);
    Iterable<StringNode> _ancestors_3 = i.getAncestors(1);
    final Function1<StringNode,String> _function_47 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_47 = IterableExtensions.<StringNode, String>map(_ancestors_3, _function_47);
    String _join_47 = IterableExtensions.join(_map_47);
    Matcher<String> _is_48 = Matchers.<String>is("f");
    Assert.<String>assertThat(_join_47, _is_48);
    Iterable<StringNode> _ancestors_4 = i.getAncestors(0);
    final Function1<StringNode,String> _function_48 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_48 = IterableExtensions.<StringNode, String>map(_ancestors_4, _function_48);
    String _join_48 = IterableExtensions.join(_map_48);
    Matcher<String> _is_49 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_48, _is_49);
    Iterable<StringNode> _ancestorsAndSelf = i.getAncestorsAndSelf();
    final Function1<StringNode,String> _function_49 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_49 = IterableExtensions.<StringNode, String>map(_ancestorsAndSelf, _function_49);
    String _join_49 = IterableExtensions.join(_map_49);
    Matcher<String> _is_50 = Matchers.<String>is("ifba");
    Assert.<String>assertThat(_join_49, _is_50);
    Iterable<StringNode> _ancestorsAndSelf_1 = i.getAncestorsAndSelf(3);
    final Function1<StringNode,String> _function_50 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_50 = IterableExtensions.<StringNode, String>map(_ancestorsAndSelf_1, _function_50);
    String _join_50 = IterableExtensions.join(_map_50);
    Matcher<String> _is_51 = Matchers.<String>is("ifba");
    Assert.<String>assertThat(_join_50, _is_51);
    Iterable<StringNode> _ancestorsAndSelf_2 = i.getAncestorsAndSelf(2);
    final Function1<StringNode,String> _function_51 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_51 = IterableExtensions.<StringNode, String>map(_ancestorsAndSelf_2, _function_51);
    String _join_51 = IterableExtensions.join(_map_51);
    Matcher<String> _is_52 = Matchers.<String>is("ifb");
    Assert.<String>assertThat(_join_51, _is_52);
    Iterable<StringNode> _ancestorsAndSelf_3 = i.getAncestorsAndSelf(1);
    final Function1<StringNode,String> _function_52 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_52 = IterableExtensions.<StringNode, String>map(_ancestorsAndSelf_3, _function_52);
    String _join_52 = IterableExtensions.join(_map_52);
    Matcher<String> _is_53 = Matchers.<String>is("if");
    Assert.<String>assertThat(_join_52, _is_53);
    Iterable<StringNode> _ancestorsAndSelf_4 = i.getAncestorsAndSelf(0);
    final Function1<StringNode,String> _function_53 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_53 = IterableExtensions.<StringNode, String>map(_ancestorsAndSelf_4, _function_53);
    String _join_53 = IterableExtensions.join(_map_53);
    Matcher<String> _is_54 = Matchers.<String>is("i");
    Assert.<String>assertThat(_join_53, _is_54);
    Iterable<StringNode> _ancestorsAndSiblingsAfterSelf = f.getAncestorsAndSiblingsAfterSelf();
    final Function1<StringNode,String> _function_54 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_54 = IterableExtensions.<StringNode, String>map(_ancestorsAndSiblingsAfterSelf, _function_54);
    String _join_54 = IterableExtensions.join(_map_54);
    Matcher<String> _is_55 = Matchers.<String>is("c");
    Assert.<String>assertThat(_join_54, _is_55);
    Iterable<StringNode> _ancestorsAndSiblingsAfterSelfAndSelf = f.getAncestorsAndSiblingsAfterSelfAndSelf();
    final Function1<StringNode,String> _function_55 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_55 = IterableExtensions.<StringNode, String>map(_ancestorsAndSiblingsAfterSelfAndSelf, _function_55);
    String _join_55 = IterableExtensions.join(_map_55);
    Matcher<String> _is_56 = Matchers.<String>is("fc");
    Assert.<String>assertThat(_join_55, _is_56);
    Iterable<StringNode> _ancestorsAndSiblingsBeforeSelf = f.getAncestorsAndSiblingsBeforeSelf();
    final Function1<StringNode,String> _function_56 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_56 = IterableExtensions.<StringNode, String>map(_ancestorsAndSiblingsBeforeSelf, _function_56);
    String _join_56 = IterableExtensions.join(_map_56);
    Matcher<String> _is_57 = Matchers.<String>is("gbdea");
    Assert.<String>assertThat(_join_56, _is_57);
    Iterable<StringNode> _ancestorsAndSiblingsBeforeSelfAndSelf = f.getAncestorsAndSiblingsBeforeSelfAndSelf();
    final Function1<StringNode,String> _function_57 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_57 = IterableExtensions.<StringNode, String>map(_ancestorsAndSiblingsBeforeSelfAndSelf, _function_57);
    String _join_57 = IterableExtensions.join(_map_57);
    Matcher<String> _is_58 = Matchers.<String>is("fgbdea");
    Assert.<String>assertThat(_join_57, _is_58);
    Iterable<StringNode> _ancestorsAndSiblingsAfterSelf_1 = h.getAncestorsAndSiblingsAfterSelf();
    final Function1<StringNode,String> _function_58 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_58 = IterableExtensions.<StringNode, String>map(_ancestorsAndSiblingsAfterSelf_1, _function_58);
    String _join_58 = IterableExtensions.join(_map_58);
    Matcher<String> _is_59 = Matchers.<String>is("jfc");
    Assert.<String>assertThat(_join_58, _is_59);
    Iterable<StringNode> _ancestorsAndSiblingsAfterSelfAndSelf_1 = h.getAncestorsAndSiblingsAfterSelfAndSelf();
    final Function1<StringNode,String> _function_59 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_59 = IterableExtensions.<StringNode, String>map(_ancestorsAndSiblingsAfterSelfAndSelf_1, _function_59);
    String _join_59 = IterableExtensions.join(_map_59);
    Matcher<String> _is_60 = Matchers.<String>is("hjfc");
    Assert.<String>assertThat(_join_59, _is_60);
    Iterable<StringNode> _ancestorsAndSiblingsBeforeSelf_1 = h.getAncestorsAndSiblingsBeforeSelf();
    final Function1<StringNode,String> _function_60 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_60 = IterableExtensions.<StringNode, String>map(_ancestorsAndSiblingsBeforeSelf_1, _function_60);
    String _join_60 = IterableExtensions.join(_map_60);
    Matcher<String> _is_61 = Matchers.<String>is("kgbdea");
    Assert.<String>assertThat(_join_60, _is_61);
    Iterable<StringNode> _ancestorsAndSiblingsBeforeSelfAndSelf_1 = h.getAncestorsAndSiblingsBeforeSelfAndSelf();
    final Function1<StringNode,String> _function_61 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_61 = IterableExtensions.<StringNode, String>map(_ancestorsAndSiblingsBeforeSelfAndSelf_1, _function_61);
    String _join_61 = IterableExtensions.join(_map_61);
    Matcher<String> _is_62 = Matchers.<String>is("hkgbdea");
    Assert.<String>assertThat(_join_61, _is_62);
    Iterable<StringNode> _ancestors_5 = b.getAncestors();
    List<StringNode> _list = IterableExtensions.<StringNode>toList(_ancestors_5);
    List<StringNode> _list_1 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(a)));
    Matcher<List<StringNode>> _is_63 = Matchers.<List<StringNode>>is(_list_1);
    Assert.<List<StringNode>>assertThat(_list, _is_63);
    Iterable<StringNode> _ancestorsAndSelf_5 = b.getAncestorsAndSelf();
    List<StringNode> _list_2 = IterableExtensions.<StringNode>toList(_ancestorsAndSelf_5);
    List<StringNode> _list_3 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(b, a)));
    Matcher<List<StringNode>> _is_64 = Matchers.<List<StringNode>>is(_list_3);
    Assert.<List<StringNode>>assertThat(_list_2, _is_64);
    Iterable<StringNode> _children = b.getChildren();
    List<StringNode> _list_4 = IterableExtensions.<StringNode>toList(_children);
    List<StringNode> _list_5 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(g, f)));
    Matcher<List<StringNode>> _is_65 = Matchers.<List<StringNode>>is(_list_5);
    Assert.<List<StringNode>>assertThat(_list_4, _is_65);
    int _childrenCount = b.getChildrenCount();
    Matcher<Integer> _is_66 = Matchers.<Integer>is(Integer.valueOf(2));
    Assert.<Integer>assertThat(Integer.valueOf(_childrenCount), _is_66);
    Iterable<StringNode> _nextsFromSelf = b.getNextsFromSelf();
    List<StringNode> _list_6 = IterableExtensions.<StringNode>toList(_nextsFromSelf);
    List<StringNode> _list_7 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(c)));
    Matcher<List<StringNode>> _is_67 = Matchers.<List<StringNode>>is(_list_7);
    Assert.<List<StringNode>>assertThat(_list_6, _is_67);
    Iterable<StringNode> _nextsFromSelfAndSelf = b.getNextsFromSelfAndSelf();
    List<StringNode> _list_8 = IterableExtensions.<StringNode>toList(_nextsFromSelfAndSelf);
    List<StringNode> _list_9 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(b, c)));
    Matcher<List<StringNode>> _is_68 = Matchers.<List<StringNode>>is(_list_9);
    Assert.<List<StringNode>>assertThat(_list_8, _is_68);
    Iterable<StringNode> _nextsFromLast = b.getNextsFromLast();
    List<StringNode> _list_10 = IterableExtensions.<StringNode>toList(_nextsFromLast);
    List<StringNode> _list_11 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(c)));
    Matcher<List<StringNode>> _is_69 = Matchers.<List<StringNode>>is(_list_11);
    Assert.<List<StringNode>>assertThat(_list_10, _is_69);
    Iterable<StringNode> _nextsFromLastAndSelf = b.getNextsFromLastAndSelf();
    List<StringNode> _list_12 = IterableExtensions.<StringNode>toList(_nextsFromLastAndSelf);
    List<StringNode> _list_13 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(c, b)));
    Matcher<List<StringNode>> _is_70 = Matchers.<List<StringNode>>is(_list_13);
    Assert.<List<StringNode>>assertThat(_list_12, _is_70);
    Iterable<StringNode> _prevsFromFirst = b.getPrevsFromFirst();
    List<StringNode> _list_14 = IterableExtensions.<StringNode>toList(_prevsFromFirst);
    List<StringNode> _list_15 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(e, d)));
    Matcher<List<StringNode>> _is_71 = Matchers.<List<StringNode>>is(_list_15);
    Assert.<List<StringNode>>assertThat(_list_14, _is_71);
    Iterable<StringNode> _prevsFromFirstAndSelf = b.getPrevsFromFirstAndSelf();
    List<StringNode> _list_16 = IterableExtensions.<StringNode>toList(_prevsFromFirstAndSelf);
    List<StringNode> _list_17 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(e, d, b)));
    Matcher<List<StringNode>> _is_72 = Matchers.<List<StringNode>>is(_list_17);
    Assert.<List<StringNode>>assertThat(_list_16, _is_72);
    Iterable<StringNode> _prevsFromSelf = b.getPrevsFromSelf();
    List<StringNode> _list_18 = IterableExtensions.<StringNode>toList(_prevsFromSelf);
    List<StringNode> _list_19 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(d, e)));
    Matcher<List<StringNode>> _is_73 = Matchers.<List<StringNode>>is(_list_19);
    Assert.<List<StringNode>>assertThat(_list_18, _is_73);
    Iterable<StringNode> _prevsFromSelfAndSelf = b.getPrevsFromSelfAndSelf();
    List<StringNode> _list_20 = IterableExtensions.<StringNode>toList(_prevsFromSelfAndSelf);
    List<StringNode> _list_21 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(b, d, e)));
    Matcher<List<StringNode>> _is_74 = Matchers.<List<StringNode>>is(_list_21);
    Assert.<List<StringNode>>assertThat(_list_20, _is_74);
    Iterable<StringNode> _descendantsOfFirstChild = b.getDescendantsOfFirstChild();
    List<StringNode> _list_22 = IterableExtensions.<StringNode>toList(_descendantsOfFirstChild);
    List<StringNode> _list_23 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(g, k)));
    Matcher<List<StringNode>> _is_75 = Matchers.<List<StringNode>>is(_list_23);
    Assert.<List<StringNode>>assertThat(_list_22, _is_75);
    Iterable<StringNode> _descendantsOfFirstChildAndSelf = b.getDescendantsOfFirstChildAndSelf();
    List<StringNode> _list_24 = IterableExtensions.<StringNode>toList(_descendantsOfFirstChildAndSelf);
    List<StringNode> _list_25 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(b, g, k)));
    Matcher<List<StringNode>> _is_76 = Matchers.<List<StringNode>>is(_list_25);
    Assert.<List<StringNode>>assertThat(_list_24, _is_76);
    Iterable<StringNode> _ancestors_6 = e.getAncestors();
    List<StringNode> _list_26 = IterableExtensions.<StringNode>toList(_ancestors_6);
    List<StringNode> _list_27 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(a)));
    Matcher<List<StringNode>> _is_77 = Matchers.<List<StringNode>>is(_list_27);
    Assert.<List<StringNode>>assertThat(_list_26, _is_77);
    Iterable<StringNode> _ancestorsAndSelf_6 = e.getAncestorsAndSelf();
    List<StringNode> _list_28 = IterableExtensions.<StringNode>toList(_ancestorsAndSelf_6);
    List<StringNode> _list_29 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(e, a)));
    Matcher<List<StringNode>> _is_78 = Matchers.<List<StringNode>>is(_list_29);
    Assert.<List<StringNode>>assertThat(_list_28, _is_78);
    Iterable<StringNode> _children_1 = e.getChildren();
    List<StringNode> _list_30 = IterableExtensions.<StringNode>toList(_children_1);
    List<StringNode> _list_31 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList()));
    Matcher<List<StringNode>> _is_79 = Matchers.<List<StringNode>>is(_list_31);
    Assert.<List<StringNode>>assertThat(_list_30, _is_79);
    int _childrenCount_1 = e.getChildrenCount();
    Matcher<Integer> _is_80 = Matchers.<Integer>is(Integer.valueOf(0));
    Assert.<Integer>assertThat(Integer.valueOf(_childrenCount_1), _is_80);
    Iterable<StringNode> _nextsFromSelf_1 = e.getNextsFromSelf();
    List<StringNode> _list_32 = IterableExtensions.<StringNode>toList(_nextsFromSelf_1);
    List<StringNode> _list_33 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(d, b, c)));
    Matcher<List<StringNode>> _is_81 = Matchers.<List<StringNode>>is(_list_33);
    Assert.<List<StringNode>>assertThat(_list_32, _is_81);
    Iterable<StringNode> _nextsFromSelfAndSelf_1 = e.getNextsFromSelfAndSelf();
    List<StringNode> _list_34 = IterableExtensions.<StringNode>toList(_nextsFromSelfAndSelf_1);
    List<StringNode> _list_35 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(e, d, b, c)));
    Matcher<List<StringNode>> _is_82 = Matchers.<List<StringNode>>is(_list_35);
    Assert.<List<StringNode>>assertThat(_list_34, _is_82);
    Iterable<StringNode> _nextsFromLast_1 = e.getNextsFromLast();
    List<StringNode> _list_36 = IterableExtensions.<StringNode>toList(_nextsFromLast_1);
    List<StringNode> _list_37 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(c, b, d)));
    Matcher<List<StringNode>> _is_83 = Matchers.<List<StringNode>>is(_list_37);
    Assert.<List<StringNode>>assertThat(_list_36, _is_83);
    Iterable<StringNode> _nextsFromLastAndSelf_1 = e.getNextsFromLastAndSelf();
    List<StringNode> _list_38 = IterableExtensions.<StringNode>toList(_nextsFromLastAndSelf_1);
    List<StringNode> _list_39 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(c, b, d, e)));
    Matcher<List<StringNode>> _is_84 = Matchers.<List<StringNode>>is(_list_39);
    Assert.<List<StringNode>>assertThat(_list_38, _is_84);
    Iterable<StringNode> _prevsFromFirst_1 = e.getPrevsFromFirst();
    List<StringNode> _list_40 = IterableExtensions.<StringNode>toList(_prevsFromFirst_1);
    List<StringNode> _list_41 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList()));
    Matcher<List<StringNode>> _is_85 = Matchers.<List<StringNode>>is(_list_41);
    Assert.<List<StringNode>>assertThat(_list_40, _is_85);
    Iterable<StringNode> _prevsFromFirstAndSelf_1 = e.getPrevsFromFirstAndSelf();
    List<StringNode> _list_42 = IterableExtensions.<StringNode>toList(_prevsFromFirstAndSelf_1);
    List<StringNode> _list_43 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(e)));
    Matcher<List<StringNode>> _is_86 = Matchers.<List<StringNode>>is(_list_43);
    Assert.<List<StringNode>>assertThat(_list_42, _is_86);
    Iterable<StringNode> _prevsFromSelf_1 = e.getPrevsFromSelf();
    List<StringNode> _list_44 = IterableExtensions.<StringNode>toList(_prevsFromSelf_1);
    List<StringNode> _list_45 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList()));
    Matcher<List<StringNode>> _is_87 = Matchers.<List<StringNode>>is(_list_45);
    Assert.<List<StringNode>>assertThat(_list_44, _is_87);
    Iterable<StringNode> _prevsFromSelfAndSelf_1 = e.getPrevsFromSelfAndSelf();
    List<StringNode> _list_46 = IterableExtensions.<StringNode>toList(_prevsFromSelfAndSelf_1);
    List<StringNode> _list_47 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(e)));
    Matcher<List<StringNode>> _is_88 = Matchers.<List<StringNode>>is(_list_47);
    Assert.<List<StringNode>>assertThat(_list_46, _is_88);
    Iterable<StringNode> _descendantsOfFirstChild_1 = e.getDescendantsOfFirstChild();
    List<StringNode> _list_48 = IterableExtensions.<StringNode>toList(_descendantsOfFirstChild_1);
    List<StringNode> _list_49 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList()));
    Matcher<List<StringNode>> _is_89 = Matchers.<List<StringNode>>is(_list_49);
    Assert.<List<StringNode>>assertThat(_list_48, _is_89);
    Iterable<StringNode> _descendantsOfFirstChildAndSelf_1 = e.getDescendantsOfFirstChildAndSelf();
    List<StringNode> _list_50 = IterableExtensions.<StringNode>toList(_descendantsOfFirstChildAndSelf_1);
    List<StringNode> _list_51 = IterableExtensions.<StringNode>toList(Collections.<StringNode>unmodifiableList(Lists.<StringNode>newArrayList(e)));
    Matcher<List<StringNode>> _is_90 = Matchers.<List<StringNode>>is(_list_51);
    Assert.<List<StringNode>>assertThat(_list_50, _is_90);
    boolean _Remove = g.Remove();
    Matcher<Boolean> _is_91 = Matchers.<Boolean>is(Boolean.valueOf(true));
    Assert.<Boolean>assertThat(Boolean.valueOf(_Remove), _is_91);
    Iterable<StringNode> _descendants_11 = a.getDescendants();
    final Function1<StringNode,String> _function_62 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_62 = IterableExtensions.<StringNode, String>map(_descendants_11, _function_62);
    String _join_62 = IterableExtensions.join(_map_62);
    Matcher<String> _is_92 = Matchers.<String>is("edbflimc");
    Assert.<String>assertThat(_join_62, _is_92);
    boolean _Remove_1 = f.Remove();
    Matcher<Boolean> _is_93 = Matchers.<Boolean>is(Boolean.valueOf(true));
    Assert.<Boolean>assertThat(Boolean.valueOf(_Remove_1), _is_93);
    Iterable<StringNode> _descendants_12 = a.getDescendants();
    final Function1<StringNode,String> _function_63 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_63 = IterableExtensions.<StringNode, String>map(_descendants_12, _function_63);
    String _join_63 = IterableExtensions.join(_map_63);
    Matcher<String> _is_94 = Matchers.<String>is("edbc");
    Assert.<String>assertThat(_join_63, _is_94);
    boolean _Remove_2 = g.Remove();
    Matcher<Boolean> _is_95 = Matchers.<Boolean>is(Boolean.valueOf(false));
    Assert.<Boolean>assertThat(Boolean.valueOf(_Remove_2), _is_95);
    boolean _Remove_3 = f.Remove();
    Matcher<Boolean> _is_96 = Matchers.<Boolean>is(Boolean.valueOf(false));
    Assert.<Boolean>assertThat(Boolean.valueOf(_Remove_3), _is_96);
  }
  
  @Test
  public void TraverseSingles() {
    StringNode a = new StringNode("a");
    StringNode b = new StringNode("b");
    StringNode c = new StringNode("c");
    StringNode d = new StringNode("d");
    StringNode e = new StringNode("e");
    StringNode f = new StringNode("f");
    StringNode g = new StringNode("g");
    a.AddFirst(b);
    a.AddLast(g);
    b.AddFirst(c);
    c.AddFirst(d);
    d.AddFirst(e);
    d.AddLast(f);
    Iterable<StringNode> _descendantsOfSingle = b.getDescendantsOfSingle();
    final Function1<StringNode,String> _function = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map = IterableExtensions.<StringNode, String>map(_descendantsOfSingle, _function);
    String _join = IterableExtensions.join(_map);
    Matcher<String> _is = Matchers.<String>is("cd");
    Assert.<String>assertThat(_join, _is);
    Iterable<StringNode> _descendantsOfSingleAndSelf = b.getDescendantsOfSingleAndSelf();
    final Function1<StringNode,String> _function_1 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_1 = IterableExtensions.<StringNode, String>map(_descendantsOfSingleAndSelf, _function_1);
    String _join_1 = IterableExtensions.join(_map_1);
    Matcher<String> _is_1 = Matchers.<String>is("bcd");
    Assert.<String>assertThat(_join_1, _is_1);
    Iterable<StringNode> _descendantsOfSingle_1 = c.getDescendantsOfSingle();
    final Function1<StringNode,String> _function_2 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_2 = IterableExtensions.<StringNode, String>map(_descendantsOfSingle_1, _function_2);
    String _join_2 = IterableExtensions.join(_map_2);
    Matcher<String> _is_2 = Matchers.<String>is("d");
    Assert.<String>assertThat(_join_2, _is_2);
    Iterable<StringNode> _descendantsOfSingleAndSelf_1 = c.getDescendantsOfSingleAndSelf();
    final Function1<StringNode,String> _function_3 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_3 = IterableExtensions.<StringNode, String>map(_descendantsOfSingleAndSelf_1, _function_3);
    String _join_3 = IterableExtensions.join(_map_3);
    Matcher<String> _is_3 = Matchers.<String>is("cd");
    Assert.<String>assertThat(_join_3, _is_3);
    Iterable<StringNode> _ancestorsWithSingleChild = b.getAncestorsWithSingleChild();
    final Function1<StringNode,String> _function_4 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_4 = IterableExtensions.<StringNode, String>map(_ancestorsWithSingleChild, _function_4);
    String _join_4 = IterableExtensions.join(_map_4);
    Matcher<String> _is_4 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_4, _is_4);
    Iterable<StringNode> _ancestorsWithSingleChildAndSelf = b.getAncestorsWithSingleChildAndSelf();
    final Function1<StringNode,String> _function_5 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_5 = IterableExtensions.<StringNode, String>map(_ancestorsWithSingleChildAndSelf, _function_5);
    String _join_5 = IterableExtensions.join(_map_5);
    Matcher<String> _is_5 = Matchers.<String>is("b");
    Assert.<String>assertThat(_join_5, _is_5);
    Iterable<StringNode> _ancestorsWithSingleChild_1 = c.getAncestorsWithSingleChild();
    final Function1<StringNode,String> _function_6 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_6 = IterableExtensions.<StringNode, String>map(_ancestorsWithSingleChild_1, _function_6);
    String _join_6 = IterableExtensions.join(_map_6);
    Matcher<String> _is_6 = Matchers.<String>is("b");
    Assert.<String>assertThat(_join_6, _is_6);
    Iterable<StringNode> _ancestorsWithSingleChildAndSelf_1 = c.getAncestorsWithSingleChildAndSelf();
    final Function1<StringNode,String> _function_7 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_7 = IterableExtensions.<StringNode, String>map(_ancestorsWithSingleChildAndSelf_1, _function_7);
    String _join_7 = IterableExtensions.join(_map_7);
    Matcher<String> _is_7 = Matchers.<String>is("cb");
    Assert.<String>assertThat(_join_7, _is_7);
    Iterable<StringNode> _ancestorsWithSingleChild_2 = d.getAncestorsWithSingleChild();
    final Function1<StringNode,String> _function_8 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_8 = IterableExtensions.<StringNode, String>map(_ancestorsWithSingleChild_2, _function_8);
    String _join_8 = IterableExtensions.join(_map_8);
    Matcher<String> _is_8 = Matchers.<String>is("cb");
    Assert.<String>assertThat(_join_8, _is_8);
    Iterable<StringNode> _ancestorsWithSingleChildAndSelf_2 = d.getAncestorsWithSingleChildAndSelf();
    final Function1<StringNode,String> _function_9 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_9 = IterableExtensions.<StringNode, String>map(_ancestorsWithSingleChildAndSelf_2, _function_9);
    String _join_9 = IterableExtensions.join(_map_9);
    Matcher<String> _is_9 = Matchers.<String>is("dcb");
    Assert.<String>assertThat(_join_9, _is_9);
    Iterable<StringNode> _ancestorsWithSingleChild_3 = e.getAncestorsWithSingleChild();
    final Function1<StringNode,String> _function_10 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_10 = IterableExtensions.<StringNode, String>map(_ancestorsWithSingleChild_3, _function_10);
    String _join_10 = IterableExtensions.join(_map_10);
    Matcher<String> _is_10 = Matchers.<String>is("");
    Assert.<String>assertThat(_join_10, _is_10);
    Iterable<StringNode> _ancestorsWithSingleChildAndSelf_3 = e.getAncestorsWithSingleChildAndSelf();
    final Function1<StringNode,String> _function_11 = new Function1<StringNode,String>() {
      public String apply(final StringNode it) {
        return it.getValue();
      }
    };
    Iterable<String> _map_11 = IterableExtensions.<StringNode, String>map(_ancestorsWithSingleChildAndSelf_3, _function_11);
    String _join_11 = IterableExtensions.join(_map_11);
    Matcher<String> _is_11 = Matchers.<String>is("e");
    Assert.<String>assertThat(_join_11, _is_11);
  }
}
