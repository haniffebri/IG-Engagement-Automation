# IG-Engagement-Automation

**IG-Engagement-Automation** adalah proyek automasi berbasis **Java**, **Selenium**, **JUnit**, dan **Cucumber** untuk menjalankan interaksi otomatis di Instagram. Proyek ini dirancang untuk membantu pengujian dan simulasi aktivitas interaksi akun, seperti menyukai postingan, memberikan komentar, serta mengirim direct message (DM) secara terstruktur.

## Fitur Utama

Proyek ini mendukung beberapa mode interaksi otomatis, yaitu:

- Like postingan target
- Comment pada postingan target
- Like dan comment sekaligus pada postingan target
- Mengirim direct message (DM) ke target

## Cara Kerja

Alur kerja bot secara umum adalah sebagai berikut:

1. Bot menggunakan akun Instagram yang telah dikonfigurasi sebelumnya.
2. Target interaksi dibaca dari file `link.txt` dan `link2.txt` yang tersedia di dalam folder proyek.
3. Selenium akan menjalankan automasi browser sesuai mode interaksi yang dipilih.
4. JUnit dan Cucumber digunakan untuk menjalankan serta menguji skenario automation.

## Teknologi yang Digunakan

Proyek ini dibangun menggunakan teknologi berikut:

- **Java** — bahasa pemrograman utama
- **Selenium** — untuk automasi browser dan interaksi dengan Instagram
- **JUnit** — untuk pengujian proses automation
- **Cucumber** — untuk pengujian berbasis skenario

## Struktur File Penting

Berikut beberapa file dan folder utama dalam proyek ini:

### `Instagram.feature`
Berisi skenario pengujian berbasis Cucumber dalam format Gherkin. File ini mendefinisikan alur automation yang akan dijalankan.

### `utility`
Folder ini berisi fungsi-fungsi utilitas pendukung, seperti pengaturan timeout, pembacaan file, dan helper method lain yang dapat digunakan kembali.

### `igLogic`
Berisi logika utama automation, seperti navigasi ke target, melakukan like, comment, maupun pengiriman DM.

### `botrunner`
Berfungsi sebagai test runner untuk menjalankan skenario yang telah didefinisikan pada `Instagram.feature` menggunakan Cucumber dan JUnit.

### `Hooks`
Berisi method yang dijalankan sebelum dan sesudah setiap skenario, misalnya untuk membuka dan menutup browser.

### `igDef`
Menghubungkan langkah-langkah pada file `Instagram.feature` dengan implementasi kode Java agar skenario dapat dieksekusi.

## Cara Menjalankan

### 1. Clone repository
```bash
git clone https://github.com/haniffebri/IG-Engagement-Automation.git
```

### 2. Buka project di IDE
Gunakan IDE Java seperti **IntelliJ IDEA**, **Eclipse**, atau **NetBeans**.

### 3. Install dependencies
Pastikan dependency berikut sudah tersedia pada project:

- Selenium
- JUnit
- Cucumber

Jika menggunakan Maven atau Gradle, tambahkan dependency yang sesuai pada file konfigurasi project.

### 4. Siapkan file target
Isi file `link.txt` dan/atau `link2.txt` dengan link target interaksi yang akan digunakan oleh bot.

### 5. Jalankan bot
Bot dapat dijalankan melalui IDE atau menggunakan runner yang telah disediakan pada project.  
Jika project sudah dikemas dalam file `.jar`, jalankan dengan perintah berikut:

```bash
java -jar InstaBot.jar
```

## Catatan Penggunaan

Sebelum menjalankan bot, pastikan bahwa:

- akun Instagram telah dikonfigurasi dengan benar,
- target link telah disiapkan,
- koneksi internet stabil,
- browser dan WebDriver sesuai dengan versi yang digunakan.

## Disclaimer

Proyek ini dibuat untuk tujuan pembelajaran, eksperimen, dan pengujian automation.

Harap gunakan dengan bijak. Instagram memiliki sistem deteksi terhadap aktivitas otomatis, sehingga penggunaan berlebihan dapat menyebabkan pembatasan akun, checkpoint, atau pemblokiran sementara. Pengguna bertanggung jawab penuh atas penggunaan proyek ini.

## Kontak

Apabila terdapat pertanyaan, masukan, atau saran, silakan hubungi:

- **Email:** [haniffebri31@gmail.com](mailto:haniffebri31@gmail.com)
- **GitHub Issues:** [Buat issue di repository ini](https://github.com/haniffebri/IG-Engagement-Automation/issues)

---

Happy Automating.
