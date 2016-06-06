package Ejecucion;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Beat.DJTestDrive;
import Heart.HeartTestDrive;
import Operacion.HeartDescTestDrive;
import Operacion.OperacionTestDrive;
import Strategy.StrategyTestDrive;
 
public class Ejecucion implements ActionListener{//implementando el listener de eventos
 
    JPanel jp1, jp2, jp3;

    JButton jb1, jb2, jb3, jb4, jb5, jbP1, jbP2, jbP3;   
 
    public Ejecucion(){
 
        JFrame jfM = new JFrame("Trabajo Final 2016");  
        jfM.setLayout(null);
 
 
        gridJP(); //invocamos los metodos que contienen los paneles 
 
 
        jp1.setBounds(10, 10, 200, 200);
 
        jfM.add(jp1); 
 
        jfM.setLocation(100, 50);
        jfM.setResizable(false);
        jfM.setVisible(true);
        jfM.setSize(225, 250);
        jfM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
 
    public void gridJP(){
 
        jp1 = new JPanel(new GridLayout(5, 1, 5, 7));//filas, columnas, espacio entre filas, espacio entre columnas
 
        jb1= new JButton("Beat"); jb2= new JButton("Heart"); jb3= new JButton("Heart Desc"); jb4= new JButton("Operacion"); jb5= new JButton("Strategy");//creamos los objetos para el panel
 
        jp1.add(jb1); jp1.add(jb2); jp1.add(jb3); jp1.add(jb4); jp1.add(jb5);//añadimos los objetos al jpanel
 
        jb1.addActionListener(this); jb2.addActionListener(this); jb3.addActionListener(this); jb4.addActionListener(this); jb5.addActionListener(this);
 
        jp1.setVisible(true);
    }
 
 
    public static void main(String[] args) {        
        Ejecucion gj = new Ejecucion();//uso de constructor para la ventana
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {//sobreescribimos el metodo del listener
        if(e.getSource() == jb1){
        	DJTestDrive.play();
        	/*if(jp1.isVisible()){
                jp1.setVisible(false);
                DJTestDrive.play();
            }else
                jp1.setVisible(true);*/          	
        }
        else if(e.getSource() == jb2){
        	HeartTestDrive.play();
        	/*if(jp2.isVisible()){
                jp2.setVisible(false);
                //HeartTestDrive.play();
            }else
                jp2.setVisible(true);*/
 
        }
        else if(e.getSource() == jb3){
        	HeartDescTestDrive.play();
        	/*if(jp3.isVisible()){
                jp3.setVisible(false);
            }else
                jp3.setVisible(true);*/
 
        }
        else if(e.getSource() == jb4){
        	OperacionTestDrive.play();
        	/*if(jp3.isVisible()){
                jp3.setVisible(false);
            }else
                jp3.setVisible(true);*/
 
        }
        else if(e.getSource() == jb5){
        	StrategyTestDrive.play();
        	/*if(jp3.isVisible()){
                jp3.setVisible(false);
            }else
                jp3.setVisible(true);*/
 
        }
        else{
            JOptionPane.showMessageDialog(null, e.getActionCommand());
        }
    }
}