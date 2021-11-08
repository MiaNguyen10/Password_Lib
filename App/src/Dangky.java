import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.awt.*;


public class Dangky extends JFrame {
    //private final static String login = "Login.txt";
    // Swing component
    private Container container = new Container();
    JTextField username;
    JPasswordField password;
    String suggest_pass;
    public Dangky() {
        super("Register Form");
        init();
    }

    private void init() {
    	container = getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
       // this.getContentPane().setBackground(new Color(0x000000));
        //this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("D:/UEF1822/JavaTechnology/ApplicationJava/image/login.jpg")))));
        //===============render input section===============;
        JPanel inputSection = new JPanel(new FlowLayout(1, 0, 10));
        // userName
        JPanel userField = new JPanel(new FlowLayout(1, 10, 0));
        userField.add(new JLabel("User name:"));
        username = new JTextField(20);
        userField.add(username);

        // password     
        JPanel passField = new JPanel(new FlowLayout(1, 10, 0));
        passField.add(new JLabel("Password:"));
        password = new JPasswordField(20);
        passField.add(password);
		password.setEchoChar((char) 0); //show password
        
        inputSection.add(userField);
        inputSection.add(passField);
        //===============render button section===============;
        JPanel buttonField = new JPanel(new FlowLayout(1, 20, 0));
        // confirm button
        JButton confirmButton = new JButton("Confirm");
        confirmButton.setBackground( new Color(0xCED16A));
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try 
        		{
        			Class.forName("com.mysql.cj.jdbc.Driver");
        			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/game","root","10062000ha");
        			String query= "Insert into login(acc,pass) values(?,?)";
        			PreparedStatement pst = conn.prepareStatement(query);
        			String password1 = password.getText().toString();
        			
        			StringBuilder inputpass = new StringBuilder(password1);
        			suggest_pass = PasswordValidator.generatePassword(password1).toString();
        			if (PasswordValidator.isValid(password1)) {        				
        				//JOptionPane.showMessageDialog(null,"Insert Successfully! Please Login again." );    
        				if(PasswordValidator.checkStrengthOfPassword(password1)) {
        					JOptionPane.showMessageDialog(null,"Insert Successfully! Please Login again." );    
        					pst.setString(1, username.getText());
    						pst.setString(2, password1);
    						pst.executeUpdate();      
    						setVisible(false);
        				} else {
    						int result = JOptionPane.showConfirmDialog(null,"Your password is Weak!\n Do you want to reset your password.", "Confirm Question",
          			               JOptionPane.YES_NO_OPTION,
          			               JOptionPane.QUESTION_MESSAGE);
         					if(result == JOptionPane.YES_OPTION){
         						int result1 = JOptionPane.showConfirmDialog(null,"Suggest password: "+ suggest_pass, "Confirm Question",
               			               JOptionPane.YES_NO_OPTION,
               			               JOptionPane.QUESTION_MESSAGE);
         						if(result1 == JOptionPane.YES_OPTION)
         							password.setText(suggest_pass); 
         						else 
         							password.setText(""); 
         					}else {  
         						pst.setString(1, username.getText());
         						pst.setString(2, password1);
         						pst.executeUpdate();      
         						setVisible(false);
         					}
        				}
        	        }
        	        else {
        	        	JOptionPane.showMessageDialog(null,"Invalid Password!!! Please sign up again." );
        	        	password.setText("");
        	        }         			
        		} catch (Exception e2) {e2.getStackTrace();}
            	
         }
            	
            
        });
        // Cancel Button
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setBackground( new Color(0xCED16A));
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        buttonField.add(confirmButton);
        buttonField.add(cancelButton);

        // Add to container
        container.add(inputSection);
        container.add(buttonField);

        renderWindow();
    }

    private void renderWindow() {
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }
    
    
}
