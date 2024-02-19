interface Invoice {
    id? : string
    invoiceDate?: string,
    invoiceNumber?: string,
    trxTableName?: string,
    price?: number,
    totalItem?: number,
    type? : string,
    invoiceItems? : InvoiceItem[]
    status? : string
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
    storeId : string,
    unit : string,

}

interface InputFileEvent extends Event {
    target : HTMLInputElement
}

interface RequestPayload {
    whereConditions? : string[]
    page? : number
    size? : number
}

export type { Invoice, NewInvoice, InvoiceItem, Product, NewProduct, InputFileEvent, RequestPayload }