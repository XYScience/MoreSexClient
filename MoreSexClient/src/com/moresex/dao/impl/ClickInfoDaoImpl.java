package com.moresex.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.moresex.dao.ClickInfoDao;
import com.moresex.entity.Article;
import com.moresex.entity.HibernateSessionFactory;

/**
 * @description
 * 
 * @author ����Science ������
 * @school University of South China
 * @email science.chentushen@gmail.com,274240671@qq.com
 * @version V1.0
 * @date 2015-4-9
 * 
 */
public class ClickInfoDaoImpl implements ClickInfoDao {

	private Integer click = 0;
	// ���������
	Session session = HibernateSessionFactory.getSession();
	Transaction tx = session.beginTransaction();

	// ���������
	@Override
	public void getClick(Integer id) {
		try {
			Article articleInfo = (Article) session.get(Article.class, id);
			// �ж�click�ֶ��Ƿ�Ϊ��
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
