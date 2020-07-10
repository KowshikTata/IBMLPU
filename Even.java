/*

Problem Statement 1:
1.Develop a java class with a method storeEvenNumbers(int N) using ArrayList to store even numbers from 2 to N, where N is a integer which is passed as a parameter to the method storeEvenNumbers().  The method should return the ArrayList (A1) created. 
2.In the same class create a method printEvenNumbers()which iterates through the arrayList A1 in step 1,  and It should multiply each number with 2 and display it in format 4,8,12….2*N. and add these numbers in a new ArrayList (A2). The new ArrayList (A2) created needs to be returned.
3.Create a method retrieveEvenNumber(int N)  parameter is a number N. This method should search the arrayList (A1) for the existence of the number ‘N’ passed.  If exists it should return the Number else return zero.
Hint:  Use instance variable for storing the ArrayList A1 and A2.


*/
import java.util.*;
public class Even
{
ArrayList al=new ArrayList();
ArrayList al2=new ArrayList();
//store even
ArrayList storeEven(int n)
{
for(int i=2;i<=n;i=i+2)
{
al.add(i);
}
return al;
}
//print even
ArrayList printEven()
{
Iterator itr = al.iterator();
while (itr.hasNext()) 
        {  
            int i = (Integer)itr.next(); 
i=i*2;
al2.add(i);
}
return al2;
}
//retrieveEvenNumber(int N)
int retrieveEvenNumber(int N)
{
Iterator itr = al.iterator();
while (itr.hasNext()) 
        {  
            int i = (Integer)itr.next(); 
if(i==N)
{
return i;
}
}
return 0;
}

public static void main(String args[])
{
Even obj=new Even();
System.out.println(obj.storeEven(10));
System.out.println(obj.printEven());
System.out.println(obj.retrieveEvenNumber(11));
}


}