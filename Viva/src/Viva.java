import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class Viva extends JFrame{
	private JLabel input,output;
	private JTextField inputf,outputf;
	private JButton result;
	private JPanel panel;
	private String st,rt="";
	
	
	public Viva(){
		setLayout(null);
		
		//look and feel
		try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) { }
		
		panel = new JPanel();
		
		panel.setLayout(null);
		panel.setBounds(120, 80,380 , 200);
		
		//Setting Border
		TitledBorder border = new TitledBorder("InputOuput");
	    border.setTitleJustification(TitledBorder.CENTER);
	    border.setTitlePosition(TitledBorder.TOP);
	    panel.setBorder(border);
	    
		input  = new JLabel("Input");
		output = new JLabel("Output");		
		inputf = new JTextField("input");
		outputf = new JTextField("");
		result = new JButton("Result");
		

		//Setting Bounds of Component
		input.setBounds(60, 20, 100, 30);
		output.setBounds(225, 20, 100, 30);
		inputf.setBounds(60, 50, 100, 30);
		outputf.setBounds(225, 50, 100, 30);
		result.setBounds(145, 110, 100, 40);
		
		//inputf.setEnabled(false);
		//inputf.setEnabled(false);
		outputf.setEnabled(false);
		
		inputf.setBackground(Color.white);
		inputf.setForeground(new Color(150, 155, 155));
		outputf.setBackground(Color.WHITE);
		outputf.setForeground(new Color(150, 155, 155));
		
		add(panel);
		panel.add(input);
		panel.add(output);
		panel.add(inputf);
		panel.add(outputf);
		panel.add(result);

		
		mouseListener();
		
		result.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				st = inputf.getText();
				int len = st.length();
			    int[] count = new int[800];
				for(int i=0; i<800; i++){
					count[i] = 0; 
				}
				
				
				
				//Counting Frequency;
				for(int i=0; i<st.length(); i++){
					int id = (int)st.charAt(i);
					count[id] = count[id] + 1;
				}			
				for(int i=0; i<st.length(); i++){
					int id = (int)st.charAt(i);
					char c = st.charAt(i);
					if(count[id] > 1){
						rt = rt + c+":"+count[st.charAt(i)]+" ";
						count[id] = 0;
					}
				}
				//System.out.println(rt);
				outputf.setText(rt);
				rt = "";
				outputf.setEnabled(true);	
				outputf.setForeground(Color.black);
			}			
		});
		
		//Setting window location in middle
	    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setLocation(dim.width/4-this.getSize().width/2, dim.height/4-this.getSize().height/2);
	  
		
		setSize(600,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Viva");
		setResizable(false);
	}
	
	public void mouseListener(){
		inputf.addMouseListener(new MouseAdapter(){

            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //inputf.setEditable(true);
                inputf.setText("");
                
                inputf.setForeground(Color.BLACK);
                result.setEnabled(true);
  
            }
            
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                inputf.setBorder(BorderFactory.createLineBorder(new Color(66, 134, 244), 1, false));
            }
            
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e); 
                inputf.setBorder(BorderFactory.createLineBorder(new Color(255,255,255), 1, false));
            }
		});

	}
	
	public static void  main(String []args){
		new Viva();
	}
}
