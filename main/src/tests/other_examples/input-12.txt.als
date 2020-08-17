
open util/boolean

//==============test==============
some sig test{
	result:String
}

fact testFact {
}

pred smallerCheck[x:Int, y:Int]{
	some n: test| not (((((((n.result) = ("x")) or ((n.result) = ("y"))) or ((n.result) = ("equal"))) and ((x) > (0))) and ((y) > (0))) => (((((x) < (y)) => ((((("x") = ("x")) or (("x") = ("y"))) or (("x") = ("equal"))) and (((("x") = ("x")) or (("x") = ("y"))) or (("x") = ("equal"))))) and (((not ((x) < (y))) and ((x) > (y))) => ((((("y") = ("x")) or (("y") = ("y"))) or (("y") = ("equal"))) and (((("y") = ("x")) or (("y") = ("y"))) or (("y") = ("equal")))))) and ((((not ((x) < (y))) and (not ((x) > (y)))) and (1=1)) => ((((("equal") = ("x")) or (("equal") = ("y"))) or (("equal") = ("equal"))) and (((("equal") = ("x")) or (("equal") = ("y"))) or (("equal") = ("equal")))))))
}

//The post-condition/class-invariant/loop-correctness of function (smaller) is only valid when this is inconsistent.
run {
	some x: Int| some y: Int| smallerCheck[x, y]
} for 8 but 8 int, 2 Bool, exactly 32 String