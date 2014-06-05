package net.exkazuu.tree

class NamedNode<TNode extends NamedNode<TNode, ?>, TValue> extends Node<TNode, TValue> {

	/**
     * Initializes a new instance of the Node class with a default value.
     */
	protected new() {
	}

	/**
     * Initializes a new instance of the Node class with the specified value.
     */
	protected new(TValue value) {
		super(value)
	}

	@Property String name

	final def child(String name) {
		children.findFirst[it.name == name]
	}

	final def ancestors(String name) {
		ancestors.filter[it.name == name]
	}

	final def ancestorsAndSelf(String name) {
		ancestorsAndSelf.filter[it.name == name]
	}

	final def children(String name) {
		children.filter[it.name == name]
	}

	final def nextsFromSelf(String name) {
		nextsFromSelf.filter[it.name == name]
	}

	final def nextsFromSelfAndSelf(String name) {
		nextsFromSelfAndSelf.filter[it.name == name]
	}

	final def nextsFromLast(String name) {
		nextsFromLast.filter[it.name == name]
	}

	final def nextsFromLastAndSelf(String name) {
		nextsFromLastAndSelf.filter[it.name == name]
	}

	final def prevsFromFirst(String name) {
		prevsFromFirst.filter[it.name == name]
	}

	final def prevsFromFirstAndSelf(String name) {
		prevsFromFirstAndSelf.filter[it.name == name]
	}

	final def prevsFromSelf(String name) {
		prevsFromSelf.filter[it.name == name]
	}

	final def prevsFromSelfAndSelf(String name) {
		prevsFromSelfAndSelf.filter[it.name == name]
	}

	final def descendants(String name) {
		descendants.filter[it.name == name]
	}

	final def descendantsAndSelf(String name) {
		descendantsAndSelf.filter[it.name == name]
	}

	final def siblings(String name) {
		siblings.filter[it.name == name]
	}

	final def siblingsAndSelf(String name) {
		siblingsAndSelf.filter[it.name == name]
	}

	final def ancestorsAndSiblingsAfterSelf(String name) {
		ancestorsAndSiblingsAfterSelf.filter[it.name == name]
	}

	final def ancestorsAndSiblingsAfterSelfAndSelf(String name) {
		ancestorsAndSiblingsAfterSelfAndSelf.filter[it.name == name]
	}

	final def ancestorsAndSiblingsBeforeSelf(String name) {
		ancestorsAndSiblingsBeforeSelf.filter[it.name == name]
	}

	final def ancestorsAndSiblingsBeforeSelfAndSelf(String name) {
		ancestorsAndSiblingsBeforeSelfAndSelf.filter[it.name == name]
	}

	final def ancestorsWithSingleChild(String name) {
		ancestorsWithSingleChild.filter[it.name == name]
	}

	final def ancestorsWithSingleChildAndSelf(String name) {
		ancestorsWithSingleChildAndSelf.filter[it.name == name]
	}

	final def descendantsOfSingle(String name) {
		descendantsOfSingle.filter[it.name == name]
	}

	final def descendantsOfSingleAndSelf(String name) {
		descendantsOfSingleAndSelf.filter[it.name == name]
	}

	final def descendantsOfFirstChild(String name) {
		descendantsOfFirstChild.filter[it.name == name]
	}

	final def descendantsOfFirstChildAndSelf(String name) {
		descendantsOfFirstChildAndSelf.filter[it.name == name]
	}

	final def ancestors(String name, int inclusiveDepth) {
		ancestors(inclusiveDepth).filter[it.name == name]
	}

	final def ancestorsAndSelf(String name, int inclusiveDepth) {
		ancestorsAndSelf(inclusiveDepth).filter[it.name == name]
	}

	final def descendants(String name, int inclusiveDepth) {
		descendants(inclusiveDepth).filter[it.name == name]
	}

	final def descendantsAndSelf(String name, int inclusiveDepth) {
		descendantsAndSelf(inclusiveDepth).filter[it.name == name]
	}

	final def siblings(String name, int inclusiveEachLength) {
		siblings(inclusiveEachLength).filter[it.name == name];
	}

	final def siblingsAndSelf(String name, int inclusiveEachLength) {
		siblingsAndSelf(inclusiveEachLength).filter[it.name == name]
	}

}
