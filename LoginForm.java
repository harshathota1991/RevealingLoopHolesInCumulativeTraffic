
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.*;

public class LoginForm implements ActionListener
{
public String cu="",cp="";

	Font f1 = new Font("Times New Roman", Font.BOLD, 45);
	Font f2 = new Font("Bell MT", Font.BOLD, 21);
	Font f3 = new Font("Bell MT", Font.BOLD, 18);

	JLabel l= new JLabel(" LOGIN PAGE ");
	//JLabel l1= new JLabel(" USER NAME ");
	//JLabel l2= new JLabel(" PASSWORD ");
	JLabel l6= new JLabel();
	JLabel l7= new JLabel();
	JLabel l8= new JLabel();
	JTextField t1 = new JTextField();
	JPasswordField t2 = new JPasswordField();

	JButton LOGIN = new JButton("  LOGIN  ");
	JButton CANCEL = new JButton("  CANCEL  ");

	public JFrame jf;
	public Container c;

	LoginForm()  
        {
		ImageIcon v2 = new ImageIcon(this.getClass().getResource("bg.jpg"));
		l6.setIcon(v2);
		   l6.setBounds(0, 0, 1024, 768);
		   ImageIcon v1 = new ImageIcon(this.getClass().getResource("Authentication.jpg"));
			l7.setIcon(v1);
			   l7.setBounds(200, 100, 600, 500);
			   
		jf = new JFrame(" ADMIN lOGIN FORM ");
	    c = jf.getContentPane();
	   
	    c.setLayout(null);
		jf.setSize(1024,740);
		jf.show();

		l.setBounds(350,40,700,100);
		l.setFont(f1);
		l.setForeground(Color.red);
		c.add(l);

		
		t1.setBounds(365,217,245,37);
		t1.setFont(f3);
		t1.setForeground(Color.GREEN);
		c.add(t1);
		
		t2.setBounds(365,263,245,37);
		t2.setFont(f3);
		t2.setForeground(Color.GREEN);
		c.add(t2);

		LOGIN.setBounds(270,350,140,30);
		LOGIN.setFont(f2);
		LOGIN.setForeground(Color.white);
		LOGIN.setBackground(new Color(0,89,0));
		LOGIN.addMouseListener(new Mous	eAdapter(){
			 public void mouseEntered(MouseEvent e) {
				 LOGIN.setBackground(new Color(21,255,21));
				// LOGIN.setForeground(new Color(6,176,21));
			    }

			    public void mouseExited(MouseEvent e) {
			    	LOGIN.setBackground(new Color(0,89,0));
			    	//LOGIN.setForeground(new Color(72,196,251));
			    }
			   			});


		c.add(LOGIN);

		CANCEL.setBounds(450,350,150,30);
		CANCEL.setFont(f2);
		CANCEL.setForeground(Color.white);
		CANCEL.setBackground(new Color(0,89,0));
		CANCEL.addMouseListener(new MouseAdapter(){
			 public void mouseEntered(MouseEvent e) {
				 CANCEL.setBackground(new Color(21,255,21));
				// CANCEL.setForeground(new Color(6,176,21));
			    }

			    public void mouseExited(MouseEvent e) {
			    	CANCEL.setBackground(new Color(0,89,0));
			    	//CANCEL.setForeground(new Color(72,196,251));
			    }
			   			});

		c.add(CANCEL);

		jf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent win) {
				System.exit(0);
			}
		});
		LOGIN.addActionListener(this);
		CANCEL.addActionListener(this);
		c.add(l7);
		c.add(l8);
		c.add(l6);
	}

	public void actionPerformed(ActionEvent e) {
		 if (e.getSource()== LOGIN)
		 {
			 String Name1 = t1.getText();
			 String Password1 = t2.getText();

			 try {
				 

				 Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				 Connection c= DriverManager.getConnection("jdbc:odbc:Anomaly");
				 Statement s= c.createStatement();
				 ResultSet rs = s.executeQuery("select user1,pass1 from Login where user1='"+Name1+"' and  pass1='"+Password1+"' " );
				 while(rs.next())
				 {
			cu=rs.getString(1).toString();
                        cp=rs.getString(2).toString();
				   
				    
				 }
                                 if(cu.equals("")&& cu.equals(""))
                                 {
                                     JOptionPane.showMessageDialog(null,"UserName Or Password Is Incoorect");
                                 }
                                 else
                                 {
                                     JOptionPane.showMessageDialog(null, "Login Successflly");
                                 
                                       new serverr().setVisible(true);
                                       jf.setVisible(false);
                                 
                                   
                                   
                                      
                                 }
                                 
				
			 }

			 catch(Exception ee)
                         {
				 System.out.print(ee);
			 }

		 }
		 if (e.getSource()== CANCEL)
		 {
			 t1.setText("");
			 t2.setText("");
		 }

	}

	public static void main(String[] args) 
        {

		new LoginForm();

	}




}
