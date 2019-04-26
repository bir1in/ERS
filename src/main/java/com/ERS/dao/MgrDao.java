package com.ERS.dao;


import java.util.List;

import com.ERS.bean.Manager;

public interface MgrDao {
	public List<Manager> getAllMgrs();
	public Manager getMgrById(int id);
	public void insertMgr(Manager m);
	public void deleteMgr(Manager m);
	public void updateMgr(Manager m);
}
