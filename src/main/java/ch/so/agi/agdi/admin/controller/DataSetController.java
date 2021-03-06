package ch.so.agi.agdi.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ch.so.agi.agdi.admin.model.DataSet;
import ch.so.agi.agdi.admin.service.DataSetService;

@Controller
public class DataSetController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DataSetService dataSetService;

	@GetMapping("/data_sets")
	public ModelAndView listDataSets() {
		ModelAndView mv = new ModelAndView("data_sets");
		mv.addObject("dataSets", dataSetService.findAll());
		
		return mv;
	}
	
	@GetMapping("/data_sets/new")
	public ModelAndView addDataSet() {
		ModelAndView mv = new ModelAndView("data_sets_add_new");
		mv.addObject("dataSets", dataSetService.findAll());
		
		return mv;
	}
	
//	@ResponseBody
//	@GetMapping("/data_sets/tables")
//	public void listDataSourceTables(@RequestParam(value = "data_source_id", required = true) int dataSourceId) {
//		log.info("*****");
//		log.info("fubar");
//	}
}
