import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Scanner;
 

public class Main {
 

	public static void main(String[] args) {
		//new MainFrame();
		
		// 실행 커맨드
		
        String[] cmd = { "cmd", "/c", "git", "status"}; 
		Process process = null;
 
		try {
			
			process = new ProcessBuilder(cmd).start();
		
 
			// SequenceInputStream은 여러개의 스트림을 하나의 스트림으로 연결해줌.
			SequenceInputStream seqIn = new SequenceInputStream(
					process.getInputStream(), process.getErrorStream());
 
			// 스캐너클래스를 사용해 InputStream을 스캔함
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