package views;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import models.ItemList;

public class GroceryView extends Pane {

	private ItemList model;

	private ListView<String> fruitList;
	private TextField newItemField;
	private Button addButton;
	private Button removeButton;
	
	public GroceryView(ItemList m) {
		model = m;
		
		newItemField = new TextField();			// the Text Input Field
		newItemField.relocate(10, 10);
		newItemField.setPrefSize(150, 25);

		addButton = new Button("Add");			// the Add Button
		addButton.relocate(175, 10);
		addButton.setPrefSize(100, 25);

		removeButton = new Button("Remove");	// the Remove Button
		removeButton.relocate(175, 45);
		removeButton.setPrefSize(100, 25);

		fruitList = new ListView<String>();		// the Fruit List
		fruitList.relocate(10, 45);
		fruitList.setPrefSize(150, 150);
		
		getChildren().addAll(newItemField, addButton, removeButton, fruitList);
		updateList();

	}
	
	public TextField getNewItemField() {
		return newItemField;
	}

	public Button getAddButton() {
		return addButton;
	}

	public Button getRemoveButton() {
		return removeButton;
	}

	public ListView<String> getFruitList() {
		return fruitList;
	}

	public void updateList() {
		String[] exactList = new String[model.getSize()];
		
		for(int i=0; i < model.getSize(); i++) {
			exactList[i] = model.getItems()[i];
		}
		
		int selectedIndex = fruitList.getSelectionModel().getSelectedIndex();
		fruitList.getSelectionModel().select(selectedIndex);
		fruitList.setItems(FXCollections.observableArrayList(exactList));
		
		addButton.setDisable(newItemField.getText().trim().length() <= 0);
		removeButton.setDisable(fruitList.getSelectionModel().getSelectedIndex() < 0);
	}

}
