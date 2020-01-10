public class EagerSingleton extends BaseSingleton {

  private static final EagerSingleton INSTANCE = new EagerSingleton();

  public static EagerSingleton getInstance() {
      return INSTANCE;
  }
}