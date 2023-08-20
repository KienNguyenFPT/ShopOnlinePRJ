package entity;

/**
 *
 * @author Trung Kien
 */
public class Product {
    private int product_id;
    private String name;
    private String img;
    private String description;
    private int new_price;
    private int old_price;

    public Product() {}

    public Product(int product_id, String name, String img, String description, int new_price, int old_price) {
        this.product_id = product_id;
        this.name = name;
        this.img = img;
        this.description = description;
        this.new_price = new_price;
        this.old_price = old_price;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNew_price() {
        return new_price;
    }

    public void setNew_price(int new_price) {
        this.new_price = new_price;
    }

    public int getOld_price() {
        return old_price;
    }

    public void setOld_price(int old_price) {
        this.old_price = old_price;
    }

    @Override
    public String toString() {
        return "Product{" + "product_id=" + product_id + ", name=" + name + ", img=" + img + ", description=" + description + ", new_price=" + new_price + ", old_price=" + old_price + '}';
    }   
}
