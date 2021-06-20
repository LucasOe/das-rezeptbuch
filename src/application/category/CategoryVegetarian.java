package application.category;

public class CategoryVegetarian extends Category {

	public CategoryVegetarian(String categoryName) {
		super(categoryName);
	}

	@Override
	public String getCategoryImageUrl() {
		return "application/fxml/images/categories/Element 39@8x.png";
	}
	
}
