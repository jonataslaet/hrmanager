package com.devsuperior.hrworker.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.devsuperior.hrworker.controllers.dtos.WorkerDTO;
import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerService.class);

	@Autowired
	private Environment environment;
	
	@Autowired
	private WorkerRepository workerRepository;
	
	public List<WorkerDTO> findAll(){
		List<Worker> workers = workerRepository.findAll();
		return workers.stream().map(w -> new WorkerDTO(w)).collect(Collectors.toList());
	}

	public WorkerDTO findById(Long id) {
//		try {
//			Thread.sleep(3000L);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		logger.info("PORT: " + environment.getProperty("local.server.port"));
		Optional<Worker> workerDTO = workerRepository.findById(id);
		return new WorkerDTO(workerDTO.get());
	}
}
