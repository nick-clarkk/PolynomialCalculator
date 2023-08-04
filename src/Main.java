import java.util.Scanner;

class Main {
    private static Scanner keyboard = new Scanner(System.in);

    private static Polynomial poly1 = new Polynomial();
    private static Polynomial poly2 = new Polynomial();

    public static void main(String[] args) {
        display();
    }
    private static int polyChoice;
    private static void display() {
        do {
            System.out.println("\nPress (1) to edit Polynomial1\n");
            System.out.println("Press (2) to edit Polynomial2\n");
            System.out.println("Press (3) to exit\n");
            System.out.print("> ");
            polyChoice = keyboard.nextInt();
            if(polyChoice == 1)
                displayPoly1();
            else if(polyChoice == 2)
                displayPoly2();
            else {
                System.out.println("\nYou have exited out of LinkedList Polynomial Editor. Goodbye.");
                System.exit(0);
            }
        }while(polyChoice != 3);

    }

    private static void displayPoly1() {
        int input;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nPolynomial1 LinkedList Adder\n");

        do {
            System.out.println("Press (1) to add a new term");
            System.out.println("Press (2) to clear your polynomial");
            System.out.println("Press (3) to add polynomial2 to polynomial1");
            System.out.println("Press (4) to exit to main menu");
            System.out.print("> ");

            input = keyboard.nextInt();

            switch(input) {
                case 1:
                    keyboard.nextLine();
                    System.out.print("\nEnter a term: ");
                    String termInput = keyboard.nextLine();
                    poly1.addTerm(new Term(termInput));
                    System.out.println("\nPolynomial 1 is now: " + poly1 +"\n");
                    break;

                case 2:
                    System.out.println("\nPolynomial1 is now cleared.\n");
                    poly1.clear();
                    break;

                case 3:
                    Polynomial tempPoly = poly1;
                    tempPoly.add(poly2);
                    System.out.println("\nHere is the sum of your two polynomials: " + tempPoly + "\n");
                    break;

                case 4:
                    System.out.println("\nYou have exited Polynomial1 Editor. Goodbye.");
                    display();
                    break;

            }
        }while(input != 4);

        System.exit(0);
    }

    private static void displayPoly2() {
        int input;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\nPolynomial2 LinkedList Adder\n");

        do {
            System.out.println("Press (1) to add a new term");
            System.out.println("Press (2) to clear your polynomial");
            System.out.println("Press (3) to add polynomial2 to polynomial1");
            System.out.println("Press (4) to exit the program");
            System.out.print("> ");

            input = keyboard.nextInt();

            switch(input) {
                case 1:
                    keyboard.nextLine();
                    System.out.print("\nEnter a term: ");
                    String termInput = keyboard.nextLine();
                    poly2.addTerm(new Term(termInput));
                    System.out.println("\nPolynomial2 is now: " + poly2 + "\n");
                    break;

                case 2:
                    System.out.println("\nPolynomial2 is now cleared.\n");
                    poly2.clear();
                    break;

                case 3:
                    Polynomial tempPoly = poly2;
                    tempPoly.add(poly1);
                    System.out.println("\nHere is the sum of your two polynomials: " + tempPoly + "\n");
                    break;

                case 4:
                    System.out.println("\nYou have exited Polynomial2 Editor. Goodbye.");
                    display();
                    break;

            }
        }while(input != 4);

        System.exit(0);
    }


}