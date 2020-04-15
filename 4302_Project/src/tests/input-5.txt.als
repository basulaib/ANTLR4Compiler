
open util/boolean

//==============test==============
some sig test{
	result:Bool
}

fact testFact {
}

pred disjunctionCheck[x:Bool, y:Bool]{
	some n: test| not (((((n.result = True) <=> ((1=1) or (1=0))) and ((x = True) <=> ((1=1) or (1=0)))) and ((y = True) <=> ((1=1) or (1=0)))) => ((((x = True) or (y = True)) <=> ((1=1) or (1=0))) and (((x = True) or (y = True)) <=> ((x = True) or (y = True)))))
}

//The post-condition/class-invariant/loop-correctness of function (disjunction) is only valid when this is inconsistent.
run {
	some x: Bool| some y: Bool| disjunctionCheck[x, y]
} for 8 but 8 int, 2 Bool, exactly 32 String