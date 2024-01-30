package application;

import controllers.GroceryController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.ItemList;
import views.GroceryView;

public class Main extends Application {
	
	private ItemList model;
	private GroceryView gv;
	private GroceryController gc;
	

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage st) throws Exception {
		model = new ItemList();
		gv = new GroceryView(model);
		gc = new GroceryController(model, gv);

		gc.handleNewTextField();
		gc.handleAddButton();
		gc.handleRemoveButton();
		gc.handleFruitList();
		
		st.setResizable(false);
		st.setTitle("Grocery List");
		st.setScene(new Scene(gv, 300, 300));
		st.show();
	}

}
