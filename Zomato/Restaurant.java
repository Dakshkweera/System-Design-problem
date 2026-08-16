// import java.util.*;

public class Restaurant{
    private String name;
    private int id;
    private Menu menu;
    private boolean isOpen;

    public Restaurant(String name,int id, Menu menu, boolean isOpen){
        this.name = name;
        this.id = id;
        this.menu = menu;
        this.isOpen = isOpen;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Menu getMenu() {
        return menu;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
