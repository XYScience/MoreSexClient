package com.moresex.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.moresex.dao.ClickInfoDao;
import com.moresex.dao.ContentInfoDao;
import com.moresex.dao.impl.ClickInfoDaoImpl;
import com.moresex.dao.impl.ContentInfoDaoImpl;
import com.moresex.dao.impl.JsonInfoDaoImpl;
import com.moresex.entity.Article;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @description
 * 
 * @author 幸运Science 陈土燊
 * @school University of South China
 * @email science.chentushen@gmail.com,274240671@qq.com
 * @version V1.0
 * @date 2015-4-8
 * 
 */
public class JSONAction extends ActionSupport implements ServletRequestAware,
		ServletResponseAware {

	private HttpServletRequest mRequest;
	private HttpServletResponse mResponse;
	private String format;
	private List<Article> mInfoList = new ArrayList<Article>();
	private int page = 1;
	private Integer id = 1;
	private JsonInfoDaoImpl mJsonInfoDao = new JsonInfoDaoImpl();
	private Gson mGson;
	private String mContent;

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		mResponse = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		mRequest = request;
	}

	public List<Article> getInfoList() {
		return mInfoList;
	}

	public void setInfoList(List<Article> infoList) {
		mInfoList = infoList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void skillJson() {

		mInfoList = mJsonInfoDao.getInfo_skill(page);
		getJson();
	}

	public void meathlJson() {

		mInfoList = mJsonInfoDao.getInfo_health(page);
		getJson();
	}

	public void physiologyJson() {

		mInfoList = mJsonInfoDao.getInfo_physiology(page);
		getJson();
	}

	public void mentalityJson() {

		mInfoList = mJsonInfoDao.getInfo_mentality(page);
		getJson();
	}

	public void birthControlJson() {

		mInfoList = mJsonInfoDao.getInfo_birth(page);
		getJson();
	}

	public void recommendJson() {

		mInfoList = mJsonInfoDao.getInfo_recommend(page);
		getJson();
	}

	public void getJson() {

		mGson = new Gson();

		java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<Article>>() {
		}.getType();
		String beanListToJson = mGson.toJson(mInfoList, type);

		try {
			mResponse.setContentType("text/json; charset = utf-8");// 解决中文乱码问题
			mResponse.setCharacterEncoding("utf-8");
			this.mResponse.getWriter().write(beanListToJson);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 更改点击量
	public String getClick() {

		ClickInfoDao clickInfoDao = new ClickInfoDaoImpl();

		clickInfoDao.getClick(id);

		return SUCCESS;
	}

	// 得到文章内容
	public void getContent() {

		ContentInfoDao contentInfoDao = new ContentInfoDaoImpl();
		mContent = contentInfoDao.getContent(id);
		try {
			mResponse.setContentType("text/json; charset = utf-8");// 解决中文乱码问题
			mResponse.setCharacterEncoding("utf-8");
			this.mResponse.getWriter().write(mContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getArticleContent() {
		mInfoList = mJsonInfoDao.getInfoArticle(id);
		getJson();
	}
}
