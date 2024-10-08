/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgJnsPerawatanRalan.java
 *
 * Created on May 22, 2010, 11:58:21 PM
 */

package bridging;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

/**
 *
 * @author dosen
 */
public final class MobileJKNReferensiPendaftaran extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private Connection koneksi=koneksiDB.condb();
    private PreparedStatement ps;
    private ResultSet rs;    
    private int i=0;
    private HttpHeaders headers;
    private String URL="",link="",utc="";
    private  String requestJson,datajam="";
    private HttpEntity requestEntity;
    private ApiMobileJKN api=new ApiMobileJKN();
    private JsonNode root;
    private JsonNode nameNode;
    private JsonNode response;
    private ObjectMapper mapper = new ObjectMapper();
     

    /** Creates new form DlgJnsPerawatanRalan
     * @param parent
     * @param modal */
    public MobileJKNReferensiPendaftaran(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocation(8,1);
        setSize(628,674);

        tabMode=new DefaultTableModel(null,new Object[]{
                "No.Rawat","No.RM","Nama Pasien","No.HP","No.Kartu","NIK","Tanggal","Poliklinik","Dokter","Jam Praktek","Jenis Kunjungan","Nomor Referensi","Status","Validasi Checkin","No.Booking"
            }){
             @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbJnsPerawatan.setModel(tabMode);

        tbJnsPerawatan.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbJnsPerawatan.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 15; i++) {
            TableColumn column = tbJnsPerawatan.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(110);
            }else if(i==1){
                column.setPreferredWidth(70);
            }else if(i==2){
                column.setPreferredWidth(160);
            }else if(i==3){
                column.setPreferredWidth(83);
            }else if(i==4){
                column.setPreferredWidth(90);
            }else if(i==5){
                column.setPreferredWidth(103);
            }else if(i==6){
                column.setPreferredWidth(65);
            }else if(i==7){
                column.setPreferredWidth(140);
            }else if(i==8){
                column.setPreferredWidth(160);
            }else if(i==9){
                column.setPreferredWidth(70);
            }else if(i==10){
                column.setPreferredWidth(110);
            }else if(i==11){
                column.setPreferredWidth(125);
            }else if(i==12){
                column.setPreferredWidth(50);
            }else if(i==13){
                column.setPreferredWidth(115);
            }else if(i==14){
                column.setPreferredWidth(110);
            }
        }
        tbJnsPerawatan.setDefaultRenderer(Object.class, new WarnaTable());

        TCari.setDocument(new batasInput((byte)100).getKata(TCari));
        
        if(koneksiDB.CARICEPAT().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
            });
        }  
        try {
            link=koneksiDB.URLAPIMOBILEJKN();
        } catch (Exception e) {
            System.out.println("E : "+e);
        }
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        MnKirimManualAntrol = new javax.swing.JMenuItem();
        WindowGantiDokterParamedis = new javax.swing.JDialog();
        internalFrame5 = new widget.InternalFrame();
        FormInput = new widget.panelisi();
        BtnSimpan4 = new widget.Button();
        BtnCloseIn4 = new widget.Button();
        jLabel17 = new widget.Label();
        NoRawatKirim = new widget.TextBox();
        jLabel27 = new widget.Label();
        KeteranganBatal = new widget.TextBox();
        jLabel18 = new widget.Label();
        NoHp = new widget.TextBox();
        jLabel20 = new widget.Label();
        NamaPasien = new widget.TextBox();
        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbJnsPerawatan = new widget.Table();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        jLabel7 = new widget.Label();
        LCount = new widget.Label();
        BtnCheckin = new widget.Button();
        BtnBelum = new widget.Button();
        BtnBatal = new widget.Button();
        BtnPrint = new widget.Button();
        BtnKeluar = new widget.Button();
        panelGlass10 = new widget.panelisi();
        jLabel19 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel21 = new widget.Label();
        DTPCari2 = new widget.Tanggal();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        BtnAll = new widget.Button();

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        MnKirimManualAntrol.setBackground(new java.awt.Color(255, 255, 254));
        MnKirimManualAntrol.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnKirimManualAntrol.setForeground(new java.awt.Color(50, 50, 50));
        MnKirimManualAntrol.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnKirimManualAntrol.setText("Kirim Pasien Batal");
        MnKirimManualAntrol.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MnKirimManualAntrol.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MnKirimManualAntrol.setName("MnKirimManualAntrol"); // NOI18N
        MnKirimManualAntrol.setPreferredSize(new java.awt.Dimension(160, 26));
        MnKirimManualAntrol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnKirimManualAntrolActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnKirimManualAntrol);

        WindowGantiDokterParamedis.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        WindowGantiDokterParamedis.setName("WindowGantiDokterParamedis"); // NOI18N
        WindowGantiDokterParamedis.setUndecorated(true);
        WindowGantiDokterParamedis.setResizable(false);

        internalFrame5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(239, 244, 234)), "::[ Kirim Pasien Batal Mobile JKN ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame5.setName("internalFrame5"); // NOI18N
        internalFrame5.setPreferredSize(new java.awt.Dimension(300, 455));
        internalFrame5.setLayout(new java.awt.BorderLayout(1, 1));

        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(200, 434));
        FormInput.setLayout(null);

        BtnSimpan4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpan4.setMnemonic('S');
        BtnSimpan4.setText("Kirim");
        BtnSimpan4.setToolTipText("Alt+S");
        BtnSimpan4.setName("BtnSimpan4"); // NOI18N
        BtnSimpan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpan4ActionPerformed(evt);
            }
        });
        FormInput.add(BtnSimpan4);
        BtnSimpan4.setBounds(280, 20, 100, 30);

        BtnCloseIn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cross.png"))); // NOI18N
        BtnCloseIn4.setMnemonic('U');
        BtnCloseIn4.setText("Tutup");
        BtnCloseIn4.setToolTipText("Alt+U");
        BtnCloseIn4.setName("BtnCloseIn4"); // NOI18N
        BtnCloseIn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCloseIn4ActionPerformed(evt);
            }
        });
        FormInput.add(BtnCloseIn4);
        BtnCloseIn4.setBounds(280, 50, 100, 30);

        jLabel17.setText("No.Hp :");
        jLabel17.setName("jLabel17"); // NOI18N
        FormInput.add(jLabel17);
        jLabel17.setBounds(40, 50, 70, 23);

        NoRawatKirim.setEditable(false);
        NoRawatKirim.setName("NoRawatKirim"); // NOI18N
        NoRawatKirim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoRawatKirimActionPerformed(evt);
            }
        });
        NoRawatKirim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoRawatKirimKeyPressed(evt);
            }
        });
        FormInput.add(NoRawatKirim);
        NoRawatKirim.setBounds(120, 80, 150, 23);

        jLabel27.setText("No. Rawat/ Booking :");
        jLabel27.setName("jLabel27"); // NOI18N
        FormInput.add(jLabel27);
        jLabel27.setBounds(0, 80, 110, 23);

        KeteranganBatal.setName("KeteranganBatal"); // NOI18N
        KeteranganBatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                KeteranganBatalKeyPressed(evt);
            }
        });
        FormInput.add(KeteranganBatal);
        KeteranganBatal.setBounds(120, 110, 150, 23);

        jLabel18.setText("Keterangan :");
        jLabel18.setName("jLabel18"); // NOI18N
        FormInput.add(jLabel18);
        jLabel18.setBounds(20, 110, 90, 23);

        NoHp.setEditable(false);
        NoHp.setName("NoHp"); // NOI18N
        NoHp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoHpActionPerformed(evt);
            }
        });
        NoHp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoHpKeyPressed(evt);
            }
        });
        FormInput.add(NoHp);
        NoHp.setBounds(120, 50, 150, 23);

        jLabel20.setText("Nama Pasien :");
        jLabel20.setName("jLabel20"); // NOI18N
        FormInput.add(jLabel20);
        jLabel20.setBounds(40, 20, 70, 23);

        NamaPasien.setEditable(false);
        NamaPasien.setName("NamaPasien"); // NOI18N
        NamaPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaPasienActionPerformed(evt);
            }
        });
        NamaPasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NamaPasienKeyPressed(evt);
            }
        });
        FormInput.add(NamaPasien);
        NamaPasien.setBounds(120, 20, 150, 23);

        internalFrame5.add(FormInput, java.awt.BorderLayout.CENTER);

        WindowGantiDokterParamedis.getContentPane().add(internalFrame5, java.awt.BorderLayout.CENTER);
        internalFrame5.getAccessibleContext().setAccessibleName("::[ Kirim Pasien Batal Mobile JKN ]::");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Referensi Pendaftaran Mobile JKN ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbJnsPerawatan.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbJnsPerawatan.setComponentPopupMenu(jPopupMenu1);
        tbJnsPerawatan.setName("tbJnsPerawatan"); // NOI18N
        Scroll.setViewportView(tbJnsPerawatan);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(44, 100));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel7.setText("Record :");
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(52, 23));
        panelGlass8.add(jLabel7);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass8.add(LCount);

        BtnCheckin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnCheckin.setMnemonic('S');
        BtnCheckin.setText("Checkin");
        BtnCheckin.setToolTipText("Alt+S");
        BtnCheckin.setName("BtnCheckin"); // NOI18N
        BtnCheckin.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnCheckin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCheckinActionPerformed(evt);
            }
        });
        BtnCheckin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCheckinKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnCheckin);

        BtnBelum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); // NOI18N
        BtnBelum.setMnemonic('B');
        BtnBelum.setText("Belum");
        BtnBelum.setToolTipText("Alt+B");
        BtnBelum.setName("BtnBelum"); // NOI18N
        BtnBelum.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBelum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBelumActionPerformed(evt);
            }
        });
        BtnBelum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBelumKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnBelum);

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnBatal.setMnemonic('H');
        BtnBatal.setText("Batal");
        BtnBatal.setToolTipText("Alt+H");
        BtnBatal.setName("BtnBatal"); // NOI18N
        BtnBatal.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });
        BtnBatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBatalKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnBatal);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnPrint);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnKeluar);

        jPanel3.add(panelGlass8, java.awt.BorderLayout.CENTER);

        panelGlass10.setName("panelGlass10"); // NOI18N
        panelGlass10.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass10.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel19.setText("Tanggal :");
        jLabel19.setName("jLabel19"); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(55, 23));
        panelGlass10.add(jLabel19);

        DTPCari1.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "02-10-2024" }));
        DTPCari1.setDisplayFormat("dd-MM-yyyy");
        DTPCari1.setName("DTPCari1"); // NOI18N
        DTPCari1.setOpaque(false);
        DTPCari1.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass10.add(DTPCari1);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("s.d.");
        jLabel21.setName("jLabel21"); // NOI18N
        jLabel21.setPreferredSize(new java.awt.Dimension(23, 23));
        panelGlass10.add(jLabel21);

        DTPCari2.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "02-10-2024" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy");
        DTPCari2.setName("DTPCari2"); // NOI18N
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass10.add(DTPCari2);

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(75, 23));
        panelGlass10.add(jLabel6);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(205, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass10.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setToolTipText("Alt+2");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelGlass10.add(BtnCari);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelGlass10.add(BtnAll);

        jPanel3.add(panelGlass10, java.awt.BorderLayout.PAGE_START);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }else{Valid.pindah(evt,BtnCari,TCari);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            //TCari.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            Sequel.queryu("delete from temporary where temp37='"+akses.getalamatip()+"'");
            int row=tabMode.getRowCount();
            for(int r=0;r<row;r++){  
                Sequel.menyimpan("temporary","'"+r+"','"+
                                tabMode.getValueAt(r,0).toString().replaceAll("'","") +"','"+
                                tabMode.getValueAt(r,1).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,2).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,3).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,4).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,5).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,6).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,7).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,8).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,9).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,10).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,11).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,12).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,13).toString().replaceAll("'","")+"','"+
                                tabMode.getValueAt(r,14).toString().replaceAll("'","")+"','','','','','','','','','','','','','','','','','','','','','','"+akses.getalamatip()+"'","Rekap Harian BulananDokter"); 
            }
            
            Map<String, Object> param = new HashMap<>();
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());   
            param.put("logo",Sequel.cariGambar("select setting.logo from setting")); 
            Valid.MyReportqry("rptReferensiPendaftaranMobileJKN.jasper","report","::[ Data Referensi Pendaftaran Mobile JKN ]::","select * from temporary where temporary.temp37='"+akses.getalamatip()+"' order by temporary.no",param);
        }
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnCari, BtnKeluar);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
}//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
}//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil();
}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            tampil();
            TCari.setText("");
        }else{
            Valid.pindah(evt, BtnPrint, BtnKeluar);
        }
}//GEN-LAST:event_BtnAllKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        if(tbJnsPerawatan.getSelectedRow()!= -1){
            if(Sequel.mengedittf("referensi_mobilejkn_bpjs","nobooking=?","status='Batal',validasi=now()",1,new String[]{
                tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),14).toString()
            })==true){
                Sequel.menyimpan2("referensi_mobilejkn_bpjs_batal","?,?,?,now(),?,?,?",6,new String[]{
                    tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),1).toString(),tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),0).toString(), 
                    tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),11).toString(),"Dibatalkan Oleh Admin","Belum",tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),14).toString()
                });
                tampil();
            }
        }else{
            JOptionPane.showMessageDialog(null,"Silahkan pilih dulu data yang mau dibatalkan..!!");
        }
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnBatalActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnCheckin, BtnPrint);
        }
    }//GEN-LAST:event_BtnBatalKeyPressed

    private void BtnCheckinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCheckinActionPerformed
        if(Sequel.mengedittf("referensi_mobilejkn_bpjs","nobooking=?","status='Checkin',validasi=now()",1,new String[]{
            tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),14).toString()
        })==true){
            Sequel.meghapus("referensi_mobilejkn_bpjs_batal","nobooking",tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),14).toString());
            tampil();
        }
    }//GEN-LAST:event_BtnCheckinActionPerformed

    private void BtnCheckinKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCheckinKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCheckinActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnCari, BtnBatal);
        }
    }//GEN-LAST:event_BtnCheckinKeyPressed

    private void BtnBelumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBelumActionPerformed
        if(Sequel.mengedittf("referensi_mobilejkn_bpjs","nobooking=?","status='Belum',validasi='0000-00-00 00:00:00'",1,new String[]{
            tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),14).toString()
        })==true){
            Sequel.meghapus("referensi_mobilejkn_bpjs_batal","nobooking",tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),14).toString());
            tampil();
        }
    }//GEN-LAST:event_BtnBelumActionPerformed

    private void BtnBelumKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBelumKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnBelumActionPerformed(null);
        }else{Valid.pindah(evt, BtnCheckin, BtnBatal);}
    }//GEN-LAST:event_BtnBelumKeyPressed

    private void MnKirimManualAntrolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnKirimManualAntrolActionPerformed
        // TODO add your handling code here:
        NoRawatKirim.setText(tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),14).toString());
        NamaPasien.setText(tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),2).toString());
        NoHp.setText(tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),3).toString());
        WindowGantiDokterParamedis.setSize(400,180);
        WindowGantiDokterParamedis.setLocationRelativeTo(internalFrame1);
        WindowGantiDokterParamedis.setVisible(true);
    }//GEN-LAST:event_MnKirimManualAntrolActionPerformed

    private void NoRawatKirimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoRawatKirimKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoRawatKirimKeyPressed

    private void BtnCloseIn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCloseIn4ActionPerformed
        WindowGantiDokterParamedis.dispose();
    }//GEN-LAST:event_BtnCloseIn4ActionPerformed

    private void BtnSimpan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpan4ActionPerformed
        try {
            headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.add("x-cons-id", koneksiDB.CONSIDAPIMOBILEJKN());
            utc = String.valueOf(api.GetUTCdatetimeAsString());
            headers.add("x-timestamp", utc);
            headers.add("x-signature", api.getHmac(utc));
            headers.add("user_key", koneksiDB.USERKEYAPIMOBILEJKN());
            requestJson = "{"
                    + "\"kodebooking\": \""+NoRawatKirim.getText()+"\","
                    + "\"keterangan\": \""+KeteranganBatal.getText()+"\""
                    + "}";
//            TeksArea.append("JSON : " + requestJson + "\n");
            requestEntity = new HttpEntity(requestJson, headers);
            URL = link + "/antrean/batal";
            System.out.println("URL : " + URL);
            //System.out.println(api.getRest().exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody());
            root = mapper.readTree(api.getRest().exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody());
            nameNode = root.path("metadata");
            System.out.println(" code : " + nameNode.path("code").asText());
            System.out.println(" pesan : " + nameNode.path("message").asText());
            JOptionPane.showMessageDialog(null,nameNode.path("message").asText());
            if (nameNode.path("code").asText().equals("200")) {
                Sequel.queryu2("update referensi_mobilejkn_bpjs_batal set statuskirim='Sudah' where nomorreferensi='" + tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),11).toString() + "'");
                datajam = tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),13).toString();
                if (!datajam.equals("")) {
                    if (Sequel.menyimpantf2("referensi_mobilejkn_bpjs_taskid", "?,?,?", "task id", 3, new String[]{tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),0).toString(), "99", datajam}) == true) {
//                        parsedDate = dateFormat.parse(datajam);
                    String dateTimeString = datajam;
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                    LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
                    Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
                    long timestamp99 = instant.toEpochMilli();
                        try {
//                            TeksArea.append("Menjalankan WS taskid batal pelayanan poli Mobile JKN Pasien BPJS\n");
                            headers = new HttpHeaders();
                            headers.setContentType(MediaType.APPLICATION_JSON);
                            headers.add("x-cons-id", koneksiDB.CONSIDAPIMOBILEJKN());
                            utc = String.valueOf(api.GetUTCdatetimeAsString());
                            headers.add("x-timestamp", utc);
                            headers.add("x-signature", api.getHmac(utc));
                            headers.add("user_key", koneksiDB.USERKEYAPIMOBILEJKN());
                            requestJson = "{"
                                    + "\"kodebooking\": \"" + NoRawatKirim.getText() + "\","
                                    + "\"taskid\": \"99\","
                                    + "\"waktu\": \""+timestamp99+"\""
                                    + "}";
//                            TeksArea.append("JSON : " + requestJson + "\n");
                            requestEntity = new HttpEntity(requestJson, headers);
                            URL = link + "/antrean/updatewaktu";
                            System.out.println("URL : " + URL);
                            //System.out.println(api.getRest().exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody());
                            System.out.println("JSON : "+requestJson);
                            requestEntity = new HttpEntity(requestJson,headers);
                            root = mapper.readTree(api.getRest().exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody());
                            nameNode = root.path("metaData");
                            System.out.println(" code : " + nameNode.path("code").asText());
                            System.out.println(" pesan : " + nameNode.path("message").asText());
                            if (!nameNode.path("code").asText().equals("200")) {
                                Sequel.queryu2("delete from referensi_mobilejkn_bpjs_taskid where taskid='99' and no_rawat='" + tbJnsPerawatan.getValueAt(tbJnsPerawatan.getSelectedRow(),0).toString() + "'");
                            }else {
                                JOptionPane.showMessageDialog(null,"Berhasil dibatalkan...!!");
                            }
//                            TeksArea.append("respon WS BPJS : " + nameNode.path("code").asText() + " " + nameNode.path("message").asText() + "\n");
                        } catch (Exception ex) {
                            System.out.println("Notifikasi Bridging : " + ex);
                        }
                    }
                }
            }
