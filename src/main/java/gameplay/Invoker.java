package gameplay;

import commands.Command;
import commands.MoveCommand;
import commands.FaceNorthCommand;
import commands.FaceEastCommand;
import commands.FaceSouthCommand;
import commands.FaceWestCommand;
import commands.AttackCommand;
import commands.DropWeaponCommand;
import commands.GetWeaponOneCommand;
import commands.GetWeaponTwoCommand;
import commands.ReloadCommand;

import lifeform.LifeForm;

import lifeform.LifeForm;

/**
 * @author Elijah Hill
 * executes commands based on input commandIndex number and a standardized list
 */
public class Invoker {
  Command[] commands = new Command[CommandName.BUTTON_AMOUNT];
  LifeForm lf;

  /**
   * Constructor for the Invoker
   *
   * @param lf the LifeForm the Invoker controls upon initialization
   */
  public Invoker(LifeForm lf) {
    this.setLifeForm(lf);
  }

  /**
   * No args constructor
   */
  public Invoker() {
  }

  /**
   * Sets the LifeForm the Invoker controls
   *
   * @param lf the LifeForm to control
   */
  public void setLifeForm(LifeForm lf) {
    this.lf = lf;

    this.commands[CommandName.MOVE] = new MoveCommand(lf);
    this.commands[CommandName.FACE_NORTH] = new FaceNorthCommand(lf);
    this.commands[CommandName.FACE_EAST] = new FaceEastCommand(lf);
    this.commands[CommandName.FACE_SOUTH] = new FaceSouthCommand(lf);
    this.commands[CommandName.FACE_WEST] = new FaceWestCommand(lf);
    this.commands[CommandName.ATTACK] = new AttackCommand(lf);
    this.commands[CommandName.DROP_WEAPON] = new DropWeaponCommand(lf);
    this.commands[CommandName.GET_WEAPON_ONE] = new GetWeaponOneCommand(lf);
    this.commands[CommandName.GET_WEAPON_TWO] = new GetWeaponTwoCommand(lf);
    this.commands[CommandName.RELOAD] = new ReloadCommand(lf);
  }

  /**
   * Executes designated Command from array based on the index number input
   *
   * @param commandName name of Command to execute
   */
  public void executeCommand(int commandName) {
    if (lf != null) {
      this.commands[commandName].execute();
    }
  }
}
