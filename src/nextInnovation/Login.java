/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nextInnovation;

/**
 *
 * @author Winnerawan
 */
import com.mysql.jdbc.Statement;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import nextInnovation.conf.connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

public class Login extends JFrame {

	JLabel lTitle,lSubTitle,lUser,lPass;
	JPanel pIcUser,pIcPasswd,pMain,pSignIn;
	JTextField txtUser;
	JPasswordField txtPasswd;
	JButton bSign;
	JLabel iconUser;

	public Login() {
		super("Sign In");
                ImageIcon icBg = new ImageIcon(getClass().getResource("images/bg.png"));
                JLabel bg = new JLabel(icBg);
		setContentPane(bg);
		setSize(800,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);

			pMain = new JPanel();
			pMain.setLayout(null);
			pMain.setVisible(true);
			pMain.setBounds(70,80,650,300);
			pMain.setBackground(new Color(0,0,0,0));
			add(pMain);

			pSignIn = new JPanel();
			pSignIn.setLayout(null);
			pSignIn.setVisible(true);
			pSignIn.setOpaque(true);
			pSignIn.setBounds(70,380,650,100);
			pSignIn.setBackground(new Color(0,0,0,0));
			add(pSignIn);
			
			
				
				//title
				lTitle = new JLabel("Next-Innovation Point Of Sale System");
				lTitle.setBounds(50,10,700,80);
				lTitle.setFont(new Font("monofur", Font.ITALIC, 28));
				lTitle.setForeground(Color.white);
				lTitle.setVisible(true);
				add(lTitle);
				//icon-user 
				ImageIcon icUser = new ImageIcon(getClass().getResource("images/icon/user-icon.png"));
				iconUser = new JLabel(icUser,JLabel.CENTER);
				iconUser.setBounds(230,50,200,200);
				add(iconUser);
				pMain.add(iconUser);
				
				ImageIcon signBg = new ImageIcon(getClass().getResource("images/icon/sign-bg.png"));
				JLabel icSignBG = new JLabel(signBg);
				icSignBG.setBounds(57,12,540,78);
				pSignIn.add(icSignBG);
				
				//pIcUser = new JPanel();
				//pIcUser.setBounds(75,25,85,53);
				//pIcUser.setBackground(Color.white);
				//pSignIn.add(pIcUser);
					//lUser = new JLabel("   Username : ");
					//lUser.setBounds(10,10,100,40);
					//lUser.setForeground(Color.black);
					//pIcUser.add(lUser);
				
				lSubTitle = new JLabel("Sign In . . . ");
				lSubTitle.setBounds(350,340,150,50);
				lSubTitle.setFont(new Font("monofur", Font.ITALIC,20));
				lSubTitle.setForeground(Color.white);
				add(lSubTitle);
				
				txtUser = new JTextField("   Username");
				txtUser.setBounds(75,25,250,53);
				txtUser.setOpaque(true);
                                txtUser.setForeground(Color.black);
				txtUser.setFont(new Font("monofur",Font.ITALIC,16));
				txtUser.setVisible(true);
				pSignIn.add(txtUser);

				
				txtPasswd = new JPasswordField("   Password ");
                                txtPasswd.setForeground(Color.black);
				//txtPasswd.setEchoChar((char)2);
				txtPasswd.setFont(new Font("monofur",Font.ITALIC,16));
				txtPasswd.setBounds(335,25,250,53);
				txtPasswd.setVisible(true);
				txtPasswd.setOpaque(true);
				pSignIn.add(txtPasswd);
				
				ImageIcon goBtn = new ImageIcon(getClass().getResource("images/icon/go.png"));
				JLabel iconGo = new JLabel(goBtn);
				Color goColor = new Color(0xFF6600);
				bSign = new JButton(goBtn);
				bSign.setBounds(595,25,53,53);
				bSign.setVisible(true);
				bSign.setBorder(null);
				bSign.setOpaque(true);
				bSign.setBackground(goColor);
				pSignIn.add(bSign);
        
                                    bSign.addActionListener(new ActionListener() {
                                        public void actionPerformed(ActionEvent e) {
                                                  try {
                     
            java.sql.Connection connect = (java.sql.Connection) connection.ConnectDB();
            java.sql.Statement stm = connect.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("select * from user where user='"+txtUser.getText()+"'");
            
            if(sql.next()){
                if(txtPasswd.getText().equals(sql.getString("pass"))){
                    JOptionPane.showMessageDialog(null, "login berhasil");
                    dispose();
                    new Dashboard();
                }
                else{
                    JOptionPane.showMessageDialog(null,"username and password salah");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"username dan password tidak tersedia");
            }
            
        } catch (Exception en) {
            JOptionPane.showMessageDialog(null,"terjadi kesalahan");
        }
                                        }
                                           
                                        });
                                    txtUser.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                                   System.out.println("RELEASE");

            }
 
            public void keyTyped(KeyEvent e) {
               System.out.println("TYPED");

                
            }
 
            public void keyPressed(KeyEvent e) {
               System.out.println("PRESSED");
            }
        });
                                     txtPasswd.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                                   System.out.println("RELEASE");

            }
 
            public void keyTyped(KeyEvent e) {
               System.out.println("TYPED");

                
            }
 
            public void keyPressed(KeyEvent e) {
               System.out.println("PRESSED");
            }
        });

}
 public static void main(String[] args) {
 	SwingUtilities.invokeLater(new Runnable() {
 		public void run() {
 			new Login();
 		}
 		});
 	}
 }