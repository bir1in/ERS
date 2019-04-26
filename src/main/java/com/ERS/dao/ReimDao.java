package com.ERS.dao;

import java.util.List;

import com.ERS.bean.Reimbursement;

public interface ReimDao {
	public List<Reimbursement> getAllReims();
	public Reimbursement getReimById(int id);
	public void insertReim(Reimbursement r);
	public void deleteReim(Reimbursement r);
	public void updateReim(Reimbursement r);
}
