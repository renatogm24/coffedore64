import java.util.ArrayList;

class KioskoOrder {
  private ArrayList<Item> menu;
  private ArrayList<Order> orders;

  public KioskoOrder() {
    this.menu = new ArrayList<Item>();
    this.orders = new ArrayList<Order>();
  }

  public void addMenuItem(String nombre, double precio) {
    Item newItem = new Item(nombre, precio);
    newItem.setIndex(this.menu.size());
    this.menu.add(newItem);
  }

  public void displayMenu() {
    for (Item item : this.menu) {
      System.out.format("%d %s -- $%,.2f %n", item.getIndex(), item.getNombre(), item.getPrecio());
    }
  }
  
  public void newOrder() {
    System.out.println("Please enter customer name for new order");
    String nombre = System.console().readLine();

    displayMenu();

    Order newOrderAux = new Order(nombre);
    ArrayList<Item> newListItems = new ArrayList<Item>();
    boolean flag = true;
    String option = "";
    do {
      System.out.println("Please enter new item ID for your order");
      option = System.console().readLine();
      try {
        Integer.parseInt(option);
      } catch (Exception e) {
        if (option.equals("q")) {
          option = "q";
        } else {
          option = "-1";
        }

      }
      if (option.equals("q")) {
        flag = false;
        newOrderAux.setItems(newListItems);
      }else if (Integer.parseInt(option) < this.menu.size() && Integer.parseInt(option)>=0) {
        newListItems.add(this.menu.get(Integer.parseInt(option)));
      }else {
        System.out.println("Enter a valid option");
      }
    } while (flag);    
  }
}