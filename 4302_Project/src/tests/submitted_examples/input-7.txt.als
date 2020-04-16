
open util/boolean
open util/sequniv

//==============FuncCallTest==============
some sig FuncCallTest{
	x:Int,
	z:Int
}

fact FuncCallTestFact {
}

pred decreaseCheck{
	some n: FuncCallTest| not ((1=1) and (((n.x) = (minus[n.z][1])) => ((minus[n.z][1]) = (n.x))))
}

//The post-condition/class-invariant/loop-correctness of function (decrease) is only valid when this is inconsistent.
run decreaseCheck for 8 but 8 int, 2 Bool, exactly 32 String

pred realDecreaseCheck{
	some n: FuncCallTest| not ((minus[n.z][1]) = (minus[n.z][1]))
}

//The post-condition/class-invariant/loop-correctness of function (realDecrease) is only valid when this is inconsistent.
run realDecreaseCheck for 8 but 8 int, 2 Bool, exactly 32 String

pred recursionTestCheck{
	some n: FuncCallTest| not ((1=1) and ((1=1) => (1=1)))
}

//The post-condition/class-invariant/loop-correctness of function (recursionTest) is only valid when this is inconsistent.
run recursionTestCheck for 8 but 8 int, 2 Bool, exactly 32 String