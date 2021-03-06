/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airlinemanagementsystem;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Sandra
 */
public class CurrentTimeAndDate extends javax.swing.JFrame {

    /**
     * Creates new form CurrentTimeAndDate
     */
    public CurrentTimeAndDate() {
        initComponents();
        String sql = "select * from flightplans where time>= now() ORDER BY TIME limit 5;";
        class updateFlightState extends TimerTask {
            @Override
            public void run() {
                try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "sysadmin", "peter@2002");
                conn.createStatement().executeUpdate("use nuvieliv_airlinemanagement");
                PreparedStatement ps = conn.prepareStatement(sql);
                Date dt = new Date();
                ResultSet rs = ps.executeQuery();
                Component[] FlightCodes = new Component[] {flightCode_1, flightCode_2, flightCode_3, flightCode_4, flightCode_5};
                Component[] arrivalStatus = new Component[] {arrivalStatus_1, arrivalStatus_2, arrivalStatus_3, arrivalStatus_4, arrivalStatus_5};
                Component[] dateAndTime = new Component[] {dateAndTime_1, dateAndTime_2, dateAndTime_3, dateAndTime_4, dateAndTime_5};
                Component[] statusOfFlight = new Component[] { statusOfFlight_1, statusOfFlight_2, statusOfFlight_3, statusOfFlight_4, statusOfFlight_5};                
                int x = 0;
                if (rs.next() == true) {
                    flightCode_1.setText(rs.getString("FLIGHT_CODE"));
                    statusOfFlight_1.setText(statusOfFlight(rs.getString("IS_CANCELLED")));
                    statusOfFlight_1.setForeground(getStatusIndicator(rs.getString("IS_CANCELLED")));
                    dateAndTime_1.setText(rs.getString("Time"));
                    arrivalStatus_1.setText(arrivalStatus(rs.getString("MODE")));
                } else {
                    flightCode_1.setText("");
                    statusOfFlight_1.setText("");
                    dateAndTime_1.setText("");
                    arrivalStatus_1.setText("");
                }
                if (rs.next() == true) {
                    flightCode_2.setText(rs.getString("FLIGHT_CODE"));
                    statusOfFlight_2.setText(statusOfFlight(rs.getString("IS_CANCELLED")));
                    statusOfFlight_2.setForeground(getStatusIndicator(rs.getString("IS_CANCELLED")));
                    dateAndTime_2.setText(rs.getString("Time"));
                    arrivalStatus_2.setText(arrivalStatus(rs.getString("MODE")));
                } else {
                    flightCode_2.setText("");
                    statusOfFlight_2.setText("");
                    dateAndTime_2.setText("");
                    arrivalStatus_2.setText("");
                }
                if (rs.next() == true) {
                    flightCode_3.setText(rs.getString("FLIGHT_CODE"));
                    statusOfFlight_3.setForeground(getStatusIndicator(rs.getString("IS_CANCELLED")));
                    statusOfFlight_3.setText(statusOfFlight(rs.getString("IS_CANCELLED")));
                    dateAndTime_3.setText(rs.getString("Time"));
                    arrivalStatus_3.setText(arrivalStatus(rs.getString("MODE")));
                } else {
                    flightCode_3.setText("");
                    statusOfFlight_3.setText("");
                    dateAndTime_3.setText("");
                    arrivalStatus_3.setText("");
                }
                if (rs.next() == true) {
                    flightCode_4.setText(rs.getString("FLIGHT_CODE"));
                    statusOfFlight_4.setForeground(getStatusIndicator(rs.getString("IS_CANCELLED")));
                    statusOfFlight_4.setText(statusOfFlight(rs.getString("IS_CANCELLED")));
                    dateAndTime_4.setText(rs.getString("Time"));
                    arrivalStatus_4.setText(arrivalStatus(rs.getString("MODE")));
                } else {
                    flightCode_4.setText("");
                    statusOfFlight_4.setText("");
                    dateAndTime_4.setText("");
                    arrivalStatus_4.setText("");
                }
                if (rs.next() == true) {
                    flightCode_5.setText(rs.getString("FLIGHT_CODE"));
                    statusOfFlight_5.setForeground(getStatusIndicator(rs.getString("IS_CANCELLED")));
                    statusOfFlight_5.setText(statusOfFlight(rs.getString("IS_CANCELLED")));
                    dateAndTime_5.setText(rs.getString("Time"));
                    jLabel8.setText(arrivalStatus(rs.getString("MODE")));
                } else {
                    flightCode_5.setText("");
                    statusOfFlight_5.setText("");
                    dateAndTime_5.setText("");
                    jLabel8.setText("");
                }
                conn.close();
            } catch (Exception e) {
                new alertBox("Unknown Error Occurred: " + e, "System Failure", 0);
            }
            }
        }

        Timer timer = new Timer();
        timer.schedule(new updateFlightState(), 0, 5000);
    }
     
    private String arrivalStatus(String q )
    {
        switch (q)
        {
            case "0":
                return "Arrival";
            case "1":
                return "Departure";
            default: return "";
        }
    }
    private java.awt.Color getStatusIndicator(String i) {
        switch (i) {
            case "0": 
                return new java.awt.Color(0, 255, 0);
            case "1": 
                return new java.awt.Color(255, 255, 0);
            case "2": 
                return new java.awt.Color(255, 0, 0);
            default: return new java.awt.Color(0, 0, 0);
        }
    }
    private String statusOfFlight(String i ) 
    {
        switch (i)
                {
            case "0": 
                return "ON TIME";
            case "1": 
                return "DELAY";
            case "2": 
                return "CANCELLED";
            default: return "";
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        IsState5 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        IsState6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        IsState7 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        IsState9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        presentDateAndTime = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        flightCode_1 = new javax.swing.JLabel();
        arrivalStatus_1 = new javax.swing.JLabel();
        dateAndTime_1 = new javax.swing.JLabel();
        statusOfFlight_1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        flightCode_2 = new javax.swing.JLabel();
        arrivalStatus_2 = new javax.swing.JLabel();
        dateAndTime_2 = new javax.swing.JLabel();
        statusOfFlight_2 = new javax.swing.JLabel();
        arrivalStatus_5 = new javax.swing.JPanel();
        flightCode_5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        dateAndTime_5 = new javax.swing.JLabel();
        statusOfFlight_5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        flightCode_3 = new javax.swing.JLabel();
        arrivalStatus_3 = new javax.swing.JLabel();
        dateAndTime_3 = new javax.swing.JLabel();
        statusOfFlight_3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        flightCode_4 = new javax.swing.JLabel();
        arrivalStatus_4 = new javax.swing.JLabel();
        dateAndTime_4 = new javax.swing.JLabel();
        statusOfFlight_4 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("3:20 AM | 3/5/2022");

        jLabel22.setText("jLabel13");

        jPanel7.setBackground(new java.awt.Color(50, 50, 50));

        jLabel23.setBackground(new java.awt.Color(0, 0, 0));
        jLabel23.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("G8-6045");

        jLabel24.setBackground(new java.awt.Color(0, 0, 0));
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Arriving from COK");

        jLabel25.setBackground(new java.awt.Color(0, 0, 0));
        jLabel25.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("2022-04-22 16:46");

        IsState5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        IsState5.setForeground(new java.awt.Color(255, 255, 0));
        IsState5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IsState5.setText("LATE");

        jLabel26.setText("jLabel13");

        jPanel8.setBackground(new java.awt.Color(50, 50, 50));

        jLabel27.setBackground(new java.awt.Color(0, 0, 0));
        jLabel27.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("G8-6045");

        jLabel28.setBackground(new java.awt.Color(0, 0, 0));
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Arriving from COK");

        jLabel29.setBackground(new java.awt.Color(0, 0, 0));
        jLabel29.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("2022-04-22 16:46");

        IsState6.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        IsState6.setForeground(new java.awt.Color(255, 255, 0));
        IsState6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IsState6.setText("LATE");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addGap(85, 85, 85)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(93, 93, 93)
                .addComponent(IsState6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29)
                    .addComponent(IsState6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23)
                .addGap(85, 85, 85)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(93, 93, 93)
                .addComponent(IsState5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel25)
                    .addComponent(IsState5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(96, 96, 96)
                    .addComponent(jLabel26)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jPanel9.setBackground(new java.awt.Color(50, 50, 50));

        jLabel31.setBackground(new java.awt.Color(0, 0, 0));
        jLabel31.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("G8-6045");

        jLabel32.setBackground(new java.awt.Color(0, 0, 0));
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Arriving from COK");

        jLabel33.setBackground(new java.awt.Color(0, 0, 0));
        jLabel33.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("2022-04-22 16:46");

        IsState7.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        IsState7.setForeground(new java.awt.Color(255, 255, 0));
        IsState7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IsState7.setText("LATE");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addGap(85, 85, 85)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addGap(93, 93, 93)
                .addComponent(IsState7, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel33)
                    .addComponent(IsState7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(50, 50, 50));

        jLabel37.setBackground(new java.awt.Color(0, 0, 0));
        jLabel37.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("G8-6045");

        jLabel38.setBackground(new java.awt.Color(0, 0, 0));
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Arriving from COK");

        jLabel39.setBackground(new java.awt.Color(0, 0, 0));
        jLabel39.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("2022-04-22 16:46");

        IsState9.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        IsState9.setForeground(new java.awt.Color(255, 255, 0));
        IsState9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IsState9.setText("LATE");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addGap(85, 85, 85)
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(93, 93, 93)
                .addComponent(IsState9, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39)
                    .addComponent(IsState9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(java.awt.Color.darkGray);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        presentDateAndTime.setBackground(new java.awt.Color(0, 0, 0));
        presentDateAndTime.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        presentDateAndTime.setForeground(new java.awt.Color(255, 255, 255));
        presentDateAndTime.setText("");
        class updateTimer extends TimerTask{
            @Override
            public void run(){
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                presentDateAndTime.setText(dtf.format(now));

            }
        }
        Timer timer = new Timer();
        timer.schedule(new updateTimer(),0,1000);

        jPanel2.setBackground(new java.awt.Color(50, 50, 50));

        flightCode_1.setBackground(new java.awt.Color(0, 0, 0));
        flightCode_1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        flightCode_1.setForeground(new java.awt.Color(255, 255, 255));
        flightCode_1.setText("G8-6045");

        arrivalStatus_1.setBackground(new java.awt.Color(0, 0, 0));
        arrivalStatus_1.setForeground(new java.awt.Color(255, 255, 255));
        arrivalStatus_1.setText("Arriving from COK");

        dateAndTime_1.setBackground(new java.awt.Color(0, 0, 0));
        dateAndTime_1.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        dateAndTime_1.setForeground(new java.awt.Color(255, 255, 255));
        dateAndTime_1.setText("2022-04-22 16:46");

        statusOfFlight_1.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        statusOfFlight_1.setForeground(new java.awt.Color(255, 0, 0));
        statusOfFlight_1.setText("CANCELLED");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(flightCode_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arrivalStatus_1)
                .addGap(136, 136, 136)
                .addComponent(dateAndTime_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusOfFlight_1)
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(arrivalStatus_1)
                            .addComponent(flightCode_1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dateAndTime_1)
                        .addComponent(statusOfFlight_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(50, 50, 50));

        flightCode_2.setBackground(new java.awt.Color(0, 0, 0));
        flightCode_2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        flightCode_2.setForeground(new java.awt.Color(255, 255, 255));
        flightCode_2.setText("G8-6045");

        arrivalStatus_2.setBackground(new java.awt.Color(0, 0, 0));
        arrivalStatus_2.setForeground(new java.awt.Color(255, 255, 255));
        arrivalStatus_2.setText("Arriving from COK");

        dateAndTime_2.setBackground(new java.awt.Color(0, 0, 0));
        dateAndTime_2.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        dateAndTime_2.setForeground(new java.awt.Color(255, 255, 255));
        dateAndTime_2.setText("2022-04-22 16:46");

        statusOfFlight_2.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        statusOfFlight_2.setForeground(new java.awt.Color(0, 255, 0));
        statusOfFlight_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusOfFlight_2.setText("ON TIME");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(flightCode_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arrivalStatus_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateAndTime_2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusOfFlight_2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flightCode_2)
                    .addComponent(arrivalStatus_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateAndTime_2)
                    .addComponent(statusOfFlight_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        arrivalStatus_5.setBackground(new java.awt.Color(50, 50, 50));

        flightCode_5.setBackground(new java.awt.Color(0, 0, 0));
        flightCode_5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        flightCode_5.setForeground(new java.awt.Color(255, 255, 255));
        flightCode_5.setText("G8-6045");

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Arriving from COK");

        dateAndTime_5.setBackground(new java.awt.Color(0, 0, 0));
        dateAndTime_5.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        dateAndTime_5.setForeground(new java.awt.Color(255, 255, 255));
        dateAndTime_5.setText("2022-04-22 16:46");

        statusOfFlight_5.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        statusOfFlight_5.setForeground(new java.awt.Color(255, 255, 0));
        statusOfFlight_5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusOfFlight_5.setText("LATE");

        javax.swing.GroupLayout arrivalStatus_5Layout = new javax.swing.GroupLayout(arrivalStatus_5);
        arrivalStatus_5.setLayout(arrivalStatus_5Layout);
        arrivalStatus_5Layout.setHorizontalGroup(
            arrivalStatus_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(arrivalStatus_5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(flightCode_5)
                .addGap(136, 136, 136)
                .addComponent(jLabel8)
                .addGap(136, 136, 136)
                .addComponent(dateAndTime_5)
                .addGap(137, 137, 137)
                .addComponent(statusOfFlight_5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        arrivalStatus_5Layout.setVerticalGroup(
            arrivalStatus_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(arrivalStatus_5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(arrivalStatus_5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flightCode_5)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateAndTime_5)
                    .addComponent(statusOfFlight_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("SCHEDULED FLIGHT LIST");

        jPanel5.setBackground(new java.awt.Color(50, 50, 50));

        flightCode_3.setBackground(new java.awt.Color(0, 0, 0));
        flightCode_3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        flightCode_3.setForeground(new java.awt.Color(255, 255, 255));
        flightCode_3.setText("G8-6045");

        arrivalStatus_3.setBackground(new java.awt.Color(0, 0, 0));
        arrivalStatus_3.setForeground(new java.awt.Color(255, 255, 255));
        arrivalStatus_3.setText("Arriving from COK");

        dateAndTime_3.setBackground(new java.awt.Color(0, 0, 0));
        dateAndTime_3.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        dateAndTime_3.setForeground(new java.awt.Color(255, 255, 255));
        dateAndTime_3.setText("2022-04-22 16:46");

        statusOfFlight_3.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        statusOfFlight_3.setForeground(new java.awt.Color(255, 255, 0));
        statusOfFlight_3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusOfFlight_3.setText("LATE");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(flightCode_3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arrivalStatus_3)
                .addGap(136, 136, 136)
                .addComponent(dateAndTime_3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusOfFlight_3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flightCode_3)
                    .addComponent(arrivalStatus_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateAndTime_3)
                    .addComponent(statusOfFlight_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(50, 50, 50));

        flightCode_4.setBackground(new java.awt.Color(0, 0, 0));
        flightCode_4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        flightCode_4.setForeground(new java.awt.Color(255, 255, 255));
        flightCode_4.setText("G8-6045");

        arrivalStatus_4.setBackground(new java.awt.Color(0, 0, 0));
        arrivalStatus_4.setForeground(new java.awt.Color(255, 255, 255));
        arrivalStatus_4.setText("Arriving from COK");

        dateAndTime_4.setBackground(new java.awt.Color(0, 0, 0));
        dateAndTime_4.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        dateAndTime_4.setForeground(new java.awt.Color(255, 255, 255));
        dateAndTime_4.setText("2022-04-22 16:46");

        statusOfFlight_4.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        statusOfFlight_4.setForeground(new java.awt.Color(255, 255, 0));
        statusOfFlight_4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusOfFlight_4.setText("LATE");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(flightCode_4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(arrivalStatus_4)
                .addGap(136, 136, 136)
                .addComponent(dateAndTime_4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(statusOfFlight_4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(flightCode_4)
                    .addComponent(arrivalStatus_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dateAndTime_4)
                    .addComponent(statusOfFlight_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(presentDateAndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(arrivalStatus_5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(presentDateAndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(arrivalStatus_5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CurrentTimeAndDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CurrentTimeAndDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CurrentTimeAndDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CurrentTimeAndDate.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CurrentTimeAndDate().setVisible(true);
            }
        });
       

          
        }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IsState5;
    private javax.swing.JLabel IsState6;
    private javax.swing.JLabel IsState7;
    private javax.swing.JLabel IsState9;
    private javax.swing.JLabel arrivalStatus_1;
    private javax.swing.JLabel arrivalStatus_2;
    private javax.swing.JLabel arrivalStatus_3;
    private javax.swing.JLabel arrivalStatus_4;
    private javax.swing.JPanel arrivalStatus_5;
    private javax.swing.JLabel dateAndTime_1;
    private javax.swing.JLabel dateAndTime_2;
    private javax.swing.JLabel dateAndTime_3;
    private javax.swing.JLabel dateAndTime_4;
    private javax.swing.JLabel dateAndTime_5;
    private javax.swing.JLabel flightCode_1;
    private javax.swing.JLabel flightCode_2;
    private javax.swing.JLabel flightCode_3;
    private javax.swing.JLabel flightCode_4;
    private javax.swing.JLabel flightCode_5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel presentDateAndTime;
    private javax.swing.JLabel statusOfFlight_1;
    private javax.swing.JLabel statusOfFlight_2;
    private javax.swing.JLabel statusOfFlight_3;
    private javax.swing.JLabel statusOfFlight_4;
    private javax.swing.JLabel statusOfFlight_5;
    // End of variables declaration//GEN-END:variables
}
