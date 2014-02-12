/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Symbols.VN;
import Symbols.VT;
import java.io.File;
import java.util.Collection;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian
 */
public class AnalizadorAscendenteLRTest {
    
    public AnalizadorAscendenteLRTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    private static final String desktop = "C:" + File.separator + "Users"
            + File.separator + System.getProperty("user.name") + File.separator + "Dropbox" + File.separator + "PL Practica" + File.separator + "Java (PRACTICA)" + File.separator;

    private static String devCadena(Collection<VT> c) {
        String aux = "";
        for (VT v : c) {
            aux += v.toString();
        }
        return aux;
    }

    private static Collection<VT> devColeccion(String... cadena) {
        Collection<VT> col = new LinkedList<VT>();
        for (String s : cadena) {
            col.add(new VT(s));
        }
        return col;
    }
    
    Gramatica g = new Gramatica(desktop + "Gramatica_PR8.txt");

    /**
     * Test of analizar method, of class AnalizadorAscendenteLR.
     */
    @Test
    public void testAnalizar1() {
        System.out.println("analizar");
        Collection<VT> c = devColeccion("id","+","id","*","(","id","+","id",")","$");
        AnalizadorAscendenteLR instance = new AnalizadorAscendenteLR(g);
        boolean expResult = true;
        boolean result = instance.analizar(c);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of analizar method, of class AnalizadorAscendenteLR.
     */
    @Test
    public void testAnalizar2() {
        System.out.println("analizar");
        Collection<VT> c = devColeccion("id","+","id","*","(","id","+","id",")");
        AnalizadorAscendenteLR instance = new AnalizadorAscendenteLR(g);
        boolean expResult = false;
        boolean result = instance.analizar(c);
        assertEquals(expResult, result);
    }
    
}
