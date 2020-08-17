
open util/boolean

//==============test==============
some sig test{
	result:Bool,
	bar:Bool
}

fact testFact {
	all n: test| (n.bar = True) <=> (1=1)
}

pred impCheck[x:Bool, y:Bool]{
	some n: test| not (((((n.result = True) <=> (n.bar = True)) and (((x = True) <=> (1=1)) or (1=0))) and ((y = True) <=> ((1=1) or (1=0)))) => (((((y = True) <=> ((1=1) and (x = True))) <=> (1=1)) => ((((x = True) => ((y = True) and (n.bar = True))) <=> (n.bar = True)) and ((((x = True) => ((y = True) and (n.bar = True))) <=> ((1=1) or (x = True))) <=> (1=0)))) and (((not (((y = True) <=> ((1=1) and (x = True))) <=> (1=1))) and (1=1)) => (((((x = True) or (y = True)) => ((y = True) or (x = True))) <=> (n.bar = True)) and (((((x = True) or (y = True)) => ((y = True) or (x = True))) <=> ((1=1) or (x = True))) <=> (1=0))))))
}

//The post-condition/class-invariant/loop-correctness of function (imp) is only valid when this is inconsistent.
run {
	some x: Bool| some y: Bool| impCheck[x, y]
} for 8 but 8 int, 2 Bool, exactly 32 String