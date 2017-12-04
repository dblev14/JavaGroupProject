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
public class MeatsDairy extends Item {
    
        public final String itemDescription = "Meats/Dairy";
    
      public MeatsDairy(double itemCost, String itemDescription, String itemName, double itemRetail, int itemQty)
    {
        super(itemCost, itemDescription, itemName, itemRetail, itemQty);
    }
    
    
 public String printItemDescription(MeatsDairy meatsDairy)
    {
        return itemDescription;
    }
    
    
}
