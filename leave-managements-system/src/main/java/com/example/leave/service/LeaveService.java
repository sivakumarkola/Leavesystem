package com.example.leave.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.leave.model.Leave;

public interface LeaveService {

	List<Leave> getAllLeave();
	void saveLeave(Leave leave);
	Leave getLeaveById(int id);
	void deleteLeaveById(int id);
	Page<Leave> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);


}
