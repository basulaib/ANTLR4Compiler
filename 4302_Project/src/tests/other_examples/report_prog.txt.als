
open util/boolean
open util/sequniv

//==============Account==============
some sig Account{
	old_amount:Int,
	amount:0,
	tmp:Int,
	name:String,
	student:False,
	recentTransactions:seq Int
}

fact AccountFact {
	all n: Account| (n.amount) >= (0)
}

pred increaseCheck[x:Int, y:Int]{
	some n: Account| not (((((n.amount) > (0)) and ((x) > (0))) and ((y) > (0))) => ((((((1) > (0)) and ((5) >= (5))) and (((((n.tmp) > (0)) and ((n.amount) >= (n.old_amount))) and (not ((n.tmp) = (5)))) => (((plus[n.tmp][1]) > (0)) and ((mul[n.amount][2]) >= (n.amount))))) and (((((n.tmp) > (0)) and ((n.amount) >= (n.old_amount))) and ((n.tmp) = (5))) => (((((n.amount) > (50)) => ((((minus[n.amount][50]) = (4)) => (((minus[n.amount][50]) > (0)) and ((minus[n.amount][50]) = (plus[plus[n.old_amount][x]][y])))) and (((not ((minus[n.amount][50]) = (4))) and (1=1)) => (((minus[n.amount][50]) > (0)) and ((minus[n.amount][50]) = (plus[plus[n.old_amount][x]][y])))))) and (((not ((n.amount) > (50))) and ((n.amount) <= (50))) => ((((plus[n.amount][50]) = (4)) => (((plus[n.amount][50]) > (0)) and ((plus[n.amount][50]) = (plus[plus[n.old_amount][x]][y])))) and (((not ((plus[n.amount][50]) = (4))) and (1=1)) => (((plus[n.amount][50]) > (0)) and ((plus[n.amount][50]) = (plus[plus[n.old_amount][x]][y]))))))) and ((((not ((n.amount) > (50))) and (not ((n.amount) <= (50)))) and (1=1)) => ((((minus[n.amount][1]) = (4)) => (((minus[n.amount][1]) > (0)) and ((minus[n.amount][1]) = (plus[plus[n.old_amount][x]][y])))) and (((not ((minus[n.amount][1]) = (4))) and (1=1)) => (((minus[n.amount][1]) > (0)) and ((minus[n.amount][1]) = (plus[plus[n.old_amount][x]][y]))))))))) and ((((((n.tmp) > (0)) and ((n.amount) >= (n.old_amount))) and (not ((n.tmp) = (5)))) => ((minus[5][plus[n.tmp][1]]) >= (0))) and (((((n.tmp) > (0)) and ((n.amount) >= (n.old_amount))) and (not ((n.tmp) = (5)))) => ((minus[5][plus[n.tmp][1]]) < (minus[5][n.tmp]))))))
}

//The post-condition/class-invariant/loop-correctness of function (increase) is only valid when this is inconsistent.
run {
	some x: Int| some y: Int| increaseCheck[x, y]
} for 8 but 8 int, 2 Bool, exactly 32 String

pred increaseAndCheckCheck{
	some n: Account| not (((n.amount) > (0)) => ((((20) > (0)) and ((20) > (0))) and (((n.amount) = (plus[plus[n.old_amount][20]][20])) => (((n.amount) > (0)) and ((n.amount) >= (0))))))
}

//The post-condition/class-invariant/loop-correctness of function (increaseAndCheck) is only valid when this is inconsistent.
run increaseAndCheckCheck for 8 but 8 int, 2 Bool, exactly 32 String