
open util/boolean

//==============Fibonacci==============
some sig Fibonacci{
	x:1,
	y:1,
	result:Int,
	i:Int
}

fact FibonacciFact {
}

pred fibonacciCheck[z:Int]{
	some n: Fibonacci| not (((z) > (2)) => (((((((1) <= (z)) and ((1) > (0))) and (((1) = (n.x)) or ((1) = (n.y)))) and ((((((n.i) <= (z)) and ((n.i) > (0))) and (((n.result) = (n.x)) or ((n.result) = (n.y)))) and (not ((n.i) >= (z)))) => ((((n.x) < (n.y)) => ((((plus[n.i][1]) <= (z)) and ((plus[n.i][1]) > (0))) and (((plus[n.x][n.y]) = (plus[n.x][n.y])) or ((plus[n.x][n.y]) = (n.y))))) and (((not ((n.x) < (n.y))) and (1=1)) => ((((plus[n.i][1]) <= (z)) and ((plus[n.i][1]) > (0))) and (((plus[n.x][n.y]) = (n.x)) or ((plus[n.x][n.y]) = (plus[n.x][n.y])))))))) and ((((((n.i) <= (z)) and ((n.i) > (0))) and (((n.result) = (n.x)) or ((n.result) = (n.y)))) and ((n.i) >= (z))) => (((((n.x) > (n.y)) => ((n.result) = (n.x))) and (((n.y) > (n.x)) => ((n.result) = (n.y)))) and ((((n.x) > (0)) and ((n.y) > (0))) and ((n.i) = (z)))))) and (((((((n.i) <= (z)) and ((n.i) > (0))) and (((n.result) = (n.x)) or ((n.result) = (n.y)))) and (not ((n.i) >= (z)))) => ((((n.x) < (n.y)) => ((minus[z][plus[n.i][1]]) >= (0))) and (((not ((n.x) < (n.y))) and (1=1)) => ((minus[z][plus[n.i][1]]) >= (0))))) and ((((((n.i) <= (z)) and ((n.i) > (0))) and (((n.result) = (n.x)) or ((n.result) = (n.y)))) and (not ((n.i) >= (z)))) => ((((n.x) < (n.y)) => ((minus[z][plus[n.i][1]]) < (minus[z][n.i]))) and (((not ((n.x) < (n.y))) and (1=1)) => ((minus[z][plus[n.i][1]]) < (minus[z][n.i]))))))))
}

//The post-condition/class-invariant/loop-correctness of function (fibonacci) is only valid when this is inconsistent.
run {
	some z: Int| fibonacciCheck[z]
} for 8 but 8 int, 2 Bool, exactly 32 String