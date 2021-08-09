
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// frameul
		JFrame frame = new JFrame("Polinoame");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(630, 400);

		// panelul
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(600, 400));
		panel.setLayout(null);

		// PENTRU PRIMUL POLINOM

		// Create a label with text "Primul polinom: "
		JLabel Polinom1Label = new JLabel("PRIMUL POLINOM ");
		panel.add(Polinom1Label);
		Polinom1Label.setBounds(30, 20, 120, 20);

		// Create a label with text "Coeficient1: "
		JLabel coeficient1Label = new JLabel("Introdu coeficientul: ");
		panel.add(coeficient1Label);
		coeficient1Label.setBounds(170, 20, 120, 20);

		// Create a text field
		JTextField coeficient1TextField = new JTextField("");
		panel.add(coeficient1TextField);
		coeficient1TextField.setBounds(290, 20, 40, 20);

		// Create a label with text "Grad1: "
		JLabel grad1Label = new JLabel("Introdu gradul: ");
		panel.add(grad1Label);
		grad1Label.setBounds(360, 20, 90, 20);

		// Create a text field
		JTextField grad1TextField = new JTextField("");
		panel.add(grad1TextField);
		grad1TextField.setBounds(450, 20, 40, 20);

		// Buton de adaugare la polinom
		JButton polinom1Button = new JButton("ADD");
		panel.add(polinom1Button);
		polinom1Button.setBounds(520, 20, 60, 20);

		// Create a label with text "Polinomul 1: "
		JLabel polinomul1Label = new JLabel("Polinomul 1: ");
		panel.add(polinomul1Label);
		polinomul1Label.setBounds(60, 140, 90, 20);

		// Create a text field
		JTextField polinomul1TextField = new JTextField("");
		panel.add(polinomul1TextField);
		polinomul1TextField.setBounds(140, 140, 150, 20);

		// PENTRU AL 2-LEA POLINOM

		// Create a label with text "Al doilea polinom: "
		JLabel Polinom2Label = new JLabel("AL 2-LEA POLINOM ");
		panel.add(Polinom2Label);
		Polinom2Label.setBounds(30, 80, 120, 20);

		// Create a label with text "Coeficient2: "
		JLabel coeficient2Label = new JLabel("Introdu coeficientul: ");
		panel.add(coeficient2Label);
		coeficient2Label.setBounds(170, 80, 120, 20);

		// Create a text field
		JTextField coeficient2TextField = new JTextField("");
		panel.add(coeficient2TextField);
		coeficient2TextField.setBounds(290, 80, 40, 20);

		// Create a label with text "Grad2: "
		JLabel grad2Label = new JLabel("Introdu gradul: ");
		panel.add(grad2Label);
		grad2Label.setBounds(360, 80, 90, 20);

		// Create a text field
		JTextField grad2TextField = new JTextField("");
		panel.add(grad2TextField);
		grad2TextField.setBounds(450, 80, 40, 20);

		// Buton de adaugare la polinom
		JButton polinom2Button = new JButton("ADD");
		panel.add(polinom2Button);
		polinom2Button.setBounds(520, 80, 60, 20);

		// Create a label with text "Polinomul 2: "
		JLabel polinomul2Label = new JLabel("Polinomul 2: ");
		panel.add(polinomul2Label);
		polinomul2Label.setBounds(330, 140, 90, 20);

		// Create a text field
		JTextField polinomul2TextField = new JTextField("");
		panel.add(polinomul2TextField);
		polinomul2TextField.setBounds(410, 140, 150, 20);

		// PENTRU REZULTAT

		// Create a label with text "Rezultat: "
		JLabel RezultatLabel = new JLabel("Rezultat: ");
		panel.add(RezultatLabel);
		RezultatLabel.setBounds(90, 190, 120, 20);

		// Create a text field
		JTextField RezultatTextField = new JTextField("");
		panel.add(RezultatTextField);
		RezultatTextField.setBounds(160, 190, 210, 20);

		// Buton pentru clear la caseta de rezultat
		JButton clearButton = new JButton("CLEAR");
		panel.add(clearButton);
		clearButton.setBounds(410, 190, 100, 20);

		// PENTRU OPERATII

		// Buton pt adunarea polinoamelor
		JButton adunareButton = new JButton("+");
		panel.add(adunareButton);
		adunareButton.setBounds(100, 250, 60, 50);

		// Buton pt scaderea polinoamelor
		JButton scadereButton = new JButton("-");
		panel.add(scadereButton);
		scadereButton.setBounds(200, 250, 60, 50);

		// Buton pt inmultirea polinoamelor
		JButton inmultireButton = new JButton("X");
		panel.add(inmultireButton);
		inmultireButton.setBounds(300, 250, 60, 50);

		// Buton pt derivarea polinoamelor
		JButton derivareButton = new JButton("'");
		panel.add(derivareButton);
		derivareButton.setBounds(400, 250, 60, 50);

		// Buton pt integrarea polinoamelor
		JButton integrareButton = new JButton("I");
		panel.add(integrareButton);
		integrareButton.setBounds(500, 250, 60, 50);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Poze\\5.jpg"));
		label.setBounds(0, 0, 640, 400);
		panel.add(label);

		frame.setContentPane(panel);
		frame.setVisible(true);

		Polinoame p1 = new Polinoame();
		Polinoame p2 = new Polinoame();
		Polinoame p3 = new Polinoame();
		Polinoame p4 = new Polinoame();
		Polinoame p5 = new Polinoame();
		Polinoame p6 = new Polinoame();

		polinom1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monom m1 = new Monom();
				m1.coeficient = Integer.parseInt(coeficient1TextField.getText());
				m1.grad = Integer.parseInt(grad1TextField.getText());
				p1.addMonom(m1);
				p1.sortarePolinom();

				polinomul1TextField.setText(p1.afisarePolinom());
				coeficient1TextField.setText(null);
				grad1TextField.setText(null);
			}
		});

		polinom2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Monom m2 = new Monom();
				m2.coeficient = Integer.parseInt(coeficient2TextField.getText());
				m2.grad = Integer.parseInt(grad2TextField.getText());
				p2.addMonom(m2);
				p2.sortarePolinom();

				polinomul2TextField.setText(p2.afisarePolinom());
				coeficient2TextField.setText(null);
				grad2TextField.setText(null);
			}
		});

		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RezultatTextField.setText(null);
			}
		});

		adunareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p3.adunarePolinoame(p1, p2);
				RezultatTextField.setText(p3.afisarePolinom());
			}
		});

		scadereButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p4.scaderePolinoame(p1, p2);
				RezultatTextField.setText(p4.afisarePolinom());
			}
		});

		inmultireButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p5.inmultirePolinoame(p1, p2);
				p5.sortarePolinom();
				RezultatTextField.setText(p5.afisarePolinom());
			}
		});

		derivareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1.derivarePolinom();
				RezultatTextField.setText(p1.afisarePolinom());
			}
		});

		integrareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p2.integrarePolinom(p6);
				RezultatTextField.setText(p6.afisarePolinomR());
			}
		});
	}

}
