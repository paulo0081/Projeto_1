import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Janela {
	private JFrame  janela     = new JFrame  ("Labirinto");
    private JLabel  visor      = new JLabel  ("Inicio, aqui ficará o log de Erros", JLabel.LEFT);
    private JButton botao []   = new JButton [4];
    private JTextArea textArea = new JTextArea("Bem vindo!\n");
    
    public Janela()
    {
    	
    	JPanel botoes = new JPanel();
        botoes.setLayout (new GridLayout(1,4));

        String texto [] = {	"Criar um novo arquivo de labirinto",
        					"Abrir  um  arquivo  de  labirinto  para  edição", 
        					"Salvar  arquivo  de  labirinto", 
        					"Executar arquivo  de  labirinto"};

        for (int i=0; i<this.botao.length; i++)
        {
            this.botao [i] = new JButton (texto [i]);
            botoes.add (this.botao [i]);
        }
    	
        this.textArea.setFont(new Font("Arial", Font.PLAIN, 16));
        this.textArea.setBackground(Color.DARK_GRAY);
        this.textArea.setForeground(Color.white);
        this.textArea.setSize(510, 300);
        this.textArea.setEditable(false);
        
        this.visor.setPreferredSize(new Dimension(250, 100));
        this.visor.setVerticalAlignment(SwingConstants.TOP);
        
    	this.janela.setSize (1210,700);
        this.janela.getContentPane().setLayout(new BorderLayout());

        this.janela.add(botoes,BorderLayout.NORTH);
        this.janela.add(this.textArea,BorderLayout.CENTER);
        this.janela.add(this.visor,BorderLayout.SOUTH);
        
        this.janela.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        this.janela.setVisible(true);
        
        
        this.botao[0].addActionListener(new  CriarLab ());
        this.botao[0].addActionListener(new  AbrirLab ());
        this.botao[0].addActionListener(new SalvarLab ());
        this.botao[0].addActionListener(new   ExecLab ());
    }
    
    private class CriarLab implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			textArea.setText("");
			textArea.setEditable(true);
		}
    }
    
    private class AbrirLab implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println();
			
		}
    }
    
    private class SalvarLab implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println();
			
		}
    }
    
    private class ExecLab implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			
			System.out.println();
			
		}
    }
}
