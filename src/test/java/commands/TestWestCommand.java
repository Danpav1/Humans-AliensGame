package commands;

import lifeform.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestWestCommand {

  /**
   * Tests the use of the west command
   */
  @Test
  public void testFaceWest() {
    LifeForm x = new MockLifeForm();
    Command west = new FaceWestCommand(x);
    west.execute();
    assertEquals("west", x.getCurrentDirection());
  }
}
