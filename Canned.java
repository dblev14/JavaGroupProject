/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photogrocery;

/**
 *
 * @author Daniel
 */
public class Canned extends Item{
    
        public final String itemDescription = "Canned";
    
    
      public Canned(double itemCost, String itemDescription, String itemName, double itemRetail, int itemQty)
    {
        super(itemCost, itemDescription, itemName, itemRetail, itemQty);
    }
      
      
      
    public String printItemDescription(Canned canned)
    {
        return itemDescription;
    }
      
    
}
