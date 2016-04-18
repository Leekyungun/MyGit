import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	
	Container c = getContentPane();
	
	JLabel lblDir = new JLabel("디렉토리 : ");
	JLabel lblRemote = new JLabel("원격 주소 : ");
	
	JTextField txtDir = new JTextField(30);
	JTextField txtRemote = new JTextField(30);
	
	JTextArea txaResult = new JTextArea(20,  30);
	
	JButton btnInit = new JButton("저장소 생성");
	JButton btnClone = new JButton("저장소 받아오기");
	
	String dir = null;
	String remoteSrc = null;
	public MainFrame() {
		// TODO Auto-generated constructor stub
		setTitle("Easy Git Setting");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.setLayout(new FlowLayout());
		
		setUI();
		MyListener();
		
		setSize(450, 500);
		setVisible(true);
	}
	private void MyListener() {
		btnInit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dir = txtDir.getText();
				remoteSrc = txtRemote.getText();
				
				String[] init = { "cmd", "/c", "git", "add", "."}; 
				String[] commit = {"cmd", "/c", "git", "commit", "-m", "first commit"};
				String[] remote = {"cmd", "/c", "git", "remote", "add", "origin", remoteSrc};
				String[] push = {"cmd", "/c", "git", "push", "-u", "origin", "master"};
				
				Process process = null;
				 
				try {
					
					process = new ProcessBuilder(init).directory(new File(dir)).start();
				
					// SequenceInputStream은 여러개의 스트림을 하나의 스트림으로 연결해줌.
					SequenceInputStream seqIn = new SequenceInputStream(
							process.getInputStream(), process.getErrorStream());
		 
					// 스캐너클래스를 사용해 InputStream을 스캔함
					Scanner s = new Scanner(seqIn);
		 
					while (s.hasNextLine() == true) {
						String str = s.nextLine();
						System.out.println(str);
						txaResult.append(str);
					}
		 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
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
	
	public static void main(String[] args) {
		new MainFrame();
		
	}

	
}
