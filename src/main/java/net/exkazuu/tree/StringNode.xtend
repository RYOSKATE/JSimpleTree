package net.exkazuu.tree

class StringNode extends NamedNode<StringNode, String> {

	new(String node) {
		super(node)
	}

	final def getValue() {
		_value
	}

	final def setValue(String value) {
		_value = value
	}

	final def AddFirst(String value) {
		return addFirst(new StringNode(value));
	}

	final def AddLast(String value) {
		return addLast(new StringNode(value));
	}

	final def AddNext(String value) {
		return addNext(new StringNode(value));
	}

	final def AddPrevious(String value) {
		return addPrevious(new StringNode(value));
	}
}
