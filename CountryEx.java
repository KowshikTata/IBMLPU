/*
1.Develop a java class with a instance variable Country  HashSet (H1)  add a method storeCountryNames(String CountryName) , the method should add the passed country to a HashSet (H1) and return the added HashSet(H1).
2.Develop a method retrieveCountry(String CountryName) which iterates through the HashSet and returns the country if exist else return null.

*/
import java.util.*;
public class CountryEx
{
HashSet<String> country=new HashSet();
String storeCountryNames(String CountryName)
{
country.add(CountryName);
return CountryName;
}
String retrieveCountry(String CountryName)
{
Iterator it=country.iterator();
while(it.hasNext())
{
String name=(String)it.next();
if(CountryName.equals(name))
{
return name;
}
}
return null;
}
public static void main(String args[])
{
CountryEx obj=new CountryEx();
System.out.println(obj.storeCountryNames("INDIA"));
System.out.println(obj.storeCountryNames("America"));
System.out.println(obj.retrieveCountry("China"));
}
}