//            TeksArea.append("respon WS BPJS : " + nameNode.path("code").asText() + " " + nameNode.path("message").asText() + "\n");
        } catch (Exception ex) {
            System.out.println("Notifikasi Bridging : " + ex);
        }
      
       WindowGantiDokterParamedis.dispose();
         emptTeks();
         tampil();
    }//GEN-LAST:event_BtnSimpan4ActionPerformed

    private void KeteranganBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_KeteranganBatalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_KeteranganBatalKeyPressed

    private void NoRawatKirimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoRawatKirimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoRawatKirimActionPerformed

    private void NoHpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoHpKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoHpKeyPressed

    private void NoHpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoHpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoHpActionPerformed

    private void NamaPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaPasienActionPerformed
        
    }//GEN-LAST:event_NamaPasienActionPerformed

    private void NamaPasienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NamaPasienKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaPasienKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            MobileJKNReferensiPendaftaran dialog = new MobileJKNReferensiPendaftaran(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }
    private void emptTeks() {
        NoRawatKirim.setText("");
        KeteranganBatal.setText("");
        NamaPasien.setText("");
        NoHp.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAll;
    private widget.Button BtnBatal;
    private widget.Button BtnBelum;
    private widget.Button BtnCari;
    private widget.Button BtnCheckin;
    private widget.Button BtnCloseIn4;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSimpan4;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.panelisi FormInput;
    private widget.TextBox KeteranganBatal;
    private widget.Label LCount;
    private javax.swing.JMenuItem MnKirimManualAntrol;
    private widget.TextBox NamaPasien;
    private widget.TextBox NoHp;
    private widget.TextBox NoRawatKirim;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private javax.swing.JDialog WindowGantiDokterParamedis;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame5;
    private widget.Label jLabel17;
    private widget.Label jLabel18;
    private widget.Label jLabel19;
    private widget.Label jLabel20;
    private widget.Label jLabel21;
    private widget.Label jLabel27;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private widget.panelisi panelGlass10;
    private widget.panelisi panelGlass8;
    private widget.Table tbJnsPerawatan;
    // End of variables declaration//GEN-END:variables

    private void tampil() {
        Valid.tabelKosong(tabMode);
        try{
            ps=koneksi.prepareStatement(
                   "SELECT referensi_mobilejkn_bpjs.no_rawat,referensi_mobilejkn_bpjs.norm,pasien.nm_pasien,referensi_mobilejkn_bpjs.nohp,referensi_mobilejkn_bpjs.nomorkartu,"+
                   "referensi_mobilejkn_bpjs.nik,referensi_mobilejkn_bpjs.tanggalperiksa,referensi_mobilejkn_bpjs.kodepoli,referensi_mobilejkn_bpjs.kodedokter,referensi_mobilejkn_bpjs.jampraktek,"+
                   "referensi_mobilejkn_bpjs.jeniskunjungan,referensi_mobilejkn_bpjs.nomorreferensi,referensi_mobilejkn_bpjs.status,referensi_mobilejkn_bpjs.validasi,"+
                   "referensi_mobilejkn_bpjs.nobooking FROM referensi_mobilejkn_bpjs INNER JOIN pasien ON referensi_mobilejkn_bpjs.norm=pasien.no_rkm_medis "+
                   "WHERE referensi_mobilejkn_bpjs.tanggalperiksa BETWEEN ? AND ? "+(TCari.getText().equals("")?"":
                   "and (referensi_mobilejkn_bpjs.no_rawat LIKE ? OR referensi_mobilejkn_bpjs.norm LIKE ? OR pasien.nm_pasien LIKE ? OR "+
                   "referensi_mobilejkn_bpjs.nohp LIKE ? OR referensi_mobilejkn_bpjs.nomorkartu LIKE ? OR referensi_mobilejkn_bpjs.nik LIKE ? OR "+
                   "referensi_mobilejkn_bpjs.jeniskunjungan LIKE ? OR referensi_mobilejkn_bpjs.nomorreferensi LIKE ? OR referensi_mobilejkn_bpjs.status LIKE ?) ")+
                   "order by referensi_mobilejkn_bpjs.tanggalperiksa");
            try {
                ps.setString(1,Valid.SetTgl(DTPCari1.getSelectedItem()+""));
                ps.setString(2,Valid.SetTgl(DTPCari2.getSelectedItem()+""));
                if(!TCari.getText().trim().equals("")){
                    ps.setString(3,"%"+TCari.getText()+"%");
                    ps.setString(4,"%"+TCari.getText()+"%");
                    ps.setString(5,"%"+TCari.getText()+"%");
                    ps.setString(6,"%"+TCari.getText()+"%");
                    ps.setString(7,"%"+TCari.getText()+"%");
                    ps.setString(8,"%"+TCari.getText()+"%");
                    ps.setString(9,"%"+TCari.getText()+"%");
                    ps.setString(10,"%"+TCari.getText()+"%");
                    ps.setString(11,"%"+TCari.getText()+"%");
                }
                    
                rs=ps.executeQuery();
                while(rs.next()){
                    tabMode.addRow(new Object[]{
                        rs.getString("no_rawat"),rs.getString("norm"),rs.getString("nm_pasien"),
                        rs.getString("nohp"),rs.getString("nomorkartu"),rs.getString("nik"),
                        rs.getString("tanggalperiksa"),Sequel.cariIsi("select maping_poli_bpjs.nm_poli_bpjs from maping_poli_bpjs where maping_poli_bpjs.kd_poli_bpjs=?",rs.getString("kodepoli")),
                        Sequel.cariIsi("select maping_dokter_dpjpvclaim.nm_dokter_bpjs from maping_dokter_dpjpvclaim where maping_dokter_dpjpvclaim.kd_dokter_bpjs=?",rs.getString("kodedokter")),
                        rs.getString("jampraktek"),rs.getString("jeniskunjungan"),rs.getString("nomorreferensi"),
                        rs.getString("status"),rs.getString("validasi"),rs.getString("nobooking")
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText(""+tabMode.getRowCount());
    }
}
