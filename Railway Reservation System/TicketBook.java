import java.util.*;
class TicketBook
{
static int aLB = 2; //available lower berth
static int aMB = 1;
static int aUB = 1;
static int aRAC = 1;
static int aWL = 1;

static List<Integer> lBP = new ArrayList<Integer>(Arrays.asList(1, 2));
static List<Integer> mBP = new ArrayList<Integer>(Arrays.asList(1));
static List<Integer> uBP = new ArrayList<Integer>(Arrays.asList(1));
static List<Integer> racP = new ArrayList<Integer>(Arrays.asList(1));
static List<Integer> wlP = new ArrayList<Integer>(Arrays.asList(1));

static Queue<Integer> wlList = new LinkedList<Integer>();
static Queue<Integer> racList = new LinkedList<Integer>();
static List<Integer> bookedTicketList = new ArrayList<Integer>();
static Map<Integer, Passenger> passenger_stored_data = new HashMap<Integer, Passenger>();

public void bookTicket(Passenger p, int snumber, String allotedBerth)
{
p.number = snumber;
p.alloted = allotedBerth;
passenger_stored_data.put(p.passengerId, p);
bookedTicketList.add(p.passengerId);
System.out.println("Passenger ID:" + p.passengerId);
System.out.println("Passenger Name:" + p.name);
System.out.println("Passenger Age:" + p.age);
System.out.println("Passenger Gender:" + p.gender);
System.out.println("Alloted Berth:" + snumber+allotedBerth);
System.out.println("--------------------------Booked Successfully");
}
public void racTicket(Passenger p, int snumber, String RACBerth)
{
p.number = snumber;
p.alloted = RACBerth;
passenger_stored_data.put(p.passengerId, p);
racList.add(p.passengerId);
System.out.println("Passenger ID:" + p.passengerId);
System.out.println("Passenger Name:" + p.name);
System.out.println("Passenger Age:" + p.age);
System.out.println("Passenger Gender:" + p.gender);
System.out.println("Alloted Berth:" + snumber+RACBerth);
System.out.println("--------------------------RAC Berth Given");
}
public void wlTicket(Passenger p, int snumber, String WLBerth)
{
p.number = snumber;
p.alloted = WLBerth;
passenger_stored_data.put(p.passengerId, p);
wlList.add(p.passengerId);
System.out.println("Passenger ID:" + p.passengerId);
System.out.println("Passenger Name:" + p.name);
System.out.println("Passenger Age:" + p.age);
System.out.println("Passenger Gender:" + p.gender);
System.out.println("Alloted Berth:" + snumber+WLBerth);
System.out.println("--------------------------You're in Waiting List");
}
//==================================================================================
public void cancelTicket(int passengerId)
{

Passenger p = passenger_stored_data.get(passengerId);
passenger_stored_data.remove(passengerId);
bookedTicketList.remove(passengerId);
int psnumber = p.number;
System.out.println("-------------------Cancelled Successfully");
if(p.alloted.equals("L"))
{
lBP.add(psnumber);
aLB++;
}
else if(p.alloted.equals("M"))
{
mBP.add(psnumber);
aMB++;
}
else if(p.alloted.equals("U"))
{
uBP.add(psnumber);
aUB++;
}
if(racList.size() > 0)
{
Passenger passengerFromRAC=passenger_stored_data.get(racList.poll());
int pracsnumber=passengerFromRAC.number;
racP.add(pracsnumber);
racList.remove(passengerFromRAC.passengerId);
aRAC++;

if(wlList.size() > 0)
{
Passenger pfwl=passenger_stored_data.get(wlList.poll());
int pwlnumber=pfwl.number;
wlP.add(pwlnumber);
wlList.remove(pfwl.passengerId);
   
pfwl.number=racP.get(0);
pfwl.alloted="RAC";
racP.remove(0);
racList.add(pfwl.passengerId);
aWL++;
aRAC--;
}
Main.bookTicket(passengerFromRAC);
}
}


//=====================================================================
public void availableTickets()
{
System.out.println("The Lower Berths Ticket is:" + aLB);
System.out.println("The Middle Berths Ticket is:" + aMB);
System.out.println("The Upper Berths Ticket is:" + aUB);
System.out.println("The RAC Ticket is:" + aRAC);
System.out.println("The Waiting List Ticket is:" + aWL);
}



//===================================================================================
public void passengersDetail()
{
if(passenger_stored_data.size() == 0)
{
System.out.println("No Passengers Detail Found");
return;
}
else
{
for(Passenger p : passenger_stored_data.values())
{
System.out.println("Passenger Id:" + p.passengerId);
System.out.println("Passenger Name:" + p.name);
System.out.println("Passenger Age:" + p.age);
System.out.println("Passenger Gender:" + p.gender);
System.out.println("Passenger Child Name:" + p.cname);
System.out.println("passenger Child Age:" + p.cage);
System.out.println("Alloted Berth:" + p.number+p.alloted);

System.out.println("=========================================");
}
}
}




}