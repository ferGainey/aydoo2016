package ar.edu.untref.aydoo;

import org.junit.Test;
import java.util.ArrayList;
import org.junit.Assert;



public class ProgramTest 
{
	
    @Test
    public void esPrimoUno()
    {
        Program program = new Program();
        Boolean result = program.esPrimo(1);
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void esPrimoDos()
    {
        Program program = new Program();
        Boolean result = program.esPrimo(2);
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void esPrimoTres()
    {
        Program program = new Program();
        Boolean result = program.esPrimo(3);
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void esPrimoCuatro()
    {
        Program program = new Program();
        Boolean result = program.esPrimo(4);
        Assert.assertEquals(false, result);
    }
    
    @Test
    public void esPrimoCinco()
    {
        Program program = new Program();
        Boolean result = program.esPrimo(5);
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void esPrimoQuince()
    {
        Program program = new Program();
        Boolean result = program.esPrimo(15);
        Assert.assertEquals(false, result);
    }
    
    @Test
    public void esPrimoDiecisiete()
    {
        Program program = new Program();
        Boolean result = program.esPrimo(17);
        Assert.assertEquals(true, result);
    }
    
    @Test
    public void esPrimoMil()
    {
        Program program = new Program();
        Boolean result = program.esPrimo(1000);
        Assert.assertEquals(false, result);
    }
    
    @Test
    public void descomposicionSimple()
    {
        Program program = new Program();
        ArrayList<Integer> esperado = new ArrayList<Integer>();
        esperado.add(0,3);
        program.resolver(3);
        ArrayList<Integer> result = program.listaDivisoresPrimos;
        Assert.assertEquals(esperado, result);
    }
    
    @Test
    public void descomposicionDelNueve()
    {
        Program program = new Program();
        ArrayList<Integer> esperado = new ArrayList<Integer>();
        esperado.add(0,3);
        esperado.add(1,3);
        program.resolver(9);
        ArrayList<Integer> result = program.listaDivisoresPrimos;
        Assert.assertEquals(esperado, result);
    }
    
    @Test
    public void descomposicionDelQuince()
    {
        Program program = new Program();
        ArrayList<Integer> esperado = new ArrayList<Integer>();
        esperado.add(0,3);
        esperado.add(1,5);
        program.resolver(15);
        ArrayList<Integer> result = program.listaDivisoresPrimos;
        Assert.assertEquals(esperado, result);
    }
    
    @Test
    public void descomposicionDelCien()
    {
        Program program = new Program();
        ArrayList<Integer> esperado = new ArrayList<Integer>();
        esperado.add(0,2);
        esperado.add(1,2);
        esperado.add(2,5);
        esperado.add(3,5);
        program.resolver(100);
        ArrayList<Integer> result = program.listaDivisoresPrimos;
        Assert.assertEquals(esperado, result);
    }
    
    @Test
    public void descomposicionDelMilSetecientosNueve()
    {
        Program program = new Program();
        ArrayList<Integer> esperado = new ArrayList<Integer>();
        esperado.add(0,1709);
        program.resolver(1709);
        ArrayList<Integer> result = program.listaDivisoresPrimos;
        Assert.assertEquals(esperado, result);
    }
}
