
open util/boolean

//==============test==============
some sig test{
	result:Int,
	a:5,
	amount:Int
}

fact testFact {
	all n: test| (n.amount) > (0)
}

pred multCheck[x:Int, y:Int]{
	some n: test| not (((((n.result) >= (0)) and ((x) >= (0))) and ((y) >= (0))) => (((mul[x][y]) >= (0)) and ((mul[x][y]) = (mul[x][y]))))
}

//The post-condition/class-invariant/loop-correctness of function (mult) is only valid when this is inconsistent.
run {
	some x: Int| some y: Int| multCheck[x, y]
} for 8 but 8 int, 2 Bool, exactly 32 String