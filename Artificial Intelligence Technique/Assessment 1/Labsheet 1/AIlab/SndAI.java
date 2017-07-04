public class SndAI{

String sname;
String type;
int id;

public SndAI(String s,int i){
type=s;
id=i;

}

public void stName(String sn){

sname=sn;

System.out.println(" The Name is = " + sname);

}

public int result(){

id=id*2;
return id;

}

public int stID(){

return id;

}

}