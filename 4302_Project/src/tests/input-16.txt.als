
open util/boolean

//==============test==============
some sig test{
	result:Int,
	amount:5
}

fact testFact {
}

pred negateCheck[y:Int]{
	some n: test| not ((((n.amount) = (5)) and ((y) > (0))) => (((((n.amount) = (3)) => (((n.amount) = (5)) and ((4) = (7)))) and (((not ((n.amount) = (3))) and ((n.amount) = (5))) => (((n.amount) = (5)) and ((7) = (7))))) and ((((not ((n.amount) = (3))) and (not ((n.amount) = (5)))) and (1=1)) => (((n.amount) = (5)) and ((5) = (7))))))
}

//The post-condition/class-invariant/loop-correctness of function (negate) is only valid when this is inconsistent.
run {
	some y: Int| negateCheck[y]
} for 8 but 8 int, 2 Bool, exactly 32 String