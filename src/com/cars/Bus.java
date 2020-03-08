package com.cars;

import java.util.Scanner;

/**
 * 客车
 */
public class Bus extends MotoVehicle{
	private int seatCount;		// 座位数

	public int getSeatCount() {
		return seatCount;
	}
	public void setSeatCount(int seatCount) {
		this.seatCount = seatCount;
	}
	
	public Bus() {

	}
	public Bus(String vehicleId, String brand, int perRent, int seatCount) {
		super(vehicleId, brand, perRent);
		this.seatCount = seatCount;
	}
	
	/**
	 * 重写计算租金
	 */
	public float calRent(int days) {
		float rate;
		if (days < 3)// 小于3天不打折
			rate = 1;
		else if (days < 7)
			rate = 0.9f;
		else if (days < 30)
			rate = 0.8f;
		else if (days < 150)
			rate = 0.7f;
		else
			rate = 0.6f;
		return this.getPerRent() * days * rate;		
	}
	/**
	 * 重写租车流程
	 */
	public void leaseOutFlow() {
		Scanner input = new Scanner(System.in);
		System.out.println("1.金杯\t2.金龙");
		System.out.print("请选择你要租赁的客车品牌：");
		int busBrandId = input.nextInt();	// 轿车品牌编号
		int seatCount = 0;
		if (busBrandId == 1) {
			this.setBrand("金杯");
			System.out.print("请输入客车的座位数：");
			seatCount = input.nextInt();
		} else if (busBrandId == 2) {
			this.setBrand("金龙");
			System.out.print("请输入客车的座位数：");
			seatCount = input.nextInt();
		} else
			System.out.println("对不起，暂时没有此品牌的客车"); // 客车
		// 为了测试用例使用，调整实现逻辑
		this.rentBusFlow(busBrandId, seatCount);
		input.close();
	}
	public void rentBusFlow(int busBrandId, int seatCount) {
		if (busBrandId == 1) {
			this.setBrand("金杯");
			if (seatCount <= 16) {		// 如果客户输入的座位数小于等于16
				this.setSeatCount(16);	// 设置客车座位数是16
				this.setPerRent(800);
				this.setVehicleId("京6566754"); // 设置车牌号
			} else {
				this.setSeatCount(34); // 设置客车座位数是34
				this.setPerRent(1500);
				this.setVehicleId("京9696996"); // 设置车牌号

			}
		} else if (busBrandId == 2) {
			this.setBrand("金龙");
			if (seatCount <= 16) {		// 如果客户输入的座位数小于等于16
				this.setSeatCount(16);	// 设置客车座位数是16
				this.setPerRent(800);
				this.setVehicleId("京8696997"); // 设置车牌号
			} else {
				this.setSeatCount(34); // 设置客车座位数是34
				this.setPerRent(1500);
				this.setVehicleId("京8696998"); // 设置车牌号
			}
		} else
			System.out.println("对不起，暂时没有此品牌的客车"); // 客车
	}
	
}
