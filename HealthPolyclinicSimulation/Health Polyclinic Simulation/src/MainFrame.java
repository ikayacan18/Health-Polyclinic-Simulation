import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class MainFrame extends JFrame{
	
	private JPanel panel;
	private TextArea textArea;
	
	//constructor
	public MainFrame(String title) {
		
		super(title);
		setVisible(true);
		setLayout(new BorderLayout());
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		panel=new JPanel();
		panel.setVisible(true);
		panel.setBorder(BorderFactory.createTitledBorder("MENU"));
		panel.setSize(500,200);
		panel.setLayout(new GridBagLayout());
		textArea=new TextArea("RESULTS-OUTPUTS:");
		
		
		Container c=getContentPane();
		c.add(panel, BorderLayout.WEST);
		c.add(textArea, BorderLayout.CENTER);
		
	}

	//Getters
	public JPanel getPanel() {
		return panel;
	}

	public TextArea getTextArea() {
		return textArea;
	}
	
	
}
