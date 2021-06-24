package application.category;

public abstract class Category {

	private String categoryName;

	protected Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryImageUrl() {
		return null;
	}

}
