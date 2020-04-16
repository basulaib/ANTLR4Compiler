
open util/boolean

//==============Student==============
some sig Student{
	name:"Jackie",
	id:Int,
	course:"EECS 4302",
	gpa:9,
	age:999,
	year:4,
	iq:750
}

fact StudentFact {
	all n: Student| (n.gpa) >= (5)
	all n: Student| (n.year) >= (2)
	all n: Student| (n.age) >= (100)
	all n: Student| (n.id) >= (0)
	all n: Student| (n.name) != (none)
	all n: Student| (n.course) != (none)
}

pred compareStudentGPACheck[otherGPA:Int, otherIQ:Int]{
	some n: Student| not (((otherGPA) > (0)) => (1=1))
}

//The post-condition/class-invariant/loop-correctness of function (compareStudentGPA) is only valid when this is inconsistent.
run {
	some otherGPA: Int| some otherIQ: Int| compareStudentGPACheck[otherGPA, otherIQ]
} for 8 but 8 int, 2 Bool, exactly 32 String

//==============Professor==============
some sig Professor{
	name:"Trudeau",
	course:"EECS 4302",
	pay:95000,
	tenure:False,
	exp_years:1
}

fact ProfessorFact {
	all n: Professor| (n.pay) > (50000)
	all n: Professor| (n.tenure = True) <=> (1=0)
}

pred checkTenureTrackCheck{
	some n: Professor| not (((((n.pay) > (50000)) and ((n.exp_years) >= (1))) and (((n.exp_years) > (0)) and ((n.tenure = True) <=> (1=0)))) => ((((n.exp_years) > (10)) => (((n.pay) > (50000)) and ((n.exp_years) >= (1)))) and (((not ((n.exp_years) > (10))) and (1=1)) => (((n.pay) > (50000)) and ((n.exp_years) >= (1))))))
}

//The post-condition/class-invariant/loop-correctness of function (checkTenureTrack) is only valid when this is inconsistent.
run checkTenureTrackCheck for 8 but 8 int, 2 Bool, exactly 32 String

//==============Course==============
some sig Course{
	name:String,
	code:Int,
	fee:Int,
	semester:String,
	year:Int,
	instructor:String,
	department:String,
	lecture_room:String
}

fact CourseFact {
	all n: Course| (n.name) != (none)
	all n: Course| (n.code) > (0)
	all n: Course| (n.fee) > (0)
	all n: Course| (((((n.semester) = ("F")) or ((n.semester) = ("W"))) or ((n.semester) = ("S1"))) or ((n.semester) = ("S2"))) or ((n.semester) = ("SU"))
	all n: Course| ((n.year) > (0)) and ((n.year) < (5))
}