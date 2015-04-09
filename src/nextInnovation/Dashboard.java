/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nextInnovation;

/**
 *
 * @author Winnerawan
 */
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Dashboard extends JFrame {
	JLabel bgd;
	public Dashboard() {
		super("Dashboard");
                ImageIcon icBgd = new ImageIcon(getClass().getResource("images/bgd.png"));
                bgd = new JLabel(icBgd);
		setContentPane(bgd);
		setSize(1355,720);
		setVisible(true);
                setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);


	}
	public static void main(String[] args) {
 	SwingUtilities.invokeLater(new Runnable() {
 		public void run() {
 			new Dashboard();
 		}
 		});
 	}
 }