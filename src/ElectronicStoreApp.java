import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ElectronicStoreApp extends Application {
    private ElectronicStore model;
    private ElectronicStoreView view;

    public void start(Stage primaryStage) {
        model = ElectronicStore.createStore();
        view = new ElectronicStoreView(model);
        view.getAddToCartButton().setOnAction(actionEvent -> handleAddToCart());
        view.getRemoveFromCartButton().setOnAction(actionEvent -> handleRemoveFromCart());
        view.getCompleteSaleButton().setOnAction(actionEvent -> handleCompleteSale());
        view.getResetButton().setOnAction(actionEvent -> handleReset(primaryStage));
        view.getStockList().setOnMouseReleased(e -> view.update());
        view.getCartList().setOnMouseReleased(e -> view.update());

        primaryStage.setTitle("Electronic Store Application - " + model.getName());
        primaryStage.setScene(new Scene(view, 800, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
        view.update();
    }
    public void handleAddToCart() {
        Product selection = view.getStockList().getSelectionModel().getSelectedItem();
        model.addToCart(selection);
        view.update();
    }
    public void handleRemoveFromCart() {
        Product selection = view.getCartList().getSelectionModel().getSelectedItem();
        model.removeFromCart(selection);
        view.update();
    }
    public void handleCompleteSale() {
        model.completeSale();
        view.update();
    }
    public void handleReset(Stage stage) {
        start(stage);
    }
}
