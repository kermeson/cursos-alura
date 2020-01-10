public abstract class BaseSingleton {
  private long createdAt = System.currentTimeMillis();

  public String toString() {
      return getClass().getSimpleName() + " was created " + (System.currentTimeMillis() - createdAt) + " ms ago";
  }
}