import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureConverter implements ActionListener{
    JFrame frame;
    JTextField textfield, convertedfield;
    JButton converterToFahrenheitButton,  convertToCelsiusButton ;
    Font myFont = new Font("Times new roman", Font.BOLD, 30);


    TemperatureConverter(){
        frame = new JFrame("Simple Temperature Converter");;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,110);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(20,10,150,50);
        textfield.setFont(myFont);

        convertedfield = new JTextField();
        convertedfield.setBounds(380,10,270,50);
        convertedfield.setFont(myFont);
        convertedfield.setEditable(false);

        convertToCelsiusButton = new JButton("C");
        convertToCelsiusButton.setBounds(190, 10, 65,50);
        convertToCelsiusButton.setFont(myFont);

        converterToFahrenheitButton = new JButton("F");
        converterToFahrenheitButton.setBounds(275, 10, 65,50);
        converterToFahrenheitButton.setFont(myFont);

        frame.add(converterToFahrenheitButton);
        frame.add(convertToCelsiusButton);
        frame.add(textfield);
        frame.add(convertedfield);

        converterToFahrenheitButton.addActionListener(this);
        converterToFahrenheitButton.setFocusable(false);
        convertToCelsiusButton.addActionListener(this);
        convertToCelsiusButton.setFocusable(false);

        frame.setVisible(true);
    }

    public static void main(String[] args){
        TemperatureConverter temperatureconverter = new TemperatureConverter();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == converterToFahrenheitButton){
            if(textfield.getText().contains("F") || textfield.getText().contains("f")){
                convertedfield.setText(textfield.getText());

            }
            else if(textfield.getText().contains("C") || textfield.getText().contains("c")){
                String[] tmparray0 = textfield.getText().split(" ");
                if(tmparray0[0].equals("0")){
                    convertedfield.setText("32");
                }
                else{
                    String[] tmparray = textfield.getText().split(" ");
                    double tmp = Double.parseDouble(tmparray[0]);
                    double celsiustofahr = tmp * 1.8 + 32;
                    convertedfield.setText(celsiustofahr + "F");
                }
            }
            else{
                convertedfield.setText("Temperature type is not given!");
            }

        }

        if(e.getSource() == convertToCelsiusButton){
            if(textfield.getText().contains("C") || textfield.getText().contains("c")){
                convertedfield.setText(textfield.getText());

            }
            else if(textfield.getText().contains("F") || textfield.getText().contains("f")){
                String[] tmparray0 = textfield.getText().split(" ");
                if(tmparray0[0].equals("0")){
                    convertedfield.setText("-17.7777778 C");

                }
                else{
                    String[] tmparray = textfield.getText().split(" ");
                    double tmp = Double.parseDouble(tmparray[0]);
                    double celsiustofahr = tmp * 1.8 + 32;
                    convertedfield.setText(celsiustofahr + "C");
                }
            }
            else{
                convertedfield.setText("Temperature type is not given!");
            }

        }
    }
}
