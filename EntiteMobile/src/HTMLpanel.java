import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.text.html.HTMLEditorKit;

public class HTMLpanel extends JFrame {

	private static final long serialVersionUID = 1L;

public static void createFrame() {

    JEditorPane editorPane = new JEditorPane();
    editorPane.setEditable(false);
    HTMLEditorKit theKit = new HTMLEditorKit();
    editorPane.setEditorKit(theKit);

    java.net.URL resourceURL = HTMLpanel.class.getResource("index.html");
    System.out.println("Value = "+resourceURL);
    
    try {
		editorPane.setPage(resourceURL);
	} catch (IOException e) {
		 System.err.println("Attempted to read a bad URL: " + resourceURL);
	}
    
    JScrollPane editorScrollPane = new JScrollPane(editorPane);
    editorScrollPane.setMinimumSize(new Dimension(10, 10));

    JButton button = new JButton("Button!");
    button.setPreferredSize(new Dimension(350, 50));

    JFrame mainFrame = new JFrame();

    mainFrame.setTitle("Entité Mobile");
    mainFrame.setSize(350, 400);
    mainFrame.setLocationRelativeTo(null);

    mainFrame.getContentPane().add(editorScrollPane, BorderLayout.NORTH);
    mainFrame.getContentPane().add(button, BorderLayout.SOUTH);
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setVisible(true);
}
}