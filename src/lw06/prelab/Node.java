package lw06.prelab;

class Node {
    int data;   // Menyimpan nilai skor mahasiswa (bertipe integer)
    Node left;  // Referensi ke child kiri (nilai lebih kecil dari data node ini)
    Node right; // Referensi ke child kanan (nilai lebih besar dari data node ini)

    // Constructor untuk menginisialisasi node baru dengan nilai tertentu
    public Node(int data) {
        this.data = data;
        this.left = null;  // Saat baru dibuat, node belum memiliki child kiri
        this.right = null; // Saat baru dibuat, node belum memiliki child kanan
    }
}
