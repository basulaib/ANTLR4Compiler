
open util/boolean
open util/sequniv

//==============test==============
some sig test{
	result:Bool
}

fact testFact {
}

pred negateCheck[x:Bool]{
	some n: test| not ((((n.result = True) <=> ((1=1) or (1=0))) and ((x = True) <=> ((1=1) or (1=0)))) => (((not (x = True)) <=> ((1=1) or (1=0))) and ((not (x = True)) <=> not (x = True))))
}

//The post-condition/class-invariant/loop-correctness of function (negate) is only valid when this is inconsistent.
run {
	some x: Bool| negateCheck[x]
} for 8 but 8 int, 2 Bool, exactly 32 String