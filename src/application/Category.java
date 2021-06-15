package application;

public class Category {
	
	private String categoryName;
	private String categoryImageUrl;

	public Category(String categoryName) {
		this.categoryName = categoryName;

		setCategoryImageUrl(categoryName);
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;

		setCategoryImageUrl(categoryName);
	}

	public String getCategoryImageUrl() {
		return categoryImageUrl;
	}

	private void setCategoryImageUrl(String categoryName) {
		switch(categoryName) {
			case "Fleischgericht":
				categoryImageUrl = "application/fxml/images/categories/Element 19@8x.png";
				break;
			case "Vegetarisch":
				categoryImageUrl = "application/fxml/images/categories/Element 39@8x.png";
				break;
			case "Vegan":
				categoryImageUrl = "application/fxml/images/categories/Element 45@8x.png";
				break;
			case "Suppe":
				categoryImageUrl = "application/fxml/images/categories/Element 34@8x.png";
				break;
			case "Getränk":
				categoryImageUrl = "application/fxml/images/categories/Element 41@8x.png";
				break;
			case "Fisch":
				categoryImageUrl = "application/fxml/images/categories/Element 08@8x.png";
				break;
			case "Dessert":
				categoryImageUrl = "application/fxml/images/categories/Element 28@8x.png";
				break;
			default:
				categoryImageUrl = null;
				break;
		}
	}

}
