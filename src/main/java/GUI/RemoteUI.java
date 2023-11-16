package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * remote or "invoker"
 * @author Daniel Pavenko 
 */
public class RemoteUI {
  
  //our instance of the class
  private static RemoteUI remote;
  
  //constructor
  private RemoteUI() {
    createFrame();
  }
  
  /**
  * restricted getter
  * @return
  */
  public static RemoteUI getRemote() {
    if (remote == null) {
      remote = new RemoteUI();
    }
    return remote;
  }
  
  /**
  * creates the frame 
  */
  private void createFrame() {
    JFrame remoteFrame = new JFrame("Remote");
    remoteFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    remoteFrame.setSize(600, 300);
    remoteFrame.setLayout(new GridLayout(1, 2));
    
    JPanel leftButtonPanel = createLeftButtonPanel();
    JPanel rightButtonPanel = createRightButtonPanel();
    
    remoteFrame.add(leftButtonPanel);
    remoteFrame.add(rightButtonPanel);
    
    remoteFrame.setVisible(true);
  }
  
  /**
  * creates the panel that encompasses the left half of the remote
  * @return
  */
  private JPanel createLeftButtonPanel() {
    JPanel leftButtonPanel = new JPanel(new GridLayout(5, 1));
    
    JButton attackButton = new JButton("Attack");
    JButton getWeapon1Button = new JButton("Get Weapon 1");
    JButton getWeapon2Button = new JButton("Get Weapon 2");
    JButton dropWeaponButton = new JButton("Drop Weapon");
    JButton reloadButton = new JButton("Reload");
    
    leftButtonPanel.add(attackButton);
    leftButtonPanel.add(getWeapon1Button);
    leftButtonPanel.add(getWeapon2Button);
    leftButtonPanel.add(dropWeaponButton);
    leftButtonPanel.add(reloadButton);
    
    // attack button
    attackButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("attack"); //temp. just here to show that button works. delete me when im done.
        // add attack functionality here
      }
    });
    
    //get weapon 1 button
    getWeapon1Button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("get Weapon 1"); //temp. just here to show that button works. delete me when im done.
        // add get weapon 1 functionality here
      }
    });
    
    // get weapon 2 button
    getWeapon2Button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("get weapon 2"); //temp. just here to show that button works. delete me when im done.
        // add get weapon 2 functionality here
      }
    });
    
    // drop weapon button
    dropWeaponButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("drop weapon"); //temp. just here to show that button works. delete me when im done.
        // add drop weapon functionality here
      }
    });
    
    // reload weapon button
    reloadButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Reload"); //temp. just here to show that button works. delete me when im done.
        // add reload functionality here
      }
    });
    
    return leftButtonPanel;
  }
  
  /**
  * creates the panel that encompasses the right half of the remote
  * @return
  */
  private JPanel createRightButtonPanel() {
    JPanel rightButtonPanel = new JPanel(new GridLayout(5, 1));
    
    JButton faceNorthButton = new JButton("Face North");
    JButton moveButton = new JButton("Move");
    JButton faceSouthButton = new JButton("Face South");
    JButton faceWestButton = new JButton("Face West");
    JButton faceEastButton = new JButton("Face East");
    
    rightButtonPanel.add(faceNorthButton);
    rightButtonPanel.add(faceEastButton);
    rightButtonPanel.add(moveButton);
    rightButtonPanel.add(faceWestButton);
    rightButtonPanel.add(faceSouthButton);
    
    // face north button
    faceNorthButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("facing north"); //temp. just here to show that button works. delete me when im done.
        // add face north functionality here
      }
    });
    
    // face east button
    faceEastButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("faceing east"); //temp. just here to show that button works. delete me when im done.
        // add face east functionality here
      }
    });
    
    // face south button
    faceSouthButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("facing south"); //temp. just here to show that button works. delete me when im done.
        // add face south functionality here
      }
    });
    
    // face west button
    faceWestButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("facing west"); //temp. just here to show that button works. delete me when im done.
        // add face west functionality here
      }
    });
    
    // move button
    moveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("moved"); //temp. just here to show that button works. delete me when im done.
        // add move functionality here
      }
    });
    
    return rightButtonPanel;
  }
}
