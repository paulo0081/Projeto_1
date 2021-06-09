import java.io.*;
import java.net.*;
import java.util.*;
import java.util.concurrent.Semaphore;

/**
 * Classe Parceiro, resposável pela conexão geral com o servidor. Recebendo, o socket, criado na classe Cliente, assim como o receptor e transmissor.
 */
public class Parceiro
{
    private Socket             conexao;
    private ObjectInputStream  receptor;
    private ObjectOutputStream transmissor;
    
    private Comunicado proximoComunicado=null;

    private Semaphore mutEx = new Semaphore (1,true);

    /**
	 * Construtor Parceiro, responsavel por atribuir os valores recebidos como parâmetros e tratar as exceçoes de conexão básicas.
	 * @param conexao - É o socket, necessário para a conexão em tempo real.
	 * @param receptor - Responsavel pelo recebimento de dados
	 * @param transmissor - Responsavel pelo envio de dados
	 * @throws Exception Caso não seja possivel se conectar com o socket
	 * @throws Exception Caso não seja possivel se conectar com o receptor
	 * @throws Exception Caso não seja possivel se conectar com o transmissor
	*/
    public Parceiro (Socket             conexao,
                     ObjectInputStream  receptor,
                     ObjectOutputStream transmissor)
                     throws Exception // se parametro nulos
    {
        if (conexao==null)
            throw new Exception ("Conexao ausente");

        if (receptor==null)
            throw new Exception ("Receptor ausente");

        if (transmissor==null)
            throw new Exception ("Transmissor ausente");

        this.conexao     = conexao;
        this.receptor    = receptor;
        this.transmissor = transmissor;
    }

    /**
	 * Método receba, responsavel por enviar e tratar os dados do labirinto
	 * @param x - Parâmentro que contém o labirinto de fato
	 * @throws Exception Caso não seja possivel transmitir os dados
	*/
    public void receba (Comunicado x) throws Exception
    {
        try
        {
            this.transmissor.writeObject (x);
            this.transmissor.flush       ();
        }
        catch (IOException erro)
        {
            throw new Exception ("Erro de transmissao");
        }
    }

    /**
	 * Método espie, responsavel por monitorar os dados, garantindo que o nosso programa cliente não receba coisas que não sejam necessárias
	 * @throws Exception Retorna uma exceção caso não seja possível realizar o monitoramento 
	*/
    public Comunicado espie () throws Exception
    {
        try
        {
            this.mutEx.acquireUninterruptibly();
            if (this.proximoComunicado==null) this.proximoComunicado = (Comunicado)this.receptor.readObject();
            this.mutEx.release();
            return this.proximoComunicado;
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de recepcao");
        }
    }

    /**
	 * Método envie, responsavel pelo recebimento de dados de comunicado
	 * @throws Exception Retorna uma exceção caso não seja possível receber do comunicado 
	*/
    public Comunicado envie () throws Exception
    {
        try
        {
            if (this.proximoComunicado==null) this.proximoComunicado = (Comunicado)this.receptor.readObject();
            Comunicado ret         = this.proximoComunicado;
            this.proximoComunicado = null;
            return ret;
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de recepcao");
        }
    }

    /**
	 * Método adeus, responsavel por fechar todas as conexões abertas
	 * @throws Exception Retorna uma exceção caso não seja possível se desconectar
	*/
    public void adeus () throws Exception
    {
        try
        {
            this.transmissor.close();
            this.receptor   .close();
            this.conexao    .close();
        }
        catch (Exception erro)
        {
            throw new Exception ("Erro de desconexao");
        }
    }
}
