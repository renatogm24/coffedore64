public class Test {
  public static void main(String args[]) {
    KioskoOrder app = new KioskoOrder();
    app.addMenuItem("Banana", 1600);
    app.addMenuItem("Cafe", 1200);
    app.addMenuItem("Latte", 3600);

    app.displayMenu();

    app.newOrder();
  }
}
