import java.util.*;

public class Menu{
    private List<MenuItem> items;
    private int id;
    
    public Menu(int id){
        this.id = id;
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item){
        items.add(item);
    }

    public void removeItem(MenuItem item){
        items.remove(item);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public int getId() {
        return id;
    }
    
}