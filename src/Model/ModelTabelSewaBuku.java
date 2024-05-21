import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelSewaBuku extends AbstractTableModel {
    private List<SewaBuku> list;

    public ModelTabelSewaBuku(List<SewaBuku> list) {
        if (list == null) {
            this.list = new ArrayList<>();
        } else {
            this.list = list;
        }
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama Penyewa";
            case 1:
                return "Nama Buku";
            case 2:
                return "Jenis Buku";
            case 3:
                return "Nomor Telepon";
            case 4:
                return "Durasi Sewa (hari)";
            case 5:
                return "Total Biaya";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return list.get(row).getNamaPenyewa();
            case 1:
                return list.get(row).getNamaBuku();
            case 2:
                return list.get(row).getJenisBuku();
            case 3:
                return list.get(row).getNomorTelepon();
            case 4:
                return list.get(row).getDurasiSewa();
            case 5:
                return list.get(row).getTotalBiaya();
            default:
                return null;
        }
    }
}
