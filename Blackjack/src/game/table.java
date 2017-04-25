package game;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;

public class table {

  protected Shell shlGroupBlackjack;
  private static Text txtBet;
  private static Text txtPlayerHand;
  private static Text txtDealerHand;
  private static Text txtBank;
  

  
  /**
   * Launch the application.
   * @param args
   */
  public static void main(String[] args) {
    try {
      table window = new table();
      window.open();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    // game objects
    Player player1 = new Player("Player 1");
    Dealer dealer = new Dealer();
    
    /* 
     * game logic
     */
    // minor change blackjack pays $8 to avoid < whole dollars
    while (player1.getBank() > 0) {
      txtBank.setText("$" + Long.toString(player1.getBank()));
      txtBet.setText("$" + Long.toString(0));
      
    }
    
    
    
    /*
     * Game methods/classes
     */
    
  }

  /**
   * Open the window.
   */
  public void open() {
    Display display = Display.getDefault();
    createContents();
    shlGroupBlackjack.open();
    shlGroupBlackjack.layout();
    while (!shlGroupBlackjack.isDisposed()) {
      if (!display.readAndDispatch()) {
        display.sleep();
      }
    }
  }

  /**
   * Create contents of the window.
   */
  protected void createContents() {
    shlGroupBlackjack = new Shell();
    shlGroupBlackjack.setSize(428, 310);
    shlGroupBlackjack.setText("Group 10 Blackjack");
    shlGroupBlackjack.setLayout(new GridLayout(3, false));
    new Label(shlGroupBlackjack, SWT.NONE);
    
    Group grpBank = new Group(shlGroupBlackjack, SWT.NONE);
    GridData gd_grpBank = new GridData(SWT.RIGHT, SWT.FILL, false, false, 2, 1);
    gd_grpBank.widthHint = 187;
    grpBank.setLayoutData(gd_grpBank);
    grpBank.setLayout(new GridLayout(2, false));
    
    Label lblBank = new Label(grpBank, SWT.NONE);
    lblBank.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
    lblBank.setText("Bank:");
    
    txtBank = new Text(grpBank, SWT.BORDER | SWT.RIGHT);
    txtBank.setEditable(false);
    txtBank.setText("$0");
    GridData gd_txtBank = new GridData(SWT.RIGHT, SWT.TOP, true, false, 1, 1);
    gd_txtBank.widthHint = 130;
    txtBank.setLayoutData(gd_txtBank);
    
    Group grpGame = new Group(shlGroupBlackjack, SWT.NONE);
    GridData gd_grpGame = new GridData(SWT.FILL, SWT.FILL, false, false, 2, 2);
    gd_grpGame.widthHint = 189;
    grpGame.setLayoutData(gd_grpGame);
    grpGame.setLayout(new GridLayout(2, false));
    
    Label lblDealerHand = new Label(grpGame, SWT.NONE);
    lblDealerHand.setText("Dealer Hand");
    
    txtDealerHand = new Text(grpGame, SWT.BORDER);
    txtDealerHand.setEditable(false);
    GridData gd_txtDealerHand = new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1);
    gd_txtDealerHand.widthHint = 89;
    txtDealerHand.setLayoutData(gd_txtDealerHand);
    
    Label lblPlayerHand = new Label(grpGame, SWT.NONE);
    lblPlayerHand.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
    lblPlayerHand.setText("Player Hand");
    
    txtPlayerHand = new Text(grpGame, SWT.BORDER);
    txtPlayerHand.setEditable(false);
    txtPlayerHand.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false, 1, 1));
    new Label(shlGroupBlackjack, SWT.NONE);
    
    Label lblResults = new Label(shlGroupBlackjack, SWT.NONE);
    lblResults.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
    lblResults.setEnabled(false);
    lblResults.setText("Player Wins!");
    
    Group grpControls = new Group(shlGroupBlackjack, SWT.NONE);
    grpControls.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
    grpControls.setLayout(new GridLayout(2, false));
    
    Button btnHit = new Button(grpControls, SWT.NONE);
    btnHit.setText("Hit");
    
    Button btnStand = new Button(grpControls, SWT.NONE);
    btnStand.setText("Stand");
    
    Group grpBetDisplay = new Group(shlGroupBlackjack, SWT.NONE);
    grpBetDisplay.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 2, 1));
    grpBetDisplay.setLayout(new GridLayout(2, false));
    
    Label lblCurrentBet = new Label(grpBetDisplay, SWT.CENTER);
    lblCurrentBet.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
    lblCurrentBet.setText("Current Bet:");
    
    txtBet = new Text(grpBetDisplay, SWT.BORDER | SWT.RIGHT);
    txtBet.setEditable(false);
    GridData gd_txtBet = new GridData(SWT.RIGHT, SWT.CENTER, true, false, 1, 1);
    gd_txtBet.widthHint = 128;
    txtBet.setLayoutData(gd_txtBet);
    txtBet.setText("$0");
    new Label(shlGroupBlackjack, SWT.NONE);
    
    Group grpBetControls = new Group(shlGroupBlackjack, SWT.NONE);
    grpBetControls.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 2, 1));
    grpBetControls.setLayout(new GridLayout(7, false));
    
    Button btnMinus10 = new Button(grpBetControls, SWT.NONE);
    btnMinus10.setText("-$10");
    
    Button btnMinus5 = new Button(grpBetControls, SWT.NONE);
    btnMinus5.setText("-$5");
    
    Button btnMinus1 = new Button(grpBetControls, SWT.NONE);
    btnMinus1.setText("-$1");
    
    Button btnBet = new Button(grpBetControls, SWT.NONE);
    btnBet.addSelectionListener(new SelectionAdapter() {
      @Override
      public void widgetSelected(SelectionEvent e) {
      }
    });
    btnBet.setText("Deal");
    
    Button btnPlus1 = new Button(grpBetControls, SWT.NONE);
    btnPlus1.setText("+$1");
    
    Button btnPlus5 = new Button(grpBetControls, SWT.NONE);
    btnPlus5.setText("+$5");
    
    Button btnPlus10 = new Button(grpBetControls, SWT.NONE);
    btnPlus10.setText("+$10");

  }
}
