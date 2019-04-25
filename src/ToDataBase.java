import java.sql.*;
import java.awt.event.*;
import java.awt.*;

public class ToDataBase implements ActionListener {
	
	Label regNoLBL, nameLBL, marksLBL;
	Button saveBtn;
	TextField regNoTxt, nameTxt, marksTxt;
	Frame f;
	Panel p1;
	
	public ToDataBase()
	{
		Frame f = new Frame();
		Panel p1 = new Panel();
		p1.setLayout(new GridLayout(4,2));
		
		regNoLBL = new Label("RegNo");
		nameLBL = new Label("Name");
		marksLBL = new Label("Marks");
		
		regNoTxt = new TextField(20);
		nameTxt = new TextField(20);
		marksTxt = new TextField(20);
		
		saveBtn = new Button("Save");
		saveBtn.addActionListener(this);
		
		p1.add(regNoLBL);
		p1.add(regNoTxt);
		p1.add(nameLBL);
		p1.add(nameTxt);
		p1.add(marksLBL);
		p1.add(marksTxt);
		p1.add(saveBtn);
		
		
		f.add(p1, BorderLayout.NORTH);
		
		
		f.setSize(400, 400);
		f.setVisible(true);
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/qa", "root", "");
			
			Statement st = con.createStatement();
			st.executeUpdate("insert into school values(" + Integer.parseInt(regNoTxt.getText()) + "," + "'" + nameTxt.getText() + "'" + "," + Integer.parseInt(marksTxt.getText()) + ")");
			
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	public static void main(String args[])
	{
		ToDataBase td = new ToDataBase();

		
		
	}

}
