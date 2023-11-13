package gameplay;
import commands.*;
import lifeform.LifeForm;

/**
 * @author Elijah Hill
 * executes commands based on input commandIndex number and a standardized list
 */
public class Invoker {
  Command[] commands = new Command[CommandName.BUTTON_AMOUNT];

  public Invoker(LifeForm lf) {
    commands[CommandName.MOVE] = new MoveCommand(lf);
    commands[CommandName.FACE_NORTH] = new FaceNorthCommand(lf);
    commands[CommandName.FACE_EAST] = new FaceEastCommand(lf);
    commands[CommandName.FACE_SOUTH] = new FaceSouthCommand(lf);
    commands[CommandName.FACE_WEST] = new FaceWestCommand(lf);
    commands[CommandName.ATTACK] = new AttackCommand(lf);
    commands[CommandName.DROP_WEAPON] = new DropWeaponCommand(lf);
    commands[CommandName.GET_WEAPON_ONE] = new GetWeaponOneCommand(lf);
    commands[CommandName.GET_WEAPON_TWO] = new GetWeaponTwoCommand(lf);
    commands[CommandName.RELOAD] = new ReloadCommand(lf);
  }

  /**
   * executes designated Command from array based on the index number input
   * @param commandName name of Command to execute
   */
  public void executeCommand(int commandName) {
    this.commands[commandName].execute();
  }
}
