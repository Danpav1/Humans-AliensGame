package commands;

import lifeform.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestNorthCommand {

  /**
   * Tests making a LifeForm face north
   */
  @Test
  public void testFaceNorth() {
    LifeForm x = new MockLifeForm();
    Command north = new FaceNorthCommand(x);
    //LifeForms are initialized facing north, so I'm going to change its direction
    //And then change it back to north in order to ensure it works
    Command east = new FaceEastCommand(x);
    east.execute();
    assertEquals("east", x.getCurrentDirection());
    north.execute();
    assertEquals("north", x.getCurrentDirection());
  }
}
