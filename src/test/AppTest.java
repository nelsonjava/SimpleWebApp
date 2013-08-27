import junit.framework.TestCase;
import org.junit.Test;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleniumException;

public class AppTest extends TestCase {
  private DefaultSelenium selenium;

  @Override
  public void setUp() throws Exception {
    super.setUp();
    selenium = createSeleniumClient("http://localhost:8080/");
    selenium.start();
  }

  @Override
  public void tearDown() throws Exception {
    selenium.stop();
    super.tearDown();
  }

  protected DefaultSelenium createSeleniumClient(String url) throws Exception {
    return new DefaultSelenium("localhost", 4444, "*firefox", url);
  }
  
  @Test
  public void testHelloWorld() throws Exception {
    try {
      selenium.open("http://localhost:8080/mywebapp/index.jsp");
      assertEquals("Hello, World", selenium.getText("//h1"));
    } catch (SeleniumException ex) {
      fail(ex.getMessage());
      throw ex;
    }
  }
}