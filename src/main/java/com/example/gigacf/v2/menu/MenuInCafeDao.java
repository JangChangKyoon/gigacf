package com.example.gigacf.v2.menu;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.gigacf.v2.common.commonLogics.AbstractDAO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Repository("menu")
public class MenuInCafeDao extends AbstractDAO<MenuVo> {
	
	public List<MenuVo> selectList()  {
		return selectList("menu.selectAll");
	}
	
	public void insertOne(MenuVo menuVo) {
		insert("menu.insert", menuVo);
	}
	
	public void deleteOne(MenuVo menuVo) {
		delete("menu.delete", menuVo);
	}
	
	public MenuVo findOneByNo(MenuVo menuVo){
		return selectOne("menu.selectOne", menuVo);
	};
	
	public void updateOne(MenuVo menuVo){
		update("menu.updateOne", menuVo);
	};
	
    public void updateList(MenuVo menuVo) {
    	updateList("menu.updateList", menuVo);
    }
	
	public List<MenuVo> searchList(MenuVo menuVo){
		return selectList("menu.searchList", menuVo);
	}

	
}
