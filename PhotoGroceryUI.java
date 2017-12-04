/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package photogrocery;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Daniel
 */
public class PhotoGroceryUI extends Application {
    int idForEdit = 0;
    
    
    
    @Override
    public void start(Stage primaryStage) {
        Button addItem = new Button("Add Item");
        Button editItem = new Button("Edit Item");
        Button printCat = new Button("Print Items in Category");
        Button printAllItems = new Button("Print All Items");
        Button quitApp = new Button("Quit");
        
        Label welcome = new Label("Welcome to Photogrocery 2.0!");
        
        GridPane primaryPane = new GridPane();
        primaryPane.setAlignment(Pos.CENTER);
        
        addItem.setMinWidth(200);
        editItem.setMinWidth(200);
        printCat.setMinWidth(200);
        printAllItems.setMinWidth(200);
        quitApp.setMinWidth(200);
        welcome.setMinWidth(200);
        
        primaryPane.add(addItem, 1, 1, 2, 1);
        primaryPane.add(editItem, 1, 2, 2, 1);
        primaryPane.add(printCat, 1, 3, 2, 1);
        primaryPane.add(printAllItems, 1, 4, 2, 1);
        primaryPane.add(quitApp, 1, 5, 2, 1);
        primaryPane.add(welcome, 1, 0, 2, 1);
        primaryPane.setVgap(30);
        primaryPane.setHgap(30);
        
        
        
        
        Scene primaryScene = new Scene (primaryPane, 400, 500);
        
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("PhotoGrocery 2.0");
        primaryStage.show();
        
     
        // declaration for adding items
        Label enterDetails = new Label("Enter Item Details:");
        Label name = new Label("Enter Item Name:");
        Label description = new Label("Enter Label Description:");
        Label cost = new Label("Item Cost:");
        Label sellPrice = new Label ("Sell for Cost:");
        Label category = new Label("Item Category:");
        RadioButton produce = new RadioButton("Produce");
        RadioButton meatsDairy = new RadioButton("Meats/Dairy");
        RadioButton canned = new RadioButton("Canned");
        RadioButton boxed = new RadioButton("Boxed");
        RadioButton bagged = new RadioButton("Bagged");
        Label itemQuant = new Label("Item Quantity");
        Button submitNew = new Button("Submit");
        
        TextField details = new TextField();
        TextField enterName = new TextField();
        TextField enterDescr = new TextField();
        TextField itemCost = new TextField();
        TextField itemSell = new TextField();
        TextField itemQuantity = new TextField();
        
        GridPane secondaryPane = new GridPane();
        
        secondaryPane.add(enterDetails, 1, 1);
        secondaryPane.add(details, 2, 1);
        secondaryPane.add(name, 1, 2);
        secondaryPane.add(enterName, 2, 2);
        secondaryPane.add(description, 1, 3);
        secondaryPane.add(enterDescr, 2, 3);
        secondaryPane.add(cost, 1, 4);
        secondaryPane.add(itemCost, 2, 4);
        secondaryPane.add(sellPrice, 1, 5);
        secondaryPane.add(itemSell, 2, 5);
        secondaryPane.add(category, 1, 6);
        secondaryPane.add(produce, 1, 7);
        secondaryPane.add(meatsDairy, 1, 8);
        secondaryPane.add(canned, 1, 9);
        secondaryPane.add(boxed, 1, 10);
        secondaryPane.add(bagged, 1, 11);
        secondaryPane.add(itemQuant, 1, 12);
        secondaryPane.add(itemQuantity, 2, 12);
        secondaryPane.add(submitNew, 1, 14);
        
        secondaryPane.setVgap(30);
        secondaryPane.setHgap(30);
        
        Scene addItemScene = new Scene(secondaryPane, 700, 900);
        
        Stage secondaryStage = new Stage();
        secondaryStage.setScene(addItemScene);

        // add item button action
        addItem.setOnAction(e -> {
            
            secondaryStage.show();
            
        });    
        // Submit added item button action
        submitNew.setOnAction(e -> {
            if(produce.isSelected())
                Item.addToInventory(new Produce(Double.valueOf(itemCost.getText()), String.valueOf(enterDescr.getText()), String.valueOf(enterName.getText()), Double.valueOf(itemSell.getText()), Integer.valueOf(itemQuantity.getText())));
            else if(meatsDairy.isSelected())
                Item.addToInventory(new MeatsDairy(Double.valueOf(itemCost.getText()), String.valueOf(enterDescr.getText()), String.valueOf(enterName.getText()), Double.valueOf(itemSell.getText()), Integer.valueOf(itemQuantity.getText())));
            else if(canned.isSelected())
                Item.addToInventory(new Canned(Double.valueOf(itemCost.getText()), String.valueOf(enterDescr.getText()), String.valueOf(enterName.getText()), Double.valueOf(itemSell.getText()), Integer.valueOf(itemQuantity.getText())));
            else if(boxed.isSelected())
                Item.addToInventory(new Boxed(Double.valueOf(itemCost.getText()), String.valueOf(enterDescr.getText()), String.valueOf(enterName.getText()), Double.valueOf(itemSell.getText()), Integer.valueOf(itemQuantity.getText())));
            else
                Item.addToInventory(new Bagged(Double.valueOf(itemCost.getText()), String.valueOf(enterDescr.getText()), String.valueOf(enterName.getText()), Double.valueOf(itemSell.getText()), Integer.valueOf(itemQuantity.getText())));
 
        });
        
        // Edit 
        TextArea listOfItems = new TextArea();
        Label itemEditNum = new Label("Enter ID number of item to edit:");
        TextField itemEditInput = new TextField();
        Button submitIDEdit = new Button("Next");
        
        GridPane listOfCurrentItems = new GridPane();
        
        listOfCurrentItems.add(listOfItems, 1, 1, 3, 1);
        listOfItems.setMinWidth(200);
        listOfItems.setMinHeight(200);
        listOfCurrentItems.add(itemEditNum, 1, 2, 3, 1);
        listOfCurrentItems.add(itemEditInput, 1, 3, 1, 1);
        listOfCurrentItems.add(submitIDEdit, 1, 4);
        listOfCurrentItems.setVgap(20);
        listOfCurrentItems.setHgap(20);
        
        
        Scene editList = new Scene(listOfCurrentItems, 650, 500);
        
        Stage editListStage = new Stage();
        editListStage.setScene(editList);
        
        //First prompt after hitting edit item button
        editItem.setOnAction(e -> {
            
           editListStage.show();
            
        });
        
      
        // edit Window declarations
        Button submitEdit = new Button("Submit");
        GridPane editPane = new GridPane();
        Label editDetails = new Label("Enter Details:");

        Label editName = new Label("Enter Name:");
        TextField editNameBox = new TextField();
        Label editDescription = new Label("Enter Description:");
        TextField editDescrBox = new TextField();
        Label editCost = new Label("Enter Cost:");
        TextField editCostBox = new TextField();
        Label editPrice = new Label("Sell For Cost:");
        TextField editPriceBox = new TextField();
        Label editItemQuant = new Label("Item Quantity:");
        TextField editQuantBox = new TextField();
        
        editPane.add(editDetails, 1, 1);
        editPane.add(editName, 1, 2);
        editPane.add(editNameBox, 2, 2);
        editPane.add(editDescription, 1, 3);
        editPane.add(editDescrBox, 2, 3);
        editPane.add(editCost, 1, 4);
        editPane.add(editCostBox, 2, 4);
        editPane.add(editPrice, 1, 5);
        editPane.add(editPriceBox, 2, 5);
        editPane.add(editItemQuant, 1, 6);
        editPane.add(editQuantBox, 2, 6);
        editPane.add(submitEdit, 1, 7);
        
        editPane.setVgap(30);
        editPane.setHgap(30);
        
        Scene editScene = new Scene(editPane, 500, 500);
        Stage editStage = new Stage();
        editStage.setScene(editScene);
        
        
 
        // action for when user submits an ID
        submitIDEdit.setOnAction(e -> {
            
            //if(itemEditInput.getText() != null) DO SOME SORT OF NULL VALIDATION HERE!!!!!!!!!!!!!
            
            idForEdit = Integer.valueOf(itemEditInput.getText());
            
            // get text from item choice that they want to edit, access the object from the array
            editStage.show();
            
        });
        
        // action for submitting edit (actually edits the item by what ID the user chooses)
        submitEdit.setOnAction(e -> {
            
            Item.inventory.get(idForEdit - 1).setItemCost(Double.valueOf(editCostBox.getText()));
            Item.inventory.get(idForEdit - 1).setItemName(String.valueOf(editNameBox.getText()));
            Item.inventory.get(idForEdit - 1).setItemRetail(Double.valueOf(editPriceBox.getText()));
            Item.inventory.get(idForEdit - 1).setItemQty(Integer.valueOf(editQuantBox.getText()));
            Item.inventory.get(idForEdit - 1).description = String.valueOf(editDescrBox.getText());
   
        });
        


    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
