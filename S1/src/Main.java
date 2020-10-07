public class Main {

    public static void main(String[] args) {
       /*int day = ;
        switch (day) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("invalid day");
        }*/
        // print out special cases whose ordinal doesn't end in th
       /* System.out.println("1st Hello");
        System.out.println("2nd Hello");
        System.out.println("3rd Hello");
        // count from i = 4 to 10
        int i = 4;
        while (i <= 10) {
            System.out.println(i + "th Hello");
            i = i + 1;
        } 
        for (int i = 4; i <= 11; i++) {
            System.out.println(i + "th Hello");
        }
        String myStr = "HelloMasih9831079";
        for (char s : myStr.toCharArray()) {
            System.out.println(s);
        }
        String myStr = args[1];
        for (char s : myStr.toCharArray()) {
            System.out.print(s);
        } */
        // حل شماره ۱
        // b is bigger than a every time !!!
       /* int a, b, counter;
        a = 14;
        b = 21;
        counter = 0;
        for (int i = 2; i < a; i++) {
            if (a % i == 0 && b % i == 0) {
                counter++;
            }
        }
        if (counter >= 1)
            System.out.println("NO");
        else
            System.out.println("YES");

        */
        //حل شماره ۲
        int counter = 0;
        for (int i = 10; i < 21; i++) {
            for (int j = 10; j < 21; j++) {
                if (counter <= 9) {
                    System.out.print(i * j + " ");
                    counter++;
                } else if (counter > 9) {
                    System.out.println("");
                    counter = 0;

                }
            }
        }

    }
}


