package BackendSpring.product.domain;

public class ProductForm {

    private String name = "";
    private String description = "";
    private double price;
    private String picture = "";

    public ProductForm()
    {
	
    }
    /**
     * @param name
     * @param description
     * @param price
     * @param picture
     */
    public ProductForm(String name, String description, double price, String picture) {
	super();
	this.name = name;
	this.description = description;
	this.price = price;
	this.picture = picture;
    }

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
	return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
	return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(double price) {
	this.price = price;
    }

    /**
     * @return the picture
     */
    public String getPicture() {
	return picture;
    }

    /**
     * @param picture
     *            the picture to set
     */
    public void setPicture(String picture) {
	this.picture = picture;
    }
}
