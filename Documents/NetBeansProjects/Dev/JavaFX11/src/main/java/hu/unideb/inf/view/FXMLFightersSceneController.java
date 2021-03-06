/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.unideb.inf.view;

import hu.unideb.inf.model.Model;
import hu.unideb.inf.model.Fighter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dani
 */
public class FXMLFightersSceneController implements Initializable {

    private Model model;

    public void setModel(Model model) {
        this.model = model;
    }
     @FXML
    private Label name1Label;

    @FXML
    private Label attack1Label;

    @FXML
    private Label defend1Label;

    @FXML
    private Label colorLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private Label creditsLabel;

    @FXML
    private Label bdLabel;

    @FXML
    private TextField newNameTextField;
    
    @FXML
    private ChoiceBox<String> sajat;
    
    @FXML
    private ChoiceBox<String> ellenfel;
    
    ObservableList<String> list = FXCollections.observableArrayList("Akos", "Dominik");
    ObservableList<String> list2 = FXCollections.observableArrayList("Akos", "Dominik");
    
    @FXML
    private void initialize() 
    {
        sajat.setItems(list);
        sajat.setValue("Akos");
        
        ellenfel.setItems(list2);
        ellenfel.setValue("Dominik");
    }
    
    

    @FXML
    void handleLoadButtonPushed() {
        //nameLabel.setText(model.getStudent().getName());
        nameLabel.textProperty().bind(model.getFighter().nameProperty());
        name1Label.textProperty().bind(model.getFighter2().nameProperty());

        creditsLabel.setText("" + model.getFighter().getAttack());
        attack1Label.setText("" + model.getFighter2().getAttack());       
        
        bdLabel.setText(""+model.getFighter().getDefend());
        defend1Label.setText(""+model.getFighter2().getDefend());
    }

    @FXML
    void handleChangeButtonPushed() {
        model.getFighter().setName(newNameTextField.getText());
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Button pushed");
        alert.setHeaderText("You have pushed the Change Name button");
        alert.setContentText("This shows that you have pushed a button...");
        alert.showAndWait();
    }

    @FXML
    void handleSaveToFileButtonPushed() throws IOException {
        try (FileOutputStream fos = new FileOutputStream("fighters.ser");
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(model.getFighter());
        }
    }

    @FXML
    void handleLoadFromFileButtonPushed() throws IOException, ClassNotFoundException {
        try (FileInputStream fis = new FileInputStream("fighters.ser");
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            Fighter s = (Fighter) ois.readObject();
            model.getFighter().setName(s.getName());
            model.getFighter().setDefend(s.getDefend());
            model.getFighter().setAttack(s.getAttack());
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

}
