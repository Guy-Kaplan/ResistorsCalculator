// Made by Guy Kaplan
import java.util.Scanner; // import Scanner class
import java.util.Arrays; // import Arrays class
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.font.*;
import java.io.*;


public class ResistorsCalculator
{
    public static double r1, r2, r3, totalResistance;
    public static String r1str = "", r2str = "", r3str = "";
    
    public static void main(String[] args)
    {
        // swing = GUI
        Font font1 = new Font("SansSerif", Font.PLAIN, 22);
        // frame
        JFrame frame = new JFrame("Resistors Calculator");//creating instance of JFrame
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        //frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
        frame.pack();
        frame.setLocationRelativeTo(null);
        // text lines
        JLabel firstLine, secondLine, thirdLine;
        // first line
        firstLine = new JLabel("Here you can calculate the total resistance (R)");
        firstLine.setFont(new Font("Serif", Font.PLAIN, 18));
        firstLine.setBounds(25,25,700,30); //x, y, width, height
        frame.add(firstLine);
        // second line
        secondLine = new JLabel("of three resistors connected in parallel:");
        secondLine.setFont(new Font("Serif", Font.PLAIN, 18));
        secondLine.setBounds(50,50,700,30); //x, y, width, height
        frame.add(secondLine);
        // third line - formula
        thirdLine = new JLabel("(1/R) = (1/R1) + (1/R2) + (1/R3)");
        thirdLine.setFont(new Font("Serif", Font.PLAIN, 18));
        thirdLine.setBounds(75,75,700,30); //x, y, width, height
        frame.add(thirdLine);
        // labels (r1,r2,r3)
        JLabel r1Label, r2Label, r3Label, rLabel;
        // r1
        r1Label = new JLabel("R1");
        r1Label.setFont(new Font("Serif", Font.BOLD, 28));
        r1Label.setBounds(70,130,50,30); //x, y, width, height
        frame.add(r1Label);
        // r2
        r2Label = new JLabel("R2");
        r2Label.setFont(new Font("Serif", Font.BOLD, 28));
        r2Label.setBounds(170,130,50,30); //x, y, width, height
        frame.add(r2Label);
        // r3
        r3Label = new JLabel("R3");
        r3Label.setFont(new Font("Serif", Font.BOLD, 28));
        r3Label.setBounds(270,130,50,30); //x, y, width, height
        frame.add(r3Label);
        // text fields (r1,r2,r3)
        // r1
        final JTextField r1TF = new JTextField();
        r1TF.setBounds(62,160,50,30); //x, y, width, height
        r1TF.setFont(font1);
        r1TF.setHorizontalAlignment(JTextField.CENTER);
        r1TF.setText("");
        frame.add(r1TF);
        // r2
        final JTextField r2TF = new JTextField();
        r2TF.setBounds(163,160,50,30); //x, y, width, height
        r2TF.setFont(font1);
        r2TF.setHorizontalAlignment(JTextField.CENTER);
        r2TF.setText("");
        frame.add(r2TF);
        // r3
        final JTextField r3TF = new JTextField();
        r3TF.setBounds(263,160,50,30); //x, y, width, height
        r3TF.setFont(font1);
        r3TF.setHorizontalAlignment(JTextField.CENTER);
        r3TF.setText("");
        frame.add(r3TF);
        // total resistance label
        rLabel = new JLabel("Total Resistance (R)");
        rLabel.setFont(new Font("Serif", Font.BOLD, 28));
        rLabel.setBounds(62,205,700,30); //x, y, width, height
        frame.add(rLabel);
        // total resistance text field
        final JTextField trTF = new JTextField();
        trTF.setEditable(false);
        trTF.setBounds(62,245,245,30); //x, y, width, height
        trTF.setFont(font1);
        trTF.setHorizontalAlignment(JTextField.CENTER);
        frame.add(trTF);
        // buttons
        // calculate button
        JButton calculateBTN = new JButton("Calculate"); //creating instance of JButton  
        calculateBTN.setBounds(77,305,100,30); //x, y, width, height
        calculateBTN.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                    r1str = r1TF.getText();
                    r2str = r2TF.getText();
                    r3str = r3TF.getText();
                    try{
                        r1 = Double.parseDouble(r1str);
                        r2 = Double.parseDouble(r2str);
                        r3 = Double.parseDouble(r3str);
                        if(r1 > 0 && r2 > 0 && r3 > 0 ){
                            trTF.setText(Double.toString(getTotalResistance(r1,r2,r3)));
                        }
                    }    
                    catch(Exception ex){
                        trTF.setText("Error");
                    }
            }  
        });
        frame.add(calculateBTN);
        // clear button
        JButton clearBTN = new JButton("Clear"); //creating instance of JButton  
        clearBTN.setBounds(197,305,100,30); //x, y, width, height
        clearBTN.addActionListener(new ActionListener(){  
            public void actionPerformed(ActionEvent e){
                    r1TF.setText("");
                    r2TF.setText("");
                    r3TF.setText("");
                    trTF.setText("");
            }  
        });
        frame.add(clearBTN);
        // frame
        frame.setSize(400,500);//400 width and 500 height  
        frame.setLayout(null);//using no layout managers  
        frame.setVisible(true);//making the frame visible 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//on close, stop the app from running
    } // end of main
    
    public static double getTotalResistance(double r1, double r2, double r3){
        return 1 / ((1/r1) + (1/r2) + (1/r3));
    }
    
} // end of class ResistorsCalculator
    
