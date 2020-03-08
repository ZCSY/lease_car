package com.cars;

import java.util.Scanner;

/**
 * 轿车
 */
public class Car extends MotoVehicle{
	private String type;		// 型号

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Car() {

	}
	public Car(String vehicleId, String brand, String type, int perRent) {
		super(vehicleId, brand, perRent);
		this.type = type;
	}
	
	/**
	 * 重写计算租金
	 */
	public float calRent(int days) {
		float rate;
		if (days > 7 && days <= 30)
			rate = 0.9f;
		else if (days > 30 && days <= 150)
			rate = 0.8f;
		else if (days > 150)
			rate = 0.7f;
		else
			rate = 1;

		return this.getPerRent() * days * rate;
	}
	/**
	 * 重写租车流程
	 */
	public void leaseOutFlow() {
		Scanner input = new Scanner(System.in);
		System.out.println("1.宝马\t2.别克");
		System.out.print("请选择你要租赁的轿车品牌：");
		int brandId = input.nextInt();		// 轿车型号编号
		int carTypeId = 0;
		switch (brandId) {
		case 1:			// 选择宝马品牌时
			this.setBrand("宝马");
			System.out.println("1.550i\t2.X6");
			System.out.print("请选择你要租赁的轿车型号：");
			carTypeId = input.nextInt();		// 宝马的型号编号
			// 为了测试用例使用，调整实现逻辑
			this.rentVehicleFlow(brandId, carTypeId);
			break;
		case 2:
			this.setBrand("别克");		// 选择别克品牌时
			System.out.println("1.林荫大道\t2.GL8");
			System.out.print("请选择你要租赁的轿车型号：");
			carTypeId = input.nextInt();		// 别克的型号编号
			// 为了测试用例使用，调整实现逻辑
			this.rentVehicleFlow(brandId, carTypeId);
			break;
		default:
			System.out.println("对不起，没有此品牌的轿车。");
		}
		input.close();
	}
	public void rentVehicleFlow(int brandId, int typeId) {
		switch (brandId) {
		case 1:
			this.setBrand("宝马");		// 选择宝马品牌时
			if (typeId == 1) {			// 如果选择了型号550i
				this.setType("550i");
				this.setPerRent(600);
				this.setVehicleId("京NY28588"); // 设置车牌号
			} else if (typeId == 2) {			// 如果选择了型号X6
				this.setType("X6");
				this.setPerRent(800);
				this.setVehicleId("京CNY3284"); // 设置车牌号
			} else
				System.out.println("对不起，没有此型号的轿车！");
			break;
		case 2:
			this.setBrand("别克");		// 选择别克品牌时
			if (typeId == 1) {			// 如果选择了型号“林荫大道”
				this.setType("林荫大道");
				this.setPerRent(300);
				this.setVehicleId("京NT37465"); // 设置车牌号
			} else if (typeId == 2) {	// 如果选择了型号“GL8”
				this.setType("GL8");
				this.setPerRent(600);
				this.setVehicleId("京NT96968");	// 设置车牌号
			} else
				System.out.println("对不起，没有此型号的轿车！");
			break;
		default:
			System.out.println("对不起，没有此品牌的轿车。");
		}
	}
	
}
