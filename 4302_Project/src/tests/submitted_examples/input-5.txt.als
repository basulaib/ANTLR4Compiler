
open util/boolean
open util/sequniv

//==============School==============
some sig School{
	grade:String
}

fact SchoolFact {
}

pred getGradeLevelCheck[age:Int]{
	some n: School| not ((((age) > (5)) and ((age) < (18))) => (((((((age) = (6)) => (("grade 1") != ("none"))) and (((not ((age) = (6))) and ((age) = (7))) => (("grade 2") != ("none")))) and ((((not ((age) = (6))) and (not ((age) = (7)))) and ((age) = (8))) => (("grade 3") != ("none")))) and ((((((not ((age) = (6))) and (not ((age) = (7)))) and ((not ((age) = (8))) and ((age) = (9)))) => (("grade 4") != ("none"))) and (((((not ((age) = (6))) and (not ((age) = (7)))) and (not ((age) = (8)))) and ((not ((age) = (9))) and ((age) = (10)))) => (("grade 5") != ("none")))) and (((((not ((age) = (6))) and (not ((age) = (7)))) and (not ((age) = (8)))) and (((not ((age) = (9))) and (not ((age) = (10)))) and ((age) = (11)))) => (("grade 6") != ("none"))))) and ((((((((not ((age) = (6))) and (not ((age) = (7)))) and ((not ((age) = (8))) and (not ((age) = (9))))) and (((not ((age) = (10))) and (not ((age) = (11)))) and ((age) = (12)))) => (("grade 7") != ("none"))) and (((((not ((age) = (6))) and (not ((age) = (7)))) and ((not ((age) = (8))) and (not ((age) = (9))))) and (((not ((age) = (10))) and (not ((age) = (11)))) and ((not ((age) = (12))) and ((age) = (13))))) => (("grade 8") != ("none")))) and ((((((not ((age) = (6))) and (not ((age) = (7)))) and (not ((age) = (8)))) and ((not ((age) = (9))) and (not ((age) = (10))))) and (((not ((age) = (11))) and (not ((age) = (12)))) and ((not ((age) = (13))) and ((age) = (14))))) => (("grade 9") != ("none")))) and ((((((((not ((age) = (6))) and (not ((age) = (7)))) and (not ((age) = (8)))) and ((not ((age) = (9))) and (not ((age) = (10))))) and ((((not ((age) = (11))) and (not ((age) = (12)))) and (not ((age) = (13)))) and ((not ((age) = (14))) and ((age) = (15))))) => (("grade 10") != ("none"))) and ((((((not ((age) = (6))) and (not ((age) = (7)))) and (not ((age) = (8)))) and (((not ((age) = (9))) and (not ((age) = (10)))) and (not ((age) = (11))))) and ((((not ((age) = (12))) and (not ((age) = (13)))) and (not ((age) = (14)))) and ((not ((age) = (15))) and ((age) = (16))))) => (("grade 11") != ("none")))) and ((((((not ((age) = (6))) and (not ((age) = (7)))) and (not ((age) = (8)))) and (((not ((age) = (9))) and (not ((age) = (10)))) and (not ((age) = (11))))) and ((((not ((age) = (12))) and (not ((age) = (13)))) and (not ((age) = (14)))) and (((not ((age) = (15))) and (not ((age) = (16)))) and (1=1)))) => (("grade 12") != ("none")))))))
}

//The post-condition/class-invariant/loop-correctness of function (getGradeLevel) is only valid when this is inconsistent.
run {
	some age: Int| getGradeLevelCheck[age]
} for 8 but 8 int, 2 Bool, exactly 32 String