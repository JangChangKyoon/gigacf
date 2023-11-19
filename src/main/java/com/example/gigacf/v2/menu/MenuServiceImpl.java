package com.example.gigacf.v2.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.example.gigacf.v2.common.commonLogics.AbstractService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service("MenuService")
public class MenuServiceImpl extends AbstractService<MenuVo, MenuVo, List<?>> {

	@Resource
	private MenuInCafeDao menuInCafeDao;

	/**
	 * Exception 전환해서 던지기 메소드 몸체에서 Exception을 잡아서 NullPointerException로 예외를 전환해주고
	 * 메소드 시그니쳐의 throws NullPointerException로 호출하는 메소드(MenuCon.java)에 예외처리 던지기
	 */
	@Override
	public List<MenuVo> selectList() {
	    List<MenuVo> menuList = new ArrayList<>();
	    try {
	        menuList = menuInCafeDao.selectList();
	        log.info(menuList);
	    } catch (Exception e) {
	        if (menuList.isEmpty()) {
	            throw new NullPointerException("메뉴리스트가 존재하지 않습니다 in service");
	        } else {
	            throw e;
	        }
	    }
	    return  menuList;
	}

	
	@Override
	public void createOne(MenuVo vo) {
	    menuInCafeDao.insertOne(vo);
	}

	
	@Override
	public void deleteOne(MenuVo menuVo) {
		menuInCafeDao.deleteOne(menuVo);
	};
	

	@Override
	public MenuVo findOneByNo(MenuVo menuVo){
		MenuVo menu = menuInCafeDao.findOneByNo(menuVo);
		return menu;
	}

	@Override
	public void updateOne(MenuVo menuVo) {
		menuInCafeDao.updateOne(menuVo);;
	}
	
	@Override
	public void updateItems(MenuVo menuVo) {
		menuInCafeDao.updateList(menuVo);
	};

	@Override
	public  List<MenuVo> searchList(MenuVo menuVo) {
		List<MenuVo> menuList = menuInCafeDao.searchList(menuVo);
		 return menuList;
	}



}