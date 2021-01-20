package kr.pe.bluering.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.pe.bluering.beans.BoardInfoBean;
import kr.pe.bluering.mapper.TopMenuMapper;

@Repository
public class TopMenuDao {

	@Autowired
	private TopMenuMapper topMenuMapper;
	
	public List<BoardInfoBean> getTopMenuList(){
		List<BoardInfoBean> topMenuList = topMenuMapper.getTopMenuList();
		return topMenuList;
	}
}
