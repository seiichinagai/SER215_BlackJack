package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResultScreen extends JFrame {
  private static final int FRAME_WIDTH = 400;
  private static final int FRAME_HEIGHT = 100;

  private JTextArea resultArea;
  private JButton playAgainButton;
  private JButton newGameButton;
  private JButton quitButton;
  private JFrame frame;
  private int result = 0;

  public ResultScreen(int result) {
    setSize(FRAME_WIDTH, FRAME_HEIGHT);

    this.result = result;
    createResultArea();
    createPlayAgainButton();
    createNewGameButton();
    createQuitButton();
    initialize();
  }

  // gets win/loss information from player class
  public void createResultArea() {
    String gameResult = null;
    switch (result) {
      case 1: {
        gameResult = "Congratulations, you won! Your winnings have been added to your bank";
        break;
      }
      case 2: {
        gameResult = "Unfortunately, the dealer won. You should try again.";
        break;
      }
      case 3: {
        gameResult = "It was a tie! Your bet has been refunded.";
        break;
      }
      default: {
        gameResult = "Something went wrong determining results";
        break;
      }
    }
    resultArea = new JTextArea(gameResult + "\nPlayer: " + ProfileScreen.getPlayer().getName()
        + "\nWins: " + ProfileScreen.getPlayer().getWins() + "\nLosses: "
        + ProfileScreen.getPlayer().getLosses() + "\nTotal Games: "
        + ProfileScreen.getPlayer().getTotalGames() + "\nTotal Bank: $"
        + ProfileScreen.getPlayer().getBank() + "\nTotal Loans: $"
        + ProfileScreen.getPlayer().getLoan());
    resultArea.setEditable(false);
  }

  public void createPlayAgainButton() {
    playAgainButton = new JButton("Play Again?");

    ActionListener listener = new PlayListener();
    playAgainButton.addActionListener(listener);
  }

  class PlayListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      frame.setVisible(false);
      GameFrame.main(null);
      frame.dispose();
    }
  }

  public void createNewGameButton() {
    newGameButton = new JButton("New Game");
    ActionListener listener = new NewGameListener();
    newGameButton.addActionListener(listener);
  }

  class NewGameListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      IntroScreen is = new IntroScreen();
      frame.dispose();
    }
  }

  public void createQuitButton() {
    quitButton = new JButton("Quit");
    ActionListener listener = new QuitListener();
    quitButton.addActionListener(listener);
  }

  class QuitListener implements ActionListener {
    public void actionPerformed(ActionEvent event) {
      System.exit(0);
    }
  }

  public void initialize() {
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());

    panel.add(resultArea, BorderLayout.NORTH);
    panel.add(playAgainButton, BorderLayout.WEST);
    panel.add(newGameButton, BorderLayout.CENTER);
    panel.add(quitButton, BorderLayout.EAST);

    frame = new JFrame("Results");
    frame.setSize(400, 200);
    frame.add(panel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
    frame.setTitle("BlackJack Results");
  }
}
