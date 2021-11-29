public class Passenger
{
static int id=1;
String name; //Declaration
int age;
String gender;
String cname;
int cage;
String bp;
int passengerId=id++;
String alloted;
int number;

public Passenger(String name, int age, String gender, String cname, int cage, String bp)
{
this.name=name;
this.age=age;
this.gender=gender;
this.cname=cname;
this.cage=cage;
this.bp=bp;
alloted=" ";
number=-1;
}
}