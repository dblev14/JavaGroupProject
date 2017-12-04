/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProtoGrocery;

/**
 *
 * @author Daniel
 */
public class Bagged extends Item {
    
        
    public final String itemDescription = "Bagged";
    
    
       public Bagged(double itemCost, String itemDescription, String itemName, double itemRetail, int itemQty)
    {
        super(itemCost, itemDescription, itemName, itemRetail, itemQty);
    }
       
       
  public String printItemDescription(Bagged bagged)
    {
        return itemDescription;
    }
    
    
}
