
open util/boolean

//==============test==============
some sig test{
	result:Int
}

fact testFact {
}

pred addCheck[x:Int, y:Int]{
	some n: test| not (((((n.result) >= (0)) and ((x) >= (0))) and ((y) >= (0))) => (((plus[x][y]) >= (0)) and ((plus[x][y]) = (plus[x][y]))))
}

//The post-condition/class-invariant/loop-correctness of function (add) is only valid when this is inconsistent.
run {
	some x: Int| some y: Int| addCheck[x, y]
} for 8 but 8 int, 2 Bool, exactly 32 String