package com.example.demo.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.fallback.EmployeeFallback;
import com.example.demo.model.Employee;

@FeignClient(value="service-B",fallback=EmployeeFallback.class)
public interface EmployeeClient {

	@RequestMapping("/api/employees/hi")
	public String callHi(@RequestParam String name);
	@RequestMapping("/api/employees/findEmployee")
	public List<Employee> find(@RequestParam String name);
}
