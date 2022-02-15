import java.util.ArrayList;

public class Order {
  private String nombre;
  private boolean listo;
  private ArrayList<Item> items;

  public Order() {
    this.nombre = "Invitado";
    this.items = new ArrayList<Item>();
  }
  
  public Order(String nombre) {
    this.nombre = nombre;
    this.items = new ArrayList<Item>();
  }

  public void addItem(Item item) {
    this.items.add(item);
  }

  public String getStatusMessage() {
    if (this.listo) {
      return "Tu pedido está listo";
    } else {
      return "Gracias por esperar. Tu pedido estará listo pronto";
    }
  }

  public void display() {
    System.out.println(this.nombre);
    for (Item item : this.items) {
      System.out.format("%s : $%,.2f %n", item.getNombre(), item.getPrecio());
    }
    System.out.format("Total: $%,.2f %n", getOrderTotal());
  }

  public double getOrderTotal() {
    double sum = 0;
    for (Item item : this.items) {
      sum += item.getPrecio();
    }
    return sum;
  }
  
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setIsListo(boolean listo) {
    this.listo = listo;
  }

  public boolean isListo() {
    return this.listo;
  }

  public void setItems(ArrayList<Item> items) {
    this.items = items;
  }

  public ArrayList<Item> getItems() {
    return this.items;
  }
}