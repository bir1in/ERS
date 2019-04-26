package com.ERS.dao;

import java.util.List;

import com.ERS.bean.Reimbursement;

public class ReimService {
	public List<Reimbursement> getAllReims(){
		return new ReimDaoImp().getAllReims();
	}
	
	public Reimbursement getReimById(int id) {
		return new ReimDaoImp().getReimById(id);
	}
	
	public void insertReim(Reimbursement r) {
		new ReimDaoImp().insertReim(r);
	}
	
	public void deleteReim(Reimbursement r) {
		new ReimDaoImp().deleteReim(r);
	}
	public void updateReim(Reimbursement r) {
		new ReimDaoImp().updateReim(r);
	}
}
