package academic.driver;

import java.util.Scanner;

import academic.model.Student;

/**
 * @author 12S24006 margareth bungaran
 * @author 12S24006 margareth bungaran
 */
public class Driver2 {
// Konstanta untuk ukuran maksimum array Student
    private static final int MAX_STUDENTS = 100; // Contoh: dapat menampung hingga 100 mahasiswa
    private static Student[] students = new Student[MAX_STUDENTS];
    private static int studentCount = 0; // Melacak jumlah student yang saat ini tersimpan


    public static void main(String[] _args) {

         Scanner inputScanner = new Scanner(System.in);
        String line;

        System.out.println("Masukkan data mahasiswa (format: nim#nama#angkatan#program_studi). Ketik '---' untuk berhenti.");

        // Loop untuk membaca input hingga "---" diterima
        while (inputScanner.hasNextLine()) {
            line = inputScanner.nextLine();

            // Cek perintah berhenti
            if (line.equals("---")) {
                break;
            }

            // Validasi input sederhana: tidak kosong
            if (line.trim().isEmpty()) {
                System.err.println("[WARNING] Baris input kosong diabaikan."); // Menggunakan System.err untuk peringatan
                continue; // Abaikan baris kosong
            }

            String[] dataSegments = line.split("#");

            // Pastikan jumlah segmen tepat 4
            if (dataSegments.length != 4) {
                System.err.println("[WARNING] Format input tidak valid untuk baris: '" + line + "'. Harap gunakan format nim#nama#angkatan#program_studi.");
                continue; // Lewati baris yang formatnya salah
            }

            String nim = dataSegments[0].trim();
            String name = dataSegments[1].trim();
            int year; // Variabel untuk menyimpan angkatan
            String studyProgram = dataSegments[3].trim();

            // Validasi angkatan agar dapat diparsing ke integer
            try {
                year = Integer.parseInt(dataSegments[2].trim());
            } catch (NumberFormatException e) {
                System.err.println("[WARNING] Angkatan harus berupa angka bulat untuk baris: '" + line + "'.");
                continue; // Lewati baris jika angkatan tidak valid
            }

            // Batasan kapasitas array statis
            if (studentCount >= MAX_STUDENTS) {
                System.err.println("[WARNING] Kapasitas penyimpanan mahasiswa penuh. Data baru tidak dapat ditambahkan: '" + line + "'.");
                // Kita bisa memilih untuk 'break' di sini atau hanya 'continue'
                // Sesuai dengan batasan array statis, kita bisa berhenti membaca jika penuh
                break;
            }

            // Buat objek Student dan simpan ke array
            Student newStudent = new Student(nim, name, year, studyProgram);
            students[studentCount] = newStudent;
            studentCount++;
        }

        inputScanner.close(); // Tutup scanner setelah selesai membaca input

        // Menampilkan semua Student yang tersimpan
        System.out.println("\n--- Data Mahasiswa Tersimpan ---");
        if (studentCount == 0) {
            System.out.println("Tidak ada data mahasiswa yang tersimpan.");
        } else {
            for (int i = 0; i < studentCount; i++) {
                System.out.println(students[i].toString()); // Menggunakan method toString() dari kelas Student
            }
        }
    }
}

    