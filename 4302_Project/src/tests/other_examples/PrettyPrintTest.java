package tests;

import expression.*;
import expression.binary.*;
import visitor.PrettyPrinter;

public class PrettyPrintTest {

    public static void main(String[] args) {
//        PrettyPrinter test = new PrettyPrinter();
//        Constant left = new NumConst(23);
//        Constant right = new NumConst(25);
//        Constant left2 = new NumConst(10);
//        Constant right2 = new NumConst(15);
//        BiAddition add = new BiAddition(left, right);
//        BiAddition add2 = new BiAddition(left2, right2);
//
//        Variable vleft = new BoolVariable("x");
//        vleft.setValueDefined(true);
//        Variable vright = new BoolVariable("y");
//        vright.setValueDefined(false);
//        Variable vleft2 = new BoolVariable("z");
//        vleft2.setValueDefined(true);
//
//        Constant bcleft = new BoolConst(true);
//        Constant bcright = new BoolConst(false);
//
//        String result = test.getPrintResult(add);
//        System.out.println("Addition test\n----------");
//        String result2 = test.getPrintResult(add2);
//        System.out.println("23+25\n"+result + "\n\n10+15"+"\n" + result2);
//
//        BiSubtraction sub = new BiSubtraction(add, add2);
//        BiSubtraction sub2 = new BiSubtraction(add2, right);
//        System.out.println("\nSubtraction test \n---------");
//        result = test.getPrintResult(sub);
//        result2 = test.getPrintResult(sub2);
//        System.out.println("(23+25)-(10+15)\n"+result + "\n\n" + "(10+15)-25\n"+ result2);
//
//
//        BiMultiplication mult = new BiMultiplication(left, right);
//        BiMultiplication mult2 = new BiMultiplication(add2, right);
//        BiMultiplication mult3 = new BiMultiplication(sub, sub2);
//        System.out.println("\nMultiplication test \n---------");
//        result = test.getPrintResult(mult);
//        result2 = test.getPrintResult(mult2);
//        String result3 = test.getPrintResult(mult3);
//        System.out.println("23*25\n"+result + "\n\n" + "(10+15)*25\n"+ result2+"\n\n((23+25)-(10+15))*((10+15)-25)\n"+result3);
//
//        BiDivision div = new BiDivision(left, right);
//        BiDivision div2 = new BiDivision(sub, right);
//        BiDivision div3 = new BiDivision(mult, sub2);
//        System.out.println("\nDivision test \n---------");
//        result = test.getPrintResult(div);
//        result2 = test.getPrintResult(div2);
//        result3 = test.getPrintResult(div3);
//        System.out.println("23/25\n"+result + "\n\n" + "((23+25)-(10+15))/25\n"+ result2+"\n\n(23*25)/((10+15)-25)\n"+result3);
//
//        BiDisjunction dis = new BiDisjunction(vleft, vright);
//        BiDisjunction dis2 = new BiDisjunction(dis, vright);
//        BiDisjunction dis3 = new BiDisjunction(dis, dis2);
//        System.out.println("\nDisjunction test \n---------");
//        result = test.getPrintResult(dis);
//        result2 = test.getPrintResult(dis2);
//        result3 = test.getPrintResult(dis3);
//        System.out.println("x=true, y=false, z=true\n" + "x||y\n"+result + "\n\n" + "((x||y)||y)\n"+ result2+"\n\n((x||y)||((x||y)||y))\n"+result3);
//
//        BiConjunction con = new BiConjunction(vleft, vright);
//        BiConjunction con2 = new BiConjunction(con, dis2);
//        BiConjunction con3 = new BiConjunction(vleft2, dis3);
//        System.out.println("\nConjunction test \n---------");
//        result = test.getPrintResult(con);
//        result2 = test.getPrintResult(con2);
//        result3 = test.getPrintResult(con3);
//        System.out.println("x=true, y=false, z=true\n" + "x&&y\n"+result + "\n\n" + "(x&&y)&&(((x||y)||y))\n"+ result2+"\n\nz&&((x||y)||((x||y)||y))\n"+result3);
//
//
//        BiEquivalence eqv = new BiEquivalence(vleft, vright);
//        BiEquivalence eqv2 = new BiEquivalence(con, dis2);
//        BiEquivalence eqv3 = new BiEquivalence(con3, dis3);
//        System.out.println("\nequivalence test \n---------");
//        result = test.getPrintResult(eqv);
//        result2 = test.getPrintResult(eqv2);
//        result3 = test.getPrintResult(eqv3);
//        System.out.println("x=true, y=false, z=true\n" + "x==y\n"+result + "\n\n" + "(x&&y)==(((x||y)||y))\n"+ result2+"\n\n(z&&((x||y)||((x||y)||y)))==((x||y)||((x||y)||y))\n"+result3);
//
//        BiEqual eq = new BiEqual(vleft, bcright);
//        BiEqual eq2 = new BiEqual(vleft2, eqv2);
//        BiEqual eq3 = new BiEqual(vright, con3);
//        System.out.println("\nequals test \n---------");
//        result = test.getPrintResult(eq);
//        result2 = test.getPrintResult(eq2);
//        result3 = test.getPrintResult(eq3);
//        System.out.println("x=false\n"+result + "\n\n" + "z=((x&&y)==(((x||y)||y)))\n"+ result2+"\n\ny=(z&&((x||y)||((x||y)||y)))\n"+result3);
//
//        BiLarger large = new BiLarger(left, right);
//        BiLarger large2 = new BiLarger(mult2, sub2);
//        BiLarger large3 = new BiLarger(sub2, div3);
//        System.out.println("\nGreater Than test \n---------");
//        result = test.getPrintResult(large);
//        result2 = test.getPrintResult(large2);
//        result3 = test.getPrintResult(large3);
//        System.out.println("23>25\n"+result + "\n\n" + "((10+15)*25)>((10+15)-25)\n"+ result2+"\n\n((10+15)-25)>((23*25)/((10+15)-25))\n"+result3);
//
//        BiSmaller small = new BiSmaller(left, right);
//        BiSmaller small2 = new BiSmaller(mult2, sub2);
//        BiSmaller small3 = new BiSmaller(sub2, div3);
//        System.out.println("\nLess Than test \n---------");
//        result = test.getPrintResult(small);
//        result2 = test.getPrintResult(small2);
//        result3 = test.getPrintResult(small3);
//        System.out.println("23<25\n"+result + "\n\n" + "((10+15)*25)<((10+15)-25)\n"+ result2+"\n\n((10+15)-25)<((23*25)/((10+15)-25))\n"+result3);
//
//
//        BiLargerOrEqual largeeq = new BiLargerOrEqual(left, right);
//        BiLargerOrEqual largeeq2 = new BiLargerOrEqual(mult2, sub2);
//        BiLargerOrEqual largeeq3 = new BiLargerOrEqual(sub2, div3);
//        System.out.println("\nGreater Than or Equal test \n---------");
//        result = test.getPrintResult(largeeq);
//        result2 = test.getPrintResult(largeeq2);
//        result3 = test.getPrintResult(largeeq3);
//        System.out.println("23>=25\n"+result + "\n\n" + "((10+15)*25)>=((10+15)-25)\n"+ result2+"\n\n((10+15)-25)>=((23*25)/((10+15)-25))\n"+result3);
//
//
//        BiSmallerOrEqual smalleq = new BiSmallerOrEqual(left, right);
//        BiSmallerOrEqual smalleq2 = new BiSmallerOrEqual(mult2, sub2);
//        BiSmallerOrEqual smalleq3 = new BiSmallerOrEqual(sub2, div3);
//        System.out.println("\nLess Than or Equals test \n---------");
//        result = test.getPrintResult(smalleq);
//        result2 = test.getPrintResult(smalleq2);
//        result3 = test.getPrintResult(smalleq3);
//        System.out.println("23<=25\n"+result + "\n\n" + "((10+15)*25)<=((10+15)-25)\n"+ result2+"\n\n((10+15)-25)<=((23*25)/((10+15)-25))\n"+result3);
//
//
//        BiNotEqual noteq = new BiNotEqual(vleft, vleft2);
//        BiNotEqual noteq2 = new BiNotEqual(div3, sub2);
//        BiNotEqual noteq3 = new BiNotEqual(con2, con3);
//        System.out.println("\nNot Equal test \n---------");
//        result = test.getPrintResult(noteq);
//        result2 = test.getPrintResult(noteq2);
//        result3 = test.getPrintResult(noteq3);
//        System.out.println("x != z\n"+result + "\n\n" + "((23*25)/((10+15)-25))!=((10+15)-25)\n"+ result2+"\n\n(x&&y)&&(((x||y)||y))!=(z&&((x||y)||((x||y)||y)))\n"+result3);
//
//
//        Negation neg = new Negation(vleft);
//        Negation neg2 = new Negation(con2);
//        Negation neg3 = new Negation(dis3);
//        System.out.println("\nNegation test \n---------");
//        result = test.getPrintResult(neg);
//        result2 = test.getPrintResult(neg2);
//        result3 = test.getPrintResult(neg3);
//        System.out.println("!x\n"+result + "\n\n" + "((23*25)/((10+15)-25))!=((10+15)-25)\n"+ result2+"\n\n(x&&y)&&(((x||y)||y))!=(z&&((x||y)||((x||y)||y)))\n"+result3);
//
//        BiImplication imp = new BiImplication(vleft, vright);
//        BiImplication imp2 = new BiImplication(con2, bcleft);
//        BiImplication imp3 = new BiImplication(large3, dis3);
//        System.out.println("\nImplication test \n---------");
//        result = test.getPrintResult(imp);
//        result2 = test.getPrintResult(imp2);
//        result3 = test.getPrintResult(imp3);
//        System.out.println("x=>y\n"+result + "\n\n((x&&y)&&(((x||y)||y)))=>(true)" + "\n"+ result2+"\n\n(((10+15)-25)>((23*25)/((10+15)-25)))=>(((x||y)||((x||y)||y)))\n"+result3);

/*
        StringVariable sv = new StringVariable("testString");
        StringVariable sv2 = new StringVariable("testString2");
        sv.setValue(new StringConst("ANTLR"));
        sv2.setValue(new StringConst("This is test 16"));
        System.out.println("\nString Variable test \n---------");
        result = test.getPrintResult(sv);
        result2 = test.getPrintResult(sv2);
        System.out.println("ANTLR\n"+result + "\n" + "This is test 16\n"+ result2);

 */


    }
}
