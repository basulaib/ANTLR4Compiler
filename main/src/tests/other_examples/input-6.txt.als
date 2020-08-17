
open util/boolean

//==============test==============
some sig test{
	result:Bool
}

fact testFact {
}

pred disjuncCheck[x:Int, y:Int, z:Int]{
	some n: test| not ((((((n.result = True) <=> ((1=1) or (n.result = True))) <=> (1=0)) and ((x) >= (0))) and (((y) >= (0)) and ((z) >= (0)))) => (((((x) = (y)) and ((x) = (z))) => ((((1=1) <=> ((1=1) or (1=1))) <=> (1=0)) and ((1=1) <=> (((x) = (y)) and ((x) = (z)))))) and (((not (((x) = (y)) and ((x) = (z)))) and (1=1)) => ((((1=0) <=> ((1=1) or (1=0))) <=> (1=0)) and ((1=0) <=> (((x) = (y)) and ((x) = (z))))))))
}

//The post-condition/class-invariant/loop-correctness of function (disjunc) is only valid when this is inconsistent.
run {
	some x: Int| some y: Int| some z: Int| disjuncCheck[x, y, z]
} for 8 but 8 int, 2 Bool, exactly 32 String