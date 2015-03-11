package net.codejava.spring.generic;

import java.io.Serializable;
import java.util.List;


public interface GenericDao<T extends Serializable> {
	 
	T findById(Long id);

	T findById(String id);

	// List<T> findAll(Pagination paginacion);

	long countAll();

	T persist(T bean)  ;

	void remove(T bean);

	void removeAll();

	T merge(T t);

	List<T> findAll();

	List<T> findAll(int maxRowReturn);

	List<T> findAllSort(int maxRowReturn, String propiedad1);

	List<T> findAllSortDes(int maxRowReturn, String propiedad1);

	boolean findPkExist(String nombreClasePadre, Object clasePkHija) throws ClassNotFoundException;

	T findByPkCompuesta(String nombreClasePadre, Object clasePkHija) throws ClassNotFoundException;

	void deleteProcesoDelMes(String nombreTabla, String nombreCampoMes, String nombreCampoNumero, String cplanillaMesProceso,
			Integer nplanillaNumProceso);

	//List<T> findObjectByFieldCriteria(String nombreCampo, Object valorCampo);

	List<T> findObjectByFieldCriteria(String nombreCampo, Object valorCampo, String nombreCampo2, Object valorCampo2);

	List<T> findObjectByFieldCriteria(String nombreCampo, Object valorCampo);
	
	}