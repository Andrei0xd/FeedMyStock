public class Singleton {

   private static ObserversFactory instance = null;
   private Singleton() {
   }

   public static ObserversFactory getInstance(Subject subject) {
      if(instance == null) {
         instance = new ObserversFactory(subject);
      }
      return instance;
   }
}