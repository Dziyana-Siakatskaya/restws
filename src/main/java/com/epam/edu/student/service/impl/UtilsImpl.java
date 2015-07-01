package com.epam.edu.student.service.impl;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.epam.edu.student.service.Utils;

@Component(value = "utils")
public class UtilsImpl implements Utils{
	private static final int MIN = 1000;
	private static final int MAX = 9999;

	public int getRandom() {
		Random rand = new Random();
	    return rand.nextInt((MAX - MIN) + 1) + MIN;
	}

}
