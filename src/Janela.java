import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.*;



public class Janela{
	private JFrame  janela     = new JFrame  ("Labirinto");
    private JLabel  visor      = new JLabel  ("Inicio, aqui ficará o log de Erros", JLabel.LEFT);
    private JButton botao []   = new JButton [6];
    private JTextArea textArea = new JTextArea("Bem vindo!\n");
    private Labirinto controle = null;
    private JFileChooser fc    = new JFileChooser();
    
    
    
    public Janela()
    {
    	
    	JPanel botoes = new JPanel();
        botoes.setLayout (new GridLayout(2,3));

        String texto [] = {	"Criar um novo arquivo de labirinto", 
        					"Executar arquivo  de  labirinto",
        					"Limpar o labirinto",
        					"Abrir  um  arquivo  de  labirinto  para  edição",
        					"Salvar  arquivo  de  labirinto",
        					"Regras para criar um labirinto"};

        for (int i=0; i<this.botao.length; i++)
        {
            this.botao [i] = new JButton (texto [i]);
            botoes.add (this.botao [i]);
        }
    	
        this.textArea.setFont(new Font("Courier New", Font.PLAIN, 16));
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
        this.botao[1].addActionListener(new   ExecLab ());
        this.botao[2].addActionListener(new LimparLab ());
        this.botao[3].addActionListener(new  AbrirLab ());
        this.botao[4].addActionListener(new SalvarLab ());
        this.botao[5].addActionListener(new RegrasLab ());
    }
    
    private class CriarLab  implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			controle = null;
			textArea.setText("");
			textArea.setEditable(true);
		}
    }
    
    private class AbrirLab  implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
        	textArea.setEditable(true);
            String labCam = "", lab="";
            File fi=null;
            Arquivos aux = new Arquivos();
            try {
            fc.setDialogTitle("Abrir Labirinto");
            fc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter extFilter = new FileNameExtensionFilter(".txt File", "txt");
            fc.addChoosableFileFilter(extFilter);
            int result = fc.showOpenDialog(null);

            if(result == JFileChooser.APPROVE_OPTION) 
            {
                fi = fc.getSelectedFile();
                labCam = fi.toString();
                lab = aux.openTxt(labCam);
                textArea.setText(lab);
            }
 
            	FileReader fw = new FileReader(fi.getPath());
                fw.read();
                fw.close();
            } catch(Exception e2) {
            	String texto = e2.toString();
				visor.setForeground(Color.red);
				visor.setText(texto);
            }
        }
    }

    private class SalvarLab implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) {
            String lab = textArea.getText();

            int linha = textArea.getLineCount();

            try { 
	            fc.setDialogTitle("Salvar Labirinto");
	            fc.setAcceptAllFileFilterUsed(false);
	            FileNameExtensionFilter extFilter = new FileNameExtensionFilter(".txt File", "txt");
	            fc.addChoosableFileFilter(extFilter);
	            int result = fc.showSaveDialog(null);
	            Labirinto labir = new Labirinto(textArea.getText(), textArea.getLineCount());
				controle = (Labirinto) labir.clone();
				
				Navegacao nav = new Navegacao(labir);
	            
	            
	            
	
	            if(result == JFileChooser.APPROVE_OPTION) {
	            	File fi = fc.getSelectedFile();
	
		            FileWriter fw = new FileWriter(fi.getPath() + ".txt");
		            fw.write(lab);
		            fw.flush();
		            fw.close();
	             }
            
	         } catch(Exception e2) {
	        	 	String texto = e2.toString();
					visor.setForeground(Color.red);
					visor.setText(texto);
	         }      
            
    	} 
    }
    
    private class ExecLab   implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			try {
				Labirinto labir = new Labirinto(textArea.getText(), textArea.getLineCount());
				controle = (Labirinto) labir.clone();
				
				Navegacao nav = new Navegacao(labir);
				visor.setText("<html>"+ nav.toString() +"</html>");
				visor.setForeground(Color.black);
				textArea.setText(labir.toString());
				
			} catch (Exception e1) {
				String texto = e1.toString();
				visor.setForeground(Color.red);
				visor.setText(texto);
			}
		}
		//.getLineCount
    }
    
    private class RegrasLab implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) {
    		textArea.setText("Regras para a criação de um labirinto:\r\n" + 
    						 "\r\n" + 
    						 "1. É necessário que haja APENAS uma entrada e uma saída, demarcadas como \"E\" e \"S\", respectivamente.\r\n" + 
    						 "2. É necessário que a estrutura de \"paredes\" esteja completa com o perímetro do labirinto preenchido com \"#\".\r\n" + 
    						 "3. É necessário que haja um caminho possível entre a entrada e a saída.\r\n" + 
    						 "4. É necessário que a entrada e a saída estejam presenter exclusivamente no perímetro do labirinto. \r\n" + 
    						 "5. É necessário que TODAS as linhas possuam o mesmo tamanho.\r\n" + 
    						 "6. O caminho deve ser demarcado com \" \".\r\n" + 
    						 "\r\n" + 
    						 "Obs: ao finalizar, certifique-se que não há quebras de linha.");
    		textArea.setEditable(false);
    	}
    }
    
    private class LimparLab implements ActionListener
    {
    	public void actionPerformed(ActionEvent e) {
    		try {
    			if(controle == null)
    				throw new Exception("Labirinto não pode ser encontrado.");
    			textArea.setText(controle.toString());
    			
    		}catch(Exception e1) {
    			String texto = e1.toString();
				visor.setForeground(Color.red);
				visor.setText(texto);
    		}
    	}
    }
}
