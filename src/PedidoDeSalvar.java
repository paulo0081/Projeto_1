import java.sql.Date;

/**
* Classe PedidoDeSalvar, responsável pelo salvamento do labirinto.
* @param data - Parâmetro IP, contendo a data do salvamento
*/
@SuppressWarnings("serial")
public class PedidoDeSalvar extends Comunicado
{
    
	private String 	labirinto;
	private Date 	data;
	private String 	nome;
	private String 	ip;
    
    /**
    * Construtor da classe PedidoDeSalvar, responsável pelo atribuimento dos valores recebidos como parâmentro.
    * @param nome - Parâmetro nome, contendo o nome atribuido pelo cliente
    * @param ip - Parâmetro IP, contendo o ip do cliente
    * @param data - Parâmetro data, contendo a data do salvamento
    * @param labirinto - Parâmetro labirinto, contendo o labirinto de fato
    */
    public PedidoDeSalvar (String nome, String ip, Date data, String labirinto)
    {
    	this.nome = nome;
        this.ip = ip;
        this.data = data;
        this.labirinto = labirinto;
    }
    
    /**
    * @return Retorna o nome dado pelo cliente.
    */
    public String getNome ()
    {
        return this.nome;
    }
    
    /**
    * @return Retorna o ip do cliente.
    */
    public String getIp ()
    {
        return this.ip;
    }
    
    /**
    * @return Retorna a data do salvamento.
    */
    public Date getData ()
    {
        return this.data;
    }
    
    /**
    * @return Retorna o labirinto.
    */
    public String getLabirinto ()
    {
        return this.labirinto;
    }
    
    /**
    * @return Retorna o nome, o IP e o labirinto em formato de string
    */
    public String toString ()
    {
        return ("Nome: " + this.nome +"\nIp: " + this.ip + "\nLab: "+ this.labirinto);
    }
}
