package application;

public class Ingredient {

	private String ingredientName;
	private String amount;

	public Ingredient(String ingredientName, String amount) {
		this.ingredientName = ingredientName;
		this.amount = amount;
	}

	public String getIngredientName() {
		return this.ingredientName;
	}

	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
