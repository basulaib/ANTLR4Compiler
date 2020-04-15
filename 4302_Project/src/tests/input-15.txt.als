
open util/boolean

//==============LoopTest==============
some sig LoopTest{
	x:Int,
	z:Int
}

fact LoopTestFact {
}

pred decreaseCheck{
	some n: LoopTest| not (((((((5) > (1)) and ((5) > (1))) and ((1) = (1))) and ((((((n.x) > (n.z)) and ((n.x) > (1))) and ((n.z) = (1))) and (not ((n.x) = (2)))) => ((((minus[n.x][1]) > (n.z)) and ((minus[n.x][1]) > (1))) and ((n.z) = (1))))) and ((((((n.x) > (n.z)) and ((n.x) > (1))) and ((n.z) = (1))) and ((n.x) = (2))) => (1=1))) and (((((((n.x) > (n.z)) and ((n.x) > (1))) and ((n.z) = (1))) and (not ((n.x) = (2)))) => ((minus[n.x][1]) >= (0))) and ((((((n.x) > (n.z)) and ((n.x) > (1))) and ((n.z) = (1))) and (not ((n.x) = (2)))) => ((minus[n.x][1]) < (n.x)))))
}

//The post-condition/class-invariant/loop-correctness of function (decrease) is only valid when this is inconsistent.
run decreaseCheck for 8 but 8 int, 2 Bool, exactly 32 String