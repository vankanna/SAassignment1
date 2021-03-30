package us.mattgreen;
import java.lang.reflect.Array;
import java.util.Scanner;  // Import the Scanner class
import java.util.ArrayList; // import the ArrayList class


public class UserInput {
    final private Scanner sc = new Scanner(System.in);
    private ArrayList<Talkable> arrayList;
    UserInput(ArrayList<Talkable> animalList) {
        this.arrayList = animalList;
    }

    public void promptUser() {
        boolean running = true;
        while(running) {
            System.out.println("Which Animal Would You Like To Create?");
            System.out.println(" - Cat");
            System.out.println(" - Dog");
            System.out.println(" - Teacher");


            String response = this.sc.nextLine();

            if(response.equals("Dog")) {
                this.createDog();
            } else if (response.equals("Cat")) {
                this.createCat();
            } else if (response.equals("Teacher")) {
                this.createTeacher();
            } else {
                System.out.println("Not A Valid Choice -> " + response);
                System.out.println("Exiting Program");
                running = false;
            }

        }
    }
    private void createCat() {
        try {
            System.out.println("Please Enter A Name.");
            String name = this.sc.nextLine();

            System.out.println("Please Enter Number Of Mice Killed.");
            int miceKilled = Integer.parseInt(this.sc.nextLine());

            Cat cat = new Cat(miceKilled, name);
            this.arrayList.add(cat);
        }
        catch(NumberFormatException e) {
            System.out.println("Must Enter An Integer.");
        }

    }

    private void createDog() {
        try {
            System.out.println("Please Enter A Name.");
            String name = this.sc.nextLine();

            System.out.println("Is The Dog Friendly? True or False");
            boolean isFriendly = Boolean.parseBoolean(this.sc.nextLine());

            Dog dog = new Dog(isFriendly, name);
            this.arrayList.add(dog);
        }
        catch(Exception e) {
            System.out.println("Ran Into An Error Creating A Dog." + e);
        }
    }

    private void createTeacher() {
        try {
            System.out.println("Please Enter A Name.");
            String name = this.sc.nextLine();

            System.out.println("Please Enter An Age.");
            int age = Integer.parseInt(this.sc.nextLine());

            Teacher teacher = new Teacher(age, name);
            this.arrayList.add(teacher);
        }
        catch(NumberFormatException e) {
            System.out.println("Must Enter An Integer.");
        }
    }
}
