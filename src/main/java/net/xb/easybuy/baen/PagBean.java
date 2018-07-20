package net.xb.easybuy.baen;

import java.util.List;

public class PagBean {

	// 每页的条数
	private int unit_count;
	// 总条数
	private int total_count;
	// 当前页
	private int cur_page;
	// 总页数
	private int total_page;
	// 每页显示的数据
	private List<Object> date;
	
	public int getUnit_count() {
		return unit_count;
	}
	public void setUnit_count(int unit_count) {
		this.unit_count = unit_count;
	}
	public int getTotal_count() {
		return total_count;
	}
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
	public int getCur_page() {
		return cur_page;
	}
	public void setCur_page(int cur_page) {
		if (cur_page>this.total_page) {//如果当前页大于总页数，那么将当前页设置为总页数的数量
			this.cur_page=this.total_page;
		}else if (cur_page<=0) {//如果当前页小于等于0，那么将当前页设置为1
			this.cur_page=1;
		}else {
			this.cur_page = cur_page;
		}
	}
	public int getTotal_page() {
		return total_page;
	}
	public void setTotal_page(int total_page) {
		//如果总条数除以当前条数，余数为0，就设置总页数为总条数除以当前条数
		//否则就设置总页数为总条数除以当前条数在加一
		if (this.total_count%this.unit_count==0) {
			this.total_page = this.total_count/this.unit_count;
		}else {
			this.total_page = this.total_count/this.unit_count+1;
		}
	}
	public List<Object> getDate() {
		return date;
	}
	public void setDate(List<Object> date) {
		this.date = date;
	}
}
