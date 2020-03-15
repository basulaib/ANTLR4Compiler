module Garage

sig Garage {
	v: set Vehicle
} {#v <= 3}

sig Vehicle {
	plateNum: Int
}{plateNum > 1000}

sig Car extends Vehicle {
	make: String
}

sig Van extends Vehicle {
	make: String
}

fact carOrVan {
	//vehicle is either a car or a van
	Car + Van = Vehicle
}


assert UniquePlateNum {
	no j,v:Vehicle | j.plateNum = v.plateNum 	
}

check UniquePlateNum

pred Add(g,t:Garage, z:Vehicle) {
	//garage not full and vehicle not currently stored in a garage
	#g.v < 3
	#t.v < 3
	(z not in t.v)
	g.v = t.v + z	
}

run Add
