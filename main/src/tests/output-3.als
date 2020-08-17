
open util/boolean
open util/sequniv

//==============SortingNet==============
some sig SortingNet{
	arr:seq Int,
	tmp:Int
}

fact SortingNetFact {
}

pred sortCheck{
	some n: SortingNet| not ((((0) >= (0)) and ((1) >= (0))) and (((n.arr[0]) <= (n.arr[1])) => ((((3) >= (0)) and ((4) >= (0))) and (((n.arr[3]) <= (n.arr[4])) => ((((6) >= (0)) and ((7) >= (0))) and (((n.arr[6]) <= (n.arr[7])) => ((((1) >= (0)) and ((2) >= (0))) and (((n.arr[1]) <= (n.arr[2])) => ((((4) >= (0)) and ((5) >= (0))) and (((n.arr[4]) <= (n.arr[5])) => ((((7) >= (0)) and ((8) >= (0))) and (((n.arr[7]) <= (n.arr[8])) => ((((0) >= (0)) and ((1) >= (0))) and (((n.arr[0]) <= (n.arr[1])) => ((((3) >= (0)) and ((4) >= (0))) and (((n.arr[3]) <= (n.arr[4])) => ((((6) >= (0)) and ((7) >= (0))) and (((n.arr[6]) <= (n.arr[7])) => ((((0) >= (0)) and ((3) >= (0))) and (((n.arr[0]) <= (n.arr[3])) => ((((3) >= (0)) and ((6) >= (0))) and (((n.arr[3]) <= (n.arr[6])) => ((((0) >= (0)) and ((3) >= (0))) and (((n.arr[0]) <= (n.arr[3])) => ((((1) >= (0)) and ((4) >= (0))) and (((n.arr[1]) <= (n.arr[4])) => ((((4) >= (0)) and ((7) >= (0))) and (((n.arr[4]) <= (n.arr[7])) => ((((1) >= (0)) and ((4) >= (0))) and (((n.arr[1]) <= (n.arr[4])) => ((((2) >= (0)) and ((5) >= (0))) and (((n.arr[2]) <= (n.arr[5])) => ((((5) >= (0)) and ((8) >= (0))) and (((n.arr[5]) <= (n.arr[8])) => ((((2) >= (0)) and ((5) >= (0))) and (((n.arr[2]) <= (n.arr[5])) => ((((1) >= (0)) and ((3) >= (0))) and (((n.arr[1]) <= (n.arr[3])) => ((((5) >= (0)) and ((7) >= (0))) and (((n.arr[5]) <= (n.arr[7])) => ((((2) >= (0)) and ((6) >= (0))) and (((n.arr[2]) <= (n.arr[6])) => ((((4) >= (0)) and ((6) >= (0))) and (((n.arr[4]) <= (n.arr[6])) => ((((2) >= (0)) and ((4) >= (0))) and (((n.arr[2]) <= (n.arr[4])) => ((((2) >= (0)) and ((3) >= (0))) and (((n.arr[2]) <= (n.arr[3])) => ((((5) >= (0)) and ((6) >= (0))) and (((n.arr[5]) <= (n.arr[6])) => (((((n.arr[0]) <= (n.arr[1])) and ((n.arr[1]) <= (n.arr[2]))) and (((n.arr[2]) <= (n.arr[3])) and ((n.arr[3]) <= (n.arr[4])))) and ((((n.arr[4]) <= (n.arr[5])) and ((n.arr[5]) <= (n.arr[6]))) and (((n.arr[6]) <= (n.arr[7])) and ((n.arr[7]) <= (n.arr[8])))))))))))))))))))))))))))))))))))))))))))))))))))))))
}

//The post-condition/class-invariant/loop-correctness of function (sort) is only valid when this is inconsistent.
run sortCheck for 8 but 8 int, 2 Bool, exactly 32 String

pred SWAPCheck[i:Int, j:Int]{
	some n: SortingNet| not ((((i) >= (0)) and ((j) >= (0))) => ((((n.arr[i]) > (n.arr[j])) => ((n.arr[j]) <= (n.arr[i]))) and (((not ((n.arr[i]) > (n.arr[j]))) and (1=1)) => ((n.arr[i]) <= (n.arr[j])))))
}

//The post-condition/class-invariant/loop-correctness of function (SWAP) is only valid when this is inconsistent.
run {
	some i: Int| some j: Int| SWAPCheck[i, j]
} for 8 but 8 int, 2 Bool, exactly 32 String