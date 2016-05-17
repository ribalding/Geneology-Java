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
      model.put("template", "templates/tree.vtl");
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
    String userSibling1 = request.queryParams("userSibling1");
    String userSibling2 = request.queryParams("userSibling2");

    Relative newFather = new Relative(father, "Father", newUser.getId(), 1);
    newFather.save();
    Relative newPaternalGrandfather = new Relative(fathersFather, "Paternal Grandfather", newUser.getId(), 2);
    newPaternalGrandfather.save();
    Relative newPaternalGrandmother = new Relative(fathersMother, "Paternal Grandmother", newUser.getId(), 3);
    newPaternalGrandmother.save();
    Relative newFathersSibling1 = new Relative(fathersSibling1, "Father Sibling 1", newUser.getId(), 4);
    newFathersSibling1.save();
    Relative newFathersSibling2 = new Relative(fathersSibling2, "Father Sibling 2", newUser.getId(), 5);
    newFathersSibling2.save();
    Relative newFathersSibling1Kid1 = new Relative(fathersSibling1Kid1, "Father Sibling 1 Child 1", newUser.getId(), 6);
    newFathersSibling1Kid1.save();
    Relative newFathersSibling1Kid2 = new Relative(fathersSibling1Kid2, "Father Sibling 1 Child 2", newUser.getId(), 7);
    newFathersSibling1Kid2.save();
    Relative newFathersSibling2Kid1 = new Relative(fathersSibling2kid1, "Father Sibling 2 Child 1", newUser.getId(), 8);
    newFathersSibling2Kid1.save();
    Relative newFathersSibling2Kid2 = new Relative(fathersSibling2kid2, "Father Sibling 2 Child 2", newUser.getId(), 9);
    newFathersSibling2Kid2.save();

    Relative newMother = new Relative(mother, "Mother", newUser.getId(), 10);
    newMother.save();
    Relative newMaternalGrandfather = new Relative(mothersFather, "Maternal Grandfather", newUser.getId(), 11);
    newMaternalGrandfather.save();
    Relative newMaternalGrandmother = new Relative(mothersMother, "Maternal Grandmother", newUser.getId(), 12);
    newMaternalGrandmother.save();
    Relative newMothersSibling1 = new Relative(mothersSibling1, "Mother Sibling 1", newUser.getId(), 13);
    newMothersSibling1.save();
    Relative newMothersSibling2 = new Relative(mothersSibling2, "Mother Sibling 2", newUser.getId(), 14);
    newMothersSibling2.save();
    Relative newMothersSibling1Kid1 = new Relative(mothersSibling1Kid1, "Mother Sibling 1 Child 1", newUser.getId(), 15);
    newMothersSibling1Kid1.save();
    Relative newMothersSibling1Kid2 = new Relative(mothersSibling1Kid2, "Mother Sibling 1 Child 2", newUser.getId(), 16);
    newMothersSibling1Kid2.save();
    Relative newMothersSibling2Kid1 = new Relative(mothersSibling2kid1, "Mother Sibling 2 Child 1", newUser.getId(), 17);
    newMothersSibling2Kid1.save();
    Relative newMothersSibling2Kid2 = new Relative(mothersSibling2kid2, "Mother Sibling 2 Child 2", newUser.getId(), 18);
    newMothersSibling2Kid2.save();

    Relative newUserSibling1 = new Relative(userSibling1, "Sibling 1", newUser.getId(), 19);
    newUserSibling1.save();
    Relative newUserSibling2 = new Relative(userSibling2, "Sibling 2", newUser.getId(), 20);
    newUserSibling2.save();

    List<Relative> relList = newUser.getRelatives();
    String fatherName = newUser.getFatherName(relList);
    model.put("fatherName", fatherName);

    String motherName = newUser.getMotherName(relList);
    model.put("motherName", motherName);

    String paternalGrandfatherName = newUser.getPaternalGrandfatherName(relList);
    model.put("paternalGrandfatherName", paternalGrandfatherName);

    String paternalGrandmotherName = newUser.getPaternalGrandmotherName(relList);
    model.put("paternalGrandmotherName", paternalGrandmotherName);

    String fathersSibling1Name = newUser.getFathersSibling1Name(relList);
    model.put("paternalFathersSibling1Name", fathersSibling1Name);

    String fathersSibling2Name = newUser.getFathersSibling2Name(relList);
    model.put("paternalFathersSibling2Name", fathersSibling2Name);

    String fathersSibling1Kid1Name = newUser.getFathersSibling1Kid1Name(relList);
    model.put("fathersSibling1Kid1Name", fathersSibling1Kid1Name);

    String fathersSibling1Kid2Name = newUser.getFathersSibling1Kid2Name(relList);
    model.put("fathersSibling1Kid2Name", fathersSibling1Kid2Name);

    String fathersSibling2Kid1Name = newUser.getFathersSibling2Kid1Name(relList);
    model.put("fathersSibling2Kid1Name", fathersSibling2Kid1Name);

    String fathersSibling2Kid2Name = newUser.getFathersSibling2Kid2Name(relList);
    model.put("fathersSibling2Kid2Name", fathersSibling2Kid2Name);

    String userSibling1Name = newUser.getUserSibling1Name(relList);
    model.put("userSibling1Name", userSibling1Name);

    String userSibling2Name = newUser.getUserSibling2Name(relList);
    model.put("userSibling2Name", userSibling2Name);

    String maternalGrandfatherName = newUser.getMaternalGrandfatherName(relList);
    model.put("maternalGrandfatherName", maternalGrandfatherName);

    String maternalGrandmotherName = newUser.getMaternalGrandmotherName(relList);
    model.put("maternalGrandmotherName", maternalGrandmotherName);

    String mothersSibling1Name = newUser.getMothersSibling1Name(relList);
    model.put("mothersSibling1Name", mothersSibling1Name);

    String mothersSibling2Name = newUser.getMothersSibling2Name(relList);
    model.put("mothersSibling2Name", mothersSibling2Name);

    String mothersSibling1Kid1Name = newUser.getMothersSibling1Kid1Name(relList);
    model.put("mothersSibling1Kid1Name", mothersSibling1Kid1Name);

    String mothersSibling1Kid2Name = newUser.getMothersSibling1Kid2Name(relList);
    model.put("mothersSibling1Kid2Name", mothersSibling1Kid2Name);

    String mothersSibling2Kid1Name = newUser.getMothersSibling2Kid1Name(relList);
    model.put("mothersSibling2Kid1Name", mothersSibling2Kid1Name);

    String mothersSibling2Kid2Name = newUser.getMothersSibling2Kid2Name(relList);
    model.put("mothersSibling2Kid2Name", mothersSibling2Kid2Name);

    model.put("template", "templates/tree.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());
  }
}
