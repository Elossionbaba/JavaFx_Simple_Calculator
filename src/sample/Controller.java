package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML
    public Button one,two,three,four,five,six,seven,eight,nine,zero;
    @FXML
    public Button plus,equalTo,minus,multiply,divide,clear;
    @FXML
    TextField resultBox, inputBox;
    @FXML
    public FlowPane flowPane;
    @FXML
    public WebView webView;
    @FXML
    ImageView label;

    String pre = "";
    private char operator;
    private double a,b;
    private double result;


    @FXML
    public void HandleNumberClick(ActionEvent event){
        String number = ((Labeled)event.getSource()).getText();
        inputBox.setText(inputBox.getText()+number);
        resultBox.setText(resultBox.getText() + number);
        pre = resultBox.getText();
    }

    @FXML
    public void Clear(){
        inputBox.setText("");
        resultBox.setText("");
        pre = "";
    }

    @FXML
    public void Plus(){
        try {
            operator = 1;
            a = Double.parseDouble(inputBox.getText());
            resultBox.setText(resultBox.getText() + " + ");
            pre = resultBox.getText();

        }catch (NumberFormatException e){
            System.out.println("Error ");
        }finally {
            inputBox.setText("");
        }
    }

    @FXML
    public void Minus(){
        try {
            operator = 2;
            a = Double.parseDouble(inputBox.getText());
            resultBox.setText(resultBox.getText() + " - ");
            pre = resultBox.getText();

        }catch (NumberFormatException e){
            System.out.println("Error ");
        }finally {
            inputBox.setText("");
        }
    }

    @FXML
    public void Multiply(){
        try {
            operator = 3;
            a = Double.parseDouble(inputBox.getText());
            resultBox.setText(resultBox.getText() + " * ");
            pre = resultBox.getText();

        }catch (NumberFormatException e){
            System.out.println("Error ");
        }finally {
            inputBox.setText("");
        }
    }

    @FXML
    public void SqRoot(){
        try {
            operator = 4;
            a = Double.parseDouble(inputBox.getText());
            resultBox.setText(resultBox.getText() + "^");
            pre = resultBox.getText();

        }catch (NumberFormatException e){
            System.out.println("Error ");
        }finally {
            inputBox.setText("");
        }
    }

    @FXML
    public void Loc(){
        try {
            operator = 5;
            a = Double.parseDouble(inputBox.getText());
            resultBox.setText( "loc("+resultBox.getText());
            pre = resultBox.getText();

        }catch (NumberFormatException e){
            System.out.println("Error ");
        }finally {
            inputBox.setText("");
        }
    }

    @FXML
    public void Divide(){
        try {
            operator = 6;
            a = Double.parseDouble(inputBox.getText());
            resultBox.setText(resultBox.getText() + " / ");
            pre = resultBox.getText();

        }catch (NumberFormatException e){
            System.out.println("Error ");
        }finally {
            inputBox.setText("");
        }
    }


    @FXML
    private void HandleEqual(){
        try {

            b = Double.parseDouble(inputBox.getText());

            switch (operator){
                case 1: result = a+b; inputBox.setText("" + result +"");break;
                case 2: result = a-b; inputBox.setText("" + result +"");break;
                case 3: result = a*b; inputBox.setText("" + result +"");break;
                case 4: result = Math.sqrt(a); inputBox.setText("" + result + "");break;
                case 5: result = Math.log(a); inputBox.setText("" + result + "");break;
                case 6:try {
                    result = a/b;inputBox.setText("" + result +"");break;


                }catch (NumberFormatException e){
                    System.out.println(b+ " can't divide "+ a);
                }
                default:
                    System.out.println("Select value first");

            }

        }catch (NumberFormatException e){
            inputBox.setText("Enter your operator");
        }
            resultBox.setText(pre + "");
    }


    @FXML
    public void DialogView(){
        WebEngine engine = webView.getEngine();

    }




    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
