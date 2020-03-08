package com.cars;

import java.util.Scanner;

/**
 * �γ�
 */
public class Car extends MotoVehicle{
	private String type;		// �ͺ�

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
	 * ��д�������
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
	 * ��д�⳵����
	 */
	public void leaseOutFlow() {
		Scanner input = new Scanner(System.in);
		System.out.println("1.����\t2.���");
		System.out.print("��ѡ����Ҫ���޵Ľγ�Ʒ�ƣ�");
		int brandId = input.nextInt();		// �γ��ͺű��
		int carTypeId = 0;
		switch (brandId) {
		case 1:			// ѡ����Ʒ��ʱ
			this.setBrand("����");
			System.out.println("1.550i\t2.X6");
			System.out.print("��ѡ����Ҫ���޵Ľγ��ͺţ�");
			carTypeId = input.nextInt();		// ������ͺű��
			// Ϊ�˲�������ʹ�ã�����ʵ���߼�
			this.rentVehicleFlow(brandId, carTypeId);
			break;
		case 2:
			this.setBrand("���");		// ѡ����Ʒ��ʱ
			System.out.println("1.������\t2.GL8");
			System.out.print("��ѡ����Ҫ���޵Ľγ��ͺţ�");
			carTypeId = input.nextInt();		// ��˵��ͺű��
			// Ϊ�˲�������ʹ�ã�����ʵ���߼�
			this.rentVehicleFlow(brandId, carTypeId);
			break;
		default:
			System.out.println("�Բ���û�д�Ʒ�ƵĽγ���");
		}
		input.close();
	}
	public void rentVehicleFlow(int brandId, int typeId) {
		switch (brandId) {
		case 1:
			this.setBrand("����");		// ѡ����Ʒ��ʱ
			if (typeId == 1) {			// ���ѡ�����ͺ�550i
				this.setType("550i");
				this.setPerRent(600);
				this.setVehicleId("��NY28588"); // ���ó��ƺ�
			} else if (typeId == 2) {			// ���ѡ�����ͺ�X6
				this.setType("X6");
				this.setPerRent(800);
				this.setVehicleId("��CNY3284"); // ���ó��ƺ�
			} else
				System.out.println("�Բ���û�д��ͺŵĽγ���");
			break;
		case 2:
			this.setBrand("���");		// ѡ����Ʒ��ʱ
			if (typeId == 1) {			// ���ѡ�����ͺš���������
				this.setType("������");
				this.setPerRent(300);
				this.setVehicleId("��NT37465"); // ���ó��ƺ�
			} else if (typeId == 2) {	// ���ѡ�����ͺš�GL8��
				this.setType("GL8");
				this.setPerRent(600);
				this.setVehicleId("��NT96968");	// ���ó��ƺ�
			} else
				System.out.println("�Բ���û�д��ͺŵĽγ���");
			break;
		default:
			System.out.println("�Բ���û�д�Ʒ�ƵĽγ���");
		}
	}
	
}
