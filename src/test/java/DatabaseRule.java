import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/geneology_test", null, null);
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteUsersQuery = "DELETE FROM users;";
      String deleteRelativesQuery = "DELETE FROM relatives;";
      con.createQuery(deleteUsersQuery).executeUpdate();
      con.createQuery(deleteRelativesQuery).executeUpdate();
    }
  }
}
