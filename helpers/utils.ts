function formatCurrency(amount: number): string {
    // Convert the number to a string and split it into integer and decimal parts
    const [integerPart, decimalPart] = amount.toFixed(2).split(".");
    
    // Add thousands separator to the integer part
    const formattedIntegerPart = integerPart.replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    
    // Combine integer and decimal parts with currency symbol
    return `Rp ${formattedIntegerPart}${decimalPart ? "." + decimalPart : ""}`;
}

export { 
    formatCurrency
}