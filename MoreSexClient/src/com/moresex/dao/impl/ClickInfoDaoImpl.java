package com.moresex.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.moresex.dao.ClickInfoDao;
import com.moresex.entity.Article;
import com.moresex.entity.HibernateSessionFactory;

/**
 * @description
 * 
 * @author 幸运Science 陈土燊
 * @school University of South China
 * @email science.chentushen@gmail.com,274240671@qq.com
 * @version V1.0
 * @date 2015-4-9
 * 
 */
public class ClickInfoDaoImpl implements ClickInfoDao {

	private Integer click = 0;
	// 点击量增加
	Session session = HibernateSessionFactory.getSession();
	Transaction tx = session.beginTransaction();

	// 点击量增加
	@Override
	public void getClick(Integer id) {
		try {
			Article articleInfo = (Article) session.get(Article.class, id);
			// 判断click字段是否为空
			if (articleInfo.getClick() == null) {
				articleInfo.setClick(1);
			} else {
				click = articleInfo.getClick();
				click++;
				articleInfo.setClick(click);
			}
			session.update(articleInfo);
			tx.commit();
			session.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
