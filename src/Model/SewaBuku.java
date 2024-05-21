public class SewaBuku {
    private String namaPenyewa;
    private String namaBuku;
    private String jenisBuku;
    private String nomorTelepon;
    private int durasiSewa;
    private double totalBiaya;

    public SewaBuku(String namaPenyewa, String namaBuku, String jenisBuku, String nomorTelepon, int durasiSewa) {
        this.namaPenyewa = namaPenyewa;
        this.namaBuku = namaBuku;
        this.jenisBuku = jenisBuku;
        this.nomorTelepon = nomorTelepon;
        this.durasiSewa = durasiSewa;
        this.totalBiaya = hitungTotalBiaya(durasiSewa);
    }

    private double hitungTotalBiaya(int durasiSewa) {
        if (durasiSewa <= 2) {
            return durasiSewa * 10000;
        } else {
            return (2 * 10000) + ((durasiSewa - 2) * 5000);
        }
    }

    // Getter dan Setter untuk setiap atribut
    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public void setNamaPenyewa(String namaPenyewa) {
        this.namaPenyewa = namaPenyewa;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public void setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
    }

    public String getJenisBuku() {
        return jenisBuku;
    }

    public void setJenisBuku(String jenisBuku) {
        this.jenisBuku = jenisBuku;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public int getDurasiSewa() {
        return durasiSewa;
    }

    public void setDurasiSewa(int durasiSewa) {
        this.durasiSewa = durasiSewa;
        this.totalBiaya = hitungTotalBiaya(durasiSewa);
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }
}
