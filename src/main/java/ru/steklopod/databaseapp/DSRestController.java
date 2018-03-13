package ru.steklopod.databaseapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DSRestController {

	@Autowired
	ProfileServiceDAO profileServiceDAO;
	
	@Autowired
	TaskServiceDAO taskServiceDAO;
	
	@RequestMapping(value="/userscount")
	public String userCount_from_ProfileService() {
		return "Count from Users Table is: "+profileServiceDAO.getCount_from_users();
	}
	
	@RequestMapping(value="/taskscount") 
	public String tasksCount_from_TaskService() {
		return "Count from Tasks table is: "+taskServiceDAO.getCount_from_tasks();
	}
}