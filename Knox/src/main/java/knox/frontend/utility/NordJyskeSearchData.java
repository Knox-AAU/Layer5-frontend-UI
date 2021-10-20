package knox.frontend.utility;

public class NordJyskeSearchData {
  private String object;
  private String subject;
  private String predicate;

  public NordJyskeSearchData() {}

  public NordJyskeSearchData(String object, String subject, String predicate) {
    this.object = object;
    this.subject = subject;
    this.predicate = predicate;
  }

  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getPredicate() {
    return predicate;
  }

  public void setPredicate(String predicate) {
    this.predicate = predicate;
  }
}
