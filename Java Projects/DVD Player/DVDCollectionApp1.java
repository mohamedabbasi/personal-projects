package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;

public class DVDCollectionApp1  extends Application{
    private final DVDCollection         model;
    private DVDCollectionAppView1 view;

    public DVDCollectionApp1() {
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();
        view = new DVDCollectionAppView1(model);
        aPane.getChildren().add(view);

        view.getButtonPane().getAddButton().setOnAction(event -> handleAddButtonPress());

        view.getButtonPane().getDeleteButton().setOnAction(event -> handleDeleteButtonPress());

        view.getTitleList().setOnMousePressed(event -> handleListClicked(view.getTitleList()));
        view.getYearList().setOnMousePressed(event -> handleListClicked(view.getYearList()));
        view.getLengthList().setOnMousePressed(event -> handleListClicked(view.getLengthList()));

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane));
        primaryStage.show();
    }

    private void handleAddButtonPress() {
        String title  = JOptionPane.showInputDialog("Please enter a title:");
        int year      = Integer.parseInt(JOptionPane.showInputDialog("Please enter a year:"));
        int length    = Integer.parseInt(JOptionPane.showInputDialog("Please enter a duration:"));
        model.add(new DVD(title, year, length));
    }

    private void handleDeleteButtonPress() {
        model.remove(view.getSelectedTitle());
    }

    private void handleListClicked(ListView v) {
        view.update(model, view.getSelectedIndex(v));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
