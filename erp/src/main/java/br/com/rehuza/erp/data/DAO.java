package br.com.rehuza.erp.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;


public interface DAO<T, I extends Serializable> {
 
 public T salvar(T entity);
 
 public void atualizar(T entity);
   
 public T carregar(Class<T> classe, I pk);
  
 public T getById(Class<T> classe, I pk);
  
 public List<T> getAll(Class<T> classe);
  
 public EntityManager getEntityManager();

void excluir(Class<T> classe, Long pk);
}
