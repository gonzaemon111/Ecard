public class Slave {
  static int count = 0;
  static int slave = 1;
  static int citizen = 4;

  public static void choose (int role_num){

    if (role_num == 1) {
      citizen--;
    } else {
      slave--;
    }
    count++; /*nannkai senntaku sitaka*/

  }


}
