package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import environment.Environment;
import gameplay.TimerObserver;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.ChainGun;
import weapon.Pistol;
import weapon.PlasmaCannon;
import weapon.Weapon;

/**
* The Swing GUI for the game board.
* @author Daniel Pavenko
*/
public class GameUi implements TimerObserver {
  
  //constant for border size of elements
  private static final int BORDER_WIDTH = 1;
  
  //constants for our weapon image paths
  private static final String PISTOL_IMAGE_PATH = "src/main/java/assets/images/pistol.png";
  private static final String CHAINGUN_IMAGE_PATH = "src/main/java/assets/images/chainGun.png";
  private static final String PLASMACANNON_IMAGE_PATH
  = "src/main/java/assets/images/plasmaCannon.png";
  
  //unarmed human path(s)
  private static final String HUMAN_NORTH_PATH = "src/main/java/assets/images/humannorth.png";
  private static final String HUMAN_SOUTH_PATH = "src/main/java/assets/images/humansouth.png";
  private static final String HUMAN_EAST_PATH = "src/main/java/assets/images/humaneast.png";
  private static final String HUMAN_WEST_PATH = "src/main/java/assets/images/humanwest.png";
  
  //unarmed alien path(s)
  private static final String ALIEN_NORTH_PATH = "src/main/java/assets/images/aliennorth.png";
  private static final String ALIEN_SOUTH_PATH = "src/main/java/assets/images/aliensouth.png";
  private static final String ALIEN_EAST_PATH = "src/main/java/assets/images/alieneast.png";
  private static final String ALIEN_WEST_PATH = "src/main/java/assets/images/alienwest.png";
  
  //pistol human path(s)
  private static final String HUMAN_NORTH_PISTOL_PATH
  = "src/main/java/assets/images/humanpistolnorth.png";
  private static final String HUMAN_SOUTH_PISTOL_PATH
  = "src/main/java/assets/images/humanpistolsouth.png";
  private static final String HUMAN_EAST_PISTOL_PATH
  = "src/main/java/assets/images/humanpistoleast.png";
  private static final String HUMAN_WEST_PISTOL_PATH
  = "src/main/java/assets/images/humanpistolwest.png";
  
  //plasma human path(s)
  private static final String HUMAN_NORTH_PLASMACANNON_PATH
  = "src/main/java/assets/images/humanplasmanorth.png";
  private static final String HUMAN_SOUTH_PLASMACANNON_PATH
  = "src/main/java/assets/images/humanplasmasouth.png";
  private static final String HUMAN_EAST_PLASMACANNON_PATH
  = "src/main/java/assets/images/humanplasmaeast.png";
  private static final String HUMAN_WEST_PLASMACANNON_PATH
  = "src/main/java/assets/images/humanplasmawest.png";
  
  //chain human path(s)
  private static final String HUMAN_NORTH_CHAINGUN_PATH
  = "src/main/java/assets/images/humanchainnorth.png";
  private static final String HUMAN_SOUTH_CHAINGUN_PATH
  = "src/main/java/assets/images/humanchainsouth.png";
  private static final String HUMAN_EAST_CHAINGUN_PATH
  = "src/main/java/assets/images/humanchaineast.png";
  private static final String HUMAN_WEST_CHAINGUN_PATH
  = "src/main/java/assets/images/humanchainwest.png";
  
  //pistol alien path(s)
  private static final String ALIEN_NORTH_PISTOL_PATH
  = "src/main/java/assets/images/alienpistolnorth.png";
  private static final String ALIEN_SOUTH_PISTOL_PATH
  = "src/main/java/assets/images/alienpistolsouth.png";
  private static final String ALIEN_EAST_PISTOL_PATH
  = "src/main/java/assets/images/alienpistoleast.png";
  private static final String ALIEN_WEST_PISTOL_PATH
  = "src/main/java/assets/images/alienpistolwest.png";
  
  //plasma alien path(s)
  private static final String ALIEN_NORTH_PLASMACANNON_PATH
  = "src/main/java/assets/images/alienplasmanorth.png";
  private static final String ALIEN_SOUTH_PLASMACANNON_PATH
  = "src/main/java/assets/images/alienplasmasouth.png";
  private static final String ALIEN_EAST_PLASMACANNON_PATH
  = "src/main/java/assets/images/alienplasmaeast.png";
  private static final String ALIEN_WEST_PLASMACANNON_PATH
  = "src/main/java/assets/images/alienplasmawest.png";
  
  //chain alien path(s)
  private static final String ALIEN_NORTH_CHAINGUN_PATH
  = "src/main/java/assets/images/alienchainnorth.png";
  private static final String ALIEN_SOUTH_CHAINGUN_PATH
  = "src/main/java/assets/images/alienchainsouth.png";
  private static final String ALIEN_EAST_CHAINGUN_PATH
  = "src/main/java/assets/images/alienchaineast.png";
  private static final String ALIEN_WEST_CHAINGUN_PATH
  = "src/main/java/assets/images/alienchainwest.png";
  
  //legend images path(s)
  private static final String HUMAN_LEGEND_IMAGE_PATH
  = "src/main/java/assets/images/legend icons/humanLegend.png";
  private static final String ALIEN_LEGEND_IMAGE_PATH
  = "src/main/java/assets/images/legend icons/alienLegend.png";
  private static final String PISTOL_LEGEND_IMAGE_PATH
  = "src/main/java/assets/images/legend icons/pistolLegend.png";
  private static final String CHAINGUN_LEGEND_IMAGE_PATH
  = "src/main/java/assets/images/legend icons/chaingunLegend.png";
  private static final String PLASMACANNON_LEGEND_IMAGE_PATH
  = "src/main/java/assets/images/legend icons/plasmaCannonLegend.png";
  
