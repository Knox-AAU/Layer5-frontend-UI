package knox.unit_test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class TestTest {

  @Test
  public void TestTesting() {
    boolean test = true;
    assertEquals(test, true);
  }
}
