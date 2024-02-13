interface Invoice {
    invoiceDate: string,
    invoiceNumber?: string,
    price: number,
    totalItem: number,
    type : string
}

interface InvoiceItem {
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
    storeId : string,
    unit : string,

}

interface InputFileEvent extends Event {
    target : HTMLInputElement
}



export type { Invoice, NewInvoice, InvoiceItem, Product, NewProduct, InputFileEvent }