  //our board (matrix)
  private JButton[][] boardArray;
  
  //our environment
  private Environment world;
  
  //all of our swing elements
  private JTextArea displayTextArea;
  private JTextField textFieldHealth;
  private JTextField textFieldAmmo;
  private JTextField textFieldEquippedWeapon;
  private JTextField textFieldWeapon1;
  private JTextField textFieldWeapon2;
  private JTextField textFieldRecoveryRate;
  private JTextField textFieldRecoveryType;
  private JTextField textFieldArmor;
  private JTextField textFieldSelectedCoords;
  
  
  
  
  //data points for our text elements
  private int[] selectedArr = {-1, -1};
  
  
  //our GUI as a var
  private static GameUi instanceOfGameUI;
  
  //our selected lifeform, set it to a very unique human so that the selection following code works
  private LifeForm selectedLifeForm = new Human("temphuman-temphuman-temphuman", 999, 999);
  
  /**
  * constructor for GUI, removed the "startUI" and put
  * the initiliazation code within this constructor.
  * @param world
  */
  private GameUi(Environment world) {
    this.world = world;
    createFrame();
  }
  
  /**
  * Singleton type getter for our class. This getter takes in an instance of environment. If we
  * already have an instance of GameUI, we return it. If we dont have an instance of GameUI,
  * we create one and return it.
  */
  public static GameUi getGameUi(Environment world) {
    if (instanceOfGameUI == null) {
      instanceOfGameUI = new GameUi(world);
    }
    return instanceOfGameUI;
  }
  
  /**
  * Overloaded "regular" getter for an instance of our class.
  * Takes no inputs and just returns the instance.
  */
  public static GameUi getGameUi() {
    return instanceOfGameUI;
  }
  
  /**
  * Creates and displays the main JFrame.
  */
  private void createFrame() {
    JFrame boardFrame = new JFrame("Humans & Aliens Game");
    boardFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    boardFrame.setLayout(new BorderLayout());
    boardFrame.add(createContainerPanel(), BorderLayout.CENTER);
    boardFrame.setSize(1350, 900);
    boardFrame.setVisible(true);
  }
  
  /**
  * Creates and returns the JPanel "containerPanel". This is our first panel that sits on top of
  * the main JFrame. This panel is responsible for formatting everything
  * and it "houses" all other panels / components.
  * @return containerPanel
  */
  private JPanel createContainerPanel() {
    // the panels that will house the legend, board, moves display & cell info section.
    final JPanel legendPanel = createLegendPanel();
    final JPanel boardPanel = createBoardPanel();
    final JPanel displayBoxPanel = createDisplayBoxPanel();
    final JPanel infoPanel = createInfoPanel();
    // container panel that holds our panels
    final JPanel containerPanel = new JPanel(new GridBagLayout());
    
    // set constraints to make "legendPanel" take 1/5 of the width & 5/6 of the height
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0; 
    gbc.gridy = 0;
    gbc.weightx = 1.5 / 5.0; // take up a 1.5/5 of width
    gbc.weighty = 4.0 / 5.0; // take up 4/5 of height
    gbc.fill = GridBagConstraints.BOTH;
    containerPanel.add(legendPanel, gbc);
    
    // set constraints to make "boardPanel" take 4/5 of the width & 5/6 of the height
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.weightx = 3.5 / 5.0; // take up 3.5/5 of width
    gbc.weighty = 4.0 / 5.0; // take up 4/5 of height
    gbc.fill = GridBagConstraints.BOTH;
    containerPanel.add(boardPanel, gbc);
    
    // set constraints to make "displayBoxPanel" take 1/5 of the width & 1/6 of the height
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.weightx = 1.0 / 5.0; // take up 1/5 of the width
    gbc.weighty = 1.0 / 5.0; // take up 2/5 of the height
    gbc.fill = GridBagConstraints.BOTH;
    containerPanel.add(displayBoxPanel, gbc);
    
    // set constraints to make "infoPanel" take 4/5 of the width & 1/6 of the height
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 4.0 / 5.0; // take up 4/5 of the width
    gbc.weighty = 1.0 / 5.0; // take up 1/5 of the height
    gbc.fill = GridBagConstraints.BOTH;
    containerPanel.add(infoPanel, gbc);
    
    return containerPanel;
  }
  
