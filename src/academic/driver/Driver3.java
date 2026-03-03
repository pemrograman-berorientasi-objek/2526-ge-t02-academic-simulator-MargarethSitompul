package academic.driver;

import java.util.Scanner;

import academic.model.Enrollment;

/**
 * @author 12S24006 margareth bungaran
 * 
 */
public class Driver3 {

    // Konstanta untuk ukuran maksimum array Enrollment
    private static final int MAX_ENROLLMENTS = 100; // Contoh: dapat menampung hingga 100 pendaftaran
    private static Enrollment[] enrollments = new Enrollment[MAX_ENROLLMENTS];
    private static int enrollmentCount = 0; // Melacak jumlah enrollment yang saat ini tersimpan

    public static void main(String[] _args) {

         Scanner inputScanner = new Scanner(System.in);
        String line;

        System.out.println("Masukkan data pendaftaran (format: kode_mk#nim#tahun_akademik#semester). Ketik '---' untuk berhenti.");

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
                System.err.println("[WARNING] Format input tidak valid untuk baris: '" + line + "'. Harap gunakan format kode_mk#nim#tahun_akademik#semester.");
                continue; // Lewati baris yang formatnya salah
            }

            // Ekstrak data dan trim spasi
            String courseCode = dataSegments[0].trim();
            String studentNim = dataSegments[1].trim();
            String academicYear = dataSegments[2].trim();
            String semester = dataSegments[3].trim();
            
            // Batasan kapasitas array statis
            if (enrollmentCount >= MAX_ENROLLMENTS) {
                System.err.println("[WARNING] Kapasitas penyimpanan pendaftaran penuh. Data baru tidak dapat ditambahkan: '" + line + "'.");
                // Pilihan: break atau continue. Sesuai batasan array statis, kita bisa berhenti membaca jika penuh.
                break; 
            }

            // Buat objek Enrollment dan simpan ke array
            Enrollment newEnrollment = new Enrollment(courseCode, studentNim, academicYear, semester);
            enrollments[enrollmentCount] = newEnrollment;
            enrollmentCount++;
        }

        inputScanner.close(); // Tutup scanner setelah selesai membaca input

        // Menampilkan semua Enrollment yang tersimpan
        System.out.println("\n--- Data Pendaftaran Mata Kuliah Tersimpan ---");
        if (enrollmentCount == 0) {
            System.out.println("Tidak ada data pendaftaran mata kuliah yang tersimpan.");
        } else {
            for (int i = 0; i < enrollmentCount; i++) {
                System.out.println(enrollments[i].toString()); // Menggunakan method toString() dari kelas Enrollment
            }
        }
    }
}

    