import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;

public class UserTest{

  @Rule
  public DatabaseRule database = new DatabaseRule();

  // @Test
  // public void user_instantiatesCorrectly(){
  //   User newUser = new User("Ryan Harvey", "secretpassword");
  //   assertEquals(true, newUser instanceof User);
  // }

  // @Test
  // public void validate_returnsFalseIfBlankFieldsAreEntered(){
  //   boolean validation = User.validate("Ryan", "");
  //   assertEquals(false, validation);
  // }

  // @Test
  // public void  addRelative_returnsCorrectNumberOfRelativesInArray(){
  //   User newUser = new User("Ryan Harvey", "secretpassword");
  //   newUser.save();
  //   Relative newRelative = new Relative("Janice", "Mother", newUser.getId());
  //   newRelative.save();
  //   newUser.addRelative(newRelative);
  //   List<Relative> newList = newUser.getRelatives();
  //   assertEquals(1, newList.size());
  // }

  // @Test
  // public void findByName(){
  //   User newUser = new User("Ryan Harvey", "secretpassword");
  //   newUser.save();
  //   User foundUser = User.findByName("Ryan Harvey");
  //   assertEquals(foundUser.getPassword(), "secretpassword");
  // }

  // @Test
  // public void validate_returnsTrueIfPasswordsMatch(){
  //   boolean result = User.validate("Ryan", "stuff", "stuff");
  //   assertEquals(true, result);
  // }

  // @Test
  // public void getRelative_returnsCorrectRelative(){
  //   User newUser = new User("Ryan", "stuff");
  //   newUser.save();
  //   Relative newRelative = new Relative("Jeff", "Father", newUser.getId(), 1);
  //   newRelative.save();
  //   List<Relative> rels = newUser.getRelatives();
  //   Relative newFather = newUser.getRelative(rels, 1);
  //   assertEquals("Jeff", newFather.getRelativeName());
  // }

  // @Test
  // public void update_returnsCorrectUpdatedName(){
  //   User newUser = new User("Ryan", "stuff");
  //   newUser.save();
  //   Relative newRelative = new Relative("Jeff", "Father", newUser.getId(), 1);
  //   newRelative.save();
  //   List<Relative> rels = newUser.getRelatives();
  //   Relative newFather = newUser.getRelative(rels, 1);
  //   newFather.update("Bob");
  //   assertEquals("Bob", newFather.getRelativeName());
  // }

  // @Test
  // public void update(){
  //   Relative newRelative = new Relative("Jeff", "Father", 1, 1);
  //   newRelative.save();
  //   newRelative.update("Bob");
  //   System.out.println("after update" + newRelative.getRelativeName());
  //   assertEquals("Bob", newRelative.getRelativeName());
  // }

  @Test
  public void getRelativeUpdated(){
    User newUser = new User("Ryan", "stuff");
    newUser.save();
    Relative newRelative = new Relative("Jeff", "Father", newUser.getId(), 1);
    newRelative.save();
    Relative otherRelative = new Relative("Janice", "Mother", newUser.getId(), 10);
    otherRelative.save();
    Relative foundRelative = newUser.getRelative(10);
    assertEquals("Janice", foundRelative.getRelativeName());
  }
}
