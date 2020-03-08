package com.demo;

import java.util.Scanner;
import com.cars.MotoVehicle;	//导入另一个包的文件

public class RentMgrSys {
	private static MotoVehicle motor;
	private static double rentCost;
		
	public static MotoVehicle getMotor() {
		return motor;
	}
	public static void setMotor(MotoVehicle motor) {
		RentMgrSys.motor = motor;
	}
	public static double getRentCost() {
		return rentCost;
	}
	public static void setRentCost(double rentCost) {
		RentMgrSys.rentCost = rentCost;
	}

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		MotoVehicle moto=null;	//汽车
		System.out.println("***********欢迎光临跑得快汽车租赁公司***********");
		System.out.println("1.轿车\t2.客车\t3.卡车");
		System.out.print("请选择你要租赁的汽车类型：");		
		int choose=input.nextInt();
		System.out.print("请输入您要租赁的天数：");
		int days=input.nextInt();
		
		rentManage(choose, days, 100, 100, 100, 100.0); // vehicleType, brandId, seatCount,ton设置默认为100
		moto = RentMgrSys.getMotor(); 		// 方便测试修改重新取得moto对象
		double money = RentMgrSys.getRentCost(); 	// 方便测试取得租车费用信息money
		System.out.println("\n=====================================");
		System.out.println("分配给您的汽车牌号是："+moto.getVehicleId());
		System.out.println("您需要支付的租赁费用是："+money+"元。");
		
		input.close();
	}
	
	/**
	 * 租车管理
	 * @param type
	 * @param days
	 * @param vehicleType
	 * @param brandId
	 * @param seatCount
	 * @param ton
	 */
	public static void rentManage(int type, int days, int vehicleType, int brandId, int seatCount, double ton) {
		MotoOperation motoMgr=new MotoOperation();
		MotoVehicle moto=null;	//汽车
		String motoType="";		//汽车类型
		if(type==1)
			motoType="轿车";
		else if(type==2)
			motoType="客车";
		else if(type==3)
			motoType="卡车";
		
		if (vehicleType == 100 && brandId == 100 && seatCount == 100 && ton == 100.0) {
			moto=motoMgr.motoLeaseOut(motoType);	//获得 
		} else {
			moto=motoMgr.motorRentCommon(motoType, vehicleType, brandId, seatCount, ton);	//获得 		
		}
		
		setMotor(moto);						// 设置MotoVehicle对象
		double money=moto.calRent(days);	//租赁费用
		setRentCost(money);
	}
}