  /**
  * Creates and returns the JPanel "legendPanel". This panel will house our legend / instructions.
  * @return legendPanel
  */
  private JPanel createLegendPanel() {
    //the legend panel itself
    JPanel legendPanel = new JPanel();
    legendPanel.setLayout(new BorderLayout());
    
    // top "half": instruction text area
    JTextArea legendInstructionTextArea = createLegendInstructionTextArea();
    JScrollPane legendInstructionTextAreaScrollPane = new JScrollPane(legendInstructionTextArea);
    legendPanel.add(legendInstructionTextAreaScrollPane, BorderLayout.CENTER);
    
    // Bottom "half": 2x2 grid with pictures in row 1 and text boxes in row 2
    JPanel legendGridPanel = new JPanel(new GridLayout(2, 2));
    
    // Panel for the first picture (human)
    JPanel picturePanel1 = new JPanel(new BorderLayout());
    JLabel pictureLabel1 = new JLabel(new ImageIcon(HUMAN_LEGEND_IMAGE_PATH));
    picturePanel1.setBackground(Color.gray);
    picturePanel1.add(pictureLabel1, BorderLayout.WEST);
    legendGridPanel.add(picturePanel1);
    
    // Panel for the second picture (alien)
    JPanel picturePanel2 = new JPanel(new BorderLayout());
    JLabel pictureLabel2 = new JLabel(new ImageIcon(ALIEN_LEGEND_IMAGE_PATH));
    picturePanel2.setBackground(Color.gray);
    picturePanel2.add(pictureLabel2, BorderLayout.CENTER);
    legendGridPanel.add(picturePanel2);
    
    // Panel for the third picture (plasmacannon)
    JPanel picturePanel3 = new JPanel(new BorderLayout());
    JLabel pictureLabel3 = new JLabel(new ImageIcon(PLASMACANNON_LEGEND_IMAGE_PATH));
    picturePanel3.setBackground(Color.gray);
    picturePanel3.add(pictureLabel3, BorderLayout.EAST);
    legendGridPanel.add(picturePanel3);
    
    // Panel for the fourth picture (pistol)
    JPanel picturePanel4 = new JPanel(new BorderLayout());
    JLabel pictureLabel4 = new JLabel(new ImageIcon(PISTOL_LEGEND_IMAGE_PATH));
    picturePanel4.setBackground(Color.gray);
    picturePanel4.add(pictureLabel4, BorderLayout.WEST);
    legendGridPanel.add(picturePanel4);
    
    // Panel for the fifth picture (chaingun)
    JPanel picturePanel5 = new JPanel(new BorderLayout());
    JLabel pictureLabel5 = new JLabel(new ImageIcon(CHAINGUN_LEGEND_IMAGE_PATH));
    picturePanel5.setBackground(Color.gray);
    picturePanel5.add(pictureLabel5, BorderLayout.CENTER);
    legendGridPanel.add(picturePanel5);
    
    // Panel for the fifth picture (placeholder)
    JPanel picturePanel6 = new JPanel(new BorderLayout());
    JLabel pictureLabel6 = new JLabel(new ImageIcon("placeholder"));
    picturePanel6.setBackground(Color.gray);
    picturePanel6.add(pictureLabel6, BorderLayout.CENTER);
    legendGridPanel.add(picturePanel6);
    
    // Add the grid panel to the bottom half of the legend panel
    legendPanel.add(legendGridPanel, BorderLayout.SOUTH);
    
    legendPanel.setBackground(Color.white);
    legendPanel.setBorder(new LineBorder(Color.BLACK, BORDER_WIDTH));
    
    // Set preferred size to ensure fixed size
    legendPanel.setPreferredSize(new Dimension(150, 400));
    
    return legendPanel;
  }
  
  /**
  * Creates and houses the matrix / board. Also populates the board at start
  * @return boardPanel
  */
  private JPanel createBoardPanel() {
    
    int numOfRows = this.world.getNumRows();
    int numOfCols = this.world.getNumCols();
    
    //creates the UI grid and sizes it
    JPanel boardPanel = new JPanel(new GridLayout(numOfRows, numOfCols));
    boardPanel.setBorder(new LineBorder(Color.BLACK, BORDER_WIDTH));
    
    this.boardArray = new JButton[numOfCols][numOfRows];
    
    for (int row = 0; row < numOfRows; row++) {
      for (int col = 0; col < numOfCols; col++) {
        //button logic
        JButton button = new JButton();
        button.setBackground(Color.lightGray);
        button.setOpaque(true);
        button.setBorder(new LineBorder(Color.BLACK, BORDER_WIDTH));
        
        // Adds the ActionListener to each button (button selection)
        button.addActionListener(new ButtonClickListener());
        
        //looks for lifeforms and applies them to our buttons
        LifeForm currLifeForm = world.getLifeForm(row, col);
        String direction;
        Weapon equippedWeapon;
        // null check so we dont get the direction of a cell with no lifeform, etc
        if (currLifeForm != null) {
          direction = world.getLifeForm(row, col).getCurrentDirection();
          equippedWeapon = world.getLifeForm(row, col).getWeapon();
        } else {
          direction = "null";
          equippedWeapon = null;
        }
        
        // unequipped weapons in environment
        Weapon currWeapon = world.getWeapons(row, col)[0];
        if (currWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(PLASMACANNON_IMAGE_PATH));
        } else if (currWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(PISTOL_IMAGE_PATH));
        } else if (currWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(CHAINGUN_IMAGE_PATH));
        }
        
        
        
        //unarmed alien
        if (currLifeForm instanceof Alien && direction.equals("north")) {
          button.setIcon(new ImageIcon(ALIEN_NORTH_PATH));
        } else if (currLifeForm instanceof Alien && direction.equals("south")) {
          button.setIcon(new ImageIcon(ALIEN_SOUTH_PATH));
        } else if (currLifeForm instanceof Alien && direction.equals("east")) {
          button.setIcon(new ImageIcon(ALIEN_EAST_PATH));
        } else if (currLifeForm instanceof Alien && direction.equals("west")) {
          button.setIcon(new ImageIcon(ALIEN_WEST_PATH));
        }
        
