package InterfacesMenu;

import java.util.Scanner;


public class Menu {

    public static final String [] MONTHS = {"", "January", "February", "March", "April", "May", "June", "July", "August",
    "September", "October", "November", "December"};


    public static void showMenu(){

        System.out.println("**|||WELCOME TO MY RESERVATION SYSTEM|||**");
        System.out.println("Please, selec a option: ");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Exit");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response) {

                case 1:
                    System.out.println("Doctor");
                    break;
                case 2:
                    response = 0;
                    showPatientMenu();
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please, selection a correct option");

            }
        }while (response != 0) ;
    }



    public static void showPatientMenu(){

        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("1. Book a reservation");
            System.out.println("2. My reservation");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){

                case 1:
                    System.out.println(":: Book a reservation");
                    for (int i=1; i<13; i++){
                        System.out.println(i + ". " + MONTHS[i]);
                }
                    break;
                case 2:
                    System.out.println((":: My reservation"));
                    break;

                case 0:
                    showMenu();
                    break;
            }

        }while(response != 0);

    }
}
