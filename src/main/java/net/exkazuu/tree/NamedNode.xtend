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

	final def getChild(String name) {
		children.findFirst[it.name == name]
	}

	final def getAncestors(String name) {
		ancestors.filter[it.name == name]
	}

	final def getAncestorsAndSelf(String name) {
		ancestorsAndSelf.filter[it.name == name]
	}

	final def getChildren(String name) {
		children.filter[it.name == name]
	}

	final def getNextsFromSelf(String name) {
		nextsFromSelf.filter[it.name == name]
	}

	final def getNextsFromSelfAndSelf(String name) {
		nextsFromSelfAndSelf.filter[it.name == name]
	}

	final def getNextsFromLast(String name) {
		nextsFromLast.filter[it.name == name]
	}

	final def getNextsFromLastAndSelf(String name) {
		nextsFromLastAndSelf.filter[it.name == name]
	}

	final def getPrevsFromFirst(String name) {
		prevsFromFirst.filter[it.name == name]
	}

	final def getPrevsFromFirstAndSelf(String name) {
		prevsFromFirstAndSelf.filter[it.name == name]
	}

	final def getPrevsFromSelf(String name) {
		prevsFromSelf.filter[it.name == name]
	}

	final def getPrevsFromSelfAndSelf(String name) {
		prevsFromSelfAndSelf.filter[it.name == name]
	}

	final def getDescendants(String name) {
		descendants.filter[it.name == name]
	}

	final def getDescendantsAndSelf(String name) {
		descendantsAndSelf.filter[it.name == name]
	}

	final def getSiblings(String name) {
		siblings.filter[it.name == name]
	}

	final def getSiblingsAndSelf(String name) {
		siblingsAndSelf.filter[it.name == name]
	}

	final def getAncestorsAndSiblingsAfterSelf(String name) {
		ancestorsAndSiblingsAfterSelf.filter[it.name == name]
	}

	final def getAncestorsAndSiblingsAfterSelfAndSelf(String name) {
		ancestorsAndSiblingsAfterSelfAndSelf.filter[it.name == name]
	}

	final def getAncestorsAndSiblingsBeforeSelf(String name) {
		ancestorsAndSiblingsBeforeSelf.filter[it.name == name]
	}

	final def getAncestorsAndSiblingsBeforeSelfAndSelf(String name) {
		ancestorsAndSiblingsBeforeSelfAndSelf.filter[it.name == name]
	}

	final def getAncestorsWithSingleChild(String name) {
		ancestorsWithSingleChild.filter[it.name == name]
	}

	final def getAncestorsWithSingleChildAndSelf(String name) {
		ancestorsWithSingleChildAndSelf.filter[it.name == name]
	}

	final def getDescendantsOfSingle(String name) {
		descendantsOfSingle.filter[it.name == name]
	}

	final def getDescendantsOfSingleAndSelf(String name) {
		descendantsOfSingleAndSelf.filter[it.name == name]
	}

	final def getDescendantsOfFirstChild(String name) {
		descendantsOfFirstChild.filter[it.name == name]
	}

	final def getDescendantsOfFirstChildAndSelf(String name) {
		descendantsOfFirstChildAndSelf.filter[it.name == name]
	}

	final def getAncestors(String name, int inclusiveDepth) {
		getAncestors(inclusiveDepth).filter[it.name == name]
	}

	final def getAncestorsAndSelf(String name, int inclusiveDepth) {
		getAncestorsAndSelf(inclusiveDepth).filter[it.name == name]
	}

	final def getDescendants(String name, int inclusiveDepth) {
		getDescendants(inclusiveDepth).filter[it.name == name]
	}

	final def getDescendantsAndSelf(String name, int inclusiveDepth) {
		getDescendantsAndSelf(inclusiveDepth).filter[it.name == name]
	}

	final def getSiblings(String name, int inclusiveEachLength) {
		getSiblings(inclusiveEachLength).filter[it.name == name];
	}

	final def getSiblingsAndSelf(String name, int inclusiveEachLength) {
		getSiblingsAndSelf(inclusiveEachLength).filter[it.name == name]
	}

}