        //pistol alien
        if (currLifeForm instanceof Alien
        && direction.equals("north")
        && equippedWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(ALIEN_NORTH_PISTOL_PATH));
        } else if (currLifeForm instanceof Alien
        && direction.equals("south")
        && equippedWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(ALIEN_SOUTH_PISTOL_PATH));
        } else if (currLifeForm instanceof Alien
        && direction.equals("east")
        && equippedWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(ALIEN_EAST_PISTOL_PATH));
        }  else if (currLifeForm instanceof Alien
        && direction.equals("west")
        && equippedWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(ALIEN_WEST_PISTOL_PATH));
        }
        
        //plasma alien
        if (currLifeForm instanceof Alien
        && direction.equals("north")
        && equippedWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(ALIEN_NORTH_PLASMACANNON_PATH));
        } else if (currLifeForm instanceof Alien
        && direction.equals("south")
        && equippedWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(ALIEN_SOUTH_PLASMACANNON_PATH));
        } else if (currLifeForm instanceof Alien
        && direction.equals("east")
        && equippedWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(ALIEN_EAST_PLASMACANNON_PATH));
        } else if (currLifeForm instanceof Alien
        && direction.equals("west")
        && equippedWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(ALIEN_WEST_PLASMACANNON_PATH));
        }
        
        //chaingun alien
        if (currLifeForm instanceof Alien
        && direction.equals("north")
        && equippedWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(ALIEN_NORTH_CHAINGUN_PATH));
        } else if (currLifeForm instanceof Alien
        && direction.equals("south")
        && equippedWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(ALIEN_SOUTH_CHAINGUN_PATH));
        } else if (currLifeForm instanceof Alien
        && direction.equals("east")
        && equippedWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(ALIEN_EAST_CHAINGUN_PATH));
        } else if (currLifeForm instanceof Alien
        && direction.equals("west")
        && equippedWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(ALIEN_WEST_CHAINGUN_PATH));
        }
        
        //unarmed human
        if (currLifeForm instanceof Human && direction.equals("north")) {
          button.setIcon(new ImageIcon(HUMAN_NORTH_PATH));
        } else if (currLifeForm instanceof Human && direction.equals("south")) {
          button.setIcon(new ImageIcon(HUMAN_SOUTH_PATH));
        } else if (currLifeForm instanceof Human && direction.equals("east")) {
          button.setIcon(new ImageIcon(HUMAN_EAST_PATH));
        } else if (currLifeForm instanceof Human && direction.equals("west")) {
          button.setIcon(new ImageIcon(HUMAN_WEST_PATH));
        }
        
        //pistol human
        if (currLifeForm instanceof Human
        && direction.equals("north")
        && equippedWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(HUMAN_NORTH_PISTOL_PATH));
        } else if (currLifeForm instanceof Human
        && direction.equals("south")
        && equippedWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(HUMAN_SOUTH_PISTOL_PATH));
        } else if (currLifeForm instanceof Human
        && direction.equals("east")
        && equippedWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(HUMAN_EAST_PISTOL_PATH));
        } else if (currLifeForm instanceof Human
        && direction.equals("west")
        && equippedWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(HUMAN_WEST_PISTOL_PATH));
        }
        
        //plasma human
        if (currLifeForm instanceof Human
        && direction.equals("north")
        && equippedWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(HUMAN_NORTH_PLASMACANNON_PATH));
        } else if (currLifeForm instanceof Human
        && direction.equals("south")
        && equippedWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(HUMAN_SOUTH_PLASMACANNON_PATH));
        } else if (currLifeForm instanceof Human
        && direction.equals("east")
        && equippedWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(HUMAN_EAST_PLASMACANNON_PATH));
        } else if (currLifeForm instanceof Human
        && direction.equals("west")
        && equippedWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(HUMAN_WEST_PLASMACANNON_PATH));
        }
        
        //chaingun human
        if (currLifeForm instanceof Human
        && direction.equals("north")
        && equippedWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(HUMAN_NORTH_CHAINGUN_PATH));
        } else if (currLifeForm instanceof Human
        && direction.equals("south")
        && equippedWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(HUMAN_SOUTH_CHAINGUN_PATH));
        } else if (currLifeForm instanceof Human
        && direction.equals("east")
        && equippedWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(HUMAN_EAST_CHAINGUN_PATH));
        } else if (currLifeForm instanceof Human
        && direction.equals("west")
        && equippedWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(HUMAN_WEST_CHAINGUN_PATH));
        }
        
        // Update the corresponding button in the boardArray
        this.boardArray[row][col] = button;
        boardPanel.add(button);
      }
    }
    updateBoard();
    return boardPanel;
  }
  
  /**
  * Creates and returns the JPanel "displayBoxPanel". This panel will house the "text box"
  * that shows what moves our human has made.
  * @return displayBoxPanel
  */
  private JPanel createDisplayBoxPanel() {
    JPanel displayBoxPanel = new JPanel();
    JTextArea displayTextArea = createDisplayBoxTextArea();
    Font axiformaHeavy = loadCustomFont("src/main/java/assets/fonts/Axiforma-Heavy.ttf");
    displayTextArea.setFont(axiformaHeavy);
    JScrollPane scrollPane = new JScrollPane(displayTextArea);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
    displayBoxPanel.setLayout(new BorderLayout());
    displayBoxPanel.setBackground(Color.gray);
    displayBoxPanel.setBorder(new LineBorder(Color.BLACK, BORDER_WIDTH));
    displayBoxPanel.add(scrollPane, BorderLayout.CENTER);
    return displayBoxPanel;
  }
  
  private JTextArea createDisplayBoxTextArea() {
    JTextArea displayTextArea = new JTextArea("Action History:\n", 3, 6);
    this.displayTextArea = displayTextArea;
    displayTextArea.setEditable(false); //makes the text field display only
    displayTextArea.setBackground(Color.lightGray);
    this.displayTextArea = displayTextArea;
    return displayTextArea;
  }
  
  /**
  * Creates and returns the JPanel "infoPanel". This panel will house the info section that shows
  *  valuable information of the current cell such as health, current weapon, etc.
  * @return
  */
  private JPanel createInfoPanel() {
    final JPanel infoPanel = new JPanel();
    JPanel infoGridPanel = new JPanel(new GridLayout(3, 3));
    
    // Panel for the first text field
    JPanel textFieldPanel1 = new JPanel(new BorderLayout());
    JTextField textField1 = new JTextField("\t\t\t      ");
    textFieldPanel1.setBackground(Color.gray);
    textFieldPanel1.add(textField1, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel1);
    textField1.setFont(loadCustomFont("src/main/java/assets/fonts/Axiforma-Heavy.ttf"));
    this.textFieldHealth = textField1;
    
    // Panel for the second text field
    JPanel textFieldPanel2 = new JPanel(new BorderLayout());
    JTextField textField2 = new JTextField("\t\t\t      ");
    textFieldPanel2.setBackground(Color.gray);
    textFieldPanel2.add(textField2, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel2);
    textField2.setFont(loadCustomFont("src/main/java/assets/fonts/Axiforma-Heavy.ttf"));
    this.textFieldAmmo = textField2;
    
    // Panel for the third text field
    JPanel textFieldPanel3 = new JPanel(new BorderLayout());
    JTextField textField3 = new JTextField("\t\t\t      ");
    textFieldPanel3.setBackground(Color.gray);
    textFieldPanel3.add(textField3, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel3);
    textField3.setFont(loadCustomFont("src/main/java/assets/fonts/Axiforma-Heavy.ttf"));
    this.textFieldEquippedWeapon = textField3;
    
    // Panel for the fourth text field
    JPanel textFieldPanel4 = new JPanel(new BorderLayout());
    JTextField textField4 = new JTextField("\t\t\t      ");
    textFieldPanel4.setBackground(Color.gray);
    textFieldPanel4.add(textField4, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel4);
    textField4.setFont(loadCustomFont("src/main/java/assets/fonts/Axiforma-Heavy.ttf"));
    this.textFieldArmor = textField4;
    
    // Panel for the fifth text field
    JPanel textFieldPanel5 = new JPanel(new BorderLayout());
    JTextField textField5 = new JTextField("\t\t\t      ");
    textFieldPanel5.setBackground(Color.gray);
    textFieldPanel5.add(textField5, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel5);
    textField5.setFont(loadCustomFont("src/main/java/assets/fonts/Axiforma-Heavy.ttf"));
    this.textFieldWeapon1 = textField5;
    
    // Panel for the sixth text field
    JPanel textFieldPanel6 = new JPanel(new BorderLayout());
    JTextField textField6 = new JTextField("\t\t\t      ");
    textFieldPanel6.setBackground(Color.gray);
    textFieldPanel6.add(textField6, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel6);
    textField6.setFont(loadCustomFont("src/main/java/assets/fonts/Axiforma-Heavy.ttf"));
    this.textFieldWeapon2 = textField6;
    
    // Panel for the seventh text field
    JPanel textFieldPanel7 = new JPanel(new BorderLayout());
    JTextField textField7 = new JTextField("\t\t\t      ");
    textFieldPanel7.setBackground(Color.gray);
    textFieldPanel7.add(textField7, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel7);
    textField7.setFont(loadCustomFont("src/main/java/assets/fonts/Axiforma-Heavy.ttf"));
    this.textFieldRecoveryType = textField7;
    
    // Panel for the eigth text field
    JPanel textFieldPanel8 = new JPanel(new BorderLayout());
    JTextField textField8 = new JTextField("\t\t\t      ");
    textFieldPanel8.setBackground(Color.gray);
    textFieldPanel8.add(textField8, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel8);
    textField8.setFont(loadCustomFont("src/main/java/assets/fonts/Axiforma-Heavy.ttf"));
    this.textFieldRecoveryRate = textField8;
    
    // Panel for the ninth text field
    JPanel textFieldPanel9 = new JPanel(new BorderLayout());
    JTextField textField9 = new JTextField("\t\t\t      ");
    textFieldPanel9.setBackground(Color.gray);
    textFieldPanel9.add(textField9, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel9);
    textField9.setFont(loadCustomFont("src/main/java/assets/fonts/Axiforma-Heavy.ttf"));
    this.textFieldSelectedCoords = textField9;
    
    //adds the grid panel to our info panel
    infoPanel.add(infoGridPanel);
    
    // Set preferred size to ensure fixed size
    infoPanel.setPreferredSize(new Dimension(300, 100)); // Adjust the dimensions as needed
    
    infoPanel.setBackground(Color.gray);
    infoPanel.setBorder(new LineBorder(Color.BLACK, BORDER_WIDTH));
    return infoPanel;
  }
  
  /**
  * Creates and returns the JTextArea "legendTextArea" 
  * @return
  */
  private JTextArea createLegendInstructionTextArea() {
    JTextArea legendInstructionTextArea = new JTextArea("Legend:", 5, 5);
    Font axiformaHeavy = loadCustomFont("src/main/java/assets/fonts/Axiforma-Heavy.ttf");
    legendInstructionTextArea.setFont(axiformaHeavy);
    legendInstructionTextArea.setEditable(false);
    legendInstructionTextArea.setLineWrap(true); // enable line wrapping
    legendInstructionTextArea.setWrapStyleWord(true); // wrap at word boundaries
    legendInstructionTextArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
    legendInstructionTextArea.setText("\nLegend:\n\n");
    legendInstructionTextArea.append("  Face North: faces the human north / up.\n\n");
    legendInstructionTextArea.append("  Face West: faces the human west / left\n\n");
    legendInstructionTextArea.append("  Face East: faces the human east / right\n\n");
    legendInstructionTextArea.append("  Face South: moves the human south / down\n\n");
    legendInstructionTextArea.append("  Move: moves the human in the direction they're facing\n\n");
    legendInstructionTextArea.append("  Attack: attacks in the direction the human is facing\n\n");
    legendInstructionTextArea.append("  Get Weapon 1: picks up the cells weapon 1.\n\n");
    legendInstructionTextArea.append("  Get Weapon 2: picks up the cells weapon 2.\n\n");
    legendInstructionTextArea.append("  Drop Weapon: drops the weapon the human is holding.\n\n");
    legendInstructionTextArea.append("  Reload: reloads the weapon the human is holding\n\n");
    return legendInstructionTextArea;
  }
  
  /**
  * reads the environment "world" matrix and syncs it with our "boardArray" matrix
  * as well as updates our board
  */
  public void updateBoard() {
    int numOfRows = this.world.getNumRows();
    int numOfCols = this.world.getNumCols();
    
    //iterates through our matrix
    for (int row = 0; row < numOfRows; row++) {
      for (int col = 0; col < numOfCols; col++) { 
        JButton button = this.boardArray[row][col];
        JButton tempButton = new JButton();
        tempButton.setIcon(new ImageIcon(""));
        
        if (selectedLifeForm == null) {
          continue;
        } else if (world.getLifeForm(row, col) == selectedLifeForm) {
          button.setBackground(Color.DARK_GRAY);
          selectedArr[0] = row;
          selectedArr[1] = col;
          updateTextFields();
        } else {
          button.setBackground(Color.lightGray);
        }
        
        button.setIcon(new ImageIcon("")); //sets the picture no picture. creates a clean slate
        
        //looks for lifeforms and applies them to our buttons
        LifeForm currLifeForm = world.getLifeForm(row, col);
        String direction;
        Weapon equippedWeapon;
        Weapon currWeapon;
        
        // null check so we dont get the direction of a cell with no lifeform, etc
        if (currLifeForm != null) {
          direction = world.getLifeForm(row, col).getCurrentDirection();
          if (world.getLifeForm(row, col).getWeapon() != null) {
            equippedWeapon = world.getLifeForm(row, col).getWeapon().getBaseWeapon();
          } else {
            equippedWeapon = null;
          }
        } else {
          direction = "null";
          equippedWeapon = null;
        }
        
        // unequipped weapons in environment
        if (world.getWeapons(row, col)[0] != null) {
          currWeapon = world.getWeapons(row, col)[0].getBaseWeapon();
        } else if (world.getWeapons(row, col)[1] != null) {
          currWeapon = world.getWeapons(row, col)[1].getBaseWeapon();
        } else {
          currWeapon = null;
        }
        
        if (currWeapon instanceof PlasmaCannon) {
          tempButton.setIcon(new ImageIcon(PLASMACANNON_IMAGE_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(PLASMACANNON_IMAGE_PATH));
          }
        } else if (currWeapon instanceof Pistol) {
          tempButton.setIcon(new ImageIcon(PISTOL_IMAGE_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(PISTOL_IMAGE_PATH));
          }
        } else if (currWeapon instanceof ChainGun) {
          tempButton.setIcon(new ImageIcon(CHAINGUN_IMAGE_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(CHAINGUN_IMAGE_PATH));
          }
        }
        
        //unarmed alien
        if (currLifeForm instanceof Alien && direction.equals("north")) {
          tempButton.setIcon(new ImageIcon(ALIEN_NORTH_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_NORTH_PATH));
          }
        } else if (currLifeForm instanceof Alien && direction.equals("south")) {
          tempButton.setIcon(new ImageIcon(ALIEN_SOUTH_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_SOUTH_PATH));
          }
        } else if (currLifeForm instanceof Alien && direction.equals("east")) {
          tempButton.setIcon(new ImageIcon(ALIEN_EAST_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_EAST_PATH));
          }
        } else if (currLifeForm instanceof Alien && direction.equals("west")) {
          tempButton.setIcon(new ImageIcon(ALIEN_WEST_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_WEST_PATH));
          }
        }
        
        //pistol alien
        if (currLifeForm instanceof Alien
        && direction.equals("north")
        && equippedWeapon instanceof Pistol) {
          tempButton.setIcon(new ImageIcon(ALIEN_NORTH_PISTOL_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_NORTH_PISTOL_PATH));
          }
        } else if (currLifeForm instanceof Alien
        && direction.equals("south")
        && equippedWeapon instanceof Pistol) {
          tempButton.setIcon(new ImageIcon(ALIEN_SOUTH_PISTOL_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_SOUTH_PISTOL_PATH));
          }
        } else if (currLifeForm instanceof Alien
        && direction.equals("east")
        && equippedWeapon instanceof Pistol) {
          tempButton.setIcon(new ImageIcon(ALIEN_EAST_PISTOL_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_EAST_PISTOL_PATH));
          }
        } else if (currLifeForm instanceof Alien
        && direction.equals("west")
        && equippedWeapon instanceof Pistol) {
          tempButton.setIcon(new ImageIcon(ALIEN_WEST_PISTOL_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_WEST_PISTOL_PATH));
          }
        }
        
        //plasma alien
        if (currLifeForm instanceof Alien
        && direction.equals("north")
        && equippedWeapon instanceof PlasmaCannon) {
          tempButton.setIcon(new ImageIcon(ALIEN_NORTH_PLASMACANNON_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_NORTH_PLASMACANNON_PATH));
          }
        } else if (currLifeForm instanceof Alien
        && direction.equals("south")
        && equippedWeapon instanceof PlasmaCannon) {
          tempButton.setIcon(new ImageIcon(ALIEN_SOUTH_PLASMACANNON_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_SOUTH_PLASMACANNON_PATH));
          }
        } else if (currLifeForm instanceof Alien
        && direction.equals("east")
        && equippedWeapon instanceof PlasmaCannon) {
          tempButton.setIcon(new ImageIcon(ALIEN_EAST_PLASMACANNON_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_EAST_PLASMACANNON_PATH));
          }
        } else if (currLifeForm instanceof Alien
        && direction.equals("west")
        && equippedWeapon instanceof PlasmaCannon) {
          tempButton.setIcon(new ImageIcon(ALIEN_WEST_PLASMACANNON_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_WEST_PLASMACANNON_PATH));
          }
        }
        
        //chaingun alien
        if (currLifeForm instanceof Alien
        && direction.equals("north")
        && equippedWeapon instanceof ChainGun) {
          tempButton.setIcon(new ImageIcon(ALIEN_NORTH_CHAINGUN_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_NORTH_CHAINGUN_PATH));
          }
        } else if (currLifeForm instanceof Alien
        && direction.equals("south")
        && equippedWeapon instanceof ChainGun) {
          tempButton.setIcon(new ImageIcon(ALIEN_SOUTH_CHAINGUN_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_SOUTH_CHAINGUN_PATH));
          }
        } else if (currLifeForm instanceof Alien
        && direction.equals("east")
        && equippedWeapon instanceof ChainGun) {
          tempButton.setIcon(new ImageIcon(ALIEN_EAST_CHAINGUN_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_EAST_CHAINGUN_PATH));
          }
        } else if (currLifeForm instanceof Alien
        && direction.equals("west")
        && equippedWeapon instanceof ChainGun) {
          tempButton.setIcon(new ImageIcon(ALIEN_WEST_CHAINGUN_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(ALIEN_WEST_CHAINGUN_PATH));
          }
        }
        
        //unarmed human
        if (currLifeForm instanceof Human && direction.equals("north")) {
          tempButton.setIcon(new ImageIcon(HUMAN_NORTH_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_NORTH_PATH));
          }
        } else if (currLifeForm instanceof Human && direction.equals("south")) {
          tempButton.setIcon(new ImageIcon(HUMAN_SOUTH_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_SOUTH_PATH));
          }
        } else if (currLifeForm instanceof Human && direction.equals("east")) {
          tempButton.setIcon(new ImageIcon(HUMAN_EAST_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_EAST_PATH));
          }
        } else if (currLifeForm instanceof Human && direction.equals("west")) {
          tempButton.setIcon(new ImageIcon(HUMAN_WEST_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_WEST_PATH));
          }
        }
        
        //pistol human
        if (currLifeForm instanceof Human
        && direction.equals("north")
        && equippedWeapon instanceof Pistol) {
          tempButton.setIcon(new ImageIcon(HUMAN_NORTH_PISTOL_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_NORTH_PISTOL_PATH));
          }
        } else if (currLifeForm instanceof Human
        && direction.equals("south")
        && equippedWeapon instanceof Pistol) {
          tempButton.setIcon(new ImageIcon(HUMAN_SOUTH_PISTOL_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_SOUTH_PISTOL_PATH));
          }
        } else if (currLifeForm instanceof Human
        && direction.equals("east")
        && equippedWeapon instanceof Pistol) {
          tempButton.setIcon(new ImageIcon(HUMAN_EAST_PISTOL_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_EAST_PISTOL_PATH));
          }
        } else if (currLifeForm instanceof Human
        && direction.equals("west")
        && equippedWeapon instanceof Pistol) {
          tempButton.setIcon(new ImageIcon(HUMAN_WEST_PISTOL_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_WEST_PISTOL_PATH));
          }
        }
        
        //plasma human
        if (currLifeForm instanceof Human
        && direction.equals("north")
        && equippedWeapon instanceof PlasmaCannon) {
          tempButton.setIcon(new ImageIcon(HUMAN_NORTH_PLASMACANNON_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_NORTH_PLASMACANNON_PATH));
          }
        } else if (currLifeForm instanceof Human
        && direction.equals("south")
        && equippedWeapon instanceof PlasmaCannon) {
          tempButton.setIcon(new ImageIcon(HUMAN_SOUTH_PLASMACANNON_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_SOUTH_PLASMACANNON_PATH));
          }
        } else if (currLifeForm instanceof Human
        && direction.equals("east")
        && equippedWeapon instanceof PlasmaCannon) {
          tempButton.setIcon(new ImageIcon(HUMAN_EAST_PLASMACANNON_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_EAST_PLASMACANNON_PATH));
          }
        } else if (currLifeForm instanceof Human
        && direction.equals("west")
        && equippedWeapon instanceof PlasmaCannon) {
          tempButton.setIcon(new ImageIcon(HUMAN_WEST_PLASMACANNON_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_WEST_PLASMACANNON_PATH));
          }
        }
        
        //chaingun human
        if (currLifeForm instanceof Human
        && direction.equals("north")
        && equippedWeapon instanceof ChainGun) {
          tempButton.setIcon(new ImageIcon(HUMAN_NORTH_CHAINGUN_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_NORTH_CHAINGUN_PATH));
          }
        } else if (currLifeForm instanceof Human
        && direction.equals("south")
        && equippedWeapon instanceof ChainGun) {
          tempButton.setIcon(new ImageIcon(HUMAN_SOUTH_CHAINGUN_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_SOUTH_CHAINGUN_PATH));
          }
        } else if (currLifeForm instanceof Human
        && direction.equals("east")
        && equippedWeapon instanceof ChainGun) {
          tempButton.setIcon(new ImageIcon(HUMAN_EAST_CHAINGUN_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_EAST_CHAINGUN_PATH));
          }
        } else if (currLifeForm instanceof Human
        && direction.equals("west")
        && equippedWeapon instanceof ChainGun) {
          tempButton.setIcon(new ImageIcon(HUMAN_WEST_CHAINGUN_PATH)); // comparison button
          if (button.getIcon().equals(tempButton.getIcon())) {
            //do nothing (there is no not equals method)
          } else {
            button.setIcon(new ImageIcon(HUMAN_WEST_CHAINGUN_PATH));
          }
        }
        
        // Update the corresponding button in the boardArray
        this.boardArray[row][col] = button;
      }
    }
  }
  
  /**
  * our button selection code
  */
  private class ButtonClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      JButton clickedButton = (JButton) e.getSource();
      
      // Iterate through the boardArray to find the clicked button
      for (int row = 0; row < boardArray.length; row++) {
        for (int col = 0; col < boardArray[0].length; col++) {
          if (boardArray[row][col] == clickedButton) {
            // Store the row and column indices in selectedArr
            selectedArr[0] = row; // row
            selectedArr[1] = col; // column
            if (world.getLifeForm(row, col) instanceof Alien
            || world.getLifeForm(row, col) instanceof Human) {
              selectedLifeForm = world.getLifeForm(row, col);
            } else {
              selectedLifeForm = null;
            }
            break; // Break out of the loop since we found the clicked button
          }
        }
      }
      
      updateTextFields();
      updateDisplayTextArea("Selected: " + selectedArr[0] + ", " + selectedArr[1] + "\n");
      
      // Deselect all buttons (change their background color to light gray)
      for (int i = 0; i < boardArray.length; i++) {
        for (int j = 0; j < boardArray[0].length; j++) {
          boardArray[j][i].setBackground(Color.lightGray);
        }
      } 
      
      // Select the clicked button and change its background color to dark gray
      clickedButton.setBackground(Color.darkGray);
    }
  }
  
  /**
  * method that updates the display text area with a given string
  * @param message
  */
  public void updateDisplayTextArea(String message) {
    displayTextArea.append(message);
    displayTextArea.setCaretPosition(displayTextArea.getDocument().getLength()); 
  }
  
  /**
  * method that updates the text fields within the info section with predefined cell content
  */
  public void updateTextFields() {
    LifeForm lf = world.getLifeForm(selectedArr[0], selectedArr[1]);
    
    // default values
    String cellWeapon1Text = "Cell Weapon 1: none\t\t      ";
    String cellWeapon2Text = "Cell Weapon 2: none\t\t      ";
    String equippedWeaponText = "Equipped Weapon: none\t\t      ";
    String ammoText = "Ammo: N/A\t\t       ";
    String healthText = "Health: N/A\t\t      ";
    String recoveryRateText = "RecoveryRate: N/A\t\t      ";
    String recoveryTypeText = "RecoveryType: N/A\t\t      ";
    String armorText = "Armor: N/A\t\t      ";
    
    if (lf != null) {
      if (lf instanceof Alien) {
        Alien a = (Alien) world.getLifeForm(selectedArr[0], selectedArr[1]);
        recoveryRateText = "Recovery Rate: " + a.getRecoveryRate();
        recoveryTypeText = a.getRecoveryTypeToString();
      } else if (lf instanceof Human) {
        Human h = (Human) world.getLifeForm(selectedArr[0], selectedArr[1]);
        armorText = "Armor: " + h.getArmorPoints();
      }
      Weapon[] groundWeapons = world.getWeapons(selectedArr[0], selectedArr[1]);
      
      if (groundWeapons[0] != null) {
        cellWeapon1Text = "Cell Weapon 1: " + groundWeapons[0].toString();
      }
      if (groundWeapons[1] != null) {
        cellWeapon2Text = "Cell Weapon 2: " + groundWeapons[1].toString();
      }
      
      if (lf.getWeapon() != null) {
        equippedWeaponText = "Equipped Weapon: " + lf.getWeapon().toString();
        ammoText = "Ammo: " + lf.getWeapon().getCurrentAmmo();
      }
      
      healthText = "Health: " + lf.getCurrentLifePoints();
    } else if (lf == null) {
      Weapon[] groundWeapons = world.getWeapons(selectedArr[0], selectedArr[1]);
      
      if (groundWeapons[0] != null) {
        cellWeapon1Text = "Cell Weapon 1: " + groundWeapons[0].toString();
      }
      if (groundWeapons[1] != null) {
        cellWeapon2Text = "Cell Weapon 2: " + groundWeapons[1].toString();
      }
    }
    
    // update text fields
    textFieldWeapon1.setText(cellWeapon1Text);
    textFieldWeapon2.setText(cellWeapon2Text);
    textFieldEquippedWeapon.setText(equippedWeaponText);
    textFieldAmmo.setText(ammoText);
    textFieldHealth.setText(healthText);
    textFieldArmor.setText(armorText);
    textFieldRecoveryRate.setText(recoveryRateText);
    textFieldRecoveryType.setText(recoveryTypeText);
    textFieldSelectedCoords.setText(selectedArr[0] + ", " + selectedArr[1] + "\t\t      ");
  }
  
  /**
  * getter for the life form in the selection coords
  * @return
  */
  public LifeForm getSelected() {
    return world.getLifeForm(selectedArr[0], selectedArr[1]);
  }
  
  /**
  * method that is required to be implemented by the interface TimerObserver.
  * Refreshes the board everytime it is called.
  */
  public void updateTime(int time) {
    updateDisplayTextArea("A new round has started!\n");
    updateBoard();
  }
  
  // method to load a custom font from file
  private Font loadCustomFont(String fontFileName) {
    try {
      // load the font file
      InputStream fontStream = GameUi.class.getResourceAsStream(fontFileName);
      Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream);
      
      // register the font
      GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
      ge.registerFont(customFont);
      
      return customFont;
    } catch (Exception e) {
      e.printStackTrace();
      // if the font can't be loaded, return a default font
      return new Font("Arial", Font.PLAIN, 13);
    }
  }
}
