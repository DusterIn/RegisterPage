package com.insurance;

import java.awt.event.*;  
import java.awt.*;  
import javax.swing.*;  
import java.sql.*;

class Main extends JFrame implements ActionListener{
	
	String[] gender= {"Male","Female"};
	JLabel nameLabel = new JLabel("NAME");
	JLabel genderLabel = new JLabel("GENDER");
	JLabel passwordLabel=new JLabel("PASSWORD");
    JLabel confirmPasswordLabel=new JLabel("CONFIRM PASSWORD");
    JLabel emailLabel=new JLabel("EMAIL");

   
	
	JTextField nameTextField=new JTextField();
    JComboBox genderComboBox=new JComboBox(gender);
    JPasswordField passwordField=new JPasswordField();
    JPasswordField confirmPasswordField=new JPasswordField();
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
    JButton loginButton=new JButton("LOGIN");

	
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,sample,starB;
	JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9;
	
	
	

	Main() {
		super("REGISTER PAGE");
		setBounds(700,200,500,400);
		
		nameLabel.setBounds(80,20,40,70);
        genderLabel.setBounds(80,70,80,70);
        passwordLabel.setBounds(80,120,100,70);
        confirmPasswordLabel.setBounds(80,170,140,70);
        emailLabel.setBounds(80,220,100,70);
        nameTextField.setBounds(250,43,165,23);
        genderComboBox.setBounds(250,93,165,23);
        passwordField.setBounds(250,143,165,23);
        confirmPasswordField.setBounds(250,193,165,23);
        emailTextField.setBounds(250,243,165,23);
        registerButton.setBounds(50,300,100,35);
        resetButton.setBounds(200,300,100,35);
        loginButton.setBounds(350, 300, 100, 35);

	 
	
		
		  add(nameLabel);
	      add(genderLabel);
	      add(passwordLabel);
	      add(confirmPasswordLabel);
	      add(emailLabel);
	      add(nameTextField);
	      add(genderComboBox);
	      add(passwordField);
	      add(confirmPasswordField);
	      add(emailTextField);
	      add(registerButton);
	      add(resetButton);
	      add(loginButton);
	
	      
	    registerButton.addActionListener(this);
	    resetButton.addActionListener(this);
	    loginButton.addActionListener(this);
		 
		 setLayout(null);   
		 setVisible(true);  
		
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}
	
	
	
	public void actionPerformed(ActionEvent e){
		
		
		if(e.getSource()==registerButton) 
		{
			
			
			try {
		    Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance","root","akhil");
			PreparedStatement Pstatement=connection.prepareStatement("insert into userdata values(?,?,?,?,?)");
			  
              Pstatement.setString(1,nameTextField.getText());
              Pstatement.setString(2,genderComboBox.getSelectedItem().toString());
              Pstatement.setString(3,passwordField.getText());
              Pstatement.setString(4,confirmPasswordField.getText());
              Pstatement.setString(5,emailTextField.getText());
              
              if(passwordField.getText().equals(confirmPasswordField.getText()))
              {
                  //Executing query
           
                  Pstatement.executeUpdate();
                  JOptionPane.showMessageDialog(null,"Data Registered Successfully & Now Click On Login");
              }
              else
              {
                  JOptionPane.showMessageDialog(null,"password did not match");
              }

          } catch (Exception e1) {
              e1.printStackTrace();
          }


      }
      if(e.getSource()==resetButton)
      {
          //Clearing Fields
          nameTextField.setText(null);
          genderComboBox.setSelectedItem("Male");
          passwordField.setText(null);
          confirmPasswordField.setText(null);
          emailTextField.setText(null);
             
             																					
		}

		if(e.getSource()==loginButton) {
			LoginPage info = new LoginPage();
		}
	}
	
	
	
	public static void main(String args[]){  
		new Main(); 
		}
}