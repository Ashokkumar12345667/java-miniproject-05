package javacrude;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class jca05 {

	private JFrame frame;
	private JTextField textpname;
	private JTextField txtprice;
	private JTextField txtcity;
	private JTextField txtpid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jca05 window = new jca05();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public jca05() {
		initialize();
		Connect();
	}
	
	
	Connection con;
	PreparedStatement pst;
	
	 
	public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/javacrud", "root","");
	        }
	        catch (ClassNotFoundException ex)
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	 
	    }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 909, 491);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Java Crud Application");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 434, 46);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Product Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(10, 68, 188, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1_1.setBounds(10, 116, 188, 32);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("City");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1_2.setBounds(10, 170, 188, 32);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textpname = new JTextField();
		textpname.setBounds(196, 68, 687, 32);
		frame.getContentPane().add(textpname);
		textpname.setColumns(10);
		
		txtprice = new JTextField();
		txtprice.setBounds(196, 116, 687, 32);
		frame.getContentPane().add(txtprice);
		txtprice.setColumns(10);
		
		txtcity = new JTextField();
		txtcity.setBounds(196, 175, 687, 32);
		frame.getContentPane().add(txtcity);
		txtcity.setColumns(10);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pname,price,city;
				
				pname=textpname.getText();
				price=txtprice.getText();
				city=txtcity.getText();
				
				try {
					pst = con.prepareStatement("insert into product(Name,Price,City)values(?,?,?)");
					pst.setString(1, pname);
					pst.setString(2, price);
					pst.setString(3, city);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
					
					          
					textpname.setText("");
					txtprice.setText("");
					txtcity.setText("");
					textpname.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton.setBounds(10, 230, 143, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String pid;
				
				pid=txtpid.getText();
				
				try {
					pst = con.prepareStatement("delete from product where id=?");
					pst.setString(1, pid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record delete!!!!!");
					
					          
					textpname.setText("");
					txtprice.setText("");
					txtcity.setText("");
					textpname.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
		
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnDelete.setBounds(10, 265, 143, 23);
		frame.getContentPane().add(btnDelete);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pname,price,city,pid;
				
				pname=textpname.getText();
				price=txtprice.getText();
				city=txtcity.getText();
				pid=txtpid.getText();
				
				try {
					pst = con.prepareStatement("update product set Name= ?,Price= ?,City= ? where id=?");
					pst.setString(1, pname);
					pst.setString(2, price);
					pst.setString(3, city);
					pst.setString(4, pid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record update!!!!!");
					
					          
					textpname.setText("");
					txtprice.setText("");
					txtcity.setText("");
					textpname.requestFocus();
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnUpdate.setBounds(10, 299, 143, 23);
		frame.getContentPane().add(btnUpdate);
		
		JLabel lblNewLabel_1_3 = new JLabel("Product Id");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1_3.setBounds(10, 333, 188, 32);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		txtpid = new JTextField();
		txtpid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				
				
				try {
			          
		            String id = txtpid.getText();
		 
		                pst = con.prepareStatement("select Name,Price,City from product where id = ?");
		                pst.setString(1, id);
		                ResultSet rs = pst.executeQuery();
		 
		            if(rs.next()==true)
		            {
		              
		                String name = rs.getString(1);
		                String price = rs.getString(2);
		                String city = rs.getString(3);
		                
		                textpname.setText(name);
		                txtprice.setText(price);
		                txtcity.setText(city);
		                
		                
		            }  
		            else
		            {
		             textpname.setText("");
		             txtprice.setText("");
		                txtcity.setText("");
		                
		            }
		            
		 
		 
		        }
		catch (SQLException ex) {
		          
		        }
			}
		});
		txtpid.setColumns(10);
		txtpid.setBounds(196, 338, 687, 32);
		frame.getContentPane().add(txtpid);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnSearch.setBounds(196, 387, 687, 23);
		frame.getContentPane().add(btnSearch);
	}
}
