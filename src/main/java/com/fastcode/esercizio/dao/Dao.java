package com.fastcode.esercizio.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    
	Integer save(T t);
	
    Optional<T> get(Integer id);
     
    List<T> getAll();
      
    void update(T t);
     
    void delete(T t);
    
    void deleteAll();
}
