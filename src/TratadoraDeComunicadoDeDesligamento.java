import java.net.*;
/**
* Classe TratadoraDeComunicadoDeDesligamento, responsável por lidar com o desligamento do servidor de fato
*/
public class TratadoraDeComunicadoDeDesligamento extends Thread
{
    private Parceiro servidor;

    /**
    * Construtor da classe TratadoraDeComunicadoDeDesligamento, responsavel pelo atribuimento do servidor e tratativa do mesmo  
    * @param servidor Recebe o servidor como parâmetro e o atribui.
    * @throws Exception Retorna uma exceção para caso o servidor seja inválido
    */
    public TratadoraDeComunicadoDeDesligamento (Parceiro servidor) throws Exception
    {
        if (servidor==null)
            throw new Exception ("Porta invalida");

        this.servidor = servidor;
    }

    /**
    * Método run, que rodará o tempo todo durante a execução do programa, e só parará de ser executado, caso o comunicado de desligamento seja chamado
    * @throws Exception Retorna uma exceção caso ocorra algum erro no desligamento
    */
    public void run ()
    {
        for(;;)
        {
			try
			{
				if (this.servidor.espie() instanceof ComunicadoDeDesligamento)
				{
					System.out.println ("\nO servidor vai ser desligado agora;");
				    System.err.println ("volte mais tarde!\n");
				    System.exit(0);
				}
			}
			catch (Exception erro)
			{}
        }
    }
}
