import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "senha123";

	public static void main(String[] args) {
		SwingUtilities.invokeLater(Login::createAndShowGUI);
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("Tela de Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.insets = new Insets(8, 8, 8, 8);
		c.fill = GridBagConstraints.HORIZONTAL;

		JLabel userLabel = new JLabel("Usuário:");
		c.gridx = 0; c.gridy = 0; panel.add(userLabel, c);

		JTextField userField = new JTextField(15);
		c.gridx = 1; c.gridy = 0; panel.add(userField, c);

		JLabel passLabel = new JLabel("Senha:");
		c.gridx = 0; c.gridy = 1; panel.add(passLabel, c);

		JPasswordField passField = new JPasswordField(15);
		c.gridx = 1; c.gridy = 1; panel.add(passField, c);

		JButton loginBtn = new JButton("Entrar");
		c.gridx = 0; c.gridy = 2; c.gridwidth = 2; panel.add(loginBtn, c);

		// Ação de login (botão e Enter na senha)
		ActionListener doLogin = e -> {
			String user = userField.getText().trim();
			String pass = new String(passField.getPassword());
			if (USERNAME.equals(user) && PASSWORD.equals(pass)) {
				JOptionPane.showMessageDialog(frame, "Login realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(frame, "Usuário ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			passField.setText("");
		};

		loginBtn.addActionListener(doLogin);
		passField.addActionListener(doLogin);

		frame.getContentPane().add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		frame.getRootPane().setDefaultButton(loginBtn);
	}
}
