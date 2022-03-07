package sk.uniza.fri;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 28. 2. 2022 - 12:57
 *
 * @author Michal
 */
class StudentTest {

    private Student student;

    @BeforeEach
    void setUp() {
        this.student = new Student("12345", "Janko", "Hrasko");
    }

    @Test
    void inicializaciaStudenta() {
        assertEquals("12345", this.student.getOsobneCislo(), "Test getera na os cislo");
        assertEquals("Janko", this.student.getMeno());
        assertEquals("Hrasko", this.student.getPriezvisko());
        assertNull(this.student.getCisloSkupiny());
    }

    @Test
    void setCisloSkupiny() {
        this.student.setCisloSkupiny("ABCD");
        assertEquals("ABCD", this.student.getCisloSkupiny());
        this.student.setCisloSkupiny("");
        assertNull(this.student.getCisloSkupiny());
        this.student.setCisloSkupiny(null);
        assertNull(this.student.getCisloSkupiny());
    }

    @Test
    void toStringTest() {
        assertEquals("Student{cisloSkupiny='null', osobneCislo='12345', meno='Janko', priezvisko='Hrasko'}", this.student.toString());
    }
}