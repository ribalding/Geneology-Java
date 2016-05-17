import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App{
  public static void main(String[] args){
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) ->{
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/addUser", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      boolean confirmNewUser = false;
      boolean failedNewUser = false;
      String userFullName = request.queryParams("userFullName");
      String userPassword = request.queryParams("userPassword");
      String confirmPassword = request.queryParams("confirmPassword");
      boolean validation = User.validate(userFullName, userPassword, confirmPassword);
      if (validation == true){
        User newUser = new User(userFullName, userPassword);
        newUser.save();
        confirmNewUser = true;
        model.put("confirmNewUser", confirmNewUser);
      } else if (validation == false){
        failedNewUser = true;
        model.put("failedNewUser", failedNewUser);
      }
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  post("/familyForm", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    String userName = request.queryParams("userName");
    String userPassword = request.queryParams("userPassword");
    User newUser = User.findByName(userName);
    if (newUser.getPassword().equals(userPassword)){
      model.put("user", newUser);
      model.put("template", "templates/form.vtl");
    } else {
      model.put("template", "templates/index.vtl");
      boolean failedLogin = true;
      model.put("failedLogin", failedLogin);
    }
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  post("/tree/:id", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    User newUser = User.find(Integer.parseInt(request.params("id")));

    String father = request.queryParams("father");
    String fathersFather = request.queryParams("fathersFather");
    String fathersMother = request.queryParams("fathersMother");
    String fathersSibling1 = request.queryParams("fathersSibling1");
    String fathersSibling2 = request.queryParams("fathersSibling2");
    String fathersSibling1Kid1 = request.queryParams("fathersSibling1Kid1");
    String fathersSibling1Kid2 = request.queryParams("fathersSibling1Kid2");
    String fathersSibling2kid1 = request.queryParams("fathersSibling2kid1");
    String fathersSibling2kid2 = request.queryParams("fathersSibling2kid2");
    String mother = request.queryParams("mother");
    String mothersFather = request.queryParams("mothersFather");
    String mothersMother = request.queryParams("mothersMother");
    String mothersSibling1 = request.queryParams("mothersSibling1");
    String mothersSibling2 = request.queryParams("mothersSibling2");
    String mothersSibling1Kid1 = request.queryParams("mothersSibling1Kid1");
    String mothersSibling1Kid2 = request.queryParams("mothersSibling1Kid2");
    String mothersSibling2kid1 = request.queryParams("mothersSibling2kid1");
    String mothersSibling2kid2 = request.queryParams("mothersSibling2kid2");

    Relative newFather = new Relative(father, "Father", newUser.getId());
    newFather.save();
    Relative newPaternalGrandfather = new Relative(fathersFather, "Paternal Grandfather", newUser.getId());
    newPaternalGrandfather.save();
    Relative newPaternalGrandmother = new Relative(fathersMother, "Paternal Grandmother", newUser.getId());
    newPaternalGrandmother.save();
    Relative newFathersSibling1 = new Relative(fathersSibling1, "Father Sibling 1", newUser.getId());
    newFathersSibling1.save();
    Relative newFathersSibling2 = new Relative(fathersSibling2, "Father Sibling 2", newUser.getId());
    newFathersSibling2.save();
    Relative newFathersSibling1Kid1 = new Relative(fathersSibling1Kid1, "Father Sibling 1 Child 1", newUser.getId());
    newFathersSibling1Kid1.save();
    Relative newFathersSibling1Kid2 = new Relative(fathersSibling1Kid2, "Father Sibling 1 Child 2", newUser.getId());
    newFathersSibling1Kid2.save();
    Relative newFathersSibling2Kid1 = new Relative(fathersSibling2kid1, "Father Sibling 2 Child 1", newUser.getId());
    newFathersSibling2Kid1.save();
    Relative newFathersSibling2Kid2 = new Relative(fathersSibling2kid2, "Father Sibling 2 Child 2", newUser.getId());
    newFathersSibling2Kid2.save();

    Relative newMother = new Relative(mother, "Mother", newUser.getId());
    newMother.save();
    Relative newMaternalGrandfather = new Relative(mothersFather, "Maternal Grandfather", newUser.getId());
    newMaternalGrandfather.save();
    Relative newMaternalGrandmother = new Relative(mothersMother, "Maternal Grandmother", newUser.getId());
    newMaternalGrandmother.save();
    Relative newMothersSibling1 = new Relative(mothersSibling1, "Mother Sibling 1", newUser.getId());
    newMothersSibling1.save();
    Relative newMothersSibling2 = new Relative(mothersSibling2, "Mother Sibling 2", newUser.getId());
    newMothersSibling2.save();
    Relative newMothersSibling1Kid1 = new Relative(mothersSibling1Kid1, "Mother Sibling 1 Child 1", newUser.getId());
    newMothersSibling1Kid1.save();
    Relative newMothersSibling1Kid2 = new Relative(mothersSibling1Kid2, "Mother Sibling 1 Child 2", newUser.getId());
    newMothersSibling1Kid2.save();
    Relative newMothersSibling2Kid1 = new Relative(mothersSibling2kid1, "Mother Sibling 2 Child 1", newUser.getId());
    newMothersSibling2Kid1.save();
    Relative newMothersSibling2Kid2 = new Relative(mothersSibling2kid2, "Mother Sibling 2 Child 2", newUser.getId());
    newMothersSibling2Kid2.save();

    model.put("template", "templates/tree.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());
  }
}
