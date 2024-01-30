package controllers;

import models.ItemList;
import views.GroceryView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GroceryController {
	
	private ItemList model;
	private GroceryView gv;

	public GroceryController(ItemList _m, GroceryView _gv) {
		model = _m;
		gv = _gv;	
	}

	public void handleNewTextField() {
		gv.getNewItemField().setOnKeyPressed(e -> {
			gv.getAddButton().setDisable(gv.getNewItemField().getText().trim().length() <= 0);
		});
	}
	
	public void handleAddButton() {
		gv.getAddButton().setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				String temp = gv.getNewItemField().getText().trim();
				if (temp.length() > 0) {
					model.add(temp);
					gv.updateList();
				}
				gv.getNewItemField().clear();
			}
		});
	}
	
	public void handleRemoveButton() {
		gv.getRemoveButton().setOnAction(e -> {
			int selectedIndex = gv.getFruitList().getSelectionModel().getSelectedIndex();
			if (selectedIndex >= 0) {
				model.remove(selectedIndex);
				gv.updateList();
			}
		});
	}
	
	public void handleFruitList() {
		gv.getFruitList().setOnMousePressed(e -> {
			gv.updateList();
		});
	}
}
