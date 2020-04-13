package comm.example.demo;

import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import comm.example.demo.bean.Account;
import comm.example.demo.bean.AccountType;
import comm.example.demo.bean.ToDo;
import comm.example.demo.repo.ToDoRepository;
import comm.example.demo.repo.ToDoRepositoryImpl;
import comm.example.demo.service.AccountService;
import comm.example.demo.service.AccountServiceImpl;
import comm.example.demo.service.ToDoService;
import comm.example.demo.service.ToDoServiceImpl;

public class App 
{

	
	
	
	public static void main( String[] args )
    {
		Scanner scanner=new Scanner(System.in);
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		/*
		 * ToDoService service=context.getBean("toDoServiceImpl",ToDoServiceImpl.class);
		 * ToDo todo=context.getBean("toDo",ToDo.class);
		 * todo.setTodoID(UUID.randomUUID().toString()); todo.setTodoName("testing");
		 * todo=service.createToDo(todo); System.out.println(todo);
		 */
		int ch=0;
		do
		{
		AccountService service=context.getBean("accountServiceImpl",AccountServiceImpl.class);
		Account account=context.getBean("account",Account.class);
		System.out.println("1.Create Account"); 
		System.out.println("2.SelectAll Account"); 
		System.out.println("3.Update Account"); 
		System.out.println("4.Delete Account"); 
		System.out.println("5.Delete All Account");
		System.out.println("6.Select by Id");
		System.out.println("7.Exit");
		 ch=scanner.nextInt();
		switch(ch)
		{
		case 1: {
				String str[]=UUID.randomUUID().toString().split("-");
				
				account.setAccountNumber(str[0]);
				System.out.println("enter type of account");
				System.out.println("a.Savings/n b.Loan/n c.current/n d.credit_card");
				char accountType=scanner.next().charAt(0); 
				if(accountType=='a'){
				account.setAccountType(AccountType.SAVINGS);
				}
				else if(accountType=='b'){
					account.setAccountType(AccountType.LOAN);
				}
				else if(accountType=='c'){
					account.setAccountType(AccountType.CURRENT);
				}
				else
				{
					account.setAccountType(AccountType.CREDIT_CARD);
				}
				account.setInitialBalance(500);
				account=service.createAccount(account);
				System.out.println(account);
				break;
		}
		case 2:
		service.getAll();
		break;
		case 3:
			System.out.println("enter accountNo");
			String accountNumber=scanner.next();
			System.out.println("enter accountBalence");
			int balence=scanner.nextInt();
		service.update(accountNumber, balence);
		break;
		
		case 4:
			System.out.println("enter accountNo");
			accountNumber=scanner.next();
			service.delete(accountNumber);
		break;
		case 5:
			service.deleteAll();
			break;
		case 6:
			System.out.println("enter accountNo");
			accountNumber=scanner.next();
			System.out.println(service.getById(accountNumber));
			break;
		case 7:
			System.exit(0);
			break;
		default:
			System.out.println("select from 1-7");
 
		}
		
}while(ch!=7);
	
    }
}
