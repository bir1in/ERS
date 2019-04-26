package com.ERS.dao;

import java.util.List;

import com.ERS.bean.Manager;

public class MgrService {
	public List<Manager> getAllMgrs(){
		return new MgrDaoImp().getAllMgrs();
	}
	
	public Manager getMgrById(int id) {
		return new MgrDaoImp().getMgrById(id);
	}
	
	public void insertMgr(Manager e) {
		new MgrDaoImp().insertMgr(e);
	}
	
	public void deleteMgr(Manager m) {
		new MgrDaoImp().deleteMgr(m);
	}
	
	public void updateMgr(Manager m) {
		new MgrDaoImp().updateMgr(m);
	}
}
