
open util/boolean

//==============Account==============
some sig Account{
	balance:0,
	id:Int,
	name:String,
	y:Int
}

fact AccountFact {
	all n: Account| (n.balance) > (0)
	all n: Account| (n.name) != (none)
}

pred getBalanceCheck{
	some n: Account| not ((((n.balance) > (0)) and ((n.id) > (0))) => ((((n.balance) > (0)) and ((n.id) > (0))) and ((n.balance) = (n.balance))))
}

//The post-condition/class-invariant/loop-correctness of function (getBalance) is only valid when this is inconsistent.
run getBalanceCheck for 8 but 8 int, 2 Bool, exactly 32 String

//==============Bank==============
some sig Bank{
	num_of_clients:Int,
	account_names:String,
	account_ids:String
}

fact BankFact {
	all n: Bank| (n.num_of_clients) >= (0)
}