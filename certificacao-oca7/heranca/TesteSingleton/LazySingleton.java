public class LazySingleton extends BaseSingleton {
  private static class Loader {
    static final LazySingleton INSTANCE = new LazySingleton();
  }

  public static LazySingleton getInstance() {
    return Loader.INSTANCE;
  }

  public static void main(String[] args) throws Exception {
    // Load the class - assume the name comes from a system property etc
    Class<? extends BaseSingleton> lazyClazz = (Class<? extends BaseSingleton>) Class
        .forName("LazySingleton");
    Class<? extends BaseSingleton> eagerClazz = (Class<? extends BaseSingleton>) Class
        .forName("EagerSingleton");

    Thread.sleep(1000); // Introduce some delay between loading class and calling getInstance()

    // Invoke the getInstace method on the class
    BaseSingleton lazySingleton = (BaseSingleton) lazyClazz.getMethod("getInstance").invoke(lazyClazz);
    BaseSingleton eagerSingleton = (BaseSingleton) eagerClazz.getMethod("getInstance").invoke(eagerClazz);

    System.out.println(lazySingleton);
    System.out.println(eagerSingleton);
  }
}