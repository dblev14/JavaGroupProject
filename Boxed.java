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
public class Boxed extends Item {
    
        public final String itemDescription = "Boxed";
    
      public Boxed(double itemCost, String itemDescription, String itemName, double itemRetail, int itemQty)
    {
        super(itemCost, itemDescription, itemName, itemRetail, itemQty);
    }
    
      
      
      
      
      
  public String printItemDescription(Boxed boxed)
    {
        return itemDescription;
    }
    
}
