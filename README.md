# Tugas 10 - Advanced RecyclerView

## Identitas
- **Nama**: Fatih Jawwad Al Mumtaz
- **NIM**: 452024611047

## Screenshot
<!-- TODO: Tambahkan screenshot aplikasi saat dijalankan -->

## Penjelasan

### Perbedaan efisiensi RecyclerView.Adapter standar dengan ListAdapter

**RecyclerView.Adapter** standar memanggil `notifyDataSetChanged()` setiap kali data berubah, yang menyebabkan RecyclerView me-render ulang *semua* item yang terlihat tanpa mengetahui item mana yang benar-benar berubah. Hal ini memboroskan sumber daya karena item yang tidak berubah pun ikut di-bind ulang.

**ListAdapter** menggunakan `DiffUtil.ItemCallback` untuk menghitung perbedaan antara list lama dan baru di background thread. Hasil komputasi ini menghasilkan notifikasi perubahan yang presisi:
- Hanya item yang benar-benar berubah yang di-rebind (`notifyItemChanged`)
- Item baru mendapat animasi masuk (`notifyItemInserted`)
- Item yang dihapus mendapat animasi keluar (`notifyItemRemoved`)

Dengan demikian, ListAdapter jauh lebih efisien karena jumlah operasi bind berkurang drastis, terutama pada dataset besar dengan sedikit perubahan.

## Tech Stack
- **Bahasa**: Kotlin
- **RecyclerView**: ListAdapter + DiffUtil
- **Layout Manager**: GridLayoutManager + SpanSizeLookup
- **View Type**: Multiple Item View Types (Header & Data)
- **Binding**: DataBinding + Custom BindingAdapter
- **UI**: Material Design 3
