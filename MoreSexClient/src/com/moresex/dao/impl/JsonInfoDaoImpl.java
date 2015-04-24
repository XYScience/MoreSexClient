package com.moresex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.moresex.entity.Article;
import com.moresex.entity.HibernateSessionFactory;

/**
 * @description
 * 
 * @author ����Science ������
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
	// ��ȡ��������
	public List<Article> getInfo_skill(int page) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession
				.createQuery("select ar from Article ar where ar.type='shenghuo' group by ar.contentId");// ȥ���ظ���ҳ
		mQuery.setCacheable(true);// �����ѯ����
		mQuery.setFirstResult((page - 1) * PAGE_SIZE);
		mQuery.setMaxResults(PAGE_SIZE);

		mInfoList = mQuery.list();
		mSession.close();

		return mInfoList;
	}

	// ��ȡ��������
	public List<Article> getInfo_health(int page) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession
				.createQuery("select ar from Article ar where ar.type='jiankang' group by ar.contentId");
		mQuery.setCacheable(true);// �����ѯ����
		mQuery.setFirstResult((page - 1) * PAGE_SIZE);
		mQuery.setMaxResults(PAGE_SIZE);

		mInfoList = mQuery.list();
		mSession.close();

		return mInfoList;
	}

	// ��ȡ��������
	public List<Article> getInfo_birth(int page) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession
				.createQuery("select ar from Article ar where ar.type='biyun' group by ar.contentId");
		mQuery.setCacheable(true);// �����ѯ����
		mQuery.setFirstResult((page - 1) * PAGE_SIZE);
		mQuery.setMaxResults(PAGE_SIZE);

		mInfoList = mQuery.list();
		mSession.close();

		return mInfoList;
	}

	// ��ȡ��������
	public List<Article> getInfo_mentality(int page) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession
				.createQuery("select ar from Article ar where ar.type='xinlii' group by ar.contentId");
		mQuery.setCacheable(true);// �����ѯ����
		mQuery.setFirstResult((page - 1) * PAGE_SIZE);
		mQuery.setMaxResults(PAGE_SIZE);

		mInfoList = mQuery.list();
		mSession.close();

		return mInfoList;
	}

	// ��ȡ��������
	public List<Article> getInfo_physiology(int page) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession
				.createQuery("select ar from Article ar where ar.type='shengli' group by ar.contentId");
		mQuery.setCacheable(true);// �����ѯ����
		mQuery.setFirstResult((page - 1) * PAGE_SIZE);
		mQuery.setMaxResults(PAGE_SIZE);

		mInfoList = mQuery.list();
		mSession.close();

		return mInfoList;
	}

	// 10���Ƽ�����
	public List<Article> getInfo_recommend(int page) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession
				.createQuery("from Article f ORDER BY f.click DESC LIMIT 10");
		mQuery.setCacheable(true);// �����ѯ����
		mQuery.setFirstResult((page - 1) * PAGE_SIZE);
		mQuery.setMaxResults(PAGE_SIZE);

		mInfoList = mQuery.list();

		mSession.close();

		return mInfoList;
	}

	// ��ȡһ���������¼�¼
	public List<Article> getInfoArticle(int ids) {
		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession.createQuery("from Article f where f.id=:ids ");
		mQuery.setParameter("ids", ids);

		mQuery.setCacheable(true);// �����ѯ����

		mInfoList = mQuery.list();

		mSession.close();

		return mInfoList;
	}

}
