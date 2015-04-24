package com.moresex.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.moresex.dao.ContentInfoDao;
import com.moresex.entity.Article;
import com.moresex.entity.HibernateSessionFactory;

/**
 * @description
 * 
 * @author ÐÒÔËScience ³ÂÍÁŸö
 * @school University of South China
 * @email science.chentushen@gmail.com,274240671@qq.com
 * @version V1.0
 * @date 2015-4-15
 * 
 */
public class ContentInfoDaoImpl implements ContentInfoDao {

	private Session mSession;
	private Query mQuery;

	@Override
	public String getContent(Integer ids) {

		mSession = HibernateSessionFactory.getSession();
		mQuery = mSession.createQuery("from Article at where at.contentId="
				+ "(select contentId from Article att where att.id=:ids)");
		mQuery.setParameter("ids", ids);

		List<Article> contentList = mQuery.list();

		String content = null;
		for (int i = 0; i < contentList.size(); i++) {
			content = content + contentList.get(i).getContent();
		}

		mSession.close();

		return content;

	}

}
