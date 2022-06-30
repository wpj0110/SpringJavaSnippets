package com.example.mainpackage.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {
	public String retrieveSomething() {
		return "retrieving Dao1";
	}
}
