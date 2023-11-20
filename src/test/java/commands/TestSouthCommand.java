package commands;

import lifeform.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSouthCommand {

  /**
   * Tests using the south command
   */
  @Test
  public void testFaceSouth() {
    LifeForm x = new MockLifeForm();
    Command south = new FaceSouthCommand(x);
    south.execute();
    assertEquals("south", x.getCurrentDirection());
  }
}
