/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photogrocery;

import java.util.ArrayList;

public class Item {
    
        //Data field declaration
    public String name;
    public String description;
    public int category;
    public double cost;
    public double retailPrice;
    public int quantInStock;
    public static int nextID = 0;
    public int ItemID;
    public static ArrayList<Item> inventory = new ArrayList<>();
    public static String [] categoryDescriptions = {"Produce", "Meats/Dairy","Canned","Boxed","Bagged"};
    public static int inventoryCount;
    
  
    
 public Item()
 {
     
 }
    
    
//Item constuctor     
public Item(double itemCost, String itemDescription, String itemName, double itemRetail, int itemQty){
    this.ItemID = nextID + 1;
    this.name = itemName;
    this.description = itemDescription;

    this.cost = itemCost;
    this.retailPrice = itemRetail;
    this.quantInStock = itemQty;
    
   
    
  
    //Prints message that the item was added and prints its details
    System.out.println("Added: ");
    System.out.printf("ID #: " + this.ItemID + "\t" + this.name + "\t" 
            + "$%3.2f" + "\t" 
            + "\t" + this.quantInStock, this.cost);
    System.out.println("");
    
    
}
 
//static method that adds the Item to Item inventory array
public static boolean addToInventory(Item itemInstance){
    boolean added = true;
    inventory.add(itemInstance);
    nextID++;
    
   
    return added;
}
 
//Takes category number as an input, matches the number with the category string array,
// and returns the category as a string
public static String generateCategoryString(int catNumber){
   String category = " ";
    
    switch(catNumber){
        case 1: category = categoryDescriptions[0]; break;
        case 2: category = categoryDescriptions[1]; break;
        case 3: category = categoryDescriptions[2]; break;
        case 4: category = categoryDescriptions[3]; break;
        case 5: category = categoryDescriptions[4]; break;
        default: category = "This number is not associated with a category"; break;
    }

    return category;
}

//Getter to retrieve item cost for specified item
public double getItemCost(Item item){
    
    return this.cost;
}
   
//Getter to retrieve item retail price for the specified item
public double getItemRetail(Item item){
    
    return this.retailPrice;       
}

//Prints the item description for the specified item
public static String printItemDescription(Item item){
    String itemDescription = "";
    
    itemDescription += printItemDescription(item);
    //Need code here to return item description in subclass
    
    return itemDescription;
}

//Setter to set the category for a specified item 
public void setItemCategory(int number){
    this.category = number;
}
//Setter to set the item cost for a specified item
public void setItemCost(double setCost){
    this.cost = setCost;
}
//Setter to set the item name for a specified item
public void setItemName(String setName){
    this.name = setName;
}
//Setter to set the item quantity for a specified item
public void setItemQty(int setQty){
    this.quantInStock = setQty;
}

//Setter to set the item retail price for a specified item
public void setItemRetail(double setRetail){
    this.retailPrice = setRetail;
}
    
}
