package epi.primitivetypes;

/**
 * Created by PV029500 on 1/8/2017.
 */

/**
 * Six friends have to select a designated driver using a single unbiased coin. The process should be fair to everyone.
 * Implement a random number generator that returns an int i between low and high such that i is returned with equal
 * probability. A randomTrueFalse method is given that returns 1 or 0 with equal probability
 * https://www.quora.com/How-do-you-decide-the-winner-among-3-people-with-an-equal-probability-by-tossing-a-fair-coin
 * To select one person out of three with the help of a coin:
 * Have each choose HH, HT, TH, or TT. (They cannot choose the same one.)
 * Then flip a coin twice and record the result. If the result that wasn't chosen happens,
 * flip the coin two more times. Repeat until you get a match.
    This hypothetically could take forever, but on average will take less than 3 flips of the coin.

 Also, consider below problem:
    Chance of picking one element out of four is 1/4
    There are four such 1/4's
    Suppose an element has been picked
    We have there elements
    Chance of picking up one out of the three is 1/3
    But the three is not fixed since the first person can pick up any out of four.
    So he leaves a 3/4 part or probability to pick the 1 from 3
    hence probability of second person is 1/3 * 3/4 (as there are 3 1/4s still left)
    Similarly for others.
    All of their probabilities remain 1/4
 */
public class GenerateUniformRandomNumbers {

    public static int generateUniformRandomNumbers(int low, int high) {
        int numOfOutcomes = high - low + 1;
        int result = 0;
        do {
            for (int i = 0; (1 << i) < numOfOutcomes; i++) {
                result = (result << 1) | 1; //use the random 0/1 generator here
            }
        } while (result >= numOfOutcomes);
        return result + low;
    }
    /**
     * Time complexity for the above problem:
     * The for loop takes O(log(high - low + 1) time
     * The probability of getting a head in k flips of a coin is  1 - 1/(2^k) (because 1/(2^k) is the chance of getting all tails)
     * let t = high - low + 1
     * t is the input size for a sample space of 2^i
     * probability that we succeed in first attempt is t/(2^i)
     * but 2^i is always less than 2t (else i would have been i + 1)
     * => t/(2^i) > t/2t and t/2t = 1/2
     * probability of succeeding in first attempt > 1/2
     * probability that more than k tries are needed is less than 1/(2^k)
     * Expected tries will not be more than 1 + 2(1/2) + 3(1/2^2) +... (binomial distribution)
     * the above series is converging and hence is constant time
     * Overall time remains log(high - low + 1)
     */
}
