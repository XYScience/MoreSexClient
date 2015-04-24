package com.moresex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.moresex.entity.Article;
import com.moresex.entity.HibernateSessionFactory;

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
public class JsonInfoDaoImpl {

	private final int PAGE_SIZE = 10;
	private List<Article> mInfoList;
	private Session mSession;
	private Query mQuery;

	// "select distinct contentId, id, title, time, content, source, imgUrl, click "
	// + "from Article where type='shenghuo' group by contentId"
	// 获取技巧数据
	public List<Article> getInfo_skill(int page) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession
				.createQuery("select ar from Article ar where ar.type='shenghuo' group by ar.contentId");// 去除重复分页
		mQuery.setCacheable(true);// 激活查询缓存
		mQuery.setFirstResult((page - 1) * PAGE_SIZE);
		mQuery.setMaxResults(PAGE_SIZE);

		mInfoList = mQuery.list();
		mSession.close();

		return mInfoList;
	}

	// 获取健康数据
	public List<Article> getInfo_health(int page) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession
				.createQuery("select ar from Article ar where ar.type='jiankang' group by ar.contentId");
		mQuery.setCacheable(true);// 激活查询缓存
		mQuery.setFirstResult((page - 1) * PAGE_SIZE);
		mQuery.setMaxResults(PAGE_SIZE);

		mInfoList = mQuery.list();
		mSession.close();

		return mInfoList;
	}

	// 获取避孕数据
	public List<Article> getInfo_birth(int page) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession
				.createQuery("select ar from Article ar where ar.type='biyun' group by ar.contentId");
		mQuery.setCacheable(true);// 激活查询缓存
		mQuery.setFirstResult((page - 1) * PAGE_SIZE);
		mQuery.setMaxResults(PAGE_SIZE);

		mInfoList = mQuery.list();
		mSession.close();

		return mInfoList;
	}

	// 获取心理数据
	public List<Article> getInfo_mentality(int page) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession
				.createQuery("select ar from Article ar where ar.type='xinlii' group by ar.contentId");
		mQuery.setCacheable(true);// 激活查询缓存
		mQuery.setFirstResult((page - 1) * PAGE_SIZE);
		mQuery.setMaxResults(PAGE_SIZE);

		mInfoList = mQuery.list();
		mSession.close();

		return mInfoList;
	}

	// 获取生理数据
	public List<Article> getInfo_physiology(int page) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession
				.createQuery("select ar from Article ar where ar.type='shengli' group by ar.contentId");
		mQuery.setCacheable(true);// 激活查询缓存
		mQuery.setFirstResult((page - 1) * PAGE_SIZE);
		mQuery.setMaxResults(PAGE_SIZE);

		mInfoList = mQuery.list();
		mSession.close();

		return mInfoList;
	}

	// 10条推荐数据
	public List<Article> getInfo_recommend(int page) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession
				.createQuery("from Article f ORDER BY f.click DESC LIMIT 10");
		mQuery.setCacheable(true);// 激活查询缓存
		mQuery.setFirstResult((page - 1) * PAGE_SIZE);
		mQuery.setMaxResults(PAGE_SIZE);

		mInfoList = mQuery.list();

		mSession.close();

		return mInfoList;
	}

	// 读取一条完整文章记录
	public List<Article> getInfoArticle(int ids) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession.createQuery("from Article f where f.id=:ids ");
		mQuery.setParameter("ids", ids);

		mQuery.setCacheable(true);// 激活查询缓存

		mInfoList = mQuery.list();

		mSession.close();

		return mInfoList;
	}

}
