/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Logic.Exercise;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Storage.Memory;

/**
 *
 * @author Lennard
 */
public class WLPTest {

    public WLPTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    
    @Test
    public void testMemory() {
        Memory.instance().ReadMapFromFile();
        Memory.instance().setWeight(Exercise.Pushjerk, 100);
        Memory.instance().WriteMapToFile();
        Memory.instance().ReadMapFromFile();
        assertEquals(Memory.instance().getWeight(Exercise.Pushjerk), 100);
    }
}
