
open util/boolean
open util/sequniv

//==============Sorting==============
some sig Sorting{
	a:6,
	b:1,
	c:4,
	d:8,
	tmp:Int
}

fact SortingFact {
}

pred sortCheck[x:Int]{
	some n: Sorting| not ((((x) = (1)) or ((x) = (0))) => ((((x) = (1)) => ((((n.a) > (n.b)) => ((((n.c) > (n.d)) => ((((n.b) > (n.d)) => ((((n.a) > (n.c)) => ((((n.c) > (n.b)) => ((((x) = (1)) => ((((n.d) < (n.b)) and ((n.b) < (n.c))) and ((n.c) < (n.a)))) and (((x) = (0)) => ((((n.d) > (n.b)) and ((n.b) > (n.c))) and ((n.c) > (n.a)))))) and (((not ((n.c) > (n.b))) and (1=1)) => ((((x) = (1)) => ((((n.d) < (n.c)) and ((n.c) < (n.b))) and ((n.b) < (n.a)))) and (((x) = (0)) => ((((n.d) > (n.c)) and ((n.c) > (n.b))) and ((n.b) > (n.a)))))))) and (((not ((n.a) > (n.c))) and (1=1)) => ((((n.a) > (n.b)) => ((((x) = (1)) => ((((n.d) < (n.b)) and ((n.b) < (n.a))) and ((n.a) < (n.c)))) and (((x) = (0)) => ((((n.d) > (n.b)) and ((n.b) > (n.a))) and ((n.a) > (n.c)))))) and (((not ((n.a) > (n.b))) and (1=1)) => ((((x) = (1)) => ((((n.d) < (n.a)) and ((n.a) < (n.b))) and ((n.b) < (n.c)))) and (((x) = (0)) => ((((n.d) > (n.a)) and ((n.a) > (n.b))) and ((n.b) > (n.c)))))))))) and (((not ((n.b) > (n.d))) and (1=1)) => ((((n.a) > (n.c)) => ((((n.c) > (n.d)) => ((((x) = (1)) => ((((n.b) < (n.d)) and ((n.d) < (n.c))) and ((n.c) < (n.a)))) and (((x) = (0)) => ((((n.b) > (n.d)) and ((n.d) > (n.c))) and ((n.c) > (n.a)))))) and (((not ((n.c) > (n.d))) and (1=1)) => ((((x) = (1)) => ((((n.b) < (n.c)) and ((n.c) < (n.d))) and ((n.d) < (n.a)))) and (((x) = (0)) => ((((n.b) > (n.c)) and ((n.c) > (n.d))) and ((n.d) > (n.a)))))))) and (((not ((n.a) > (n.c))) and (1=1)) => ((((n.a) > (n.d)) => ((((x) = (1)) => ((((n.b) < (n.d)) and ((n.d) < (n.a))) and ((n.a) < (n.c)))) and (((x) = (0)) => ((((n.b) > (n.d)) and ((n.d) > (n.a))) and ((n.a) > (n.c)))))) and (((not ((n.a) > (n.d))) and (1=1)) => ((((x) = (1)) => ((((n.b) < (n.a)) and ((n.a) < (n.d))) and ((n.d) < (n.c)))) and (((x) = (0)) => ((((n.b) > (n.a)) and ((n.a) > (n.d))) and ((n.d) > (n.c)))))))))))) and (((not ((n.c) > (n.d))) and (1=1)) => ((((n.b) > (n.c)) => ((((n.a) > (n.d)) => ((((n.d) > (n.b)) => ((((x) = (1)) => ((((n.c) < (n.b)) and ((n.b) < (n.d))) and ((n.d) < (n.a)))) and (((x) = (0)) => ((((n.c) > (n.b)) and ((n.b) > (n.d))) and ((n.d) > (n.a)))))) and (((not ((n.d) > (n.b))) and (1=1)) => ((((x) = (1)) => ((((n.c) < (n.d)) and ((n.d) < (n.b))) and ((n.b) < (n.a)))) and (((x) = (0)) => ((((n.c) > (n.d)) and ((n.d) > (n.b))) and ((n.b) > (n.a)))))))) and (((not ((n.a) > (n.d))) and (1=1)) => ((((n.a) > (n.b)) => ((((x) = (1)) => ((((n.c) < (n.b)) and ((n.b) < (n.a))) and ((n.a) < (n.d)))) and (((x) = (0)) => ((((n.c) > (n.b)) and ((n.b) > (n.a))) and ((n.a) > (n.d)))))) and (((not ((n.a) > (n.b))) and (1=1)) => ((((x) = (1)) => ((((n.c) < (n.a)) and ((n.a) < (n.b))) and ((n.b) < (n.d)))) and (((x) = (0)) => ((((n.c) > (n.a)) and ((n.a) > (n.b))) and ((n.b) > (n.d)))))))))) and (((not ((n.b) > (n.c))) and (1=1)) => ((((n.a) > (n.d)) => ((((n.d) > (n.c)) => ((((x) = (1)) => ((((n.b) < (n.c)) and ((n.c) < (n.d))) and ((n.d) < (n.a)))) and (((x) = (0)) => ((((n.b) > (n.c)) and ((n.c) > (n.d))) and ((n.d) > (n.a)))))) and (((not ((n.d) > (n.c))) and (1=1)) => ((((x) = (1)) => ((((n.b) < (n.d)) and ((n.d) < (n.c))) and ((n.c) < (n.a)))) and (((x) = (0)) => ((((n.b) > (n.d)) and ((n.d) > (n.c))) and ((n.c) > (n.a)))))))) and (((not ((n.a) > (n.d))) and (1=1)) => ((((n.a) > (n.c)) => ((((x) = (1)) => ((((n.b) < (n.c)) and ((n.c) < (n.a))) and ((n.a) < (n.d)))) and (((x) = (0)) => ((((n.b) > (n.c)) and ((n.c) > (n.a))) and ((n.a) > (n.d)))))) and (((not ((n.a) > (n.c))) and (1=1)) => ((((x) = (1)) => ((((n.b) < (n.a)) and ((n.a) < (n.c))) and ((n.c) < (n.d)))) and (((x) = (0)) => ((((n.b) > (n.a)) and ((n.a) > (n.c))) and ((n.c) > (n.d)))))))))))))) and (((not ((n.a) > (n.b))) and (1=1)) => ((((n.c) > (n.d)) => ((((n.a) > (n.d)) => ((((n.b) > (n.c)) => ((((n.c) > (n.a)) => ((((x) = (1)) => ((((n.d) < (n.a)) and ((n.a) < (n.c))) and ((n.c) < (n.b)))) and (((x) = (0)) => ((((n.d) > (n.a)) and ((n.a) > (n.c))) and ((n.c) > (n.b)))))) and (((not ((n.c) > (n.a))) and (1=1)) => ((((x) = (1)) => ((((n.d) < (n.c)) and ((n.c) < (n.a))) and ((n.a) < (n.b)))) and (((x) = (0)) => ((((n.d) > (n.c)) and ((n.c) > (n.a))) and ((n.a) > (n.b)))))))) and (((not ((n.b) > (n.c))) and (1=1)) => ((((n.b) > (n.a)) => ((((x) = (1)) => ((((n.d) < (n.a)) and ((n.a) < (n.b))) and ((n.b) < (n.c)))) and (((x) = (0)) => ((((n.d) > (n.a)) and ((n.a) > (n.b))) and ((n.b) > (n.c)))))) and (((not ((n.b) > (n.a))) and (1=1)) => ((((x) = (1)) => ((((n.d) < (n.b)) and ((n.b) < (n.a))) and ((n.a) < (n.c)))) and (((x) = (0)) => ((((n.d) > (n.b)) and ((n.b) > (n.a))) and ((n.a) > (n.c)))))))))) and (((not ((n.a) > (n.d))) and (1=1)) => ((((n.b) > (n.c)) => ((((n.c) > (n.d)) => ((((x) = (1)) => ((((n.a) < (n.d)) and ((n.d) < (n.c))) and ((n.c) < (n.b)))) and (((x) = (0)) => ((((n.a) > (n.d)) and ((n.d) > (n.c))) and ((n.c) > (n.b)))))) and (((not ((n.c) > (n.d))) and (1=1)) => ((((x) = (1)) => ((((n.a) < (n.c)) and ((n.c) < (n.d))) and ((n.d) < (n.b)))) and (((x) = (0)) => ((((n.a) > (n.c)) and ((n.c) > (n.d))) and ((n.d) > (n.b)))))))) and (((not ((n.b) > (n.c))) and (1=1)) => ((((n.b) > (n.d)) => ((((x) = (1)) => ((((n.a) < (n.d)) and ((n.d) < (n.b))) and ((n.b) < (n.c)))) and (((x) = (0)) => ((((n.a) > (n.d)) and ((n.d) > (n.b))) and ((n.b) > (n.c)))))) and (((not ((n.b) > (n.d))) and (1=1)) => ((((x) = (1)) => ((((n.a) < (n.b)) and ((n.b) < (n.d))) and ((n.d) < (n.c)))) and (((x) = (0)) => ((((n.a) > (n.b)) and ((n.b) > (n.d))) and ((n.d) > (n.c)))))))))))) and (((not ((n.c) > (n.d))) and (1=1)) => ((((n.a) > (n.c)) => ((((n.b) > (n.d)) => ((((n.d) > (n.a)) => ((((x) = (1)) => ((((n.c) < (n.a)) and ((n.a) < (n.d))) and ((n.d) < (n.b)))) and (((x) = (0)) => ((((n.c) > (n.a)) and ((n.a) > (n.d))) and ((n.d) > (n.b)))))) and (((not ((n.d) > (n.a))) and (1=1)) => ((((x) = (1)) => ((((n.c) < (n.d)) and ((n.d) < (n.a))) and ((n.a) < (n.b)))) and (((x) = (0)) => ((((n.c) > (n.d)) and ((n.d) > (n.a))) and ((n.a) > (n.b)))))))) and (((not ((n.b) > (n.d))) and (1=1)) => ((((n.b) > (n.a)) => ((((x) = (1)) => ((((n.c) < (n.a)) and ((n.a) < (n.b))) and ((n.b) < (n.d)))) and (((x) = (0)) => ((((n.c) > (n.a)) and ((n.a) > (n.b))) and ((n.b) > (n.d)))))) and (((not ((n.b) > (n.a))) and (1=1)) => ((((x) = (1)) => ((((n.c) < (n.b)) and ((n.b) < (n.a))) and ((n.a) < (n.d)))) and (((x) = (0)) => ((((n.c) > (n.b)) and ((n.b) > (n.a))) and ((n.a) > (n.d)))))))))) and (((not ((n.a) > (n.c))) and (1=1)) => ((((n.b) > (n.d)) => ((((n.d) > (n.c)) => ((((x) = (1)) => ((((n.a) < (n.c)) and ((n.c) < (n.d))) and ((n.d) < (n.b)))) and (((x) = (0)) => ((((n.a) > (n.c)) and ((n.c) > (n.d))) and ((n.d) > (n.b)))))) and (((not ((n.d) > (n.c))) and (1=1)) => ((((x) = (1)) => ((((n.a) < (n.d)) and ((n.d) < (n.c))) and ((n.c) < (n.b)))) and (((x) = (0)) => ((((n.a) > (n.d)) and ((n.d) > (n.c))) and ((n.c) > (n.b)))))))) and (((not ((n.b) > (n.d))) and (1=1)) => ((((n.b) > (n.c)) => ((((x) = (1)) => ((((n.a) < (n.c)) and ((n.c) < (n.b))) and ((n.b) < (n.d)))) and (((x) = (0)) => ((((n.a) > (n.c)) and ((n.c) > (n.b))) and ((n.b) > (n.d)))))) and (((not ((n.b) > (n.c))) and (1=1)) => ((((x) = (1)) => ((((n.a) < (n.b)) and ((n.b) < (n.c))) and ((n.c) < (n.d)))) and (((x) = (0)) => ((((n.a) > (n.b)) and ((n.b) > (n.c))) and ((n.c) > (n.d)))))))))))))))) and (((not ((x) = (1))) and (1=1)) => ((((n.a) < (n.b)) => ((((n.c) < (n.d)) => ((((n.b) < (n.d)) => ((((n.a) < (n.c)) => ((((n.c) < (n.b)) => ((((x) = (1)) => ((((n.d) < (n.b)) and ((n.b) < (n.c))) and ((n.c) < (n.a)))) and (((x) = (0)) => ((((n.d) > (n.b)) and ((n.b) > (n.c))) and ((n.c) > (n.a)))))) and (((not ((n.c) < (n.b))) and (1=1)) => ((((x) = (1)) => ((((n.d) < (n.c)) and ((n.c) < (n.b))) and ((n.b) < (n.a)))) and (((x) = (0)) => ((((n.d) > (n.c)) and ((n.c) > (n.b))) and ((n.b) > (n.a)))))))) and (((not ((n.a) < (n.c))) and (1=1)) => ((((n.a) < (n.b)) => ((((x) = (1)) => ((((n.d) < (n.b)) and ((n.b) < (n.a))) and ((n.a) < (n.c)))) and (((x) = (0)) => ((((n.d) > (n.b)) and ((n.b) > (n.a))) and ((n.a) > (n.c)))))) and (((not ((n.a) < (n.b))) and (1=1)) => ((((x) = (1)) => ((((n.d) < (n.a)) and ((n.a) < (n.b))) and ((n.b) < (n.c)))) and (((x) = (0)) => ((((n.d) > (n.a)) and ((n.a) > (n.b))) and ((n.b) > (n.c)))))))))) and (((not ((n.b) < (n.d))) and (1=1)) => ((((n.a) < (n.c)) => ((((n.c) < (n.d)) => ((((x) = (1)) => ((((n.b) < (n.d)) and ((n.d) < (n.c))) and ((n.c) < (n.a)))) and (((x) = (0)) => ((((n.b) > (n.d)) and ((n.d) > (n.c))) and ((n.c) > (n.a)))))) and (((not ((n.c) < (n.d))) and (1=1)) => ((((x) = (1)) => ((((n.b) < (n.c)) and ((n.c) < (n.d))) and ((n.d) < (n.a)))) and (((x) = (0)) => ((((n.b) > (n.c)) and ((n.c) > (n.d))) and ((n.d) > (n.a)))))))) and (((not ((n.a) < (n.c))) and (1=1)) => ((((n.a) < (n.d)) => ((((x) = (1)) => ((((n.b) < (n.d)) and ((n.d) < (n.a))) and ((n.a) < (n.c)))) and (((x) = (0)) => ((((n.b) > (n.d)) and ((n.d) > (n.a))) and ((n.a) > (n.c)))))) and (((not ((n.a) < (n.d))) and (1=1)) => ((((x) = (1)) => ((((n.b) < (n.a)) and ((n.a) < (n.d))) and ((n.d) < (n.c)))) and (((x) = (0)) => ((((n.b) > (n.a)) and ((n.a) > (n.d))) and ((n.d) > (n.c)))))))))))) and (((not ((n.c) < (n.d))) and (1=1)) => ((((n.b) < (n.c)) => ((((n.a) < (n.d)) => ((((n.d) < (n.b)) => ((((x) = (1)) => ((((n.c) < (n.b)) and ((n.b) < (n.d))) and ((n.d) < (n.a)))) and (((x) = (0)) => ((((n.c) > (n.b)) and ((n.b) > (n.d))) and ((n.d) > (n.a)))))) and (((not ((n.d) < (n.b))) and (1=1)) => ((((x) = (1)) => ((((n.c) < (n.d)) and ((n.d) < (n.b))) and ((n.b) < (n.a)))) and (((x) = (0)) => ((((n.c) > (n.d)) and ((n.d) > (n.b))) and ((n.b) > (n.a)))))))) and (((not ((n.a) < (n.d))) and (1=1)) => ((((n.a) < (n.b)) => ((((x) = (1)) => ((((n.c) < (n.b)) and ((n.b) < (n.a))) and ((n.a) < (n.d)))) and (((x) = (0)) => ((((n.c) > (n.b)) and ((n.b) > (n.a))) and ((n.a) > (n.d)))))) and (((not ((n.a) < (n.b))) and (1=1)) => ((((x) = (1)) => ((((n.c) < (n.a)) and ((n.a) < (n.b))) and ((n.b) < (n.d)))) and (((x) = (0)) => ((((n.c) > (n.a)) and ((n.a) > (n.b))) and ((n.b) > (n.d)))))))))) and (((not ((n.b) < (n.c))) and (1=1)) => ((((n.a) < (n.d)) => ((((n.d) < (n.c)) => ((((x) = (1)) => ((((n.b) < (n.c)) and ((n.c) < (n.d))) and ((n.d) < (n.a)))) and (((x) = (0)) => ((((n.b) > (n.c)) and ((n.c) > (n.d))) and ((n.d) > (n.a)))))) and (((not ((n.d) < (n.c))) and (1=1)) => ((((x) = (1)) => ((((n.b) < (n.d)) and ((n.d) < (n.c))) and ((n.c) < (n.a)))) and (((x) = (0)) => ((((n.b) > (n.d)) and ((n.d) > (n.c))) and ((n.c) > (n.a)))))))) and (((not ((n.a) < (n.d))) and (1=1)) => ((((n.a) < (n.c)) => ((((x) = (1)) => ((((n.b) < (n.c)) and ((n.c) < (n.a))) and ((n.a) < (n.d)))) and (((x) = (0)) => ((((n.b) > (n.c)) and ((n.c) > (n.a))) and ((n.a) > (n.d)))))) and (((not ((n.a) < (n.c))) and (1=1)) => ((((x) = (1)) => ((((n.b) < (n.a)) and ((n.a) < (n.c))) and ((n.c) < (n.d)))) and (((x) = (0)) => ((((n.b) > (n.a)) and ((n.a) > (n.c))) and ((n.c) > (n.d)))))))))))))) and (((not ((n.a) < (n.b))) and (1=1)) => ((((n.c) < (n.d)) => ((((n.a) < (n.d)) => ((((n.b) < (n.c)) => ((((n.c) < (n.a)) => ((((x) = (1)) => ((((n.d) < (n.a)) and ((n.a) < (n.c))) and ((n.c) < (n.b)))) and (((x) = (0)) => ((((n.d) > (n.a)) and ((n.a) > (n.c))) and ((n.c) > (n.b)))))) and (((not ((n.c) < (n.a))) and (1=1)) => ((((x) = (1)) => ((((n.d) < (n.c)) and ((n.c) < (n.a))) and ((n.a) < (n.b)))) and (((x) = (0)) => ((((n.d) > (n.c)) and ((n.c) > (n.a))) and ((n.a) > (n.b)))))))) and (((not ((n.b) < (n.c))) and (1=1)) => ((((n.b) < (n.a)) => ((((x) = (1)) => ((((n.d) < (n.a)) and ((n.a) < (n.b))) and ((n.b) < (n.c)))) and (((x) = (0)) => ((((n.d) > (n.a)) and ((n.a) > (n.b))) and ((n.b) > (n.c)))))) and (((not ((n.b) < (n.a))) and (1=1)) => ((((x) = (1)) => ((((n.d) < (n.b)) and ((n.b) < (n.a))) and ((n.a) < (n.c)))) and (((x) = (0)) => ((((n.d) > (n.b)) and ((n.b) > (n.a))) and ((n.a) > (n.c)))))))))) and (((not ((n.a) < (n.d))) and (1=1)) => ((((n.b) < (n.c)) => ((((n.c) < (n.d)) => ((((x) = (1)) => ((((n.a) < (n.d)) and ((n.d) < (n.c))) and ((n.c) < (n.b)))) and (((x) = (0)) => ((((n.a) > (n.d)) and ((n.d) > (n.c))) and ((n.c) > (n.b)))))) and (((not ((n.c) < (n.d))) and (1=1)) => ((((x) = (1)) => ((((n.a) < (n.c)) and ((n.c) < (n.d))) and ((n.d) < (n.b)))) and (((x) = (0)) => ((((n.a) > (n.c)) and ((n.c) > (n.d))) and ((n.d) > (n.b)))))))) and (((not ((n.b) < (n.c))) and (1=1)) => ((((n.b) < (n.d)) => ((((x) = (1)) => ((((n.a) < (n.d)) and ((n.d) < (n.b))) and ((n.b) < (n.c)))) and (((x) = (0)) => ((((n.a) > (n.d)) and ((n.d) > (n.b))) and ((n.b) > (n.c)))))) and (((not ((n.b) < (n.d))) and (1=1)) => ((((x) = (1)) => ((((n.a) < (n.b)) and ((n.b) < (n.d))) and ((n.d) < (n.c)))) and (((x) = (0)) => ((((n.a) > (n.b)) and ((n.b) > (n.d))) and ((n.d) > (n.c)))))))))))) and (((not ((n.c) < (n.d))) and (1=1)) => ((((n.a) < (n.c)) => ((((n.b) < (n.d)) => ((((n.d) < (n.a)) => ((((x) = (1)) => ((((n.c) < (n.a)) and ((n.a) < (n.d))) and ((n.d) < (n.b)))) and (((x) = (0)) => ((((n.c) > (n.a)) and ((n.a) > (n.d))) and ((n.d) > (n.b)))))) and (((not ((n.d) < (n.a))) and (1=1)) => ((((x) = (1)) => ((((n.c) < (n.d)) and ((n.d) < (n.a))) and ((n.a) < (n.b)))) and (((x) = (0)) => ((((n.c) > (n.d)) and ((n.d) > (n.a))) and ((n.a) > (n.b)))))))) and (((not ((n.b) < (n.d))) and (1=1)) => ((((n.b) < (n.a)) => ((((x) = (1)) => ((((n.c) < (n.a)) and ((n.a) < (n.b))) and ((n.b) < (n.d)))) and (((x) = (0)) => ((((n.c) > (n.a)) and ((n.a) > (n.b))) and ((n.b) > (n.d)))))) and (((not ((n.b) < (n.a))) and (1=1)) => ((((x) = (1)) => ((((n.c) < (n.b)) and ((n.b) < (n.a))) and ((n.a) < (n.d)))) and (((x) = (0)) => ((((n.c) > (n.b)) and ((n.b) > (n.a))) and ((n.a) > (n.d)))))))))) and (((not ((n.a) < (n.c))) and (1=1)) => ((((n.b) < (n.d)) => ((((n.d) < (n.c)) => ((((x) = (1)) => ((((n.a) < (n.c)) and ((n.c) < (n.d))) and ((n.d) < (n.b)))) and (((x) = (0)) => ((((n.a) > (n.c)) and ((n.c) > (n.d))) and ((n.d) > (n.b)))))) and (((not ((n.d) < (n.c))) and (1=1)) => ((((x) = (1)) => ((((n.a) < (n.d)) and ((n.d) < (n.c))) and ((n.c) < (n.b)))) and (((x) = (0)) => ((((n.a) > (n.d)) and ((n.d) > (n.c))) and ((n.c) > (n.b)))))))) and (((not ((n.b) < (n.d))) and (1=1)) => ((((n.b) < (n.c)) => ((((x) = (1)) => ((((n.a) < (n.c)) and ((n.c) < (n.b))) and ((n.b) < (n.d)))) and (((x) = (0)) => ((((n.a) > (n.c)) and ((n.c) > (n.b))) and ((n.b) > (n.d)))))) and (((not ((n.b) < (n.c))) and (1=1)) => ((((x) = (1)) => ((((n.a) < (n.b)) and ((n.b) < (n.c))) and ((n.c) < (n.d)))) and (((x) = (0)) => ((((n.a) > (n.b)) and ((n.b) > (n.c))) and ((n.c) > (n.d))))))))))))))))))
}

//The post-condition/class-invariant/loop-correctness of function (sort) is only valid when this is inconsistent.
run {
	some x: Int| sortCheck[x]
} for 8 but 8 int, 2 Bool, exactly 32 String