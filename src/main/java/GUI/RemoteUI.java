package GUI;

import gameplay.Invoker;

import javax.swing.*;

import environment.Environment;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * remote or "invoker"
 * @author Daniel Pavenko 
 */
public class RemoteUI{
  
  //our instances
  private static RemoteUI remote;
  private Invoker control;

  //constructor
  private RemoteUI() {
    createFrame();
    control = new Invoker();
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
    remoteFrame.setSize(400, 300);
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
        control.setLifeForm(GameUI.getGameUI().getSelected());
        control.executeCommand(5);
        Environment world = Environment.getEnvironment();
        GameUI game = GameUI.getGameUI(world);
        game.updateDisplayTextArea("Attacking\n");
      }
    });
    
    //get weapon 1 button
    getWeapon1Button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("get Weapon 1"); //temp. just here to show that button works. delete me when im done.
        control.setLifeForm(GameUI.getGameUI().getSelected());
        control.executeCommand(7);
        Environment world = Environment.getEnvironment();
        GameUI game = GameUI.getGameUI(world);
        game.updateDisplayTextArea("Getting Weapon 1\n");
      }
    });
    
    // get weapon 2 button
    getWeapon2Button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("get weapon 2"); //temp. just here to show that button works. delete me when im done.
        control.setLifeForm(GameUI.getGameUI().getSelected());
        control.executeCommand(8);
        Environment world = Environment.getEnvironment();
        GameUI game = GameUI.getGameUI(world);
        game.updateDisplayTextArea("Getting weapon 2\n");
      }
    });
    
    // drop weapon button
    dropWeaponButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("drop weapon"); //temp. just here to show that button works. delete me when im done.
        control.setLifeForm(GameUI.getGameUI().getSelected());
        control.executeCommand(6);
        Environment world = Environment.getEnvironment();
        GameUI game = GameUI.getGameUI(world);
        game.updateDisplayTextArea("Dropping Weapon\n");
      }
    });
    
    // reload weapon button
    reloadButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("Reload"); //temp. just here to show that button works. delete me when im done.
        control.setLifeForm(GameUI.getGameUI().getSelected());
        control.executeCommand(9);
        Environment world = Environment.getEnvironment();
        GameUI game = GameUI.getGameUI(world);
        game.updateDisplayTextArea("Reloading Weapon\n");
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
        control.setLifeForm(GameUI.getGameUI().getSelected());
        control.executeCommand(1);
        Environment world = Environment.getEnvironment();
        GameUI game = GameUI.getGameUI(world);
        game.updateDisplayTextArea("Facing North\n");
      }
    });
    
    // face east button
    faceEastButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("facing east"); //temp. just here to show that button works. delete me when im done.
        control.setLifeForm(GameUI.getGameUI().getSelected());
        control.executeCommand(2);
        Environment world = Environment.getEnvironment();
        GameUI game = GameUI.getGameUI(world);
        game.updateDisplayTextArea("Facing East\n");
      }
    });
    
    // face south button
    faceSouthButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("facing south"); //temp. just here to show that button works. delete me when im done.
        control.setLifeForm(GameUI.getGameUI().getSelected());
        control.executeCommand(3);
        Environment world = Environment.getEnvironment();
        GameUI game = GameUI.getGameUI(world);
        game.updateDisplayTextArea("Facing South\n");
      }
    });
    
    // face west button
    faceWestButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        control.setLifeForm(GameUI.getGameUI().getSelected());
        control.executeCommand(4);
        Environment world = Environment.getEnvironment();
        GameUI game = GameUI.getGameUI(world);
        game.updateDisplayTextArea("Facing West\n");
      }
    });
    
    // move button
    moveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        control.setLifeForm(GameUI.getGameUI().getSelected());
        control.executeCommand(0);
        Environment world = Environment.getEnvironment();
        GameUI game = GameUI.getGameUI(world);
        game.updateDisplayTextArea("Moving\n");
      }
    });
    return rightButtonPanel;
  }
}
