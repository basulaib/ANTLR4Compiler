module BST
open util/boolean

sig Node {
	left: lone Node,
	right: lone Node,
	parent: lone Node,
	happy: Bool,
	key: Int
}

sig BST {
	root: lone Node
}{
	no root.parent
}

fact ChildrenNotEqual {
	all n: Node | n.left != n.right
	all n: Node | n.left.key > n.right.key && n.left.key > n.parent.key && n.right.key < n.parent.key
}

fact BSTProperty {
	all n: Node | n.left.key > n.right.key && n.left.key > n.parent.key && n.right.key < n.parent.key
}

fact OneParent {
	all n: Node | lone (n.~left+n.~right)
}

pred test {}

run test for 5 BST, 5 Node

/*
fact {
	all t: BST, n: t.root | n.left.parent = n and n.right.parent = n
}

pred Parent(t: BST) {
	all n,n':t.root.*(left+right) | n in n'.(left+right) => n' = n.parent
	no t.root.parent
}

*/
/*
pred test { }

run test for exactly 4 BST, 4 Node
*/

/*
assert children {
	one t: Node | (some t.left => t.left.parent = t) && (some t.right => t.right.parent = t)
}

check children for 3 BST, 3 Node
*/
