package com.sh.annotation;

import com.sh.factory.Factory;

@Factory(id = "Margherita", type = Meal.class)
public class MargheritaPizza implements Meal {

	@Override
	public float getPrice() {
		return 6f;
	}
}
