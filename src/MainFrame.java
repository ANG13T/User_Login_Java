import javax.swing.*;

import java.io.*;
import java.awt.*;
import java.awt.event.*;


public class MainFrame {
	JFrame frame;
	JLabel nameLabel;
	JTextField nameInput;
	JPanel panel;
	JButton submit;
	
	JLabel ageLabel;
	JTextField ageInput;
	
	
	JLabel hobbyLabel;
	JTextField hobbyInput;
	
	JMenu fileMenu;
	JMenuItem loadMenuItem;
	
	
	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.go();
	}
	
	public void go() {
		//Name
		nameLabel = new JLabel("Name:");
		nameInput = new JTextField();
		submit = new JButton("submit");
		submit.addActionListener(new ButtonListener());
		submit.setSize(100,200);
		submit.setOpaque(true);
		
		JLabel space = new JLabel("");
	
		nameInput.setSize(200, 24);
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(nameLabel);
		panel.add(nameInput);
		panel.setBackground(Color.CYAN);
		
		
		//Age
		ageLabel = new JLabel("Age: ");
		ageInput = new JTextField();
		ageInput.setSize(200, 24);
		panel.add(ageLabel);
		panel.add(ageInput);
		

		//Hobby
		hobbyLabel = new JLabel("Hobby: ");
		hobbyInput = new JTextField();
		hobbyInput.setSize(200, 24);
		panel.add(hobbyLabel);
		panel.add(hobbyInput);
		
		//frame
		frame = new JFrame("User Creation App");
		frame.getContentPane().add(BorderLayout.NORTH, panel);
		frame.getContentPane().add(BorderLayout.CENTER, submit);
		
		frame.setSize(500, 200);
		frame.setBackground(Color.BLUE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent ev) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showOpenDialog(frame);
		
			
			try {
				FileWriter writer = new FileWriter(fileChooser.getSelectedFile());
				writer.write(nameInput.getText());
				writer.write(ageInput.getText());
				writer.write(hobbyInput.getText());
				writer.close();
			} catch(IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	

}
