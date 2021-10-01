package com.devsuperior.hrworker.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrworker.controllers.dtos.WorkerDTO;
import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	@Autowired
	private WorkerRepository workerRepository;
	
	public List<WorkerDTO> findAll(){
		List<Worker> workers = workerRepository.findAll();
		return workers.stream().map(w -> new WorkerDTO(w)).collect(Collectors.toList());
	}

	public WorkerDTO findById(Long id) {
		Optional<Worker> workerDTO = workerRepository.findById(id);
		return new WorkerDTO(workerDTO.get());
	}
}
