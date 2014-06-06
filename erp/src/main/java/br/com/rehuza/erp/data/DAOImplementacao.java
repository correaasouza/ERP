package br.com.rehuza.erp.data;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public abstract class DAOImplementacao<T, I extends Serializable> implements
		DAO<T, I> {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public T salvar(T entity) {
		T saved = null;
		saved = getEntityManager().merge(entity);
		return saved;
	}

	@Override
	public void atualizar(T entity) {
		getEntityManager().merge(entity);
	}

	@Override
	public void excluir(Class<T> classe, Long pk) {
		T entityRem = getEntityManager().find (classe , pk) ;
		getEntityManager().remove(entityRem);
	}

	@Override
	public T carregar(Class<T> classe, I pk) {

		try {
			return getEntityManager().find(classe, pk);
		} catch (NoResultException e) {
			return null;
		}

	}

	@Override
	public T getById(Class<T> classe, I pk) {

		try {
			return getEntityManager().find(classe, pk);
		} catch (NoResultException e) {
			return null;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> classe) {

		return getEntityManager().createQuery(
				"select o from " + classe.getSimpleName() + " o order  by nome")
				.getResultList();
	}

	@Override
	public EntityManager getEntityManager() {
		return this.manager;
	}

}