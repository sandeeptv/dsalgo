package com.test.example.other;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class Sum extends RecursiveTask<Integer> {

	private int[] numbers;
	private int total=0;
	public Sum(int[] numbers) {
		super();
		this.numbers = numbers;
	}

	@Override
	protected Integer compute() {
		if(numbers.length>5000){
		Sum firstTask = new Sum(Arrays.copyOfRange(numbers, 0, numbers.length/2));
		Sum secondTask = new Sum(Arrays.copyOfRange(numbers, numbers.length/2, numbers.length));
		System.out.println("before fork");
		firstTask.fork();
		int sum = secondTask.compute();
		System.out.println("after second compute"+sum);
		int firstSum=firstTask.join();
		System.out.println("after 1st join"+firstSum);
		return sum+firstSum;
		}else{
			System.out.println("actual cal");
			for(int i=0;i<numbers.length;i++){
				total += numbers[i];
			}
			
		}
		return total;
	}

}
