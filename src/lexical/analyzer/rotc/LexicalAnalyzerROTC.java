/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexical.analyzer.rotc;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Element;

/**
 *
 * @author PC
 */
public class LexicalAnalyzerROTC extends Frame{

    /**
     * @param args the command line arguments
     */
    
    //Line Num=====================================================
    
        public static JTextArea Lines;
        
	public static void createAndShowGUI(){
		//JFrame frame = new JavaApplication21();
                Frame n = new Frame();
		//n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		//JScrollPane jsp = new JScrollPane();
		//jta = new JTextArea();
		Lines = new JTextArea("1");
               Font font = new Font("Courier New", Font.PLAIN, 18);

                Lines.setFont(font);

		Lines.setBackground(Color.LIGHT_GRAY);
		Lines.setEditable(false);
 
		SourceTxt.getDocument().addDocumentListener(new DocumentListener(){
			public String getText(){
				int caretPosition = SourceTxt.getDocument().getLength();
				Element root = SourceTxt.getDocument().getDefaultRootElement();
				String text = "1" + System.getProperty("line.separator");
				for(int i = 2; i < root.getElementIndex( caretPosition ) + 2; i++){
					text += i + System.getProperty("line.separator");
				}
				return text;
			}
			@Override
			public void changedUpdate(DocumentEvent de) {
				Lines.setText(getText());
			}
 
			@Override
			public void insertUpdate(DocumentEvent de) {
				Lines.setText(getText());
			}
 
			@Override
			public void removeUpdate(DocumentEvent de) {
				Lines.setText(getText());
			}
 
		});
 
		jsp.getViewport().add(SourceTxt);
		jsp.setRowHeaderView(Lines);
		//jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
 
		//n.add(jsp);
		//n.pack();
		//n.setSize(500,500);
                n.setExtendedState(Frame.MAXIMIZED_BOTH);
		n.setVisible(true);
	}
    
    //=============================================================
    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
        
        //Frame frame = new Frame();
        //frame.setExtendedState(Frame.MAXIMIZED_BOTH);
        //frame.setVisible(true);
        
    }
    
}
