package comm.example.demo.service;

import comm.example.demo.bean.Account;

public interface AccountService {

	public Account createAccount(Account account);

	public Account getById(String id);
	
	public void getAll();
	
	public void update(String id,int balence);
	
	public void delete(String id);
	
	public void deleteAll();
}
