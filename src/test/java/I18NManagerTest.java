
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class I18NManagerTest {
    @After
    public void tearDown(){
        I18NManager.getInstance().cleanCache();
    }
    @Before
    public void setUp(){
    }
    @Test
    public void testText() throws Exception{
        String message1 = I18NManager.getInstance().getText("en","l1", "US");
        Assert.assertEquals("Hello", message1);
        String message3 = I18NManager.getInstance().getText("en","l2", "US");
        Assert.assertEquals("gkfrdlk", message3);



    }
}
