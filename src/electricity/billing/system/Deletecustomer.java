
package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class Deletecustomer extends JFrame implements ActionListener{
    
    JButton done,cancel;
    String meter;
    Deletecustomer(String meter) {
        this.meter = meter;
        System.out.print(meter);
        setSize(700, 500);
        setLocation(400, 200);
        
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));
        add(p);
        
        JLabel heading = new JLabel("  TO DELETE CUSTOMER: ");
        heading.setBounds(100, 20, 1000, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);
        
        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(100, 80, 100, 20);
        p.add(lblmeternumber);
        
       Choice lblmeter = new Choice();
        
        try {
            Conc c  = new Conc();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()) {
                lblmeter.add(rs.getString("meter_no"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        lblmeter.setBounds(240, 80, 200, 20);
        p.add(lblmeter);
        
        done = new JButton("Done");
        done.setBounds(120, 390, 100,25);
        done.setBackground(Color.BLACK);
        done.setForeground(Color.WHITE);
        done.addActionListener(this);
        p.add(done);
         cancel = new JButton("Cancel");
        cancel.setBounds(250, 390, 100,25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);
        setLayout(new BorderLayout());
        
        add(p, "Center");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/delete.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, "West");
        
        getContentPane().setBackground(Color.WHITE);
          
        JLabel lblmeterno = new JLabel("Name");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);
        
        JLabel lblname = new JLabel("");
        lblname.setBounds(240, 120, 100, 20);
        p.add(lblname);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);
        
        JLabel labeladdress = new JLabel();
        labeladdress.setBounds(240, 160, 200, 20);
        p.add(labeladdress);
         
        JLabel lblcity = new JLabel("City");
        lblcity.setBounds(100, 200, 100, 20);
        p.add(lblcity);
        
        JLabel labelcity = new JLabel();
        labelcity.setBounds(240, 200, 200, 20);
        p.add(labelcity);
        
        JLabel lblstate = new JLabel("State");
        lblstate.setBounds(100, 240, 100, 20);
        p.add(lblstate);
        
        JLabel labelstate = new JLabel();
        labelstate.setBounds(240, 240, 200, 20);
        p.add(labelstate);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(100, 280, 100, 20);
        p.add(lblemail);
        
        JLabel labelemail = new JLabel();
        labelemail.setBounds(240, 280, 200, 20);
        p.add(labelemail);
        
         JLabel lblnum = new JLabel("Phone number");
        lblnum.setBounds(100, 320, 100, 20);
        p.add(lblnum);
        
        JLabel labelnum = new JLabel();
        labelnum.setBounds(240, 320, 200, 20);
        p.add(labelnum);

        
        try {
            Conc c = new Conc();
            ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+lblmeter.getSelectedItem()+"'");
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                labeladdress.setText(rs.getString("address"));
                labelcity.setText(rs.getString("city"));
                labelstate.setText(rs.getString("state"));
                labelemail.setText(rs.getString("email"));
                 labelnum.setText(rs.getString("phone"));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
         lblmeter.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conc c = new Conc();
                    ResultSet rs = c.s.executeQuery("select * from customer where meter_no = '"+lblmeter.getSelectedItem()+"'");
                    while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                        labeladdress.setText(rs.getString("address"));
                        labelcity.setText(rs.getString("city"));
                       labelstate.setText(rs.getString("state"));
                        labelemail.setText(rs.getString("email"));
                        labelnum.setText(rs.getString("phone"));
                               
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
         });
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae) {
         
         if(ae.getSource()==done)
         {     
              String meternum= meter;
             String query1 = "Delete from customer where meter_no = " + "'" +meter + "'";

         
          try {
                Conc c = new Conc();
                c.s.executeUpdate(query1);
                JOptionPane.showMessageDialog(null, "Customer Details Deleted Successfully");
                setVisible(false);
             
            } catch (Exception e) {
                e.printStackTrace();
            }
         }
         else {
            setVisible(false);
        }
     }
        public static void main(String[] args)
         {
            new Deletecustomer("");
           }
        
}
