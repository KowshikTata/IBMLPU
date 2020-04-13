package comm.example.demo.repo;

import comm.example.demo.bean.Account;

public interface AccountDAO {
	
	public Account createAccount(Account account);
	
	public void getAll();
	
	public Account getById(String id);
	
	public void update(String id,int Balence);
	
	public void delete(String id);
	
	public void deleteAll();
}
