package application.category;

public class CategoryFish extends Category {

	public CategoryFish(String categoryName) {
		super(categoryName);
	}

	@Override
	public String getCategoryImageUrl() {
		return "application/fxml/views/images/categories/Element 08@8x.png";
	}

}
