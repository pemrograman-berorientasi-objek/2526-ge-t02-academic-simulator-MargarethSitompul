package academic.driver;

import java.util.Scanner;

import academic.model.Course;

/**
 * @author 12S24006 margareth bungaran 
 * 
 */


public class Driver1 {

    // Konstanta untuk ukuran maksimum array Course
    private static final int MAX_COURSES = 100; // Contoh: dapat menampung hingga 100 mata kuliah
    private static Course[] courses = new Course[MAX_COURSES];
    private static int courseCount = 0; // Melacak jumlah course yang saat ini tersimpan

    public static void main(String[] _args) {
Scanner inputScanner = new Scanner(System.in);
        String line;

        System.out.println("Masukkan data mata kuliah (format: kode#nama_mk#sks#grade). Ketik '---' untuk berhenti.");

        while (inputScanner.hasNextLine()) {
            line = inputScanner.nextLine();

            if (line.equals("---")) {
                break; // Keluar dari loop jika input adalah "---"
            }

            // Validasi input sederhana
            if (line.trim().isEmpty()) {
                System.out.println("[WARNING] Baris input kosong diabaikan.");
                continue; // Abaikan baris kosong
            }

            String[] data = line.split("#");

            // Pastikan jumlah segmen tepat 4
            if (data.length != 4) {
                System.out.println("[WARNING] Format input tidak valid untuk baris: '" + line + "'. Harap gunakan format kode#nama_mk#sks#grade.");
                continue; // Lewati baris yang formatnya salah
            }

            String code = data[0].trim();
            String name = data[1].trim();
            int sks;
            String grade = data[3].trim();

            // Validasi SKS agar dapat diparsing ke integer
            try {
                sks = Integer.parseInt(data[2].trim());
            } catch (NumberFormatException e) {
                System.out.println("[WARNING] SKS harus berupa angka bulat untuk baris: '" + line + "'.");
                continue; // Lewati baris jika SKS tidak valid
            }

            // Batasan kapasitas array
            if (courseCount >= MAX_COURSES) {
                System.out.println("[WARNING] Kapasitas penyimpanan mata kuliah penuh. Data baru tidak dapat ditambahkan: '" + line + "'.");
                break; // Hentikan pembacaan jika array penuh
            }

            // Buat objek Course dan simpan ke array
            Course newCourse = new Course(code, name, sks, grade);
            courses[courseCount] = newCourse;
            courseCount++;
        }

        inputScanner.close(); // Tutup scanner setelah selesai membaca input

        // Menampilkan semua Course yang tersimpan
        System.out.println("\n--- Data Mata Kuliah Tersimpan ---");
        if (courseCount == 0) {
            System.out.println("Tidak ada mata kuliah yang tersimpan.");
        } else {
            for (int i = 0; i < courseCount; i++) {
                System.out.println(courses[i]); // Menggunakan method toString() dari kelas Course
            }
        }
    }
}
        // codes

    