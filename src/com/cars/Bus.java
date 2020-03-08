package com.cars;

import java.util.Scanner;

/**
 * �ͳ�
 */
public class Bus extends MotoVehicle{
	private int seatCount;		// ��λ��

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
	 * ��д�������
	 */
	public float calRent(int days) {
		float rate;
		if (days < 3)// С��3�첻����
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
	 * ��д�⳵����
	 */
	public void leaseOutFlow() {
		Scanner input = new Scanner(System.in);
		System.out.println("1.��\t2.����");
		System.out.print("��ѡ����Ҫ���޵Ŀͳ�Ʒ�ƣ�");
		int busBrandId = input.nextInt();	// �γ�Ʒ�Ʊ��
		int seatCount = 0;
		if (busBrandId == 1) {
			this.setBrand("��");
			System.out.print("������ͳ�����λ����");
			seatCount = input.nextInt();
		} else if (busBrandId == 2) {
			this.setBrand("����");
			System.out.print("������ͳ�����λ����");
			seatCount = input.nextInt();
		} else
			System.out.println("�Բ�����ʱû�д�Ʒ�ƵĿͳ�"); // �ͳ�
		// Ϊ�˲�������ʹ�ã�����ʵ���߼�
		this.rentBusFlow(busBrandId, seatCount);
		input.close();
	}
	public void rentBusFlow(int busBrandId, int seatCount) {
		if (busBrandId == 1) {
			this.setBrand("��");
			if (seatCount <= 16) {		// ����ͻ��������λ��С�ڵ���16
				this.setSeatCount(16);	// ���ÿͳ���λ����16
				this.setPerRent(800);
				this.setVehicleId("��6566754"); // ���ó��ƺ�
			} else {
				this.setSeatCount(34); // ���ÿͳ���λ����34
				this.setPerRent(1500);
				this.setVehicleId("��9696996"); // ���ó��ƺ�

			}
		} else if (busBrandId == 2) {
			this.setBrand("����");
			if (seatCount <= 16) {		// ����ͻ��������λ��С�ڵ���16
				this.setSeatCount(16);	// ���ÿͳ���λ����16
				this.setPerRent(800);
				this.setVehicleId("��8696997"); // ���ó��ƺ�
			} else {
				this.setSeatCount(34); // ���ÿͳ���λ����34
				this.setPerRent(1500);
				this.setVehicleId("��8696998"); // ���ó��ƺ�
			}
		} else
			System.out.println("�Բ�����ʱû�д�Ʒ�ƵĿͳ�"); // �ͳ�
	}
	
}
