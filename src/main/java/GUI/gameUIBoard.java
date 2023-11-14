package GUI;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import environment.Environment;
import lifeform.Alien;
import lifeform.Human;
import lifeform.LifeForm;
import weapon.Weapon;
import weapon.PlasmaCannon;
import weapon.Pistol;
import weapon.ChainGun;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
* The Swing GUI for the game board.
* @author Daniel Pavenko
*/
public class gameUIBoard {
  
  //constant for border size of elements
  private static final int BORDER_WIDTH = 1;
  
  //constants for our weapon image paths
  private static final String PISTOL_IMAGE_PATH = "src/main/java/assets/images/pistol.png";
  private static final String CHAINGUN_IMAGE_PATH = "src/main/java/assets/images/chainGun.png";
  private static final String PLASMACANNON_IMAGE_PATH = "src/main/java/assets/images/plasmaCannon.png";
  
  //unarmed human path(s)
  private static final String HUMAN_NORTH_PATH = "src/main/java/assets/images/humannorth.png";
  private static final String HUMAN_SOUTH_PATH = "src/main/java/assets/images/humansouth.png";
  private static final String HUMAN_EAST_PATH = "src/main/java/assets/images/legend icons/pistolLegend.png";
  private static final String HUMAN_WEST_PATH = "src/main/java/assets/images/humanwest.png";
  
  //alien path(s)
  private static final String ALIEN_NORTH_PATH = "src/main/java/assets/images/aliennorth.png";
  private static final String ALIEN_SOUTH_PATH = "src/main/java/assets/images/aliensouth.png";
  private static final String ALIEN_EAST_PATH = "src/main/java/assets/images/alieneast.png";
  private static final String ALIEN_WEST_PATH = "src/main/java/assets/images/alienwest.png";
  
  //pistol human path(s)
  private static final String HUMAN_NORTH_PISTOL_PATH = "src/main/java/assets/images/humanpistolnorth.png";
  private static final String HUMAN_SOUTH_PISTOL_PATH = "src/main/java/assets/images/humanpistolsouth.png";
  private static final String HUMAN_EAST_PISTOL_PATH = "src/main/java/assets/images/humanpistoleast.png";
  private static final String HUMAN_WEST_PISTOL_PATH = "src/main/java/assets/images/humanpistolwest.png";
  
  //plasma human path(s)
  private static final String HUMAN_NORTH_PLASMACANNON_PATH = "src/main/java/assets/images/humanplasmanorth.png";
  private static final String HUMAN_SOUTH_PLASMACANNON_PATH = "src/main/java/assets/images/humanplasmasouth.png";
  private static final String HUMAN_EAST_PLASMACANNON_PATH = "src/main/java/assets/images/humanplasmaeast.png";
  private static final String HUMAN_WEST_PLASMACANNON_PATH = "src/main/java/assets/images/humanplasmawest.png";
  
  //chain human path(s)
  private static final String HUMAN_NORTH_CHAINGUN_PATH = "src/main/java/assets/images/humanchainnorth.png";
  private static final String HUMAN_SOUTH_CHAINGUN_PATH = "src/main/java/assets/images/humanchainsouth.png";
  private static final String HUMAN_EAST_CHAINGUN_PATH = "src/main/java/assets/images/humanchaineast.png";
  private static final String HUMAN_WEST_CHAINGUN_PATH = "src/main/java/assets/images/humanchainwest.png";
  
  //legend images path(s)
  private static final String HUMAN_LEGEND_IMAGE_PATH = "src/main/java/assets/images/legend icons/humanLegend.png";
  private static final String ALIEN_LEGEND_IMAGE_PATH = "src/main/java/assets/images/legend icons/alienLegend.png";
  private static final String PISTOL_LEGEND_IMAGE_PATH = "src/main/java/assets/images/legend icons/pistolLegend.png";
  private static final String CHAINGUN_LEGEND_IMAGE_PATH = "src/main/java/assets/images/legend icons/chaingunLegend.png";
  private static final String PLASMACANNON_LEGEND_IMAGE_PATH = "src/main/java/assets/images/legend icons/plasmaCannonLegend.png";
  
  //our board (matrix)
  private JButton[][] boardArray;
  
  //our environment
  Environment world;
  
  /**
  * constructor for GUI, removed the "startUI" and put the initiliazation code within this constructor.
  * @param world
  */
  public gameUIBoard(Environment world) {
    this.world = world;
    refreshBoard();
    createFrame();
  }
  
