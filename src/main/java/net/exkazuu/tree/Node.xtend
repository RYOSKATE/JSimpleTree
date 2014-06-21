package net.exkazuu.tree

public class Node<TNode extends Node<TNode, TValue>, TValue> extends NodeBase<TNode, TValue> {

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

	final def childrenCount() {
		children.length
	}

	final def childAtOrNull(int index) {
		children.drop(index).head
	}

	final def ancestors() {
		ancestorsAndSelf.tail
	}

	final def getNextsFromSelfAndSelf() {
		#[thisNode] + nextsFromSelf
	}

	final def getNextsFromLastAndSelf() {
		nextsFromLast + #[thisNode]
	}

	final def prevsFromFirstAndSelf() {
		prevsFromFirst + #[thisNode]
	}

	final def prevsFromSelfAndSelf() {
		#[thisNode] + prevsFromSelf
	}

	final def descendantsAndSelf() {
		#[thisNode] + descendants
	}

	final def ancestorsAndSiblingsAfterSelf() {
		ancestorsAndSelf.map[it.nextsFromSelf].flatten
	}

	final def ancestorsAndSiblingsAfterSelfAndSelf() {
		#[thisNode] + ancestorsAndSiblingsAfterSelf
	}

	final def ancestorsAndSiblingsBeforeSelf() {
		ancestorsAndSiblingsBeforeSelfAndSelf.tail
	}

	final def ancestorsAndSiblingsBeforeSelfAndSelf() {
		ancestorsAndSelf.map[it.prevsFromSelfAndSelf].flatten
	}

	final def ancestorsWithSingleChildAndSelf() {
		#[thisNode] + ancestorsWithSingleChild
	}

	final def descendantsOfSingleAndSelf() {
		#[thisNode] + descendantsOfSingle
	}

	final def descendantsOfFirstChildAndSelf() {
		#[thisNode] + descendantsOfFirstChild
	}

	final def ancestors(int inclusiveDepth) {
		ancestors.take(inclusiveDepth)
	}

	final def ancestorsAndSelf(int inclusiveDepth) {
		ancestorsAndSelf.take(inclusiveDepth + 1)
	}

	final def descendantsAndSelf(int inclusiveDepth) {
		#[thisNode] + descendants(inclusiveDepth)
	}

	final def siblings(int inclusiveEachLength) {
		return prevsFromSelf.take(inclusiveEachLength).toList.reverse + nextsFromSelf.take(inclusiveEachLength)
	}

	final def siblingsAndSelf(int inclusiveEachLength) {
		return prevsFromSelf.take(inclusiveEachLength).toList.reverse + #[thisNode] +
			nextsFromSelf.take(inclusiveEachLength)
	}

	final def remove() {
		if (_parent == null) {
			return null
		}
		val next = _cyclicNext
		val action = if (next != this) {
				_cyclicPrev._cyclicNext = next
				next._cyclicPrev = _cyclicPrev
				if (_parent._firstChild == this) {
					_parent._firstChild = next;
					[ |
						next._parent._firstChild = thisNode
						next.addPreviousIgnoringFirstChild(thisNode)
					]
				} else {
					[|next.addPreviousIgnoringFirstChild(thisNode)]
				}
			} else {
				val parent = _parent
				parent._firstChild = null
				[|parent.addFirst(thisNode)]
			}
		_cyclicNext = null
		_cyclicPrev = null
		_parent = null
		return action
	}
}
