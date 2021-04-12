import java.io.*;

public class Arquivos {
	
	public void readTxt() {
		BufferedReader in = null;
		try{
			in = new BufferedReader(new FileReader("C:\\Users\\paulo\\eclipse-workspace\\Projeto_1\\teste.txt"));
			String str;
			while((str = in.readLine()) != null) {
				System.out.println(str);
			}
			in.close();
		}
	catch(IOException e) {}
	}
	
	
	public void copyTxt() {
		BufferedReader in = null;
		BufferedWriter out = null;
		try{
			in = new BufferedReader(new FileReader("C:\\Users\\paulo\\eclipse-workspace\\Projeto_1\\teste.txt"));
			out = new BufferedWriter(new FileWriter("C:\\Users\\paulo\\eclipse-workspace\\Projeto_1\\teste2.txt"));
			String str;
			while((str = in.readLine()) != null) {
				out.write(str);
				out.write("\n");
			}
			in.close();
			out.close();
		} 
		catch(IOException e) {
			
		}
	}
}