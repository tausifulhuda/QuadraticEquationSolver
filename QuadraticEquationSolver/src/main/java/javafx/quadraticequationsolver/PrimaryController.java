package javafx.quadraticequationsolver;

import java.io.IOException;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private TextField a;
    @FXML
    private TextField b;
    @FXML
    private TextField c;
    @FXML
    private TextField d;
    @FXML
    private Button solve;
    @FXML
    private Button graph;
    @FXML
    private Button clear;
    @FXML
    private Label x;
    
    double a1,b1,c1,d1,x1,x2;
    
    public void initialize(){
        graph.setDisable(true);
    }
    
    public void solve(ActionEvent e){
        graph.setDisable(false);
        clear.setDisable(false);
        try{                      
            if(a.getText().isEmpty())a1=0;
            else a1=Double.parseDouble(a.getText());
            
            if(b.getText().isEmpty())b1=0;
            else b1=Double.parseDouble(b.getText());
            
            if(c.getText().isEmpty())c1=0;
            else c1=Double.parseDouble(c.getText());
            
            if(d.getText().isEmpty())d1=0;
            else d1=Double.parseDouble(d.getText());
            
            if(a1==0 && b1==0)
                x.setText("Not a valid equation");
            else if((b1*b1-4*a1*(c1-d1))>=0){
                if(a1==0){
                    x.setText("x = "+formatDouble((d1-c1)/b1));
                }  
                else{
                    x1=(-b1+Math.sqrt((b1*b1)-(4*a1*(c1-d1))))/(2*a1);
                    x2=(-b1-Math.sqrt((b1*b1)-(4*a1*(c1-d1))))/(2*a1);
                    x.setText("x = "+formatDouble(x1)+", "+formatDouble(x2));
                }
            }
            else
                x.setText("x is not a real number.");
        }
        catch(NumberFormatException exp){
            a.clear();
            b.clear();
            c.clear();
            d.clear();
            x.setText("Enter numbers only.");
            graph.setDisable(true);
        }
        catch(Exception exp){
            x.setText("Error!");
            graph.setDisable(true);
        }
    }
    public void openWebpage(String url) throws IOException {
        try {
            Desktop desktop = Desktop.getDesktop();
            URI uri = new URI(url);
            desktop.browse(uri);
        } catch (URISyntaxException e) {
            x.setText("Error in generating graph.");
        }
    }
    public void graph(ActionEvent e) throws IOException{
        String web="https://www.wolframalpha.com/input?i=graphing+calculator&assumption=%7B%22C%22%2C+%22graphing+calculator%22%7D+-%3E+%7B%22Calculator%22%2C+%22dflt%22%7D&assumption=%22FSelect%22+-%3E+%7B%7B%22Plot%22%7D%2C+%22dflt%22%7D&assumption=%7B%22F%22%2C+%22Plot%22%2C+%22plotfunction%22%7D+-%3E%22"+Double.toString(a1)+"x%5E2%2B"+Double.toString(b1)+"x%2B"+Double.toString(c1-d1)+"%22";
        openWebpage(web);
    } 
    public void clear(ActionEvent e){
        a.clear();
        b.clear();
        c.clear();
        d.clear();
        x.setText("");
        graph.setDisable(true);
    }
    public String formatDouble(double number) {
        DecimalFormat df = new DecimalFormat("0.#####"); // Up to 5 decimal places, no trailing zeros
        return df.format(number);
    }
}