  /**
  * reads the environment "world" matrix and syncs it with our "boardArray" matrix
  */
  private void refreshBoard() {
    int numOfRows = this.world.getNumRows();
    int numOfCols = this.world.getNumCols();
    
    this.boardArray = new JButton[numOfCols][numOfRows];
    
    for (int i = 0; i < numOfRows; i++) {
      for (int j = 0; j < numOfCols; j++) {
        //button logic
        JButton button = new JButton();
        button.setBackground(Color.lightGray);
        button.setOpaque(true);
        button.setBorder(new LineBorder(Color.BLACK, BORDER_WIDTH));
        
        // Adds the ActionListener to each button (button selection)
        button.addActionListener(new ButtonClickListener());
        
        //looks for lifeforms and applies them to our buttons
        LifeForm currLifeForm = world.getLifeForm(i, j);
        String direction;
        Weapon equippedWeapon;
        if (currLifeForm != null) { // null check so we dont get the direction of a cell with no lifeform, etc
          direction = world.getLifeForm(i, j).getCurrentDirection();
          equippedWeapon = world.getLifeForm(i, j).getWeapon();
        } else {
          direction = "null";
          equippedWeapon = null;
        }
        
        //alien
        if (currLifeForm instanceof Alien && direction.equals("north")) {
          button.setIcon(new ImageIcon(ALIEN_NORTH_PATH));
        } else if (currLifeForm instanceof Alien && direction.equals("south")) {
          button.setIcon(new ImageIcon(ALIEN_SOUTH_PATH));
        } else if (currLifeForm instanceof Alien && direction.equals("east")) {
          button.setIcon(new ImageIcon(ALIEN_EAST_PATH));
        } else if (currLifeForm instanceof Alien && direction.equals("west")) {
          button.setIcon(new ImageIcon(ALIEN_WEST_PATH));
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
        if (currLifeForm instanceof Human && direction.equals("north") && equippedWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(HUMAN_NORTH_PISTOL_PATH));
        } else if (currLifeForm instanceof Human && direction.equals("south") && equippedWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(HUMAN_SOUTH_PISTOL_PATH));
        } else if (currLifeForm instanceof Human && direction.equals("east") && equippedWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(HUMAN_EAST_PISTOL_PATH));
        }  else if (currLifeForm instanceof Human && direction.equals("west") && equippedWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(HUMAN_WEST_PISTOL_PATH));
        }
        
