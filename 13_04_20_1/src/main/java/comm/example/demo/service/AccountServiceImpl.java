package comm.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comm.example.demo.bean.Account;
import comm.example.demo.repo.AccountDAO;
@Service
public class AccountServiceImpl implements AccountService {
	private AccountDAO accountDAO;

	@Autowired
	public AccountServiceImpl(AccountDAO accountDAO) {
		super();
		this.accountDAO = accountDAO;
	}

	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		return accountDAO.createAccount(account);
	}

	public void getAll() {
		// TODO Auto-generated method stub
		accountDAO.getAll();
	}

	public void update(String id,int balence) {
		// TODO Auto-generated method stub
		accountDAO.update(id,balence);
	}

	public void delete(String id) {
		// TODO Auto-generated method stub
		accountDAO.delete(id);
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		accountDAO.deleteAll();
	}

	public Account getById(String id) {
		// TODO Auto-generated method stub
		return accountDAO.getById(id);
	}

}
