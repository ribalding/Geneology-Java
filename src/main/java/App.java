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
      String userFirstName = request.queryParams("userFirstName");
      String userLastName = request.queryParams("userLastName");
      String userPassword = request.queryParams("userPassword");
      boolean validation = User.validate(userFirstName, userLastName, userPassword);
      if (validation == true){
        String fullName = userFirstName + " " + userLastName;
        User newUser = new User(fullName, userPassword);
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
      model.put("template", "templates/form.vtl");
    } else {
      model.put("template", "templates/index.vtl");
      boolean failedLogin = true;
      model.put("failedLogin", failedLogin);
    }
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());
  }
}
