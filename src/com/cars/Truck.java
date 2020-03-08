package com.cars;

import java.util.Scanner;

/**
 * ����
 */
public class Truck extends MotoVehicle{
	private double ton;  	 //��	

	//���ú�ȡ�ó���������Ϣ���ֵ���Ϣ
	public double getTon() {
		return ton;
	}
	public void setTon(double ton) {
		this.ton = ton;
	}
	
	// TODO: ���ع��췽�������ù��췽���Ĳ���������Ա������ֵ
	public Truck() {

	}
	public Truck(String vehicleId, String brand, double ton, int perRent) {
		super(vehicleId, brand, perRent);
		this.ton = ton;
	}

	// TODO: ��ɹ��췽��
	/**
	 * ��д�������
	 *
	 */
	public float calRent(int days) {

		return this.getPerRent() * days * (float)this.getTon();	
	}
	/**
	 * ��д�⳵����
	 */	
	public void leaseOutFlow() {
		Scanner input=new Scanner(System.in);
		System.out.println("1.���\t2.����");
		System.out.print("��ѡ����Ҫ���޵Ŀ���Ʒ�ƣ�");
		int truckBrandId = input.nextInt();        // TODO ����Ʒ�ƣ�truckBrandId
        System.out.print("�����뿨���Ķ�����");
		ton = input.nextDouble();// TODO �������
		
		// Ϊ�˲�������ʹ�ã�����ʵ���߼�
		rentVehicleFlow(truckBrandId, ton);	
		
		input.close();
	}
	
	/**
	 * ��д�⳵����
	 * @param brandId Ʒ��
	 * @param ton ����
	 */
	public void rentVehicleFlow(int brandId, double ton) {
        //����Ʒ�ƣ�brandId��������ton���ó�������Ϣ
		if (brandId == 1) {
			this.setBrand("���");
			this.setTon(ton); // ���ÿ������� 
			this.setPerRent(800);
			this.setVehicleId("��GD56577"); // ���ó��ƺ�
		} else if (brandId == 2) {
			this.setBrand("����");
			this.setTon(ton); // ���ÿ������� 
			this.setPerRent(700);
			this.setVehicleId("��GD53456"); // ���ó��ƺ�
		} else
			System.out.println("�Բ�����ʱû�д�Ʒ�ƵĿͳ�"); // �ͳ�
	}
	
}
