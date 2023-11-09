package gameplay;
import commands.*;
import lifeform.LifeForm;

/**
 * @author Elijah Hill
 * executes commands based on input commandIndex number and a standardized list
 */
public class Invoker {
  private final static int BUTTON_AMOUNT = 10;
  Command[] commands = new Command[BUTTON_AMOUNT];

  public Invoker(LifeForm lf) {
    Command move = new MoveCommand(lf);
    Command faceNorth = new FaceNorthCommand(lf);
    Command faceEast = new FaceEastCommand(lf);
    Command faceSouth = new FaceSouthCommand(lf);
    Command faceWest = new FaceWestCommand(lf);
    Command attack = new AttackCommand(lf);
    Command dropWeapon = new DropWeaponCommand(lf);
    Command getWeaponOne = new GetWeaponOneCommand(lf);
    Command getWeaponTwo = new GetWeaponTwoCommand(lf);
    Command reload = new ReloadCommand(lf);

    commands[0] = move;
    commands[1] = faceNorth;
    commands[2] = faceEast;
    commands[3] = faceSouth;
    commands[4] = faceWest;
    commands[5] = attack;
    commands[6] = dropWeapon;
    commands[7] = getWeaponOne;
    commands[8] = getWeaponTwo;
    commands[9] = reload;
  }

  /**
   * executes designated Command from array based on the index number input
   * @param commandIndex
   */
  public void executeCommand(int commandIndex) {
    commands[commandIndex].execute();
  }
}
