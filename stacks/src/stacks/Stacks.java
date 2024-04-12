/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stacks;

import javax.swing.JOptionPane;

/**
 *
 * @author anonza
 */
public class Stacks {

    public static class Car{
            
        String carReg,parkingBay;
        int carVal;
        Car previous; //memory address that will be used by pointers
        
        public static Car newNode, behind = null;
        
        //create a stack
       
        public static void createStack(){
            
            String tmpReg = JOptionPane.showInputDialog(null, "Temp reg:");
            
            while(tmpReg.compareTo(" ") != 0){
                
                newNode = new Car();
                
                newNode.carReg = tmpReg;   
                newNode.parkingBay= JOptionPane.showInputDialog(null, 
                        "parking bay:"); 
                newNode.carVal = Integer.parseInt(JOptionPane.showInputDialog(
                        null, "Car val:")); 
                
                newNode.previous = behind;
                behind = newNode;
                
                tmpReg = JOptionPane.showInputDialog(null, "Temp reg:");
            }
        }
        
        //display captured data
        public static void display(){
            do{
                System.out.println(behind.carReg + "\t" + behind.parkingBay +
                        "\t" + behind.carVal);
                behind = behind.previous;
            }
            while(behind.previous != null);
        }
    }
    public static void main(String[] args) {
        Car.createStack();
        Car.display();
    }
    
}
