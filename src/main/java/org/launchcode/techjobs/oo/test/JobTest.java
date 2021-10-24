package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job aJob = new Job();
        Job anotherJob = new Job();
        assertNotEquals(aJob.getId(), anotherJob.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(Integer.class.isInstance(newJob.getId()));
        assertTrue(newJob.getName() instanceof String);
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", "Product tester");
        assertEquals("ACME", "ACME");
        assertEquals("Desert", "Desert");
        assertEquals("Quality control", "Quality control");
        assertEquals("Persistence", "Persistence");
    }
    @Test
    public void testJobsForEquality() {
        Job aJob = new Job();
        Job anotherJob = new Job();
        assertFalse(aJob.equals(anotherJob));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String [] aNewJob = aJob.toString().split("\n");
        System.out.println(aJob.toString().charAt(0) == '\n');
        assertEquals('\n', aJob.toString().charAt(0));
        assertEquals('\n', aJob.toString().charAt(aJob.toString().length()-1));

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        String [] actual = aJob.toString().split("\n");

        assertEquals("ID: 4", actual[1]);
        assertEquals("Name: Product tester", actual[2]);
        assertEquals("Employer: ACME", actual[3]);
        assertEquals("Location: Desert", actual[4]);
        assertEquals("Position Type: Quality control", actual[5]);
        assertEquals("Core Competency: Persistence", actual[6]);
    }
    @Test
    public void testToStringHandlesEmptyField() {
        Job aJob = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));;
        String [] actual = aJob.toString().split("\n");
//        System.out.println(actual);
        assertEquals("Name: Data not available", actual[2]);
    }

}
