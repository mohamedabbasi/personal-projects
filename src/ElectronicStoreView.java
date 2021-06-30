import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class ElectronicStoreView extends Pane {
    private final Label sectionThree;

    // Buttons
    private final Button resetButton;
    private final Button addToCartButton;
    private final Button removeFromCartButton;
    private final Button completeSaleButton;

    // Text Fields
    private final TextField salesText;
    private final TextField revenueText;
    private final TextField saleText;

    // ListViews
    private final ListView<Product> popularList = new ListView<>();
    private final ListView<Product> stockList = new ListView<>();
    private final ListView<Product> cartList = new ListView<>();

    // Model
    private final ElectronicStore model;

    public ElectronicStoreView(ElectronicStore initModel) {
        this.model = initModel;

        // Labels;
        final Label sectionOne = new Label("Store Summary:");
        sectionOne.relocate(50, 23);
        final Label sectionOneSales = new Label("# Sales:");
        sectionOneSales.relocate(50, 65);
        final Label sectionOneRevenue = new Label("Revenue:");
        sectionOneRevenue.relocate(50, 105);
        final Label sectionOneSale;
        sectionOneSale = new Label("$ / Sale:");
        sectionOneSale.relocate(50, 145);
        final Label sectionOneItems = new Label("Most Popular Items:");
        sectionOneItems.relocate(80, 180);

        // Section one buttons
        resetButton = new Button("Reset Store");
        resetButton.relocate(90, 350);

        // Section one TextField
        salesText = new TextField("0");
        salesText.relocate(120, 60);
        salesText.setPrefSize(90, 25);
        salesText.setEditable(false);
        revenueText = new TextField("0.00");
        revenueText.relocate(120, 100);
        revenueText.setPrefSize(90, 25);
        revenueText.setEditable(false);
        saleText = new TextField("0.00");
        saleText.relocate(120, 140);
        saleText.setPrefSize(90, 25);
        saleText.setEditable(false);

        // Section one ListView
        popularList.relocate(50, 200);
        popularList.setPrefSize(165, 125);

        // Section two labels
        final Label sectionTwo = new Label("Store Stock:");
        sectionTwo.relocate(315, 20);

        // Section two buttons
        addToCartButton = new Button("Add to Cart");
        addToCartButton.relocate(325, 350);

        // Section two ListView
        stockList.relocate(230, 40);
        stockList.setPrefSize(260, 285);

        // Section three labels
        sectionThree = new Label(String.format("Current Cart ($ %.2f): ", model.getCartWorth()));
        sectionThree.relocate(570, 20);

        // Section three buttons
        removeFromCartButton = new Button("Remove from Cart");
        removeFromCartButton.relocate(525, 350);
        completeSaleButton = new Button("Complete Sale");
        completeSaleButton.relocate(650, 350);

        // Section three ListView
        cartList.relocate(500, 40);
        cartList.setPrefSize(270, 285);

        // Add labels to window
        getChildren().addAll(sectionOne, sectionOneSales, sectionOneRevenue, sectionOneSale, sectionOneItems, sectionTwo, sectionThree);
        // Add buttons to window
        getChildren().addAll(resetButton, addToCartButton, removeFromCartButton, completeSaleButton);
        // Add TextFields to window
        getChildren().addAll(salesText, revenueText, saleText);
        // Add ListViews to window
        getChildren().addAll(popularList, stockList, cartList);
    }

    // Getters
    public Button getResetButton() {
        return resetButton;
    }
    public Button getAddToCartButton() {
        return addToCartButton;
    }
    public Button getRemoveFromCartButton() {
        return removeFromCartButton;
    }
    public Button getCompleteSaleButton() {
        return completeSaleButton;
    }
    public ListView<Product> getStockList() {
        return stockList;
    }
    public ListView<Product> getCartList() {
        return cartList;
    }

    // To refresh and update the screen
    public void update() {
        // Update text
        sectionThree.setText(String.format("Current Cart ($ %.2f): ", model.getCartWorth()));
        salesText.setText(String.format("%d", model.getTotalSales()));
        revenueText.setText(String.format("%.2f", model.getRevenue()));

        double averageRevenue;
        if (model.getRevenue() == 0 && model.getTotalSales() == 0 | model.getTotalSales() == 0) {
            averageRevenue = 0.0;
        } else {
            averageRevenue = model.getRevenue() / model.getTotalSales();
        }
        saleText.setText(String.format("%.2f", averageRevenue));

        // Update ListViews
        ObservableList<Product> popularObservableList = FXCollections.observableArrayList(model.getPopular());
        popularList.setItems(popularObservableList);
        ObservableList<Product> stockObservableList = FXCollections.observableArrayList(model.getStockItems());
        stockList.setItems(stockObservableList);
        ObservableList<Product> stockCartObservableList = FXCollections.observableArrayList(model.getCartItems());
        cartList.setItems(stockCartObservableList);

        // Update buttons
        int cartSelection = stockList.getSelectionModel().getSelectedIndex();
        addToCartButton.setDisable(cartSelection == -1);
        int removeFromCart = cartList.getSelectionModel().getSelectedIndex();
        removeFromCartButton.setDisable(removeFromCart == -1);
        completeSaleButton.setDisable(cartList.getItems().size() == 0);
    }
}
