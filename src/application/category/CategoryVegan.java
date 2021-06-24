package application.category;

public class CategoryVegan extends Category {

	public CategoryVegan(String categoryName) {
		super(categoryName);
	}

	@Override
	public String getCategoryImageUrl() {
		return "application/fxml/images/categories/Element 45@8x.png";
	}

}
