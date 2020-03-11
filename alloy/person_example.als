module Person

sig Person {
	name: String,
	friends: set Person,
	age: Int,
	birthday: String // e.g. yyyy-mm-dd
}

fact {
	all p,q: Person | p in q.friends => q in p.friends
	all p,q: Person | p.birthday = q.birthday => p.age = q.age
	all p,q: Person | (p.name = q.name) && (p.age = q.age) && (p.friends = q.friends) && (p.birthday = q.birthday) => p = q
}

pred addFriend(p,r,q: Person) {
	!(q in p.friends)
	r.friends = p.friends + q
}

pred removeFriend(p,r,q: Person) {
	q in p.friends 
	r.friends = p.friends - q
}

/*
fun searchFriend(p,q: Person): Person {
	
}
check page 35 of text */

assert notFriends {
	all p,q: Person | p !in q.friends => q !in p.friends
}

assert notSamePerson {
	all p,q: Person | p.name != q.name => p != q
}

/*
run addFriend
run removeFriend
*/
check notFriends
check notSamePerson
