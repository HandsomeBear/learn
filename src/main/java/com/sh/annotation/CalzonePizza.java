package com.sh.annotation;

import com.sh.factory.Factory;

@Factory(id = "Calzone", type = Meal.class)
public class CalzonePizza implements Meal {

	@Override
	public float getPrice() {
		return 8.5f;
	}
}
