import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FrameTest extends JFrame {
	
	Container c = getContentPane();
	
	JLabel lblDir = new JLabel("디렉토리 : ");
	JLabel lblRemote = new JLabel("원격 주소 : ");
	
	JTextField txtDir = new JTextField(30);
	JTextField txtRemote = new JTextField(30);
	
	JTextArea txaResult = new JTextArea(20,  30);
	
	JButton btnInit = new JButton("저장소 생성");
	JButton btnClone = new JButton("저장소 받아오기");
	public FrameTest() {
		// TODO Auto-generated constructor stub
		setTitle("Easy Git Setting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//c.setLayout(new FlowLayout());
		
		setUI();
		
		setSize(450, 500);
		setVisible(true);
	}
	private void setUI() {
		// TODO Auto-generated method stub
		setNorth();
		setCenter();
		setSouth();
		
		
	}
	private void setSouth() {
		JPanel p = new JPanel();
		p.add(btnInit);
		p.add(btnClone);
		c.add(p, BorderLayout.SOUTH);
	}
	private void setCenter() {
		JPanel p = new JPanel();
		p.add(txaResult);
		c.add(p, BorderLayout.CENTER);
	}
	private void setNorth() {
		JPanel p = new JPanel();
		p.add(lblDir);
		p.add(txtDir);
		p.add(lblRemote);
		p.add(txtRemote);
		c.add(p, BorderLayout.NORTH);
	}
}
