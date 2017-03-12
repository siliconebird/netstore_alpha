package com.turnrut.common;

import java.io.Serializable;
import java.util.List;

import com.turnrut.domain.Book;

public class BookPage implements Serializable {
	
	private static final long serialVersionUID = 1L;
	//�ܹ��м�ҳ �����1
	private int totalPageNum;
	//�ܹ��ж�������¼ ע��
	private int totalBookNum;
	//��ǰҳ�Ƕ��� ע��
	private int currentPage;
	//ǰһҳ�Ƕ��� ����� 1
	private int prePage;
	//��һҳ�Ƕ��� ����� 1
	private int nextPage;
	//	��ʼ���� ����� 1
	private int startIndex;
	//	ÿҳ��¼���� ע��
	private int offset;
	//    ͼ���¼ ע��
	private List<Book> record;
	//	 ��ת��ַ ע��
	private String url;
	
	public BookPage(int currentPage,int offset,int totalBookNum){
		this.currentPage=currentPage;
		this.offset = offset;
		this.totalBookNum = totalBookNum;
		
		totalPageNum = totalBookNum%offset==0?totalBookNum/offset:(totalBookNum/offset+1);
		prePage = currentPage-1>0?currentPage-1:1;
		nextPage = currentPage+1>totalPageNum?totalPageNum:currentPage+1;
		startIndex = (currentPage-1)*offset;
		
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPageNum) {
		this.totalPageNum = totalPageNum;
	}
	public int getTotalBookNum() {
		return totalBookNum;
	}
	public void setTotalBookNum(int totalBookNum) {
		this.totalBookNum = totalBookNum;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPrePage() {
		return prePage;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public List<Book> getRecord() {
		return record;
	}
	public void setRecord(List<Book> record) {
		this.record = record;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	
}
