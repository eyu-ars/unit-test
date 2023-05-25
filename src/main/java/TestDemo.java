import java.util.Random;

public class TestDemo {

  /**
   * A method that adds two integer values. It throws IllegalArgumentException if parameters are not
   * positive.
   * 
   * @param a The first operand value
   * @param b The second operand value
   * @return integer
   */
  public int addPositive(int a, int b) {

    // Checking both parameters are positive
    if (a > 0 && b > 0) {
      return (a + b);

    } else {
      throw new IllegalArgumentException("Both parameters must be positive!");
    }
  }


  /**
   * A method finds random integer between 1 and 10. And calculates its square root.
   * 
   * @return integer
   */
  public int randomNumberSquared() {
    // Getting and assigning random number to a local variable randomNumber
    int randomNumber = getRandomInt();
    // Calculate & return the square root
    return (randomNumber * randomNumber);
  }


  /**
   * A method returns random integer between 1 and 10.
   * 
   * @return integer
   */
  int getRandomInt() {
    // Creating random object
    Random random = new Random();
    // returning random integer between 1 and 10
    return random.nextInt(10) + 1;
  }
}
