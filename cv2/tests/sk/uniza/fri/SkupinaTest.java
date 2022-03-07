package sk.uniza.fri;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 28. 2. 2022 - 12:57
 *
 * @author Michal
 */
class SkupinaTest {

    @Test
    void vytvorenieAInicializacia() {
        Skupina skupina = new Skupina("123");
        assertEquals("123", skupina.getCislo());
        Skupina skupina2 = new Skupina("50");
        assertEquals("50", skupina2.getCislo());
        assertEquals(0, skupina.dajPocetStudentov());
    }

    @Test
    void pridajStudenta() {
        Student student = new Student("12345", "Janko", "Hrasko");
        Skupina skupina = new Skupina("123");
        skupina.pridajStudenta(student);
        assertEquals(1, skupina.dajPocetStudentov());
        Student studentZoSkupiny = skupina.dajStudenta("12345");
        assertEquals(student, studentZoSkupiny);
    }

    @Test
    void pridajStudentaNull() {
        Skupina skupina = new Skupina("123");
        skupina.pridajStudenta(null);
        assertEquals(0, skupina.dajPocetStudentov());
    }

    @Test
    void pridajStudentaDuplicitne() {
        Student student = new Student("12345", "Janko", "Hrasko");
        Skupina skupina = new Skupina("123");
        skupina.pridajStudenta(student);
        assertEquals(1, skupina.dajPocetStudentov());
        skupina.pridajStudenta(student);
        assertEquals(1, skupina.dajPocetStudentov());

        Student student2 = new Student("12345", "Janko", "Hrasko");
        skupina.pridajStudenta(student2);
        assertEquals(1, skupina.dajPocetStudentov());
    }

    @Test
    void odoberStudenta() {
    }
}