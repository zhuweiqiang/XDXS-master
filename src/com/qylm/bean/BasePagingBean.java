package com.qylm.bean;

import java.io.Serializable;

import com.qylm.constants.Constants;

/**
 * 用于需要分页的管理类画面分页用
 * @author 
 *
 */
public abstract class BasePagingBean implements Serializable{

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8157114188908228993L;

	/**
	 * 当前页
	 */
	protected int currentPage = 1;
	
	/**
	 * 视图查询弹窗用
	 */
	protected String modelId;

	/**
	 * 共有几页
	 */
	protected int pageCount = 1;

	/**
	 * 一页多少条数据
	 */
	protected int onePageCount = Constants.onePageCount;

	/**
	 * 数据总数
	 */
	protected int dataCount = 0;

	/**
	 * 显示几个页数的连接（画面上【向前跳】和【向后跳】之间的数字）
	 */
	private static final int INDEX_COUNT = 5;

	/**
	 * 分页用偏移量
	 */
	private static final int OFFSET = INDEX_COUNT / 2 + 1;

	public BasePagingBean() {
	}

	/**
	 * 用于改变一页显示多少条数据用
	 * @param onePageCount
	 */
	public BasePagingBean(int onePageCount) {
		this.onePageCount = onePageCount;
	}

	/**
	 * 【向前跳】连接
	 * @return
	 */
	public String previousJump() {
		if (currentPage - 7 < 1) {
			currentPage = 1;
		} else {
			currentPage -= 7;
		}
		findData();
		return null;
	}
	
	/**
	 * 【向后跳】连接
	 * @return
	 */
	public String nextJump() {
		if (currentPage + 7 > pageCount) {
			currentPage = pageCount;
		} else {
			currentPage += 7;
		}
		findData();
		return null;
	}
	
	/**
	 * 【最后页】连接
	 * @return
	 */
	public String lastPage() {
		currentPage = pageCount;
		findData();
		return null;
	}

	/**
	 * 【前一页】连接
	 * @return
	 */
	public String previousPage() {
		currentPage -= 1;
		findData();
		return null;
	}

	/**
	 * 【后一页】连接
	 * @return
	 */
	public String nextPage() {
		currentPage += 1;
		findData();
		return null;
	}

	/**
	 * 【页数】连接
	 * @return
	 */
	public String numberPaging() {
		findData();
		return null;
	}

	/**
	 * 取数据
	 */
	private void findData() {
		fetchData((currentPage - 1) * onePageCount, false);
	}

	/**
	 * 取得第1个页数连接需要显示的数字
	 * @return
	 */
	public int getIndex1() {
		return findIndex(1);
	}

	/**
	 * 取得第2个页数连接需要显示的数字
	 * @return
	 */
	public int getIndex2() {
		return findIndex(2);
	}

	/**
	 * 取得第3个页数连接需要显示的数字
	 * @return
	 */
	public int getIndex3() {
		return findIndex(3);
	}

	/**
	 * 取得第4个页数连接需要显示的数字
	 * @return
	 */
	public int getIndex4() {
		return findIndex(4);
	}

	/**
	 * 取得第5个页数连接需要显示的数字
	 * @return
	 */
	public int getIndex5() {
		return findIndex(5);
	}

	/**
	 * 计算页数连接需要显示的数字
	 * @param indexNumber
	 * @return
	 */
	private int findIndex(int indexNumber) {
		int returnValue = currentPage + indexNumber - OFFSET;
		int minus;
		if (pageCount < INDEX_COUNT) {
			minus = pageCount - indexNumber;
		} else {
			minus = INDEX_COUNT - indexNumber;
		}
		if (returnValue > indexNumber) {
			if (returnValue + minus > pageCount) {
				return pageCount - minus;
			} else {
				return returnValue;
			}
		} else {
			return indexNumber;
		}
	}

	/**
	 * 用数据总条数初始化界面
	 * @param dataCount 数据总条数
	 */
	protected void init(int dataCount) {
		this.dataCount = dataCount;
		initPageCount();
		currentPage = 1;
	}

	/**
	 * 从当前画面显示的数据列表中移除多条数据
	 * @param count 移除数据的条数
	 * @param needData 是否重新取得数据（移除数据后画面数据列表为空是需要）
	 */
	protected void removeData(int count, boolean needData) {
		dataCount -= count;
		initPageCount();
		if (currentPage > pageCount) {
			currentPage = pageCount;
			findData();
		} else {
			if (needData) {
				findData();
			}
		}
	}

	/**
	 * 重新取得当前页数的数据
	 * @param currentPage 当前页数
	 */
	protected void reflushCurrentPage(int currentPage) {
		int currentData = (currentPage - 1) * onePageCount;
		fetchData(currentData, true);
		if (currentPage > pageCount) {
			this.currentPage = pageCount;
			if (dataCount != 0) {
				fetchData((this.currentPage - 1) * onePageCount, false);
			}
		} else {
			this.currentPage = currentPage;
		}
	}

	/**
	 * 计算总共有多少页
	 */
	private void initPageCount() {
		if (dataCount <= onePageCount) {
			pageCount = 1;
		} else {
			if (dataCount % onePageCount == 0) {
				pageCount = dataCount / onePageCount;
			} else {
				pageCount = dataCount / onePageCount + 1;
			}
		}
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	/**
	 * @return the modelId
	 */
	public String getModelId() {
		return modelId;
	}

	/**
	 * @param modelId the modelId to set
	 */
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	/**
	 * 取得数据的抽象方法，所有子类请实现本方法
	 * @param start 从第几条数据开始取
	 * @param needInit 是否需要重新计算总数据数
	 */
	protected abstract void fetchData(int start, boolean needInit);
	
}
