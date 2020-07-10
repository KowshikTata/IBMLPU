/*
1.Develop a java class with a instance variable CountryMap  HashMap (M1)  add a method storeCountryCapital(String CountryName, String capital) , the method should add the passed country and capital as key/value in the map M1 and return the Map (M1).

2.Develop a method retrieveCapital(String CountryName) which returns the capital for the country passed from the Map M1 created in step 1.
3.Develop a method retrieveCountry(String capitalName) which returns the country for the capital name passed from the Map M1 created in step 1.
4.Develop a method which iterates through the map M1 and creates another map M2 with Capital as the key and value as Country and returns the Map M2.
1.Develop a method which iterates through the map M1 and creates a ArrayList with all the Country names stored as keys. This method should return the ArrayList.


*/
import java.util.*;
public class CountryMap
{
HashMap<String,String> country=new HashMap();
HashMap<String,String> map=new HashMap();
HashMap storeCountryCapital(String CountryName, String capital)
{
country.put(CountryName,capital);
return country;
}
String retrieveCountry(String Capital)
{

for ( Map.Entry<String, String> entry : country.entrySet()) {
    if (entry.getValue().equals(Capital)) {
            return entry.getKey();
        }
}

return null;
}
//5 method
ArrayList<String> al=new ArrayList();
ArrayList retrieveCountryList()
{

for ( Map.Entry<String, String> entry : country.entrySet()) {
    al.add(entry.getKey());
}

return al;
}


//4 method

HashMap storeReverse()
{
for ( Map.Entry<String, String> entry : country.entrySet()) {
    map.put(entry.getValue(),entry.getKey());
}
return map;
}


//
String retrieveCapital(String CountryName)
{
for ( Map.Entry<String, String> entry : country.entrySet()) {
    if (entry.getKey().equals(CountryName)) {
            return entry.getValue();
        }
}
return null;
}
public static void main(String args[])
{
CountryMap obj=new CountryMap();
System.out.println(obj.storeCountryCapital("INDIA","DELHI"));
System.out.println(obj.storeCountryCapital("China","Beijing"));
System.out.println(obj.retrieveCountry("Beijing"));
System.out.println(obj.retrieveCountry("America"));
System.out.println(obj.retrieveCapital("INDIA"));
System.out.println(obj.retrieveCountryList());
System.out.println(obj.storeReverse());
}
}