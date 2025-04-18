public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * (DONE)
	 */ 
	
	private static final int BASE_PTKP = 54000000;
    private static final int MARRIAGE_PTKP = 4500000;
    private static final int CHILD_PTKP = 1500000;
    private static final int MAX_CHILDREN_COUNT = 3;
    private static final double TAX_RATE = 0.05;
	
	public static int calculateTax(
		int monthlySalary, 
		int otherMonthlyIncome, 
		int numberOfMonthWorking, 
		int deductible, 
		boolean isMarried, 
		int numberOfChildren
		) {

		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		
        numberOfChildren = Math.min(numberOfChildren, MAX_CHILDREN_COUNT);

        int annualIncome = (monthlySalary + otherMonthlyIncome) * numberOfMonthWorking;
        int ptkp = BASE_PTKP;

        if (isMarried) {
            ptkp += MARRIAGE_PTKP + (CHILD_PTKP * numberOfChildren);
        }

        int taxableIncome = annualIncome - deductible - ptkp;
        int tax = (int) Math.round(TAX_RATE * taxableIncome);

        return Math.max(tax, 0);
	}
	
}
