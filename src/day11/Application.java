package day11;

public class Application {
    public static void main(String[] args) {
        SeatChooser seatChooser = new SeatChooser();
/*        Boolean[][] array1 = seatChooser.getInput();
        System.out.println("---------------");
        seatChooser.print(array1);
        System.out.println("---------------");
        Boolean[][] array2 = seatChooser.applyRuleSet1(array1);
        seatChooser.print(array2);
        System.out.println("---------------");
        Boolean[][] array3 = seatChooser.applyRuleSet1(array2);
        seatChooser.print(array3);

        System.out.println();
        System.out.println();
        System.out.println();*/




/*        Boolean[][] array1 = new Boolean[2][2];
        array1[0][0] = Boolean.TRUE;
        array1[0][1] = Boolean.FALSE;
        array1[1][0] = Boolean.FALSE;
        array1[1][1] = Boolean.TRUE;

        Boolean[][] array2 = new Boolean[2][2];
        array2[0][0] = Boolean.TRUE;
        array2[0][1] = Boolean.FALSE;
        array2[1][0] = Boolean.FALSE;
        array2[1][1] = Boolean.TRUE;

        boolean equals1 = Arrays.deepEquals(array1, array2);
        System.out.println(equals1);

        System.out.println("//////////////////////////////////////////////////////////");


        boolean[][] array3 = new boolean[2][2];
        array3[0][0] = true;
        array3[0][1] = false;
        array3[1][0] = false;
        array3[1][1] = true;

        boolean[][] array4 = new boolean[2][2];
        array4[0][0] = true;
        array4[0][1] = false;
        array4[1][0] = false;
        array4[1][1] = true;

        boolean equals2 = Arrays.deepEquals(array3, array4);
        System.out.println(equals2);*/


        int answerPart1 = seatChooser.getAnswerPart1();
        System.out.println("answerPart1: " + answerPart1);
        System.out.println("---------");
        int answerPart2 = seatChooser.getAnswerPart2();
        System.out.println("answerPart2: " + answerPart2);


    }
}
