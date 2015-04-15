package com.moresex.dao;

import java.util.List;

import com.moresex.entity.Article;

/**
 * @description 得到文章内容
 * 
 * @author 幸运Science 陈土燊
 * @school University of South China
 * @email science.chentushen@gmail.com,274240671@qq.com
 * @version V1.0
 * @date 2015-4-9
 * 
 */
public interface ContentInfoDao {

	public List<Article> getContent(Integer id);
}
