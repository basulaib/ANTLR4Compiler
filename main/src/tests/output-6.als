
open util/boolean
open util/sequniv

//==============Course==============
some sig Course{
	name:String,
	department:String,
	instructor:String,
	code:Int,
	studentsEnrolled:seq String,
	assignmentAverages:seq Int
}

fact CourseFact {
	all n: Course| (n.code) > (0)
	all n: Course| (n.name) != (none)
	all n: Course| (n.department) != (none)
	all n: Course| (n.instructor) != (none)
}

pred removeStudentCheck[index:Int]{
	some n: Course| not (((index) > (0)) => ((none) != (none)))
}

//The post-condition/class-invariant/loop-correctness of function (removeStudent) is only valid when this is inconsistent.
run {
	some index: Int| removeStudentCheck[index]
} for 8 but 8 int, 2 Bool, exactly 32 String