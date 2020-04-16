
open util/boolean
open util/sequniv

//==============SortingNet==============
some sig SortingNet{
	arr:seq Int,
	tmp:Int,
	old_i:Int,
	old_j:Int
}

fact SortingNetFact {
}

pred sortCheck{
	some n: SortingNet| not ((((1) >= (0)) and ((2) >= (0))) and (((n.arr[1]) <= (n.arr[2])) => ((((0) >= (0)) and ((2) >= (0))) and (((n.arr[0]) <= (n.arr[2])) => ((((0) >= (0)) and ((1) >= (0))) and (((n.arr[0]) <= (n.arr[1])) => (((n.arr[0]) <= (n.arr[1])) and ((n.arr[1]) <= (n.arr[2])))))))))
}

//The post-condition/class-invariant/loop-correctness of function (sort) is only valid when this is inconsistent.
run sortCheck for 8 but 8 int, 2 Bool, exactly 32 String

pred swapCheck[i:Int, j:Int]{
	some n: SortingNet| not ((((i) >= (0)) and ((j) >= (0))) => ((((n.arr[i]) > (n.arr[j])) => ((n.arr[j]) <= (n.arr[i]))) and (((not ((n.arr[i]) > (n.arr[j]))) and (1=1)) => ((n.arr[i]) <= (n.arr[j])))))
}

//The post-condition/class-invariant/loop-correctness of function (swap) is only valid when this is inconsistent.
run {
	some i: Int| some j: Int| swapCheck[i, j]
} for 8 but 8 int, 2 Bool, exactly 32 String