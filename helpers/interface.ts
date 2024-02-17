interface Invoice {
    id? : string
    invoiceDate: string,
    invoiceNumber?: string,
    trxTableName?: string,
    price: number,
    totalItem: number,
    type : string,
    invoiceItems? : InvoiceItem[]
}

interface InvoiceItem {
    id ?: string
    productId : string,
    quantity: number,
    price : number,
    productName? : string
}

interface NewInvoice {
    invoiceDate : string,
    invoiceItems? : InvoiceItem[]
}

interface Product { 
    id : string,
    name : string,
    initPrice : number,
    sellingPrice: number,
    unit : string,
    margin : number,
    quantity : number,
}

interface NewProduct {
    name : string,
    initPrice : number,
    sellingPrice: number,
    unit : string,
}

interface Stock {
    id : string,
    productId : string,
    quantity : number,
    price : number
}

interface NewStock {
    productId : string,
    quantity : number,
    price : number
}

interface InputFileEvent extends Event {
    target : HTMLInputElement
}



export type { Invoice, NewInvoice, InvoiceItem, Product, NewProduct, Stock, NewStock, InputFileEvent }