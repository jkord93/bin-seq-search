package q3;

import javax.swing.*;
import java.awt.*;

public class table extends JFrame {
	
	JTable table;
	
	public table() {
		setLayout(new FlowLayout()) ;
		
		String [] columnNames = {"Name", "Eye = Color",};
		
		Object [] [] data = {
				{"Bill", "Hazel"},
				{"Mary", "Black"},
				{"Rick", "Red"},
				{"Janice", "Yellow"},
		};
		
		table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(500,50));
		table.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane);
	}
	
	public static void main(String args[]) {
		table gui = new table();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(600,200);
		gui.setVisible(true);
		gui.setTitle("My first gui table");
	}

}
