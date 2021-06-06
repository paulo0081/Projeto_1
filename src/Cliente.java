import java.net.*;
import java.io.*;


/**
 * Classe principal, responsável pela conexão do client com o servidor através do socket. Portanto, essa classe lida tanto com a conexão inicial ao servidor, tanto com a tratativa de desligamento.
 */
public class Cliente
{
	public static final String HOST_PADRAO  = "172.16.0.135";
	public static final int    PORTA_PADRAO = 4500;
	private static int contador = 0, info = 0;

	/**
	 * Método main, responsavel por toda a tratativa, desde a conexão até a desconexão com o servidor.
	 * @param args - É um array de strings, podendo ser utilizado para conexão com diferentes hosts e portas
	 * @throws Exception Exceção de validação das portas e hosts
	 * @throws Exception Exceção para caso não seja possível conectar o transmissor 
	 * @throws Exception Exceção para caso não seja possível conectar o receptor
	 * @throws Exception Exceção para caso não seja possível conectar com o servidor
	 * @throws Exception Exceção para caso não seja possível estabelecer a conexão do servidor com a tratadora de desligamento
	 * @throws Exception Exceção para caso não seja possível desconectar-se do servidor
	*/
	public static void main (String[] args)
	{
        if (args.length>2)
        {
            System.err.println ("Uso esperado: java Cliente [HOST [PORTA]]\n");
            return;
        }

        Socket conexao=null;
        try
        {
            String host = Cliente.HOST_PADRAO;
            int    porta= Cliente.PORTA_PADRAO;

            if (args.length>0)
                host = args[0];

            if (args.length==2)
                porta = Integer.parseInt(args[1]);

            conexao = new Socket (host, porta);
        }
        catch (Exception erro)
        {
            System.err.println ("Indique o servidor e a porta corretos!\n");
            return;
        }

        ObjectOutputStream transmissor=null;
        try
        {
            transmissor =
            new ObjectOutputStream(
            conexao.getOutputStream());
        }
        catch (Exception erro)
        {
            System.err.println ("Indique o servidor e a porta corretos!\n");
            return;
        }

        ObjectInputStream receptor=null;
        try
        {
            receptor =
            new ObjectInputStream(
            conexao.getInputStream());
        }
        catch (Exception erro)
        {
            System.err.println ("Indique o servidor e a porta corretos!\n");
            return;
        }

        Parceiro servidor=null;
        try
        {
            servidor =
            new Parceiro (conexao, receptor, transmissor);
        }
        catch (Exception erro)
        {
            System.err.println ("Indique o servidor e a porta corretos!\n");
            return;
        }

        TratadoraDeComunicadoDeDesligamento tratadoraDeComunicadoDeDesligamento = null;
        try
        {
			tratadoraDeComunicadoDeDesligamento = new TratadoraDeComunicadoDeDesligamento (servidor);
		}
		catch (Exception erro)
		{} // sei que servidor foi instanciado
		
        tratadoraDeComunicadoDeDesligamento.start();

        do {
        	if(contador == 0)
        	{
        		new Janela(servidor);
        		contador++;
        	}
        	try {
        		info = Teclado.getUmInt();
        		if(info != -1)
        			info = -1;
        	}catch(Exception e){
        		info = -1;
        	}
        }while(info == -1);

		try
		{
			servidor.receba (new PedidoParaSair ());
		}
		catch (Exception erro)
		{}
		
		System.out.println ("Obrigado por usar este programa!");
		System.exit(0);
	}
}















