module LinkedList

sig Node{
	index: Int,
	prev: lone Node,
	value: Int,
	next: lone Node
}{
//	prev = none => index = 0 else index = plus[prev.index][1]
}

//make sure the link is legal
fact DoubleLinked{
	no n: Node | n = n.next
	no n: Node | n = n.prev
	all n, m: Node | m = n.next => (n = m.prev and m.next != n)
}

//assume the index is counted properly
fact Counted{
	all n: Node | n.prev = none => n.index = 0
	all n: Node | n.prev != none => n.index = (plus[n.prev.index][1])
}

//fact Sorted{
//	all n: Node | n.next != none => n.value <= n.next.value
//}

//make sure there's only one list
fact OneList{
	one n: Node | n.prev = none
	one n: Node | n.next = none
	no n: Node | n.next = none and n.prev = none
}

//make sure the list is long enough
fact FiveNodes{
	some n: Node | n.index >= 5
}

//try to find a sorted list 
pred Sorted[n: Node]{
	all n: Node | n.next != none => n.value <= n.next.value
}

run Sorted for 10
