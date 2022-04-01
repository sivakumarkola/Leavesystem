package com.example.leave.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.leave.model.Leave;
import com.example.leave.repository.LeaveRepository;

@Service
public class LeaveServiceImpl implements LeaveService {
	
	@Autowired
	private LeaveRepository leaveRepository;
	
	@Override
	public List<Leave> getAllLeave() {
		return leaveRepository.findAll();
	}
	
	@Override
	public void saveLeave(Leave leave) {
		this.leaveRepository.save(leave);
	}

	@Override
	public Leave getLeaveById(int id) {
		Optional<Leave> optional = leaveRepository.findById(id);
		Leave leave = null;
		if (optional.isPresent()) {
			leave = optional.get();
		} else {
			throw new RuntimeException(" Leave not found for id :: " + id);
		}
		return leave;
	}
	
	@Override
	public void deleteLeaveById(int id) {
		this.leaveRepository.deleteById(id);
	}
	
	@Override
	public Page<Leave> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.leaveRepository.findAll(pageable);
	}
}
	


