package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.data.Employee;
@Repository(value = "employeeDAO")
@EnableTransactionManagement
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	@Override
	
	public List<Employee> getEmployees() {

		

		Query query = entityManager.createQuery("from Employee", Employee.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		entityManager.persist(employee);
		return employee;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee e=entityManager.find(Employee.class, id);
		
		return e;
	}

	@Override
	@Transactional
	public Employee deleteEmployee(int id) {
		Employee e=entityManager.find(Employee.class,id);
		if(e==null)
		{
			return null;
		}
		entityManager.remove(e);
		return e;
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		Employee emp=entityManager.find(Employee.class,employee.getId());
		if(emp==null)
		{
			return null;
		}
		entityManager.merge(employee);
		return employee;
	}

}
