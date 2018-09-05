package br.com.pimentel.laboratorio2.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 * @author Rodrigo Pimentel
 * @NocaCorporation @2018
 *
 * Data Access Object(DAO) Generico
 */
public abstract class RepositoryGeneric<T, PK> {

	protected final EntityManager entityManager;
	private final EntityManagerFactory factory;
	private Class<?> clazz;	
	private static final String PERSISTENCE_UNIT_NAME = "NocaCorporationPersistenceUnit";

	public RepositoryGeneric() {
		this(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
	}

	public RepositoryGeneric(EntityManagerFactory factory) {
		this.factory = factory;
		this.entityManager = factory.createEntityManager();
		this.clazz = (Class<?>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * Crai uma Query SQL personalizada
	 * 
	 * @param query Query SQL
	 * @param params Paramentros para a Query
	 * @return o Reultado da Query
	 */
	public Object executeQuery(String query, Object... params) {
		Query createdQuery = this.entityManager.createQuery(query);
		for (int i = 0; i < params.length; i++) {
			createdQuery.setParameter(i, params[i]);
		}
		return createdQuery.getResultList();		
	}

	/**
	 * Retorna uma lista com todos os dados do banco de dados
	 * @return uma lista com o resultado
	 */
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return this.entityManager.createQuery(("FROM " + this.clazz.getName())).getResultList();
	}

	/**
	 * Busca por um identificador
	 * 
	 * @param pk Id a ser pesquisado
	 * @return o Objeto pesquisado
	 */
	@SuppressWarnings("unchecked")
	public T findById(PK pk) {
		return (T) this.entityManager.find(this.clazz, pk);				
	}

	/**
	 * Salva no Banco de Dados
	 * @param entity Objeto a ser salvo
	 * @throws Exception 
	 */
	public void  save(T entity) throws Exception {
		try {
			this.beginTransaction();
			Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
			Set<ConstraintViolation<T>> erros = validador.validate(entity);
			if (erros.size() > 0) {
				for (ConstraintViolation<T> constraintViolation : erros) {
					System.out.println("Erro: " + constraintViolation.getMessage());
				}
			}else {
				this.entityManager.persist(entity);				
			}

			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	}

	/**
	 * Atualiza um objeto
	 * @param entity Objeto a ser atualizado
	 * @throws Exception 
	 */
	public void update(T entity) throws Exception {
		try {
			this.beginTransaction(); 
			Validator validador = Validation.buildDefaultValidatorFactory().getValidator();
			Set<ConstraintViolation<T>> erros = validador.validate(entity);
			if (erros.size() > 0) {
				for (ConstraintViolation<T> constraintViolation : erros) {
					System.out.println("Erro: " + constraintViolation.getMessage());
				}
			}else {
				this.entityManager.merge(entity);				
			}			

			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	}

	/**
	 * Deleta um objeto
	 * @param entity Objeto a ser deletado
	 * @throws Exception 
	 */
	public void delete(T entity) throws Exception {
		try {
			this.beginTransaction();
			this.entityManager.remove(entity);
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	}

	/**
	 * Deleta um objeto pelo Id
	 * @param pk Id do objeto a ser deletado
	 * @throws Exception 
	 */
	public void deleteForPK(PK pk) throws Exception {
		try {
			this.beginTransaction();
			this.entityManager.remove(this.entityManager.find(this.clazz, pk));
			this.commit();
		} catch (Exception e) {
			this.rollBack();
			throw e;
		}
	}

	/**
	 * Abre uma conexão com o BD e Inicia a transação
	 */
	public void beginTransaction(){
		this.entityManager.getTransaction().begin();
	}

	/**
	 * Comita a transação
	 */
	public void commit(){
		this.entityManager.getTransaction().commit();
	}

	/**
	 * Fecha a conexão com o BD
	 */
	public void close(){
		this.entityManager.close();
		this.factory.close();
	}

	/**
	 * Caso aconteça um erro na transação recupera o estado anterior
	 */
	public void rollBack(){
		this.entityManager.getTransaction().rollback();
	}

	/**
	 * Retorna um EntityManager
	 * @return EntityManager
	 */
	public EntityManager getEntityManager(){
		return this.entityManager;
	}

}
