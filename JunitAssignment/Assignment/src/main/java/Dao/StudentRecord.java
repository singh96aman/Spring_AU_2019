package Dao;

import java.util.Date;

public class StudentRecord{

	String name;
	int sub1, sub2, sub3, sub4;
	public int sum;
	public Date date;
	float percentile;
	
	
	public float getPercentile() {
		return percentile;
	}

	public void setPercentile(float percentile) {
		this.percentile = percentile;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public StudentRecord() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSub1() {
		return sub1;
	}

	public void setSub1(int sub1) {
		this.sub1 = sub1;
	}

	public int getSub2() {
		return sub2;
	}

	public void setSub2(int sub2) {
		this.sub2 = sub2;
	}

	public int getSub3() {
		return sub3;
	}

	public void setSub3(int sub3) {
		this.sub3 = sub3;
	}

	public int getSub4() {
		return sub4;
	}

	public void setSub4(int sub4) {
		this.sub4 = sub4;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString() {
		return this.getName()+" "+this.getSub1()+" "+this.getSub2()+" "+this.getSub3()+" "+this.getSub4()+" "+this.getSum()+" "+this.getPercentile()+" "+this.getDate();
	}

	public int getSum() {
		return sum;
	}

	public void computeSum() {
		this.sum = this.sub1+this.sub2+this.sub3+this.sub4;
	}
	
	
	
}
