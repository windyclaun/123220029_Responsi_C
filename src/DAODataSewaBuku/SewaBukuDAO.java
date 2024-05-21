import java.sql.*;
import java.util.*;

import koneksi.Connector;

public class SewaBukuDAO implements SewaBukuImplement {
    Connection con;
    final String select = "SELECT * FROM sewa_buku";

    public SewaBukuDAO() {
        con = Connector.connection();
    }

    @Override
    public void insert(SewaBuku sb) {
        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO `sewa_buku`(`nama_penyewa`, `nama_buku`, `jenis_buku`, `nomor_telepon`, `durasi_sewa`, `total_biaya`) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, sb.getNamaPenyewa());
            ps.setString(2, sb.getNamaBuku());
            ps.setString(3, sb.getJenisBuku());
            ps.setString(4, sb.getNomorTelepon());
            ps.setInt(5, sb.getDurasiSewa());
            ps.setDouble(6, sb.getTotalBiaya());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(SewaBuku sb) {
        PreparedStatement ps = null;
        try {
            String query = "UPDATE `sewa_buku` SET `durasi_sewa` = ?, `total_biaya` = ? WHERE `nomor_telepon` = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, sb.getDurasiSewa());
            ps.setDouble(2, sb.getTotalBiaya());
            ps.setString(3, sb.getNomorTelepon());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(SewaBuku sb) {
        PreparedStatement ps = null;
        try {
            String query = "DELETE FROM `sewa_buku` WHERE `nomor_telepon` = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, sb.getNomorTelepon());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<SewaBuku> getAll() {
        List<SewaBuku> list = null;
        try {
            list = new ArrayList<>();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                SewaBuku sb = new SewaBuku(
                    rs.getString("nama_penyewa"),
                    rs.getString("nama_buku"),
                    rs.getString("jenis_buku"),
                    rs.getString("nomor_telepon"),
                    rs.getInt("durasi_sewa")
                );
                list.add(sb);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }
}
