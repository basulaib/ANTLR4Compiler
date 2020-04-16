
open util/boolean
open util/sequniv

//==============Stock==============
some sig Stock{
	mutualFund:seq String,
	mutualAmount:seq Int,
	name:String,
	size:5,
	balance:Int,
	result:Int,
	fees:50,
	commission:150
}

fact StockFact {
}

pred depositCheck[amount:Int]{
	some n: Stock| not (((amount) > (0)) => (1=1))
}

//The post-condition/class-invariant/loop-correctness of function (deposit) is only valid when this is inconsistent.
run {
	some amount: Int| depositCheck[amount]
} for 8 but 8 int, 2 Bool, exactly 32 String

pred withdrawCheck[amount:Int]{
	some n: Stock| not ((((amount) > (0)) and ((plus[amount][n.fees]) <= (n.balance))) => (1=1))
}

//The post-condition/class-invariant/loop-correctness of function (withdraw) is only valid when this is inconsistent.
run {
	some amount: Int| withdrawCheck[amount]
} for 8 but 8 int, 2 Bool, exactly 32 String

pred investCheck[index:Int, amount:Int]{
	some n: Stock| not ((((index) < (n.size)) and ((plus[amount][n.commission]) <= (n.balance))) => ((((((index) = (0)) => ((minus[n.balance][plus[amount][n.commission]]) = (minus[minus[n.balance][plus[amount][n.commission]]][plus[amount][n.commission]]))) and (((not ((index) = (0))) and ((index) = (1))) => ((minus[n.balance][plus[amount][n.commission]]) = (minus[minus[n.balance][plus[amount][n.commission]]][plus[amount][n.commission]])))) and ((((not ((index) = (0))) and (not ((index) = (1)))) and ((index) = (2))) => ((minus[n.balance][plus[amount][n.commission]]) = (minus[minus[n.balance][plus[amount][n.commission]]][plus[amount][n.commission]])))) and ((((((not ((index) = (0))) and (not ((index) = (1)))) and ((not ((index) = (2))) and ((index) = (3)))) => ((minus[n.balance][plus[amount][n.commission]]) = (minus[minus[n.balance][plus[amount][n.commission]]][plus[amount][n.commission]]))) and (((((not ((index) = (0))) and (not ((index) = (1)))) and (not ((index) = (2)))) and ((not ((index) = (3))) and ((index) = (4)))) => ((minus[n.balance][plus[amount][n.commission]]) = (minus[minus[n.balance][plus[amount][n.commission]]][plus[amount][n.commission]])))) and (((((not ((index) = (0))) and (not ((index) = (1)))) and (not ((index) = (2)))) and (((not ((index) = (3))) and (not ((index) = (4)))) and (1=1))) => ((n.balance) = (minus[n.balance][plus[amount][n.commission]]))))))
}

//The post-condition/class-invariant/loop-correctness of function (invest) is only valid when this is inconsistent.
run {
	some index: Int| some amount: Int| investCheck[index, amount]
} for 8 but 8 int, 2 Bool, exactly 32 String

pred getMFCheck[index:Int]{
	some n: Stock| not (((index) < (n.size)) => ((n.mutualAmount[index]) = (n.mutualAmount[index])))
}

//The post-condition/class-invariant/loop-correctness of function (getMF) is only valid when this is inconsistent.
run {
	some index: Int| getMFCheck[index]
} for 8 but 8 int, 2 Bool, exactly 32 String