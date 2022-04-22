/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airlinemanagementsystem;

/**
 *
 * @author peter
 */
public class AirlineManagementSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrentTimeAndDate().setVisible(true);
                new loginForm().setVisible(true);
            }
        });
    }
}