        //plasma human
        if (currLifeForm instanceof Human && direction.equals("north") && equippedWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(HUMAN_NORTH_PLASMACANNON_PATH));
        } else if (currLifeForm instanceof Human && direction.equals("south") && equippedWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(HUMAN_SOUTH_PLASMACANNON_PATH));
        } else if (currLifeForm instanceof Human && direction.equals("east") && equippedWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(HUMAN_EAST_PLASMACANNON_PATH));
        }  else if (currLifeForm instanceof Human && direction.equals("west") && equippedWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(HUMAN_WEST_PLASMACANNON_PATH));
        }
        
        //chaingun human
        if (currLifeForm instanceof Human && direction.equals("north") && equippedWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(HUMAN_NORTH_CHAINGUN_PATH));
        } else if (currLifeForm instanceof Human && direction.equals("south") && equippedWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(HUMAN_SOUTH_CHAINGUN_PATH));
        } else if (currLifeForm instanceof Human && direction.equals("east") && equippedWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(HUMAN_EAST_CHAINGUN_PATH));
        }  else if (currLifeForm instanceof Human && direction.equals("west") && equippedWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(HUMAN_WEST_CHAINGUN_PATH));
        }
        
        // unequipped weapons in environment
        Weapon currWeapon = world.getWeapons(i, j)[0];
        if (currWeapon instanceof PlasmaCannon) {
          button.setIcon(new ImageIcon(PLASMACANNON_IMAGE_PATH));
        } else if (currWeapon instanceof Pistol) {
          button.setIcon(new ImageIcon(PISTOL_IMAGE_PATH));
        } else if (currWeapon instanceof ChainGun) {
          button.setIcon(new ImageIcon(CHAINGUN_IMAGE_PATH));
        }
        
        // Update the corresponding button in the boardArray
        this.boardArray[j][i] = button;
      }
    }
    createBoardPanel(); // recreates the boardpanel so the new elements can be reattached & appear
  }
  
  /**
  * Creates and displays the main JFrame.
  */
  private void createFrame() {
    JFrame boardFrame = new JFrame("Humans & Aliens Game");
    boardFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    boardFrame.setLayout(new BorderLayout());
    
    boardFrame.add(createContainerPanel(), BorderLayout.CENTER);
    
    boardFrame.setSize(1400, 800);
    boardFrame.setVisible(true);
  }
  
  /**
  * Creates and rethrns the JPanel "containerPanel". This is our first panel that sits on top of the main JFrame.
  * This panel is responsible for formatting everything and it "houses" all other panels / components.
  * @return
  */
  public JPanel createContainerPanel() {
    // the panels that will house the legend, board, moves display & cell info section.
    JPanel legendPanel = createLegendPanel();
    JPanel boardPanel = createBoardPanel();
    JPanel displayBoxPanel = createDisplayBoxPanel();
    JPanel infoPanel = createInfoPanel();
    // container panel that holds our panels
    JPanel containerPanel = new JPanel(new GridBagLayout());
    
    // set constraints to make "legendPanel" take 1/5 of the width & 5/6 of the height
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0; 
    gbc.gridy = 0;
    gbc.weightx = 1.0 / 5.0; // take up a 1/5 of width
    gbc.weighty = 5.0 / 5.0; // take up 5/6 of height
    gbc.fill = GridBagConstraints.BOTH;
    containerPanel.add(legendPanel, gbc);
    
    // set constraints to make "boardPanel" take 4/5 of the width & 5/6 of the height
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 0;
    gbc.weightx = 4.0 / 5.0; // take up 4/5 of width
    gbc.weighty = 5.0 / 6.0; // take up 5/6 of height
    gbc.fill = GridBagConstraints.BOTH;
    containerPanel.add(boardPanel, gbc);
    
    // set constraints to make "displayBoxPanel" take 1/5 of the width & 1/6 of the height
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.weightx = 1.0 / 5.0; // take up 1/5 of the width
    gbc.weighty = 1.0 / 6.0; // take up 1/6 of the height
    gbc.fill = GridBagConstraints.BOTH;
    containerPanel.add(displayBoxPanel, gbc);
    
    // set constraints to make "infoPanel" take 4/5 of the width & 1/6 of the height
    gbc = new GridBagConstraints();
    gbc.gridx = 1;
    gbc.gridy = 1;
    gbc.weightx = 4.0 / 5.0; // take up 4/5 of the width
    gbc.weighty = 1.0 / 6.0; // take up 1/6 of the height
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
  * Creates and returns the JPanel "boardPanel". This panel will house our game board.
  * This panel also attaches our grid / matrix to itself.
  * @return boardPanel
  */
  private JPanel createBoardPanel() {
    int numOfRows = this.world.getNumRows();
    int numOfCols = this.world.getNumCols();
    JPanel boardPanel = new JPanel(new GridLayout(numOfRows, numOfCols)); //creates the UI grid and sizes it
    
    // reads our 2d matrix and adds it as elements to the board panel
    for (int i = 0; i < numOfRows; i++) {
      for (int j = 0; j < numOfCols; j++) {
        boardPanel.add(this.boardArray[j][i]);
      }
    }
    
    boardPanel.setBorder(new LineBorder(Color.BLACK, BORDER_WIDTH));
    return boardPanel;
  }
  
  /**
  * ActionListener for the buttons in the game board.
  */
  private class ButtonClickListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
      JButton clickedButton = (JButton) e.getSource();
      
      // deselect all buttons (change their background color to light gray)
      for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
          boardArray[j][i].setBackground(Color.lightGray);
        }
      }
      
      // select the clicked button and change its background color to dark gray
      clickedButton.setBackground(Color.darkGray);
    }
  }
  
  /**
  * Creates and returns the JPanel "displayBoxPanel". This panel will house the "text box" that shows
  *  what moves our human has made.
  * @return displayBoxPanel
  */
  private JPanel createDisplayBoxPanel() {
    JPanel displayBoxPanel = new JPanel();
    JTextArea displayTextArea = createDisplayBoxTextArea();
    JScrollPane scrollPane = new JScrollPane(displayTextArea);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
    displayBoxPanel.setLayout(new BorderLayout());
    displayBoxPanel.setBackground(Color.gray);
    displayBoxPanel.setBorder(new LineBorder(Color.BLACK, BORDER_WIDTH));
    displayBoxPanel.add(scrollPane, BorderLayout.CENTER);
    
    // this is a temporary button to test the functionality of the text area
    JButton addButton = new JButton("Add Line");
    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Append another line of text to the text area
        displayTextArea.append("\n  moved some arbitrary direction \n");
        
        //scrolls all the way down at every click
        JScrollBar verticalScrollBar = scrollPane.getVerticalScrollBar();
        verticalScrollBar.setValue(verticalScrollBar.getMaximum());
      }
    });
    displayBoxPanel.add(addButton, BorderLayout.SOUTH);
    
    return displayBoxPanel;
  }
  
  private JTextArea createDisplayBoxTextArea() {
    JTextArea displayTextArea = new JTextArea("Action History:", 3, 6);
    displayTextArea.setEditable(false); //makes the text field display only
    displayTextArea.setBackground(Color.lightGray);
    return displayTextArea;
  }
  
  /**
  * Creates and returns the JPanel "infoPanel". This panel will house the info section that shows
  *  valuable information of the current cell such as health, current weapon, etc.
  * @return
  */
  private JPanel createInfoPanel() {
    JPanel infoPanel = new JPanel();
    JPanel infoGridPanel = new JPanel(new GridLayout(2, 6));
    
    // Panel for the first text field
    JPanel textFieldPanel1 = new JPanel(new BorderLayout());
    JTextField textField1 = new JTextField("Health:--------");
    textFieldPanel1.setBackground(Color.gray);
    textFieldPanel1.add(textField1, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel1);
    
    // Panel for the second text field
    JPanel textFieldPanel2 = new JPanel(new BorderLayout());
    JTextField textField2 = new JTextField("Current Weapon:---------");
    textFieldPanel2.setBackground(Color.gray);
    textFieldPanel2.add(textField2, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel2);
    
    // Panel for the third text field
    JPanel textFieldPanel3 = new JPanel(new BorderLayout());
    JTextField textField3 = new JTextField("Weapon 1:---------");
    textFieldPanel3.setBackground(Color.gray);
    textFieldPanel3.add(textField3, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel3);
    
    // Panel for the fourth text field
    JPanel textFieldPanel4 = new JPanel(new BorderLayout());
    JTextField textField4 = new JTextField("Data point 4:---------");
    textFieldPanel4.setBackground(Color.gray);
    textFieldPanel4.add(textField4, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel4);
    
    // Panel for the fifth text field
    JPanel textFieldPanel5 = new JPanel(new BorderLayout());
    JTextField textField5 = new JTextField("Data point 5:---------");
    textFieldPanel5.setBackground(Color.gray);
    textFieldPanel5.add(textField5, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel5);
    
    // Panel for the sixth text field
    JPanel textFieldPanel6 = new JPanel(new BorderLayout());
    JTextField textField6 = new JTextField("Data point 6:---------");
    textFieldPanel6.setBackground(Color.gray);
    textFieldPanel6.add(textField6, BorderLayout.CENTER);
    infoGridPanel.add(textFieldPanel6);
    
    // this is a temporary button to test the functionality of the text fields
    JButton addButton = new JButton("update data");
    addButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Update the content after the header while keeping the header
        textField1.setText("Data point 1: " + "0000000");
        textField2.setText("Data point 2: " + "1111111");
        textField3.setText("Data point 3: " + "2222222");
        textField4.setText("Data point 4: " + "3333333");
        textField5.setText("Data point 4: " + "4444444");
        textField6.setText("Data point 4: " + "5555555");
      }
    });
    infoPanel.add(addButton, BorderLayout.SOUTH);
    
    // this is a temporary button to test the functionality of the text fields
    JButton addButton1 = new JButton("reset data");
    addButton1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Update the content after the header while keeping the header
        textField1.setText("Data point 1: " + "-------");
        textField2.setText("Data point 2: " + "-------");
        textField3.setText("Data point 3: " + "-------");
        textField4.setText("Data point 4: " + "-------");
        textField5.setText("Data point 4: " + "-------");
        textField6.setText("Data point 4: " + "-------");
      }
    });
    infoPanel.add(addButton1, BorderLayout.NORTH);
    
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
    legendInstructionTextArea.setEditable(false);
    legendInstructionTextArea.setLineWrap(true); // enable line wrapping
    legendInstructionTextArea.setWrapStyleWord(true); // wrap at word boundaries
    legendInstructionTextArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
    legendInstructionTextArea.setText("Legend:\n\n");
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
}
