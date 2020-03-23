package tests;

import expression.Constant;
import expression.NumConst;
import expression.binary.BiAddition;
import expression.binary.BiSubtraction;
import visitor.PrettyPrinter;

public class PrettyPrintTest {

    public static void main(String args[]){
        PrettyPrinter test = new PrettyPrinter();
        Constant left = new NumConst(23);
        Constant right = new NumConst(25);
        Constant left2 = new NumConst(10);
        Constant right2 = new NumConst(15);
        BiAddition add = new BiAddition(left, right);
        BiAddition add2 = new BiAddition(left2, right2);

        String result = test.getPrintResult(add);
        System.out.println("Addition test\n----------");
        String result2 = test.getPrintResult(add2);
        System.out.println(result + "\n" + result2);

        BiSubtraction sub = new BiSubtraction(add, add2);
        BiSubtraction sub2 = new BiSubtraction(add2, right);
        System.out.println("Subtraction test \n---------");
        result = test.getPrintResult(sub);
        result2 = test.getPrintResult(sub2);
        System.out.println(result + "\n" + result2);


    }
}
