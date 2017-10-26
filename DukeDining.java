package HW3;
// Author: Daniel Blevins
// Date: 9/22/2017
// Program: HW3 Duke Dining
// Purpose: This program demonstrates how to use switch statements,
// if statements, and calculations to make a simple ordering menu.
import java.util.*;

public class DukeDining {

 
    public static void main(String[] args) {
        
        // Declaring variables used for menu
        Scanner in = new Scanner(System.in);
        
        int entChoice = 0;
        int conChoice = 0;
        int sidChoice = 0;
        int drkChoice = 0;
        
        int friedChoice = 0;
        int cheeseChoice = 0;
        int ovalChoice = 0;
        
        double entPrice = 0;
        double conPrice = 0;
        double sidPrice = 0;
        double drkPrice = 0;
        
        double entChicken = 4.25; // +.30 for fried
        double entBurger = 4.00;       
             
        double conCheese = 0.50;
        double conPickle = 0.30;
        double conKetchup = 0.10;        
        
        double sidFries = 1.50;
        double sidMash = 1.75; // +.50 with cheese
        double sidVeg = 0.75; // Free if ordered burger
                
        double drkCoke = 1.00;
        double drkPepsi = 1.10; // Only .50 if ordered fries
        double drkTea = 0.75;
        double drkOval = 0.75; // if cold +.15
        
        double subTotal = 0;
        double taxAmt = 0;
        double total = 0;
        
        
        // Printing to CPU the menu and prompts user to choose entre
        System.out.println("Welcome to Duke Dining 1.0!");
        System.out.println("===========================");
        System.out.println("Please Choose Your Entree: ");
        System.out.println("---------------------------");
        System.out.printf("1. Chicken: \t$" + entChicken 
                + "\n2. Hamburger: \t$%3.2f\n", entBurger); 
        System.out.print("Choice: ");
        entChoice = in.nextInt();
        System.out.println("");

        // asks if the user would like fried chicken if selected chicken
        if (entChoice == 1)
        {
            
            System.out.print("If you would like fried chicken (+0.30)"
                    + ", please type 1: ");
            System.out.println("");
            friedChoice = in.nextInt();
            
            if (friedChoice == 1)
            {
                entPrice = entChicken + .3;
            }
            else
            {
                entPrice = entChicken;
            }
        }
        // If Burger is chosen the user gets to pick a condiment
        else if (entChoice == 2)
        {
            entPrice = entBurger;
            System.out.println("Please choose your Condiment: ");
            System.out.println("------------------------------");
            System.out.printf("1. Cheese Slice: \t$%3.2f", conCheese); 
            System.out.printf("\n2. Pickles: \t\t$%3.2f", conPickle); 
            System.out.printf("\n3. Ketchup: \t\t$%3.2f\n", conKetchup);
            System.out.println("Choice: ");
            conChoice = in.nextInt();
            
            // assigns prices for later calculations
            switch (conChoice) {
                case 1: conPrice = conCheese; break;
                case 2: conPrice = conPickle; break;
                case 3: conPrice = conKetchup; break;              
            }
                         
        }
        
        // Promts user to choose side item
        System.out.println("Please choose your Side Item: ");
        System.out.println("------------------------------");
        System.out.printf("1. Fries: \t\t$%3.2f", sidFries);
        System.out.printf("\n2. Mashed Potatoes: \t$%3.2f", sidMash);
        System.out.printf("\n3. Mixed Veggies: \t$%3.2f", sidVeg);
        
        System.out.print("\nChoice: ");
        sidChoice = in.nextInt();
        System.out.println("");

        // If selected mashed potatoes asks if you want cheese on them
        switch (sidChoice) {
            case 1: sidPrice = sidFries; break;
            case 2: 
                
                System.out.print("If you would like cheese on your mashed"
                    + " potatoes (+$0.50)"
                        + ", please type 1: ");
                cheeseChoice = in.nextInt();
            
                if (cheeseChoice == 1)
                {
                    sidPrice = sidMash + .5;
                }
                else 
                {
                    sidPrice = sidMash;
                } break;
            case 3: 
                if (entChoice == 2)
                {
                    sidPrice = 0;
                }
                else
                {
                    sidPrice = sidVeg;
                } break;
        }
        
        // Prompts user to enter a drink
        System.out.println("Please choose a Drink: ");
        System.out.println("-----------------------");
        System.out.printf("1. Coke Product: \t$%3.2f", drkCoke);
        System.out.printf("\n2. Pepsi Product: \t$%3.2f", drkPepsi);
        System.out.printf("\n3. Tea: \t\t$%3.2f", drkTea);
        System.out.printf("\n4. Ovaltine: \t\t$%3.2f", drkOval);
        
        System.out.println("\nChoice: ");
        drkChoice = in.nextInt();
        
        // assigns prices to drinks based on drink chosen
        switch (drkChoice) {
            case 1: drkPrice = drkCoke; break;
            case 2: 
                if (sidChoice == 1)
                {
                    drkPrice = .5;
                }
                else 
                {
                    drkPrice = drkPepsi;
                } break;
            case 3: drkPrice = drkTea; break;
            case 4: 
                System.out.print("Press 1 for Hot Ovaltine or press 2 for "
                        + "Chilled Ovaltine (+$0.15): ");
                ovalChoice = in.nextInt();
                
                if (ovalChoice == 1)
                    drkPrice = drkOval;
                else
                {
                    drkPrice = drkOval + .15;
                }
        }
        
        // Prints the receipt 
        System.out.println("==============================="); 
        System.out.println("Receipt:");
        System.out.println("==============================="); 
        
        // Prints out what items the user chose
        switch (entChoice) {
            case 1: 
                if (friedChoice == 1)
                {
                    System.out.printf("Chicken: \t\t$%3.2f\n", entChicken);
                    System.out.println("   Fried Chicken:      +$0.30");
                } break;
            case 2: System.out.printf("Hamburger: \t\t$%3.2f\n", entBurger);
            
            switch (conChoice) {
                case 1: System.out.printf("   Cheese Slice:       "
                        + "+$%3.2f", conCheese); break;
                case 2: System.out.printf("   Pickles:\t       "
                        + "+$%3.2f", conPickle); break;
                case 3: System.out.printf("   Ketchup:\t       "
                        + "+$%3.2f", conKetchup); break;
            }
            break;   
        }
        switch (sidChoice) {
            case 1: System.out.printf("\nFries:\t\t\t$%3.2f"
                    + "          \n", sidFries); 
            break;
            case 2: 
                if (cheeseChoice == 1)
                {
                    System.out.printf("\nMashed Potatoes:\t$%3.2f\n", sidMash);
                    System.out.println("   W/ Cheese:\t       +$0.50");
                }break;
            case 3: 
                if (entChoice == 2)
                {
                    System.out.print("\nVeggies:     Free with Burger");
                }
                else
                {
                    System.out.printf("Veggies:\t\t$%3.2f", sidVeg);
                }break;
        }
        
        switch (drkChoice) {
            case 1: System.out.printf("\nCoke Product:\t\t"
                    + "$%3.2f", drkCoke); break;
            case 2: 
                if (sidChoice == 1) 
                {
                    System.out.println("Pepsi (Fries Promotion):$0.50");
                }
                else
                {
                    System.out.printf("Pepsi Product:\t\t"
                            + "$%3.2f", drkPepsi);
                    System.out.println(" ");
                }break;
            case 3: System.out.printf("Tea:\t\t\t"
                    + "$%3.2f", drkTea); break;
            case 4: 
                if (ovalChoice == 1)
                {
                    System.out.printf("\nOvaltine:\t\t$%3.2f", drkOval);
                }
                else if (ovalChoice == 2)
                {
                    System.out.printf("\nOvaltine:\t\t$%3.2f", drkOval);
                    System.out.println("\n   Chilled:\t       +$0.15");
                }break;
        }
        
        System.out.println("===============================");

        // calculates subtotal, tax, and total
        subTotal = entPrice + conPrice + sidPrice + drkPrice;
        taxAmt = subTotal * .0925;
        total = subTotal + taxAmt;
        
        
        System.out.printf("SubTotal: \t\t$%3.2f", subTotal);
        System.out.printf("\nTax:\t\t\t$%3.2f", taxAmt);
        System.out.printf("\nTotal:\t\t\t$%3.2f", total);
        
        
                


        
        
        
        }  
}


