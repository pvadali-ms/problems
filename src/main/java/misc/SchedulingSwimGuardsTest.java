package misc;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SchedulingSwimGuardsTest {

    @Test
    public void testSwimGuard() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        String fileName = ".in";
//        for (int i = 8; i < 9; i++)
        calculate(classLoader, String.valueOf(5) + fileName);

    }

    private void calculate(ClassLoader classLoader, String fileName) throws IOException {
        List<SchedulingSwimGuards.SwimInterval> input = new ArrayList<>();
        File file = new File(classLoader.getResource(fileName).getFile());
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while ((st = br.readLine()) != null) {
            String[] intervalString = st.split("\\s");
            if (intervalString.length == 2)
                input.add(new SchedulingSwimGuards.SwimInterval(Integer.parseInt(intervalString[0]), Integer.parseInt(intervalString[1])));
        }
        SchedulingSwimGuards schedulingSwimGuards = new SchedulingSwimGuards();
        System.out.println(fileName);
        List<SchedulingSwimGuards.SwimInterval> duplicateInput = new ArrayList<>(input);
//        long nLogNtimeBegin = System.currentTimeMillis();
        System.out.println(schedulingSwimGuards.getTotalShift(input));
//        System.out.println((System.currentTimeMillis() - nLogNtimeBegin) / 1000);
//        long nSquareBegin = System.currentTimeMillis();
//        System.out.println(schedulingSwimGuards.getTotalShiftLongMethod(duplicateInput));
//        System.out.println((System.currentTimeMillis() - nSquareBegin) / 1000);
    }
}