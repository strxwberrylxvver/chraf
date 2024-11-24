package christianaffirmations;
import javax.swing.*; 
import java.awt.*;
public class Affirmations {
	  private static final String[][] QUOTES = {
	            {"Stress", "“Cast all your anxiety on Him because He cares for you.” – 1 Peter 5:7"},
	            {"Failure", "“For though the righteous fall seven times, they rise again.” – Proverbs 24:16"},
	            {"Fear", "“Do not fear, for I am with you; do not be dismayed, for I am your God.” – Isaiah 41:10"},
	            {"Loneliness", "“Be strong and courageous. Do not be afraid; do not be discouraged, for the Lord your God will be with you wherever you go.” – Joshua 1:9"}
	    };

	    public static void main(String[] args) {
	        JFrame frame = new JFrame("Christian Affirmations");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(500, 300);

	        JPanel panel = new BackgroundPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 
	        frame.add(panel);

	        JLabel titleLabel = new JLabel("Choose an issue :");
	        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 16)); 
	        panel.add(titleLabel);
	        panel.add(Box.createRigidArea(new Dimension(0, 20))); 

	        for (String[] issue : QUOTES) {
	            JButton button = new JButton(issue[0]); 
	            button.setAlignmentX(Component.CENTER_ALIGNMENT);
	            button.setFont(new Font("Times New Roman", Font.PLAIN, 14)); 

	   
	            button.setBackground(new Color(255, 182, 193)); 
	            button.setForeground(Color.WHITE); 
	            button.setBorder(BorderFactory.createLineBorder(Color.PINK, 2)); 

	            button.addActionListener(e -> {
	                showAffirmationWithPinkBackground(frame, issue[1]);
	            });

	            panel.add(button);
	            panel.add(Box.createRigidArea(new Dimension(0, 10))); 
	        }

	        frame.setVisible(true);
	    }

	    static class BackgroundPanel extends JPanel {
	        private ImageIcon backgroundImage;

	        public BackgroundPanel() {
	            backgroundImage = new ImageIcon("/Users/merrone/Downloads/hellokitty.png"); 
	        }

	        @Override
	        protected void paintComponent(Graphics g) {
	            super.paintComponent(g); 

	            Image image = backgroundImage.getImage();
	            int imageWidth = image.getWidth(null);
	            int imageHeight = image.getHeight(null);

	            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	        }
	    }

	    private static void showAffirmationWithPinkBackground(JFrame parentFrame, String message) {
	        JDialog dialog = new JDialog(parentFrame, "Affirmation", true);
	        dialog.setLayout(new BorderLayout());
	        
	        JTextArea messageText = new JTextArea(message);
	        messageText.setFont(new Font("Times New Roman", Font.PLAIN, 14)); 
	        messageText.setWrapStyleWord(true); 
	        messageText.setLineWrap(true); 
	        messageText.setBackground(new Color(255, 182, 193)); 
	        messageText.setForeground(Color.BLACK); 
	        messageText.setEditable(false); 
	        messageText.setCaretPosition(0); 
	        
	        JScrollPane scrollPane = new JScrollPane(messageText);
	        scrollPane.setPreferredSize(new Dimension(280, 100)); 
	        
	        JPanel contentPanel = new JPanel();
	        contentPanel.setBackground(new Color(255, 182, 193)); 
	        contentPanel.add(scrollPane);

	        dialog.add(contentPanel, BorderLayout.CENTER);

	        JButton okButton = new JButton("OK");
	        okButton.setBackground(new Color(255, 182, 193)); 
	        okButton.setForeground(Color.BLACK);
	        okButton.addActionListener(e -> dialog.dispose());

	        dialog.add(okButton, BorderLayout.SOUTH);
	        dialog.setLocationRelativeTo(parentFrame); 
	        dialog.setSize(300, 200); 
	        dialog.setVisible(true);
	    }}