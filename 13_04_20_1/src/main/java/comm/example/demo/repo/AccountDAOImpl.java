package comm.example.demo.repo;

import java.sql.ResultSet;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import comm.example.demo.bean.Account;

@Repository("accountDAO")
public class AccountDAOImpl implements AccountDAO{
	
	private JdbcTemplate jdbcTemplate;
	private Logger logger=Logger.getLogger("AccountDAOImpl");
	@Autowired
	public AccountDAOImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}



	public Account createAccount(Account account) {
		// TODO Auto-generated method stub
		String query="insert into account(accountNumber,accountType,initialBalance) values('"
				+account.getAccountNumber()+"','"
				+account.getAccountType()+"',"+account.getInitialBalance()+")";
		
		jdbcTemplate.update(query);
		
		return account;
	}



	public void getAll() {
		// TODO Auto-generated method stub
		String query="select * from account";
		List<Account> list=jdbcTemplate.query(query,new BeanPropertyRowMapper(Account.class));
		Iterator ir=list.iterator();
		while(ir.hasNext())
		{
			Account ac=(Account) ir.next();
			System.out.println(ac.getAccountNumber());
			System.out.println(ac.getAccountType());
			System.out.println(ac.getInitialBalance());
		}
		
	}



	public void delete(String id) {
		// TODO Auto-generated method stub
		
		String query="delete from account where accountNumber=?";
		
		jdbcTemplate.update(query,id);
		
	}

	public void deleteAll() {
		// TODO Auto-generated method stub
		
		String query="delete from account where accountNumber!=?";
		
		jdbcTemplate.update(query,"null");
		
	}


	public void update(String id,int Balence) {
		// TODO Auto-generated method stub
String query="update account set initialBalance=? where accountNumber=?";
		
		jdbcTemplate.update(query,Balence,id);
	}



	public Account getById(String id) {
		// TODO Auto-generated method stub
		String query="select * from account where accountNumber=?";
		Account account=jdbcTemplate.queryForObject(query,new Object[] {id},new BeanPropertyRowMapper(Account.class));
		return account;
	}
	
	
	

}
