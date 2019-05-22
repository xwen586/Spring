package sia2.bean;

@SuppressWarnings("serial")
public class PerformanceException extends RuntimeException {
  public PerformanceException() {
    super();
  }
  
  public PerformanceException(String message) {
    super(message);
  }
}
