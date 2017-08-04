package com.ace.util;

import java.util.ArrayList;
import java.util.List;


public class PageCode {
	private List<Integer> pageList;
	
	public PageCode(int pageNum,int pageCount){
		int sideNum = 2;
		calcPage(pageNum,pageCount,sideNum);
		pageList = new ArrayList<Integer>();
		for (int i = startNum; i <= endNum; i++) {
			pageList.add(i);
		}
	}
	
	private int startNum;
	private int endNum;
	private int pageNum;
	
	public int getStartNum() {
		return startNum;
	}

	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}

	public int getEndNum() {
		return endNum;
	}

	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	public void setPageList(List<Integer> pageList) {
		this.pageList = pageList;
	}

	public List<Integer> getPageList() {
		return pageList;
	}

	public void calcPage(int pageNum,int pageCount,int sideNum){
	    int startNum = 0;
	    int endNum = 0;

	    if(pageCount<=sideNum){
	        endNum = pageCount;
	    }else{
	        if((sideNum+pageNum)>=pageCount){
	            endNum = pageCount;
	        }else{
	            endNum = sideNum+pageNum;
	            if((sideNum+pageNum)<=(2*sideNum+1)){                   
	                if((2*sideNum+1)>=pageCount){
	                    endNum = pageCount;
	                }else{
	                    endNum = 2*sideNum+1;
	                }
	            }else{
	                endNum = sideNum + pageNum;
	            }
	        }
	    }
	    if(pageNum<=sideNum){
	        startNum = 1;
	    }else{          
	        if((pageNum+sideNum)>=pageCount){
	            if((2*sideNum+1)>=pageCount){
	                if((pageCount - 2*sideNum)>=1){
	                    startNum = pageCount - 2*sideNum;
	                }else{
	                    startNum = 1;
	                }
	            }else{
	                startNum = pageCount - 2*sideNum;
	            }               
	        }else{
	            if((pageNum-sideNum)>=1){
	                startNum = pageNum - sideNum;
	            }else{
	                startNum = 1;
	            }               
	        }
	    } 
	    
	    this.startNum = startNum;
	    this.endNum = endNum;
	    this.pageNum = pageNum;
	    
	    //loopOut(startNum, endNum, pageNum);
	}
	
	public static void loopOut(int startNum,int endNum,int pageNum){
	    for (int i = startNum; i <= endNum; i++) {          
	        if(i==pageNum){
	            System.out.print(i+"@ | ");
	        }else{
	            System.out.print(i+" | ");
	        }
	    }
	}
	/*
	public static void main(String[] args) {
		PageCode p = new PageCode(1,2);
		for(int i = 0;i < p.pageList.size();i++){
			System.out.println(p.pageList.get(i));
		}
	}*/
}
