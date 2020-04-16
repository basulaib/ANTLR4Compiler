
open util/boolean
open util/sequniv

//==============ArrayTest==============
some sig ArrayTest{
	arr1:seq Int,
	arr2:seq Int,
	temp:Int,
	oldi:Int,
	oldj:Int
}{
	arr1[0] = 1
	arr1[1] = 3
	arr1[2] = 4
	arr1[3] = 2
	arr2[0] = 0
	arr2[1] = 0
}

fact ArrayTestFact {
}

pred swapCheck[i:Int, j:Int]{
	some n: ArrayTest| not ((((((i) > (0)) and ((j) > (0))) and ((i) < (4))) and ((j) < (4))) => ((((n.arr1[j]) = (n.arr1[j])) and ((n.arr1[i]) = (n.arr1[i]))) and (((n.arr1[2]) = (4)) and ((n.arr1[1]) = (3)))))
}

//The post-condition/class-invariant/loop-correctness of function (swap) is only valid when this is inconsistent.
run {
	some i: Int| some j: Int| swapCheck[i, j]
} for 8 but 8 int, 2 Bool, exactly 32 String