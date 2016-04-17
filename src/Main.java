import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Scanner;
 

public class Main {
 

	public static void main(String[] args) {
		//new MainFrame();
		
		// ���� Ŀ�ǵ�
		
        String[] cmd = { "cmd", "/c", "git", "status"}; 
		Process process = null;
 
		try {
			
			process = new ProcessBuilder(cmd).start();
		
 
			// SequenceInputStream�� �������� ��Ʈ���� �ϳ��� ��Ʈ������ ��������.
			SequenceInputStream seqIn = new SequenceInputStream(
					process.getInputStream(), process.getErrorStream());
 
			// ��ĳ��Ŭ������ ����� InputStream�� ��ĵ��
			Scanner s = new Scanner(seqIn);
 
			while (s.hasNextLine() == true) {
				System.out.println(s.nextLine());
			}
 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
 
}