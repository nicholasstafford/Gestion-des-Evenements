package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Calcule1Controller {

    @FXML
    private Button add;

    @FXML
    private Button div;

    @FXML
    private TextField txt2;

    @FXML
    private Button mul;

    @FXML
    private TextField txt1;

    @FXML
    private Label lblRes;

    @FXML
    private Button sous;


    
    // gestion des entrées numériques pour les textes
    public void checkNum(TextField a)
    {
    	try {
			int nbr = Integer.parseInt(a.getText());
		} catch (NumberFormatException e) 
    	{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Attention - Erreur");
			alert.setTitle("Erreur");
			alert.setContentText("Tu dois écrire un nombre");
			alert.show();
			a.requestFocus();
		}
    }
    @FXML
    void verifText(KeyEvent e)
    {
    	TextField txt = (TextField)e.getSource();
    	checkNum(txt);
    }
    
    @FXML
    void calculs(ActionEvent e)
    {
    	int num1 = Integer.parseInt(txt1.getText());
    	int num2 = Integer.parseInt(txt2.getText());
    	int res = 0;
    	Button btn = (Button)e.getSource();
    	
    	if(btn.getId().equals("add"))
    		res = num1+num2;
    	else
    		if(btn.getId().equals("sous"))
    			res = num1 - num2;
    	else
    		if(btn.getId().equals("mul"))
    			res = num1 * num2;
    	else
    		if(btn.getId().contentEquals("div"))
    			res = num1 / num2;
    	
    	lblRes.setText(Integer.toString(res));
    }

}
