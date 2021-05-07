import java.awt.*;
import java.awt.event.*;
import java.io.*;


import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.Border;

public class Janela {
	private JFrame  janela     = new JFrame  ("Labirinto");
    private JLabel  visor      = new JLabel  ("Inicio, aqui ficar� o log de Erros", JLabel.LEFT);
    private JButton botao []   = new JButton [4];
    private JTextArea textArea = new JTextArea("Bem vindo!\n");
    final JFileChooser fc = new JFileChooser(new File("./"));
    
    public Janela()
    {
    	
    	JPanel botoes = new JPanel();
        botoes.setLayout (new GridLayout(1,4));

        String texto [] = {	"Criar um novo arquivo de labirinto",
        					"Abrir  um  arquivo  de  labirinto  para  edi��o", 
        					"Salvar  arquivo  de  labirinto", 
        					"Executar arquivo  de  labirinto"};

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
        this.botao[1].addActionListener(new  AbrirLab ());
        this.botao[2].addActionListener(new SalvarLab ());
        this.botao[3].addActionListener(new   ExecLab ());
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
    
    /** 
     * @return void
     * @metodo Salva o arquivo com o nome escolhido pelo usuário
     */
    private class SalvarLab implements ActionListener {
      public void actionPerformed(ActionEvent e) {
        String lab = textArea.getText();

        fc.setDialogTitle("Salvar Labirinto");

        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter extFilter = new FileNameExtensionFilter(".txt File", "txt");
        fc.addChoosableFileFilter(extFilter);
        int result = fc.showSaveDialog(null);

        if(result == JFileChooser.APPROVE_OPTION) {
          File fi = fc.getSelectedFile();

          try { 
            FileWriter fw = new FileWriter(fi.getPath() + ".txt");
            fw.write(lab);
            fw.flush();
            fw.close();
          } catch(Exception e2) {
            JOptionPane.showMessageDialog(null, e2.getMessage());
          }
  
        }
	  	}
    }
    
    private class ExecLab implements ActionListener
    {
		public void actionPerformed(ActionEvent e) {
			
			System.out.println();
			
		}
    }
}
