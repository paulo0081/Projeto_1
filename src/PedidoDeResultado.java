/**
 * Classe PedidoDeResultado, responsável somente para retornar dados como nome, ip e um método toString
*/
@SuppressWarnings("serial")
    public class PedidoDeResultado extends Comunicado
    {
        private String     nome;
        private String     ip;

        /**
        * Construtor PedidoDeResultado, responsável pela atribuição dos valores de nome e ip.
        * @param nome - Parâmetro nome, contendo o nome atribuido pelo cliente
        * @param ip - Parâmetro IP, contendo o ip do cliente
        */
        public PedidoDeResultado (String nome, String ip)
        {
            this.nome = nome;
            this.ip = ip;
        }

        /**
        * @return Retorna o nome do labirinto
        */
        public String getNome ()
        {
            return this.nome;
        }

       /**
        * @return Retorna o IP do usuário
        */
        public String getIp ()
        {
            return this.ip;
        }

        /**
        * @return Retorna o nome e o IP em formato de string
        */
        public String toString ()
        {
            return ("Nome: " + this.nome +"\nIp: " + this.ip);
        }
    }