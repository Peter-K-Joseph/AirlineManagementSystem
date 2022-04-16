/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlinemanagementsystem;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author peter
 */

class alertBox
{
    alertBox(String infoMessage, String titleBar, int i)
    {
        switch (i) {
            case 0: JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.ERROR_MESSAGE);
                    break;
            case 1: JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.WARNING_MESSAGE);
                    break;
            case 2: JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
                    break;
        }
    }
}