import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	
	Container c = getContentPane();
	
	JLabel lblDir = new JLabel("���丮 : ");
	JLabel lblRemote = new JLabel("���� �ּ� : ");
	
	JTextField txtDir = new JTextField(30);
	JTextField txtRemote = new JTextField(30);
	
	JTextArea txaResult = new JTextArea(20,  30);
	
	JButton btnInit = new JButton("����� ����");
	JButton btnClone = new JButton("����� �޾ƿ���");
	public MainFrame() {
		// TODO Auto-generated constructor stub
		setTitle("Easy Git Setting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.setLayout(new FlowLayout());
		
		setUI();
		
		setSize(450, 500);
		setVisible(true);
	}
	private void setUI() {
		// TODO Auto-generated method stub
		c.add(lblDir);
		c.add(txtDir);
		c.add(lblRemote);
		c.add(txtRemote);
		c.add(txaResult);
		c.add(btnInit);
		c.add(btnClone);
	}
}
