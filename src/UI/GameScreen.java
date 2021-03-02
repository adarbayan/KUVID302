package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Domain.GameController;
import Domain.LocalFile;

public class GameScreen implements Runnable {
	ButtonPanel buttons = new ButtonPanel();
	//new
	JButton pause = new JButton("Play/Pause");
	JButton saveLocal = new JButton("SaveLocal");
	JButton saveMongo = new JButton("SaveMongo");
	JButton loadLocal = new JButton("LoadLocal");
	JButton etaShield = new JButton("Eta-S");
	JButton zetaShield = new JButton("Zeta-S");
	JButton thetaShield = new JButton("Theta-S");
	JButton lotaShield = new JButton("Lota-S");
	
	GameEngine gamePlay;
	//new
	JFrame window=new JFrame("Kuvid302  Game(Press Play/Pause button first,then please click tab on your keyboard for gun)");

	public GameScreen(GameEngine gameEngine) {
		gamePlay = gameEngine;
	}

	@Override
	public void run() {
		Font f = new Font("Helvetica", Font.PLAIN, 8);
		Font f2 = new Font("Helvetica", Font.PLAIN, 10);
		lotaShield.setPreferredSize(new Dimension(60,25));
		lotaShield.setFont(f);
		thetaShield.setPreferredSize(new Dimension(60,25));
		thetaShield.setFont(f);
		zetaShield.setPreferredSize(new Dimension(60,25));
		zetaShield.setFont(f);
		etaShield.setPreferredSize(new Dimension(60,25));
		etaShield.setFont(f);
		saveMongo.setPreferredSize(new Dimension(90,25));
		saveMongo.setFont(f2);
		saveLocal.setPreferredSize(new Dimension(90,25));
		saveLocal.setFont(f2);
		loadLocal.setPreferredSize(new Dimension(90,25));
		loadLocal.setFont(f2);
		pause.setPreferredSize(new Dimension(90,25));
		pause.setFont(f2);

		window.setBounds(10, 10, 700 , 620);
		window.setResizable(false);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//new
		window.add(buttons, BorderLayout.PAGE_START);

		window.add(gamePlay, BorderLayout.CENTER);
		window.setVisible(true);
		pause.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(gamePlay.timer.isRunning()) {
					gamePlay.timer.stop();
				}else {
					gamePlay.timer.restart();
				}
			}
			
		});
		saveLocal.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if(gamePlay.timer.isRunning()) {
					gamePlay.timer.stop();
					try {
						gamePlay.game.getBoard().localSaver();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					gamePlay.timer.restart();
				}
			}
			
		});
		saveMongo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gamePlay.timer.isRunning()) {
					try {
						gamePlay.game.getBoard().mongoSaver();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		loadLocal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(gamePlay.timer.isRunning())) {
					try {
						gamePlay.game.getBoard().localLoad();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		etaShield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePlay.addShields(0);
			}
		});
		zetaShield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePlay.addShields(1);
			
			}
		});
		thetaShield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePlay.addShields(2);
			}
		});
		lotaShield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gamePlay.addShields(3);
			}
		});
		
		buttons.add(pause);
		pause.setFocusable(false);
		buttons.add(saveLocal);
		saveLocal.setFocusable(false);
		buttons.add(saveMongo);
		saveMongo.setFocusable(false);
		buttons.add(loadLocal);
		loadLocal.setFocusable(false);
		buttons.add(lotaShield);
		lotaShield.setFocusable(false);
		buttons.add(thetaShield);
		thetaShield.setFocusable(false);
		buttons.add(zetaShield);
		zetaShield.setFocusable(false);
		buttons.add(etaShield);
		etaShield.setFocusable(false);
		
		window.setBounds(10,10,700,620);
		window.setResizable(false);
		//window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(gamePlay,BorderLayout.CENTER);
		//window.add(buttons,BorderLayout.PAGE_START);
	
		window.setVisible(true);
		
		//new
		
		
		
	}
	
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	
	}
			
}