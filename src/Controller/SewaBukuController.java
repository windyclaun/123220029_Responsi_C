package Controller;
import java.util.List;

public class SewaBukuController {
    MainView frame;
    SewaBukuDAO implement;
    List<SewaBuku> list;

    public SewaBukuController(MainView frame) {
        this.frame = frame;
        implement = new SewaBukuDAO();
        list = implement.getAll();
    }

    public void isiTabel() {
        list = implement.getAll();
        ModelTabelSewaBuku mtm = new ModelTabelSewaBuku(list);
        frame.getTabelData().setModel(mtm);
    }

    public void insert(String namaPenyewa, String judulBuku, String jenisBuku, String nomorTelepon, int durasiSewa) {
        SewaBuku sb = new SewaBuku(namaPenyewa, judulBuku, jenisBuku, nomorTelepon, durasiSewa);
        sb.setnamaPenyewa(namaPenyewa);
        sb.setjudulBuku(judulBuku);
        sb.setjenisBuku(jenisBuku);
        sb.setnomorTelepon(nomorTelepon);
        sb.setdurasiSewa(durasiSewa);
        implement.insert(sb);
    }

    public void update(String nomorTelepon, int durasiSewa) {
        for (SewaBuku sb : list) {
            if (sb.getNomorTelepon().equals(nomorTelepon)) {
                sb.setDurasiSewa(durasiSewa);
                implement.update(sb);
                isiTabel();
                break;
            }
        }
    }

    public void delete(String nomorTelepon) {
        for (SewaBuku sb : list) {
            if (sb.getNomorTelepon().equals(nomorTelepon)) {
                implement.delete(sb);
                isiTabel();
                break;
            }
        }
    }
}
