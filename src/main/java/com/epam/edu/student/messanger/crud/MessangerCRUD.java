package com.epam.edu.student.messanger.crud;

import java.util.List;

import com.epam.edu.student.messanger.model.Messanger;

public interface MessangerCRUD {
	Integer save(Messanger messanger);
	void update(Messanger messanger);
	void delete(Messanger messanger);
	Messanger getMessangerOnId(int id);
	List<Messanger> getAllInstances();
}
