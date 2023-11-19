package com.example.gigacf.v2.menu;

import java.util.List;

import javax.annotation.Resource;
import javax.management.MXBean;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller("MenuController")
@RequestMapping("/v2/menu")
public class MenuCon {

	@Resource
	private MenuServiceImpl menuService;

	/** 
	 * */
	@GetMapping("/menu_list")
	public ModelAndView menuList() {
		ModelAndView modelAndView = new ModelAndView("/v2/menu/menu");
		List<MenuVo> menuList = menuService.selectList();
		modelAndView.addObject("menuList", menuList);
		return modelAndView;
	}
	
	@GetMapping("/menu_ins")
	public String showMenuInsertPage() {
		return "/v2/menu/menu_ins";
	}
	
	@PostMapping("/menu_ins")
	public ModelAndView createMenu(MenuVo menuVo) {
		ModelAndView mv = new ModelAndView("redirect:/v2/menu/menu_list");
		menuService.createOne(menuVo);
		return mv;
	}
	
	@GetMapping("/menu_del")
	public ModelAndView deleteMenu(MenuVo menuVo) {
		ModelAndView mv = new ModelAndView("redirect:/v2/menu/menu_list");
		menuService.deleteOne(menuVo);
		return mv;
	}
	
	@GetMapping("/menu_up")
	public ModelAndView showUpdateMenuPage(MenuVo menuVo) {
		ModelAndView mv = new ModelAndView("/v2/menu/menu_up");
		MenuVo menu = menuService.findOneByNo(menuVo);
		log.info(menu);
		mv.addObject("menu",menu);
		return mv;
	}
	
	@PostMapping("/menu_up")
	public ModelAndView updateMenu(MenuVo menuVo) {
		ModelAndView mv = new ModelAndView("redirect:/v2/menu/menu_list");
		menuService.updateOne(menuVo);
		return mv;
	}
	
	@PostMapping("/menu_updatePrices")
	public String updatePrices(MenuVo menuVo) {
		log.info(menuVo);
		menuService.updateItems(menuVo);
		return "redirect:/v2/menu/menu_list";
	}
	
	@PostMapping("/menu_search")
	public ModelAndView searchMenus(MenuVo menuVo) {
		ModelAndView mv = new ModelAndView("/v2/menu/menu");
		List<MenuVo> menuList = menuService.searchList(menuVo);
		log.info(menuList);
		mv.addObject("menuList", menuList);
		return mv;
	}
}
