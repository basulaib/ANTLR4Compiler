
open util/boolean

//==============test==============
some sig test{
	result:Bool
}

fact testFact {
}

pred smallEqualCheck[x:Int, y:Int]{
	some n: test| not (((((n.result = True) <=> ((1=1) or (1=0))) and ((x) > (0))) and ((y) > (0))) => ((((x) <= (y)) => (((1=1) <=> ((1=1) or (1=0))) and ((1=1) <=> ((x) <= (y))))) and (((not ((x) <= (y))) and (1=1)) => (((1=0) <=> ((1=1) or (1=0))) and ((1=0) <=> ((x) <= (y)))))))
}

//The post-condition/class-invariant/loop-correctness of function (smallEqual) is only valid when this is inconsistent.
run {
	some x: Int| some y: Int| smallEqualCheck[x, y]
} for 8 but 8 int, 2 Bool, exactly 32 String