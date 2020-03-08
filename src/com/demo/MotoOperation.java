package com.demo;

import com.cars.MotoVehicle;
import com.cars.Bus;
import com.cars.Car;
import com.cars.Truck;

/**
 * 汽车业务
 */
public class MotoOperation {
	
	/**
	 * 租赁汽车 
	 * @param motoType 汽车类型
	 * @return 汽车
	 */
	public MotoVehicle motoLeaseOut(String motoType){
		
		return motorRentCommon(motoType, 0, 0, 0, 0);
	}
	
	/**
	 * 租赁汽车 
	 * @param motoType 汽车类型
	 * @param brandId 品牌
	 * @param typeId 型号
	 * @param seatCount 座位数
	 * @param ton 吨数
	 * @return 汽车
	 */
	public MotoVehicle motorRentCommon(String motoType, int brandId, int typeId, int seatCount, double ton){
		MotoVehicle moto=null;
		if(motoType.equals("轿车")){		//如果选择租赁类型是轿车
			moto=new Car();				//创建轿车对象
			if (brandId == 0 && typeId == 0 && seatCount == 0) {
				moto.leaseOutFlow();	//调用客车租赁流程的方法
			} else {
				((Car) moto).rentVehicleFlow(brandId, typeId); //调用轿车租赁流程的方法
			}		
		}else if(motoType.equals("客车")){	//如果选择租赁类型是客车
			moto=new Bus();					//创建客车对象
			if (brandId == 0 && typeId == 0 && seatCount == 0) {
				moto.leaseOutFlow();	//调用客车租赁流程的方法
			} else {
				((Bus) moto).rentBusFlow(brandId, seatCount); //调用客车租赁流程的方法
			}
		} else if (motoType.equals("卡车")) {	// 如果选择租赁类型是卡车
		    moto = new Truck();					//创建卡车对象			
            if (brandId == 0 && typeId == 0 && seatCount == 0 && ton == 0) {
                moto.leaseOutFlow();			//TODO 调用卡车租赁流程的方法		
            } else {
		        ((Truck) moto).rentVehicleFlow(brandId, ton); //调用卡车租赁流程的方法
            }
		}
		return moto;	//返回一个汽车对象
	}
	
}
