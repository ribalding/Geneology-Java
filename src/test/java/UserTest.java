import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class UserTest{

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void user_instantiatesCorrectly(){
    User newUser = new User("Ryan Harvey", "secretpassword");
    assertEquals(true, newUser instanceof User);
  }

  @Test
  public void validate_returnsFalseIfBlankFieldsAreEntered(){
    boolean validation = User.validate("Ryan", "", "");
    assertEquals(false, validation);
  }
}
