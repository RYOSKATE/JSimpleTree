package net.exkazuu.tree

import org.junit.Test

import static org.hamcrest.Matchers.*
import static org.junit.Assert.*

class NodeTest {
	def NormalizeNewLine(String text) {
		return text.replace("\n", System.lineSeparator);
	}

	@Test
	def OperateRoot() {
		val root = new StringNode("a");
		assertThat(root.prevsFromFirst.toList, is(#[].toList))
		assertThat(root.nextsFromSelf.toList, is(#[].toList))
		assertThat(root.prevsFromFirstAndSelf.toList, is(#[root].toList))
		assertThat(root.nextsFromSelfAndSelf.toList, is(#[root].toList))
		assertThat(root.prevsFromSelf.toList, is(#[].toList))
		assertThat(root.nextsFromLast.toList, is(#[].toList))
		assertThat(root.prevsFromSelfAndSelf.toList, is(#[root].toList))
		assertThat(root.nextsFromLastAndSelf.toList, is(#[root].toList))
	}

	@Test
	def Create1Node() {
		val node = new StringNode("a");
		assertThat(node.toString, is("a\n".NormalizeNewLine()))
		assertThat(node.descendants.map[it.value].join, is(""))
	}

	@Test
	def Create2Nodes() {
		var node = new StringNode("a");
		node.addFirst(new StringNode("b"));
		assertThat(node.toString, is("a\n  b\n".NormalizeNewLine()))
		assertThat(node.descendants.map[it.value].join, is("b"))
	}

	@Test
	def Create3Nodes() {
		var node = new StringNode("a");
		node.addLast(new StringNode("b"));
		node.addFirst(new StringNode("c"));
		assertThat(node.toString, is("a\n  c\n  b\n".NormalizeNewLine()))
		assertThat(node.descendants.map[it.value].join, is("cb"))
	}

	@Test
	def Create4Nodes() {
		var node = new StringNode("a");
		node.addLast(new StringNode("b"));
		node.addFirst(new StringNode("c"));
		node.addLast(new StringNode("d"));
		assertThat(node.toString, is("a\n  c\n  b\n  d\n".NormalizeNewLine()))
		assertThat(node.descendants.map[it.value].join, is("cbd"))
	}

	@Test
	def CreateTreeAndTraverse() {
		var a = new StringNode("a"); // 1
		var b = a.addFirst(new StringNode("b")); // 2
		var c = a.addLast(new StringNode("c")); // 2
		var d = a.addFirst(new StringNode("d")); // 2
		var e = a.addFirst(new StringNode("e")); // 2
		var f = b.addFirst(new StringNode("f")); // 3
		var g = b.addFirst(new StringNode("g")); // 3
		var h = g.AddLast("h"); // 4
		var i = f.AddLast("i"); // 4
		var j = h.AddNext("j"); // 4
		var k = h.AddPrevious("k"); // 4
		var l = i.AddPrevious("l"); // 4
		var m = i.AddNext("m"); // 4
		assertThat(a.toString,
			is(
				"a\n  e\n  d\n  b\n    g\n      k\n      h\n      j\n    f\n      l\n      i\n      m\n  c\n".
					NormalizeNewLine()))

		assertThat(a.descendants.map[it.value].join, is("edbgkhjflimc"))
		assertThat(e.descendants.map[it.value].join, is(""))
		assertThat(d.descendants.map[it.value].join, is(""))
		assertThat(b.descendants.map[it.value].join, is("gkhjflim"))
		assertThat(c.descendants.map[it.value].join, is(""))

		assertThat(a.descendantsAndSelf.map[it.value].join, is("aedbgkhjflimc"))
		assertThat(e.descendantsAndSelf.map[it.value].join, is("e"))
		assertThat(d.descendantsAndSelf.map[it.value].join, is("d"))
		assertThat(b.descendantsAndSelf.map[it.value].join, is("bgkhjflim"))
		assertThat(c.descendantsAndSelf.map[it.value].join, is("c"))

		assertThat(a.descendants(2).map[it.value].join, is("edbgfc"))
		assertThat(e.descendants(2).map[it.value].join, is(""))
		assertThat(d.descendants(2).map[it.value].join, is(""))
		assertThat(b.descendants(2).map[it.value].join, is("gkhjflim"))
		assertThat(c.descendants(2).map[it.value].join, is(""))
		assertThat(b.descendants(0).map[it.value].join, is(""))

		assertThat(a.descendantsAndSelf(2).map[it.value].join, is("aedbgfc"))
		assertThat(e.descendantsAndSelf(2).map[it.value].join, is("e"))
		assertThat(d.descendantsAndSelf(2).map[it.value].join, is("d"))
		assertThat(b.descendantsAndSelf(2).map[it.value].join, is("bgkhjflim"))
		assertThat(c.descendantsAndSelf(2).map[it.value].join, is("c"))
		assertThat(b.descendantsAndSelf(0).map[it.value].join, is("b"))

		assertThat(a.siblings.map[it.value].join, is(""))
		assertThat(k.siblings.map[it.value].join, is("hj"))
		assertThat(h.siblings.map[it.value].join, is("kj"))
		assertThat(j.siblings.map[it.value].join, is("kh"))
		assertThat(i.siblings.map[it.value].join, is("lm"))

		assertThat(a.siblingsAndSelf.map[it.value].join, is("a"))
		assertThat(k.siblingsAndSelf.map[it.value].join, is("khj"))
		assertThat(h.siblingsAndSelf.map[it.value].join, is("khj"))
		assertThat(j.siblingsAndSelf.map[it.value].join, is("khj"))
		assertThat(i.siblingsAndSelf.map[it.value].join, is("lim"))

		assertThat(a.siblings(1).map[it.value].join, is(""))
		assertThat(k.siblings(1).map[it.value].join, is("h"))
		assertThat(h.siblings(1).map[it.value].join, is("kj"))
		assertThat(j.siblings(1).map[it.value].join, is("h"))
		assertThat(i.siblings(1).map[it.value].join, is("lm"))
		assertThat(i.siblings(0).map[it.value].join, is(""))

		assertThat(a.siblingsAndSelf(1).map[it.value].join, is("a"))
		assertThat(k.siblingsAndSelf(1).map[it.value].join, is("kh"))
		assertThat(h.siblingsAndSelf(1).map[it.value].join, is("khj"))
		assertThat(j.siblingsAndSelf(1).map[it.value].join, is("hj"))
		assertThat(i.siblingsAndSelf(1).map[it.value].join, is("lim"))
		assertThat(i.siblingsAndSelf(0).map[it.value].join, is("i"))

		assertThat(i.ancestors.map[it.value].join, is("fba"))
		assertThat(i.ancestors(3).map[it.value].join, is("fba"))
		assertThat(i.ancestors(2).map[it.value].join, is("fb"))
		assertThat(i.ancestors(1).map[it.value].join, is("f"))
		assertThat(i.ancestors(0).map[it.value].join, is(""))

		assertThat(i.ancestorsAndSelf.map[it.value].join, is("ifba"))
		assertThat(i.ancestorsAndSelf(3).map[it.value].join, is("ifba"))
		assertThat(i.ancestorsAndSelf(2).map[it.value].join, is("ifb"))
		assertThat(i.ancestorsAndSelf(1).map[it.value].join, is("if"))
		assertThat(i.ancestorsAndSelf(0).map[it.value].join, is("i"))

		assertThat(f.ancestorsAndSiblingsAfterSelf.map[it.value].join, is("c"))
		assertThat(f.ancestorsAndSiblingsAfterSelfAndSelf.map[it.value].join, is("fc"))
		assertThat(f.ancestorsAndSiblingsBeforeSelf.map[it.value].join, is("gbdea"))
		assertThat(f.ancestorsAndSiblingsBeforeSelfAndSelf.map[it.value].join, is("fgbdea"))

		assertThat(h.ancestorsAndSiblingsAfterSelf.map[it.value].join, is("jfc"))
		assertThat(h.ancestorsAndSiblingsAfterSelfAndSelf.map[it.value].join, is("hjfc"))
		assertThat(h.ancestorsAndSiblingsBeforeSelf.map[it.value].join, is("kgbdea"))
		assertThat(h.ancestorsAndSiblingsBeforeSelfAndSelf.map[it.value].join, is("hkgbdea"))

		assertThat(b.ancestors.toList, is(#[a].toList));
		assertThat(b.ancestorsAndSelf.toList, is(#[b, a].toList));
		assertThat(b.children.toList, is(#[g, f].toList));
		assertThat(b.childrenCount, is(2));
		assertThat(b.nextsFromSelf.toList, is(#[c].toList));
		assertThat(b.nextsFromSelfAndSelf.toList, is(#[b, c].toList));
		assertThat(b.nextsFromLast.toList, is(#[c].toList));
		assertThat(b.nextsFromLastAndSelf.toList, is(#[c, b].toList));
		assertThat(b.prevsFromFirst.toList, is(#[e, d].toList));
		assertThat(b.prevsFromFirstAndSelf.toList, is(#[e, d, b].toList));
		assertThat(b.prevsFromSelf.toList, is(#[d, e].toList));
		assertThat(b.prevsFromSelfAndSelf.toList, is(#[b, d, e].toList));
		assertThat(b.descendantsOfFirstChild.toList, is(#[g, k].toList));
		assertThat(b.descendantsOfFirstChildAndSelf.toList, is(#[b, g, k].toList));

		assertThat(e.ancestors.toList, is(#[a].toList));
		assertThat(e.ancestorsAndSelf.toList, is(#[e, a].toList));
		assertThat(e.children.toList, is(#[].toList));
		assertThat(e.childrenCount, is(0));
		assertThat(e.nextsFromSelf.toList, is(#[d, b, c].toList));
		assertThat(e.nextsFromSelfAndSelf.toList, is(#[e, d, b, c].toList));
		assertThat(e.nextsFromLast.toList, is(#[c, b, d].toList));
		assertThat(e.nextsFromLastAndSelf.toList, is(#[c, b, d, e].toList));
		assertThat(e.prevsFromFirst.toList, is(#[].toList));
		assertThat(e.prevsFromFirstAndSelf.toList, is(#[e].toList));
		assertThat(e.prevsFromSelf.toList, is(#[].toList));
		assertThat(e.prevsFromSelfAndSelf.toList, is(#[e].toList));
		assertThat(e.descendantsOfFirstChild.toList, is(#[].toList));
		assertThat(e.descendantsOfFirstChildAndSelf.toList, is(#[e].toList));

		val restoreG = g.recoverablyRemove()
		assertThat(restoreG, is(not(nullValue)))
		assertThat(a.descendants.map[it.value].join, is("edbflimc"))

		val restoreF = f.recoverablyRemove()
		assertThat(restoreF, is(not(nullValue)))
		assertThat(a.descendants.map[it.value].join, is("edbc"))

		val anotherRestoreF = f.recoverablyRemove();
		restoreF.apply();
		anotherRestoreF.apply();
		restoreF.apply();
		assertThat(a.descendants().map[it.value].join, is("edbflimc"));
		var anotherRestoreG = g.recoverablyRemove();
		restoreG.apply();
		anotherRestoreG.apply();
		restoreG.apply();
		assertThat(a.descendants().map[it.value].join, is("edbgkhjflimc"));

		assertThat(a.recoverablyRemove(), is(nullValue));
		for (node : a.descendants().toList) {
			var restore = node.recoverablyRemove()
			assertThat(restore, is(not(nullValue)))
			assertThat(a.descendants.map[it.value].join, is(not(containsString(node.value))))
			restore.apply
			assertThat(a.descendants.map[it.value].join, is("edbgkhjflimc"))
		}
	}

	@Test
	def TraverseSingles() {
		var a = new StringNode("a");
		var b = new StringNode("b");
		var c = new StringNode("c");
		var d = new StringNode("d");
		var e = new StringNode("e");
		var f = new StringNode("f");
		var g = new StringNode("g");

		// a - b - c - d - e
		//   - g         - f
		a.addFirst(b);
		a.addLast(g);
		b.addFirst(c);
		c.addFirst(d);
		d.addFirst(e);
		d.addLast(f);

		assertThat(b.descendantsOfSingle.map[it.value].join, is("cd"))
		assertThat(b.descendantsOfSingleAndSelf.map[it.value].join, is("bcd"))
		assertThat(c.descendantsOfSingle.map[it.value].join, is("d"))
		assertThat(c.descendantsOfSingleAndSelf.map[it.value].join, is("cd"))

		assertThat(b.ancestorsWithSingleChild.map[it.value].join, is(""))
		assertThat(b.ancestorsWithSingleChildAndSelf.map[it.value].join, is("b"))
		assertThat(c.ancestorsWithSingleChild.map[it.value].join, is("b"))
		assertThat(c.ancestorsWithSingleChildAndSelf.map[it.value].join, is("cb"))
		assertThat(d.ancestorsWithSingleChild.map[it.value].join, is("cb"))
		assertThat(d.ancestorsWithSingleChildAndSelf.map[it.value].join, is("dcb"))
		assertThat(e.ancestorsWithSingleChild.map[it.value].join, is(""))
		assertThat(e.ancestorsWithSingleChildAndSelf.map[it.value].join, is("e"))
	}
}
