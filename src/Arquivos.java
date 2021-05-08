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
	
	
	public String openTxt(String arq) 
    {
            BufferedReader in = null;
            String ret = "";
            boolean numFlag = true;

            try
            {
                in = new BufferedReader(new FileReader(arq));
                int tamanho;
                String str;
                while((str = in.readLine()) != null) 
                {
                    if (numFlag == true)
                    {
                        str = in.readLine();
                        numFlag = false;
                    }
                    ret += str + "\n";
                }
                in.close();
                tamanho = ret.length();
                ret = ret.substring(0, tamanho-1);
            }
        catch(IOException e) 
            {

            }
            return ret;
    }
}