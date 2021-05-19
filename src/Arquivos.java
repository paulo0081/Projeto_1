import java.io.*;

public class Arquivos {
	
	 /**
    * M�todo respons�vel por carregar um arquivo txt e retorna-lo em String
    * 
    * @return estrutura String de labirinto
    * @throws Exception exce��es de encontrar arquivo
    */
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
	
	/**
	 * Retorna uma String contendo o  conte�do do arquivo .txt passado. 
     * @param arq - nome do arquivo que ser� lido no m�todo.
     * @return String
     */
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