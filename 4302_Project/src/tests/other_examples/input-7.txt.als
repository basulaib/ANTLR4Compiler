
open util/boolean

//==============test==============
some sig test{
	result:Int
}

fact testFact {
}

pred divCheck[x:Int, y:Int]{
	some n: test| not (((((n.result) >= (0)) and ((x) >= (0))) and ((y) > (0))) => (((div[x][y]) >= (0)) and ((div[x][y]) = (div[x][y]))))
}

//The post-condition/class-invariant/loop-correctness of function (div) is only valid when this is inconsistent.
run {
	some x: Int| some y: Int| divCheck[x, y]
} for 8 but 8 int, 2 Bool, exactly 32 String