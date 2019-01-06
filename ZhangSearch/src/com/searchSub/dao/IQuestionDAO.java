package com.searchSub.dao;
import java.util.List;

import com.searchSub.po.IQuestion;
import com.searchSub.po.Question;

public interface IQuestionDAO {
	public void save(IQuestion transientInstance);
	public void delete(Question transientInstance);
	public void update(Question transientInstance);
	public List findByHQL(String hql);
}
