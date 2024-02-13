function formatCurrency(amount: number): string {
    if (!amount) {
        return `Rp. 0`
    }
    const [integerPart, decimalPart] = amount.toFixed(2).split(".");
    const formattedIntegerPart = integerPart.replace(/\B(?=(\d{3})+(?!\d))/g, ",");

    return `Rp ${formattedIntegerPart}${decimalPart ? "." + decimalPart : ""}`;
}

export { 
    formatCurrency
}