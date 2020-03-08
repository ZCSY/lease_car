package com.cars;

import java.util.Scanner;

/**
 * 卡车
 */
public class Truck extends MotoVehicle{
	private double ton;  	 //吨	

	//设置和取得车辆载重信息即吨的信息
	public double getTon() {
		return ton;
	}
	public void setTon(double ton) {
		this.ton = ton;
	}
	
	// TODO: 重载构造方法，利用构造方法的参数，给成员变量赋值
	public Truck() {

	}
	public Truck(String vehicleId, String brand, double ton, int perRent) {
		super(vehicleId, brand, perRent);
		this.ton = ton;
	}

	// TODO: 完成构造方法
	/**
	 * 重写计算租金
	 *
	 */
	public float calRent(int days) {

		return this.getPerRent() * days * (float)this.getTon();	
	}
	/**
	 * 重写租车流程
	 */	
	public void leaseOutFlow() {
		Scanner input=new Scanner(System.in);
		System.out.println("1.解放\t2.东风");
		System.out.print("请选择你要租赁的卡车品牌：");
		int truckBrandId = input.nextInt();        // TODO 输入品牌：truckBrandId
        System.out.print("请输入卡车的吨数：");
		ton = input.nextDouble();// TODO 输入吨数
		
		// 为了测试用例使用，调整实现逻辑
		rentVehicleFlow(truckBrandId, ton);	
		
		input.close();
	}
	
	/**
	 * 重写租车流程
	 * @param brandId 品牌
	 * @param ton 吨数
	 */
	public void rentVehicleFlow(int brandId, double ton) {
        //根据品牌：brandId，吨数：ton设置车辆的信息
		if (brandId == 1) {
			this.setBrand("解放");
			this.setTon(ton); // 设置卡车吨数 
			this.setPerRent(800);
			this.setVehicleId("京GD56577"); // 设置车牌号
		} else if (brandId == 2) {
			this.setBrand("东风");
			this.setTon(ton); // 设置卡车吨数 
			this.setPerRent(700);
			this.setVehicleId("京GD53456"); // 设置车牌号
		} else
			System.out.println("对不起，暂时没有此品牌的客车"); // 客车
	}
	
}
