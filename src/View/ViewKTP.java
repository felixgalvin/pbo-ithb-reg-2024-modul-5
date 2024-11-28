package View;

import java.awt.*;
import javax.swing.*;
import Model.Data;

public class ViewKTP {
    JFrame frame;

    public ViewKTP(Data ktp) {
        viewKTP(ktp);
    }

    private void viewKTP(Data ktp) {
        frame = new JFrame("KTP OUTPUT FORM");
        frame.setLayout(new GridLayout(1, 2));
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        final int frameWidth = 700;
        final int frameHeight = 550;

        int frameX = (screenWidth / 2) - (frameWidth / 2);
        int frameY = (screenHeight / 2) - (frameHeight / 2);

        frame.setBounds(frameX, frameY, frameWidth, frameHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for Images
        JPanel gambarPanel = new JPanel();
        gambarPanel.setLayout(new FlowLayout());

        // Scaled Photo
        ImageIcon ktpImage = new ImageIcon(ktp.getFoto().getAbsolutePath());
        ImageIcon resizedKtpImage = new ImageIcon(ktpImage.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH));
        JLabel imageLabel = new JLabel("Photo", resizedKtpImage, JLabel.CENTER);

        // Scaled Signature
        ImageIcon tandImageIcon = new ImageIcon(ktp.getTandaTangan().getAbsolutePath());
        ImageIcon resizedTandImage = new ImageIcon(tandImageIcon.getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH));
        JLabel imageLabel2 = new JLabel("Signature", resizedTandImage, JLabel.CENTER);

        gambarPanel.add(imageLabel);
        gambarPanel.add(imageLabel2);

        // Panel for Text Information
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(null);

        StringBuilder hasil = new StringBuilder();
        hasil.append("<html>");
        hasil.append("<h1>Provinsi DKI JAKARTA</h1>");
        hasil.append("<h1>JAKARTA UTARA</h1>");
        hasil.append("NIK : " + ktp.getNik() + "<br>");
        hasil.append("Nama : " + ktp.getNama() + "<br>");
        hasil.append("Tempat Lahir : " + ktp.getTempatLahir() + "<br>");
        hasil.append("Tanggal Lahir : " + ktp.getTanggalLahir() + "<br>");
        hasil.append("Jenis Kelamin : " + ktp.getJenisKelamin() + "<br>");
        hasil.append("Golongan Darah : " + ktp.getGolDarah() + "<br>");
        hasil.append("Alamat : " + ktp.getAlamat() + "<br>");
        hasil.append("Rt/RW : " + ktp.getRtRW() + "<br>");
        hasil.append("Kel/Desa : " + ktp.getKelDesa() + "<br>");
        hasil.append("Kecamatan : " + ktp.getRtRW() + "<br>");
        hasil.append("Agama : " + ktp.getAgama() + "<br>");
        hasil.append("Status Perkawinan : " + ktp.getStatusPerkawinan() + "<br>");
        hasil.append("Pekerjaan : " + ktp.getPekerjaan() + "<br>");
        hasil.append("Kewarganegaraan : " + ktp.getKewarganegaraan() + "<br>");
        hasil.append("Berlaku Hingga : " + ktp.getBerlakuHingga() + "<br>");
        hasil.append("Kota Pembuatan : " + ktp.getKotaPembuatanKTP() + "<br>");
        hasil.append("Tanggal Pembuatan : " + ktp.getTanggalPembuatanKTP() + "<br>");
        hasil.append("</html>");

        JLabel result = new JLabel(hasil.toString());
        result.setBounds(20, 20, 660, 200); 

        inputPanel.add(result);

        // Adding Panels to Frame
        frame.add(inputPanel, BorderLayout.CENTER);
        frame.add(gambarPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}