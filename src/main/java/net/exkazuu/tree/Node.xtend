package net.exkazuu.tree

public class Node<TNode extends Node<TNode, ?>, TValue> extends NodeBase<TNode, TValue> {

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

	final def getChildrenCount() {
		children.length
	}

	final def getChildAtOrNull(int index) {
		children.drop(index).head
	}

	final def getAncestors() {
		ancestorsAndSelf.tail
	}

	final def getNextsFromSelfAndSelf() {
		#[thisNode] + nextsFromSelf
	}

	final def getNextsFromLastAndSelf() {
		nextsFromLast + #[thisNode]
	}

	final def getPrevsFromFirstAndSelf() {
		prevsFromFirst + #[thisNode]
	}

	final def getPrevsFromSelfAndSelf() {
		#[thisNode] + prevsFromSelf
	}

	final def getDescendantsAndSelf() {
		#[thisNode] + descendants
	}

	final def getAncestorsAndSiblingsAfterSelf() {
		ancestorsAndSelf.map[it.nextsFromSelf].flatten
	}

	final def getAncestorsAndSiblingsAfterSelfAndSelf() {
		#[thisNode] + ancestorsAndSiblingsAfterSelf
	}

	final def getAncestorsAndSiblingsBeforeSelf() {
		ancestorsAndSiblingsBeforeSelfAndSelf.tail
	}

	final def getAncestorsAndSiblingsBeforeSelfAndSelf() {
		ancestorsAndSelf.map[it.prevsFromSelfAndSelf].flatten
	}

	final def getAncestorsWithSingleChildAndSelf() {
		#[thisNode] + ancestorsWithSingleChild
	}

	final def getDescendantsOfSingleAndSelf() {
		#[thisNode] + descendantsOfSingle
	}

	final def getDescendantsOfFirstChildAndSelf() {
		#[thisNode] + descendantsOfFirstChild
	}

	final def getAncestors(int inclusiveDepth) {
		ancestors.take(inclusiveDepth)
	}

	final def getAncestorsAndSelf(int inclusiveDepth) {
		ancestorsAndSelf.take(inclusiveDepth + 1)
	}

	final def getDescendantsAndSelf(int inclusiveDepth) {
		#[thisNode] + getDescendants(inclusiveDepth)
	}

	final def getSiblings(int inclusiveEachLength) {
		return prevsFromSelf.take(inclusiveEachLength).toList.reverse + nextsFromSelf.take(inclusiveEachLength);
	}

	final def getSiblingsAndSelf(int inclusiveEachLength) {
		return prevsFromSelf.take(inclusiveEachLength).toList.reverse + #[thisNode] +
			nextsFromSelf.take(inclusiveEachLength);
	}

}
