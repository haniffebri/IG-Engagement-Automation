IG-Engagement-Automation

IG-Engagement-Automation adalah proyek automation berbasis Selenium dan JUnit untuk melakukan interaksi otomatis di Instagram. Fitur utama bot ini mencakup:
🔹 Like postingan target
🔹 Komen pada postingan target
🔹 Like & komen sekaligus pada postingan target
🔹 Mengirim Direct Message (DM) ke target

📌 Cara Kerja
👉 Menggunakan akun Instagram yang telah dikonfigurasi.
👉 Target untuk interaksi diambil dari file link.txt dan link2.txt dalam folder proyek.
👉 Selenium mengotomatisasi interaksi sesuai dengan mode yang dipilih.
👉 JUnit digunakan untuk menguji jalannya proses automation.

🚀 Library dan bahasa yang Digunakan
👉 Selenium: Automasi browser untuk mengontrol Instagram.
👉 JUnit: Pengujian kode untuk memastikan stabilitas dan keakuratan.
👉 Java: Bahasa pemrograman utama untuk proyek ini.

📂 Struktur Folder

📂 bot-instagram
 ├── 📂 .idea
 ├── 📂 .gradle
 ├── 📂 bot-instagram
 ├── 📂 build
 ├── 📂 gradle
 ├── 📂 src
 │   ├── 📂 main
 │   ├── 📂 test
 │   │   ├── 📂 java
 │   │   │   ├── 📂 features
 │   │   │   │   ├── 📜 Instagram.feature
 │   │   │   ├── 📂 helper
 │   │   │   │   ├── 📂 ig
 │   │   │   │   │   ├── 📜 link.txt
 │   │   │   │   │   ├── 📜 link2.txt
 │   │   │   │   ├── 📂 utility
 │   │   │   ├── 📂 pages
 │   │   │   │   ├── 📜 igLogic
 │   │   │   ├── 📂 runner
 │   │   │   │   ├── 📜 botrunner
 │   │   │   ├── 📂 step
 │   │   │   │   ├── 📜 Hooks
 │   │   │   │   ├── 📜 igDef
 │   │   ├── 📂 resources
 ├── 📜 .gitignore
 ├── 📜 build.gradle
 ├── 📜 gradlew
 ├── 📜 gradlew.bat
 ├── 📜 settings.gradle


📄 Penjelasan File & Folder Penting

🔹 Instagram.feature
File ini berisi skenario pengujian berbasis Cucumber untuk memastikan alur automation berjalan sesuai rencana. Skenario ini mendefinisikan langkah-langkah uji dalam format Gherkin.

🔹 utility
Folder ini berisi berbagai fungsi utilitas yang mendukung operasional bot, seperti pengaturan timeout, pembacaan file, atau metode reusable lainnya.

🔹 igLogic
File ini menangani logika utama dari interaksi bot dengan Instagram, seperti navigasi ke profil target, melakukan like, komentar, atau mengirim DM.

🔹 botrunner
File ini berfungsi sebagai test runner untuk menjalankan skenario pengujian yang didefinisikan di Instagram.feature menggunakan Cucumber dan JUnit.

🔹 Hooks
File ini berisi metode yang dieksekusi sebelum dan sesudah setiap skenario pengujian, seperti membuka dan menutup sesi browser.

🔹 igDef
File ini menghubungkan langkah-langkah yang didefinisikan dalam Instagram.feature dengan implementasi kode dalam Java, memastikan skenario pengujian dapat berjalan dengan baik.

🔧 Cara Menjalankan

Clone repository ini:

1️⃣ git clone https://github.com/username/InstaBot-Automation.git
2️⃣ Install dependencies Selenium dan JUnit (jika belum ada di proyek Java-mu).
3️⃣ Jalankan bot melalui IDE atau terminal:
4️⃣ java -jar InstaBot.jar
5️⃣ Pastikan link.txt telah diisi dengan target interaksi.

⚠️ Disclaimer

Gunakan bot ini dengan bijak dan jangan untuk spam.
Instagram memiliki algoritma anti-bot yang dapat mendeteksi aktivitas otomatis.
Penggunaan berlebihan dapat menyebabkan akun dibatasi atau diblokir.

📞 Kontak
Jika ada pertanyaan atau saran, silakan hubungi saya di haniffebri31@gmail.com atau buat issue di repository ini.
Happy Automating! 🚀

