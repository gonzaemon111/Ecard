public class Emperor {
  static int count = 0;
  static int emperor = 1;
  static int citizen = 4;

  public static void choose (int role_num) {

    if (role_num == 1) {
      citizen--;
    } else {
      emperor--;
    }
    count++; /*nannkai senntaku sitaka*/
  }



}
