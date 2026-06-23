# Tugas 10 - Advanced RecyclerView

## Identitas
- **Nama**: Fatih Jawwad Al Mumtaz
- **NIM**: 452024611047
- **Kelas**: A2
- **Mata Kuliah**: Pemrograman Perangkat Bergerak
- **Universitas**: Universitas Darussalam Gontor

## Fitur Implementasi

### 1. ListAdapter + DiffUtil
Mengganti `RecyclerView.Adapter` standar menjadi **ListAdapter** dengan `DiffUtil.ItemCallback` untuk komputasi perubahan data di background thread. Ini memastikan hanya item yang benar-benar berubah yang di-rebind ulang, bukan seluruh list.

### 2. Multiple Item View Types
Adapter mendukung **2 jenis layout** yang berbeda:
- **Header** — tampilan full-width (span 2) dengan latar warna solid dan judul kategori
- **Data Item** — tampilan grid (span 1) dengan lingkaran warna dan label teks

### 3. GridLayoutManager + SpanSizeLookup
Menggunakan `GridLayoutManager` dengan span count = 2. `SpanSizeLookup` di-override sehingga item Header mengambil 2 span (full width) dan item Data mengambil 1 span.

### 4. Custom BindingAdapter
Membuat fungsi `@BindingAdapter("app:backgroundColor")` kustom untuk mengatur warna latar secara langsung dari XML melalui DataBinding.

### 5. ViewHolder Factory Pattern
 setiap ViewHolder memiliki **companion object** dengan method `create()` sebagai factory, memisahkan logika inflasi layout dari konstruktor.

## Screenshot

<!-- TODO: Tambahkan screenshot aplikasi saat dijalankan -->
![Screenshot Aplikasi](screenshot_app.png)

## Penjelasan

### Perbedaan efisiensi RecyclerView.Adapter standar dengan ListAdapter

**RecyclerView.Adapter** standar memanggil `notifyDataSetChanged()` setiap kali data berubah, yang menyebabkan RecyclerView me-render ulang *semua* item yang terlihat tanpa mengetahui item mana yang benar-benar berubah. Hal ini memboroskan sumber daya karena item yang tidak berubah pun ikut di-bind ulang.

**ListAdapter** menggunakan `DiffUtil.ItemCallback` untuk menghitung perbedaan antara list lama dan baru di background thread. Hasil komputasi ini menghasilkan notifikasi perubahan yang presisi:
- Hanya item yang benar-benar berubah yang di-rebind (`notifyItemChanged`)
- Item baru mendapat animasi masuk (`notifyItemInserted`)
- Item yang dihapus mendapat animasi keluar (`notifyItemRemoved`)
- Posisi item yang berubah dihitung secara otomatis tanpa perlu tracking manual

Dengan demikian, ListAdapter jauh lebih efisien karena jumlah operasi bind berkurang drastis, terutama pada dataset besar dengan sedikit perubahan. Saat tombol **Refresh** ditekan, DiffUtil hanya mengupdate item-item yang berbeda tanpa menyentuh item lama yang tidak berubah.

## Tech Stack
- **Bahasa**: Kotlin
- **RecyclerView**: ListAdapter + DiffUtil
- **Layout Manager**: GridLayoutManager + SpanSizeLookup
- **View Type**: Multiple Item View Types (Header & Data)
- **Binding**: DataBinding + Custom BindingAdapter
- **UI**: Material Design 3 (CardView, FAB, Toolbar)
