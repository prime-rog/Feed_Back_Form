package View;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Arrays;
import javax.swing.*;
class reg extends JFrame implements ActionListener
{
	// Variables
	Container c;
	 String Name ="";
	String Student_Id="";
	String Year="";
	String Branch ="";
	String Section = "";
	String Teacher_Name="";
	String Remarks="";
	// Labels Used in GUI
	JLabel tt = new JLabel("Feed Back Form"); 
	JLabel l1 = new JLabel("Name:");
	JLabel l2 = new JLabel("Email-ID:");
	JLabel l3 = new JLabel("Year:");
	JLabel l4 = new JLabel("Branch:");
	JLabel l5 = new JLabel("Section:");
	JLabel l6 = new JLabel("Teacher Name:");
	JLabel l7 = new JLabel("Remarks:");
	JLabel l8 = new JLabel("Explanation");
	JLabel l9 = new JLabel("Doubt Solving");
	// Buttons of Submit and Clear Form
	JButton bt1 = new JButton("Submit");
	JButton bt2 = new JButton("Clear");
	// TextFeilds to Take User Input
	JTextField t1 = new JTextField();
	JTextField t2 = new JTextField();
	JTextField t6 = new JTextField();
	JTextField t7 = new JTextField();
	JTextField t5 = new JTextField();
	JTextField ps1 = new JTextField(); 
	JTextField ps2 = new JTextField();
	// RadioButton For Marking Teacher
	JRadioButton bt1m = new JRadioButton("1");
	JRadioButton bt2m = new JRadioButton("2");
	JRadioButton bt3m = new JRadioButton("3");
	JRadioButton bt4m = new JRadioButton("4");
	JRadioButton bt5m = new JRadioButton("5");
	JRadioButton bt1mo = new JRadioButton("1");
	JRadioButton bt2mo = new JRadioButton("2");
	JRadioButton bt3mo = new JRadioButton("3");
	JRadioButton bt4mo = new JRadioButton("4");
	JRadioButton bt5mo = new JRadioButton("5");
	// Button Group for RadioButton
	ButtonGroup b = new ButtonGroup();
	ButtonGroup b1 = new ButtonGroup();
	reg()
	{
		setTitle("Feed Back Form");
		setVisible(true);
		setBounds(20,40,700,600);
		c = getContentPane();
		setLayout(null);
		// CSS for labels , textFeilds , buttons.
		tt.setBounds(300,0,200,60);
		tt.setForeground(Color.BLUE);
		l1.setBounds(50,40,200,60);
		l2.setBounds(50,80,200,60);
		l3.setBounds(50,120,200,60);
		l4.setBounds(50,160,200,60);
		l5.setBounds(50,200,200,60);
		l6.setBounds(50,240,200,60);
		l8.setBounds(50,280,200,60);
		l9.setBounds(50,320,200,60);
		l7.setBounds(50,360,200,60);
		bt1.setBounds(70,450,100,40);
		bt2.setBounds(200,450,100,40);
		t1.setBounds(250,60,400,20);
		t2.setBounds(250,100,400,20);
		ps1.setBounds(250,140,400,20);
		ps2.setBounds(250,180,400,20);
		t5.setBounds(250,220,400,20);
		t6.setBounds(250,260,400,20);
		bt1m.setBounds(250,300,60,20);
		bt2m.setBounds(310,300,60,20);
		bt3m.setBounds(370,300,60,20);
		bt4m.setBounds(430,300,60,20);
		bt5m.setBounds(490,300,60,20);
		bt1mo.setBounds(250,340,60,20);
		bt2mo.setBounds(310,340,60,20);
		bt3mo.setBounds(370,340,60,20);
		bt4mo.setBounds(430,340,60,20);
		bt5mo.setBounds(490,340,60,20);
		t7.setBounds(250,380,400,20);
		// Adding radio buttons to their respective button group
		b.add(bt1m);
		b.add(bt2m);
		b.add(bt3m);
		b.add(bt4m);
		b.add(bt5m);
		b1.add(bt1mo);
		b1.add(bt2mo);
		b1.add(bt3mo);
		b1.add(bt4mo);
		b1.add(bt5mo);
		// Adding action listener to submit and clear button
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		// Adding all buttons to container GUI
		c.add(tt);
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		c.add(l5);
		c.add(l6);
		c.add(l7);
		c.add(bt1);
		c.add(bt2);
		c.add(t1);
		c.add(t2);
		c.add(ps1);
		c.add(ps2);
		c.add(t5);
		c.add(t6);
		c.add(t7);
		c.add(l8);
		c.add(l9);
		c.add(bt1m);
		c.add(bt2m);
		c.add(bt3m);
		c.add(bt4m);
		c.add(bt5m);
		c.add(bt1mo);
		c.add(bt2mo);
		c.add(bt3mo);
		c.add(bt4mo);
		c.add(bt5mo);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==bt2)
		{
			// Clearing Form 
			t1.setText(null);
	    	t2.setText(null);
	    	ps1.setText(null);
	    	ps2.setText(null);
	    	t5.setText(null);
	    	t6.setText(null);
	    	t7.setText(null);
	    	b.clearSelection();
	    	b1.clearSelection();
		}
		if(e.getSource()==bt1)
		{ 
			//Taking input to variables 
			Name = t1.getText();
			Student_Id = t2.getText();
			Year = ps1.getText();
			Branch = ps2.getText();
			Section = t5.getText();
			Teacher_Name = t6.getText();
			Remarks = t7.getText();
			int mrk1 = b.getButtonCount();
			int mrk2 = b.getButtonCount();
			try
			{
				//jdbc
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FEEDBACK" ,"root" , "root");
				PreparedStatement psmt = con.prepareStatement("insert into FEEDBACK values(?,?,?,?,?,?,?,?,?)");
				psmt.setString(1, Name);
				psmt.setString(2, Student_Id);
				psmt.setString(3, Year);
				psmt.setString(4, Branch);
				psmt.setString(5, Section);
				psmt.setString(6, Teacher_Name);
				psmt.setInt(7, mrk1);
				psmt.setInt(8, mrk2);
				psmt.setString(9, Remarks);
				int count = psmt.executeUpdate();
				if(count>0)
					System.out.println("updated");
				else
					System.out.println("No update");
			}
			catch(Exception exp)
			{
				System.out.println(exp);
			}			
		}   
	}	
}
public class MainView {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		reg obj = new reg();
		System.out.println(obj.Name);
	}
}

