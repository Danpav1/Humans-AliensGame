package commands;

import lifeform.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestEastCommand {

  /**
   * Tests making a LifeForm face east via the command
   */
  @Test
  public void testFaceEast() {
    LifeForm x = new MockLifeForm();
    Command east = new FaceEastCommand(x);
    east.execute();
    assertEquals("east", x.getCurrentDirection());
  }
}
