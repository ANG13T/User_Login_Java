import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;


public class ReadFrame {
	JFrame frame;
	JMenu fileMenu;
	JMenuItem loadMenuItem;
	
	public static void main(String[] args) {
		ReadFrame rf = new ReadFrame();
		rf.go();
	}
	
	public void go() {
		JMenuBar menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		loadMenuItem = new JMenuItem("Load in User File");
		loadMenuItem.addActionListener(new OpenMenuListener());
		fileMenu.add(loadMenuItem);
		menuBar.add(fileMenu);
		
		frame = new JFrame("User File Reader");
		frame.setJMenuBar(menuBar);
		
		frame.setSize(500, 200);
		frame.setBackground(Color.BLUE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public class OpenMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent ev) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.showOpenDialog(frame);
			readFile(fileChooser.getSelectedFile());
		}
	}
	
	public void readFile(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			reader.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
