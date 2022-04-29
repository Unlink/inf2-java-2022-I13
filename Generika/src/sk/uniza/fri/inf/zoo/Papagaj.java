package sk.uniza.fri.inf.zoo;

/**
 * 29. 4. 2022 - 10:26
 *
 * @author Michal
 */
public class Papagaj implements IZviera {
    private String naucenaFraza = "Som papagaj";


    public void naucFrazu(String fraza) {
        this.naucenaFraza = fraza;
    }

    @Override
    public void hovor() {
        System.out.println(this.naucenaFraza);
    }
}
