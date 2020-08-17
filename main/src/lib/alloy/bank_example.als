module Bank

sig Account {
	id: Int,
	balance: Int,
}
 
/*{
	n.balance >= 0
	n.id > 0
}*/

one sig Bank {
	accounts: set Account,
}

fact positive {
	all n: Account | n.balance >= 0 and n.id > 0
	all b: Bank, n: Account | n in b.accounts
//	all b: Bank | one b.accounts
}
/*
assert t {
	all p,q: Account | p.id = q.id
}

check t
*/
/*
fact noSameAccounts {
	no all p,q: Account | p.id = q.id
}
*/

pred deposit(p,p': Account, n: Int) {
	n > 0
	p'.balance = p.balance + n
	p'.id = p.id
}

run deposit

pred withdraw(b: Bank, p,q: Account, n: Int) {
	n > 0
	(p.balance - n) > 0
	(p in Bank.accounts)
	(q in Bank.accounts)
//	(p.id = q.id)
	q.balance = p.balance - n
}

run withdraw

fun getBalance(p: Account): Int {
	p.balance
}
