package com.devsuperior.hrworker.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.controllers.dtos.WorkerDTO;
import com.devsuperior.hrworker.services.WorkerService;

@RestController
@RefreshScope
@RequestMapping(value = "/workers")
public class WorkerController {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	
	@Value("${test.config}")
	private String configServer;

	@Autowired
	private WorkerService workerService;
	
	@GetMapping("/configs")
	public ResponseEntity <Void> getConfig(){
		logger.info("CONFIG = " + configServer);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity <List<WorkerDTO>> findAll(){
		List<WorkerDTO> workersDTO = workerService.findAll();
		return ResponseEntity.ok(workersDTO);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <WorkerDTO> findById(@PathVariable Long id){
		WorkerDTO workerDTO = workerService.findById(id);
		return ResponseEntity.ok(workerDTO);
	}
}
