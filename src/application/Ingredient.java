package application;

public class Ingredient {
	
	public String ingredient;
	public String amount;

	public Ingredient(
		String ingredient,
		String amount
	) {
		this.ingredient = ingredient;
		this.amount = amount;
	}

	public String getIngredient() {
		return this.ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

}
