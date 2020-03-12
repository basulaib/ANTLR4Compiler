module VarDeclare

sig Variable {
	v: Int,
	w: Int
}

/*
fact alwaysPositive {
	all v:Int | 	v > 0
}
*/

assert s {
	all q: Variable | (q.w > 5 && 5 > q.v) => q.w > q.v
}

check s

/*
pred test {
	one q: Variable | (q.w > 5 && 5 > q.v) => q.w > q.v
}

run test for 5 Variable
*/
