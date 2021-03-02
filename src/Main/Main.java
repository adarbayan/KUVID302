package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

import UI.GameEngine;
import UI.GameScreen;
import UI.HelpText;

class BuildMode implements Runnable, ActionListener {
	public Boolean startGame = false;

	private int unitLengthL;

	private int[] numberOfGameElements = new int[18];
	

	@Override
	public void run() {
		HelpText text = new HelpText();

		Thread thread = new Thread(this);

		JFrame window = new JFrame("Building Mode");
		JButton start = new JButton("<html> <h3 style=\"color:black;\">Start </h3> </html>");
		JTextArea atomAlphaNumber = new JTextArea(1, 2);
		JTextArea atomBetaNumber = new JTextArea(1, 2);
		JTextArea atomGammaNumber = new JTextArea(1, 2);
		JTextArea atomSigmaNumber = new JTextArea(1, 2);

		JTextArea moleculeAlphaNumber = new JTextArea(1, 2);
		JTextArea moleculeBetaNumber = new JTextArea(1, 2);
		JTextArea moleculeGammaNumber = new JTextArea(1, 2);
		JTextArea moleculeSigmaNumber = new JTextArea(1, 2);

		JTextArea reactionAlphaBlockerNumber = new JTextArea(1, 2);
		JTextArea reactionBetaBlockerNumber = new JTextArea(1, 2);
		JTextArea reactionGammaBlockerNumber = new JTextArea(1, 2);
		JTextArea reactionSigmaBlockerNumber = new JTextArea(1, 2);

		JTextArea powerUpsAlphaNumber = new JTextArea(1, 2);
		JTextArea powerUpsBetaNumber = new JTextArea(1, 2);
		JTextArea powerUpsGammaNumber = new JTextArea(1, 2);
		JTextArea powerUpsSigmaNumber = new JTextArea(1, 2);

		// New
		JTextArea unitL = new JTextArea(1, 2);
		JTextArea mType = new JTextArea(1, 2);
		// New
		JLabel help = new JLabel(text.helpText);

		JLabel atomAlphaLabel = new JLabel("<html> <h4 style=\"color:blue;\">#Number Of Alpha Atoms</h4> </html>");
		JLabel atomBetaLabel = new JLabel("<html> <h4 style=\"color:blue;\">#Number Of Beta Atoms</h4> </html>");
		JLabel atomGammaLabel = new JLabel("<html> <h4 style=\"color:blue;\">#Number Of Gamma Atoms</h4> </html>");
		JLabel atomSigmaLabel = new JLabel("<html> <h4 style=\"color:blue;\">#Number Of Sigma Atoms</h4> </html>");

		JLabel moleculeAlphaLabel = new JLabel(
				"<html> <h4 style=\"color:blue;\">#Number Of Alpha Molecules</h4> </html>");
		JLabel moleculeBetaLabel = new JLabel(
				"<html> <h4 style=\"color:blue;\">#Number Of Beta Molecules</h4> </html>");
		JLabel moleculeGammaLabel = new JLabel(
				"<html> <h4 style=\"color:blue;\">#Number Of Gamma Molecules</h4> </html>");
		JLabel moleculeSigmaLabel = new JLabel(
				"<html> <h4 style=\"color:blue;\">#Number Of Sigma Molecules</h4> </html>");

		JLabel reactionBlockerAlphaLabel = new JLabel(
				"<html> <h4 style=\"color:blue;\">#Number Of Alpha Reaction Blockers</h4> </html>");
		JLabel reactionBlockerBetaLabel = new JLabel(
				"<html> <h4 style=\"color:blue;\">#Number Of Beta Reaction Blockers</h4> </html>");
		JLabel reactionBlockerGammaLabel = new JLabel(
				"<html> <h4 style=\"color:blue;\">#Number Of Gamma Reaction Blockers</h4> </html>");
		JLabel reactionBlockerSigmaLabel = new JLabel(
				"<html> <h4 style=\"color:blue;\">#Number Of Sigma Reaction Blockers</h4> </html>");

		JLabel powerUpAlphaLabel = new JLabel(
				"<html> <h4 style=\"color:blue;\">#Number Of Alpha PowerUps</h4> </html>");
		JLabel powerUpBetaLabel = new JLabel("<html> <h4 style=\"color:blue;\">#Number Of Beta PowerUps</h4> </html>");
		JLabel powerUpGammaLabel = new JLabel(
				"<html> <h4 style=\"color:blue;\">#Number Of Gamma PowerUps</h4> </html>");
		JLabel powerUpSigmaLabel = new JLabel(
				"<html> <h4 style=\"color:blue;\">#Number Of Sigma PowerUps</h4> </html>");
		// New
		JLabel unitLLabel = new JLabel("<html> <h4 style=\"color:blue;\">#Unit Length of L</h4> </html>");
		JLabel mTypeLabel = new JLabel("<html> <h4 style=\"color:blue;\">#Molecule Type:</h4> </html>");
		// New
		atomAlphaNumber.setText("100");
		atomBetaNumber.setText("100");
		atomGammaNumber.setText("100");
		atomSigmaNumber.setText("100");

		moleculeAlphaNumber.setText("10");
		moleculeBetaNumber.setText("10");
		moleculeGammaNumber.setText("10");
		moleculeSigmaNumber.setText("10");

		reactionAlphaBlockerNumber.setText("1");
		reactionBetaBlockerNumber.setText("1");
		reactionGammaBlockerNumber.setText("1");
		reactionSigmaBlockerNumber.setText("1");

		powerUpsAlphaNumber.setText("5");
		powerUpsBetaNumber.setText("5");
		powerUpsGammaNumber.setText("5");
		powerUpsSigmaNumber.setText("5");
		// New
		unitL.setText("70");
		mType.setText("1");
		// New
		JPanel panel = new JPanel();
		panel.setSize(300, 300);

		window.setBounds(10, 10, 700, 600);
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.setLayout(null);

		mTypeLabel.setBounds(0, 330, 250, 15);
		panel.add(mTypeLabel);

		panel.add(atomAlphaLabel);
		panel.add(atomBetaLabel);
		panel.add(atomGammaLabel);
		panel.add(atomSigmaLabel);

		panel.add(moleculeAlphaLabel);
		panel.add(moleculeBetaLabel);
		panel.add(moleculeGammaLabel);
		panel.add(moleculeSigmaLabel);

		panel.add(reactionBlockerAlphaLabel);
		panel.add(reactionBlockerBetaLabel);
		panel.add(reactionBlockerGammaLabel);
		panel.add(reactionBlockerSigmaLabel);

		panel.add(powerUpAlphaLabel);
		panel.add(powerUpBetaLabel);
		panel.add(powerUpGammaLabel);
		panel.add(powerUpSigmaLabel);
		// New
		panel.add(unitLLabel);
		panel.add(mTypeLabel);
		// New
		panel.add(atomAlphaNumber);
		panel.add(atomBetaNumber);
		panel.add(atomGammaNumber);
		panel.add(atomSigmaNumber);

		panel.add(moleculeAlphaNumber);
		panel.add(moleculeBetaNumber);
		panel.add(moleculeGammaNumber);
		panel.add(moleculeSigmaNumber);

		panel.add(reactionAlphaBlockerNumber);
		panel.add(reactionBetaBlockerNumber);
		panel.add(reactionGammaBlockerNumber);
		panel.add(reactionSigmaBlockerNumber);

		panel.add(powerUpsAlphaNumber);
		panel.add(powerUpsBetaNumber);
		panel.add(powerUpsGammaNumber);
		panel.add(powerUpsSigmaNumber);
		// New
		panel.add(mType);
		panel.add(unitL);
		// New
		atomAlphaLabel.setBounds(0, 50, 250, 15);
		atomAlphaNumber.setBounds(250, 50, 100, 15);

		atomBetaLabel.setBounds(0, 65, 200, 15);
		atomBetaNumber.setBounds(250, 65, 100, 15);

		atomGammaLabel.setBounds(0, 80, 250, 15);
		atomGammaNumber.setBounds(250, 80, 100, 15);

		atomSigmaLabel.setBounds(0, 95, 250, 15);
		atomSigmaNumber.setBounds(250, 95, 100, 15);

		moleculeAlphaLabel.setBounds(0, 110, 250, 15);
		moleculeAlphaNumber.setBounds(250, 110, 100, 15);

		moleculeBetaLabel.setBounds(0, 125, 250, 15);
		moleculeBetaNumber.setBounds(250, 125, 100, 15);

		moleculeGammaLabel.setBounds(0, 140, 250, 15);
		moleculeGammaNumber.setBounds(250, 140, 100, 15);

		moleculeSigmaLabel.setBounds(0, 155, 250, 15);
		moleculeSigmaNumber.setBounds(250, 155, 100, 15);

		reactionBlockerAlphaLabel.setBounds(0, 170, 250, 15);
		reactionAlphaBlockerNumber.setBounds(250, 170, 100, 15);

		reactionBlockerBetaLabel.setBounds(0, 185, 250, 15);
		reactionBetaBlockerNumber.setBounds(250, 185, 100, 15);

		reactionBlockerGammaLabel.setBounds(0, 200, 250, 15);
		reactionGammaBlockerNumber.setBounds(250, 200, 100, 15);

		reactionBlockerSigmaLabel.setBounds(0, 215, 250, 15);
		reactionSigmaBlockerNumber.setBounds(250, 215, 100, 15);

		powerUpAlphaLabel.setBounds(0, 230, 250, 15);
		powerUpsAlphaNumber.setBounds(250, 230, 100, 15);

		powerUpBetaLabel.setBounds(0, 245, 250, 15);
		powerUpsBetaNumber.setBounds(250, 245, 100, 15);

		powerUpGammaLabel.setBounds(0, 260, 250, 15);
		powerUpsGammaNumber.setBounds(250, 260, 100, 15);

		powerUpSigmaLabel.setBounds(0, 275, 250, 15);
		powerUpsSigmaNumber.setBounds(250, 275, 100, 15);
		// new
		unitLLabel.setBounds(0, 290, 250, 15);
		unitL.setBounds(250, 290, 100, 15);

		mTypeLabel.setBounds(0, 305, 250, 15);
		mType.setBounds(250, 305, 100, 15);
		// new

		window.add(panel, BorderLayout.CENTER);
		panel.add(start);
		start.setBackground(Color.green);
		start.setBounds(400, 200, 150, 100);
		panel.add(help);
		help.setBounds(0, 250, 700, 400);

		window.setVisible(true);
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					numberOfGameElements[0] = Integer.parseInt(atomAlphaNumber.getText());
					numberOfGameElements[1] = Integer.parseInt(atomBetaNumber.getText());
					numberOfGameElements[2] = Integer.parseInt(atomGammaNumber.getText());
					numberOfGameElements[3] = Integer.parseInt(atomSigmaNumber.getText());

					numberOfGameElements[4] = Integer.parseInt(moleculeAlphaNumber.getText());
					numberOfGameElements[5] = Integer.parseInt(moleculeBetaNumber.getText());
					numberOfGameElements[6] = Integer.parseInt(moleculeGammaNumber.getText());
					numberOfGameElements[7] = Integer.parseInt(moleculeSigmaNumber.getText());

					numberOfGameElements[8] = Integer.parseInt(reactionAlphaBlockerNumber.getText());
					numberOfGameElements[9] = Integer.parseInt(reactionBetaBlockerNumber.getText());
					numberOfGameElements[10] = Integer.parseInt(reactionGammaBlockerNumber.getText());
					numberOfGameElements[11] = Integer.parseInt(reactionSigmaBlockerNumber.getText());

					numberOfGameElements[12] = Integer.parseInt(powerUpsAlphaNumber.getText());
					numberOfGameElements[13] = Integer.parseInt(powerUpsBetaNumber.getText());
					numberOfGameElements[14] = Integer.parseInt(powerUpsAlphaNumber.getText());
					numberOfGameElements[15] = Integer.parseInt(powerUpsSigmaNumber.getText());
					// new
					numberOfGameElements[16] = Integer.parseInt(unitL.getText());
					numberOfGameElements[17] = Integer.parseInt(mType.getText());
					for (int i = 0; i < numberOfGameElements.length; i++) {
						if ((numberOfGameElements[i] < 0) || (numberOfGameElements[i] > 200)) {
							throw new IOException();
						}
					}
					System.out.println("Inputs are correct");
					// new

				} catch (Exception e) {

					System.out.println("Wrong input.");
					OptionPaneExample();
				}
				GameEngine gameEngine = new GameEngine(numberOfGameElements, numberOfGameElements[16]);
				gameEngine.go();
				GameScreen game = new GameScreen(gameEngine);
				Thread  thread2 = new Thread(game);
				
					thread2.start();
			}
		});

	}

	JFrame f;

	void OptionPaneExample() {
		f = new JFrame();
		JOptionPane.showMessageDialog(f, "Wrong Input.");
	}

	public Boolean getStartGame() {
		return startGame;

	}

	public void setStartGame(Boolean startGame) {
		this.startGame = startGame;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}

public class Main {

	public static void main(String[] args) {

		BuildMode runnable = new BuildMode();
		Thread thread = new Thread(runnable);

		thread.start();

	}

}