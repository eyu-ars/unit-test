import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

class TestDemoTest {

  private TestDemo testDemo;
  
  @BeforeEach
  void setUp() {
    // New TestDemo object is created before each test 
    testDemo = new TestDemo();
  }

  
  /**
   * This parameterized test is for the method {@link TestDemo#addPositive(int, int)}. It shows that 
   * the addPositive method correctly handles legal and illegal values.
   * @param a The first operand value for addition
   * @param b The second operand value for addition
   * @param expected The expected result
   * @param expectException If not false, the test expects an exception to be thrown.
   */
  @ParameterizedTest
  @MethodSource("TestDemoTest#argumentsForAddPositive")
  void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, Boolean expectException) {
    // Checking the exception parameter
    if(!expectException) {
      assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
    }else {
      assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(
          IllegalArgumentException.class);
    }
  }

  
  /**
   * This test method verifies that randomNumberSquared(), calculate square root of random number, method works as expected.
   */
  @Test
  void assertThatNumberSquaredIsCorrect() {
    // Given:  
    TestDemo mockDemo = spy(testDemo);
    doReturn(5).when(mockDemo).getRandomInt();
    
    // When: 5 is squared
    int fiveSquared = mockDemo.randomNumberSquared();
    
    // Then: square root of 5 is 25
    assertThat(fiveSquared).isEqualTo(25);
    
  }
  
  
  /**
   * These arguments are for {@link #assertThatTwoPositiveNumbersAreAddedCorrectly(int, int, int, Boolean)}
   * @return A Stream of test arguments
   */
  private static Stream<Arguments> argumentsForAddPositive(){
    return Stream.of(
        arguments(2, 4, 6, false),
        arguments(0, 4, 0, true),
        arguments(2, 0, 0, true),
        arguments(-1, 4, 0, true),
        arguments(2, -1, 0, true),
        arguments(100, 5, 105, false)
        );
  }
}
